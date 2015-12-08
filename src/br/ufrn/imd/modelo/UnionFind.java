package br.ufrn.imd.modelo;

 public class UnionFind {
	/**
	 * Construtor da classe. � vazio pois apenas os m�todos ser�o utilizados.
	 */
	UnionFind(){}
	/**
	 * Cria os conjuntos disjuntos. Torna cada casa pai de si mesmo.
	 */
	public void makeSet(Casa c){
		c.setParent(c);
		c.setRank(0);
	}
	/**
	 * Verifica qual � o pai da casa.
	 */
	public Casa find (Casa c){
		while(c.getRank() > 0){
			c= c.getParent();
		}
		return c;
	}
	/**
	 * Verifica se o pai de duas casas � o mesmo.
	 */
	public boolean connected (Casa c1, Casa c2){
		return find(c1) == find(c2);
	}
	/**
	 * Une duas casas para criar um conjunto �nico, ou seja, uma aresta. Determina quem ser�
	 * o pai de acordo com o rank da casa. No fim, o rank do filho ser� o de seu pai + 1.
	 */
	public void link(Casa c1, Casa c2){
		if(c1.getRank() > c2.getRank()){
			c2.setParent(c1);
			c2.setRank(c2.getParent().getRank()+1);
		}
		else{
			c1.setParent(c2);
			c1.setRank(c2.getParent().getRank()+1);
		}
		
	}
	/**
	 * Chama connected e verifica se � poss�vel fazer o link das casas. se sim, chama link. caso
	 * contr�rio, imprime na tela e sai.
	 */
	public void union(Casa c1, Casa c2){
		if(!connected(c1,c2)){
			link(c1,c2);
		}
		else{
			System.out.println("N�o pode conectar");
			return;
		}
	}

}

