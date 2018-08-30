
import java.util.HashMap;
import javax.swing.DefaultListModel;

public class ManejoDeSimbolos 
{
    //public static ArrayList<Character> caracter = new ArrayList<Character>();
    public static HashMap <Character, Automata> automatas = new HashMap <Character, Automata>();
    //Lista de símbolos
    public static DefaultListModel listaSimbolos = new DefaultListModel();
    public static HashMap<Character, Automata> getAutomatas() 
    {
        return automatas;
    }   
    public static DefaultListModel getListaSimbolos() 
    {
        return listaSimbolos;
    }
    
}
