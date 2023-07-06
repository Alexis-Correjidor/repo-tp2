package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.sucursal;

import java.time.LocalDate;
import java.util.ArrayList;


@Component
public class ListaSucursal {

	/**
	 * Crea una lista de la clase sucursal
	 */
	private List<sucursal> sucursales;
	
	 /**
	  * Encapsula los datos para crear una lista de sucursales
	  */
	public ListaSucursal() {
		sucursales = new ArrayList<sucursal>();
		sucursales.add(new sucursal(1L, "Todo Mascotas - Local 1", "Jujuy", "Av. General Belgrano 3915", "+5493884999999", 
				"todomascotas1@gmail.com", LocalDate.of(2022, 05, 13), 4));
		sucursales.add(new sucursal(2L, "Todo Mascotas - Local 2", "Jujuy", "Av. General Belgrano 1530", "+5493885167839", 
				"todomascotas2@gmail.com", LocalDate.of(2022, 07, 19), 2));
		sucursales.add(new sucursal( 3L, "Todo Mascotas - Local Salta 1", "Salta", "Balvin 1030", "+5493884192238", 
				"todomascotassalta1@gmail.com", LocalDate.of(2023, 02, 05), 6));
	}
	/**
	 * Metodo para agregar una nueva sucursal a la lista
	 * @return sucursales Agrega la nueva sucursal a la lista
	 */
	public List<sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	

	
}
