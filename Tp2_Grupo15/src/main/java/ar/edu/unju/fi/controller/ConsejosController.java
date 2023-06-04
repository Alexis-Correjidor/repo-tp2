package ar.edu.unju.fi.controller;
import ar.edu.unju.fi.listas.ListaConsejos;
import ar.edu.unju.fi.model.consejosSalud;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller

/*----Captura de peticiones para la pagina de consejoSalud----*/
@RequestMapping("/consejos")	

public class ConsejosController {
	
	/*----Inyeccion de dependencia de ListaConsejos----*/
	@Autowired
	ListaConsejos listaConsejos;
	/*----Inyeccion de dependencia de consejoSSalud----*/
	@Autowired
	private consejosSalud consejosSalud;
	
	/*----Creacion de solicitudes HTTP GET y POST----*/
	
	/*----RECIBE LA PETECION ENVIADA POR URL PARA MOSTRAR LA PAGINA consejoSalud CON LOS OBJETOS DE LA LISTA----*/
	@GetMapping("/listado")
	public String getListaConsejosPage(Model model) {
		model.addAttribute("consejos", listaConsejos.getConsejos());
		return "consejoSalud";
}
	/*----CAPTURA LA PETECION ENVIADA POR URL, MUESTRA LA PAGINA nuevo_consejo_salud CON UN OBJETO PARA ASIGNARLE VALORES A LOS ATRIBUTOS.----*/
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		model.addAttribute("consejosSalud", consejosSalud);
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo_salud";
	}
	/*----EVALUA SI EL OBJETO RESULT TIENE ERRORES, VOLVERA A MOSTRAR LA PAGINA nuevo_consejo_salud
	 * PARA ENVIAR VALORES VALIDOS PARA LOS ATRIBUTOS. SINO A LA LISTA SE AÑADIRA UN NUEVO
	 * OBJETO CON LOS VALORES CORRECTOS Y MOSTRARA LA PAGINA consejoSalud.----*/
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevoConsejoPage(@Valid @ModelAttribute("consejosSalud")consejosSalud consejosSalud, BindingResult result) {
		ModelAndView modelView = new ModelAndView("consejoSalud");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_consejo_salud");
			modelView.addObject("consejosSalud", consejosSalud);
			return modelView;  
		}
		listaConsejos.getConsejos().add(consejosSalud);
		modelView.addObject("consejos", listaConsejos.getConsejos());
		return modelView;
}
	/*----CAPTURA LA VARIABLE ENVIADA POR URL Y MUESTRA LA PAGINA nuevo_consejo_salud CON EL OBJETO DE LA LISTA
	 *CON EL CUAL ENCONTRO LA COINCIDENCIA EN EL ATRIBUTO TITULO----*/
	@GetMapping("/modificar/{titulo}") 
	public String getModificarConsejoPage(Model model, @PathVariable(value="titulo")String titulo){
		consejosSalud consejoEncontrado = new consejosSalud();
		boolean edicion = true;
		for(consejosSalud conse : listaConsejos.getConsejos()) {
			if (conse.getTitulo().equals(titulo)) {
				consejoEncontrado = conse;
				break;
			}
		}
		model.addAttribute("consejosSalud", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo_salud";
}
	/*----ASIGNA LOS NUEVOS VALORES A LOS ATRIBUTOS DEL OBJETO. EL TITULO DEBE SER EL MISMO----*/
	@PostMapping("/modificar")
	public String modificarConsejos(@ModelAttribute("consejosSalud")consejosSalud consejosSalud) {
		for(consejosSalud conse : listaConsejos.getConsejos()) {
			if (conse.getTitulo().equals(consejosSalud.getTitulo())) {
				conse.setNombreIMG(consejosSalud.getNombreIMG());
				conse.setDescripcion(consejosSalud.getDescripcion());
			}	
		}
		return "redirect:/consejos/listado";
}
	/*----CAPTURA LA VARIABLE ENVIADA POR URL Y MUESTRA LA PAGINA consejos/listado CON EL OBJETO DE LA LISTA
	 * 	CON EL CUAL ENCONTRO LA COINCIDENCIA EN EL ATRIBUTO TITULO PARA PODER ELIMINAR EL OBJETO DE LA LISTA----*/
	@GetMapping("/eliminar/{titulo}")
	public String eliminarConsejos(@PathVariable(value="titulo") String titulo) {
		for(consejosSalud conse : listaConsejos.getConsejos()) {
			if (conse.getTitulo().equals(titulo)) {
				listaConsejos.getConsejos().remove(conse);
				break;
			}
		}
		return "redirect:/consejos/listado";
	}
	
}