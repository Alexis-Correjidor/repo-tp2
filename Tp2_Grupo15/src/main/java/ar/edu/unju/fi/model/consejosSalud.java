package ar.edu.unju.fi.model;

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
