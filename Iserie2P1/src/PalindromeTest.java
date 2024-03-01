import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void testEsPalindromo() {
        // Casos de prueba
        System.out.println("Cadenas palíndromas:");
        // Verifica si la cadena "Anita lava la tina" es un palíndromo y muestra el resultado
        assertTrue(imprimirResultado("Anita lava la tina")); // Palíndromo
        // Verifica si la cadena "A man, a plan, a canal, Panama" es un palíndromo y muestra el resultado
        assertTrue(imprimirResultado("A man, a plan, a canal, Panama")); // Palíndromo

        System.out.println("\nCadenas no palíndromas:");
        // Verifica si la cadena "Hola mundo" es un palíndromo y muestra el resultado
        assertFalse(imprimirResultado("Hola mundo")); // No palíndromo
        // Verifica si la cadena "Java" es un palíndromo y muestra el resultado
        assertFalse(imprimirResultado("Java")); // No palíndromo
    }

    // Método para verificar si una cadena es un palíndromo e imprimir el resultado
    private boolean imprimirResultado(String cadena) {
        // Eliminar los caracteres que no son letras ni números y convertir la cadena a minúsculas
        String cadenaFormateada = cadena.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Comparar la cadena original con su reverso para determinar si es un palíndromo
        boolean esPalindromo = cadenaFormateada.equals(new StringBuilder(cadenaFormateada).reverse().toString());

        // Imprimir el resultado de la prueba
        System.out.println(cadena + " es palíndromo: " + esPalindromo);

        return esPalindromo;
    }
}
