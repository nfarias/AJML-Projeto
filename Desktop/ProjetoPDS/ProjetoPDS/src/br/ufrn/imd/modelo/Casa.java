package br.ufrn.imd.modelo;

public class Casa {
    private int id;
    private int rank;
    private int grau;
    private Casa parent;
    /**
     * Construtor da classe.
     */
    public Casa(int id)
    {
        this.id = id;
        rank = 0;
        grau = 0;
        parent = null;
    }
    /**
     * Retorna o grau de uma casa, ou seja, quantas ligações ela já possui.
     */
    public int getGrau(){
        return grau;
    }
    /**
     * Altera o grau da casa.
     */
    public void setGrau(int grau){
        this.grau = grau;
    }
    /**
     * Retorna o Rank (nível) da casa.
     */
    public int getRank(){
        return rank;
    }
    /**
     * Altera o rank da casa.
     */
    public void setRank( int grau){
        this.rank = grau;
    }
    /**
     * Retorna o Id da casa.
     */
    public int getId(){
        return id;
    }
    /**
     * Altera o Id da casa.
     */
    public void setId( int id){
       this.id = id; 
    }
    /**
     * Retorna o pai de uma casa.
     */
    public Casa getParent(){
        return parent;
    }
    /**
     * Altera o pai de uma casa.
     */
    public void setParent( Casa parent){
        this.parent = parent;
    }
}

