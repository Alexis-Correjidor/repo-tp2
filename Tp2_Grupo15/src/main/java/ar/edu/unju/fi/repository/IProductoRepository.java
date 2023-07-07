package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Producto;
@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long>{
	
	/**
	 * METODO QUE LISTA LOS REGISTROS QUE TENGAN EL VALOR 'TRUE'
	 * @param estado
	 * @return
	 */
	public List<Producto> findByEstado(boolean estado);
	
}
