package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Paseador;


public interface IPaseoService {

	List<Paseador> getLista();
	
	void guardar (Paseador paseador);
	
	Paseador getBy(String nombre);
	
	void modificar(Paseador paseador);
	
	void eliminar(Paseador paseadorEncontrado);
	
	Paseador getPaseador();
}

