package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Producto {
	private String nombre;
	private String nombreImagen;
	private int codigo;
	private double precio;
	private String categoria;
	private int descuento;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String nombre,String nombreImagen, int codigo, double precio, String categoria, int descuento) {
		super();
		this.nombre = nombre;
		this.nombreImagen = nombreImagen;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
	}

	
	public double calcularDescuento() {
		if (descuento != 0 ) {
		double resultado = Math.round((1 - descuento/100d) * precio);
			return resultado;
		} else {
			return precio;
		}
	}
	
	
	
	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	
	


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public int getDescuento() {
		return descuento;
	}



	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	


}


