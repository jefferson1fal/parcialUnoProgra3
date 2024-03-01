
// Clase principal donde se utiliza la clase Coche
public class Main {
    public static void main(String[] args) {
        // Crear objetos de tipo Coche
        Coche coche1 = new Coche("Toyota", "Corolla", 2022);
        Coche coche2 = new Coche("Honda", "Civic", 2020);

        // Acceder a los métodos y atributos de los objetos
        System.out.println(coche1.getInfo());
        System.out.println(coche2.getInfo());
    }

}
