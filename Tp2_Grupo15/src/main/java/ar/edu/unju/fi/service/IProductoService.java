package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Producto;

public interface IProductoService {
	
	/**METODOS*/
	
	List<Producto> getProductos();
	
	Producto getBy(Long id);
	
	void guardar(Producto producto);
	
	void modificar(Producto producto);
	
	void eliminar(Producto producto);
	
	Producto getProducto();
	
	
	
}
