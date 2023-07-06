package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


@Component
@Entity
@Table(name="sucursales")

/**
 * Clase que contiene los datos de una sucursal
 */
	public class sucursal {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY) 
		@Column(name="sucu_id" )
		private Long id;
		
		@Column(name="sucu_nombre",length=35, nullable = false)
		@Size(min=8, max=30, message="El nombre debe tener entre 8 y 30 caracteres")
		@NotEmpty(message="Este campo no debe estar vacio")
		private String nombre;
		
		@Column(name="sucu_provincia", nullable = false)
		@NotBlank(message="Debe seleccion una provincia")
		private String provincia;
		
		@Column(name="sucu_direccion", length=60, nullable = false)
		@Size(min=5, max=100,message="La direccion debe tener entre 5 y 100 caracteres")
		@NotEmpty(message="Este campo no debe estar vacio")
		private String direccion;
		
		@Column(name="sucu_telefono", nullable = false)
		@NotEmpty(message="Este campo no puede estar vacio")
		@Size(min=7, max=12, message="El telefono debe tener entre 7 y 12 caracteres")
		private String telefono;
		
		@Column(name="sucu_email", length=35, nullable = false)
		@NotEmpty(message="Este campo no debe estar vacio")
		@Email(message="Debe ingresar un email con formato valido")
		private String email;
		
		@Column(name="sucu_fecha_inicio", nullable = false)
		@DateTimeFormat(pattern="dd-MM-yyyy")
		@NotNull(message="La fecha no puede ser null")
		@Past(message="La fecha debe ser menor a la actual")
		private LocalDate fechaInicio;
		
		@Column(name="sucu_cantidad_empleados", nullable = false)
		@Min(value=3, message="El valor mínimo permitido es 3")
		@Max(value=15, message="El valor máximo permitido es 15")
		@Positive(message="Solo se permiten valores positivos")
		private int cantidadEmpleados;
		
		@Column(name="sucu_estado")
		private boolean estado;
		
	public sucursal() {
		
	}

	/**
	 * Captura los datos para una sucursal
	 * @param id El identificador de la sucursal
	 * @param nombre El nombre de la sucursal
	 * @param provincia Provincia donde se encuentra la sucursal
	 * @param direccion La direccion de la sucursal
	 * @param telefono El numero de telefono de la sucursal
	 * @param email El correo electronico de la sucursal
	 * @param fechaInicio La fecha en la que abre la sucursal
	 * @param cantidadEmpleados La cantidad de empleados de la sucursal
	 */
	public sucursal(Long id, String nombre, String provincia, String direccion, String telefono, String email,
		LocalDate fechaInicio, int cantidadEmpleados) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.provincia = provincia;
	this.direccion = direccion;
	this.telefono = telefono;
	this.email = email;
	this.fechaInicio = fechaInicio;
	this.cantidadEmpleados = cantidadEmpleados;
}
	/*----creacion de getters y setters----*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	 
}
