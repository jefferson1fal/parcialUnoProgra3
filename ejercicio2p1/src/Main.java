import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario.

import static org.junit.Assert.*; // Importa los métodos estáticos de la clase Assert de JUnit para realizar las afirmaciones en las pruebas unitarias.
import org.junit.Test; // Importa la anotación Test de JUnit para marcar métodos de prueba.
import java.io.ByteArrayInputStream; // Importa la clase ByteArrayInputStream para crear una secuencia de entrada a partir de un arreglo de bytes.
import java.io.InputStream; // Importa la clase InputStream para manejar la entrada de datos.

public class Main { // Declara una clase llamada Main.
    public static void main(String[] args) { // Declara el método main.
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario.

        LectorEntrada lectorEntrada = new LectorEntrada(scanner); // Crea un objeto LectorEntrada pasando el Scanner como argumento.
        int[][] matriz = lectorEntrada.leerMatriz(); // Lee la matriz utilizando el objeto LectorEntrada.

        System.out.println("Ingrese la fila de la posición: "); // Imprime un mensaje pidiendo al usuario que ingrese la fila de la posición.
        int fila = scanner.nextInt(); // Lee la fila ingresada por el usuario.
        System.out.println("Ingrese la columna de la posición: "); // Imprime un mensaje pidiendo al usuario que ingrese la columna de la posición.
        int columna = scanner.nextInt(); // Lee la columna ingresada por el usuario.

        BuscadorPosiciones buscadorPosiciones = new BuscadorPosiciones(); // Crea un objeto BuscadorPosiciones.
        int[][] adyacentes = buscadorPosiciones.encontrarAdyacentes(matriz, fila, columna); // Encuentra las posiciones adyacentes en la matriz.

        ImpresorSalida impresorSalida = new ImpresorSalida(); // Crea un objeto ImpresorSalida.
        impresorSalida.mostrarPosiciones(adyacentes); // Muestra las posiciones adyacentes encontradas.

        scanner.close(); // Cierra el objeto Scanner para liberar recursos.
    }
}

class LectorEntrada { // Declara una clase llamada LectorEntrada.
    private Scanner scanner; // Declara una variable privada de tipo Scanner.

    public LectorEntrada(Scanner scanner) { // Constructor de la clase que recibe un objeto Scanner como argumento.
        this.scanner = scanner; // Inicializa la variable scanner con el objeto recibido como argumento.
    }

    public int[][] leerMatriz() { // Método para leer una matriz ingresada por el usuario.
        System.out.print("Ingrese el número de filas de la matriz: "); // Imprime un mensaje pidiendo al usuario que ingrese el número de filas.
        int filas = scanner.nextInt(); // Lee el número de filas ingresado por el usuario.
        System.out.print("Ingrese el número de columnas de la matriz: "); // Imprime un mensaje pidiendo al usuario que ingrese el número de columnas.
        int columnas = scanner.nextInt(); // Lee el número de columnas ingresado por el usuario.

        int[][] matriz = new int[filas][columnas]; // Crea una matriz con las dimensiones especificadas.

        System.out.println("Ingrese los elementos de la matriz:"); // Imprime un mensaje pidiendo al usuario que ingrese los elementos de la matriz.
        for (int i = 0; i < filas; i++) { // Itera sobre las filas de la matriz.
            for (int j = 0; j < columnas; j++) { // Itera sobre las columnas de la matriz.
                matriz[i][j] = scanner.nextInt(); // Lee el elemento de la matriz en la posición (i, j).
            }
        }
        return matriz; // Devuelve la matriz ingresada por el usuario.
    }
}

class BuscadorPosiciones { // Declara una clase llamada BuscadorPosiciones.
    public int[][] encontrarAdyacentes(int[][] matriz, int fila, int columna) { // Método para encontrar las posiciones adyacentes en una matriz.
        int filas = matriz.length; // Obtiene el número de filas de la matriz.
        int columnas = matriz[0].length; // Obtiene el número de columnas de la matriz.

        int[][] adyacentes = new int[4][2]; // Crea una matriz para almacenar las posiciones adyacentes.

        int pos = 0; // Inicializa una variable para llevar el seguimiento de la posición en la matriz de adyacentes.
        if (fila > 0) { // Verifica si hay una fila adyacente hacia arriba.
            adyacentes[pos++] = new int[]{fila - 1, columna}; // Almacena la posición adyacente hacia arriba.
        }
        if (fila < filas - 1) { // Verifica si hay una fila adyacente hacia abajo.
            adyacentes[pos++] = new int[]{fila + 1, columna}; // Almacena la posición adyacente hacia abajo.
        }
        if (columna > 0) { // Verifica si hay una columna adyacente hacia la izquierda.
            adyacentes[pos++] = new int[]{fila, columna - 1}; // Almacena la posición adyacente hacia la izquierda.
        }
        if (columna < columnas - 1) { // Verifica si hay una columna adyacente hacia la derecha.
            adyacentes[pos++] = new int[]{fila, columna + 1}; // Almacena la posición adyacente hacia la derecha.
        }

        return adyacentes; // Devuelve la matriz de posiciones adyacentes.
    }
}

class ImpresorSalida { // Declara una clase llamada ImpresorSalida.
    public void mostrarPosiciones(int[][] adyacentes) { // Método para mostrar las posiciones adyacentes.
        System.out.println("Posiciones adyacentes:"); // Imprime un mensaje indicando que se van a mostrar las posiciones adyacentes.
        for (int[] posicion : adyacentes) { // Itera sobre las posiciones adyacentes.
            System.out.println("(" + posicion[0] + "," + posicion[1] + ")"); // Imprime las coordenadas de la posición adyacente.
        }
    }
}

