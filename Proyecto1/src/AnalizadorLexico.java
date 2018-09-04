
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
    private AFD autom;
    private String lexema;
    private Stack<Estado> pila;
    private boolean pasePorAccept;
    private boolean ImDone;
    
    public AnalizadorLexico(String cadena, AFD autom) {
        this.cadena = cadena;
        this.autom = autom;
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
    
    public int getToken(){
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
                            this.lexema=this.lexema+String.valueOf(cadena.charAt(indice));
                            //indice++;
                            
                            if(t.getDestino().isEsFinal()){
                                this.pasePorAccept=true;
                                token=e.getId();
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
                       
                        this.cadena=this.cadena.substring(indice);
                        pila.empty();
                        pila.push(this.autom.getEstadoInicial());
                        
                        return token;
                        
                    }
                    else{
                        System.out.println("\nLa cadena no es reconocida");
                        this.cadena=this.cadena.substring(indice+1);
                        
                        pila.empty();
                        pila.push(this.autom.getEstadoInicial());
                        return token;
                    }
                        
                }
                
                
               // System.out.println(cadena.charAt(indice));
            }
            this.ImDone=true;
            return token;
            
        
         } catch (Exception ex) {
                System.out.println(ex);
            }
        return token;
    }
    
    public String getLexema(){
        String aux=this.lexema;
        this.lexema="";
        return aux;
    }
    
    
    
}
