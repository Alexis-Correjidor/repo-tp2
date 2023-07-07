package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;


public interface ISucursalService {

	
	
	List<Sucursal> getLista();
	  
	void guardar (Sucursal sucursal);
	
	Sucursal getBy(Long id);
	
	void modificar(Sucursal sucursal);
	
	void eliminar(Sucursal sucursalEncontrada);
	
	Sucursal getSucursal();
}
