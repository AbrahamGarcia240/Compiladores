/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class EstadoLexico {
    
     //estado lexico
    
    private String cadenaEstadoLexico;
    private String cadenaEstadoLexicoAux;
    private String cadenaEstadoLexicoReal;
    private String cadenaEstadoLexicoRealAux;
    private boolean EstadoLexicoPasePorAccept;
    private boolean EstadoLexicoImDone;
    
    //fin del estado lexico

    public EstadoLexico() {
    }

    public String getCadenaEstadoLexico() {
        return cadenaEstadoLexico;
    }

    public void setCadenaEstadoLexico(String cadenaEstadoLexico) {
        this.cadenaEstadoLexico = cadenaEstadoLexico;
    }

    public String getCadenaEstadoLexicoAux() {
        return cadenaEstadoLexicoAux;
    }

    public void setCadenaEstadoLexicoAux(String cadenaEstadoLexicoAux) {
        this.cadenaEstadoLexicoAux = cadenaEstadoLexicoAux;
    }

    public String getCadenaEstadoLexicoReal() {
        return cadenaEstadoLexicoReal;
    }

    public void setCadenaEstadoLexicoReal(String cadenaEstadoLexicoReal) {
        this.cadenaEstadoLexicoReal = cadenaEstadoLexicoReal;
    }

    public String getCadenaEstadoLexicoRealAux() {
        return cadenaEstadoLexicoRealAux;
    }

    public void setCadenaEstadoLexicoRealAux(String cadenaEstadoLexicoRealAux) {
        this.cadenaEstadoLexicoRealAux = cadenaEstadoLexicoRealAux;
    }

    public boolean isEstadoLexicoPasePorAccept() {
        return EstadoLexicoPasePorAccept;
    }

    public void setEstadoLexicoPasePorAccept(boolean EstadoLexicoPasePorAccept) {
        this.EstadoLexicoPasePorAccept = EstadoLexicoPasePorAccept;
    }

    public boolean isEstadoLexicoImDone() {
        return EstadoLexicoImDone;
    }

    public void setEstadoLexicoImDone(boolean EstadoLexicoImDone) {
        this.EstadoLexicoImDone = EstadoLexicoImDone;
    }
    
    
    
    
    
}
