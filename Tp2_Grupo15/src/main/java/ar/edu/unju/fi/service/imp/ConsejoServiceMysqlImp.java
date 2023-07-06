package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.consejosSalud;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;
@Service("consejoServiceMysql")
public class ConsejoServiceMysqlImp implements IConsejoService {
	
	
	@Autowired
	private IConsejoRepository consejoRepository;
	@Autowired
	private consejosSalud consejo;

	/**
	 * METODO QUE OBTIENE LA LISTA DE CONSEJOS MEDIANTE SU ESTADO LOGICO 'TRUE'
	 * 
	 */
	@Override
	public List<consejosSalud> getLista() {
		
		return consejoRepository.findByEstado(true);
	}

	/**
	 * METODO PARA AÑADIR UN NUEVO CONSEJO A LA LISTA
	 */
	@Override
	public void guardar(consejosSalud consejo) {
		consejo.setEstado(true);
		consejoRepository.save(consejo);

	}

	/**
	 * METODO PARA ENCONTRAR UN CONSEJO A TRAVEZ DE SU ID
	 */
	@Override
	public consejosSalud getBy(Long id) {

		return consejoRepository.findById(id).get();
	}

	/**
	 * METODO PARA MODIFICAR LOS VALORES DE UN CONSEJO DE LA LISTA
	 */
	@Override
	public void modificar(consejosSalud consejo) {
		consejo.setEstado(true);
		consejoRepository.save(consejo);

	}

	/** 
	 * METODO QUE CAMBIA EL ESTADO DE UN CONSEJO A 'FALSE' PARA UNA ELIMINACION LOGICA
	 * @param consejo
	 */
	@Override
	public void eliminar(consejosSalud consejo) {
		consejo.setEstado(false);
		consejoRepository.save(consejo);
		
	}

	/** 
	 * METODO QUE DEVUELVE UN CONSEJO
	 */
	@Override
	public consejosSalud getConsejo() {
		
		return consejo;
	}

}
