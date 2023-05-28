package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaPaseador;
import ar.edu.unju.fi.model.Paseador;



@Controller
@RequestMapping("/servicios")
public class ServiciosController {

	ListaPaseador listaPaseadores = new ListaPaseador();
	
	@GetMapping("/listado")
	public String getListaPaseadoresPage(Model model) {
		model.addAttribute("paseadores",listaPaseadores.getPaseadores());
		return "serviciosPaseo";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoPaseadorPage(Model model) {
		model.addAttribute("paseador", new Paseador());
		boolean edicion=false;
		model.addAttribute("edicion", edicion);
		return "nuevoPaseador";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarPaseadorPage(@ModelAttribute("paseador") Paseador paseador) {
		ModelAndView modelView = new ModelAndView ("serviciosPaseo");
		listaPaseadores.getPaseadores().add(paseador);
		modelView.addObject("paseadores",listaPaseadores.getPaseadores());
		return modelView;
	}
	
	@GetMapping("/modificar/{nombre}")
	public String getModificarPaseadorPage(Model model, @PathVariable(value="nombre")String nombre) {
		Paseador paseadorEncontrado = new Paseador();
		boolean edicion = true;
		for (Paseador pas : listaPaseadores.getPaseadores()) {
			if (pas.getNombre().equals(nombre)) {
				paseadorEncontrado = pas;
				break;
			}
		}
		model.addAttribute("paseador", paseadorEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevoPaseador";
	}
	
	
	@PostMapping("/modificar")
	public String modificarPaseador(@ModelAttribute("paseador")Paseador paseador) {
		for(Paseador pas : listaPaseadores.getPaseadores()) {
			if (pas.getNombre().equals(paseador.getNombre())) {
				pas.setApellido(paseador.getApellido());
				pas.setDias(paseador.getDias());
				pas.setHoraMInicio(paseador.getHoraMInicio());
				pas.setHoraMFin(paseador.getHoraMFin());
				pas.setHoraTInicio(paseador.getHoraTInicio());
				pas.setHoraTFin(paseador.getHoraTFin());
			}	
		}
		return "redirect:/servicios/listado";
	}
	
	
	@GetMapping("/eliminar/{nombre}")
	public String eliminarPaseador(@PathVariable(value="nombre") String nombre) {
		for(Paseador pas : listaPaseadores.getPaseadores()) {
			if (pas.getNombre().equals(nombre)) {
				listaPaseadores.getPaseadores().remove(pas);
				break;
			}
		}
		return "redirect:/servicios/listado";
	}
	
	
	
}
