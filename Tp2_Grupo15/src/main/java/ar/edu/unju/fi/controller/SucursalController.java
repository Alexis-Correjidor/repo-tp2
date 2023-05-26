package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.listaSucursal;
import ar.edu.unju.fi.model.sucursal;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {
 
	listaSucursal listaSucursales = new listaSucursal();
	@GetMapping("/listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "sucursales";
	}
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		model.addAttribute("sucursal", new sucursal());
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")sucursal sucursal) {
		ModelAndView modelView = new ModelAndView("sucursales");
		listaSucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales", listaSucursales.getSucursales());
		return modelView;
	}
	@GetMapping("/modificar/{nombre}") 
	public String getModificarSucursalPage(Model model, @PathVariable(value="nombre")String nombre){
		sucursal sucursalEncontrada = new sucursal();
		boolean edicion = true;
		for(sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(nombre)) {
				sucursalEncontrada = sucu;
				break;
			}
		}
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("sucursal")sucursal sucursal) {
		for(sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(sucursal.getNombre())) {
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setEmail(sucursal.getEmail());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setTelefono(sucursal.getTelefono());
				sucu.setFechaInicio(sucursal.getFechaInicio());
			}	
		}
		return "redirect:/sucursal/listado";
	}
	
	@GetMapping("/eliminar/{nombre}")
	public String eliminarSucursal(@PathVariable(value="nombre") String nombre) {
		for(sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(nombre)) {
				listaSucursales.getSucursales().remove(sucu);
				break;
			}
		}
		return "redirect:/sucursal/listado";
	}
}
