
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
//          SOLO UN SIMBOLO
         for (ArrayList<Character> temp : Betas) {
			//temp.forEach(n->System.out.println(n) );
                       // System.out.println(" ");
                        //System.out.println(temp.size());
                        if(temp.size()>0)
                            Aux.addAll(First(temp));
		} 

         
//         FIN DE SOLO UN SIMBOLO

        if(Aux.size()==1)
            return Aux;
        if(Aux.contains('#') && ListaSimbolos.size()>1){
            Aux.removeIf(x->x.equals('#'));
            
            ArrayList<Character> Alterno = new ArrayList<Character> ();
            int miau=0;
            for(Character c: ListaSimbolos){
                
                if(miau!=0)
                    Alterno.add(c);
                miau++;
            }
            
            Aux.addAll(First(Alterno));
           
            
        }

        return Aux;
    }    
    
    
    public ArrayList<Character> Follow(Character Caracter)
    {
        ArrayList<Character> Respuesta = new ArrayList<Character>();
        ArrayList<Character> Aux = new ArrayList<Character>();
       
      
        
        if(Caracter.equals('E')){
             Respuesta.add('$');
        }
        
        Nodo A = new Nodo();
        Nodo B = new Nodo();
        Nodo C = new Nodo();
        A=n;
        B=A.getDerecha();
        C=B;
        
//        INICIO DE BUSQUEDA
        while(A!=null){
               //System.out.println(A.getSimbolo());
              
               while(B!=null){
                   //System.out.println(B.getSimbolo());
                    try {
                        if(Caracter.equals(B.getSimbolo())){
                            //System.out.println(B.getSimbolo()+" es igual a  "+Caracter);
                             if(!Aux.contains(A.getSimbolo())){
                                 try {
                                     if(B.getDerecha().getSimbolo().equals('E') || B.getDerecha().getSimbolo().equals('e') || B.getDerecha().getSimbolo().equals('T') || B.getDerecha().getSimbolo().equals('t') || B.getDerecha().getSimbolo().equals('F')  )
                                        System.out.println("nel");
                              
                                     
                                 } catch (Exception e) {
                                     System.out.println("Soy "+B.getSimbolo()+" mi derecha es "+B.getDerecha().getSimbolo());
                                     Aux.add(A.getSimbolo());
                                 }
                                     
                             }
                             
                                     
                            
                           
                           //Respuesta.add(B.getSimbolo());
                           
                       }
                   } catch (Exception e) {
                   }
                   try {
                       B=B.getDerecha();
                       if(B==null){
                           if(C.getAbajo()!=null){
                               B=C.getAbajo();
                               C=B;
                              
                               
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
//        FIN DE BUSQUEDA
        
        return Aux;
//        
//        for(Character cn: Aux){
//            if(!cn.equals(Caracter))
//                Respuesta.addAll(Follow(cn));
//        }
//        
//        for(Character cn: Aux){
//            if(cn.equals(Caracter)){
//                Aux=First(Aux)
//            }
//        }
//        
        
    }
    
    
    
    
    
    
}
