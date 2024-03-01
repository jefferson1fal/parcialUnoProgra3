import java.util.Arrays; // Importa la clase Arrays para manipular matrices.
import java.util.Random; // Importa la clase Random para generar números aleatorios.
import static org.junit.Assert.*; // Importa los métodos estáticos de la clase Assert de JUnit para realizar afirmaciones en las pruebas unitarias.
import org.junit.Test; // Importa la anotación Test de JUnit para marcar métodos de prueba.

class Juego {
    private final int[] tablero;
    private final Random random;

    public Juego() { // Constructor de la clase Juego.
        this.tablero = new int[64]; // Inicializa el tablero con 64 casillas.
        Arrays.fill(tablero, -1); // Inicializa todo el tablero con el valor -1.
        // Declara un arreglo para representar las casillas especiales de origen.
        int[] origenCasillasEspeciales = new int[]{7, 11, 31, 30, 40, 43, 50, 59}; // Inicializa las casillas especiales de origen.
        // Declara un arreglo para representar las casillas especiales de destino.
        int[] destinoCasillasEspeciales = new int[]{38, 37, 46, 2, 21, 60, 5, 42}; // Inicializa las casillas especiales de destino.
        for (int i = 0; i < origenCasillasEspeciales.length; i++) { // Recorre las casillas especiales.
            tablero[origenCasillasEspeciales[i] - 1] = destinoCasillasEspeciales[i] - 1; // Asigna el destino de cada casilla especial en el tablero.
        }
        this.random = new Random(); // Inicializa el objeto Random.
    }

    public void jugar() { // Método para iniciar el juego.
        int[] jugadores = {1, 1}; // Posiciones iniciales de los jugadores.
        int jugadorActual = 0; // Índice del jugador que juega actualmente.
        int consecutivosSeis = 0; // Contador para contar la cantidad de seis consecutivos.

        while (jugadores[jugadorActual] < tablero.length) { // Itera mientras ningún jugador haya alcanzado la última casilla del tablero.
            int dado = lanzarDado(); // Genera un número aleatorio simulando el lanzamiento de un dado.
            System.out.println("Turno del Jugador " + (jugadorActual + 1) + ": Resultado del dado: " + dado); // Imprime el resultado del lanzamiento del dado.

            if (dado == 6) { // Si el resultado del dado es 6.
                consecutivosSeis++; // Incrementa el contador de seis consecutivos.
                if (consecutivosSeis == 3) { // Si un jugador saca tres seis consecutivos.
                    jugadorHaSacadoTresSeis(jugadorActual); // Realiza las acciones correspondientes.
                    continue; // Salta a la siguiente iteración del ciclo.
                }
            } else { // Si el resultado del dado no es 6.
                consecutivosSeis = 0; // Reinicia el contador de seis consecutivos.
            }

            moverJugador(jugadores, jugadorActual, dado); // Mueve al jugador según el resultado del dado.
            imprimirPosicion(jugadorActual, jugadores[jugadorActual]); // Imprime la posición del jugador actual.

            jugadorActual = (jugadorActual + 1) % jugadores.length; // Cambia al siguiente jugador.
        }

        System.out.println("¡Jugador " + (jugadorActual + 1) + " ha ganado!"); // Imprime el mensaje de victoria del jugador.
    }

    protected int lanzarDado() { // Método para simular el lanzamiento de un dado.
        return random.nextInt(6) + 1; // Retorna un número aleatorio entre 1 y 6.
    }

    private void jugadorHaSacadoTresSeis(int jugadorActual) { // Método para manejar el caso cuando un jugador saca tres seis consecutivos.
        System.out.println("¡Jugador " + (jugadorActual + 1) + " ha sacado 3 seis consecutivos! Vuelve a la posición 1 y queda bloqueado."); // Imprime un mensaje indicando que el jugador vuelve a la posición inicial y queda bloqueado.
    }

    private void moverJugador(int[] jugadores, int jugadorActual, int dado) { // Método para mover al jugador en el tablero.
        jugadores[jugadorActual] += dado; // Mueve al jugador según el resultado del dado.
        if (tablero[jugadores[jugadorActual] - 1] != -1) { // Si el jugador cae en una casilla especial.
            int nuevaPosicion = tablero[jugadores[jugadorActual] - 1] + 1; // Obtiene la nueva posición del jugador.
            if (nuevaPosicion > jugadores[jugadorActual]) { // Si la nueva posición es mayor que la posición actual del jugador.
                System.out.println("¡Jugador " + (jugadorActual + 1) + " ha caído en una escalera! Avanza a la posición " + nuevaPosicion); // Imprime un mensaje indicando que el jugador subió por una escalera.
            } else { // Si la nueva posición es menor o igual que la posición actual del jugador.
                System.out.println("¡Jugador " + (jugadorActual + 1) + " ha caído en una serpiente! Retrocede a la posición " + nuevaPosicion); // Imprime un mensaje indicando que el jugador bajó por una serpiente.
            }
            jugadores[jugadorActual] = nuevaPosicion; // Actualiza la posición del jugador.
        }
        if (jugadores[jugadorActual] > tablero.length) { // Si el jugador se pasa de la última casilla del tablero.
            int retroceso = jugadores[jugadorActual] - tablero.length; // Calcula la cantidad de posiciones que se pasa el jugador.
            jugadores[jugadorActual] = tablero.length - retroceso; // Retrocede al jugador a la última casilla del tablero.
            System.out.println("Se pasó. Retrocede " + retroceso + " posiciones."); // Imprime un mensaje indicando el retroceso del jugador.
        }
    }

    private void imprimirPosicion(int jugadorActual, int posicion) { // Método para imprimir la posición actual del jugador.
        System.out.println("Posición del Jugador " + (jugadorActual + 1) + ": " + posicion); // Imprime la posición actual del jugador.
    }
}

public class Main { // Declara la clase principal Main.

    public static void main(String[] args) { // Método principal del programa.
        Juego juego = new Juego(); // Crea un objeto de la clase Juego para iniciar el juego.
        juego.jugar(); // Inicia el juego.
    }
}
