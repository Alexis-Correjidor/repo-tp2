package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import jakarta.validation.constraints.Size;


@Component 
public class Producto {
	/**Validaciones para el nombre de un producto*/
	@NotEmpty(message = "Debe ingresar un nombre")
	private String nombre;
	/**Validaciones para el nombre de imagen de un producto*/
	@NotBlank(message="Debe ingresar un nombre de imagen")
	@Size(min = 3, max= 30,message="Los nombres de imagen deben tener entre 3 y 30 caracteres" )
	@Pattern(regexp="[a-zA-Z]+",message="Los nombres solo pueden contener letras")
	private String nombreImagen;
	/**Validaciones para codigo de producto*/
	@NotNull(message="No puede dejar el campo codigo vacio")
	@Min(value=1, message="Debe ingresar un codigo mayor a cero")
	@Max(value = 150, message="Debe ingresar un codigo menor a 150")
	private Integer codigo;
	/**Validaciones para precio de producto*/
	@NotNull(message="Debe rellenar el campo precio")
	@Positive(message="Debe ingresar valores positivos")
	@Min(value = 0,message="Debe ingresar un precio mayor a 0")
	private Double precio;
	@NotBlank(message="Debe ingresar una categoria")
	@Size(min = 3, max= 30,message="Los nombres deben tener entre 3 y 30 caracteres" )
	@Pattern(regexp="[a-zA-Z]+",message="Los nombres solo pueden contener letras")
	private String categoria;
	@NotNull(message="Si no hay descuentos debe ingresar 0")
	@Min(value=0,message= "El valor minimo que puede ingresar es 0")
	@Max(value=50, message="El maximo de descuento que se puede aplicar es 50")
	private Integer descuento;
	
	/** CONSTRUCTOR POR DEFECTO */
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	/** CONSTRUCTOR SOBRECARCADO*/
	
	public Producto(String nombre,String nombreImagen, Integer codigo, Double precio, String categoria, Integer descuento) {
		super();
		this.nombre = nombre;
		this.nombreImagen = nombreImagen;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
	}

	/** 
	 * METODO PARA OBTENER PRECIO CON DESCUENTO
	 * @return DEVULVE EL PRECIO CON EL DESCUENTO APLICADO
	*/
	
	public double calcularDescuento() {
		if (descuento != 0 ) {
		double resultado = Math.round((1 - descuento/100d) * precio);
			return resultado;
		} else {
			return precio;
		}
	}
	
	/** GETTERS Y SETTERS*/
	
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



	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public Integer getDescuento() {
		return descuento;
	}



	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	


}


