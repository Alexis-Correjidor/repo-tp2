package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.consejosSalud;


@Component
public class ListaConsejos {
	
	private List<consejosSalud> consejos; 
	
	
	public ListaConsejos() {
		consejos = new ArrayList<consejosSalud>();
		consejos.add(new consejosSalud(1L, "Consejos para pasear durante climas cálidos", "Si vives en un lugar en donde ya comienza a subir la temperatura, \r\n"
				+ "				es necesario que te prepares de distintas maneras no solo para tu bienestar, \r\n"
				+ "				sino para que puedas seguir con tu actividad física en compañía de tu mascota, \r\n"
				+ "				especialmente al aire libre. Así que te dejamos una serie de consejos y recomendaciones para que cuides del bienestar \r\n"
				+ "				de tu animal de compañía: Ofrece agua a tu mascota en todo momento, incluso aunque se la tomen cada vez que lo hagas. "
				+ "				Si ves que no lo hace, puedes llevar un bowl que conozco e incluso tomar una botella con el agua que tienes en casa. Puedes hacer uso de una sombrilla.", "Imagen: perro comiendo"));
		consejos.add(new consejosSalud(2L, "Prevenir accidentes en el hogar", "Muchos de los accidentes que nuestros perros o gatos pueden llegar a sufrir suceden en el hogar ya sea por descuido o falta de conocimiento, pero si estamos preparados para afrontarlos, la mayor parte de las veces no será grave.\r\n"
				+ "					La intoxicación es el más común, por lo que es importante que ante el primer síntoma — y mientras se llama al veterinario de urgencia — mantenga la calma e intentes identificar la causa.\r\n"
				+ "					Algo que puede ayudar es tener siempre en el botiquín un poco de carbón activado, ya que es de gran ayuda para neutralizar los productos tóxicos en el organismo.\r\n"
				+ "					Por otro lado, la Ingestión de objetos como alfileres, calcetines, plásticos pequeños, hilos, entre muchos otros, son los causantes de urgencias veterinarias, especialmente cuando las mascotas son incapaces de expulsarlos de manera natural; si este tipo de accidente compromete seriamente su vida, la cirugía se convierte en la única alternativa.\r\n"
				+ "					Los cables eléctricos también representan un gran riesgo para los animales de compañía, sobre todo para los cachorros que les encanta mordisquear todo lo que encuentran y pueden llegar a confundirlos con algún juguete, por lo que debemos tener mucho cuidado, ya que pueden enredarse o morderlos recibiendo una pequeña descarga.\r\n"
				+ "					Por esto, lo mejor es dejar desconectados todos aquellos aparatos que estén a la vista si no se están utilizando o cubrirlos con algún material que les dificulte el acceso. Recordemos que si llevamos un animal a nuestro hogar es porque estamos conscientes de que podemos garantizar su bienestar, así como un espacio seguro para que se desarrolle.", "Imagen: dos perros encima de una mesa"));
		consejos.add(new consejosSalud(3L, "Consejos para cuidar a un gato de edad avanzada", "Los gatos pueden tener una vida muy larga, usualmente son capaces de vivir más que otras mascotas, con un promedio alrededor de 12 a 18 años, si bien cada animal tiene un desarrollo distintos, al llegar alrededor de los 13 años se considera que estos necesitan cuidados geriátricos. \r\n"
				+ "						Con el paso de los años, el cuerpo, personalidad y capacidad de los felinos cambiar por lo que es necesario que los propietarios adapten sus cuidados de acuerdo a estas nuevas necesidades: Alimentación: los gatos en edad avanzada necesitan un cambio en su dieta, ya que algunos alimentos tienen una gran cantidad de fósforo lo que puede provocar padecimientos renales, además "
				+ "						de que son más propensos al sobrepeso y la obesidad, por lo que es necesario moderar sus hábitos alimenticios. Descanso: mejora su lugar de descanso, ya que a esta edad su cuerpo es más sensible, asegúrate de que este sea cómodo, en un lugar tranquilo y privado. ", "Imagen: un Gato mirando a camara"));
		
	}
	/**
	 * @return consejos Retorna la lista con los articulos de consejos de salud
	 */
	public List<consejosSalud> getConsejos() {
		return consejos;
	}
	/**
	 * @param consejos Carga la lista con los articulos de consejos de salud
	 */
	public void setConsejos(List<consejosSalud> consejos) {
		this.consejos = consejos;
	}
	
}
