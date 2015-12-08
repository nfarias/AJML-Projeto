package br.ufrn.imd.modelo;

public class CriadorVetores {
    private int size;
    private Casa[] casas;
    private Aresta[] arestas;
    private GerenciadorArquivoIn arquivo;
    /**
     * Construtor da classe
     */
    //@ invariant 0 < size;
    
    /*@ requires arquivo == null;
      @ requires casas == null;
      @ requires arestas == null;
      @ assignable arquivo, casas, arestas, size;
      @ ensures 0 < size;
      @ ensures arquivo != null;
      @ ensures (\forall int i;
	  @ 				0 <= i && i < arquivo.getN();
	  @ 			casas[i] == null);
	  @ ensures (\forall int j;
	  @ 				0 <= j && j < size;
	  @ 			arestas[j] == null);
	  @ ensures casas != null;
	  @ ensures arestas != null;
      @*/
    CriadorVetores(){
    	
        arquivo = new GerenciadorArquivoIn();
        arquivo.leituraArquivo();
        casas = new Casa[arquivo.getN()];
        size = tamArray(arquivo.getN());
        arestas = new Aresta[size];
        
    }
    /**
     * Cria e retorna um array de casas
     */
    /*@ requires arquivo != null
      @ requires casas != null;
      @ requires (\forall int i; 0 <= i && i < casas.length;
      @            casas[i] == null)
      @ assignable casas;
      @ ensures casas != null;
      @ ensures (\forall int j; 0 <= j && j < casas.length;
      @            casas[i].getId() == i+1);
      @*/
    public Casa[] vetorCasas(){
            int i;
            for(i=0;i<arquivo.getN();i++){
                Casa c = new Casa(i + 1);
                casas[i]= c;
            }
        return casas;
    }
    /**
     * Cria um array com as arestas possíveis dado um arquivo de texto.
     */
    /*@ requires arquivo != null;
      @ requires casas != null;
      @ requires this.aresta != null;
      @
      @ requires (\forall int j; 0 <= j && j < arestas.length;
      @            	arestas[i] == null)
      @
      @ assignable aresta, custo, arestas, cont;
      @
      @ ensures arestas != null;
      @ ensures 0 <= arestas.lenght 
      @ ensures 0 <= custo;
      @ ensures (\forall int i; 0 <= i && i < arestas.length;
      @				arestas[i] != null);
      @ 
      @*/
    public Aresta[] criaArestas(){
            int i,cont=0;
            for(i=1; i<arquivo.getN(); i++){
                for(int j = i+1; j<=arquivo.getN(); j++){
                    int custo = arquivo.getCusto();
                    Aresta aresta = new Aresta(i, j, custo);
                    aresta.setCasa1(casas[i - 1]);
                    aresta.setCasa2(casas[j - 1]);
                    if(cont <size){
                        arestas[cont]= aresta;
                        cont++;
                    }
                }
            }
        return arestas;
    }
    /**
     * Chama o método para criar o array de casas e o de arestas. Retorna um array de arestas.
     */
    
    public Aresta[] criaVetor(){
       vetorCasas();
       return criaArestas();
    }
    /**
     * Imprime as arestas.
     */
    //@ pure
    //@ requires arestas != null;
    //@ requires 1 <= arestas.lenght
    public void print(){
        for(Aresta aresta: arestas ){
            System.out.println(aresta.getCasa1().getId() + " " + aresta.getCasa2().getId() + " " + aresta.getCusto());
        }
    }
   
        /**
      * Retorna um array de casas.
      */
    //@ pure
    public Casa[] getCasas(){
        return casas;
    }
    /**
     * Retorna um array de arestas.
     */
    //@ pure
    public Aresta[] getArestas(){
        return arestas;
    }
    //@ requires temp != null;
    //@ assignable arestas;
    //@ ensures arestas == temp;
    public void setArestas(Aresta[] temp){
       arestas = temp; 
    }
    

    /**
     * Retorna o valor d de ligações que cada casa poderá ter.
     */
    //@ pure
    public int getD(){
        return arquivo.getD();
    }
    /**
     * Retorna a quantidade de casas existentes.
     */
    //@ pure
    public int getN(){
        return arquivo.getN();
    }
    /**
     * Retorna o tamanho do array de arestas possíveis
     */
    //@ pure
    public int getSize(){
        return size;
    }
    /**
     * Calcula o fatorial de um valor.
     */   
    /*@ requires 0 < n; 
      @ assignable n, aux;
      @ ensures 1 <= n;
      @*/
    private int fatorial(int n){
        int aux =n-1;
        while(aux>1){
            n *= aux;
            aux -=1;
        }
        return n;
    }
    /**
     * Retorna o tamanho exato que um array precisará ter para guardar as combinações de casas
     * para criar as arestas, sem repetição. Utiliza o método fatorial.
     */
    /*@ requires 0 < n;
      @ ensures 1 <= n;
      @*/
    private int tamArray(int n){
        return fatorial(n)/(2*fatorial(n-2));
        
    }
}