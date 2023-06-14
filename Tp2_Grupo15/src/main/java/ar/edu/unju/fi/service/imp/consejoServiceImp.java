package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.consejosSalud;
import ar.edu.unju.fi.listas.ListaConsejos;
import ar.edu.unju.fi.service.IConsejoService;

@Service
public class consejoServiceImp implements IConsejoService{

	@Autowired
	private ListaConsejos listaConsejos;
	@Autowired
	private consejosSalud consejosSalud;
	
	/**
	 * METODO QUE RETORNA LA LISTA DE CONSEJOS
	 * */
	@Override
	public List<consejosSalud> getLista() {
		
		return listaConsejos.getConsejos();
	}

	/**
	 * METODO PARA AÑADIR UN NUEVO CONSEJO A LA LISTA
	 * */
	@Override
	public void guardar(consejosSalud consejo) {
		listaConsejos.getConsejos().add(consejo);
		 
	}

	/**
	 * EL METODO CONSIGUE EL CONSEJO ATRAVES DEL TITULO
	 * @param titulo
	 * @return RETORNA EL CONSEJO ENCOTRADO
	 * */
	@Override
	public consejosSalud getBy(String titulo) {
		consejosSalud consejoEncontrado = null; 
		for(consejosSalud conse : listaConsejos.getConsejos()) {
			if (conse.getTitulo().equals(titulo)) {
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
	public void modificar(consejosSalud consejo) {
		for(consejosSalud conse : listaConsejos.getConsejos()) {
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
	public void eliminar(consejosSalud consejo) {
		listaConsejos.getConsejos().remove(consejo);
		
	}

	/**METODO QUE DEVUELVE EL CONSEJO */
	@Override
	public consejosSalud getConsejo() {
		
		return consejosSalud;
	}
 
}
