package ar.edu.unju.fi.controller;
import ar.edu.unju.fi.listas.ListaConsejos;
import ar.edu.unju.fi.model.consejosSalud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("/listado")
	public String getListaConsejosPage(Model model) {
		model.addAttribute("consejos", listaConsejos.getConsejos());
		return "consejoSalud";
}
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		model.addAttribute("consejosSalud", new consejosSalud());
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo_salud";
	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevoConsejoPage(@ModelAttribute("consejosSalud")consejosSalud consejosSalud) {
		ModelAndView modelView = new ModelAndView("consejoSalud");
		listaConsejos.getConsejos().add(consejosSalud);
		modelView.addObject("consejos", listaConsejos.getConsejos());
		return modelView;
}
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