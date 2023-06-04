package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PaginaController {

	@GetMapping("/inicio")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/sucursales")
	public String getSucursalesPage() {
		return "sucursales";
	}
	
	
	@GetMapping("/contactos")
	public String getContactosPage() {
		return "contactanos";
	}
	

	
	@GetMapping("/consejos-salud")
	public String getConsejosSaludPage() {
		return "consejoSalud";
	}
	
	@GetMapping("/servicios-paseo")
	public String getServicioPaseoPage() {
		return "serviciosPaseo";
	}
	
}
