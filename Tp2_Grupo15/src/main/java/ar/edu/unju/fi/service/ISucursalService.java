package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.sucursal;


public interface ISucursalService {

	List<sucursal> getLista();
	  
	void guardar (sucursal sucursal);
	
	sucursal getBy(String nombre);
	
	void modificar(sucursal sucursal);
	
	void eliminar(sucursal sucursalEncontrada);
	
	sucursal getSucursal();
}
