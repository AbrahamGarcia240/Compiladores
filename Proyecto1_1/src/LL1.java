
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
public class LL1 {
    
    private Nodo n;

    public LL1(Nodo n) {
        this.n = n;
    }
    
    
    public ArrayList<Character> First(ArrayList<Character> ListaSimbolos)
    {
        ArrayList<Character> Respuesta = new ArrayList<Character>();
//        BUSCO SI EL PRIMER CARACTER DEL FIRST ES TERMINAL
            Nodo A = new Nodo();
            Nodo B = new Nodo();
            Nodo C = new Nodo();
           A=n;
           B=A.getDerecha();
           C=B;
           
           while(A!=null){
               //System.out.println(A.getSimbolo());
               
               while(B!=null){
                   //System.out.println(B.getSimbolo());
                   if(ListaSimbolos.get(0).equals(B.getSimbolo())){ //valido que sea alpha 1
                       if(B.isTerminal() || B.getSimbolo().equals('#')){
                           Respuesta.add(B.getSimbolo());
                           return Respuesta;
                       }
                   }
                   
                   try {
                       B=B.getDerecha();
                       if(B==null){
                           if(C.getAbajo()!=null){
                               B=C.getAbajo();
                               C=B;
                               System.out.println(" ");
                           }
                       }
                       
                   } catch (Exception e) {
                   }
               }
               
               
               
               A=A.getAbajo();
               try {
                    B=A.getDerecha();
                    C=B;
               } catch (Exception e) {
                   
               }
              
               
           }
           
            
            
//        FIN DE LA BUSQUEDA
        return Respuesta;
    }    
    
}
