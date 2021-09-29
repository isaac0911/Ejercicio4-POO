
/**
 * Modela el tipo de Enemigo2 en versión normal, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 28/09/2021
 */

public class Enemigo2 extends Combatiente{
	
	/**
	 * Instancia un objeto de la clase Enemigo2
	 * @version 28/09/2021
	 * @param tipoCombatiente Tipo de combatiente del que se trata
	 * @param nom Nombre del combatiente
	 */
	public Enemigo2(int tipoCombatiente, String nom){
		super (tipoCombatiente, nom);
	}
	
	/**
	 * Devuelve el mensaje que se muestra cuando el Enemigo2 gana.
	 * @version 28/09/2021
	 * @return Devuelve un String con el mensaje de victoria del Enemigo2
	 */
	public String MensajeVictoria(){
		String m = "-" + nombre + ": Hahaha, es tan facil ganar!";
		return m;
	}
	
	/**
	 * Devuelve el mensaje que se muestra cuando el Enemigo2 pierde.
	 * @version 28/09/2021
	 * @return Devuelve un String con el mensaje de derrota del Enemigo2
	 */
	public String MensajeDerrota(){
		String m = "-" + nombre + ": Volvere y cobrare venganza!";
		return m;
	}
	
	/**
	 * Devuelve el mensaje que dice el Enemigo2 cuando inicia la partida.
	 * @version 28/09/2021
	 * @return Devuelve el String que dice el Enemigo2 cuando la batalla comienza
	 */
	public String MensajeInicio(){
		String m = "-" + nombre + ": Ha llegado mi momento!";
		return m;
	}
	
	/**
	 * Envenena al jugador
	 * @version 28/09/2021
	 * @param Atacante Enemigo que está atacando
	 * @param Atacado Combatiente que está siendo atacado
	 * @param PoderAtaque Número de puntos que pierde el atacado
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String Envenenar (Enemigo2 Atacante, Combatiente Atacado, int PoderAtaque){
		
		//Se reduce la vida del combatiente atacado
		int nuevosPuntosDeVida = Atacado.PuntosVida - PoderAtaque;
		Atacado.PuntosVida = nuevosPuntosDeVida;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + Atacante.nombre + " enveneno a " + Atacado.nombre + " y le resto 3 puntos de vida";
		
		return mensaje;
		
	}
}