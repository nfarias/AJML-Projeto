package br.ufrn.imd.main;
import br.ufrn.imd.modelo.GeradorArvore;
/**
 * Chama o m�todo para a cria��o de uma �rvore e imprime o resultado.
 * Obs: Ao inserior o nome do arquivo, tamb�m escrever o seu tipo. Ex: Arquivo.txt, Arquivo.in
 */
public class Main{

	public static void main(String[] args){
		GeradorArvore main = new GeradorArvore();
	     main.criaArvore();
	     main.printFlorestaECusto();
	}
}