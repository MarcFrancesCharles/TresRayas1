/*Programar el juego "tres en raya" en java donde dos jugadores irán posicionando sus piezas en un tablero con 9 casillas que forman un cuadrado de 3x3.
 *  Para esto hará falta usar matrices.
Reglas del juego:
El juego preguntará los nombres del jugador 1 y del jugador 2.
Se lanzará una "moneda" (se escoge aleatoriamente) para elegir quien empezara primero, el jugador 1 o el jugador 2.
Los dos jugadores irán poniendo las fichas hasta que:
Uno de los dos jugadores haya conseguido poner 3 fichas en línea, ya sea horizontalmente, verticalmente o diagonalmente.
Haya un empate debido a que no quedan mas huecos libres en el tablero.
Cuando termina el juego se preguntara si quieren echar la revancha o finalizar el juego.
Instrucciones:

Hay que dejar bien claro a que jugador le toca poner ficha.
Cada vez que un jugador ponga una ficha mostraremos que posiciones siguen vacías y cuales están ocupadas
Si el jugador intenta poner ficha donde ya hay una puesta, saldrá un mensaje de error y le pedirá que la ponga en otra parte.
Cuando un jugador gana saldrá el nombre del ganador.
Con que un solo jugador no quiera la revancha valdrá para terminar el juego*/
package PackageTresRAYAS ;
import java.util.*;
public class JOC {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); //Creem Scanner
		 Scanner enter = new Scanner(System.in);// Scanner unic per al Enter de tirar moneda.
		String jugador1; //Jugador1 
		String jugador2; //Jugador2
		String[] moneda = new String[] {"cara", "creu"}; //Crem String moneda amb les 2 opcions
		Random r = new Random(); //Random per a que sorti resultat moneda
		String resultatmoneda; // Guardem resultat moneda
		resultatmoneda = moneda[r.nextInt(moneda.length)]; // Fem que la moneda agafi valor aleatori 
		String tirarmoneda;
		String JugadorInicial;
		
		
		System.out.println("INTRODUCCIÓ"); //Intro
		System.out.println("\n Introduiex nom per a primer jugador : "); //Jugador 1 tria nom
		jugador1 = s.next();
		System.out.println("\n Introduiex nom per a primer jugador : ");
		jugador2 = s.next();
		
		
		System.out.println("Segidament tirarem una moneda. \n \n "
				+ jugador1 +" serà Cara \n"
				+ jugador2 +" serà Creu");
		
		
        System.out.println("\n Siusplau toqueu la tecla ENTER per a tirar moneda");
        enter.nextLine(); //Esperem a que el Jugador toco Enter sense necessitat de ficar res
        System.out.println("Moneda tirada!");
        
        
		System.out.println("\n El resultat de la moneda a estat "+resultatmoneda);
		if (resultatmoneda.equals("cara")) {
		    JugadorInicial = jugador1;  // Cara == Jugador1 
		    System.out.println("Comença " + jugador1);
		} else {
		    JugadorInicial = jugador2;  // Creu == Jugador2
		    System.out.println("Comença " + jugador2);
		}
	
	}

}
