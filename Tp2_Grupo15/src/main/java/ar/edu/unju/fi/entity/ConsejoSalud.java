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

/**
 * Clase que contiene los datos de un articulo de salud
 */
public class ConsejoSalud {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="conse_id" )
	private Long id;
	
	@Column(name="conse_titulo")
	@Size(min=15, max=150, message="El titulo debe tener entre 10 y 150 caracteres")
	@NotEmpty(message="El titulo no puede estar vacio")
	private String titulo;
	
	@Column(name="conse_descripcion")
	@Size(min=30, message="Debe tener una descripcion mas extensa")
	@NotEmpty(message="La descripcion no puede estar vacia.")
	private String descripcion;
	
	@Column(name="conse_imagen")
	@NotEmpty(message="Debe describir la imagen que se usaria")
	private String nombreIMG;
	
	@Column(name="conse_estado")
	private boolean estado;
	
public ConsejoSalud () {
	
}
/**
 * Captura los datos para el articulo
 * @param id El identificador del articulo
 * @param titulo El titulo del articulo
 * @param descripcion La descripcion del articulo
 * @param nombreIMG  Imagen del articulo
 */
public ConsejoSalud(Long id, String titulo, String descripcion, String nombreIMG) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.nombreIMG = nombreIMG;
}

public String getNombreIMG() {
	return nombreIMG;
}

public void setNombreIMG(String nombreIMG) {
	this.nombreIMG = nombreIMG;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public boolean isEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}


}
