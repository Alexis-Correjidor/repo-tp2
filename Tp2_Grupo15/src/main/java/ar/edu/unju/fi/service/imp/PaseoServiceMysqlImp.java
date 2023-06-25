package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Paseador;
import ar.edu.unju.fi.repository.IPaseoRepository;
import ar.edu.unju.fi.service.IPaseoService;

@Service("paseoServiceMysql")
public class PaseoServiceMysqlImp implements IPaseoService {

	@Autowired
	private IPaseoRepository paseoRepository; 
	@Autowired
	private Paseador paseador;
	
	@Override
	public List<Paseador> getLista() {
		return paseoRepository.findByEstado(true);
	}

	@Override
	public void guardar(Paseador paseador) {
		paseador.setEstado(true);
		paseoRepository.save(paseador);
	}

	@Override
	public Paseador getBy(Long id) {
		return paseoRepository.findById(id).get();
	}

	@Override
	public void modificar(Paseador paseador) {
		paseador.setEstado(true);
		paseoRepository.save(paseador);
	}

	@Override
	public void eliminar(Paseador paseadorEncontrado) {
		paseador.setEstado(false);
		paseoRepository.save(paseador);
	}

	@Override
	public Paseador getPaseador() {
		// TODO Auto-generated method stub
		return paseador;
	}

}
