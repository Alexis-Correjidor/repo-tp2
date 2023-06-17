package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.sucursal;
@Repository
public interface ISucursalRepository extends CrudRepository<sucursal,Long> {

	/**
	 * METODO QUE LISTA LOS REGISTROS QUE TENGAN EL VALOR 'TRUE'
	 * @param estado
	 * @return
	 */
	public List<sucursal> findByEstado(boolean estado);
	
}
