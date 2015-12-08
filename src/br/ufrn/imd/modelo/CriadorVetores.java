package br.ufrn.imd.modelo;

public class CriadorVetores {
    private int size;
    private /*@ spec_public nullable @*/ Casa[] casas;
    private /*@ spec_public nullable @*/ Aresta[] arestas;
    private /*@ spec_public nullable @*/ GerenciadorArquivoIn arquivo;
    /**
     * Construtor da classe
     */
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
    public Aresta[] criaArestas(){
            int i,cont=0;
            for(i=1; i<arquivo.getN(); i++){
                for(int j = i+1; j<=arquivo.getN(); j++){
                    int custo = arquivo.getCusto();
                    Aresta aresta = new Aresta(i, j, custo);
                    aresta.setCasa1(casas[i- 1]);
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
    public void print(){
        for(Aresta aresta: arestas ){
            System.out.println(aresta.getCasa1().getId() + " " + aresta.getCasa2().getId() + " " + aresta.getCusto());
        }
    }
   
        /**
      * Retorna um array de casas.
      */
    public Casa[] getCasas(){
        return casas;
    }
    /**
     * Retorna um array de arestas.
     */
    public Aresta[] getArestas(){
        return arestas;
    }
    public void setArestas(Aresta[] temp){
       arestas = temp; 
    }
    

    /**
     * Retorna o valor d de ligações que cada casa poderá ter.
     */
    public int getD(){
        return arquivo.getD();
    }
    /**
     * Retorna a quantidade de casas existentes.
     */
    public int getN(){
        return arquivo.getN();
    }
    /**
     * Retorna o tamanho do array de arestas possíveis
     */
    public int getSize(){
        return size;
    }
    /**
     * Calcula o fatorial de um valor.
     */   
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
    private int tamArray(int n){
        return fatorial(n)/(2*fatorial(n-2));
        
    }
}