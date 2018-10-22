
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
       ArrayList<ArrayList<Character>> Ws = new ArrayList<ArrayList<Character>>();
      ArrayList<Character> Aux2 = new ArrayList<Character>();
      
        
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
                                     if(B.getDerecha().getSimbolo().equals('E') || B.getDerecha().getSimbolo().equals(')')  || B.getDerecha().getSimbolo().equals('(') || B.getDerecha().getSimbolo().equals('e') || B.getDerecha().getSimbolo().equals('T') || B.getDerecha().getSimbolo().equals('t') || B.getDerecha().getSimbolo().equals('F')  ){
                                        Nodo D=new Nodo();
                                        D=B.getDerecha();
                                        Aux2.add(A.getSimbolo());
                                        Ws.add( new ArrayList<Character>());
                                        while(D!=null){
                                            Ws.get(Ws.size()-1).add(D.getSimbolo());
                                            D=D.getDerecha();
                                        }
                                       
                                        //AGREGAR
                                     }   
                                     
                                 } catch (Exception e) {
                                     if(!Caracter.equals(A.getSimbolo())){
                                           Respuesta.addAll(Follow(A.getSimbolo()));
                                            System.out.println("Voy a hacer el follow de la "+A.getSimbolo());
                                     }
                                    
//                                     Aux.add(A.getSimbolo());
//                                     System.out.println("entre al catch");
//                                     System.out.println(A.getSimbolo());
//                                     System.out.println(Aux.size());
                                 }
                                     
                             }
                             
                                     
                            
                           
                           //Respuesta.add(B.getSimbolo());
                           
                       }
                        else{
                            Aux.remove(Aux.size()-1);
                        }
                   } catch (Exception e) {
                       // System.out.println("m");
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
                       //System.out.println("foal");
                   }
               }
               
               
              
               A=A.getAbajo();
               try {
                    B=A.getDerecha();
                    C=B;
               } catch (Exception e) {
                   //System.out.println("x");
               }
              
               
           }
//        FIN DE BUSQUEDA
        
        
        
//        for(Character cn: Aux){
//            System.out.println(cn);
//           if(!cn.equals(Caracter)){
//                Respuesta.addAll(Follow(cn));
//                System.out.println("Voy a hacer el follow de la "+cn);
//           }
//        }
      
        int indice=0;
        for (ArrayList<Character> temp : Ws) {
//			temp.forEach(n->System.out.print(n) );
//                        System.out.println("  ");

                        
                        if(!Aux2.get(indice).equals(Caracter)){
                            System.out.println(" voy a haver el First de" +temp);
                            temp.remove(1);
                            Aux.addAll(First(temp));
                            Respuesta.addAll(Aux);
                            if(Aux.contains('#')){
                                 Respuesta.removeIf(x->x.equals('#'));
                                 Respuesta.addAll(Follow(Aux2.get(indice)));

                            }
                        }
                        
                        
                        indice++;
		} 
//        System.out.println(" ");
//        System.out.println("EL TAMAÑO ES: "+Ws.size());
//      
//        for(Character cc: Aux2)
//            System.out.print(cc+" ");
    ArrayList<Character> Respuesta2 = new ArrayList<Character>();
    for(Character f: Respuesta){
        if(!Respuesta2.contains(f))
            Respuesta2.add(f);
    }
        return Respuesta2;
    }
    
    
    
    
    
    
}
