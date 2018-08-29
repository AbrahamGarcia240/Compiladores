
import java.util.ArrayList;
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
public class Test {
    public static void main(String [] args)
	{
            System.out.println("Automata AUB");
            
            
            //Aqui creo un AFNbasico como en clase, hize uno normal y otro con epsilon
            //de tal manera que la cerradura epsilon para "dos" dara como resultado los nodos 1 y 2
            Automata uno=Automata.CreaAFNBasico('a');
            Automata dos=Automata.CreaAFNBasico('b');
            
            
            
            //imprimo el automata
            uno.printAutomata();
            dos.printAutomata();
            
            uno=uno.UnirAutomata(dos); //alo
            uno=uno.CerraduraEstrella();
            Automata tres=Automata.CreaAFNBasico('c');
            
            tres=tres.CerraduraMas();
            
            uno=uno.ConcatenarAutomata(tres);
            
            System.out.println("Imprimo el automata final");
            uno.printAutomata();
           
            
            
        try {
            
           
            //Automata.CerraduraEpsilon(uno.getEstadoInicial()).forEach(n->System.out.println(n.getId()));
            
            AFD nuevo=uno.AFNtoAFD();
            nuevo.printAutomata();
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
           
           
	}
}
