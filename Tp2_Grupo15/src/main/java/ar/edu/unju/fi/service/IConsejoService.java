package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.ConsejoSalud;



public interface IConsejoService {

	
	
	List<ConsejoSalud> getLista();
	  
	void guardar (ConsejoSalud consejo);
	
	ConsejoSalud getBy(Long id);
	
	void modificar(ConsejoSalud consejo);
	
	void eliminar(ConsejoSalud consejoEncontrado);
	
	ConsejoSalud getConsejo();
}
 