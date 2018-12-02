
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class Nodo {
    private Character simbolo;
    private Nodo derecha;
    private Nodo abajo;
    private Boolean terminal;

    public Nodo() {
        terminal = false;
       
        
    }

     
    
   void setSimbolo(Character c){
 	this.simbolo=c;
 }

 Character  getSimbolo(){
 	return simbolo;
 }

 void setDerecha(Nodo n){
 	this.derecha=n;
 }

 Nodo getDerecha(){
 	return derecha;
 }

 void setAbajo(Nodo n){
 	this.abajo=n;
 }

 Nodo getAbajo(){
 	return abajo;
 }

 void setTerminal(Boolean b){
 	this.terminal=b;
 }

 Boolean isTerminal(){
 	return terminal;
 }
 
 void addItems(){
     
     Nodo a=this;
     
    
    while(a!=null){
        if(a.getDerecha()!=null){
            Nodo b= a.getDerecha();
            ArrayList<Nodo> c= new ArrayList<Nodo>();
                int n=0;
                while(b!=null){
                    Nodo aux= new Nodo();
                    aux.setSimbolo((char)176);
                    aux.setDerecha(b);
                    aux.setAbajo(b.getAbajo());
                    if(n==0){
                        a.setDerecha(aux);
                        c.add(aux);
                    }
                    else{
                        c.get(c.size()-1).setAbajo(aux);
                    }
                    c.add(aux);
                    b=b.getAbajo();
                    
                    n++;
                }
                
            
        }
        a=a.getAbajo();
        
    }
 }
 
 void printNodo(){
     Nodo a=this;
     Nodo b=a.getDerecha();
     Nodo c=b;
     int n=0;
     while(a!=null){
         
         if(n==0){
              System.out.print(a.getSimbolo());
              n++;
              while(b!=null){
                  if(b.isTerminal()){
                      System.out.print("->"+b.getSimbolo()+" TERMINAL ");
                  }
                  else
                    System.out.print("->"+b.getSimbolo());
              
                  b=b.getDerecha();
                 if(b==null){
                     if(c.getAbajo().equals('\0')){
                       
                         b=c.getAbajo();
                         c=b;
                          System.out.println("");
                          System.out.print(" ");
                     }
                 }
              }
              System.out.println("");
         }
         if(a.getAbajo()!=null){
                System.out.println("|");
                System.out.println("v");
                System.out.print(a.getAbajo().getSimbolo());
                b=a.getAbajo().getDerecha();
                c=b;
                while(b!= null){
                 if(b.isTerminal()){
                      System.out.print("->"+b.getSimbolo()+" TERMINAL ");
                  }
                  else
                    System.out.print("->"+b.getSimbolo());
              
                    b=b.getDerecha();

                    if(b==null){
                        try {
                            if(!c.getAbajo().equals('\0')){
                               b=c.getAbajo();
                               c=b;
                                System.out.println("");
                                System.out.print(" ");
                           }    
                        } catch (Exception e) {
                        }
                    }
              }
              System.out.println("");
             
         }
        
         a=a.getAbajo();
         if(a!=null)
             b=a.getDerecha();
         
     }
     
 
 }
 
}
