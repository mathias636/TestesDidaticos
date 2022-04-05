package TestesDidaticos.src;

import java.util.Scanner;

public class TesteStringMatches {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String palavra;
        String caracteres_nao_alfabeticos = "[0-9]";
        String caracteres_especiais = "[,.:?!]$*"+"\s$*";
        
        palavra = sc.nextLine();
        
        System.out.println(""+
            palavra.matches(caracteres_nao_alfabeticos)+" | "+palavra.matches(caracteres_especiais)
            +"\n--------------------------------------------------------------------------------------"
        );

        if(palavra.matches(caracteres_nao_alfabeticos) == true){
            System.out.println(false);
        }else{
            System.out.println(true);
        }

        main(args);
    }
}
