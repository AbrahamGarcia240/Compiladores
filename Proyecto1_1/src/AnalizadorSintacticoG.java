/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class AnalizadorSintacticoG {
    
    private AnalizadorLexico Lexic;
    private Token T;
    private EstadoLexico E;

    public AnalizadorSintacticoG(String cadena, AFD autom, Token T) {
        this.Lexic = new AnalizadorLexico(cadena, autom);
        this.T=T;
    }
    
    Boolean ListaLadosDerP(Nodo N){
	int t;
	Nodo N2 = new Nodo();
	t=Lexic.getToken();
	if(t==T.Tokens.get("OR")){
            System.out.println("Lexema OR:"+Lexic.getLexema());
		if(LadoDerecho(N)){
			if(ListaLadosDerP(N2)){
				N.setAbajo(N2);
                                 //System.out.println("Abajo de "+N.getSimbolo()+" pongo a "+N2.getSimbolo());
				//N.setAbajo(N2.getAbajo());
			
				return true;
			}
		}
		//N.setDerecha(null);
		//N.setAbajo(null);
		return false;
	}
	Lexic.ReturnToken(t);
	N=null;
	return true;
}


    
    Boolean ListaReglasP(Nodo N){
	int t;
	EstadoLexico E=new EstadoLexico();
	Nodo N2=new Nodo();
        Lexic.buildEstadoLexico(E);
	if(Regla(N)){ //obtengo una regla
		t=Lexic.getToken();
		if(t==T.Tokens.get("PuntoYComa")){
                     System.out.println("Lexema punto y coma:"+Lexic.getLexema());
			if(ListaReglasP(N2)){
				N.setAbajo(N2);
                                //System.out.println("Abajo de "+N.getSimbolo()+" pongo a "+N2.getSimbolo());
				return true;
			}
		}
		return false;
	}
	//YA NO HABIAN MAS REGLAS
	N=null;
        Lexic.useEstadoLexico(E);
	//L=new Lista(); //quiere decir que no se recibio una regla, por lo tanto, se inicializa la lista L apuntando a NULL
	return true;
}
    
    
    Boolean LadoDerechoP(Nodo N){
	int t;
	Nodo N2 = new Nodo();
	t=Lexic.getToken();
	if(t==T.Tokens.get("Simbolo") || t==T.Tokens.get("Simbolo2") || t==T.Tokens.get("Simbolo3") || t==T.Tokens.get("Simbolo4") || t==T.Tokens.get("Simbolo5") || t==T.Tokens.get("Simbolo6") || t==T.Tokens.get("Simbolo7") || t==T.Tokens.get("Simbolo8")){
		N.setSimbolo(Lexic.getLexema().charAt(0));
                //System.out.println(N.getSimbolo());
                if(N.getSimbolo().equals('+') || N.getSimbolo().equals('-') || N.getSimbolo().equals('*') || N.getSimbolo().equals('/') || N.getSimbolo().equals('(') || N.getSimbolo().equals(')') || N.getSimbolo().equals('n') ){
                      N.setTerminal(true);
                      System.out.println("El simbolo "+N.getSimbolo()+" es terminal");
                  }

		if(LadoDerechoP(N2)){
			N.setDerecha(N2);
			//N.getAbajo().setDerecha(N2.getAbajo());
                        
                         //System.out.println("Derecha de "+N.getSimbolo()+" pongo a "+N2.getSimbolo());
			return true;
		}
		//N2.setDerecha(null);
		//N2.setAbajo(null);
		return false;
	}
	N=null;
	N2=null;
        Lexic.ReturnToken(t);
	return true;
}
    
    
    Boolean LadoDerecho(Nodo N){
	int t;
	Nodo N2= new Nodo();
	t=Lexic.getToken();
	if(t==T.Tokens.get("Simbolo") || t==T.Tokens.get("Simbolo2") || t==T.Tokens.get("Simbolo3") || t==T.Tokens.get("Simbolo4") || t==T.Tokens.get("Simbolo5") || t==T.Tokens.get("Simbolo6") || t==T.Tokens.get("Simbolo7") || t==T.Tokens.get("Simbolo8")){
		//N2.setSimbolo(Lexic.getLexema());
		  N.setSimbolo(Lexic.getLexema().charAt(0));
                  if(N.getSimbolo().equals('+') || N.getSimbolo().equals('-') || N.getSimbolo().equals('*') || N.getSimbolo().equals('/') || N.getSimbolo().equals('(') || N.getSimbolo().equals(')') || N.getSimbolo().equals('n') ){
                      N.setTerminal(true);
                      System.out.println("El simbolo "+N.getSimbolo()+" es terminal");
                  }
                  //System.out.println(N.getSimbolo());
                  
		if(LadoDerechoP(N2)){
			N.setDerecha(N2);
                         //System.out.println("Derecho de "+N.getSimbolo()+" pongo a "+N2.getSimbolo());
			//N.setDerecha(N2.getAbajo());
			return true;
		}
	}
	return false;
}
    
    Boolean ListaLadosDer(Nodo N){
	int t;
	Nodo N2= new Nodo();
	if(LadoDerecho(N)){
		if(ListaLadosDerP(N2)){
			//L.Addabajo(L2.getDerecha());
			//N.AddDerecha(N2);
                        N.setAbajo(N2);
                        // System.out.println("Abajo de "+N.getSimbolo()+" pongo a "+N2.getSimbolo());
			return true;
		}
	}
	return false;
}
    
    
    Boolean LadoIzquierdo(Nodo N){
	int t;
	t=Lexic.getToken();
	if(t==T.Tokens.get("Simbolo") || t==T.Tokens.get("Simbolo2") || t==T.Tokens.get("Simbolo3") || t==T.Tokens.get("Simbolo4") || t==T.Tokens.get("Simbolo5") || t==T.Tokens.get("Simbolo6") || t==T.Tokens.get("Simbolo7") || t==T.Tokens.get("Simbolo8")){
		//Nodo N2= new Nodo();
		//N2.setSimbolo(Lexic.getLexema());
		//N.setAbajo(N2);
		N.setSimbolo(Lexic.getLexema().charAt(0));
                //System.out.println(N.getSimbolo());
		return true;
	}
	return false;
}
    
    Boolean Regla(Nodo N){
        int t;
        Nodo N2= new Nodo();
        if(LadoIzquierdo(N)){
		t=Lexic.getToken();
		if(t==T.Tokens.get("Flecha")){
                        System.out.println("Lexema flecha:"+Lexic.getLexema());
			if(ListaLadosDer(N2)){
				//L.AddDerecha(N2);
				//N.AddDerecha(N2.getAbajo());
				//N.getAbajo().AddDerecha(N2.getAbajo());
				N.setDerecha(N2);
                                 //System.out.println("Derecha de "+N.getSimbolo()+" pongo a "+N2.getSimbolo());
				return true;
			}
		}
	}
	return false;
        
    }
    
    Boolean ListaReglas(Nodo N){
        int t;
        Nodo N2= new Nodo();
        
        if(Regla(N)){
            t=Lexic.getToken();
            if(t==T.Tokens.get("PuntoYComa")){
                System.out.println("Lexema punto y coma:"+Lexic.getLexema());
                if(ListaReglasP(N2)){
                    N.setAbajo(N2);
                     //System.out.println("Abajo de "+N.getSimbolo()+" pongo a "+N2.getSimbolo());
                    return true;
                }
            }
        }
        return false;
        
    }
    
    
    
    Boolean G(Nodo N){
        if(ListaReglas(N))
            return true;
        return false;
        
    }
    
    
}
