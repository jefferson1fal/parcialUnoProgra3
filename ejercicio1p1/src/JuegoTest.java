import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JuegoTest { // Declara una clase para las pruebas unitarias de la clase Juego.

    @Test // Marca el método como una prueba unitaria.
    public void testLanzarDado() { // Método para probar el método lanzarDado de la clase Juego.
        Juego juego = new Juego(); // Crea un objeto de la clase Juego para realizar las pruebas.
        int resultado = juego.lanzarDado(); // Llama al método lanzarDado para obtener un resultado.
        assertTrue("El resultado debe estar entre 1 y 6", resultado >= 1 && resultado <= 6); // Verifica que el resultado esté dentro del rango esperado.
    }
}
