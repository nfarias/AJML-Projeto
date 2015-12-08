package br.ufrn.imd.main;
import br.ufrn.imd.modelo.GeradorArvore;
/**
 * Chama o método para a criação de uma árvore e imprime o resultado.
 * Obs: Ao inserior o nome do arquivo, também escrever o seu tipo. Ex: Arquivo.txt, Arquivo.in
 */
public class Main{

	public static void main(String[] args){
		GeradorArvore main = new GeradorArvore();
	     main.criaArvore();
	     main.printFlorestaECusto();
	}
}