
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
public class LR {
    
    private Nodo maestro;

    public LR(Nodo n) {
        maestro=n;
    }
    
    
    public ArrayList<Nodo> Cerradura(Nodo n){ 
        ArrayList<Nodo> resultado= new ArrayList<Nodo>();
        resultado= this.Union(this.CerraduraInterna(n));
        return resultado;
    
    }
    
    private ArrayList<Nodo> CerraduraInterna(Nodo n){  
        ArrayList<Nodo> resultado= new ArrayList<Nodo>();
        if(this.BuscaPunto(n).getDerecha().isTerminal()){
            resultado.add(n);
            return resultado;
        }
        
        resultado.add(n);
        
        for(Nodo aux: this.BuscaFilasConLadoDerecho(this.BuscaPunto(n).getDerecha().getSimbolo())){
            //System.out.println("Hize comparacion de "+aux.getSimbolo()+" con "+this.BuscaPunto(aux).getDerecha().getSimbolo());
            try {
                if(aux.getSimbolo().equals(this.BuscaPunto(aux).getDerecha().getSimbolo())){
                    //System.out.println("entree con");
                    //this.ImprimeHorizontal(aux);
                    //resultado=this.Union(resultado, aux);
                    resultado.add(aux);

                 }

                 else{
                     for(Nodo aux2: Cerradura(aux)){
                         resultado.add(aux2);
                     }

                 }
            } catch (Exception e) {
            }
        }
        
        
       return resultado;
    
    
    }
    
    public ArrayList<Nodo> Union(ArrayList<Nodo> conjunto){
         ArrayList<Nodo> resultado= new ArrayList<Nodo>();
         int i=0;
        Nodo aux=new Nodo();
         for (Nodo nodo : conjunto) {
             
            if(i==0){
                resultado.add(nodo);
                aux=nodo;
            }
            else{
                
                Nodo aux2=nodo;
                while(aux2!=null || aux!=null){
                    
                    try {
                        
                         if(!aux2.getSimbolo().equals(aux.getSimbolo())){
                             if(this.Verificador(nodo))
                                resultado.add(nodo);
                            break;
                        }
                    } catch (Exception e) {
                    }
                    if(aux2.getDerecha()!=null)
                        aux2=aux2.getDerecha();
                    else
                        break;
                    if(aux.getDerecha()!=null)
                        aux=aux.getDerecha();
                    else
                       break;
                
                }
                aux=nodo;
                
            }
            i++;
        }
        return resultado;
    }
    
    private Boolean Verificador(Nodo n){
        int i=0;
        while(n!=null){
           n=n.getDerecha();
           i++;  
        }
        if(i>3)
            return true;
        
        
        return  false;
    }
    
    private void ImprimeHorizontal(Nodo n){
        while(n!=null){
            System.out.print(n.getSimbolo()+"->");
            n=n.getDerecha();
        }
        System.out.println("");
    
    }
    
    
    private Nodo BuscaPunto(Nodo n){
       Nodo aux=n;
       while(aux.getSimbolo().compareTo((char)176)!=0){
           aux=aux.getDerecha();
       }
       return aux;
    }
    
    private ArrayList<Nodo> BuscaFilasConLadoDerecho(Character c){
        ArrayList<Nodo> resultado= new ArrayList<Nodo>();
        
        Nodo aux=maestro;
        while(aux!=null){
            try {
                if(aux.getSimbolo().equals(c)){
                    Nodo b=aux.getDerecha();
                    
                    while(b!=null){
                        Nodo aux2=new Nodo();
                        aux2.setSimbolo(c);
                        aux2.setDerecha(b);
                        resultado.add(aux2);
                        b=b.getAbajo();
                    }
                    
                    
               }
            } catch (Exception e) {
            }
             aux=aux.getAbajo();
            
            
        }
        return resultado;
    
    }
}
