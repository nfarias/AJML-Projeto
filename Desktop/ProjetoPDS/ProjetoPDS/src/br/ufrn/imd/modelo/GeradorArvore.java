package br.ufrn.imd.modelo;

import java.util.ArrayList;

public class GeradorArvore
{

    private UnionFind unionFind;
    private CriadorVetores vetor;
    private Arvore tree;
    private ArrayList < Arvore > floresta;
    private GerenciadorArquivoOut arq;

    /**
     * Construtor da classe
     */
    public GeradorArvore()
    {
        floresta = new ArrayList < Arvore >();
        unionFind = new UnionFind();
        vetor = null;
        tree = null;
    }
    /**
     * Utiliza as outras classes para criar uma nova árvore, dado um arquivo de texto
     */
    public void criaArvore(){
            tree = new Arvore();
            vetor = new CriadorVetores();
            vetor.criaVetor();
            Aresta[] aux = vetor.getArestas();
            
            for(Aresta aresta : aux){
                unionFind.makeSet(aresta.getCasa1());
                unionFind.makeSet(aresta.getCasa2());
            }
            for(Aresta aresta : aux){
                if(unionFind.find(aresta.getCasa1()) == unionFind.find(aresta.getCasa2())){
                    System.out.println("Já estão linkados");
                }
                else
                {
                    if(aresta.getCasa1().getGrau() < vetor.getD() && aresta.getCasa2().getGrau() < vetor.getD()){ 
                        
                        unionFind.union(aresta.getCasa1(), aresta.getCasa2());
                        
                        aresta.getCasa1().setGrau(aresta.getCasa1().getGrau() + 1);  
                        aresta.getCasa2().setGrau(aresta.getCasa2().getGrau() + 1);
                        
                        tree.setCustoTotal(tree.getCustoTotal() + aresta.getCusto());
                        
                        tree.getArvore().add(aresta);
                        tree.printArvore();
                        System.out.println("Custo: " + tree.getCustoTotal());
                    }
                }
            }
            addFloresta(tree);
            arq = new GerenciadorArquivoOut(tree);
            vetor = null;
            tree = null;
            aux = null;
            
    }
    /**
     * Adiciona uma árvore na lista de árvores (floresta)
     */
    private void addFloresta(Arvore tree){
        floresta.add(tree);
    }
    /**
     * Imprime a floresta/árvore e seu respectivo custo.
     */
    public void printFlorestaECusto(){
        int i = 1;
        for(Arvore tree : floresta){
            tree.printArvore();
            System.out.println("Custo total da Arvore numero: " + i + "\n" + tree.getCustoTotal());
            i++;
        }
    }

}
