import java.util.ArrayList;
import java.util.Scanner;

public class String_compator {
    public static void main(String[] args){
        // Codigo sacado de Chat GPT
        // Array de palabras
        Scanner scanner = new Scanner(System.in);

        // Pedir la cantidad de palabras que se ingresarán
        System.out.print("Ingrese la cantidad de palabras: ");
        int cantidadPalabras = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente después de nextInt()

        // Crear el array para almacenar las palabras
        String[] palabras = new String[cantidadPalabras];

        // Pedir las palabras y almacenarlas en el array
        for (int i = 0; i < cantidadPalabras; i++) {
            System.out.print("Ingrese la palabra " + (i + 1) + ": ");
            palabras[i] = scanner.nextLine();
        }

        // Crear un ArrayList para almacenar los caracteres
        ArrayList<Character> caracteres = new ArrayList<>();

        // Recorrer el array de palabras
        for (String palabra : palabras) {
            // Recorrer cada palabra y agregar los caracteres al ArrayList
            for (char caracter : palabra.toCharArray()) {
                caracteres.add(caracter);
            }
        }

        // Convertir el ArrayList en un array de caracteres
        char[] arrayCaracteres = new char[caracteres.size()];
        for (int i = 0; i < caracteres.size(); i++) {
            arrayCaracteres[i] = caracteres.get(i);
        }

        // Imprimir el array de caracteres
        for (char c : arrayCaracteres) {
            System.out.print(c + " ");
        }

    }
}