package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.service.ISucursalService;


@Service("sucursalServiceImp")
public class SucursalServiceImp implements ISucursalService {
	
	@Autowired
	private ListaSucursal listaSucursales;
	@Autowired
	private Sucursal sucursal;
	
	/**
	 * METODO QUE RETORNA LA LISTA DE SUCURSALES
	 * */
	@Override
	public List<Sucursal> getLista() {
		
		return listaSucursales.getSucursales();
	}
	
	/**
	 * METODO PARA AÑADIR UNA NUEVA SUCURSAL A LA LISTA
	 * */
	@Override
	public void guardar(Sucursal sucursal) {
		listaSucursales.getSucursales().add(sucursal);
	}
 
	/**
	 * EL METODO CONSIGUE LA SUCURSAL ATRAVES DE SU ID
	 * @param id
	 * @return RETORNA LA SUCURSAL ENCONTRADA
	 * */
	
	@Override
	 public Sucursal getBy(Long id) {
		Sucursal sucursalEncontrada = null;
		for(Sucursal sucu : listaSucursales.getSucursales()) {
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
	public void modificar(Sucursal sucursal) {
		
		for(Sucursal sucu : listaSucursales.getSucursales()) {
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
	public void eliminar(Sucursal sucursal) {
		listaSucursales.getSucursales().remove(sucursal);
	}
 
	/**
	 * METODO QUE DEVUELVE LA SUCURSAL */
	@Override
	public Sucursal getSucursal() {
		
		return sucursal;
	}

	
}
