package ar.edu.unju.fi.listas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.model.Paseador;

@Component
public class ListaPaseador {

	private List<Paseador>paseadores;
	
	public ListaPaseador() {
		paseadores = new ArrayList<Paseador>();
		paseadores.add(new Paseador("Juan", "Perez", "Lunes", LocalTime.of(8,00), LocalTime.of(9,00),LocalTime.of(18,30),LocalTime.of(21,15)));
		paseadores.add(new Paseador("Lucas", "Diaz", "Martes", LocalTime.of(10,15), LocalTime.of(11,45),LocalTime.of(19,00),LocalTime.of(22,00)));
		paseadores.add(new Paseador("Maria", "Gomez", "Jueves",LocalTime.of(11,30), LocalTime.of(13,00),LocalTime.of(20,15),LocalTime.of(23,10)));
		
	}
	
	public List<Paseador> getPaseadores() {
		return paseadores;
	}

	public void setPaseadores(List<Paseador> paseadores) {
		this.paseadores = paseadores;
	}
	
}
