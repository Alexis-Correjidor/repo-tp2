package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class sucursal {
	private String nombre;
	private String provincia;
	private String direccion;
	private String telefono;
	private String email;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate fechaInicio;
	
public sucursal() {
	
}

	public sucursal(String nombre, String provincia, String direccion, String telefono, String email,
		LocalDate fechaInicio) {
	super();
	this.nombre = nombre;
	this.provincia = provincia;
	this.direccion = direccion;
	this.telefono = telefono;
	this.email = email;
	this.fechaInicio = fechaInicio;
}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	 
}
