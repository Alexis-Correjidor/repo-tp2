package ar.edu.unju.fi.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	private ListaProducto listaProductos;
	@Autowired
	private Producto producto;
	/**
	 * METODO QUE RETORNA LA LISTA DE PRODUCTOS
	 * */
	@Override
	public List<Producto> getProductos() {
		return listaProductos.getProductos();
	}
	/**
	 * METODO PARA AÑADIR UN NUEVO PRODUCTO A LA LISTA
	 * */
	@Override
	public void guardar(Producto producto) {
		listaProductos.getProductos().add(producto);
	}
	/**
	 * METODO PARA MODIFICAR LOS VALORES DE UN PRODUCTO DE LA LISTA
	 * @param producto
	 * */
	@Override
	public void modificar(Producto producto) {
		for (Producto prod: listaProductos.getProductos()) {
			if (prod.getCodigo() == producto.getCodigo()) {
				 prod.setNombre(producto.getNombre());
				 prod.setNombreImagen(producto.getNombreImagen());
				 prod.setCodigo(producto.getCodigo());
				 prod.setPrecio(producto.getPrecio());
				 prod.setCategoria(producto.getCategoria());
				 prod.setDescuento(producto.getDescuento());
			}

		}
		
	}
	/** 
	 * METODO QUE ELIMINA EL PRODUCTO ENVIADO POR PARAMETRO
	 * @param producto
	 * */
	@Override
	public void eliminar(Producto producto) {
		listaProductos.getProductos().remove(producto);
		
	}
	/**METODO QUE DEVUELVE EL PRODUCTO */
	@Override
	public Producto getProducto() {
		return producto;
	}
	
	/**
	 * EL METODO CONSIGUE EL PRODUCTO ATRAVES DEL CODIGO
	 * @param codigo
	 * @return RETORNA EL PRODUCTO ENCOTRADO
	 * */
	@Override
	public Producto getByCodigo(String codigo) {
		Producto productoEncontrado = null;
		for (Producto prod: listaProductos.getProductos()) {
			if (prod.getCodigo()==Integer.parseInt(codigo)) {
				productoEncontrado = prod;
				break;
			}
		}
		return productoEncontrado;
	}
	
	
	
}
