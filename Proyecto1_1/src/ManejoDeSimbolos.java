
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;

public class ManejoDeSimbolos 
{
    //public static ArrayList<Character> caracter = new ArrayList<Character>();
    public static HashMap <Integer, Automata> automatas = new HashMap <Integer, Automata>();
    //Creamos un hasmap para el automata total
    public static HashMap <Integer, Automata> automatasFinales = new HashMap <Integer, Automata>();
    //Lista de símbolos
    public static DefaultListModel listaSimbolos = new DefaultListModel();
    //Manejo de automata total
    public static DefaultListModel automataTotal = new DefaultListModel();
    
    
    public static HashMap<Integer, Automata> getAutomatas() 
    {
        return automatas;
    }   
    public static HashMap<Integer, Automata> getAutomatasFinales() {
        return automatasFinales;
    }

    public static DefaultListModel getAutomataTotal() {
        return automataTotal;
    }

    public static DefaultListModel getListaSimbolos() 
    {
        return listaSimbolos;
    }
    
}
