import java.util.Scanner;

public class Main {
	
	// Método que verifica si un RUT es válido
	static public boolean isValidRut(String rut) {		
		// Explicación de como hacerlo en https://es.wikipedia.org/wiki/C%C3%B3digo_de_control
		// Dividimos el RUT en dos partes utilizando el método split y el separador "-".
		// La primera parte corresponde al número del RUT y la segunda parte corresponde a la letra verificadora.
		String[] parts = rut.split("-");
		//Quitamos los posibles puntos que tenga el RUT
		parts[0] = parts[0].replace(".", "");
		// Verificamos si la primera parte (el número del RUT) está compuesta únicamente por dígitos y si la segunda parte (la letra verificadora) es un carácter válido (un dígito o la letra "k" o "K").
		// Si alguna de estas condiciones no se cumple, devolvemos false.
		if (!parts[0].matches("\\d+") || !parts[1].matches("[0-9kK]{1}")) {
		    return false;
		}
	    // Invertimos el orden de los dígitos del número del RUT
	    String reverseRut = new StringBuilder(parts[0]).reverse().toString();
	    int sum = 0; // Creamos una variable para almacenar la suma parcial
	    int factor = 2; // Creamos una variable para almacenar el factor de multiplicación
	    // Recorremos cada dígito del número del RUT invertido
	    for (int i = 0; i < reverseRut.length(); i++) {
	        // Si el factor es 8, lo volvemos a poner en 2 (esto es necesario para el algoritmo de verificación del RUT)
	        if (factor == 8) {
	            factor = 2;
	        }
	        // Acumulamos la multiplicación del dígito por el factor en la variable sum
	        sum += factor * Character.getNumericValue(reverseRut.charAt(i));
	        // Incrementamos el factor en 1
	        factor++;
	    }
	    // Calculamos el módulo de la suma parcial entre 11
	    int module = sum % 11;
	    // Calculamos el dígito verificador que correspondería al RUT según el algoritmo
	    String calculatedVerifierDigit = String.valueOf(11 - module);
	    // Si el dígito verificador calculado es "10", lo convertimos a "k" (esto es necesario porque el algoritmo utiliza "k" en lugar de "10")
	    if (calculatedVerifierDigit.equals("10")) {
	        calculatedVerifierDigit = "k";
	    }
	    // Si el dígito verificador calculado coincide con el dígito verificador del RUT que estamos verificando, devolvemos true. De lo contrario, devolvemos false
	    if (calculatedVerifierDigit.equals(parts[1])) {
			return true;
		}
	    return false;
	}

	public static void main(String[] args) {
		System.out.print("RUT con codigo verificador: ");
		if (isValidRut(new Scanner(System.in).nextLine())) {
			System.out.println("El rut es valido");
		} else {
			System.out.println("El rut no es valido");
		}
	}
}
