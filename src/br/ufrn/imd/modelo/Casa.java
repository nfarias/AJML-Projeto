package br.ufrn.imd.modelo;

public class Casa {
	
    private /*@ spec_public @*/ int id;
    private /*@ spec_public @*/ int rank;
    private /*@ spec_public @*/ int grau;
    private /*@ spec_public nullable @*/ Casa parent; 
    
    /**
     * Construtor da classe.
     */
    /*@
     @ requires id >= 0;
     @ ensures this.rank == 0 && this.grau == 0; 
     @ ensures this.parent == null;
     @ ensures this.id == id;
     @*/
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
    /*@
     @ ensures \result >= 0;
     @*/
    public /*@ pure @*/ int getGrau(){
        return grau;
    }
    /**
     * Altera o grau da casa.
     */
    /*@
     @ requires grau >= 0;
     @ ensures this.grau == grau;
     @*/
    public void setGrau(int grau){
        this.grau = grau;
    }
    /**
     * Retorna o Rank (nível) da casa.
     */
    /*@
     @ ensures \result >= 0;
     @*/
    public /*@ pure @*/ int getRank(){
        return rank;
    }
    /**
     * Altera o rank da casa.
     */
    /*@
     @ requires rank >= 0;
     @ ensures this.rank == rank;
     @*/
    public void setRank( int rank){
        this.rank = rank;
    }
    /**
     * Retorna o Id da casa.
     */
    /*@
     @ ensures \result >= 0;
     @*/
    public /*@ pure @*/ int getId(){
        return id;
    }
    /**
     * Altera o Id da casa.
     */
    /*@
     @ requires id >= 0;
     @ ensures this.id == id;
     @*/
    public void setId( int id){
       this.id = id; 
    }
    /**
     * Retorna o pai de uma casa.
     */
    /*@
     @ ensures \result != null; 
     @*/
    public /*@ pure @*/ Casa getParent(){
        return parent;
    }
    /**
     * Altera o pai de uma casa.
     */
    /*@
     @ requires parent != null;
     @ ensures this.parent == parent;
     @*/
    public void setParent( Casa parent){
        this.parent = parent;
    }
}

