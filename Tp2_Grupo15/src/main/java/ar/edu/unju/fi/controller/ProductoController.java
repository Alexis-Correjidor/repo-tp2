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

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	@Qualifier("productoServiceMysql")
	private IProductoService productoService;
	
	@GetMapping("/")
	public String getProductoPage(Model model) {
		model.addAttribute("productos", productoService.getProductos());
		return "productos";
	}
	
	
	/**RECIBE LA PETECION ENVIADA POR URL PARA MOSTRAR LA PAGINA PRODUCTOS CON LOS OBJETOS DE LA LISTA
	 * @param model 
	 * @return RETORNA LA PAGINA productos
	 * */
	@GetMapping("/lista-producto")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", productoService.getProductos());
		return "productoAbm";
	}
	
	
	/**CAPTURA LA PETECION ENVIADA POR URL, MUESTRA LA PAGINA formulario-producto CON UN OBJETO PARA ASIGNARLE VALORES A LOS ATRIBUTOS.
	 * @param model
	 * @return  RETORNA PAGINA formulario-producto
	 * */
	@GetMapping("/nuevo")
	public String getFormularioProductoPage(Model model) {
		boolean editar=false;
		model.addAttribute("producto", productoService.getProducto());
		model.addAttribute("editar", editar);
		return "formulario-producto";
	}
	
	
	/** EVALUA SI EL OBJETO RESULT TIENE ERRORES, VOLVERA A MOSTRAR LA PAGINA formulario-producto
	 *  PARA ENVIAR VALORES VALIDOS PARA LOS ATRIBUTOS. SINO A LA LISTA LE SE AÑADIRA UN NUEVO 
	 *  OBJETO CON LOS VALORES CORRECTOS Y MOSTRARA LA PAGINA productos
	 * 	@param producto
	 *  @param result
	 *  @return EL OBJETO modelView
	 * */
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto")Producto producto, BindingResult result) {
		ModelAndView modelView = new ModelAndView("productos");
		if(result.hasErrors()) 
		{
			modelView.setViewName("formulario-producto");
			modelView.addObject("producto", producto);
			return modelView;
		}
		productoService.guardar(producto);
		modelView.addObject("productos", productoService.getProductos());
		return modelView;
	
	}
	
	/** CAPTURA LA VARIABLE ENVIADA POR URL Y MUESTRA LA PAGINA formulario-producto CON EL OBJETO DE LA LISTA
	 * 	CON EL CUAL ENCONTRO LA COINCIDENCIA EN EL ATRIBUTO CODIGO
	 * @param model
	 * @param codigo
	 * @return RETORNA LA PAGINA formulario-producto
	 *  */
	@GetMapping("/modificar/{id}")
		public String getEditarProductoPage(Model model, @PathVariable(value="id") Long id) {
			boolean editar=true;
			model.addAttribute("producto", productoService.getBy(id));
			model.addAttribute("editar", editar);
			return "formulario-producto";
			
		}
	
	/**MUESTRA LA PAGINA HTML producto y formulario-producto
	 * @param producto
	 * @return PAGINA HTML productos y formulario-producto
	 *   */
	@PostMapping("/modificar")
	public String modificarProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
		if(result.hasErrors())
		{
			return "formulario-producto";
		}
		productoService.modificar(producto);
		return "redirect:/producto/lista-producto";
	}
	/** CAPTURA LA VARIABLE ENVIADA POR URL Y MUESTRA LA PAGINA FORMULARIO PRODUCTOS CON EL OBJETO DE LA LISTA
	 * 	CON EL CUAL ENCONTRO LA COINCIDENCIA EN EL ATRIBUTO CODIGO PARA PODER ELIMINAR EL OBJETO DE LA LISTA
	 * @param codigo
	 * @return RETORNA LA PAGINA productos CON EL OBJETO ELIMINADO DE LA LISTA
	 * */
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable(value = "id")Long id) {
		productoService.eliminar(productoService.getBy(id));	
		return "redirect:/producto/lista-producto";
	}
	
	
}
