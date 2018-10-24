/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielmezam
 */
public class simbolosTablaLL1 {
     String pila;
     String cadena;
     String accions;

    public simbolosTablaLL1(String pila, String cadena, String accions) {
        this.pila = pila;
        this.cadena = cadena;
        this.accions = accions;
    }

    public String getPila() {
        return pila;
    }

    public void setPila(String pila) {
        this.pila = pila;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getAccions() {
        return accions;
    }

    public void setAccions(String accions) {
        this.accions = accions;
    }
     
}
