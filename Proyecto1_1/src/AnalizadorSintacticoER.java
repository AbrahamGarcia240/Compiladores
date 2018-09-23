/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class AnalizadorSintacticoER {
    
     private AnalizadorLexico Lexic;
    private Token T;

    public AnalizadorSintacticoER(String cadena, AFD autom, Token T) {
        this.Lexic = new AnalizadorLexico(cadena, autom);
        this.T=T;
    }
    
    
    private Boolean F(AutomataContainer v){
      
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
                   System.out.println("En F: "+v);
                   return true;
               }
           }
           System.out.println("En F: "+v);
           return false;
       }
       else if(tok==T.Tokens.get("EXP")||tok==T.Tokens.get("M")||tok==T.Tokens.get("m")||tok==T.Tokens.get("p")){
           //System.out.print("sali de F: ");
           String l=Lexic.getLexema();
           System.out.println("lexema:"+l);
           if(tok==T.Tokens.get("M"))
            v.setA(Automata.CreaAFNBasico('+'));
           else if(tok==T.Tokens.get("m"))
            v.setA(Automata.CreaAFNBasico('-'));
           else if(tok==T.Tokens.get("p"))
            v.setA(Automata.CreaAFNBasico('.'));
           else
            v.setA(Automata.CreaAFNBasico(l.charAt(0)));   
           v.getA().printAutomata();
           
           //System.out.println(v);
           System.out.println("En F: "+v);
           return true;
       }
       
      
       System.out.println("En F: "+v);
        //System.out.println("FALSO");
       return false;
    
    }
    
    private Boolean Cp(AutomataContainer v){
        int tok;
        
           
        tok=Lexic.getToken();
        int cmas=T.Tokens.get("CMAS");
        int cest=T.Tokens.get("CEST");
        int cpre=T.Tokens.get("CPRE");
        if(tok==T.Tokens.get("CMAS")||tok==T.Tokens.get("CEST")||tok==T.Tokens.get("CPRE")){
             System.out.println(Lexic.getLexema());
             
             if(tok==cmas)
                    v.setA(v.getA().CerraduraMas());
                     
             else if(tok==cest)
                     v.setA(v.getA().CerraduraEstrella());
             else if(tok==cpre)
                     v.setA(v.getA().CerraduraPregunta());
                    
                 
             
             
             System.out.println("En Cp"+v);
            return true;
        }
        System.out.println("EPSILON:" +tok+" ");
        Lexic.ReturnToken(tok);    
        System.out.println("En Cp: "+v);
        return true;
    
    }
    
    private Boolean C(AutomataContainer v){
       
        if(F(v)){
            if(Cp(v)){
                System.out.println("En C: "+v);
                return true;
            }
        }
        //System.out.println("FALSO P");
        System.out.println("En C: "+v);
        return false;
    }
    
    
    private Boolean Tp(AutomataContainer v){
       int tok;
       AutomataContainer v2=new AutomataContainer();
       tok=Lexic.getToken();
     
        //System.out.println("Sali de TP:"+tok);
       if(tok==T.Tokens.get("AND")){
           //System.out.println("Token Tp de DIV:"+tok);
           System.out.println(Lexic.getLexema());
           if(C(v2)){
               v.setA(v.getA().ConcatenarAutomata(v2.getA()));
             
               if(Tp(v)){
                   System.out.println("En Tp: "+v);
                   return true;
               }
           }
           //System.out.println("FALSO TP");
           System.out.println("En Tp: "+v);
           return false;
       }
        System.out.println("EPSILON "+tok);
       Lexic.ReturnToken(tok);
       System.out.println("En Tp: "+v);
       return true;
    
    }
    
    private Boolean Ep(AutomataContainer v){
        int tok;
        AutomataContainer v2=new AutomataContainer();

        tok=Lexic.getToken();
        int esMas=0;
        if(tok==T.Tokens.get("OR")){
            System.out.println(Lexic.getLexema());
          esMas=tok;
            if(T(v2)){
               v.setA( v.getA().UnirAutomata(v2.getA()));
              // v.getA().pintaAutomata();
                
                if(Ep(v)){
                    System.out.println("En Ep: "+v);
                    return true;
                }
            }
            //System.out.println("Falso en EP");
             System.out.println("En Ep: "+v);
            return false;
        }
        System.out.println("EPSION "+tok);
        System.out.println("En Ep: "+v);
        Lexic.ReturnToken(tok);
        return true;
        
    }
    
    private Boolean T(AutomataContainer v){
        if(C(v)){
            if(Tp(v)){
                System.out.println("En T: "+v);
                return true;
            }
        }
       // System.out.println("Falso en T");
       System.out.println("En T: "+v);
        return false;
    }
    
    private Boolean E(AutomataContainer v){
        
        if(T(v)){
            
            if(Ep(v)){
                System.out.println("En E: "+v);
                return true;
                
            }
        }
        System.out.println("En E: "+v);
        return false;
    }
    
    public Boolean Analiza(AutomataContainer v){
        
        if(E(v)){
            int t=Lexic.getToken();
            if(t==0){
                System.out.println("EN analiza: "+v);
                return true;
            }
         //   System.out.println(t);
             
        }
           
            
        return  false;
    }
    
}
