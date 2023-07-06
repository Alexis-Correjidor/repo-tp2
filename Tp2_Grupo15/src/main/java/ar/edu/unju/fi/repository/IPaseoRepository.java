package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Paseador;

@Repository
public interface IPaseoRepository extends CrudRepository<Paseador,Long>{	//SE EXTENDERA INTERFAZ A CRUDREPOSITORY CON UNA CLASE DE REFERECNIA(Paseador) Y EL IDENTIDICADOR(id DE TIPO Long) 

	public List<Paseador> findByEstado(boolean estado); 	//BUSCAR Y LISTAR PASEADORES EN ESTADO TRUE
	
}
