package br.ufrn.imd.modelo;
import java.util.ArrayList;

public class Arvore{
	
	private /*@ spec_public nullable @*/ ArrayList < Aresta > arvore;
	private int custoTotal;
	/**
	 * Construtor da classe
	 */
	public Arvore(){
	    // initialise instance variables
	    custoTotal = 0;
	    arvore = new ArrayList < Aresta >();
	}
	/**
	 * Retorna o custo total de uma árvore.
	 */
	public int getCustoTotal(){
	    return custoTotal;
	}
	/**
	 * Altera o custo total de uma árvore.
	 */
	public void setCustoTotal(int total){
	    this.custoTotal = total;
	}
	/**
	 * Retorna uma árvore.
	 */
	public ArrayList < Aresta > getArvore(){
	    return arvore;
	}
	/**
	 * Altera uma árvore.
	 */
	public void setArvore( ArrayList < Aresta > arvore){
	    this.arvore = arvore;
	}
	/**
	 * Imprime a árvore.
	 */
	public void printArvore(){
	    for(Aresta aresta : arvore){
	        System.out.println(aresta.getCasa1().getId() + " " + aresta.getCasa2().getId() + " " + aresta.getCusto());
	    }
	}
}
