
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
    
    /*
     El lenguaje es un arreglo dinamico de strings
     Los estados estan guardados en un hasmap, si quiero acceder al estado 3, uso la clave 3
     En un integer guardo el estado inicial del automata
     Todas las trancisiones que existen en el automata tambien se guardan aqui
     El Automata puede tener varios estados finales, los he guardado en un arreglo
    
    */
    
   private ArrayList <Character> Lenguaje;
   private Map <Integer,Estado> Estados;
   private Integer estadoInicial;
   private ArrayList <Transicion> Trancisiones;
   private ArrayList<Integer> estadoFinal;

    public Automata() { 
      
       this.estadoInicial=0;
       this.estadoFinal=new ArrayList<Integer>();
       this.Lenguaje=new ArrayList<Character>();
       this.Estados=new HashMap <Integer, Estado>();
       this.Trancisiones= new ArrayList<Transicion>();
    }

    
    
    
    
    public void setEstadoInicial(Integer id) throws Exception{
        if(this.estadoInicial==0){ //si no hay un estado inicial
            if(this.Estados.containsKey(id)){ //y el id que recibi es un estado que existe en el AFN
                this.Estados.get(id).setEsInicial(true); //accedo al estado a traves del Hashmap y dentro de el prendo la bandera de inicial
                this.estadoInicial=id; //en el AFN lo declaro como inicial
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
        this.Estados.get(id).setEsFinal(true); //accedo al estado a traves del Hashmap y dentro prendo la bandera de estado final
        this.estadoFinal.add(id); //agrego el ID de este estado a la coleccion de estados finales
    }
    
    public Estado getEstadoInicial() throws Exception{
        
        if(this.estadoInicial==0){
            throw new Exception("No existe un estado inicial para este automata");
        }
        else{
            return this.Estados.get(this.estadoInicial);
        }
        
        
    }
  
    /*
        Dado un estado e, CerraduraEpsilon nos dice todos los estados a los que puedo llegar
        usando "epsilon". 
    
        Esta funcion es estatica, asi que no necesito instanciar para usarla :D
    
        INPUT: Un objeto Estado
        OUTPUT: Una lista de objetos Estado
    */
    
    public static ArrayList<Estado> CerraduraEpsilon(Estado e){
        ArrayList<Estado> Conjunto=new ArrayList<Estado>(); //aqui se guarda el resultado de la cerradura 
        Deque <Estado> Pila= new ArrayDeque<Estado>(); //pila para guardar todos los estados que aun no he revisado
       
        Pila.push(e); //meto el primer estado para revisarlo
        while (!Pila.isEmpty()) {  //este algoritmo se va a ejecutar siempre que hayan estados en la pila           
            e=Pila.pop(); //saca el ultimo estado de la pila
            if(!Conjunto.contains(e)){ //si este estado no lo he agregado al resultado
                Conjunto.add(e); //agregalo, si estoy en el estado e, con epsilon puedo llegar a e
                List <Transicion> Aux=e.getTrancisiones().stream() //entro al estado que estoy revisando y recorro todas las trancisiones que tiene 
                                    .filter(x->new Character('\0').equals(x.getSimbolo())) //solo me interesan las trancisiones desde "e" que me lleven a otro estado usando "epsilon"
                                    .collect(Collectors.toList()); //las trancisiones que cumplan con esto, las guardo en una lista auxiliar
                for(Transicion t: Aux){ //por cada trancision desde "e" que tenga como simbolo a "epsilon"
                    if(!Conjunto.contains(t.getDestino())) //si el destino de la trancision que estoy revisando NO esta en el conjunto resultado
                        Conjunto.add(t.getDestino()); //puedo llegar a ese nodo usando epsilon, agregalo al resultado
                        Pila.push(t.getDestino()); //analizalo, es decir, ponlo en la pila
                }
                
            }
        }
        
        return Conjunto;
    }
    
    
    /*
        Esta funcion regresa el estado con el indice i
    */
    
    public Estado getEstado(int i){
           return this.Estados.get(i);
    }
   
    
    /*
       Esta funcion estatica crea el automata para detectar un caracter
       
    INPUT: una cadena a detectar
    OUTPUT: un automata
    
    */
   
    
    public static Automata CreaAFNBasico(Character simbolo){
    
        Automata a= new Automata(); //creo un automata nuevo, vacio
        Estado e1=new Estado(true, false);
        Estado e2=new Estado(false, true);
        a.Estados.put(e1.getId(), e1);
        a.Estados.put(e2.getId(), e2);
        
        a.Estados.get(e1.getId()).setTrancision(simbolo, a.Estados.get(e2.getId())); //del estado 1 tengo una trancision al estado 2
        a.setEstadoFinal(e2.getId()); //el estado 2 es el final
       try { //si es que no existe un estado inicial en el AFN
           a.setEstadoInicial(e1.getId()); //el nuevo estado inicial sera el 1
       } catch (Exception ex) {
           System.out.println(a); 
       }
        a.addSimboloToLenguaje(simbolo); //agrego el nuevo lenguaje al AFN
        return a;
    }
    
    public void printLenguaje(){
        this.Lenguaje.forEach(n-> System.out.println(n) );
    }
    public void addSimboloToLenguaje(Character e){
        if(!this.Lenguaje.contains(e))
            this.Lenguaje.add(e);
    }

  
    
    public void printAutomata(){
    
         
        for(Map.Entry<Integer, Estado> e: this.Estados.entrySet()){  //para cada estado del automata
           
            if(!e.getValue().getTrancisiones().isEmpty()){ //si el estado aun tiene trancisiones
                System.out.print(e.getValue().getId()); //imprime el ID del estado
                e.getValue().getTrancisiones()         //para cada una de sus trancisiones
                        .forEach(n->n.printTrancision()); //imprime la trancision
            }
            
            
        }
    }
    
    
   
   
   
   
    
}
