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
    
    
    private Boolean F(Flotante v){
       Flotante v2=new Flotante(0.0,"");
       int tok;
       tok=Lexic.getToken();
        //System.out.println("token:"+tok);
       if(tok==T.Tokens.get("PARI")){
            System.out.println(Lexic.getLexema());
          // System.out.println(Lexic.getLexema());
           if(E(v)){
               tok=Lexic.getToken();
               if(tok==T.Tokens.get("PARD")){
                    System.out.println(Lexic.getLexema());
                   //.out.println(Lexic.getLexema());
                   System.out.println("En F: "+v.getV());
                   return true;
               }
           }
           System.out.println("En F: "+v.getV());
           return false;
       }
       else if(tok==T.Tokens.get("NUM") || tok==T.Tokens.get("NUM2") || tok==T.Tokens.get("NUM3")){
           //System.out.print("sali de F: ");
           String l=Lexic.getLexema();
           //System.out.println("lexema:"+l);
          
           v.setV(Double.valueOf(l));
           v.setS(l);
           //System.out.println(v);
           System.out.println("En F: "+v.getV());
           return true;
       }
       
       else if(tok==T.Tokens.get(("SEN")) || tok==T.Tokens.get("COS") || tok==T.Tokens.get("TAN") || tok==T.Tokens.get("LOG")){
            System.out.println(Lexic.getLexema());
            int ver=tok;
           tok=Lexic.getToken();
           
           if(tok==T.Tokens.get("PARI")){
                System.out.println(Lexic.getLexema());
            // System.out.println(Lexic.getLexema());
             if(E(v2)){
                 System.out.println("NUGGEEET "+ver);
                 if(ver==T.Tokens.get(("SEN"))){
                     
                     v.setV(Math.sin(v2.getV()));
                     v.setS(v.getS()+" "+v2.getS()+" sen");
                    
                 }
                 else if(ver==T.Tokens.get(("COS"))){
                      v.setV(Math.cos(v2.getV()));
                      v.setS(v.getS()+" "+v2.getS()+" cos");
                 }
                 else if(ver==T.Tokens.get(("TAN"))){
                     v.setV(Math.tan(v2.getV()));
                     v.setS(v.getS()+" "+v2.getS()+" tan");
                 }
                 else if(ver==T.Tokens.get(("LOG"))){
                      v.setV(Math.log10(v2.getV()));
                      v.setS(v.getS()+" "+v2.getS()+" log");
                 }
                 tok=Lexic.getToken();
                 if(tok==T.Tokens.get("PARD")){
                      System.out.println(Lexic.getLexema());
                     //.out.println(Lexic.getLexema());
                     System.out.println("En F: "+v.getV());
                     return true;
                 }
             }
             return false;
         }
       }
       System.out.println("En F: "+v.getV());
        //System.out.println("FALSO");
       return false;
    
    }
    
    private Boolean Pp(Flotante v){
        int tok;
        Flotante v2= new Flotante(0.0,"");
           
        tok=Lexic.getToken();
        if(tok==T.Tokens.get("EXP")){
             System.out.println(Lexic.getLexema());
            if(F(v2)){
                v.setV(Math.pow(v.getV(), v2.getV()));
                v.setS(v.getS()+" "+v2.getS()+" ^");
                
                if(Tp(v)){
                    System.out.println("En Pp: "+v.getV());
                    return true;
                }
            }
            return false;
        }
        //System.out.println("EPSILON:" +tok+" ");
        Lexic.ReturnToken(tok);    
        System.out.println("En Pp: "+v.getV());
        return true;
    
    }
    
    private Boolean P(Flotante v){
        if(F(v)){
            if(Pp(v)){
                System.out.println("En P: "+v.getV());
                return true;
            }
        }
        //System.out.println("FALSO P");
        System.out.println("En P: "+v.getV());
        return false;
    }
    
    
    private Boolean Tp(Flotante v){
       int tok;
       Flotante v2= new Flotante(0.0,"");
       tok=Lexic.getToken();
       int esProd=tok;
        //System.out.println("Sali de TP:"+tok);
       if(tok==T.Tokens.get("PROD") || tok==T.Tokens.get("DIV")){
           //System.out.println("Token Tp de DIV:"+tok);
           System.out.println(Lexic.getLexema());
           if(P(v2)){
               if(esProd==T.Tokens.get("PROD")){
                   
                    v.setV(v.getV()*v2.getV());
                    v.setS(v.getS()+" "+v2.getS()+" *");
                }
                else{
                   v.setV(v.getV()/v2.getV());
                   v.setS(v.getS()+" "+v2.getS()+" /");
                   
                }
               if(Tp(v)){
                   System.out.println("En Tp: "+v.getV());
                   return true;
               }
           }
           //System.out.println("FALSO TP");
           System.out.println("En Tp: "+v.getV());
           return false;
       }
        //System.out.println("EPSILON "+tok);
       Lexic.ReturnToken(tok);
       System.out.println("En Tp: "+v.getV());
       return true;
    
    }
    
    private Boolean Ep(Flotante v){
        int tok;
        Flotante v2=new Flotante(0.0,"");
        tok=Lexic.getToken();
        int esMas=0;
        if(tok==T.Tokens.get("MAS") || tok==T.Tokens.get("MENOS")){
            System.out.println(Lexic.getLexema());
          esMas=tok;
            if(T(v2)){
                if(esMas==T.Tokens.get("MAS")){
                    
                    v.setV(v.getV()+v2.getV());
                    v.setS(v.getS()+" "+v2.getS()+" +");
                }
                else{
                    v.setV(v.getV()-v2.getV());
                    v.setS(v.getS()+" "+v2.getS()+" -");
                }
                
                if(Ep(v)){
                    System.out.println("En Ep: "+v.getV());
                    return true;
                }
            }
            //System.out.println("Falso en EP");
             System.out.println("En Ep: "+v.getV());
            return false;
        }
        //System.out.println("EPSION "+tok);
        System.out.println("En Ep: "+v.getV());
        Lexic.ReturnToken(tok);
        return true;
        
    }
    
    private Boolean T(Flotante v){
        if(P(v)){
            if(Tp(v)){
                System.out.println("En T: "+v.getV());
                return true;
            }
        }
       // System.out.println("Falso en T");
       System.out.println("En T: "+v.getV());
        return false;
    }
    
    private Boolean E(Flotante v){
        
        if(T(v)){
            
            if(Ep(v)){
                System.out.println("En E: "+v.getV());
                return true;
                
            }
        }
        System.out.println("En E: "+v);
        return false;
    }
    
    public Boolean Analiza(Flotante v){
        
        if(E(v)){
            int t=Lexic.getToken();
            if(t==0){
                System.out.println("EN analiza: "+v.getV());
                return true;
            }
         //   System.out.println(t);
             
        }
           
            
        return  false;
    }
    
    
}
