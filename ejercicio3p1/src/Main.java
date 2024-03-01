import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario.

class ListNode { // Define una clase ListNode para representar un nodo de una lista enlazada.
    int val; // Valor almacenado en el nodo.
    ListNode next; // Referencia al siguiente nodo.

    ListNode(int val) { // Constructor que asigna un valor al nodo.
        this.val = val;
    }
}

public class Main { // Clase principal que contiene el método main y las funciones para ordenar y fusionar listas enlazadas.
    public static ListNode sortList(ListNode head) { // Función para ordenar una lista enlazada utilizando el algoritmo merge sort.
        if (head == null || head.next == null) { // Si la lista está vacía o tiene un solo elemento, retorna la lista.
            return head;
        }

        ListNode mid = getMiddle(head); // Obtiene el nodo medio de la lista.
        ListNode midNext = mid.next; // Guarda la referencia al siguiente nodo del nodo medio.
        mid.next = null; // Divide la lista en dos sub-listas.

        ListNode left = sortList(head); // Ordena la primera mitad de la lista.
        ListNode right = sortList(midNext); // Ordena la segunda mitad de la lista.

        return merge(left, right); // Fusiona las dos sub-listas ordenadas.
    }

    public static ListNode getMiddle(ListNode head) { // Función para obtener el nodo medio de una lista enlazada.
        if (head == null) { // Si la lista está vacía, retorna null.
            return null;
        }

        ListNode slow = head; // Referencia al nodo lento que se mueve un paso a la vez.
        ListNode fast = head.next; // Referencia al nodo rápido que se mueve dos pasos a la vez.

        while (fast != null && fast.next != null) { // Mientras el nodo rápido no alcance el final de la lista.
            slow = slow.next; // Mueve el nodo lento un paso.
            fast = fast.next.next; // Mueve el nodo rápido dos pasos.
        }

        return slow; // Retorna el nodo lento que ahora está en el punto medio.
    }

    public static ListNode merge(ListNode left, ListNode right) { // Función para fusionar dos listas enlazadas ordenadas.
        ListNode dummy = new ListNode(0); // Nodo ficticio para facilitar la fusión.
        ListNode current = dummy; // Nodo para mantener un puntero a la lista resultante.

        while (left != null && right != null) { // Mientras ambas listas tengan elementos.
            if (left.val < right.val) { // Si el valor del nodo izquierdo es menor.
                current.next = left; // Agrega el nodo izquierdo a la lista resultante.
                left = left.next; // Avanza al siguiente nodo en la lista izquierda.
            } else { // Si el valor del nodo derecho es menor o igual.
                current.next = right; // Agrega el nodo derecho a la lista resultante.
                right = right.next; // Avanza al siguiente nodo en la lista derecha.
            }
            current = current.next; // Avanza al siguiente nodo en la lista resultante.
        }

        if (left != null) { // Si quedan nodos en la lista izquierda.
            current.next = left; // Agrega todos los nodos restantes de la lista izquierda a la lista resultante.
        }

        if (right != null) { // Si quedan nodos en la lista derecha.
            current.next = right; // Agrega todos los nodos restantes de la lista derecha a la lista resultante.
        }

        return dummy.next; // Retorna el siguiente nodo después del nodo ficticio, que es el inicio de la lista fusionada.
    }

    // Función para imprimir la lista enlazada.
    public static void printList(ListNode head) { // Método para imprimir los valores de una lista enlazada.
        ListNode current = head; // Inicializa un nodo para recorrer la lista.

        while (current != null) { // Mientras haya nodos en la lista.
            System.out.print(current.val + " "); // Imprime el valor del nodo actual.
            current = current.next; // Avanza al siguiente nodo.
        }
        System.out.println(); // Imprime un salto de línea al final de la lista.
    }

