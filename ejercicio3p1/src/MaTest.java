import org.junit.Test; // Importa la clase Test del framework JUnit para escribir pruebas unitarias.
import static org.junit.Assert.*; // Importa todos los métodos estáticos de la clase Assert de JUnit para realizar afirmaciones.

public class MaTest { // Define la clase MaTest que contendrá las pruebas unitarias.

    // Prueba unitaria para verificar el ordenamiento de una lista enlazada
    @Test // Indica que este método es una prueba unitaria.
    public void testSortList() { // Define la prueba unitaria para la función sortList.
        // Crear la lista enlazada de prueba
        ListNode head = new ListNode(3); // Crea el primer nodo de la lista con valor 3.
        head.next = new ListNode(1); // Crea el segundo nodo de la lista con valor 1 y lo enlaza al primero.
        head.next.next = new ListNode(2); // Crea el tercer nodo de la lista con valor 2 y lo enlaza al segundo.
        head.next.next.next = new ListNode(4); // Crea el cuarto nodo de la lista con valor 4 y lo enlaza al tercero.

        // Ordenar la lista enlazada
        ListNode sortedHead = Main.sortList(head); // Llama a la función sortList para ordenar la lista enlazada.

        // Comprobar si la lista está ordenada correctamente
        int[] expected = {1, 2, 3, 4}; // Arreglo esperado con los valores ordenados.
        ListNode current = sortedHead; // Inicializa un nodo para recorrer la lista ordenada.
        int i = 0; // Inicializa un índice para acceder a los elementos del arreglo esperado.
        while (current != null) { // Itera sobre la lista ordenada.
            assertEquals(expected[i], current.val); // Comprueba si el valor actual coincide con el valor esperado.
            current = current.next; // Avanza al siguiente nodo en la lista.
            i++; // Incrementa el índice para acceder al siguiente valor esperado.
        }
    }
}

