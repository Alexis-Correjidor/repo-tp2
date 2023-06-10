package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.listaSucursal;
import ar.edu.unju.fi.model.sucursal;
import ar.edu.unju.fi.service.ISucursalService;


@Service
public class sucursalServiceImp implements ISucursalService {
	
	@Autowired
	private listaSucursal listaSucursales;
	@Autowired
	private sucursal sucursal;
	
	@Override
	public List<sucursal> getLista() {
		
		return listaSucursales.getSucursales();
	}

	@Override
	public void guardar(sucursal sucursal) {
		listaSucursales.getSucursales().add(sucursal);
	}
 
	@Override
	public sucursal getBy(String nombre) {
		sucursal sucursalEncontrada = null;
		for(sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(nombre)) {
				sucursalEncontrada = sucu;
				break;
			}
		}	
		return sucursalEncontrada;
	}

	@Override
	public void modificar(sucursal sucursal) {
		
		for(sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(sucursal.getNombre())) {
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setEmail(sucursal.getEmail());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setTelefono(sucursal.getTelefono());
				sucu.setFechaInicio(sucursal.getFechaInicio());
				sucu.setCantidadEmpleados(sucursal.getCantidadEmpleados());
			}	
		}
	}

	@Override
	public void eliminar(sucursal sucursal) {
		listaSucursales.getSucursales().remove(sucursal);
	}
 
	@Override
	public sucursal getSucursal() {
		
		return sucursal;
	}

	
}
