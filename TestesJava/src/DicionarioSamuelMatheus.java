// package TrabalhoAlgII.src;

/*
 * Entrega do Trabalho 1- Algoritmos e Programação II
 * Nós,
 * Matheus Galvão
 * Milena Hochheim
 * Vinicius Gomes
 * 
 * declaramos que
 * todas as respostas são fruto de nosso próprio trabalho,
 * não copiamos respostas de colegas externos à equipe,
 * não disponibilizamos nossas respostas para colegas externos ao grupo e
 * não realizamos quaisquer outras atividades desonestas para nos beneficiar ou
 * prejudicar outros.
 */

import java.io.File;
import java.util.Scanner;

public class DicionarioSamuelMatheus {

  public static void main(String[] args) throws Exception {
    String[] dicionario = new String[1000];
    String nomeArquivo = "";
    
    try (Scanner entrada = new Scanner(System.in)) {
      System.out.println("Digite o nome do arquivo: ");
      nomeArquivo = entrada.next();
    }
    
    dicionario = popularDicionario(dicionario, nomeArquivo);
    imprimir(dicionario);
  }

  private static String[] popularDicionario(String[] dicionario, String nomeArquivo) throws Exception {
    Scanner entrada = new Scanner(new File(nomeArquivo));
    String palavraDoTexto = "";

    while (entrada.hasNext()) {
      palavraDoTexto = entrada.next().toLowerCase();
      
      boolean repetido = verificarRepetido(dicionario, palavraDoTexto);
      boolean vazio = dicionario[0].equals("") || dicionario[0] == null;

      if(repetido == false && vazio == true){
        dicionario = InserirElementoNaOrdem(dicionario, palavraDoTexto);
      }
    }
    return dicionario;
  }

  private static void imprimir(String[] dicionario) throws Exception {
    int count = 0;
    for(int i = 0; i < dicionario.length; i++){
      if(dicionario[i] != null){
        if(!(dicionario[i].equals(""))) {
          System.out.println(dicionario[i]);
          count++;
        }
      }
    }
    System.out.println("total de palavras diferentes no dicionario="+count);
  }

  private static String[] removerNull(String[] v, int index) throws Exception {
    if(index >= 0 && index <= v.length-1){
      if(v[index] == null){
        v[index] = "";
      }
    }
    return v;
  }

  private static String[] InserirElementoNaOrdem(String[] v, String palavra) throws Exception {
    boolean procura = true;
    int i = 0; 
    while(procura == true){
      procura = verificarEntrada(i, v, palavra);

      if(procura == true){
        v[i] = v[i+1];
        i++;
      }else{
        v[i] = palavra;
      }
    }
    return v;
  }

  private static boolean verificarEntrada(int i, String[] v, String palavra) throws Exception {
    v = removerNull(v, i+1);
    v = removerNull(v, i-1);
    
    if(i == 0){
      if(palavra.compareTo(v[i+1]) < 0){//verificar se entra no inicio
        return false;
      }
    }else if(i == v.length-1){//no fim
      if(palavra.compareTo(v[i-1]) > 0){
        return false;
      }
    }else{
        if(palavra.compareTo(v[i-1]) > 0 && palavra.compareTo(v[i+1]) < 0){//no meio
        return false;
      }
    }

    //se não, continue procurando
    return true;
  }

  private static boolean verificarRepetido(String[] v, String palavraDoTexto) throws Exception {
    int i = 0;
    int m = 0;
    int f = v.length-1;

    while(i <= f){
      m = (i + f) /2;

      //retirar null para fazer a comparação em [i] [m] e [f]
      v = removerNull(v, i);
      v = removerNull(v, f);
      v = removerNull(v, m);

      if(v[m].compareTo(palavraDoTexto) == 0){
          return true;
      }else if(v[m].compareTo(palavraDoTexto) < 0){
          i = m+1;
      }else{
          f = m-1;
      }
    }
    return false;
  }
}
