package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.sucursal;
import ar.edu.unju.fi.listas.listaSucursal;
import ar.edu.unju.fi.service.ISucursalService;


@Service("sucursalServiceImp")
public class sucursalServiceImp implements ISucursalService {
	
	@Autowired
	private listaSucursal listaSucursales;
	@Autowired
	private sucursal sucursal;
	
	/**
	 * METODO QUE RETORNA LA LISTA DE SUCURSALES
	 * */
	@Override
	public List<sucursal> getLista() {
		
		return listaSucursales.getSucursales();
	}
	
	/**
	 * METODO PARA AÑADIR UNA NUEVA SUCURSAL A LA LISTA
	 * */
	@Override
	public void guardar(sucursal sucursal) {
		listaSucursales.getSucursales().add(sucursal);
	}
 
	/**
	 * EL METODO CONSIGUE LA SUCURSAL ATRAVES DE SU ID
	 * @param id
	 * @return RETORNA LA SUCURSAL ENCONTRADA
	 * */
	
	@Override
	 public sucursal getBy(Long id) {
		sucursal sucursalEncontrada = null;
		for(sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getId().equals(id)) {
				sucursalEncontrada = sucu;
				break;
			}
		} 	
		return sucursalEncontrada;
	} 

	/**
	 * METODO PARA MODIFICAR LOS VALORES DE UNA SUCURSAL DE LA LISTA
	 * @param sucursal
	 * */
	@Override
	public void modificar(sucursal sucursal) {
		
		for(sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getId().equals(sucursal.getId())) {
				sucu.setId(sucursal.getId());
				sucu.setNombre(sucursal.getNombre());
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setEmail(sucursal.getEmail());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setTelefono(sucursal.getTelefono());
				sucu.setFechaInicio(sucursal.getFechaInicio());
				sucu.setCantidadEmpleados(sucursal.getCantidadEmpleados());
			}	
		}
	}

	/** 
	 * METODO QUE ELIMINA LA SUCURSAL ENVIADO POR PARAMETRO
	 * @param sucursal
	 * */
	@Override
	public void eliminar(sucursal sucursal) {
		listaSucursales.getSucursales().remove(sucursal);
	}
 
	/**METODO QUE DEVUELVE LA SUCURSAL */
	@Override
	public sucursal getSucursal() {
		
		return sucursal;
	}

	
}
