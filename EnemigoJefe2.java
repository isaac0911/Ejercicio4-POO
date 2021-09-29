
/**
 * Modela el tipo de Enemigo2 en versión jefe, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 28/09/2021
 */

public class EnemigoJefe2 extends Enemigo2{
	
	/**
	 * Instancia un objeto de la clase EnemigoJefe2
	 * @version 28/09/2021
	 * @param tipoCombatiente Tipo de combatiente del que se trata
	 * @param nom Nombre del combatiente
	 */
	public EnemigoJefe2(int tipoCombatiente, String nom){
		super (tipoCombatiente, nom);
	}
	
	/**
	 * Devuelve el mensaje que se muestra cuando el EnemigoJefe2 gana.
	 * @version 28/09/2021
	 * @return Devuelve un String con el mensaje de victoria del EnemigoJefe2
	 */
	public String MensajeVictoria(){
		String m = "-" + nombre + ": Soy experto en ganar batallas de este tipo!";
		return m;
	}
	
	/**
	 * Devuelve el mensaje que se muestra cuando el EnemigoJefe2 pierde.
	 * @version 28/09/2021
	 * @return Devuelve un String con el mensaje de derrota del EnemigoJefe2
	 */
	public String MensajeDerrota(){
		String m = "-" + nombre + ": Ya veraz a la proxima, que hoy venia desganado!";
		return m;
	}
	
	/**
	 * Devuelve el mensaje que dice el EnemigoJefe2 cuando inicia la partida.
	 * @version 28/09/2021
	 * @return Devuelve el String que dice el EnemigoJefe2 cuando la batalla comienza
	 */
	public String MensajeInicio(){
		String m = "-" + nombre + ": Que empieze el juego!";
		return m;
	}
	
	/**
	 * Devuelve un mensaje que dice todas las habilidades especiales con las que cuenta el enemigoJefe2
	 * @version 28/09/2021
	 * @return Devuelve un String con todas las habilidades especiales
	 */
	public String MensajePedirHabEspecial(){
		
		String m = "\nQue habilidad especial desea usar: \n1.\tEnvenenar\n2.\tRegenerar parcialmente las heridas";
		return m;
	}
	
	/**
	 * Regenera parcialmente las heridas del EnemigoJefe2
	 * @version 28/09/2021
	 * @param Enemigo Enemigo que regenera sus heridas
	 * @param PoderAtaque Número de puntos que pierde el atacado
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String RegenerarHeridas(EnemigoJefe2 Enemigo, int PoderAtaque){
		
		//Se aumenta la vida del combatiente
		Enemigo.PuntosVida = Enemigo.PuntosVida+5;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + Enemigo.nombre + " regenero sus heridas y obtuvo un +5 en su vida";
		
		return mensaje;
		
	}
	
}