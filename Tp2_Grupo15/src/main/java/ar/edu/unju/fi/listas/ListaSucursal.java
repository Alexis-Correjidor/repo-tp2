package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;


@Component
public class ListaSucursal {

	private List<Sucursal> sucursales;
	 
	public ListaSucursal() {
		sucursales = new ArrayList<Sucursal>();
		sucursales.add(new Sucursal(1L, "Todo Mascotas - Local 1", "Jujuy", "Av. General Belgrano 3915", "+5493884999999", 
				"todomascotas1@gmail.com", LocalDate.of(2022, 05, 13), 4));
		sucursales.add(new Sucursal(2L, "Todo Mascotas - Local 2", "Jujuy", "Av. General Belgrano 1530", "+5493885167839", 
				"todomascotas2@gmail.com", LocalDate.of(2022, 07, 19), 2));
		sucursales.add(new Sucursal( 3L, "Todo Mascotas - Local Salta 1", "Salta", "Balvin 1030", "+5493884192238", 
				"todomascotassalta1@gmail.com", LocalDate.of(2023, 02, 05), 6));
	}
	/**
	 * @return sucursales Retorna la lista de sucursales
	 */
	public List<Sucursal> getSucursales() {
		return sucursales;
	}
	/**
	 * @param sucursales Carga la lista de sucursales 
	 */
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	

	
}
