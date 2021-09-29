import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Comunica a la Vista con el Modelo y viceversa.
 * 
 * @author Isaac Solórzano Q.
 * @version 28/09/2021
 */
 
public class Controlador{
	
	private Vista v;
	private ArrayList<String> UltimasTresAcciones;
	
	/**
	 * Instancia un objeto de tipo Controlador.
	 * @version 28/09/2021
	 */
	public Controlador(){
		v = new Vista();
		UltimasTresAcciones = new ArrayList<String>();
	}
	
	/**
	 * Es uno de los métodos principales. Crea al jugador y a los enemigos. Además, manda a ejecutar el metodo "MetodoGeneral"
	 * @version 28/09/2021
	 */
	public void ciclo(){
		v.MensajeBienvenida();
		
		ArrayList<String> ListaNombres = new ArrayList<>(Arrays.asList("Goku","Bulbasaur","Ivysaur","Venusaur"));
		
		//Generar un jugador
		String mensaje = "\nGENERANDO JUGADOR...";
		v.MostrarMensaje(mensaje);
		
		String nombre = ListaNombres.get(0);
		ListaNombres.remove(0);
		
		int tipoJugador = -1;
		Random rand = new Random();
		
		Combatiente Juga = new Combatiente (1, "a");
		float numAleatorio = rand.nextFloat();
		if (numAleatorio<=0.5){
			Juga = new Guerrero(1, nombre);
		}else{
			Juga = new Explorador(2, nombre);
		}
		
		mensaje = "\nLos dato del jugador son: ";
		v.MostrarMensaje(mensaje);
		mensaje = Juga.toString();
		v.MostrarMensaje(mensaje);
		
		//Generar enemigos
		mensaje = "\nGENERANDO ENEMIGOS...";
		v.MostrarMensaje(mensaje);
		
		ArrayList<Combatiente> Enemigos = new ArrayList<Combatiente>();
		
		int numEnemigos = (int)(Math.random()*(3-1+1)+1);
		
		Combatiente Enemigo = new Combatiente (1, "a");
		for (int i=0; i<numEnemigos; i++){
			
			int tipoEnemigo = (int)(Math.random()*(6-3+1)+3);
			nombre = ListaNombres.get(0);
			ListaNombres.remove(0);
			
			if(tipoEnemigo == 3){
				Enemigo = new Enemigo1(tipoEnemigo, nombre);
			}else if(tipoEnemigo == 4){
				Enemigo = new Enemigo2(tipoEnemigo, nombre);
			}else if(tipoEnemigo == 5){
				Enemigo = new EnemigoJefe1(tipoEnemigo, nombre);
			}else{
				Enemigo = new EnemigoJefe2(tipoEnemigo, nombre);
			}
			
			Enemigos.add(Enemigo);
		}
		
		mensaje = "\nSe han generado " + Enemigos.size() + " enemigos. Sus datos son:";
		v.MostrarMensaje(mensaje);
		
		for (int i = 0; i<Enemigos.size(); i++){
			Combatiente enemigo = Enemigos.get(i);
			mensaje = enemigo.toString();
			v.MostrarMensaje(mensaje);
		}
		
		//Mostrar mensajes de los jugadores al iniciar la batalla
		mensaje = ("\n-----------------------------------------------------------------------------------------------------------------------------------");
		v.MostrarMensaje(mensaje);
		
		mensaje = Juga.MensajeInicio();
		v.MostrarMensaje(mensaje);
		
		for (int i=0; i<Enemigos.size(); i++){
			Combatiente enemigo = Enemigos.get(i);
			mensaje = enemigo.MensajeInicio();
			v.MostrarMensaje(mensaje);
		}
		
		mensaje = ("-----------------------------------------------------------------------------------------------------------------------------------");
		
		//Mostrar mensaje de bienvenida a la batalla
		mensaje = ("-----------------------------------------------------------------------------------------------------------------------------------\n\nQUE COMIENZE LA BATALLA!!");
		v.MostrarMensaje(mensaje);
		
		
		CicloGeneral(Juga, Enemigos);
	}
	
