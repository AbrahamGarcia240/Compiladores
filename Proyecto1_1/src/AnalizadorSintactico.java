/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class AnalizadorSintactico {
    
    private AnalizadorLexico Lexic;
    private Token T;

    public AnalizadorSintactico(String cadena, AFD autom, Token T) {
        this.Lexic = new AnalizadorLexico(cadena, autom);
        this.T=T;
    }
    
    
    private Boolean F(){
       int tok;
       tok=Lexic.getToken();
        //System.out.println("token:"+tok);
       if(tok==T.Tokens.get("PARI")){
          // System.out.println(Lexic.getLexema());
           if(E()){
               tok=Lexic.getToken();
               if(tok==T.Tokens.get("PARD")){
                   //.out.println(Lexic.getLexema());
                   return true;
               }
           }
           return false;
       }
       else if(tok==T.Tokens.get("NUM")){
           //System.out.print("sali de F: ");
           //System.out.println(Lexic.getLexema());
           return true;
       }
        //System.out.println("FALSO");
       return false;
    
    }
    
    private Boolean Pp(){
        int tok;
        tok=Lexic.getToken();
        if(tok==T.Tokens.get("EXP")){
            if(F()){
                if(Tp()){
                    return true;
                }
            }
            return false;
        }
        //System.out.println("EPSILON:" +tok+" ");
        Lexic.ReturnToken(tok);       
        return true;
    
    }
    
    private Boolean P(){
        if(F()){
            if(Pp()){
                return true;
            }
        }
        //System.out.println("FALSO P");
        return false;
    }
    
    
    private Boolean Tp(){
       int tok;
       tok=Lexic.getToken();
        //System.out.println("Sali de TP:"+tok);
       if(tok==T.Tokens.get("PROD") || tok==T.Tokens.get("DIV")){
           //System.out.println("Token Tp de DIV:"+tok);
           if(P()){
               if(Tp()){
                   return true;
               }
           }
           //System.out.println("FALSO TP");
           return false;
       }
        //System.out.println("EPSILON "+tok);
       Lexic.ReturnToken(tok);
       return true;
    
    }
    
    private Boolean Ep(){
        int tok;
        tok=Lexic.getToken();
        
        if(tok==T.Tokens.get("MAS") || tok==T.Tokens.get("MENOS")){
          //  System.out.println(Lexic.getLexema());
            if(T()){
                if(Ep()){
                    return true;
                }
            }
            //System.out.println("Falso en EP");
            return false;
        }
        //System.out.println("EPSION "+tok);
        Lexic.ReturnToken(tok);
        return true;
        
    }
    
    private Boolean T(){
        if(P()){
            if(Tp()){
                return true;
            }
        }
       // System.out.println("Falso en T");
        return false;
    }
    
    private Boolean E(){
        
        if(T()){
            
            if(Ep()){
                return true;
            }
        }
        return false;
    }
    
    public Boolean Analiza(){
        if(E()){
            int t=Lexic.getToken();
            if(t==0){
                return true;
            }
         //   System.out.println(t);
             
        }
           
        return  false;
    }
    
    
}
