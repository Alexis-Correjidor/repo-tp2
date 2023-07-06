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

	public class Sucursal {
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
		
	public Sucursal() {
		
	}

	/**
	 * Captura los datos para una sucursal
	 * @param id El identificador de la sucursal
	 * @param nombre El nombre de la sucursal
	 * @param provincia La provincia donde estará la sucursal
	 * @param direccion La Dirección de la sucursal
	 * @param telefono El telefono de la sucursal
	 * @param email El correo de la sucursal
	 * @param fechaInicio  La fecha de inauguracion de la sucursal
	 * @param cantidadEmpleados  La cantidad de empleados de la sucursal
	 */
	public Sucursal(Long id, String nombre, String provincia, String direccion, String telefono, String email,
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
	
	/**
	 * @return id Retorna el identificador de la sucursal
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id Carga el identificador de la sucursal
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return nombre Retorna el nombre de la sucursal
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre Carga el nombre de la sucursal
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return provincia Retorna la provincia de la sucursal
	 */
	public String getProvincia() {
		return provincia;
	}
	
	/**
	 * @param provincia Carga la provincia de la sucursal
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	/**
	 * @return direccion Retorna la direccion de la sucursal
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * @param direccion Carga la direccion de la sucursal
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * @return telefono Retorna el numero de telefono de la sucursal
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * @param telefono Carga el numero de telefono de la sucursal
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * @return email Retorna el correo de la sucursal
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email Carga el correo de la sucursal
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return fechaInicio Retorna la fecha de inauguracion de la sucursal
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	/**
	 * @param fechaInicio Carga la fecha de inauguracion de la sucursal
	 */
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return Retorna la cantidad de empleados de la sucursal
	 */
	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	/**
	 * @param cantidadEmpleados Carga la cantidad de empleados de la sucursal
	 */
	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

	/**
	 * @return estado Retorna el estado logico de una sucursal para guardarla, modificarla o eliminarla
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado Carga el estado logico de una sucursal para guardarla, modificarla o eliminarla
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	 
}
