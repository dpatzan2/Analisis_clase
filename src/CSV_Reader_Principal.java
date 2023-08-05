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

    public static String[] generarArray() {
        String filePath = "./Libro1.csv";
        String[] palabras = readCSVFile(filePath);

        return palabras; // Retornamos el array de palabras
    }


}