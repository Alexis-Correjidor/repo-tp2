package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/*----encapsulamiento de datos sucursal----*/
@Component

	public class sucursal {
		@Size(min=8, max=30, message="El nombre debe tener entre 8 y 30 caracteres")
		@NotEmpty(message="Este campo no debe estar vacio")
		private String nombre;
		@NotBlank(message="Debe seleccion una provincia")
		private String provincia;
		@Size(min=5, max=100,message="La direccion debe tener entre 5 y 100 caracteres")
		@NotEmpty(message="Este campo no debe estar vacio")
		private String direccion;
		@NotEmpty(message="Este campo no puede estar vacio")
		@Size(min=7, max=12, message="El telefono debe tener entre 7 y 12 caracteres")
		private String telefono;
		@NotEmpty(message="Este campo no debe estar vacio")
		@Email(message="Debe ingresar un email con formato valido")
		private String email;
		@DateTimeFormat(pattern="dd-MM-yyyy")
		@NotNull(message="La fecha no puede ser null")
		@Past(message="La fecha debe ser menor a la actual")
		private LocalDate fechaInicio;
		@Min(value=3, message="El valor mínimo permitido es 3")
		@Max(value=15, message="El valor máximo permitido es 15")
		@Positive(message="Solo se permiten valores positivos")
		private int cantidadEmpleados;
		
	public sucursal() {
		
	}

	/**
	 * Se utiliza para los datos de las sucursales.
	 * @author Agustin Castellon
	 * @param nombre recibe un parametro tipo String para el nombre de la sucursal.
	 * @param provincia recibe un parametro tipo String para la provincia de la sucursal.
	 * @param direccion recibe un parametro tipo String para la direccion de la sucursal.
	 * @param telegono recibe un parametro tipo String para el telefono de la sucursal.
	 * @param email recibe un parametro tipo String para el mail de la sucursal.
	 * @param fechaInicio recibe un parametro tipo LocalDate para la fecha de inicio de la sucursal.
	 * @param cantidadEmpleados recibe la cantidad de empleados que trabajan en el local.
	 */
	public sucursal(String nombre, String provincia, String direccion, String telefono, String email,
		LocalDate fechaInicio, int cantidadEmpleados) {
	super();
	this.nombre = nombre;
	this.provincia = provincia;
	this.direccion = direccion;
	this.telefono = telefono;
	this.email = email;
	this.fechaInicio = fechaInicio;
	this.cantidadEmpleados = cantidadEmpleados;
}
	/*----creacion de getters y setters----*/
	
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

	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}
	
	 
}
