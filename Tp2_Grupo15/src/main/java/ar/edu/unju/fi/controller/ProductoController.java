package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ListaProducto listaProducto; //inyeccion class ListaProductos
	@Autowired
	Producto productoEncontrado; //inyeccion class Producto
	
	@GetMapping("/lista-producto")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", listaProducto.getProductos());
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String getFormularioProductoPage(Model model) {
		boolean editar=false;
		model.addAttribute("producto", new Producto());
		model.addAttribute("editar", editar);
		return "formulario-producto";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@ModelAttribute("producto")Producto producto) {
	ModelAndView modelView = new ModelAndView("productos");
	listaProducto.getProductos().add(producto);
	modelView.addObject("productos", listaProducto.getProductos());
	return modelView;
	
	}
	
	@GetMapping("/modificar/{codigo}")
		public String getEditarProductoPage(Model model, @PathVariable(value="codigo") int codigo) {
			boolean editar=true;
			for (Producto prod: listaProducto.getProductos()) {
				if (prod.getCodigo()== codigo) {
					productoEncontrado = prod;
					break;
				}
			}
			model.addAttribute("producto", productoEncontrado);
			model.addAttribute("editar", editar);
			return "formulario-producto";
			
		}
	
	
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
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarProducto(@PathVariable(value = "codigo")int codigo) {
		for (Producto prod: listaProducto.getProductos()) {
			if (prod.getCodigo()== codigo) {
				listaProducto.getProductos().remove(prod);
				break;
			}
		}
		return "redirect:/producto/lista-producto";
	}
	
	
}
