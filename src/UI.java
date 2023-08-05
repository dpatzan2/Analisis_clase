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
            System.out.println("1. Leer archivo");
            System.out.println("2. Salir");
            System.out.println("Opcion: ");
            op = in.nextLine();

            switch(op){

                /*
                 * Se lee el archivo
                 */
                case "1":
                    System.out.println("Ha seleccionado leer archivo");
                    CSV_Reader_Principal.generarArray();

                /*
                 * Salir del programa
                 */
                case "2":
                    System.out.println("Saliendo");
            }

        }while(!op.equals("2"));
    }

    /*
     * Mostrar Resultados
     */
    public static void ShowResults(){
        System.out.println("Mostrar Resultados");
    }
}
