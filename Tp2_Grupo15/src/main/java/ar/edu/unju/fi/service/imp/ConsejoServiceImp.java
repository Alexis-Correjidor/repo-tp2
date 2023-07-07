package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ConsejoSalud;
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.service.IConsejoService;

@Service("consejoServiceImp")
public class ConsejoServiceImp implements IConsejoService{

	@Autowired
	private ListaConsejo listaConsejos;
	@Autowired
	private ConsejoSalud consejosSalud;
	
	/**
	 * METODO QUE RETORNA LA LISTA DE CONSEJOS
	 * */
	@Override
	public List<ConsejoSalud> getLista() {
		
		return listaConsejos.getConsejos();
	}

	/**
	 * METODO PARA AÑADIR UN NUEVO CONSEJO A LA LISTA
	 * */
	@Override
	public void guardar(ConsejoSalud consejo) {
		listaConsejos.getConsejos().add(consejo);
		 
	}

	/**
	 * EL METODO CONSIGUE EL CONSEJO ATRAVES DEL ID
	 * @param ID
	 * @return RETORNA EL CONSEJO ENCOTRADO
	 * */
	@Override
	public ConsejoSalud getBy(Long id) {
		ConsejoSalud consejoEncontrado = null; 
		for(ConsejoSalud conse : listaConsejos.getConsejos()) {
			if (conse.getId().equals(id)) {
				consejoEncontrado = conse;
				break;
			}
		}
		return consejoEncontrado;
	}

	/**
	 * METODO PARA MODIFICAR LOS VALORES DE UN CONSEJO DE LA LISTA
	 * @param consejo
	 * */
	@Override
	public void modificar(ConsejoSalud consejo) {
		for(ConsejoSalud conse : listaConsejos.getConsejos()) {
			if (conse.getTitulo().equals(consejosSalud.getTitulo())) {
				conse.setNombreIMG(consejosSalud.getNombreIMG());
				conse.setDescripcion(consejosSalud.getDescripcion());
			}	
		}
	}

	/** 
	 * METODO QUE ELIMINA EL CONSEJO ENVIADO POR PARAMETRO
	 * @param consejo
	 * */
	@Override
	public void eliminar(ConsejoSalud consejo) {
		listaConsejos.getConsejos().remove(consejo);
		
	}

	/**METODO QUE DEVUELVE EL CONSEJO */
	@Override
	public ConsejoSalud getConsejo() {
		
		return consejosSalud;
	}
 
}