	/**
	 * Contiene el ciclo en el que se mantendrá el flujo del programa hasta que el usuario decida salir.
	 * @version 28/09/2021
	 * @param Juga Representa al jugador.
	 * @param Enemigos Es un arrayList que contiene a todos los enemigos almacenados como instancias de Combatiente.
	 */
	private void CicloGeneral(Combatiente Juga, ArrayList<Combatiente> Enemigos){
		
		ArrayList<Combatiente> Combatientes = new ArrayList<Combatiente>();
		Combatientes.add(Juga);
		
		//Se crear un arraylist con todos los combatientes
		for (int i=0; i<Enemigos.size(); i++){
			Combatientes.add(Enemigos.get(i));
		}
		
		boolean validacion = true;
		String s = "NO";
		
		int posicion = -1;
		
		//Ciclo principal del sistema
		while (validacion && s != "Salir"){
			
			posicion++;
			
			if(posicion>=Combatientes.size()){
				posicion = 0;
			}
			
			Combatiente Comb = Combatientes.get(posicion);
			
			Turno(Comb, Combatientes);
			
			s = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
			UltimasTresAcciones.remove(UltimasTresAcciones.size()-1);
			
			if (s != "Salir"){
				MandarAMostrarEstadoJugadores(Combatientes);
				if(UltimasTresAcciones.size()>0){
					MandarAMostrarUltimasTresAcciones(UltimasTresAcciones);
				}
			}
			
			validacion = validarTodosEstanVivos(Juga, Enemigos);
		}
		
		if(s == "Salir"){
			String mensaje = "\n-----------------------------------------------------------------------------------------------------------------------------------\nGraciar por jugar. Feliz dia.\n-----------------------------------------------------------------------------------------------------------------------------------\n";
			v.MostrarMensaje(mensaje);
		}else{
			MostrarAlGanador(Combatientes);
		}
		
		
	}
	
