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
package PackageTresRAYAS;

import java.util.*;

public class JOC {
    public static void main(String[] args) {
       
        Scanner s = new Scanner(System.in);
        Scanner enter = new Scanner(System.in); // Escàner per esperar que es premi Enter
        
        // NOMS JUGADORS
        String jugador1;
        String jugador2;

        // JOC I NOMS
        System.out.println(          "TRES RAYAS"                             );
        System.out.println("\r\n"
        		+ "Funcionament:Formar una línia de tres marques consecutives (horitzontal, vertical o diagonal)"
        		+ " Cada jugador utilitza un símbol,X o O, alternant torns ");
        System.out.print("\nIntrodueix el nom del primer jugador: ");
        jugador1 = s.next(); // Llegim el nom del primer jugador
        System.out.print("\nIntrodueix el nom del segon jugador: ");
        jugador2 = s.next(); // Llegim el nom del segon jugador

        //REPETIR JOC "SI"
        boolean jugarDeNou = true;
        while (jugarDeNou) {
            jugarDeNou = jugarPartida(jugador1, jugador2, s, enter);
        }
        
        System.out.println("\nGràcies per jugar!");
    }
    
    public static boolean jugarPartida(String jugador1, String jugador2, Scanner s, Scanner enter) {
        // MONEDA
        String[] moneda = new String[]{"cara", "creu"};
        Random r = new Random();
        String resultatMoneda = moneda[r.nextInt(moneda.length)];

        //ABANS TIRAR MONEDA
        System.out.println("\nA continuació tirarem una moneda. \n");
        System.out.println(jugador1 + " serà Cara");
        System.out.println(jugador2 + " serà Creu");
        System.out.println("\nSi us plau, prem la tecla ENTER per tirar la moneda");
        enter.nextLine(); // Esperem que el jugador premi Enter
        System.out.println("Moneda tirada!");

        // DESPRES MONEDA- RESULTAT Y COMENÇA
        System.out.println("\nEl resultat de la moneda ha estat: " + resultatMoneda);
        String jugadorInicial = resultatMoneda.equals("cara") ? jugador1 : jugador2;
        System.out.println("Comença " + jugadorInicial);

        // TAULER
        char[][] tauler = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };
        boolean jocAcabat = false;
        char fitxaActual = 'X';
        int moviments = 0;

        // BUCLE JOC
        while (!jocAcabat) {
            System.out.println("\nTauler:");//----
            for (char[] fila : tauler) {//               |
                for (char casella : fila) {//            |----> MOSTRAT TAULER
                    System.out.print(casella + " ");//   |
                }//                                      |
                System.out.println();// -----------------|
            }

            // TORN JOC
            System.out.println("\nTorn de " + (fitxaActual == 'X' ? jugador1 : jugador2) + " (" + fitxaActual + ")");
            System.out.print("Escull una casella (1-9): ");

            int casella = 0;
            while (true) {
                try {						//COMPROVAR "LLETRES" 
                    casella = s.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Si us plau, introdueix només números.");
                    s.next();
                    continue;
                }
                //COMPROVAR NUM
                if (casella < 1 || casella > 9) {
                    System.out.println("Casella no vàlida. Escull una altra (1-9):");
                    continue;
                }
                //COORDENADES
                int fila = (casella - 1) / 3;
                int columna = (casella - 1) % 3;

                if (tauler[fila][columna] == 'X' || tauler[fila][columna] == 'O') {
                    System.out.println("Casella ocupada. Escull una altra:");
                } else {
                    tauler[fila][columna] = fitxaActual;
                    moviments++;
                    break;
                }
            }

            // VERIFICACIONS 
            int fila = (casella - 1) / 3;
            int columna = (casella - 1) % 3;
            if ((tauler[fila][0] == fitxaActual && tauler[fila][1] == fitxaActual && tauler[fila][2] == fitxaActual) || //FILA
                (tauler[0][columna] == fitxaActual && tauler[1][columna] == fitxaActual && tauler[2][columna] == fitxaActual) || //COLUMNA
                (tauler[0][0] == fitxaActual && tauler[1][1] == fitxaActual && tauler[2][2] == fitxaActual) || //DIAGONAL 
                (tauler[0][2] == fitxaActual && tauler[1][1] == fitxaActual && tauler[2][0] == fitxaActual)) { //DIAGONAL
                jocAcabat = true;
                System.out.println("\nHa guanyat " + (fitxaActual == 'X' ? jugador1 : jugador2) + "!");
                
                //TAULER FINAL 
                System.out.println("\nTauler FINAL:");
                for (char[] filaFinal : tauler) {
                    for (char casellaFinal : filaFinal) {
                        System.out.print(casellaFinal + " ");
                    }                                        
                    System.out.println();
                }

                break;
            }
            //EMPAT
            if (moviments == 9) {
                System.out.println("\n Cap jugador guanya, hi ha EMPAT!");
                break;
            }
            //TORN
            fitxaActual = (fitxaActual == 'X') ? 'O' : 'X';
        }
        //REINICIAR JOC 
        System.out.print("\nVols jugar una altra partida? (si/no): ");
        String resposta = s.next();
        return resposta.equalsIgnoreCase("si");
    }
}
