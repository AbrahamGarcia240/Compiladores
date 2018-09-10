
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import sun.security.provider.VerificationProvider;

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
    private ArrayList<Character> Lenguaje;
    Map<Integer, Estado> Estados;
    private Integer estadoInicial;
    private ArrayList<Transicion> Trancisiones;
    private ArrayList<Estado> estadoFinal;

    public Automata() {

        this.estadoInicial = 0;
        this.estadoFinal = new ArrayList<Estado>();
        this.Lenguaje = new ArrayList<Character>();
        this.Estados = new HashMap<Integer, Estado>();
        this.Trancisiones = new ArrayList<Transicion>();
    }

    Boolean SnEsFinal(ArrayList<Estado> Sn) {
        for (Estado e : Sn) {
            if (e.isEsFinal()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
    
    Boolean SnEsFinal(ArrayList<Estado> Sn, AFD nuevo, int l) {
        for (Estado e : Sn) {
            if (e.isEsFinal()) {
                System.out.print("Voy a poner en el estado ");
                System.out.print(l);
                System.out.print(" El token ");
                System.out.println(e.getId());
                nuevo.getEstado(l).setToken(e.getId());
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public AFD AFNtoAFD() {
        AFD nuevo = new AFD();
        Map<Integer, ArrayList<Estado>> Sn = new HashMap<Integer, ArrayList<Estado>>(); // lista de estados del AFD
        Stack<ArrayList<Estado>> E = new Stack<ArrayList<Estado>>(); //pila auxiliar del algoritmo
        int j = nuevo.AgregaEstado(); //para cada Sn mapeo un nuevo estado en el AFD

        try {
            nuevo.setEstadoInicial(j);

            Sn.put(j, Automata.CerraduraEpsilon(this.getEstadoInicial())); //<0,So={0,1,2,4,7,8}>  

        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        E.push(Sn.get(j));
        ArrayList<Estado> lista, Aux;
        while (E.size() != 0) {
            lista = E.pop(); //lista=So
            for (Map.Entry<Integer, ArrayList<Estado>> entry : Sn.entrySet()) {
                if (lista.equals(entry.getValue())) {
                    j = entry.getKey();
                    // if(SnEsFinal(Aux))
                    //    nuevo.setEstadoFinal(entry.getKey());
                    break;
                }
            }

            for (Character c : this.getLenguaje()) {
                Aux = Automata.Ir_A(lista, c); //Aux=S1

                if (!Sn.containsValue(Aux) && Aux.size() != 0) {
                    int l = nuevo.AgregaEstado();
                    //System.out.println(l);
                    Sn.put(l, Aux);
                    E.add(Aux);
                    nuevo.AgregaTracision(j, c, l);
                    
                    if (SnEsFinal(Aux,nuevo,l)) {
                       
                        
                        nuevo.setEstadoFinal(l);
                    }

                } else {
                    for (Map.Entry<Integer, ArrayList<Estado>> entry : Sn.entrySet()) {
                        if (Aux.equals(entry.getValue())) {
                            // System.out.println(entry.getKey());
                            nuevo.AgregaTracision(j, c, entry.getKey());
                            if (SnEsFinal(Aux)) {
                                nuevo.setEstadoFinal(entry.getKey());
                            }
                            break;
                        }
                    }

                }

            }

        }
        return nuevo;

    }
    

    
    public void setEstadoInicial(Integer id) throws Exception {
        if (this.estadoInicial == 0) { //si no hay un estado inicial
            if (this.Estados.containsKey(id)) { //y el id que recibi es un estado que existe en el AFN
                this.Estados.get(id).setEsInicial(true); //accedo al estado a traves del Hashmap y dentro de el prendo la bandera de inicial
                this.estadoInicial = id; //en el AFN lo declaro como inicial
            } else {
                throw new Exception("No se puede agregar el estado final, el nodo no existe");
            }

        } else {
            throw new Exception("No se puede agregar estado porque ya existe un estado inicial");
        }

    }

    public void setEstadoFinal(Integer id) {
        this.Estados.get(id).setEsFinal(true); //accedo al estado a traves del Hashmap y dentro prendo la bandera de estado final
        this.estadoFinal.add(this.Estados.get(id)); //agrego el ID de este estado a la coleccion de estados finales
    }

    public Estado getEstadoInicial() throws Exception {

        if (this.estadoInicial == 0) {
            throw new Exception("No existe un estado inicial para este automata");
        } else {
            return this.Estados.get(this.estadoInicial);
        }

    }

    public ArrayList<Estado> getEstadoFinal() {
        return estadoFinal;
    }

    /*
        Dado un estado e, CerraduraEpsilon nos dice todos los estados a los que puedo llegar
        usando "epsilon". 
    
        Esta funcion es estatica, asi que no necesito instanciar para usarla :D
    
        INPUT: Un objeto Estado
        OUTPUT: Una lista de objetos Estado
     */
    public static ArrayList<Estado> CerraduraEpsilon(Estado e) {
        ArrayList<Estado> Conjunto = new ArrayList<Estado>(); //aqui se guarda el resultado de la cerradura 
        Deque<Estado> Pila = new ArrayDeque<Estado>(); //pila para guardar todos los estados que aun no he revisado

        Pila.push(e); //meto el primer estado para revisarlo
        while (!Pila.isEmpty()) {  //este algoritmo se va a ejecutar siempre que hayan estados en la pila 
            //System.out.print("tamaño pila:");
            //System.out.println(Pila.size());
            e = Pila.pop(); //saca el ultimo estado de la pila

            Conjunto.add(e); //agregalo, si estoy en el estado e, con epsilon puedo llegar a e
            List<Transicion> Aux = e.getTrancisiones().stream() //entro al estado que estoy revisando y recorro todas las trancisiones que tiene 
                    .filter(x -> new Character('\0').equals(x.getSimbolo())) //solo me interesan las trancisiones desde "e" que me lleven a otro estado usando "epsilon"
                    .collect(Collectors.toList()); //las trancisiones que cumplan con esto, las guardo en una lista auxiliar

            for (Transicion t : Aux) { //por cada trancision desde "e" que tenga como simbolo a "epsilon"
                if (!Conjunto.contains(t.getDestino())) { //si el destino de la trancision que estoy revisando NO esta en el conjunto resultado

                    if (!Conjunto.contains(e)) {
                        Conjunto.add(t.getDestino()); //puedo llegar a ese nodo usando epsilon, agregalo al resultado
                    }
                    Pila.push(t.getDestino());//analizalo, es decir, ponlo en la pila
                }
            }

        }

        return Conjunto;
    }

    public static ArrayList<Estado> Union(ArrayList<Estado> a, ArrayList<Estado> b) {
        for (Estado nuevo : b) {
            if (!a.contains(nuevo)) {
                a.add(nuevo);
            }
        }

        return a;
    }

    public static ArrayList<Character> UnionAlfabeto(ArrayList<Character> a, ArrayList<Character> b) {
        for (Character nuevo : b) {
            if (!a.contains(nuevo)) {
                a.add(nuevo);
            }
        }

        return a;
    }

    public static ArrayList<Estado> CerraduraConjunto(ArrayList<Estado> Conjunto) {
        ArrayList<Estado> Respuesta = new ArrayList<Estado>();
        for (Estado e : Conjunto) {
            Automata.Union(Respuesta, Automata.CerraduraEpsilon(e));

        }

        return Respuesta;
    }

    public static ArrayList<Estado> Mover(Estado e, Character c) {
        ArrayList<Estado> Resultado = new ArrayList<Estado>();
        for (Transicion t : e.getTrancisiones()) {
            if (t.getSimbolo().equals(c)) {
                Resultado.add(t.getDestino());
            }
        }
        return Resultado;

    }

    public static ArrayList<Estado> Mover(ArrayList<Estado> Conjunto, Character c) {
        ArrayList<Estado> Respuesta = new ArrayList<Estado>();
        for (Estado e : Conjunto) {
            Automata.Union(Respuesta, Automata.Mover(e, c));

        }

        return Respuesta;
    }
    
    
    public static Automata AgregaATotal(Automata destino, Automata fn){
        try {
            Estado verifcador=destino.getEstadoInicial();
            
            verifcador.setTrancision('\0', fn.getEstadoInicial());
            for(Estado e: fn.getEstadoFinal()){
                destino.estadoFinal.add(e);
            }
            for(Map.Entry<Integer,Estado>e:fn.Estados.entrySet()){
                destino.Estados.put(e.getKey(), e.getValue());
            }
            for(Character c: fn.getLenguaje()){
                destino.addSimboloToLenguaje(c);
            }
            
            fn.getEstadoInicial().setEsInicial(false);
            
        } catch (Exception e) {
            
            destino=Automata.CreaAFNBasico('\0');
            destino.ConcatenarAutomata(fn);
            destino.Lenguaje.remove(0);
            
        }
    
        return destino;
    }
    

    public Automata UnirAutomata(Automata f2) {
        Estado e1, e2;
        e1 = new Estado(true, false);
        this.Estados.put(e1.getId(), e1);
        e2 = new Estado(false, true);
        this.Estados.put(e2.getId(), e2);

        for (Map.Entry<Integer, Estado> e : f2.Estados.entrySet()) {
           
            this.Estados.put(e.getKey(), e.getValue());
        }

        try {
            e1.setTrancision('\0', this.getEstadoInicial());
            e1.setTrancision('\0', f2.getEstadoInicial());

        } catch (Exception e) {
            System.out.println(e);
        }

        for (Estado e : this.getEstadoFinal()) {
            e.setTrancision('\0', e2);
            e.setEsFinal(false);
        }

        for (Estado e : f2.getEstadoFinal()) {
            e.setTrancision('\0', e2);
            e.setEsFinal(false);
        }

        this.estadoFinal.clear();
        this.estadoFinal.add(e2);
      
        try {
            this.getEstadoInicial().setEsInicial(false);
              this.estadoInicial = e1.getId();
            f2.getEstadoInicial().setEsInicial(false);
        } catch (Exception e) {
            System.out.println(e);
        }

        this.Lenguaje = Automata.UnionAlfabeto(this.Lenguaje, f2.Lenguaje);
        return this;

    }

    public Automata ConcatenarAutomata(Automata f2) {
        for (Map.Entry<Integer, Estado> e : f2.Estados.entrySet()) {
            if (!e.getValue().isEsInicial()) {
                this.Estados.put(e.getKey(), e.getValue());
            }
        }
        for (Estado e : this.getEstadoFinal()) {
            e.setEsFinal(false);
            try {
                for (Transicion t : f2.getEstadoInicial().getTrancisiones()) {
                    e.addTrancision(t);
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
        this.getEstadoFinal().clear();
        f2.estadoFinal.forEach(n -> this.getEstadoFinal().add(n));
        this.Lenguaje = Automata.UnionAlfabeto(this.Lenguaje, f2.Lenguaje);

        return this;
    }

    public Automata CerraduraPregunta() {
        Estado e1, e2;
        e1 = new Estado(true, false);
        this.Estados.put(e1.getId(), e1);
        e2 = new Estado(false, true);
        this.Estados.put(e2.getId(), e2);

        for (Estado e : this.estadoFinal) {
            e.setTrancision('\0', e2);

            e.setEsFinal(false);

        }
        try {
            e1.setTrancision('\0', this.getEstadoInicial());
            e1.setTrancision('\0', e2);
            this.getEstadoInicial().setEsInicial(false);

        } catch (Exception e) {
            System.out.println(e);
        }

        this.estadoFinal.clear();
        this.estadoFinal.add(e2);
        this.estadoInicial = e1.getId();

        return this;

    }

    public Automata CerraduraEstrella() {

        Estado e1, e2;
        e1 = new Estado(true, false);
        this.Estados.put(e1.getId(), e1);
        e2 = new Estado(false, true);
        this.Estados.put(e2.getId(), e2);

        for (Estado e : this.estadoFinal) {
            e.setTrancision('\0', e2);

            try {
                e.setTrancision('\0', this.getEstadoInicial());

            } catch (Exception ex) {
                System.out.println(ex);
            }
            e.setEsFinal(false);

        }
        try {
            e1.setTrancision('\0', this.getEstadoInicial());
            e1.setTrancision('\0', e2);
            this.getEstadoInicial().setEsInicial(false);

        } catch (Exception e) {
            System.out.println(e);
        }

        this.estadoFinal.clear();
        this.estadoFinal.add(e2);
        this.estadoInicial = e1.getId();

        return this;
    }

    public Automata CerraduraMas() {

        Estado e1, e2;
        e1 = new Estado(true, false);
        this.Estados.put(e1.getId(), e1);
        e2 = new Estado(false, true);
        this.Estados.put(e2.getId(), e2);

        for (Estado e : this.estadoFinal) {
            e.setTrancision('\0', e2);

            try {
                e.setTrancision('\0', this.getEstadoInicial());

            } catch (Exception ex) {
                System.out.println(ex);
            }
            e.setEsFinal(false);

        }
        try {
            e1.setTrancision('\0', this.getEstadoInicial());

            this.getEstadoInicial().setEsInicial(false);

        } catch (Exception e) {
            System.out.println(e);
        }

        this.estadoFinal.clear();
        this.estadoFinal.add(e2);
        this.estadoInicial = e1.getId();

        return this;
    }

    public static ArrayList<Estado> Ir_A(Estado e, Character c) {
        return Automata.CerraduraConjunto(Automata.Mover(e, c));
    }

    public static ArrayList<Estado> Ir_A(ArrayList<Estado> Conjunto, Character c) {
        return Automata.CerraduraConjunto(Automata.Mover(Conjunto, c));
    }

    /*
        Esta funcion regresa el estado con el indice i
     */
    public Estado getEstado(int i) throws Exception {
        if (this.Estados.containsKey(i)) {
            return this.Estados.get(i);
        } else {
            throw new Exception("No existe un estado para este automata");
        }
    }

    /*
       Esta funcion estatica crea el automata para detectar un caracter
       
    INPUT: una cadena a detectar
    OUTPUT: un automata
    
     */
    public static Automata CreaAFNBasico(Character simbolo) {

        Automata a = new Automata(); //creo un automata nuevo, vacio
        Estado e1 = new Estado(true, false);
        Estado e2 = new Estado(false, true);
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

    public void printLenguaje() {
        ImprimirAutomata.jTextArea2.append("Lenguaje: [ ");
        this.Lenguaje.forEach(n -> ImprimirAutomata.jTextArea2.append(""+n+" "));
        ImprimirAutomata.jTextArea2.append("]");
        this.Lenguaje.forEach(n -> System.out.println(n));
    }

    public void addSimboloToLenguaje(Character e) {
        if (!this.Lenguaje.contains(e)) {
            this.Lenguaje.add(e);
        }
    }

    public ArrayList<Character> getLenguaje() {
        return Lenguaje;
    }
    
    public void printAutomata() {

        for (Map.Entry<Integer, Estado> e : this.Estados.entrySet()) {  //para cada estado del automata
            
             //imprime el ID del estado
            
             for(Transicion t: e.getValue().getTrancisiones()){
                 ImprimirAutomata.jTextArea2.append(""+e.getValue().getId());
                 System.out.print(e.getValue().getId());
                
                 t.printTrancision();
             }
        }
        ImprimirAutomata.jTextArea2.append("Estado inicial: ");
        System.out.print("Estado inicial:");
        try {
            ImprimirAutomata.jTextArea2.append("" + this.getEstadoInicial().getId());
            System.out.println(this.getEstadoInicial().getId());

        } catch (Exception e) {
            System.out.println(e);
        }
        ImprimirAutomata.jTextArea2.append("\nEstado(s) final(es): ");
        System.out.print("Estado(s) final(es):");
        try {
            this.getEstadoFinal().forEach(n -> ImprimirAutomata.jTextArea2.append(""+n.getId()));
            this.getEstadoFinal().forEach(n -> System.out.println(n.getId()));
        } catch (Exception e) {
            System.out.println(e);
        }
        ImprimirAutomata.jTextArea2.append("\n");
        System.out.println("\n");
    }
    public void printAutomataTotal() 
    {
        
        for (Map.Entry<Integer, Estado> e : this.Estados.entrySet()) {  //para cada estado del automata
            
             //imprime el ID del estado
            
             for(Transicion t: e.getValue().getTrancisiones()){
                 UnirAutomatas.jTextArea1.append(""+e.getValue().getId());
                 System.out.print(e.getValue().getId());
                
                 t.printTrancision();
             }
        }
        
        
        UnirAutomatas.jTextArea1.append("\nEstado inicial: ");
        System.out.print("Estado inicial:");
        try {
            UnirAutomatas.jTextArea1.append(" " + this.getEstadoInicial().getId());
            System.out.println(this.getEstadoInicial().getId());

        } catch (Exception e) {
            System.out.println(e);
        }
        UnirAutomatas.jTextArea1.append("\nEstado(s) final(es): ");
        System.out.print("Estado(s) final(es):");
        try {
            this.getEstadoFinal().forEach(n -> UnirAutomatas.jTextArea1.append("\n"+n.getId()));
            this.getEstadoFinal().forEach(n -> System.out.println(n.getId()));
        } catch (Exception e) {
            System.out.println(e);
        }
        UnirAutomatas.jTextArea1.append("\n");
        System.out.println("\n");
    }

    
}