package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaPaseador;
import ar.edu.unju.fi.model.Paseador;
import ar.edu.unju.fi.service.IPaseoService;

@Service
public class PaseoServiceImp implements IPaseoService{

	@Autowired
	private ListaPaseador listaPaseadores;
	@Autowired
	private Paseador paseador;
	
	@Override
	public List<Paseador> getLista() {
		
		return listaPaseadores.getPaseadores();
	}
	
	@Override
	public void guardar(Paseador paseador) {
		listaPaseadores.getPaseadores().add(paseador);
	}
	
	@Override
	public Paseador getBy(String nombre) {
		Paseador paseadorEncontrado = null;
		for (Paseador pas : listaPaseadores.getPaseadores()) {
			if (pas.getNombre().equals(nombre)) {
				paseadorEncontrado = pas;
				break;
			}
		}
		return paseadorEncontrado;
	}
	
	@Override
	public void modificar(Paseador paseador) {
		for(Paseador pas : listaPaseadores.getPaseadores()) {
			if (pas.getNombre().equals(paseador.getNombre())) {
				pas.setApellido(paseador.getApellido());
				pas.setDias(paseador.getDias());
				pas.setHoraMInicio(paseador.getHoraMInicio());
				pas.setHoraMFin(paseador.getHoraMFin());
				pas.setHoraTInicio(paseador.getHoraTInicio());
				pas.setHoraTFin(paseador.getHoraTFin());
			}	
		}
		
	}
	
	@Override
	public void eliminar(Paseador paseador) {
		listaPaseadores.getPaseadores().remove(paseador);
	}
	
	@Override
	public Paseador getPaseador() {
		
		return paseador;
	}
}
