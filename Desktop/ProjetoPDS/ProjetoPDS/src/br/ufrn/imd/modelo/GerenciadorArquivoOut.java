package br.ufrn.imd.modelo;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GerenciadorArquivoOut implements GerenciadorOut
{
    GerenciadorArquivoOut(Arvore tree){
    try{
            FileWriter arq = new FileWriter("Resposta.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println("Custo Total: " + tree.getCustoTotal());
            for(Aresta aresta : tree.getArvore()){
                gravarArq.println(aresta.getCasa1().getId() + " " + aresta.getCasa2().getId());
            }
            arq.close();
            System.out.println("Arquivo salvo");
        }
        catch(Exception e){
            System.out.println("Arquivo nao pode ser criado");
        }
    }
    
    public void Salvar(Arvore tree){
        try{
            FileWriter arq = new FileWriter("Resposta.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println("Custo Total: " + tree.getCustoTotal());
            for(Aresta aresta : tree.getArvore()){
                gravarArq.println(aresta.getCasa1().getId() + " " + aresta.getCasa2().getId());
            }
            arq.close();
            System.out.println("Arquivo salvo");
        }
        catch(Exception e){
            System.out.println("Arquivo nao pode ser criado");
        }
    }
}

