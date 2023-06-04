package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Producto;

@Component //Se guarda en spring container
public class ListaProducto {
	private List<Producto> productos;
	
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("Alimento Royal Canin Size Health Nutrition Mini Adult para perro adulto de raza pequeña sabor mix en bolsa de 7.5 kg","Alimento Perro", 1, 31952.73d, "Alimento", 50));
		productos.add(new Producto("Alimento Excellent Urinary para gato adulto sabor pollo y arroz en bolsa de 7.5 kg","Alimento Gato", 2, 13020.89d, "Alimento", 20));
		productos.add(new Producto("Buzo para perro","Ropa Perro", 3, 3230.75d, "Ropa", 10));
		productos.add(new Producto("Poncho Capa Buzo Abrigo Polar Mascotas Gatos","Ropa Gato", 4, 3790d, "Ropa", 5));
		productos.add(new Producto("Kong Extreme L Juguetes Rellenable Large Perros","Juguete Perro", 5, 13999.85d, "Juguete", 15));
		productos.add(new Producto("Cañita alambre resistente largo","Juguete Gato", 6, 898.99d, "Juguete", 10));
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}




}
