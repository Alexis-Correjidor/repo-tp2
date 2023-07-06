package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
@Service("sucursalServiceMysql")
public class SucursalServiceMysqlImp implements ISucursalService {

	@Autowired
	private ISucursalRepository sucursalRepository;
	@Autowired
	private sucursal sucursal;
	
	/**
	 * METODO QUE OBTIENE LA LISTA DE SUCURSALES MEDIANTE SU ESTADO LOGICO 'TRUE'
	 * 
	 */
	@Override
	public List<sucursal> getLista() {
		return sucursalRepository.findByEstado(true);
	}
	
	/**
	 * METODO PARA AÑADIR UNA NUEVA SUCURSAL A LA LISTA
	 */
	@Override
	public void guardar(sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);
 
	}

	/**
	 * METODO PARA ENCONTRAR UNA SUCURSAL A TRAVEZ DE SU ID
	 */
	@Override
	public sucursal getBy(Long id) {
		return sucursalRepository.findById(id).get();
	}

	/**
	 * METODO PARA MODIFICAR LOS VALORES DE UNA SUCURSAL DE LA LISTA
	 */
	@Override
	public void modificar(sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);

	}

	/** 
	 * METODO QUE CAMBIA EL ESTADO DE UNA SUCURSAL A 'FALSE' PARA UNA ELIMINACION LOGICA
	 * @param sucursal
	 */
	@Override
	public void eliminar(sucursal sucursal) {
		sucursal.setEstado(false);
		sucursalRepository.save(sucursal);
 
	}

	/** 
	 * METODO QUE DEVUELVE UNA SUCURSAL
	 */
	@Override
	public sucursal getSucursal() {
		return sucursal;
	}

}
