package ar.edu.unju.fi.controller;

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


import ar.edu.unju.fi.model.sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller

/*----Captura de peticiones para la pagina de sucursales----*/
@RequestMapping("/sucursal")
public class SucursalController {
	
	/*----Inyeccion de dependencia de ListaSucursal-----*/
	@Autowired
	private ISucursalService sucursalService;
	
	/*----Creacion de solicitudes HTTP GET y POST----*/
	
	/*----RECIBE LA PETECION ENVIADA POR URL PARA MOSTRAR LA PAGINA sucursales CON LOS OBJETOS DE LA LISTA----*/
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", sucursalService.getLista());
		return "sucursales";
	}
	/*----CAPTURA LA PETECION ENVIADA POR URL, MUESTRA LA PAGINA nueva_sucursal CON UN OBJETO PARA ASIGNARLE VALORES A LOS ATRIBUTOS.----*/
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		model.addAttribute("sucursal", sucursalService.getSucursal());
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	/*----EVALUA SI EL OBJETO RESULT TIENE ERRORES, VOLVERA A MOSTRAR LA PAGINA nueva_sucursal
	 * PARA ENVIAR VALORES VALIDOS PARA LOS ATRIBUTOS. SINO A LA LISTA SE AÑADIRA UN NUEVO
	 * OBJETO CON LOS VALORES CORRECTOS Y MOSTRARA LA PAGINA sucursales.----*/
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")sucursal sucursal, BindingResult result) {
		ModelAndView modelView = new ModelAndView("sucursales");
		if(result.hasErrors()) {
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("sucursal", sucursal);
			return modelView;  
		}
		sucursalService.guardar(sucursal); 
		modelView.addObject("sucursales", sucursalService.getLista());
		return modelView;
	} 
	/*----CAPTURA LA VARIABLE ENVIADA POR URL Y MUESTRA LA PAGINA nueva_sucursal CON EL OBJETO DE LA LISTA
	 *CON EL CUAL ENCONTRO LA COINCIDENCIA EN EL ATRIBUTO NOMBRE----*/
	@GetMapping("/modificar/{nombre}") 
	public String getModificarSucursalPage(Model model, @PathVariable(value="nombre")String nombre){
		sucursal sucursalEncontrada = sucursalService.getBy(nombre);
		boolean edicion = true;
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	/*----ASIGNA LOS NUEVOS VALORES A LOS ATRIBUTOS DEL OBJETO. EL NOMBRE DEBE SER EL MISMO----*/
	@PostMapping("/modificar")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal")sucursal sucursal, BindingResult result) {
		if(result.hasErrors()) {
			
			return "nueva_sucursal";
		}
		 
		sucursalService.modificar(sucursal);
		return "redirect:/sucursal/listado";
	}
	/*----CAPTURA LA VARIABLE ENVIADA POR URL Y MUESTRA LA PAGINA sucursal/listado CON EL OBJETO DE LA LISTA
	 * 	CON EL CUAL ENCONTRO LA COINCIDENCIA EN EL ATRIBUTO NOMBRE PARA PODER ELIMINAR EL OBJETO DE LA LISTA----*/
	@GetMapping("/eliminar/{nombre}")
	public String eliminarSucursal(@PathVariable(value="nombre") String nombre) {
		sucursal sucursalEncontrada = sucursalService.getBy(nombre);
		sucursalService.eliminar(sucursalEncontrada);
		return "redirect:/sucursal/listado";
	}
}
