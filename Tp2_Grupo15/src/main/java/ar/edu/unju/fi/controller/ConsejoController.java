package ar.edu.unju.fi.controller;
import ar.edu.unju.fi.entity.consejosSalud;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

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


@Controller


@RequestMapping("/consejos")	

public class ConsejoController {
	
	
	@Autowired
	@Qualifier("consejoServiceMysql")
	private IConsejoService consejoService;
	
	
	
	
	@GetMapping("/listado")
	public String getListaConsejosPage(Model model) {
		model.addAttribute("consejos", consejoService.getLista());
		return "consejoSalud";
}
	
	@GetMapping("/nuevo")
	public String getNuevoConsejoPage(Model model) {
		model.addAttribute("consejosSalud", consejoService.getConsejo());
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo_salud";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevoConsejoPage(@Valid @ModelAttribute("consejosSalud")consejosSalud consejosSalud, BindingResult result) {
		ModelAndView modelView = new ModelAndView("consejoSalud");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_consejo_salud");
			modelView.addObject("consejosSalud", consejosSalud);
			return modelView;  
		}
		consejoService.guardar(consejosSalud);
		modelView.addObject("consejos", consejoService.getLista());
		return modelView;
}
	
	@GetMapping("/modificar/{id}") 
	public String getModificarConsejoPage(Model model, @PathVariable(value="id")Long id){
		boolean edicion = true;
		model.addAttribute("consejosSalud", consejoService.getBy(id)); 
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo_salud";
}
	
	@PostMapping("/modificar")
	public String modificarConsejos(@Valid @ModelAttribute("consejosSalud")consejosSalud consejosSalud, BindingResult result) {
		if(result.hasErrors()) {
			
			return "nuevo_consejo_salud";
		}
		 
		consejoService.modificar(consejosSalud);
		return "redirect:/consejos/listado";
}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarConsejos(@PathVariable(value="id") Long id) {
		consejosSalud consejoEncontrado = consejoService.getBy(id);
		consejoService.eliminar(consejoEncontrado);
		return "redirect:/consejos/listado";
	}
	
}