	/**
	 * Manda a mostrar el status de cada jugador al inicio de cada turno
	 * @version 28/09/2021
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void MandarAMostrarEstadoJugadores(ArrayList<Combatiente> Combatientes){
		
		String mensaje = "\n*****************************************************\n\nEl nuevo estatus de cada competidor es el siguiente: ";
		v.MostrarMensaje(mensaje);
		//Se muestra el status de cada combatiente
		for(int i = 0; i<Combatientes.size(); i++){
			Combatiente Comb = Combatientes.get(i);
			mensaje = Comb.toString();
			v.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Manda a mostrar las ultimas tres acciones que han sido tomadas en el juego
	 * @version 28/09/2021
	 * @param UltimasTresAcciones ArrayList que contiene, redactadas en formato String, las tres ultimas acciones que han sido tomadas
	 */
	private void MandarAMostrarUltimasTresAcciones(ArrayList<String> UltimasTresAcciones){
		
		String mensaje = "\n*****************************************************\n\nLas ultimas acciones que han sido tomadas en el juego, desde la mas antigua a la mas reciente, son las siguientes: ";
		v.MostrarMensaje(mensaje);
		
		//Se asegura que solo se vayan a mostrar, como máximo, tres acciones
		while (UltimasTresAcciones.size()>3){
			UltimasTresAcciones.remove(0);
		}
		
		//Se muestran las últimas acciones ejecutadas
		for (int i = 0; i<UltimasTresAcciones.size();i++){
			mensaje = UltimasTresAcciones.get(i);
			mensaje = "-\t" + mensaje.substring(1, mensaje.length());
			v.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Verifica que todos los combatientes tengan una vida superior a 0. De ser así, devuelve true, de lo contrario, devuelve false.
	 * @version 28/09/2021
	 * @param Juga Representa al jugador.
	 * @param Enemigos Es un arrayList que contiene a todos los enemigos almacenados como instancias de Combatiente.
	 * @return Devuelve una variable tipo boolean que indica si todos los combatientes siguen vivos o si alguno ya murió.
	 */
	private boolean validarTodosEstanVivos(Combatiente Juga, ArrayList<Combatiente> Enemigos){
		
		boolean validacion = true;
		
		//Se comprueba que el jugador esté vivo
		if (!Juga.ComprobarVivo()){
			validacion = false;
		}
		
		//Se comprueba que los enemigos estén vivos
		for (int i=0; i<Enemigos.size(); i++){
			Combatiente enemigo = Enemigos.get(i);
			if(!enemigo.ComprobarVivo()){
				validacion = false;
			}
		}
		
		return validacion;
	}
	
	/**
	 * Manda a mostrar en pantalla quién ganó y los mensajes de Victoria o Derrota de cada combatiente, según sea el caso.
	 * @version 28/09/2021
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void MostrarAlGanador(ArrayList<Combatiente> Combatientes){
		String Ganador = "Enemigos";
		
		//Comprobar si el que gano fue el jugador
		Combatiente comb = Combatientes.get(0);
		if (comb.ComprobarVivo()){
			Ganador = "Jugador";
		}
		
		//Mandar a mostrar mensaje de quien fue el ganador
		if (Ganador == "Jugador"){
			String mensaje = "\n-----------------------------------------------------------------------------------------------------------------------------------\nEL GANADOR ES: " + comb.getNombre() + "!!!\n-----------------------------------------------------------------------------------------------------------------------------------\n";
			v.MostrarMensaje(mensaje);
			//Mostrar los mensajes de victoria y derrota de cada combatiente
			mensaje = comb.MensajeVictoria();
			v.MostrarMensaje(mensaje);
			for (int i=1; i<Combatientes.size(); i++){
				comb = Combatientes.get(i);
				mensaje = comb.MensajeDerrota();
				v.MostrarMensaje(mensaje);
			}
			mensaje = "-----------------------------------------------------------------------------------------------------------------------------------\n";
			v.MostrarMensaje(mensaje);
		}else if(Ganador == "Enemigos"){
			String mensaje = "\n-----------------------------------------------------------------------------------------------------------------------------------\nGANARON LOS ENEMIGOS!!!\n-----------------------------------------------------------------------------------------------------------------------------------n";
			v.MostrarMensaje(mensaje);
			//Mostrar los mensajes de victoria y derrota de cada combatiente
			mensaje = comb.MensajeDerrota();
			v.MostrarMensaje(mensaje);
			for (int i=1; i<Combatientes.size(); i++){
				comb = Combatientes.get(i);
				mensaje = comb.MensajeVictoria();
				v.MostrarMensaje(mensaje);
			}
			mensaje = "-----------------------------------------------------------------------------------------------------------------------------------\n";
			v.MostrarMensaje(mensaje);
		}
	}
	
	/**
	 * Evalua el tipo de Combatiente cuyo turno está en curso y manda a ejecutar el método correspondiente.
	 * @version 28/09/2021
	 * @param Comb Combatiente cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void Turno(Combatiente Comb, ArrayList<Combatiente> Combatientes){
		
		String TipoCombatiente = Comb.getTipo();
		
		//Se mandan a ejecutar distintos métodos en función del tipo de combatiente
		if (TipoCombatiente == "Guerrero"){
			Guerrero Combat = (Guerrero) Comb;
			TurnoGuerrero(Combat, Combatientes);
		}else if (TipoCombatiente == "Explorador"){
			Explorador Combat = (Explorador) Comb;
			TurnoExplorador(Combat, Combatientes);
		}else if (TipoCombatiente == "Enemigo1"){
			Enemigo1 Combat = (Enemigo1) Comb;
			TurnoEnemigo1(Combat, Combatientes);
		}else if (TipoCombatiente == "Enemigo2"){
			Enemigo2 Combat = (Enemigo2) Comb;
			TurnoEnemigo2(Combat, Combatientes);
		}else if (TipoCombatiente == "EnemigoJefe1"){
			EnemigoJefe1 Combat = (EnemigoJefe1) Comb;
			TurnoEnemigoJefe1(Combat, Combatientes);
		}else if (TipoCombatiente == "EnemigoJefe2"){
			EnemigoJefe2 Combat = (EnemigoJefe2) Comb;
			TurnoEnemigoJefe2(Combat, Combatientes);
		}
		
	}
	
	/**
	 * Manda a preguntar qué acción desea hacer el guerrero y ejecuta los métodos corresponditenes con la acción deseada.
	 * @version 28/09/2021
	 * @param Comb Guerrero cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void TurnoGuerrero(Guerrero Comb, ArrayList<Combatiente> Combatientes){
		
		String nombre = Comb.getNombre();
		
		//Se manda a pedir la opcion a ejecutar
		int opcion = v.MostrarOpciones(nombre);
		
		String s = "o";
		if (opcion == 4){
			s = "Salir";
		}
		
		
		if (opcion == 1){
			//Si desea atacar
			DatosDeAtaqueHaciaEnemigos(Comb, Combatientes);
			String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
			v.MostrarMensaje(mensaje);
		}else if(opcion == 2){
			//Si desea usar item
			String mensaje = Comb.MensajePedirItem();
			//Se manda a preguntar qué item desea ejecutar
			int numItem = v.PedirItem(mensaje, 2);
			
			if (numItem == 1){
				//Si desea aumentar puntos de vida
				if (Comb.getnumRecuperarPuntosDeVida()>0){
					String accion = Comb.RecuperarPuntosDeVida(Comb);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Comb.getNombre() + " ya no cuenta con hongos para recuperar vidas.";
					v.MostrarMensaje(mensaje);
				}
			}else if(numItem == 2){
				//Si desea realizar un doble ataque
				if (Comb.getnumRecuperarPuntosDeVida()>0){
					String accion = DatosDobleAtaque(Comb, Combatientes);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Comb.getNombre() + " ha realizado todos los ataques dobles con lo que contaba.";
					v.MostrarMensaje(mensaje);
				}
			}
		}
		
		
		UltimasTresAcciones.add(s);
	}
	
	/**
	 * Manda a preguntar a qué combatiente se desea atacar y se manda a ejecutar el método Atacar de la clase Combatiente.
	 * @version 28/09/2021
	 * @param Comb Combatiente cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void DatosDeAtaqueHaciaEnemigos (Combatiente Comb, ArrayList<Combatiente> Combatientes){
		
		//Se crea un arraylist donde estén solo los enemigos
		ArrayList<Combatiente> Enemigos = new ArrayList<Combatiente>();
		for(int i=1; i<Combatientes.size(); i++){
			Enemigos.add(Combatientes.get(i));
		}
		
		//Se manda a pregunta qué enemigo desea atacar
		int posEnemigoAAtacar = v.PedirEnemigoAAtacar(Enemigos);
		
		//Se obtiene el enemigo a atatcar
		Combatiente EnemigoAAtacar = Enemigos.get(posEnemigoAAtacar);
		
		//Se obtiene el poder del ataque
		int PoderDeAtaque = Comb.getPoderAtaque();
		
		//Se ataca
		String accion = Comb.Atacar(Comb, EnemigoAAtacar, PoderDeAtaque);
		
		//Se actualiza la lista de las últimas acciones realizadas
		UltimasTresAcciones.add(accion);
	}
	
	/**
	 * Manda a preguntar a qué enemigo se le desea aplicar un doble ataque y manda a ejecutar el método "AtacarDoble" de la clase Guerrero.
	 * @version 28/09/2021
	 * @param Comb Combatiente cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 * @return Devuelve el String con la descripción de la acción realizada.
	 */
	private String DatosDobleAtaque (Combatiente Comb, ArrayList<Combatiente> Combatientes){
		
		//Se crea un arraylist donde estén solo los enemigos
		ArrayList<Combatiente> Enemigos = new ArrayList<Combatiente>();
		for(int i=1; i<Combatientes.size(); i++){
			Enemigos.add(Combatientes.get(i));
		}
		
		//Se manda a pregunta qué enemigo desea atacar
		int posEnemigoAAtacar = v.PedirEnemigoAAtacarDoble(Enemigos);
		
		//Se obtiene el enemigo a atatcar
		Combatiente EnemigoAAtacar = Enemigos.get(posEnemigoAAtacar);
		
		//Se obtiene el poder del ataque
		int PoderDeAtaque = 2*Comb.getPoderAtaque();
		
		//Se ataca
		Guerrero Combat = (Guerrero) Comb;
		String accion = Combat.AtacarDoble(Combat, EnemigoAAtacar, PoderDeAtaque);
		
		return accion;
	}
	
	/**
	 * Manda a preguntar qué acción desea hacer el explorador y ejecuta los métodos corresponditenes con la acción deseada.
	 * @version 28/09/2021
	 * @param Comb Explorador cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void TurnoExplorador(Explorador Comb, ArrayList<Combatiente> Combatientes){
		
		String nombre = Comb.getNombre();
		
		//Se manda a pedir la opcion a ejecutar
		int opcion = v.MostrarOpciones(nombre);
		
		String s = "o";
		if (opcion == 4){
			s = "Salir";
		}
		
		if (opcion == 1){
			//Si desea atacar
			DatosDeAtaqueHaciaEnemigos(Comb, Combatientes);
			String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
			v.MostrarMensaje(mensaje);
		}else if(opcion == 2){
			//Si desea ejecutar algun item
			String mensaje = Comb.MensajePedirItem();
			int numItem = v.PedirItem(mensaje, 4);
			if (numItem == 1){
				//Si desea recuperar puntos de vida
				if (Comb.getnumRecuperarPuntosDeVida()>0){
					String accion = Comb.RecuperarPuntosDeVida(Comb);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Comb.getNombre() + " ya no cuenta con hongos para recuperar vidas.";
					v.MostrarMensaje(mensaje);
				}
			}else if(numItem == 2){
				//Si desea realizar un doble ataque
				if (Comb.getnumRecuperarPuntosDeVida()>0){
					String accion = DatosDobleAtaque(Comb, Combatientes);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Comb.getNombre() + " ha realizado todos los ataques dobles con lo que contaba.";
					v.MostrarMensaje(mensaje);
				}
			}else if(numItem == 3){
				//Si desea lanzar una bola de fuego
				if (Comb.getnumBolaDeFuego()>0){
					String accion = DatosBolaDeFuego(Comb, Combatientes);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Comb.getNombre() + " se ha gastado todas sus bolas de fuego.";
					v.MostrarMensaje(mensaje);
				}
			}else if(numItem == 4){
				//Si desea usar un escudo de inmunidad
				if (Comb.getnumInmunidad()>0){
					String accion = Comb.UsarEscudoDeInmunidad(Comb);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede realizar esta accion. " + Comb.getNombre() + " ya ha utilizado todos sus escudos de inmunidad.";
					v.MostrarMensaje(mensaje);
				}
			}
		}
		
		UltimasTresAcciones.add(s);
		
	}
	
	/**
	 * Manda a preguntar a qué enemigo se le desea lanzar una bola de juego y manda a ejecutar el método "AtacarConBolaDeFuego" de la clase Explorador.
	 * @version 28/09/2021
	 * @param Comb Combatiente cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 * @return Devuelve el String con la descripción de la acción realizada.
	 */
	private String DatosBolaDeFuego (Explorador Comb, ArrayList<Combatiente> Combatientes){
		
		//Se crea un arraylist donde estén solo los enemigos
		ArrayList<Combatiente> Enemigos = new ArrayList<Combatiente>();
		for(int i=1; i<Combatientes.size(); i++){
			Enemigos.add(Combatientes.get(i));
		}
		
		//Se manda a pregunta a qué enemigo se le desea lanzar la bola de fuego
		int posEnemigoAAtacar = v.PedirEnemigoALanzarBolaDeFuego(Enemigos);
		
		//Se obtiene el enemigo a atatcar
		Combatiente EnemigoAAtacar = Enemigos.get(posEnemigoAAtacar);
		
		int PoderDeAtaque = 3;
		
		//Se manda a lanzar la bola de fuego
		String accion = Comb.AtacarConBolaDeFuego(Comb, EnemigoAAtacar, PoderDeAtaque);
		
		return accion;
	}
	
	/**
	 * Manda a preguntar qué acción desea hacer el combatiente de tipo Enemigo1, y ejecuta los métodos corresponditenes con la acción deseada.
	 * @version 28/09/2021
	 * @param Comb Enemigo cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void TurnoEnemigo1(Enemigo1 Comb, ArrayList<Combatiente> Combatientes){
		
		String nombre = Comb.getNombre();
		
		//Se manda a pedir la opcion a ejecutar
		int opcion = v.MostrarOpcionesEnemigo(nombre);
		
		String s = "o";
		if (opcion == 4){
			s = "Salir";
		}
		
		//Se comprueba si el jugador tiene un escudo de inmunidad
		boolean escudo = false;
		Combatiente Jugador = Combatientes.get(0);
		boolean EsExplorador = ComprobarSiJugadorEsExplorador(Jugador);
		if (EsExplorador){
			Explorador Ex = (Explorador) Jugador;
			escudo = Ex.getInmunidad();
		}
		
		if (opcion == 1){
			//Si desea atacar
			if (!escudo){
				DatosDeAtaqueHaciaJugadorDesdeEnemigo1(Comb, Combatientes);
				String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
				v.MostrarMensaje(mensaje);
			}else{
				String mensaje = "\nNo se puede realizar el ataque porque " + Jugador.getNombre() + " tiene escudo de inmunidad";
				v.MostrarMensaje(mensaje);
				Explorador Ex = (Explorador) Jugador;
				Ex.setInmunidad();
			}
		}else if(opcion == 2){
			//Si desea usar la habilidad especial
			if (!escudo){
				String accion = Comb.TirarRayoElectrico(Comb, Combatientes.get(0), 3);
				UltimasTresAcciones.add(accion);
				v.MostrarMensaje(accion);
			}else{
				String mensaje = "\nNo se puede utilizar la habilidad especial porque " + Jugador.getNombre() + " tiene escudo de inmunidad";
				v.MostrarMensaje(mensaje);
				Explorador Ex = (Explorador) Jugador;
				Ex.setInmunidad();
			}
		}
		
		//Se actualiza la lista de las últimas tres acciones
		UltimasTresAcciones.add(s);
		
	}
	
	/**
	 * Manda a ejecutar el método "Atacar" de la clase Combatiente y agrega a UltimasTresAcciones un String con la descipción de la acción realizada.
	 * @version 28/09/2021
	 * @param Comb Enemigo cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void DatosDeAtaqueHaciaJugadorDesdeEnemigo1 (Enemigo1 Comb, ArrayList<Combatiente> Combatientes){
		
		//Se obtiene el poder de ataque
		int PoderDeAtaque = Comb.getPoderAtaque();
		
		//Se ataca
		String accion = Comb.Atacar(Comb, Combatientes.get(0), PoderDeAtaque);
		
		//Se actualiza la lista de las últimas tres acciones
		UltimasTresAcciones.add(accion);
	}
	
	/**
	 * Manda a preguntar qué acción desea hacer el combatiente de tipo Enemigo2, y ejecuta los métodos corresponditenes con la acción deseada.
	 * @version 28/09/2021
	 * @param Comb Enemigo cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void TurnoEnemigo2(Enemigo2 Comb, ArrayList<Combatiente> Combatientes){
		
		String nombre = Comb.getNombre();
		
		//Se manda a pedir la opcion a ejecutar
		int opcion = v.MostrarOpcionesEnemigo(nombre);
		
		String s = "o";
		if (opcion == 4){
			s = "Salir";
		}
		
		//Se comprueba si el jugador tiene un escudo de inmunidad
		boolean escudo = false;
		Combatiente Jugador = Combatientes.get(0);
		boolean EsExplorador = ComprobarSiJugadorEsExplorador(Jugador);
		if (EsExplorador){
			Explorador Ex = (Explorador) Jugador;
			escudo = Ex.getInmunidad();
		}
		
		if (opcion == 1){
			//Si desea atacar
			if (!escudo){
				DatosDeAtaqueHaciaJugadorDesdeEnemigo2(Comb, Combatientes);
				String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
				v.MostrarMensaje(mensaje);
			}else{
				String mensaje = "\nNo se puede realizar el ataque porque " + Jugador.getNombre() + " tiene escudo de inmunidad";
				v.MostrarMensaje(mensaje);
				Explorador Ex = (Explorador) Jugador;
				Ex.setInmunidad();
			}
		}else if(opcion == 2){
			//Si desea usar la habilidad especial
			if (!escudo){
				String accion = Comb.Envenenar(Comb, Combatientes.get(0), 3);
				UltimasTresAcciones.add(accion);
				v.MostrarMensaje(accion);
			}else{
				String mensaje = "\nNo se puede utilizar la habilidad especial porque " + Jugador.getNombre() + " tiene escudo de inmunidad";
				v.MostrarMensaje(mensaje);
				Explorador Ex = (Explorador) Jugador;
				Ex.setInmunidad();
			}
		}
		
		//Se actualiza la lista de las últimas tres acciones
		UltimasTresAcciones.add(s);
		
	}
	
	/**
	 * Manda a ejecutar el método "Atacar" de la clase Combatiente y agrega a UltimasTresAcciones un String con la descipción de la acción realizada.
	 * @version 28/09/2021
	 * @param Comb Enemigo cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void DatosDeAtaqueHaciaJugadorDesdeEnemigo2 (Enemigo2 Comb, ArrayList<Combatiente> Combatientes){
		
		//Se obtiene el poder de ataque
		int PoderDeAtaque = Comb.getPoderAtaque();
		
		//Se ataca
		String accion = Comb.Atacar(Comb, Combatientes.get(0), PoderDeAtaque);
		
		//Se actualiza la lista de las últimas tres acciones
		UltimasTresAcciones.add(accion);
	}
	
	/**
	 * Manda a preguntar qué acción desea hacer el combatiente de tipo EnemigoJefe1, y ejecuta los métodos corresponditenes con la acción deseada.
	 * @version 28/09/2021
	 * @param Comb Enemigo cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void TurnoEnemigoJefe1(EnemigoJefe1 Comb, ArrayList<Combatiente> Combatientes){
		
		String nombre = Comb.getNombre();
		
		//Se manda a pedir la opcion a ejecutar
		int opcion = v.MostrarOpcionesEnemigoJefe(nombre);
		
		String s = "o";
		if (opcion == 4){
			s = "Salir";
		}
		
		//Se comprueba si el jugador tiene un escudo de inmunidad
		boolean escudo = false;
		Combatiente Jugador = Combatientes.get(0);
		boolean EsExplorador = ComprobarSiJugadorEsExplorador(Jugador);
		if (EsExplorador){
			Explorador Ex = (Explorador) Jugador;
			escudo = Ex.getInmunidad();
		}
		
		if (opcion == 1){
			if (!escudo){
				//Si desea atacar
				DatosDeAtaqueHaciaJugadorDesdeEnemigo1(Comb, Combatientes);
				String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
				v.MostrarMensaje(mensaje);
			}else{
				String mensaje = "\nNo se puede realizar el ataque porque " + Jugador.getNombre() + " tiene escudo de inmunidad";
				v.MostrarMensaje(mensaje);
				Explorador Ex = (Explorador) Jugador;
				Ex.setInmunidad();
			}
		}else if(opcion == 2){
			
			//Si desea usar una habilidad especial
			
			String mensaje = Comb.MensajePedirHabEspecial();
			int numHabEsp = v.PedirItem(mensaje, 2);
			
			if (numHabEsp == 1){
				//Si desea tirar un rayo electrico
				if (!escudo){
					String accion = Comb.TirarRayoElectrico(Comb, Combatientes.get(0), 5);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede utilizar la habilidad especial porque " + Jugador.getNombre() + " tiene escudo de inmunidad";
					v.MostrarMensaje(mensaje);
					Explorador Ex = (Explorador) Jugador;
					Ex.setInmunidad();
				}
			}else if(numHabEsp == 2){
				//Si desea lanzar un ataque de flechas
				if (!escudo){
					String accion = Comb.LanzarAtaqueDeFlechas(Comb, Combatientes.get(0), 5);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede utilizar la habilidad especial porque " + Jugador.getNombre() + " tiene escudo de inmunidad";
					v.MostrarMensaje(mensaje);
					Explorador Ex = (Explorador) Jugador;
					Ex.setInmunidad();
				}
			}
		}
		
		UltimasTresAcciones.add(s);
	}
	
	/**
	 * Manda a preguntar qué acción desea hacer el combatiente de tipo EnemigoJefe2, y ejecuta los métodos corresponditenes con la acción deseada.
	 * @version 28/09/2021
	 * @param Comb Enemigo cuyo turno está en curso.
	 * @param Combatientes ArrayList que contiene a todos los combatientes, tanto al jugador como a los enemigos.
	 */
	private void TurnoEnemigoJefe2(EnemigoJefe2 Comb, ArrayList<Combatiente> Combatientes){
		
		String nombre = Comb.getNombre();
		
		//Se manda a pedir la opcion a ejecutar
		int opcion = v.MostrarOpcionesEnemigoJefe(nombre);
		
		String s = "o";
		if (opcion == 4){
			s = "Salir";
		}
		
		//Se comprueba si el jugador tiene un escudo de inmunidad
		boolean escudo = false;
		Combatiente Jugador = Combatientes.get(0);
		boolean EsExplorador = ComprobarSiJugadorEsExplorador(Jugador);
		if (EsExplorador){
			Explorador Ex = (Explorador) Jugador;
			escudo = Ex.getInmunidad();
		}
		
		if (opcion == 1){
			//Si desea atacar
			if (!escudo){
				DatosDeAtaqueHaciaJugadorDesdeEnemigo2(Comb, Combatientes);
				String mensaje = UltimasTresAcciones.get(UltimasTresAcciones.size()-1);
				v.MostrarMensaje(mensaje);
			}else{
				String mensaje = "\nNo se puede realizar el ataque porque " + Jugador.getNombre() + " tiene escudo de inmunidad";
				v.MostrarMensaje(mensaje);
				Explorador Ex = (Explorador) Jugador;
				Ex.setInmunidad();
			}
		}else if(opcion == 2){
			
			//Si desea utilizar una habilidad especial
			String mensaje = Comb.MensajePedirHabEspecial();
			int numHabEsp = v.PedirItem(mensaje, 2);
			
			if (numHabEsp == 1){
				//Si desea envenenar
				if (!escudo){
					String accion = Comb.Envenenar(Comb, Combatientes.get(0), 5);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede utilizar la habilidad especial porque " + Jugador.getNombre() + " tiene escudo de inmunidad";
					v.MostrarMensaje(mensaje);
					Explorador Ex = (Explorador) Jugador;
					Ex.setInmunidad();
				}
			}else if(numHabEsp == 2){
				//Si desea regenerar sus heridas
				if (!escudo){
					String accion = Comb.RegenerarHeridas(Comb, 5);
					UltimasTresAcciones.add(accion);
					v.MostrarMensaje(accion);
				}else{
					mensaje = "\nNo se puede utilizar la habilidad especial porque " + Jugador.getNombre() + " tiene escudo de inmunidad";
					v.MostrarMensaje(mensaje);
					Explorador Ex = (Explorador) Jugador;
					Ex.setInmunidad();
				}
			}
		}
		
		UltimasTresAcciones.add(s);
	}
	
	/**
	 * Comprueba si la instancia de Combatiente que recibe como parámetro es de tipo Explorador.
	 * @version 28/09/2021
	 * @param Jugador Jugador del cual se desea saber si es de tipo Explorador
	 * @return Devuelve true si el Combatiente es Explorador; de lo contrario, devuelve false.
	 */
	private boolean ComprobarSiJugadorEsExplorador (Combatiente Jugador){
		try{
			//Trata de convertir el objeto de tipo Combatiente a tipo Explorador
			Explorador Ex = (Explorador) Jugador;
			return true;
		}catch(Exception e){
			return false;
		}
	}
}