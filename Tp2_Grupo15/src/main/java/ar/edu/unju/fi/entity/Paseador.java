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


@Component 				    //NOTACION REGISTRA UN bean DENTRO DEL FRAMEWORK
@Entity						//DEFINE UNA CLASE COMO ENTIDAD
@Table(name="paseadores")   //INDICAR A JPA CONTRA DE QUE TABLA SE DEBE MAPEAR UNA ENTIDAD 
public class Paseador {
	@Id 					//IDENTIFICADOR CLAVE PRIMARIA
	@GeneratedValue(strategy=GenerationType.IDENTITY) 		 //CLAVE PRIMARIA SE GENERARA E INCREMENTARA EN UNA UNIDAD
	@Column(name="pas_id" )  								 //AGREGAR NOMBRE A LA COLUMNA QUE REPRESENTA UN CAMPO
	private Long id;
	
	@Column(name="pas_nombre",length=20, nullable = false)
	@Size(min=5, max=20, message="El nombre debe tener entre 5 y 20 caracteres")   // SE DETERMINA LONGITUD DE UNA CADENA
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
	 * CONSTRUCTOR SOBRECARGADO DE PASEADOR
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

	/**
	 * METODO ENTREGARA EL id DEL PASEADOR
	 * @return id retorna el identificador del Paseador
	 */
	public Long getId() {
		return id;
	}
	/**
	 * METODO CARGARA EL id DEL PASEADOR
	 * @param id se cargara el identificador del Paseador
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * METODO ENTREGARA EL nombre DEL PASEADOR
	 * @return nombre retorna el nombre del Paseador
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * METODO CARGARA EL nombre DEL PASEADOR
	 * @param nombre se cargara el nombre del Paseador
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * METODO ENTREGARA EL apellido DEL PASEADOR
	 * @return apellido retorna el apellido del Paseador
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * METODO CARGARA EL apellido DEL PASEADOR
	 * @param apellido se cargara el apellido del Paseador
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * METODO ENTREGARA EL dia DEL PASEADOR
	 * @return dias retorna el dias del Paseador a trabajar
	 */
	public String getDias() {
		return dias;
	}
	/**
	 * METODO CARGARA EL dia DEL PASEADOR
	 * @param dias se cargara el dia del Paseador a trabajar
	 */
	public void setDias(String dias) {
		this.dias = dias;
	}
	/**
	 * METODO ENTREGARA HoraInicio en la mañana DEL PASEADOR
	 * @return horaMInicio retorna el horario inicial del Paseador
	 */
	public LocalTime getHoraMInicio() {
		return horaMInicio;
	}
	/**
	 * METODO CARGARA HoraInicio en la Mañana DEL PASEADOR
	 * @param horaMInicio se cargara horaInicial del Paseador
	 */
	public void setHoraMInicio(LocalTime horaMInicio) {
		this.horaMInicio = horaMInicio;
	}
	/**
	 * METODO ENTREGARA HoraFinal en la mañana DEL PASEADOR
	 * @return horaMInicio retorna el horario final del Paseador
	 */
	public LocalTime getHoraMFin() {
		return horaMFin;
	}
	/**
	 * METODO CARGARA HoraFinal en la Mañana DEL PASEADOR
	 * @param horaMFin se cargara horaFinal del Paseador
	 */
	public void setHoraMFin(LocalTime horaMFin) {
		this.horaMFin = horaMFin;
	}
	/**
	 * METODO ENTREGARA HoraInicio en la Tarde DEL PASEADOR
	 * @return horaMInicio retorna el horario inicial del Paseador
	 */
	public LocalTime getHoraTInicio() {
		return horaTInicio;
	}
	/**
	 * METODO CARGARA HoraInicio en la Tarde DEL PASEADOR
	 * @param horaTInicio se cargara horaInicial del Paseador
	 */
	public void setHoraTInicio(LocalTime horaTInicio) {
		this.horaTInicio = horaTInicio;
	}
	/**
	 * METODO ENTREGARA HoraFinal en la Tarde DEL PASEADOR
	 * @return horaMInicio retorna el horario final del Paseador
	 */
	public LocalTime getHoraTFin() {
		return horaTFin;
	}
	/**
	 * METODO CARGARA HoraFinal en la Tarde DEL PASEADOR
	 * @param horaTFin se cargara horaFinal del Paseador
	 */
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
