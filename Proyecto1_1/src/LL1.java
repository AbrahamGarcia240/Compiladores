
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
        ArrayList<Character> Aux = new ArrayList<Character>();
        
        ArrayList<ArrayList<Character>> Betas = new ArrayList<ArrayList<Character>>();
       
        
//        BUSCO SI EL PRIMER CARACTER DEL FIRST ES TERMINAL
            Nodo A = new Nodo();
            Nodo B = new Nodo();
            Nodo C = new Nodo();
           A=n;
           B=A.getDerecha();
           C=B;
           
           Betas.add( new ArrayList<Character>());
           
           while(A!=null){
               //System.out.println(A.getSimbolo());
               
               while(B!=null){
                   //System.out.println(B.getSimbolo());
//                   CREO LISTA DE LADOS DERECHOS
                      try {
                        if(ListaSimbolos.get(0).equals(A.getSimbolo())){
                           
                           Betas.get(Betas.size()-1).add(B.getSimbolo());
                           
                           //Respuesta.add(B.getSimbolo());
                           
                       }
                   } catch (Exception e) {
                   }

//                    FIN DE CREACION DE LISTA DE LADOS DERECHOS
                   try {
                        if(ListaSimbolos.get(0).equals(B.getSimbolo())){ //valido que sea alpha 1
                            if(B.isTerminal() || B.getSimbolo().equals('#')){
                                Respuesta.add(B.getSimbolo());
                                return Respuesta;
                            }
                        }
                   } catch (Exception e) {
                   }
                   
                   try {
                       B=B.getDerecha();
                       if(B==null){
                           if(C.getAbajo()!=null){
                               B=C.getAbajo();
                               C=B;
                               Betas.add( new ArrayList<Character>());
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
            
         for (ArrayList<Character> temp : Betas) {
			//temp.forEach(n->System.out.println(n) );
                       // System.out.println(" ");
                        //System.out.println(temp.size());
                        if(temp.size()>0)
                            Aux.addAll(First(temp));
		} 

        return Aux;
    }    
    
}
