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

@Controller						 //SE INDICA QUE LA CLASE ES UN CONTROLADOR Y CAPTURA DE PETICIONES HTTP
@RequestMapping("/servicios")	  //MAPEO DE SOLICITUDES WEB A METODOS 
public class ServicioController {
	
	@Autowired  	//INYECCION DE DEPENDENCIA LISTA DE PASEADORES Y METODOS EN CAPA DE SERVICIOS ABSTRACTA
	@Qualifier("paseoServiceMysql")	  //NOMBRE DE A CUAL IMPLEMENTACION DE SERVICIO DEBE ACCEDER
	private IPaseoService paseoService ; 
	
	
	@GetMapping("/listado")	  //NOTACION COMPUESTA, ACCESO DIRECTO PARA @RequestMapping(method = RequestMethod.GET)
	public String getListaPaseadoresPage(Model model) {		//METODO MOSTRAR PAGINA serviciosPaseo CON LOS OBJETOS DE LA LISTA
		model.addAttribute("paseadores",paseoService.getLista());
		return "serviciosPaseo";
	}
	
	
	@GetMapping("/nuevo")
	public String getNuevoPaseadorPage(Model model) {		//METODO MOSTRAR PAGINA nuevoPaseador CON UN OBJETO PARA ASIGNARLE VALORES A LOS ATRIBUTOS
		model.addAttribute("paseador", paseoService.getPaseador());
		boolean edicion=false;				 //BOOLEAN EN FALSE SE ENVIARA PETICION /servicios/guardar
		model.addAttribute("edicion", edicion);
		return "nuevoPaseador";
	}
	
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarPaseadorPage(@Valid @ModelAttribute("paseador") Paseador paseador,BindingResult result) {		//@Valid ENVIAR VALORES CORRECTOS PARA LOS ATRIBUTOS
		ModelAndView modelView = new ModelAndView ("serviciosPaseo");
		if(result.hasErrors()) {					  //EVALUA SI EL OBJETO RESULT TIENE ERROREE
			modelView.setViewName("nuevoPaseador");		 //SE VOLVERA A MOSTRAR PAGINA nuevoPaseador
			modelView.addObject("paseador", paseador);
			return modelView;  
		}
		paseoService.guardar(paseador);					//OBJETO CON VALORES CORRECTOS SE GUARDARA Y SE MOSTRARA LA PAGINA serviciosPaseo
		modelView.addObject("paseadores",paseoService.getLista());
		return modelView;
		
	}
	
	
	@GetMapping("/modificar/{id}") 			//PETICION /modificar + VARIALE id 
	public String getModificarPaseadorPage(Model model, @PathVariable(value="id")Long id) {  	//@PathVariable REFERENCIA A VARIABLE DENTRO DEL PROPIO SEGMENTO DE LA URL
		
		boolean edicion = true; 	//BOOLEAN EN FALSE SE ENVIARA PETICION /servicios/modificar
		
		model.addAttribute("paseador", paseoService.getBy(id)); 	//BUSCAR COINCIDENCIA DE OBJETO CON id ENTREGADO Y ENTREGAR OBJETO DEL MODEL
		model.addAttribute("edicion", edicion);						//ENTREGA DE VARIABLE edicion AL MODEL
		return "nuevoPaseador";
	}
	
	
	@PostMapping("/modificar")		//NOTACION COMPUESTA, ACCESO DIRECTO PARA @RequestMapping(method = RequestMethod.POST)
	public String modificarPaseador(@Valid @ModelAttribute("paseador")Paseador paseador, BindingResult result) {
		if(result.hasErrors()) {
			
			return "nuevoPaseador";				//SE MOSTRARA PAGINA nuevoPaseador, EN CASO DE ENCONTRAR ERROR EN OBJETO RESULT
		}
		paseoService.modificar(paseador);		//SE ASIGNA LOS NUEVOS VALORES A LOS ATRIBUTOS DEL OBJETO
		return "redirect:/servicios/listado";
	}
	
	
	@GetMapping("/eliminar/{id}")  										//PETICION /eliminar + VARIALE id 
	public String eliminarPaseador(@PathVariable(value="id") Long id) {
		Paseador paseadorEncontrado = paseoService.getBy(id); 		   //BUSCAR COINCIDENCIA DE OBJETO CON EL id y ENTREGARLO A OBJETO paseadorEncontrado
		paseoService.eliminar(paseadorEncontrado);						//SE ENTREGA paseadorEncontrado PARA SER ELIMINADO
		return "redirect:/servicios/listado";
	}
	
	
	
}
