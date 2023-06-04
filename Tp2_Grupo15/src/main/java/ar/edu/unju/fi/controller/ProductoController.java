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

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ListaProducto listaProducto; //INYECCION CLASS LISTAPRODUCTO
	@Autowired
	private Producto producto; //INYECCION CLASS PRODUCTO
	
	/**RECIBE LA PETECION ENVIADA POR URL PARA MOSTRAR LA PAGINA PRODUCTOS CON LOS OBJETOS DE LA LISTA
	 * @param model 
	 * @return RETORNA LA PAGINA productos
	 * */
	@GetMapping("/lista-producto")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", listaProducto.getProductos());
		return "productos";
	}
	
	
	/**CAPTURA LA PETECION ENVIADA POR URL, MUESTRA LA PAGINA formulario-producto CON UN OBJETO PARA ASIGNARLE VALORES A LOS ATRIBUTOS.
	 * @param model
	 * @return  RETORNA PAGINA formulario-producto
	 * */
	@GetMapping("/nuevo")
	public String getFormularioProductoPage(Model model) {
		boolean editar=false;
		model.addAttribute("producto", producto);
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
	
		listaProducto.getProductos().add(producto);
		modelView.addObject("productos", listaProducto.getProductos());
		return modelView;
	
	}
	
	/** CAPTURA LA VARIABLE ENVIADA POR URL Y MUESTRA LA PAGINA formulario-producto CON EL OBJETO DE LA LISTA
	 * 	CON EL CUAL ENCONTRO LA COINCIDENCIA EN EL ATRIBUTO CODIGO
	 * @param model
	 * @param codigo
	 * @return RETORNA LA PAGINA formulario-producto
	 *  */
	@GetMapping("/modificar/{codigo}")
		public String getEditarProductoPage(Model model, @PathVariable(value="codigo") String codigo) {
			boolean editar=true;
			Producto productoEncontrado = new Producto();
			for (Producto prod: listaProducto.getProductos()) {
				if (prod.getCodigo()==Integer.parseInt(codigo)) {
					productoEncontrado = prod;
					break;
				}
			}
			model.addAttribute("producto", productoEncontrado);
			model.addAttribute("editar", editar);
			return "formulario-producto";
			
		}
	
	/**ASIGNA LOS NUEVOS VALORES A LOS ATRIBUTOS DEL OBJETO. EL CODIGO DEBE SER EL MISMO
	 * @param producto
	 * @return EL OBJETO CON LOS NUEVOS VALORES EN LA PAGINA productos
	 *   */
	@PostMapping("/modificar")
	public String modificarProductoPage(@ModelAttribute("producto")Producto producto) {
		for (Producto prod: listaProducto.getProductos()) {
			if (prod.getCodigo()== producto.getCodigo()) {
				 prod.setNombre(producto.getNombre());
				 prod.setNombreImagen(producto.getNombreImagen());
				 prod.setCodigo(producto.getCodigo());
				 prod.setPrecio(producto.getPrecio());
				 prod.setCategoria(producto.getCategoria());
				 prod.setDescuento(producto.getDescuento());
			}
		}
		return "redirect:/producto/lista-producto";
	}
	/** CAPTURA LA VARIABLE ENVIADA POR URL Y MUESTRA LA PAGINA FORMULARIO PRODUCTOS CON EL OBJETO DE LA LISTA
	 * 	CON EL CUAL ENCONTRO LA COINCIDENCIA EN EL ATRIBUTO CODIGO PARA PODER ELIMINAR EL OBJETO DE LA LISTA
	 * @param codigo
	 * @return RETORNA LA PAGINA productos CON EL OBJETO ELIMINADO DE LA LISTA
	 * */
	@GetMapping("/eliminar/{codigo}")
	public String eliminarProducto(@PathVariable(value = "codigo")String codigo) {
		for (Producto prod: listaProducto.getProductos()) {
			if (prod.getCodigo()== Integer.parseInt(codigo)) {
				listaProducto.getProductos().remove(prod);
				break;
			}
		}
		return "redirect:/producto/lista-producto";
	}
	
	
}
