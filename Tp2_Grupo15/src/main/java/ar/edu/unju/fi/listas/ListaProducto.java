package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Producto;

/*----registro de bean y creacion de ListaConsejos----*/
@Component
public class ListaProducto {
	private List<Producto> productos;
	
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto(1L,"Alimento Royal Canin Size Health Nutrition Mini Adult para perro adulto de raza pequeña sabor mix en bolsa de 7.5 kg","Alimento Perro", 1, 31952.73d, "Alimento", 50,true));
		productos.add(new Producto(8L,"Alimento Excellent Urinary para gato adulto sabor pollo y arroz en bolsa de 7.5 kg","AlimentoGato", 2, 13020.89d, "Alimento", 20,true));
		productos.add(new Producto(3L,"Buzo para perro","Ropa Perro", 3, 3230.75d, "Ropa", 10,true));
		productos.add(new Producto(4L,"Poncho Capa Buzo Abrigo Polar Mascotas Gatos","Ropa Gato", 4, 3790d, "Ropa", 5,true));
		productos.add(new Producto(5L,"Kong Extreme L Juguetes Rellenable Large Perros","Juguete Perro", 5, 13999.85d, "Juguete", 15,true));
		productos.add(new Producto(9L,"Cañita alambre resistente largo","Juguete Gato", 6, 898.99d, "Juguete", 10,true));
	}

	/**
	 * @return productos Retorna la lista de productos 
	 */
	public List<Producto> getProductos() {
		return productos;
	}
	/**
	 * @param List<Productos> productos Carga la lista de productos
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
