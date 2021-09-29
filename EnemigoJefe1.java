
/**
 * Modela el tipo de Enemigo1 en versión jefe, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 28/09/2021
 */

public class EnemigoJefe1 extends Enemigo1{
	
	/**
	 * Instancia un objeto de la clase EnemigoJefe1
	 * @version 28/09/2021
	 * @param tipoCombatiente Tipo de combatiente del que se trata
	 * @param nom Nombre del combatiente
	 */
	public EnemigoJefe1(int tipoCombatiente, String nom){
		super (tipoCombatiente, nom);
	}
	
	/**
	 * Devuelve el mensaje que se muestra cuando el EnemigoJefe1 gana.
	 * @version 28/09/2021
	 * @return Devuelve un String con el mensaje de victoria del EnemigoJefe1
	 */
	public String MensajeVictoria(){
		String m = "-" + nombre + ": Ohh yea soy el mejor!";
		return m;
	}
	
	/**
	 * Devuelve el mensaje que se muestra cuando el EnemigoJefe1 pierde.
	 * @version 28/09/2021
	 * @return Devuelve un String con el mensaje de derrota del EnemigoJefe1
	 */
	public String MensajeDerrota(){
		String m = "-" + nombre + ": Fue pura suerte!";
		return m;
	}
	
	/**
	 * Devuelve el mensaje que dice el EnemigoJefe1 cuando inicia la partida.
	 * @version 28/09/2021
	 * @return Devuelve el String que dice el EnemigoJefe1 cuando la batalla comienza
	 */
	public String MensajeInicio(){
		String m = "-" + nombre + ": Alla vamos!";
		return m;
	}
	
	/**
	 * Devuelve un mensaje que dice todas las habilidades especiales con las que cuenta el enemigoJefe1
	 * @version 28/09/2021
	 * @return Devuelve un String con todas las habilidades especiales
	 */
	public String MensajePedirHabEspecial(){
		
		String m = "\nQue habilidad especial desea usar: \n1.\tTirar rayo electrico\n2.\tLanzar ataque de flechas";
		return m;
	}
	
	/**
	 * Lanza un ataque de flechas en contra del jugador
	 * @version 28/09/2021
	 * @param Atacante Enemigo que está atacando
	 * @param Atacado Combatiente que está siendo atacado
	 * @param PoderAtaque Número de puntos que pierde el atacado
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String LanzarAtaqueDeFlechas (EnemigoJefe1 Atacante, Combatiente Atacado, int PoderAtaque){
		
		//Se reduce la vida del combatiente atacado
		int nuevosPuntosDeVida = Atacado.PuntosVida - PoderAtaque;
		Atacado.PuntosVida = nuevosPuntosDeVida;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + Atacante.nombre + " efectuo un ataque de flechas en contra de " + Atacado.nombre;
		
		return mensaje;
		
	}
	
}