    public static void main(String[] args) { // Método principal del programa.
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario.

        // Crear la lista enlazada para la primera prueba
        ListNode head1 = new ListNode(4); // Crea el primer nodo de la lista con valor 4.
        head1.next = new ListNode(2); // Crea el segundo nodo de la lista con valor 2 y lo enlaza al primero.
        head1.next.next = new ListNode(1); // Crea el tercer nodo de la lista con valor 1 y lo enlaza al segundo.
        head1.next.next.next = new ListNode(3); // Crea el cuarto nodo de la lista con valor 3 y lo enlaza al tercero.

        // Ordenar la lista enlazada e imprimir el resultado
        System.out.println("Prueba 1:"); // Imprime un mensaje indicando la primera prueba.
        System.out.print("Entrada: "); // Imprime un mensaje indicando la entrada.
        printList(head1); // Imprime la lista enlazada original.
        ListNode sortedHead1 = sortList(head1); // Ordena la lista enlazada.
        System.out.print("Salida: "); // Imprime un mensaje indicando la salida.
        printList(sortedHead1); // Imprime la lista enlazada ordenada.

        // Crear la lista enlazada para la segunda prueba
        ListNode head2 = new ListNode(-1); // Crea el primer nodo de la segunda lista con valor -1.
        head2.next = new ListNode(5); // Crea el segundo nodo de la lista con valor 5 y lo enlaza al primero.
        head2.next.next = new ListNode(3); // Crea el tercer nodo de la lista con valor 3 y lo enlaza al segundo.
        head2.next.next.next = new ListNode(4); // Crea el cuarto nodo de la lista con valor 4 y lo enlaza al tercero.
        head2.next.next.next.next = new ListNode(0); // Crea el quinto nodo de la lista con valor 0 y lo enlaza al cuarto.

        // Ordenar la lista enlazada e imprimir el resultado
        System.out.println("\nPrueba 2:"); // Imprime un mensaje indicando la segunda prueba.
        System.out.print("Entrada: "); // Imprime un mensaje indicando la entrada.
        printList(head2); // Imprime la lista enlazada original.
        ListNode sortedHead2 = sortList(head2); // Ordena la lista enlazada.
        System.out.print("Salida: "); // Imprime un mensaje indicando la salida.
        printList(sortedHead2); // Imprime la lista enlazada ordenada.

        // Crear la lista enlazada para la tercera prueba (permitiendo al usuario ingresar la entrada)
        System.out.println("\nPrueba 3:"); // Imprime un mensaje indicando la tercera prueba.
        System.out.print("Ingrese los elementos de la lista separados por espacios: "); // Pide al usuario ingresar los elementos de la lista.
        String input = scanner.nextLine(); // Lee la entrada del usuario.
        String[] values = input.split(" "); // Divide la entrada en valores individuales.
        ListNode head3 = null; // Inicializa la cabeza de la lista enlazada.
        ListNode tail = null; // Inicializa la cola de la lista enlazada.
        for (String value : values) { // Recorre los valores ingresados.
            int num = Integer.parseInt(value); // Convierte el valor de cadena a entero.
            if (head3 == null) { // Si la lista está vacía.
                head3 = new ListNode(num); // Crea un nuevo nodo como cabeza de la lista.
                tail = head3; // Establece la cola igual a la cabeza.
            } else { // Si la lista no está vacía.
                tail.next = new ListNode(num); // Crea un nuevo nodo y lo enlaza con la cola actual.
                tail = tail.next; // Mueve la cola al nuevo nodo.
            }
        }

        // Ordenar la lista enlazada e imprimir el resultado
        System.out.print("Entrada: "); // Imprime un mensaje indicando la entrada.
        printList(head3); // Imprime la lista enlazada original.
        ListNode sortedHead3 = sortList(head3); // Ordena la lista enlazada.
        System.out.print("Salida: "); // Imprime un mensaje indicando la salida.
        printList(sortedHead3); // Imprime la lista enlazada ordenada.

        scanner.close(); // Cierra el objeto Scanner para liberar recursos.
    }
}
