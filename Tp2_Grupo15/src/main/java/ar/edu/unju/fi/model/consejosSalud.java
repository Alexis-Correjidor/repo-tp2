package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

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
	private String titulo;
	private String descripcion;
	private String nombreIMG;
public consejosSalud () {
	
}

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
