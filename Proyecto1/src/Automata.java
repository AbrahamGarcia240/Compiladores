
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
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
public class Automata {
   private ArrayList <String> Lenguaje;
   private Map <Integer,Estado> Estados;
   private Integer estadoInicial;
   private ArrayList <Transicion> Trancisiones;
   private Integer estadoFinal;

    public Automata() { 
      
       this.estadoInicial=0;
       this.estadoFinal=0;
       this.Lenguaje=new ArrayList<String>();
       this.Estados=new HashMap <Integer, Estado>();
       this.Trancisiones= new ArrayList<Transicion>();
    }

    public ArrayList<String> getLenguaje() {
        return Lenguaje;
    }

    public Map<Integer, Estado> getEstados() {
        return Estados;
    }

 

    public void setLenguaje(ArrayList <String> Lenguaje) {
        this.Lenguaje = Lenguaje;
    }

    public void setEstados(Map<Integer, Estado> Estados) {
        this.Estados = Estados;
    }

    
    public void setEstadoInicial(Integer id) throws Exception{
        if(this.estadoInicial==0){
            if(this.Estados.containsKey(id)){
                this.Estados.get(id).setEsInicial(true);
                this.estadoInicial=id;
            }
            else{
                throw new Exception("No se puede agregar el estado final, el nodo no existe");
            }
            
        }
        else{
            throw new Exception("No se puede agregar estado porque ya existe un estado inicial");
        }
        
    }

    public void setEstadoFinal(Integer id){
        this.Estados.get(id).setEsFinal(true);
        this.estadoFinal=id;
    }
    
    public Estado getEstadoInicial() throws Exception{
        
        if(this.estadoInicial==0){
            throw new Exception("No existe un estado inicial para este automata");
        }
        else{
            return this.Estados.get(this.estadoInicial);
        }
        
        
    }
    public Estado getEstadoFinal() throws Exception{
        if(this.estadoFinal==0){
            throw new Exception("No existe un estado final para este automata");
        }
        else{
            return this.Estados.get(this.estadoFinal);
        }
    }
    
    
    
    
   
    
    
    public void setTrancision(int inicial, String simbolo, int destino){
        
        if(this.Estados.containsKey(inicial))
        {
            if(this.Estados.containsKey(destino)){
                //existen las dos claves
            }
            else{
                this.Estados.put(destino,new Estado(destino, false, false));
            }
            
        }
        else{
            //creo el estado inicial
            this.Estados.put(inicial,new Estado(inicial, false, false));
            
            if(this.Estados.containsKey(destino)){
                //existen las dos claves
            }
            else{
                this.Estados.put(destino,new Estado(destino, false, false));
            }
        }
        
        //aqui ya existen los dos estados, ahora hago la trans
        
        this.Estados.get(inicial).setTrancision(simbolo, this.Estados.get(destino));
        
        
    }
    
    public void printLenguaje(){
        this.Lenguaje.forEach(n-> System.out.println(n) );
    }
    public void addSimboloToLenguaje(String e){
        if(!this.Lenguaje.contains(e))
            this.Lenguaje.add(e);
    }

  
    
    public void printAutomata(){
    
         
        for(Map.Entry<Integer, Estado> e: this.Estados.entrySet()){
            System.out.print(e.getValue().getId());
          e.getValue().getTrancisiones()          
                    .forEach(n->n.printTrancision());
            
        }
    }
    
    
   
   
   
   
    
}
