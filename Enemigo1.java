
/**
 * Modela el tipo de Enemigo1 en versión normal, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 28/09/2021
 */

public class Enemigo1 extends Combatiente{
	
	/**
	 * Instancia un objeto de la clase Enemigo1
	 * @version 28/09/2021
	 * @param tipoCombatiente Tipo de combatiente del que se trata
	 * @param nom Nombre del combatiente
	 */
	public Enemigo1(int tipoCombatiente, String nom){
		super (tipoCombatiente, nom);
	}
	
	/**
	 * Devuelve el mensaje que se muestra cuando el Enemigo1 gana.
	 * @version 28/09/2021
	 * @return Devuelve un String con el mensaje de victoria del Enemigo1
	 */
	public String MensajeVictoria(){
		String m = "-" + nombre + ": Ha, eso le llamo ganar!";
		return m;
	}
	
	/**
	 * Devuelve el mensaje que se muestra cuando el Enemigo1 pierde.
	 * @version 28/09/2021
	 * @return Devuelve un String con el mensaje de derrota del Enemigo1
	 */
	public String MensajeDerrota(){
		String m = "-" + nombre + ": No, como pude perder!";
		return m;
	}
	
	/**
	 * Devuelve el mensaje que dice el Enemigo1 cuando inicia la partida.
	 * @version 28/09/2021
	 * @return Devuelve el String que dice el Enemigo1 cuando la batalla comienza
	 */
	public String MensajeInicio(){
		String m = "-" + nombre + ": Hora de triunfar!";
		return m;
	}
	
	/**
	 * Le tira un rayo eléctrico al jugador
	 * @version 28/09/2021
	 * @param Atacante Enemigo que está atacando
	 * @param Atacado Combatiente que está siendo atacado
	 * @param PoderAtaque Número de puntos que pierde el atacado
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String TirarRayoElectrico (Enemigo1 Atacante, Combatiente Atacado, int PoderAtaque){
		
		//Se reduce la vida del combatiente atacado
		int nuevosPuntosDeVida = Atacado.PuntosVida - PoderAtaque;
		Atacado.PuntosVida = nuevosPuntosDeVida;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + Atacante.nombre + " lanzo un rayo electrico en contra de " + Atacado.nombre;
		
		return mensaje;
		
	}
	
}