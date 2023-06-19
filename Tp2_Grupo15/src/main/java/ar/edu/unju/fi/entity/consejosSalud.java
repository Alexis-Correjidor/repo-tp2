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

/*----encapsulamiento de datos consejoSalud----*/
@Component
@Entity
@Table(name="consejos")
/**
 * Se utiliza para los datos que iran en el articulo.
 * @author Agustin Castellon
 * @param titulo recibe un parametro tipo String sobre el titulo del arituclo.
 * @param descripcion recibe un parametro tipo String sobre la descripcion del articulo.
 * @param nombreIMG recibe un parametro tipo String sobre la descripcion de la imagen a utilizar.
 */
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
/*----Constructor sobrecargado----*/
public consejosSalud(Long id, String titulo, String descripcion, String nombreIMG) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.nombreIMG = nombreIMG;
}
/*----creacion de getters y setters----*/
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
