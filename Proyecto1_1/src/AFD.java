
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class AFD implements Serializable {
    
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
        System.out.println("entre a print automata");
         
        for (Map.Entry<Integer, Estado> e : this.Estados.entrySet()) {  //para cada estado del automata
            System.out.println(e.getValue().getId()+"HI");
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
    
    
     public void pintaAutomata( ){
        
        //estados finales
        ArrayList<Integer> fin= new ArrayList<Integer>();
        Creartxt pinta= new Creartxt();
        try{
        
           pinta.creacion();
       } catch (IOException ex) {
           Logger.getLogger(Creartxt.class.getName()).log(Level.SEVERE, null, ex);
       }
         String text="";
       for (Map.Entry<Integer, Estado> e : this.Estados.entrySet()) { 
             for(Transicion t: e.getValue().getTrancisiones()){
                 int x=(int)t.getSimbolo().charValue();
                    switch(x){
                       case 33:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"!\"] ";
                        break;
                        
                 
                        case 35:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"#\"] ";
                        break;
                        case 36:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"$\"] ";
                        break;
                        case 37:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"%\"] ";
                        break;
                        case 38:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"&\"] ";
                        break;
                        case 39:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"'\"] ";
                        break;
                        case 40:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"(\"] ";
                        break;
                        case 41:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \")\"] ";
                        break;
                        case 42:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"*\"] ";
                        break;
                        case 43:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"+\"] ";
                        break;
                        case 44:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \",\"] ";
                        break;
                        case 45:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"-\"] ";
                        break;
                        case 46:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \".\"] ";
                        break;
                        case 47:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"/\"] ";
                        break;
                        case 48:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"0\"] ";
                        break;
                        case 49:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"1\"] ";
                        break;
                        case 50:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"2\"] ";
                        break;
                        case 51:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"3\"] ";
                        break;
                        case 52:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"4\"] ";
                        break;
                        case 53:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"5\"] ";
                        break;
                        case 54:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"6\"] ";
                        break;
                        case 55:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"7\"] ";
                        break;
                        case 56:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"8\"] ";
                        break;
                        case 57:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"9\"] ";
                        break;
                        case 58:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \":\"] ";
                        break;
                        case 59:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \";\"] ";
                        break;
                        case 60:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"<\"] ";
                        break;
                        case 61:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"=\"] ";
                        break;
                        case 62:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \">\"] ";
                        break;
                        case 63:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"?\"] ";
                        break;
                        case 64:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"@\"] ";
                        break;
                        case 65:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"A\"] ";
                        break;
                        case 66:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"B\"] ";
                        break;
                        case 67:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"C\"] ";
                        break;
                        case 68:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"D\"] ";
                        break;
                        case 69:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"E\"] ";
                        break;
                        case 70:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"F\"] ";
                        break;
                        case 71:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"G\"] ";
                        break;
                        case 72:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"H\"] ";
                        break;
                        case 73:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"I\"] ";
                        break;
                        case 74:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"J\"] ";
                        break;
                        case 75:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"K\"] ";
                        break;
                        case 76:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"L\"] ";
                        break;
                        case 77:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"M\"] ";
                        break;
                        case 78:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"N\"] ";
                        break;
                        case 79:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"O\"] ";
                        break;
                        case 80:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"P\"] ";
                        break;
                        case 81:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"Q\"] ";
                        break;
                        case 82:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"R\"] ";
                        break;
                        case 83:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"S\"] ";
                        break;
                        case 84:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"T\"] ";
                        break;
                        case 85:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"U\"] ";
                        break;
                        case 86:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"V\"] ";
                        break;
                        case 87:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"W\"] ";
                        break;
                        case 88:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"X\"] ";
                        break;
                        case 89:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"Y\"] ";
                        break;
                        case 90:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"Z\"] ";
                        break;
                        case 91:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"[\"] ";
                        break;
                        case 92:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"\\\"] ";
                        break;
                        case 93:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"]\"] ";
                        break;
                        case 94:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"^\"] ";
                        break;
                        case 95:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"_\"] ";
                        break;
                        case 96:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"`\"] ";
                        break;
                        case 97:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"a\"] ";
                        break;
                        case 98:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"b\"] ";
                        break;
                        case 99:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"c\"] ";
                        break;
                        case 100:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"d\"] ";
                        break;
                        case 101:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"e\"] ";
                        break;
                        case 102:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"f\"] ";
                        break;
                        case 103:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"g\"] ";
                        break;
                        case 104:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"h\"] ";
                        break;
                        case 105:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"i\"] ";
                        break;
                        case 106:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"j\"] ";
                        break;
                        case 107:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"k\"] ";
                        break;
                        case 108:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"l\"] ";
                        break;
                        case 109:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"m\"] ";
                        break;
                        case 110:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"n\"] ";
                        break;
                        case 111:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"o\"] ";
                        break;
                        case 112:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"p\"] ";
                        break;
                        case 113:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"q\"] ";
                        break;
                        case 114:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"r\"] ";
                        break;
                        case 115:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"s\"] ";
                        break;
                        case 116:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"t\"] ";
                        break;
                        case 117:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"u\"] ";
                        break;
                        case 118:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"v\"] ";
                        break;
                        case 119:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"w\"] ";
                        break;
                        case 120:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"x\"] ";
                        break;
                        case 121:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"y\"] ";
                        break;
                        case 122:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"z\"] ";
                        break;
                        case 123:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"{\"] ";
                        break;
                        case 124:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"|\"] ";
                        break;
                        default:
                        text=text+e.getValue().getId()+" -> "+t.getDestino().getId()+" [ label = \"\"] ";
                        break;
                        
                    
                    
                    
                    
                    }
                   
                 
                
                 
             }
        
        }
        
        System.out.println(text);
        this.getEstadoFinal().forEach(n ->fin.add(n.getId()) );
        
        
        String[] array=new String[fin.size()];
        for (int i = 0; i <fin.size(); i++) {
           
            array[i]=String.valueOf(fin.get(i));
            
        }
        
        
       
       
        
        try {
            pinta.crearbase(String.valueOf(this.getEstadoInicial().getId()),"qi",array);//1 es el estado inicial, 
        } catch (Exception ex) {
            Logger.getLogger(Automata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
        
        try {
            Files.write(Paths.get("fsm.gv"), text.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println(e);
            //exception handling left as an exercise for the reader
        }
        
        
        
        
       
        pinta.nodosF();
        pinta.dibujar();
        
        
        
        
    }
    
}
