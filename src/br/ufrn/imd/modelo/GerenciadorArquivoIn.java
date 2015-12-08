package br.ufrn.imd.modelo;

import java.io.FileReader;
import java.util.Scanner;

public class GerenciadorArquivoIn implements GerenciadorIn
{
    private /*@ spec_public @*/ int n, d;
    private /*@ spec_public nullable @*/ FileReader arq;
    private /*@ spec_public nullable @*/ Scanner lerArq;
    private /*@ spec_public nullable @*/ String nome;
   
     
    GerenciadorArquivoIn(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo:");
        nome = ler.nextLine();
        ler.close();
    }
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
    public /*@ pure @*/ int getCusto(){
        return lerArq.nextInt();
    }
    public /*@ pure @*/ int getN(){
        return n;
    }

    public /*@ pure @*/ int getD(){
        return d;
    }
}
