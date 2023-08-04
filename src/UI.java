import java.util.Scanner;

public class UI {

    private static void Showmenu(){
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

        }while(!op.equals("2"));
    }
    private static void ShowResults(){
        System.out.println("Mostrando");
    }
}
