package TestesDidaticos.src;

import java.util.Scanner;

/**
 * TesteStringReplace
 */
public class TesteStringReplace {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine().toLowerCase();
        // String entrada = sc.nextLine().toLowerCase().replaceAll("$[,.:;!?]+\\s", "");
        boolean bool = entrada.matches("^[^a-z^A-Z]$");
        System.out.println(
            bool
            +"\n"+
            entrada
        );
        main(args);
    }
}