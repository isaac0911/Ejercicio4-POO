
/**
 * Modela un Guerrero, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 28/09/2021
 */

public class Guerrero extends Combatiente{
	
	/**
	* Numero de veces que se puede aplicar el item de "recuperar puntos de vida"
	*/
	protected int numRecuperarPuntosDeVida;
	
	/**
	* Numero de veces que se puede aplicar el item "doble ataque"
	*/
	protected int numUsarDobleAtaque;
	
	/**
	 * Instancia un Guerrero
	 * @version 28/09/2021
	 * @param tipoCombatiente Tipo de combatiente del que se trata
	 * @param nom Nombre del combatiente
	 */
	public Guerrero(int tipoCombatiente, String nom){
		super (tipoCombatiente, nom);
		numRecuperarPuntosDeVida = 2;
		numUsarDobleAtaque = 3;
	}
	
	/**
	 * Devuelve un String que contiente el estatus del Guerrero
	 * @version 28/09/2021
	 * @return Devuelve un String con el estatus del Guerrero
	 */
	public String toString(){
		String mensaje = "\nNombre: " + nombre +"\n\tPuntos de Vida: " + PuntosVida + "\n\tPoder de ataque: " + PoderAtaque + "\n\tHongos para recuparar vidas disponibles: " + numRecuperarPuntosDeVida  + "\n\tDuplicadores de ataque disponibles: " + numUsarDobleAtaque;
		return mensaje;
	}
	
	/**
	 * Devuelve un String con todos los items que puede ejecutar el Guerrero
	 * @version 28/09/2021
	 * @return Devuelve el String con todos los items del Guerrero
	 */
	public String MensajePedirItem(){
		
		String m = "\nQue item desea ejecutar: \n1.\tInerir hongo para recuperar puntos de vida\n2.\tUsar doble ataque";
		return m;
	}
	
	/**
	 * Devuelve el contenido del atributo "numRecuperarPuntosDeVida"
	 * @version 28/09/2021
	 * @return Devuelve el número de veces que se puede aplicar el item de recuperar puntos de vida.
	 */
	public int getnumRecuperarPuntosDeVida(){
		return numRecuperarPuntosDeVida;
	}
	
	/**
	 * Devuelve el contenido del atributo "numUsarDobleAtaque"
	 * @version 28/09/2021
	 * @return Devuelve el número de veces que se puede aplicar el item de doble ataque
	 */
	public int getnumUsarDobleAtaque(){
		return numUsarDobleAtaque;
	}
	
	/**
	 * Le sube tres puntos a la vida del Guerrero
	 * @version 28/09/2021
	 * @param Comb Guerrero al que se le aumentarán los puntos de vida.
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String RecuperarPuntosDeVida(Guerrero Comb){
		
		//Se aumenta la vida del Guerrero
		int VidaNueva = Comb.PuntosVida + 3;
		Comb.PuntosVida = VidaNueva;
		
		//Se disminuye en uno el número de hongos para recuperar vida que le quedan
		numRecuperarPuntosDeVida--;
		
		//Se arma el String que indica la acción realizada
		String m = "\n" + Comb.nombre + " recupero 3 puntos de vida";
		return m;
	}
	
	/**
	 * Resta el doble de puntos de vida (de los que se restarían normalmente) al combatiente que está siendo atacado
	 * @version 28/09/2021
	 * @param Atacante Guerrero que está atacando
	 * @param Atacado Combatiente que está siendo atacado
	 * @param PoderAtaque Número de puntos que pierde el atacado
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String AtacarDoble (Guerrero Atacante, Combatiente Atacado, int PoderAtaque){
		
		//Se reduce la vida del combatiente atacado
		int nuevosPuntosDeVida = Atacado.PuntosVida - PoderAtaque;
		Atacado.PuntosVida = nuevosPuntosDeVida;
		
		//Se disminuye en uno el número de veces que puede usar un doble ataque
		numUsarDobleAtaque--;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + Atacante.nombre + " realizo un doble ataque en contra de " + Atacado.nombre;
		
		return mensaje;
	}
	
}