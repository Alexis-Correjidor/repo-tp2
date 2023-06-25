package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Paseador;
import ar.edu.unju.fi.service.IPaseoService;
import jakarta.validation.Valid;

@Controller

/*----Captura de peticiones para la pagina de serviciosPaseo----*/

@RequestMapping("/servicios")	
public class ServiciosController {
	
	/*----Inyección de dependencia de ListaPaseadores-----*/
	@Autowired
	@Qualifier("paseoServiceMysql")
	private IPaseoService paseoService ;
	
	
	/*----Creacion de solicitudes HTTP GET y POST----*/
	
	/*----RECIBE LA PETECION ENVIADA POR URL PARA MOSTRAR LA PAGINA serviciosPaseo CON LOS OBJETOS DE LA LISTA----*/
	@GetMapping("/listado")
	public String getListaPaseadoresPage(Model model) {
		model.addAttribute("paseadores",paseoService.getLista());
		return "serviciosPaseo";
	}
	
	/*----CAPTURA LA PETECION ENVIADA POR URL, MUESTRA LA PAGINA nuevoPaseador CON UN OBJETO PARA ASIGNARLE VALORES A LOS ATRIBUTOS.----*/
	@GetMapping("/nuevo")
	public String getNuevoPaseadorPage(Model model) {
		model.addAttribute("paseador", paseoService.getPaseador());
		boolean edicion=false;
		model.addAttribute("edicion", edicion);
		return "nuevoPaseador";
	}
	
	/*----EVALUA SI EL OBJETO RESULT TIENE ERRORES, VOLVERA A MOSTRAR LA PAGINA nuevoPaseador
	 * PARA ENVIAR VALORES VALIDOS PARA LOS ATRIBUTOS. SINO A LA LISTA SE AÑADIRA UN NUEVO
	 * OBJETO CON LOS VALORES CORRECTOS Y MOSTRARA LA PAGINA serviciosPaseo.----*/
	@PostMapping("/guardar")
	public ModelAndView getGuardarPaseadorPage(@Valid @ModelAttribute("paseador") Paseador paseador,BindingResult result) {
		ModelAndView modelView = new ModelAndView ("serviciosPaseo");
		if(result.hasErrors()) {
			modelView.setViewName("nuevoPaseador");
			modelView.addObject("paseador", paseador);
			return modelView;  
		}
		paseoService.guardar(paseador);
		modelView.addObject("paseadores",paseoService.getLista());
		return modelView;
		
	}
	
	/*----CAPTURA LA VARIABLE ENVIADA POR URL Y MUESTRA LA PAGINA nuevoPaseador CON EL OBJETO DE LA LISTA
	 *CON EL CUAL ENCONTRO LA COINCIDENCIA EN EL ATRIBUTO NOMBRE----*/
	@GetMapping("/modificar/{id}")
	public String getModificarPaseadorPage(Model model, @PathVariable(value="id")Long id) {
		
		boolean edicion = true;
		
		model.addAttribute("paseador", paseoService.getBy(id));
		model.addAttribute("edicion", edicion);
		return "nuevoPaseador";
	}
	
	/*----ASIGNA LOS NUEVOS VALORES A LOS ATRIBUTOS DEL OBJETO. EL NOMBRE DEBE SER EL MISMO----*/
	@PostMapping("/modificar")
	public String modificarPaseador(@Valid @ModelAttribute("paseador")Paseador paseador, BindingResult result) {
		if(result.hasErrors()) {
			
			return "nuevoPaseador";
		}
		paseoService.modificar(paseador);
		return "redirect:/servicios/listado";
	}
	
	/*----CAPTURA LA VARIABLE ENVIADA POR URL Y MUESTRA LA PAGINA /servicios/listado CON EL OBJETO DE LA LISTA
	 * 	CON EL CUAL ENCONTRO LA COINCIDENCIA EN EL ATRIBUTO NOMBRE PARA PODER ELIMINAR EL OBJETO DE LA LISTA----*/
	@GetMapping("/eliminar/{id}")
	public String eliminarPaseador(@PathVariable(value="id") Long id) {
		Paseador paseadorEncontrado = paseoService.getBy(id);
		paseoService.eliminar(paseadorEncontrado);
		return "redirect:/servicios/listado";
	}
	
	
	
}
