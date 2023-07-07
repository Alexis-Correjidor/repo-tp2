package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import jakarta.validation.constraints.Size;


@Component 
@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_id")
	private Long id;
	/**Validaciones para el nombre de un producto*/
	@NotEmpty(message = "Debe ingresar un nombre")
	@Column(name="prod_nombre")
	private String nombre;
	/**Validaciones para el nombre de imagen de un producto*/
	@NotBlank(message="Debe ingresar un nombre de imagen")
	@Size(min = 3, max= 30,message="Los nombres de imagen deben tener entre 3 y 30 caracteres" )
	@Column(name="prod_nombreImagen")
	private String nombreImagen;
	/**Validaciones para codigo de producto*/
	@NotNull(message="No puede dejar el campo codigo vacio")
	@Min(value=1, message="Debe ingresar un codigo mayor a cero")
	@Max(value = 150, message="Debe ingresar un codigo menor a 150")
	@Column(name="prod_codigo")
	private Integer codigo;
	/**Validaciones para precio de producto*/
	@NotNull(message="Debe rellenar el campo precio")
	@Positive(message="Debe ingresar valores positivos")
	@Min(value = 0,message="Debe ingresar un precio mayor a 0")
	@Column(name="prod_precio")
	private Double precio;
	@NotBlank(message="Debe ingresar una categoria")
	@Size(min = 3, max= 30,message="Los nombres deben tener entre 3 y 30 caracteres" )
	@Pattern(regexp="[a-zA-Z]+",message="Los nombres solo pueden contener letras")
	@Column(name="prod_categoria")
	private String categoria;
	@NotNull(message="Si no hay descuentos debe ingresar 0")
	@Min(value=0,message= "El valor minimo que puede ingresar es 0")
	@Max(value=50, message="El maximo de descuento que se puede aplicar es 50")
	@Column(name="prod_descuento")
	private Integer descuento;
	@Column(name="prod_estado")
	private boolean estado;
	
	/** CONSTRUCTOR POR DEFECTO */
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	/** CONSTRUCTOR SOBRECARCADO*/
	/**
	 * Captura los datos para un articulo
	 * @param id El identificador del producto
	 * @param nombre El nombre del producto
	 * @param codigo El codigo del producto
	 * @param nombreImagen  La imagen que lleva el articulo
	 * @param precio Precio del producto
	 * @param categoria La categoria del producto
	 * @param descuento Descuento del producto
	 * @param estado Estado del producto
	 */
	public Producto(Long id,String nombre,String nombreImagen, Integer codigo, Double precio, String categoria, Integer descuento, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreImagen = nombreImagen;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
		this.estado = estado;
	}

	/** 
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
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return nombreImagen Retorna nombre de la imagen del producto
	 */
	public String getNombreImagen() {
		return nombreImagen;
	}

	/**
	 * @param nombreImagen Carga el nombre de la imagen del producto
	 */
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	
	/**
	 * @return nombre Retorna nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return nombre Carga nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return codigo Retorna codigo del producto
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @return codigo Carga codigo del producto
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return precio Retorna precio del producto
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @return precio Carga precio del producto
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	/**
	 * @return categoria Retorna precio del producto
	 */
	public String getCategoria() {
		return categoria;
	}


	/**
	 * @return categoria Carga categoria del producto
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	/**
	 * @return descuento Retorna descuento del producto
	 */
	public Integer getDescuento() {
		return descuento;
	}


	/**
	 * @return descuento Carga descuento del producto
	 */
	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	/**
	 * @return estado Retorna estado del producto
	 */
	public boolean isEstado() {
		return estado;
	}
	/**
	 * @return estado Carga estado del producto
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}


