package ar.edu.unju.fi.model;

public class Paseador {

	private String nombre;
	private String apellido;
	private String dias;
	private int horaMInicio;
	private int horaMFin;
	private int horaTInicio;
	private int horaTFin;
	
	public Paseador() {
		// TODO Auto-generated constructor stub
	}

	public Paseador(String nombre, String apellido, String dias, int horaMInicio, int horaMFin, int horaTInicio,
			int horaTFin) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dias = dias;
		this.horaMInicio = horaMInicio;
		this.horaMFin = horaMFin;
		this.horaTInicio = horaTInicio;
		this.horaTFin = horaTFin;
	}

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

	public int getHoraMInicio() {
		return horaMInicio;
	}

	public void setHoraMInicio(int horaMInicio) {
		this.horaMInicio = horaMInicio;
	}

	public int getHoraMFin() {
		return horaMFin;
	}

	public void setHoraMFin(int horaMFin) {
		this.horaMFin = horaMFin;
	}

	public int getHoraTInicio() {
		return horaTInicio;
	}

	public void setHoraTInicio(int horaTInicio) {
		this.horaTInicio = horaTInicio;
	}

	public int getHoraTFin() {
		return horaTFin;
	}

	public void setHoraTFin(int horaTFin) {
		this.horaTFin = horaTFin;
	}
	
	
	
	
	
	
}
