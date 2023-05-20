package ar.edu.unju.fi.listas;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import ar.edu.unju.fi.model.sucursal;

public class listaSucursal {

	private List<sucursal> sucursales;
	
	public listaSucursal() {
		sucursales = new ArrayList<sucursal>();
		sucursales.add(new sucursal("Todo Mascotas - Local 1", "Jujuy", "Av. General Belgrano 3915", "+5493884999999", 
				"todomascotas1@gmail.com", LocalDate.of(2022, 05, 13)));
		sucursales.add(new sucursal("Todo Mascotas - Local 2", "Jujuy", "Av. General Belgrano 1530", "+5493885167839", 
				"todomascotas2@gmail.com", LocalDate.of(2022, 07, 19)));
		sucursales.add(new sucursal("Todo Mascotas - Local Salta 1", "Salta", "Balvin 1030", "+5493884192238", 
				"todomascotassalta1@gmail.com", LocalDate.of(2023, 02, 05)));
	}

	public List<sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	

	
}
