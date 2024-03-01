import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LectorEntradaTest { // Declara una clase para las pruebas unitarias de LectorEntrada.

    @Test // Marca el método como una prueba unitaria.
    public void testLeerMatriz() { // Método para probar el método leerMatriz de LectorEntrada.
        String input = "2\n3\n1 2 3\n4 5 6\n"; // Define una cadena de entrada simulada.
        InputStream in = new ByteArrayInputStream(input.getBytes()); // Crea una secuencia de entrada a partir de la cadena de entrada simulada.
        System.setIn(in); // Establece la secuencia de entrada como la entrada estándar del sistema.

        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para la entrada simulada.
        LectorEntrada lector = new LectorEntrada(scanner); // Crea un objeto LectorEntrada con el Scanner simulado.

        int[][] matriz = lector.leerMatriz(); // Lee la matriz utilizando el objeto LectorEntrada.

        // Realiza afirmaciones para verificar que la matriz se leyó correctamente.
        assertEquals("Número de filas incorrecto", 2, matriz.length);
        assertEquals("Número de columnas incorrecto", 3, matriz[0].length);
        assertEquals("Valor incorrecto en la matriz", 1, matriz[0][0]);
        assertEquals("Valor incorrecto en la matriz", 6, matriz[1][2]);
    }
}
