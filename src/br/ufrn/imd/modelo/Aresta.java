package br.ufrn.imd.modelo;


public class Aresta
{	
	 
    private /*@ spec_public @*/ int custo;
    private /*@ spec_public nullable @*/ Casa home1;
    private /*@ spec_public nullable @*/ Casa home2; 

    /*@
     	requires h1 != h2;
     	requires custo >= 0;
     
     	assignable home1, home2, this.custo;
     	
     	ensures this.custo == custo;
     	ensures this.home1.getId() == h1;
     	ensures this.home2.getId() == h2;
     	
     @*/
    public  Aresta(int h1, int h2, int custo)
    {
        this.custo = custo;
        home1 = new Casa(h1);
        home2 = new Casa(h2); 
    }
   /*@
   @*/
    public /*@ pure @*/ int getCusto(){
        return custo;
    }
    public  void setCusto(int custo){
        this.custo = custo;
    }
    public /*@ pure  @*/ Casa getCasa1(){
        return home1;
    }
    public  void setCasa1( Casa hom1){
        this.home1 = hom1;
    }
    public /*@ pure @*/ Casa getCasa2(){
        return home2;
    }
    public void setCasa2( Casa hom2){
        this.home2 = hom2;
    }
}

