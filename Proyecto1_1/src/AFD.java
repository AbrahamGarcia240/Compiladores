
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
public class AFD {
    
    private Map <Integer,Estado> Estados;
    private Integer estadoInicial;
    private ArrayList<Estado> estadoFinal;

    public AFD() {
        Estados=new HashMap<Integer, Estado>();
        estadoInicial=0;
        estadoFinal=new ArrayList<Estado>();
    }
    
    public Estado getEstado(int i ){
       return this.Estados.get(i);
    }    
    
    public int AgregaEstado(){
        Estado e= new Estado(false, false);
        Estados.put(e.getId(), e);
        return e.getId();
    }
    
    public void AgregaTracision(int n,Character c, int m){
       Estados.get(n).addTrancision(new Transicion(c, Estados.get(m)));
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
        else{    //System.out.println("hola");
        ImprimirAutomata.jTextArea2.append(""+this.Estados.get(id).getId());
        System.out.println(this.Estados.get(id).getId());
            throw new Exception("No se puede agregar estado porque ya existe un estado inicial");
        }
        
    }

    public void setEstadoFinal(Integer id){
        //System.out.println(this.Estados.get(id));
        this.Estados.get(id).setEsFinal(true); //accedo al estado a traves del Hashmap y dentro prendo la bandera de estado final
        if(!estadoFinal.contains(this.Estados.get(id)))
            this.estadoFinal.add(this.Estados.get(id)); //agrego el ID de este estado a la coleccion de estados finales
    }
    
    public Estado getEstadoInicial() throws Exception{
        
        if(this.estadoInicial==0){
            throw new Exception("No existe un estado inicial para este automata");
        }
        else{
            return this.Estados.get(this.estadoInicial);
        }
        
        
    }

    public ArrayList<Estado> getEstadoFinal() {
        return estadoFinal;
    }
    
    public void printAutomata(){
    
         
        for (Map.Entry<Integer, Estado> e : this.Estados.entrySet()) {  //para cada estado del automata
            
             //imprime el ID del estado
            
             for(Transicion t: e.getValue().getTrancisiones()){
                 ImprimirAutomata.jTextArea2.append(""+e.getValue().getId());
                 System.out.print(e.getValue().getId());
                
                 t.printTrancision();
             }
        }
        ImprimirAutomata.jTextArea2.append("\nEstado inicial: ");
        System.out.print("\nEstado inicial:");
        try {
            ImprimirAutomata.jTextArea2.append(""+this.getEstadoInicial().getId());
                    System.out.println(this.getEstadoInicial().getId());

        } catch (Exception e) {
            System.out.println(e);
        }
        ImprimirAutomata.jTextArea2.append("\nEstado(s) final(es)");
        System.out.print("\nEstado(s) final(es):");
        try {
            this.getEstadoFinal().forEach(n->ImprimirAutomata.jTextArea2.append(n.getId()+"\n"));
            this.getEstadoFinal().forEach(n->System.out.println(n.getId()));
        } catch (Exception e) {
            System.out.println(e);
        }
        ImprimirAutomata.jTextArea2.append("\n");
        System.out.println("\n");
    }
    public void printAutomataTotal(){
    
        for (Map.Entry<Integer, Estado> e : this.Estados.entrySet()) {  //para cada estado del automata
            
             //imprime el ID del estado
            
             for(Transicion t: e.getValue().getTrancisiones()){
                UnirAutomatas.jTextArea1.append(""+e.getValue().getId());
                 System.out.print(e.getValue().getId());
                
                 t.printTrancisionAFD();
             }
        }
        
        UnirAutomatas.jTextArea1.append("\nEstado inicial: ");
        System.out.print("\nEstado inicial:");
        try {
            UnirAutomatas.jTextArea1.append(""+this.getEstadoInicial().getId());
                    System.out.println(this.getEstadoInicial().getId());

        } catch (Exception e) {
            System.out.println(e);
        }
        UnirAutomatas.jTextArea1.append("\nEstado(s) final(es)");
        System.out.print("\nEstado(s) final(es):");
        try {
            this.getEstadoFinal().forEach(n->UnirAutomatas.jTextArea1.append(n.getId()+"\n"));
            this.getEstadoFinal().forEach(n->System.out.println(n.getId()));
        } catch (Exception e) {
            System.out.println(e);
        }
        UnirAutomatas.jTextArea1.append("\n");
        System.out.println("\n");
    }
    public void printAutomataTotalAFD() 
    {
        for (Map.Entry<Integer, Estado> e : this.Estados.entrySet()) {  //para cada estado del automata
            
             //imprime el ID del estado
            
             for(Transicion t: e.getValue().getTrancisiones()){
                 UnirAutomatas.jTextArea1.append(""+e.getValue().getId());
                 System.out.print(e.getValue().getId());
                
                 t.printTrancisionAFD();
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
