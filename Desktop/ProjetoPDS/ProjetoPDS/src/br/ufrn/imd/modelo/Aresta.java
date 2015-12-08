package br.ufrn.imd.modelo;

public class Aresta
{
    private int custo;
    private Casa home1;
    private Casa home2;

    /**
     * Constructor for objects of class Aresta
     */
    public Aresta(int h1, int h2, int custo)
    {
        this.custo = custo;
        home1 = new Casa(h1);
        home2 = new Casa(h2); 
    }
    
    public int getCusto(){
        return custo;
    }
    public void setCusto(int custo){
        this.custo = custo;
    }
    public Casa getCasa1(){
        return home1;
    }
    public void setCasa1( Casa hom1){
        this.home1 = hom1;
    }
    public Casa getCasa2(){
        return home2;
    }
    public void setCasa2( Casa hom2){
        this.home2 = hom2;
    }
}

