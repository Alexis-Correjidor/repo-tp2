package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.consejosSalud;



public interface IConsejoService {

	/** METODOS */
	
	List<consejosSalud> getLista();
	  
	void guardar (consejosSalud consejo);
	
	consejosSalud getBy(Long id);
	
	void modificar(consejosSalud consejo);
	
	void eliminar(consejosSalud consejoEncontrado);
	
	consejosSalud getConsejo();
}
 