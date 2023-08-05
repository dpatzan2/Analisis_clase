import java.util.ArrayList;
import java.util.List;

public class String_compator {
    public static void main(String[] args){
        String filePath = "./Libro1.csv"; // Cambia esta ruta por la ubicación real de tu archivo CSV
        String[] palabras = CSV_Reader_Principal.readCSVFile(filePath);

        // Generar un nuevo array con las palabras palíndromas
        String[] palindromas = obtenerPalindromas(palabras);

        // Mostrar las palabras palíndromas en el nuevo array
        System.out.println("Palíndromas:");
        for (String palabra : palindromas) {
            System.out.println(palabra);
        }
    }

    public static String[] obtenerPalindromas(String[] palabras) {
        List<String> palindromasList = new ArrayList<>();

        for (String palabra : palabras) {
            if (esPalindromo(palabra)) {
                palindromasList.add(palabra);
            }
        }

        return palindromasList.toArray(new String[0]);
    }

    public static boolean esPalindromo(String palabra) {
        String reversed = new StringBuilder(palabra).reverse().toString();
        return palabra.equalsIgnoreCase(reversed);
    }
}