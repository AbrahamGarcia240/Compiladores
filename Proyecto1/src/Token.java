
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class Token {
    
    private AnalizadorLexico Lexic;
    public HashMap<String,Integer> Tokens;
    private AFD autom;

    public Token(AFD autom) {
        this.autom=autom;
        this.Tokens=new HashMap<String,Integer>();
    }
    
    public Integer DefineToken(String cadena,String Nombre){
        Lexic=new AnalizadorLexico(cadena, this.autom);
        int tok=Lexic.getToken();
        
        this.Tokens.put(Nombre,tok );
        return tok;
    }
    
   
   
    
    
    
}
