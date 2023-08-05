import java.io.*;
import java.util.ArrayList;
import java.util.List;

public  class CSV_Reader_Principal {
    //Generate by IA
    public static String[] readCSVFile(String filePath) {
        List<String> palabras = new ArrayList<>();

        try (Reader reader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                // Aquí se asume que el CSV está compuesto de una sola columna de palabras por línea
                String[] words = line.split(",");
                for (String word : words) {
                    palabras.add(word.trim()); // Agregar la palabra al array, eliminando espacios en blanco
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return palabras.toArray(new String[0]);
    }

    public static void generarArray() {
        String filePath = "./Libro1.csv"; // Cambia esta ruta por la ubicación real de tu archivo CSV
        String[] palabras = readCSVFile(filePath);

        // Mostrar todas las palabras en el array
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }

}