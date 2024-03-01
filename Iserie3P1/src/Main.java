public class Main {
    public static void main(String[] args) {
        // Declaración de variables con tipos específicos
        int numeroEntero = 10;
        double numeroDecimal = 5.5;

        // Operación entre variables del mismo tipo
       double resultado = numeroEntero + numeroDecimal;

        // Esto produciría un error de compilación ya que no se puede asignar un double a un int directamente
         //int resultado = numeroEntero + numeroDecimal;

        System.out.println("El resultado es: " + resultado);
    }
}

    // JavaScript es un lenguaje débilmente tipado
  //  let numeroEntero = 10;
    //let numeroDecimal = 5.5;

    // Operación entre variables sin necesidad de preocuparse por los tipos de datos
    //let resultado = numeroEntero + numeroDecimal;

//console.log("El resultado es: " + resultado);
