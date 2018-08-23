
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
    private static int IdEdoAct=1;
    private int id;
    private boolean esInicial;
    private boolean esFinal;
   
    //aqui guardo todas las trancisiones que parten de este estado
    private ArrayList<Transicion> trancisiones;

    public Estado(boolean esInicial, boolean esFinal) {
        this.id = Estado.IdEdoAct++;
        //this.id = id;
        this.esInicial = esInicial;
        this.esFinal = esFinal;
        this.trancisiones= new ArrayList<Transicion>();
       
    }

    public int getId() {
        return id;
    }

    public boolean isEsInicial() {
        return this.esInicial;
    }

    public boolean isEsFinal() {
        return this.esFinal;
    }



    

    public void setEsInicial(boolean esInicial) {
        this.esInicial = esInicial;
    }

    public void setEsFinal(boolean esFinal) {
        this.esFinal = esFinal;
    }

    public void setTrancision( Character simbolo, Estado destino ) {
        this.trancisiones.add(new Transicion(simbolo,destino));
       
    }
    
    public void addTrancision(Transicion t){
        this.trancisiones.add(t);
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
