package ar.edu.unju.fi.listas;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.model.Paseador;

@Component
public class ListaPaseador {

	private List<Paseador>paseadores;
	
	public ListaPaseador() {
		paseadores = new ArrayList<Paseador>();
		paseadores.add(new Paseador("Juan", "Perez", "Lunes", 9, 12,16,18));
		paseadores.add(new Paseador("Lucas", "Diaz", "Martes", 9, 12,16,18));
		paseadores.add(new Paseador("Maria", "Gomez", "Jueves",9, 12, 16, 18));
		
	}
	
	public List<Paseador> getPaseadores() {
		return paseadores;
	}

	public void setPaseadores(List<Paseador> paseadores) {
		this.paseadores = paseadores;
	}
	
}
