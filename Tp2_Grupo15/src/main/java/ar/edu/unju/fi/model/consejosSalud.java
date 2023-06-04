package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/*----encapsulamiento de datos consejoSalud----*/
@Component
/**
 * Se utiliza para los datos que iran en el articulo.
 * @author Agustin Castellon
 * @param titulo recibe un parametro tipo String sobre el titulo del arituclo.
 * @param descripcion recibe un parametro tipo String sobre la descripcion del articulo.
 * @param nombreIMG recibe un parametro tipo String sobre la descripcion de la imagen a utilizar.
 */
public class consejosSalud {
	@Size(min=15, max=150, message="El titulo debe tener entre 10 y 150 caracteres")
	@NotEmpty(message="El titulo no puede estar vacio")
	private String titulo;
	@Size(min=30, message="Debe tener una descripcion mas extensa")
	@NotEmpty(message="La descripcion no puede estar vacia.")
	private String descripcion;
	@NotEmpty(message="Debe describir la imagen que se usaria")
	private String nombreIMG;
public consejosSalud () {
	
}
/*----Constructor sobrecargado----*/
public consejosSalud(String titulo, String descripcion, String nombreIMG) {
	super();
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

}
