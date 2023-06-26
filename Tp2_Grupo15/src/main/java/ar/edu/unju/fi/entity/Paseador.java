package ar.edu.unju.fi.entity;

import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/*----encapsulamiento de datos Paseador----*/
@Component
@Entity
@Table(name="paseadores")
public class Paseador {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="pas_id" )
	private Long id;
	
	@Column(name="pas_nombre",length=20, nullable = false)
	@Size(min=5, max=20, message="El nombre debe tener entre 5 y 20 caracteres")
	private String nombre;
	
	@Column(name="pas_apellido",length=20, nullable = false)
	@Size(min=5, max=20, message="El apellido debe tener entre 5 y 20 caracteres")	
	private String apellido;
	
	@Column(name="pas_dias", nullable = false)
	@NotEmpty(message="Este campo no debe estar vacio")
	private String dias;
	
	@Column(name="pas_horaMInicio", nullable = false)
	@DateTimeFormat(pattern="HH:mm")
	@NotNull(message="La hora no puede ser null")
	private LocalTime horaMInicio;
	
	@Column(name="pas_horaMFin", nullable = false)
	@NotNull(message="La hora no puede ser null")
	private LocalTime horaMFin;
	
	@Column(name="pas_horaTInicio", nullable = false)
	@NotNull(message="La hora no puede ser null")
	private LocalTime horaTInicio;
	
	@Column(name="pas_horaTFin", nullable = false)
	@NotNull(message="La hora no puede ser null")
	private LocalTime horaTFin;
	
	@Column(name="pas_estado")
	private boolean estado;
	
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
	public Paseador(Long id,String nombre, String apellido, String dias, LocalTime horaMInicio, LocalTime horaMFin, LocalTime horaTInicio,
			LocalTime horaTFin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dias = dias;
		this.horaMInicio = horaMInicio;
		this.horaMFin = horaMFin;
		this.horaTInicio = horaTInicio;
		this.horaTFin = horaTFin;
	}

	/*----Creacion de Getters y Setters----*/
	
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
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Paseador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dias=" + dias
				+ ", horaMInicio=" + horaMInicio + ", horaMFin=" + horaMFin + ", horaTInicio=" + horaTInicio
				+ ", horaTFin=" + horaTFin + ", estado=" + estado + "]";
	}

	
}
