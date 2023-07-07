package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Component
@Entity
@Table(name="consejos")

	public class consejosSalud {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY) 
		@Column(name="conse_id" )
		private Long id;
		
		@Column(name="conse_titulo",length=65, nullable = false)
		@Size(min=15, max=150, message="El titulo debe tener entre 10 y 150 caracteres")
		@NotEmpty(message="El titulo no puede estar vacio")
		private String titulo;
		
		@Column(name="conse_descripcion")
		@Size(min=30, message="Debe tener una descripcion mas extensa")
		@NotEmpty(message="La descripcion no puede estar vacia.")
		private String descripcion;
		
		@Column(name="conse_imagen",length=55, nullable = false)
		@NotEmpty(message="Debe describir la imagen que se usaria")
		private String nombreIMG;
		
		@Column(name="conse_estado")
		private boolean estado;
		
	public consejosSalud () {
		
	}
	/**
	 * Captura los datos para un articulo
	 * @param id El identificador del articulo
	 * @param titulo El titulo que del articulo
	 * @param descripcion La descripcion que del articulo
	 * @param nombreIMG  La imagen que lleva el articulo
	 */
	public consejosSalud(Long id, String titulo, String descripcion, String nombreIMG) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.nombreIMG = nombreIMG;
	}
	
	
	
	/**
	 * @return nombreIMG Retorna nombre de la imagen del articulo
	 */
	public String getNombreIMG() {
		return nombreIMG;
	}
	
	/**
	 * @param nombreIMG Carga el nombre de la imagen del articulo
	 */
	public void setNombreIMG(String nombreIMG) {
		this.nombreIMG = nombreIMG;
	}
	
	/**
	 * @return titulo Retorna el titulo del articulo
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * @param titulo Carga el titulo del articulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * @return descripcion Retorna la descripcion de un articulo
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * @param descripcion Carga la descripcion de un articulo
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @return id Retorna el identificador de un articulo
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id Carga el identificador de un articulo
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return estado Retorna el estado logico de un articulo para guardarlo, modificarlo o eliminarlo
	 */
	public boolean isEstado() {
		return estado;
	}
	
	/**
	 * @param estado Carga el estado logico de un articulo para guardarlo, modificarlo o eliminarlo
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	}
