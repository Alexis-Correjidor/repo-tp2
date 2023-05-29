package ar.edu.unju.fi.model;

import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component

public class Paseador {

	private String nombre;
	private String apellido;
	private String dias;
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime horaMInicio;
	private LocalTime horaMFin;
	private LocalTime horaTInicio;
	private LocalTime horaTFin;
	
	public Paseador() {
		
	}

	/**
	 * Constructor Sobrecargado de Paseador
	 * @param nombre recibe un parametro tipo String para el nombre del Paseador.
	 * @param apellido recibe un parametro tipo String para el apellido del Paseador.
	 * @param dias recibe un parametro tipo String para los dias a trabajar.
	 * @param horaMInicio recibe un parametro tipo LocalTime para almacenar hora inicial a trabajar por la mañana.
	 * @param horaMFin recibe un parametro tipo LocalTime para almacenar hora final a trabajar por la tarde.
	 * @param horaTInicio recibe un parametro tipo LocalTime para almacenar hora inicial a trabajar por la mañana.
	 * @param horaTFin recibe un parametro tipo LocalTime para almacenar hora final a trabajar por la tarde.
	 */
	public Paseador(String nombre, String apellido, String dias, LocalTime horaMInicio, LocalTime horaMFin, LocalTime horaTInicio,
			LocalTime horaTFin) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dias = dias;
		this.horaMInicio = horaMInicio;
		this.horaMFin = horaMFin;
		this.horaTInicio = horaTInicio;
		this.horaTFin = horaTFin;
	}

	/*----Creacion de Getters y Setters----*/
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public LocalTime getHoraMInicio() {
		return horaMInicio;
	}

	public void setHoraMInicio(LocalTime horaMInicio) {
		this.horaMInicio = horaMInicio;
	}

	public LocalTime getHoraMFin() {
		return horaMFin;
	}

	public void setHoraMFin(LocalTime horaMFin) {
		this.horaMFin = horaMFin;
	}

	public LocalTime getHoraTInicio() {
		return horaTInicio;
	}

	public void setHoraTInicio(LocalTime horaTInicio) {
		this.horaTInicio = horaTInicio;
	}

	public LocalTime getHoraTFin() {
		return horaTFin;
	}

	public void setHoraTFin(LocalTime horaTFin) {
		this.horaTFin = horaTFin;
	}
	
	
	
	
	
	
}
