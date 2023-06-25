package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Paseador;

@Repository
public interface IPaseoRepository extends CrudRepository<Paseador,Long>{

	public List<Paseador> findByEstado(boolean estado);
	
}
