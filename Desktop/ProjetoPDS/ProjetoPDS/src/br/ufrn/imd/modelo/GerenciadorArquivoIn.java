package br.ufrn.imd.modelo;

import java.io.FileReader;
import java.util.Scanner;

public class GerenciadorArquivoIn implements GerenciadorIn
{
    private /*@ spec_public @*/ int n, d, custo;
    private /*@ spec_public nullable @*/ FileReader arq;
    private /*@ spec_public nullable @*/ Scanner lerArq;
    private /*@ spec_public nullable @*/ String nome;
    
    /*@ 
      @ requires nome = null;
      @ assignable nome, ler;
      @ ensures nome != null;
      @*/ 
    GerenciadorArquivoIn(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo:");
        nome = ler.nextLine();
        ler.close();
    }
    /*@ public normal_behavior 
      @		requires arq == null;
      @ 	requires lerArq == null;
      @		requires nome != null;
	  @ 	requires n == 0 ;
      @ 	requires d == 0;
      @		assignable arq, lerArq, n , d;
      @ 	ensures 0 <= n;
      @ 	ensures 0 <= d;
      @		ensures lerArq != null;
      @		ensures arq != null;
      @ also
      @	public exceptional_behavior
      @		requires arq == null;
      @ 	requires lerArq == null;
      @		requires nome != null;
	  @ 	requires n == 0 ;
      @ 	requires d == 0;
      @		assignable arq, lerArq, n , d;
      @		signals_only Exception;
      @ 	signals (Exception e)
      @			
      @*/
    public void leituraArquivo(){
        try{
            arq = new FileReader(nome);
            lerArq = new Scanner(arq);
            n = lerArq.nextInt();
            d = lerArq.nextInt();
        }
        catch(Exception e){
            System.out.println("Arquivo não encontrado");
        }
    }
    //@ pure
    public int getCusto(){
        return custo = lerArq.nextInt();
    }
    //@ pure
    public int getN(){
        return n;
    }
    //@ pure
    public int getD(){
        return d;
    }
}
