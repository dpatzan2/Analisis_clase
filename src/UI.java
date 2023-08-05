import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 * 
 */
public class UI {
    //Se modificafon los metodos de privados a publicos

    /*
     * Metodo mostrar menu
     */

    public static void Showmenu(){
        String op = "";

        System.out.println("----------------------------------");
        System.out.println(" Programa De Palabras Palindromas ");
        System.out.println("-----------------------------------");
        System.out.println("");

        Scanner in = new Scanner(System.in);
        do{
            System.out.println("Menu: ");
            System.out.println("1. Leer archivo y generar archivo csv");
            System.out.println("2. Salir");
            System.out.println("Opcion: ");
            op = in.nextLine();

            switch(op){

                /*
                 * Se lee el archivo
                 */
                case "1":
                    System.out.println("Ha seleccionado leer archivo");
                    String[] palabrasArray = CSV_Reader_Principal.generarArray();
                    String[] palabrasPalindromas = String_compator.obtenerPalindromas(palabrasArray);
                    ShowResults(palabrasPalindromas);
                    break;
                case "2":
                    System.out.println("Saliendo");
            }

        }while(!op.equals("2"));
    }

    /*
     * Mostrar Resultados
     */
    public static void ShowResults(String[] palabrasPalindromas) {
        String ruta = "./palindromas.csv";

        try {
            FileWriter writer = new FileWriter(ruta);

            for (String palabra : palabrasPalindromas) {
                writer.append(palabra);
                writer.append('\n');
            }

            writer.flush();
            writer.close();

            System.out.println("Archivo CSV de palabras palíndromas generado: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }

}
