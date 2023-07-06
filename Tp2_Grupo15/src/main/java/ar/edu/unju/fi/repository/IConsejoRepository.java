package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.ConsejoSalud;

@Repository
public interface IConsejoRepository extends CrudRepository<ConsejoSalud,Long> {


	
	public List<ConsejoSalud> findByEstado(boolean estado);
	
}
