package br.ufrn.imd.modelo;
import java.util.ArrayList;

public class Arvore{

	private /*@ spec_public@*/ ArrayList < Aresta > arvore;
	private /*@ spec_public@*/ int custoTotal;
	
	//@ initially custoTotal == 0;
	/**
	 * Construtor da classe
	 */
	//@ requires arvore == null; 
	public Arvore(){
	    custoTotal = 0;
	    arvore = new ArrayList < Aresta >();
	}
	/**
	 * Retorna o custo total de uma �rvore.
	 */
	//@ pure
	public int getCustoTotal(){
	    return custoTotal;
	}
	/**
	 * Altera o custo total de uma �rvore.
	 */
	//@ requires 0 <= total;
	//@ assignable custoTotal;
	//@ ensures custoTotal == total;
	public void setCustoTotal(int total){
	    this.custoTotal = total;
	}
	/**
	 * Retorna uma �rvore.
	 */
	//@ pure
	public ArrayList < Aresta > getArvore(){
	    return arvore;
	}
	/**
	 * Altera uma �rvore.
	 */
	//@ requires arvore != null;
	//@ assignable this.arvore;
	//@ ensures this.arvore == arvore;
	public void setArvore( ArrayList < Aresta > arvore){
	    this.arvore = arvore;
	}
	/**
	 * Imprime a �rvore.
	 */
	//@ requires arvore != null;
	public void printArvore(){
	    for(Aresta aresta : arvore){
	        System.out.println(aresta.getCasa1().getId() + " " + aresta.getCasa2().getId() + " " + aresta.getCusto());
	    }
	}
}
