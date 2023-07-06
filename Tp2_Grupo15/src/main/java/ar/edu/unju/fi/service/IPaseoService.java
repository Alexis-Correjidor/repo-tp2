package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Paseador;


public interface IPaseoService { //INTERFAZ DE METODOS ABSTRACTOS IMPLEMENTADOS EN PaseoServiceImp

	List<Paseador> getLista();
	
	void guardar (Paseador paseador);
	
	Paseador getBy(Long id);
	
	void modificar(Paseador paseador);
	
	void eliminar(Paseador paseadorEncontrado);
	
	Paseador getPaseador();
}

