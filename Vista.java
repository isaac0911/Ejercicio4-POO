import java.util.Scanner;
import java.util.ArrayList;

/**
 * Muestra mensajes en pantalla y recibe datos a través del teclado.
 * 
 * @author Isaac Solórzano Q.
 * @version 28/09/2021
 */

public class Vista{
	
	/**
	 * Muestra el mensaje de Bienvenida.
	 * @version 28/09/2021
	 */
	public void MensajeBienvenida(){
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------\nBIENVENIDO AL JUEGO: LA ULTIMA BATALLA\n-----------------------------------------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Muestra el String que recibe como parámetro.
	 * @version 28/09/2021
	 * @param mensaje Conjunto de caracteres que se deseea mostrar en pantalla.
	 */
	public void MostrarMensaje (String mensaje){
		System.out.println(mensaje);
	}
	
	/**
	 * Muestra las opciones que puede realizar el jugador y se pregunta al usuario cuál desea ejecutar.
	 * @version 28/09/2021
	 * @param nombre Nombre del combatiente cuyo turno está en curso.
	 * @return Devuelve el número que corresponde con la opción ingresada por el usuario.
	 */
	public int MostrarOpciones(String nombre){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------\nTURNO DE " + nombre.toUpperCase() + "\n\nQue desea hacer?");
		System.out.println("1. Atacar");
		System.out.println("2. Usar un item");
		System.out.println("3. Pasar turno");
		System.out.println("4. Salir");
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 4.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
	}
	
	/**
	 * Muestra las opciones que puede realizar el enemigo en version normal y se pregunta al usuario cuál desea ejecutar.
	 * @version 28/09/2021
	 * @param nombre Nombre del combatiente cuyo turno está en curso.
	 * @return Devuelve el número que corresponde con la opción ingresada por el usuario.
	 */
	public int MostrarOpcionesEnemigo (String nombre){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------------------\nTURNO DE " + nombre.toUpperCase() + "\n\nQue desea hacer?");
		System.out.println("1. Atacar");
		System.out.println("2. Usar habilidad especial");
		System.out.println("3. Pasar turno");
		System.out.println("4. Salir");
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 4.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Muestra las opciones que puede realizar el enemigo en versión jefe y se pregunta al usuario cuál desea ejecutar.
	 * @version 28/09/2021
	 * @param nombre Nombre del combatiente cuyo turno está en curso.
	 * @return Devuelve el número que corresponde con la opción ingresada por el usuario.
	 */
	public int MostrarOpcionesEnemigoJefe (String nombre){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------------------\nTURNO DE " + nombre.toUpperCase() + "\n\nQue desea hacer?");
		System.out.println("1. Atacar");
		System.out.println("2. Usar alguna habilidad especial");
		System.out.println("3. Pasar turno");
		System.out.println("4. Salir");
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 4.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Muestra las posibles víctimas del ataque y se le pregunta al usuario a cuál desea atacar.
	 * @version 28/09/2021
	 * @param Enemigos ArrayList que contiente todos los enemigos almacenados como instancias de la clase Combatiente
	 * @return Devuelve el número que corresponde con el enemigo ingresado por el usuario.
	 */
	public int PedirEnemigoAAtacar (ArrayList<Combatiente> Enemigos){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nQue enemigo desea atacar?");
		for (int i = 0; i<Enemigos.size(); i++){
			Combatiente Enemigo = Enemigos.get(i);
			System.out.println(i+1 + "\t" + Enemigo.getNombre());
		}
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>Enemigos.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + Enemigos.size() + ".");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero-1;
	}
	
	/**
	 * Muestra las posibles víctimas del doble ataque y se le pregunta al usuario a cuál desea atacar.
	 * @version 28/09/2021
	 * @param Enemigos ArrayList que contiente todos los enemigos almacenados como instancias de la clase Combatiente
	 * @return Devuelve el número que corresponde con el enemigo ingresado por el usuario.
	 */
	public int PedirEnemigoAAtacarDoble (ArrayList<Combatiente> Enemigos){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nContra que enemigo desea realizar el doble ataque?");
		for (int i = 0; i<Enemigos.size(); i++){
			Combatiente Enemigo = Enemigos.get(i);
			System.out.println(i+1 + "\t" + Enemigo.getNombre());
		}
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>Enemigos.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + Enemigos.size() + ".");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero-1;
		
	}
	
	/**
	 * Muestra los enemigos a los que se les puede lanzar una bola de fuego y se le pregunta al usuario a cuál se la desea lanzar.
	 * @version 28/09/2021
	 * @param Enemigos ArrayList que contiente todos los enemigos almacenados como instancias de la clase Combatiente
	 * @return Devuelve el número que corresponde con el enemigo ingresado por el usuario.
	 */
	public int PedirEnemigoALanzarBolaDeFuego(ArrayList<Combatiente> Enemigos){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nContra que enemigo desea lanzar la bola de fuego?");
		for (int i = 0; i<Enemigos.size(); i++){
			Combatiente Enemigo = Enemigos.get(i);
			System.out.println(i+1 + "\t" + Enemigo.getNombre());
		}
		
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>Enemigos.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + Enemigos.size() + ".");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero-1;
		
	}
	
	/**
	 * Muestra todos los items o habilidades especiales con los que cuenta el combatiente y se le pide al usaurio que ingrese el que desea aplicar.
	 * @version 28/09/2021
	 * @param mensaje String que contiene todas los items o hablidades especiales con los que cuenta el combatiente.
	 * @param numOpciones Numero de items o habilidades especiales de los que dispone el combatiente
	 * @return Devuelve el número que corresponde con el item o habilidad especial ingresada por el usuario.
	 */
	public int PedirItem(String mensaje, int numOpciones){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println(mensaje);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>numOpciones){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + numOpciones + ".");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Verifica si el valor que recibe como parámetro es un entero. Si es así, devuelve true, de lo contrario, devuelve false.
	 * @version 16/09/2021
	 * @param conjuntoCaracteres Valor del cual se verificará si es un entero o no.
	 * @return Devuelve una variable tipo boolean que indica si el parámetro recibido es un entero o no.
	 */
	private static boolean comprobarNumero(String conjuntoCaracteres){
		try{
			//Se trata de convertir el objeto de tipo String a tipo int
			Integer.parseInt(conjuntoCaracteres);
			return true;
		}
		catch (NumberFormatException nfe){
			return false;
		}
	}
}