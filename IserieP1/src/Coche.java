// Definición de la clase Coche
class Coche {
    // Atributos
    String marca;
    String modelo;
    int año;

    // Constructor
    public Coche(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    // Método para obtener información del coche
    public String getInfo() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año;
    }
}
