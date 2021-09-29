import java.util.ArrayList;
import java.util.Arrays;

/**
 * Modela un Combatiente, con sus atributos y métodos.
 * 
 * @author Isaac Solórzano Q.
 * @version 28/09/2021
 */

public class Combatiente{
	
	/**
	* Nombre del combatiente
	*/
	protected String nombre;
	
	/**
	* Puntos de Vida del combatiente
	*/
	protected int PuntosVida;
	
	/**
	* Poder de ataque del combatiente
	*/
	protected int PoderAtaque;
	
	/**
	* Tipo del combatiente
	*/
	protected String tipo;
	
	
	/**
	 * Instancia un combatiente
	 * @version 28/09/2021
	 * @param tipoCombatiente Tipo de combatiente del que se trata
	 * @param nom Nombre del combatiente
	 */
	public Combatiente (int tipoCombatiente, String nom){
		
		nombre = nom;
		
		ArrayList<String> TiposCombatientes = new ArrayList<>(Arrays.asList("Guerrero","Explorador","Enemigo1","Enemigo2", "EnemigoJefe1", "EnemigoJefe2"));
		
		if (tipoCombatiente == 1){
			//Generar un Guerrero
			PuntosVida = 10;
			PoderAtaque = 2;
		} else if (tipoCombatiente == 2){
			//Generar un Explorador
			PuntosVida = 5;
			PoderAtaque = 1;
		}else if (tipoCombatiente == 3){
			//Generar un Enemigo1
			PuntosVida = 5;
			PoderAtaque = 2;
		}else if (tipoCombatiente == 4){
			//Generar un Enemigo2
			PuntosVida = 5;
			PoderAtaque = 2;
		}else if (tipoCombatiente == 5){
			//Generar un EnemigoJefe1
			PuntosVida = 10;
			PoderAtaque = 4;
		}else if (tipoCombatiente == 6){
			//Generar un EnemigoJefe2
			PuntosVida = 10;
			PoderAtaque = 4;
		}
		
		tipo = TiposCombatientes.get(tipoCombatiente-1);
	}
	
	/**
	 * Devuelve el contenido del atributo "nombre"
	 * @version 28/09/2021
	 * @return Devuelve el nombre del combatiente
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Devuelve el contenido del atributo "Tipo"
	 * @version 28/09/2021
	 * @return Devuelve el tipo del combatiente
	 */
	public String getTipo(){
		return tipo;
	}
	
	/**
	 * Devuelve el contenido del atributo "PoderAtaque"
	 * @version 28/09/2021
	 * @return Devuelve el poder de ataque del combatiente
	 */
	public int getPoderAtaque (){
		return PoderAtaque;
	}
	
	/**
	 * Devuelve un String que contiente el estatus del combatiente
	 * @version 28/09/2021
	 * @return Devuelve un String con el estatus del combatiente
	 */
	public String toString(){
		String mensaje = "\nNombre: " + nombre +"\n\tPuntos de Vida: " + PuntosVida + "\n\tPoder de ataque: " + PoderAtaque;
		return mensaje;
	}
	
	/**
	 * Devuelve el mensaje que se muestra cuando el combatiente gana.
	 * @version 28/09/2021
	 * @return Devuelve un String con el mensaje de victoria del combatiente
	 */
	public String MensajeVictoria(){
		String m = "-" + nombre + ": Soy el mejor!";
		return m;
	}
	
	/**
	 * Devuelve el mensaje que se muestra cuando el combatiente pierde.
	 * @version 28/09/2021
	 * @return Devuelve un String con el mensaje de derrota del combatiente
	 */
	public String MensajeDerrota(){
		String m = "-" + nombre + ": Fue suerte, en la proxima les ganare!";
		return m;
	}
	
	/**
	 * Devuelve el mensaje que dice el combatiente cuando inicia la partida.
	 * @version 28/09/2021
	 * @return Devuelve el String que dice el combatiente cuando la batalla comienza
	 */
	public String MensajeInicio(){
		String m = "-" + nombre + ": A jugar!";
		return m;
	}
	
	/**
	 * Comprueba si el combatiente esta vivo
	 * @version 28/09/2021
	 * @return Devuelve true si el combatiente tiene una vida mayor a 0, de lo contrario devuelve false.
	 */
	public boolean ComprobarVivo(){
		//Se comprueba que el combatiente esté vivo, es decir, que en su atributo "PuntosVida" tenga un valor mayor a 0
		boolean v = true;
		if(PuntosVida<=0){
			v = false;
		}
		return v;
	}
	
	/**
	 * Resta determinados puntos de vida al combatiente que está siendo atacado
	 * @version 28/09/2021
	 * @param Atacante Combatiente que está atacando
	 * @param Atacado Combatiente que está siendo atacado
	 * @param PoderAtaque Número de puntos que pierde el atacado
	 * @return Devuelve un String que indica la acción que se acaba de realizar
	 */
	public String Atacar(Combatiente Atacante, Combatiente Atacado, int PoderAtaque){
		
		//Se reduce la vida del combatiente atacado
		int nuevosPuntosDeVida = Atacado.PuntosVida - PoderAtaque;
		Atacado.PuntosVida = nuevosPuntosDeVida;
		
		//Se arma el String que indica la acción realizada
		String mensaje = "\n" + Atacante.nombre + " ataco a " + Atacado.nombre;
		
		return mensaje;
	}
	
	/**
	 * Cambia el valor del atributo "PuntosVida"
	 * @version 28/09/2021
	 * @param nuevaVida Número de puntos de vida con los que contará a partir de ahora el combatiente.
	 */
	public void setPuntosVida (int nuevaVida) {
		PuntosVida = nuevaVida;
	}
}