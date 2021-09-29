
/**
 * Modela un Explorador, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 28/09/2021
 */

public class Explorador extends Guerrero{
	
	/**
	* Numero de veces que se puede aplicar el item de "Lanzar bola de fuego"
	*/
	private int numBolaDeFuego;
	
	/**
	* Numero de veces que se puede aplicar el item de "Usar escudo de inmunidad"
	*/
	private int numInmunidad;
	
	/**
	* Estado que indica si el explorador está usando o no actualmente un escudo de inmunidad
	*/
	private boolean Inmunidad;
	
	/**
	 * Instancia un Explorador
	 * @version 28/09/2021
	 * @param tipoCombatiente Tipo de combatiente del que se trata
	 * @param nom Nombre del combatiente
	 */
	public Explorador(int tipoCombatiente, String nom){
		
		super (tipoCombatiente, nom);
		numBolaDeFuego = 2;
		numInmunidad = 3;
		Inmunidad = false;
		
	}
	
	/**
	 * Devuelve un String que contiente el estatus del Explorador
	 * @version 28/09/2021
	 * @return Devuelve un String con el estatus del Explorador
	 */
	public String toString(){
		
		String TieneInmunidad;
		
		//Se comprueba si tiene puesto un escudo de inmunidad
		if (Inmunidad){
			TieneInmunidad = "Si";
		}else{
			TieneInmunidad = "No";
		}
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\nNombre: " + nombre + "\n\tPuntos de Vida: " + PuntosVida + "\n\tPoder de ataque: " + PoderAtaque + "\n\tHongos para recuperar vidas disponibles: " + numRecuperarPuntosDeVida  + "\n\tDuplicadores de ataque disponibles: " + numUsarDobleAtaque + "\n\tBolas de fuego disponibles: " + numBolaDeFuego + "\n\tEscudos de inmunidad disponibles: " + numInmunidad + "\n\tTiene inmunidad:"  + TieneInmunidad;
		return mensaje;
	}
	
	/**
	 * Devuelve un String con todos los items que puede ejecutar el Explorador
	 * @version 28/09/2021
	 * @return Devuelve el String con todos los items del Explorador
	 */
	public String MensajePedirItem(){
		
		String m = "\nQue item desea ejecutar: \n1.\tInerir hongo para recuperar puntos de vida\n2.\tUsar doble ataque\n3.\tUsar bola de fuego\n4.\tUsar escudo de inmunidad";
		return m;
	}
	
	/**
	 * Devuelve el contenido del atributo "numBolaDeFuego"
	 * @version 28/09/2021
	 * @return Devuelve el número de veces que se puede ejecutar el item de lanzar bola de fuego
	 */
	public int getnumBolaDeFuego(){
		return numBolaDeFuego;
	}
	
	/**
	 * Devuelve el contenido del atributo "Inmunidad"
	 * @version 28/09/2021
	 * @return Devuelve un objeto tipo boolean que indica si el explorador tiene o no puesto un escudo de inmunidad
	 */
	public boolean getInmunidad(){
		return Inmunidad;
	}
	
	/**
	 * Devuelve el contenido del atributo "numInmunidad"
	 * @version 28/09/2021
	 * @return Devuelve el número de escudos de inmunidad que quedan disponibles
	 */
	public int getnumInmunidad(){
		return numInmunidad;
	}
	
	/**
	 * Lanza una bola de fuego al enemigo
	 * @version 28/09/2021
	 * @param Atacante Explorador que está atacando
	 * @param Atacado Combatiente que está siendo atacado
	 * @param PoderAtaque Número de puntos que pierde el atacado
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String AtacarConBolaDeFuego (Explorador Atacante, Combatiente Atacado, int PoderAtaque){
		
		//Se reduce la vida del combatiente atacado
		int nuevosPuntosDeVida = Atacado.PuntosVida - PoderAtaque;
		Atacado.PuntosVida = nuevosPuntosDeVida;
		
		//Se disminuye en uno el número de veces que puede lanzar una bola de fuego
		numBolaDeFuego--;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + Atacante.nombre + " lanzo una bola de fuego contra " + Atacado.nombre;
		
		return mensaje;
	}
	
	/**
	 * Le coloca un escudo de inmunidad al Explorador
	 * @version 28/09/2021
	 * @param Comb Explorador al que se le colocará el escudo.
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String UsarEscudoDeInmunidad (Explorador Comb){
		
		//Se disminuye en uno el número de veces que puede usar un escudo de inmunidad
		numInmunidad--;
		
		//Se le pone el escudo de inmunidad al explorador
		Inmunidad = true;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + this.nombre + " utilizo un escudo de inmunidad";
		
		return mensaje;
	}
	
	/**
	 * Cambia el valor del atributo "Inmunidad" a false
	 * @version 28/09/2021
	 */
	public void setInmunidad(){
		Inmunidad = false;
	}
	
}