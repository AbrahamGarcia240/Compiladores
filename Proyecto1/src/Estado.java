
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class Estado {
    
    // id es el identificador de cada estado, los booleanos nos dicen si es estado final o inicial
    private int id;
    private boolean esInicial;
    private boolean esFinal;
   
    //aqui guardo todas las trancisiones que parten de este estado
    private ArrayList<Transicion> trancisiones;

    public Estado(int id, boolean esInicial, boolean esFinal) {
        this.id = id;
        this.esInicial = esInicial;
        this.esFinal = esFinal;
        this.trancisiones= new ArrayList<Transicion>();
       
    }

    public int getId() {
        return id;
    }

    public boolean isEsInicial() {
        return esInicial;
    }

    public boolean isEsFinal() {
        return esFinal;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setEsInicial(boolean esInicial) {
        this.esInicial = esInicial;
    }

    public void setEsFinal(boolean esFinal) {
        this.esFinal = esFinal;
    }

    public void setTrancision( String simbolo, Estado destino ) {
        this.trancisiones.add(new Transicion(simbolo,destino));
       
    }

    public ArrayList<Transicion> getTrancisiones() {
        return trancisiones;
    }
    
    
    
    public int getNumeroDeTrancisiones(){
        return this.trancisiones.size();
    }
    
    public void eliminarTrancision(Integer destino){
        this.trancisiones.remove(destino);
    }
    
    public void eleminarTodasLasTrancisiones(){
        this.trancisiones.clear();
    }
    
    
}
