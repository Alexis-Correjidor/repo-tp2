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

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller


@RequestMapping("/sucursal")
public class SucursalController {
	
	
	@Autowired
	@Qualifier("sucursalServiceMysql")
	private ISucursalService sucursalService;
	
	
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", sucursalService.getLista());
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		model.addAttribute("sucursal", sucursalService.getSucursal());
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
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
	
	@GetMapping("/modificar/{id}") 
	public String getModificarSucursalPage(Model model, @PathVariable(value="id") Long id){
		boolean edicion = true;
		model.addAttribute("sucursal", sucursalService.getBy(id));
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/modificar")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
		if(result.hasErrors()) {
			
			return "nueva_sucursal";
		}
		 
		sucursalService.modificar(sucursal);
		return "redirect:/sucursal/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value="id") Long id) {
		Sucursal sucursalEncontrada = sucursalService.getBy(id);
		sucursalService.eliminar(sucursalEncontrada);
		return "redirect:/sucursal/listado";
	}
}
