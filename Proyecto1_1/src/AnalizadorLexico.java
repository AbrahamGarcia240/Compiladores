
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class AnalizadorLexico {
    private String cadena;
    private String cadenaReal;
    private String cadenaRealAux;
    private String cadenaAux;
    private AFD autom;
    private String lexema;
    private Stack<Estado> pila;
    private boolean pasePorAccept;
    private boolean ImDone;
    
    public AnalizadorLexico(String cadena, AFD autom) {
        this.cadenaReal=cadena;
        this.cadenaRealAux=cadena;
        this.cadenaAux=cadena.replaceAll("[0-9]", "D");
        this.cadena = cadena.replaceAll("[0-9]", "D");
        
        this.cadenaAux=cadena.replaceAll("[a-zA-Z]", "D");
        this.cadena = cadena.replaceAll("[a-zA-Z]", "D");
        
        
     
         
        System.out.println("Cadena real "+this.cadenaReal);
        System.out.println(this.cadenaRealAux);
        System.out.println("Cadena prueba "+this.cadena);
        System.out.println(this.cadenaAux);
        
        this.autom = autom;
        this.cadenaAux=cadena;
        pila=new Stack<Estado>();
        this.lexema="";
        this.pasePorAccept=false;
        try {
            pila.add(this.autom.getEstadoInicial());
        } catch (Exception ex) {
            Logger.getLogger(AnalizadorLexico.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.ImDone=false;
        
    }
    
    public void ReturnToken(int n){
        this.cadena=this.cadenaAux;
        this.cadenaReal=this.cadenaRealAux;
        if(n!=0){
             this.ImDone=false;
        }
        else{
            this.ImDone=true;
        }
           
            
        
        pila.empty();
        try {
            pila.push(this.autom.getEstadoInicial());
        } catch (Exception ex) {
            Logger.getLogger(AnalizadorLexico.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        this.lexema="";
    
    }
    
    public int getToken(){
        
       // System.out.println("EVALUARE A "+cadena);
        if(this.ImDone){
            this.ImDone=false;
          
            return 0;
        }
        
        int token=1;
        int indice=0;
        Estado e;
         try {
                e=pila.pop();
            for(indice=0; indice<cadena.length(); indice++){  
                Character c=cadena.charAt(indice);
                
                long x=e.getTrancisiones().stream()
                        .filter(n->n.getSimbolo().equals(c))
                        .count();
                if(x>0){
                    for(Transicion t: e.getTrancisiones()){
                        if(t.getSimbolo()==cadena.charAt(indice)){
                            //this.lexema=this.lexema+String.valueOf(cadena.charAt(indice));
                            //System.out.println("en 1");
                            this.lexema=this.lexema+String.valueOf(cadenaReal.charAt(indice));
                            //indice++;
                            
                            if(t.getDestino().isEsFinal()){
                                this.pasePorAccept=true;
                                //System.out.print("El nuevo token es:");
                                token=t.getDestino().getToken();
                                //System.out.println(token);
                                 pila.push(e);

                            }
                            e=t.getDestino();
                             break;       
                        }

                    }
                }
                else{
                    if(this.pasePorAccept){
                        this.pasePorAccept=false;
                        this.cadenaAux=this.cadena;
                        this.cadenaRealAux=this.cadenaReal;
                      /*  System.out.println("en 2");
                         System.out.println(this.cadenaReal);
                        System.out.println(this.cadena);*/
                        this.cadena=this.cadena.substring(indice);
                        this.cadenaReal=this.cadenaReal.substring(indice);
                        //System.out.println(this.cadenaReal);
                        //System.out.println(this.cadena);
                        pila.empty();
                        pila.push(this.autom.getEstadoInicial());
                        //System.out.println("Subcadena es "+this.cadenaAux);
                        //System.out.println("Nueva cadena es "+this.cadena);
                        return token;
                        
                    }
                    else{
                        System.out.println("\nLa cadena no es reconocida");
                        this.cadenaAux=this.cadena;
                        this.cadenaRealAux=this.cadenaReal;
                        this.cadena=this.cadena.substring(indice+1);
                        this.cadenaReal=this.cadenaReal.substring(indice+1);
                        /*System.out.println(this.cadenaReal);
                        System.out.println(this.cadena);
                        System.out.println("Cadena aux es "+this.cadenaAux);
                        System.out.println("Nueva cadena es "+this.cadena);*/
                        pila.empty();
                        pila.push(this.autom.getEstadoInicial());
                        return token;
                    }
                        
                }
                
                
               // System.out.println(cadena.charAt(indice));
            }
            this.cadenaAux=this.cadena;
            this.cadenaRealAux=this.cadenaReal;
            // System.out.println("Cadena aux es "+this.cadenaAux);
             //           System.out.println("Nueva cadena es "+this.cadena);
            this.ImDone=true;
            return token;
            
        
         } catch (Exception ex) {
               System.out.println(cadenaReal);
                Logger.getLogger(AnalizadorLexico.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        return token;
    }
    
    public String getLexema(){
        String aux=this.lexema;
        this.lexema="";
        return aux;
    }
    
    
    
}
