
import java.util.ArrayList;

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
            Automata dos=Automata.CreaAFNBasico('\0');
            
            //imprimo el automata
            uno.printAutomata();
            dos.printAutomata();
            
            //aqui pruebo la cerradura epsilon la cual devuelve un arreglo de todos los estados
            //a los que puedes llegar desde el estado (x) usando epsilon
            ArrayList<Estado>prueba= Automata.CerraduraEpsilon(uno.getEstado(1));
            System.out.println("ceradura:");
            //imprimo el resultado
            prueba.forEach(n->System.out.println(n.getId()));
            System.out.println("fin");
            
            System.out.println("\n");
            
            //ahora pruebo la cerradura epsilon con dos, en este caso puedo llegar a todos los nodos
            //con epsilon
            try {
                 prueba= Automata.CerraduraEpsilon(dos.getEstadoInicial());
            } catch (Exception e) {
            }
           
            System.out.println("ceradura:");
            prueba.forEach(n->System.out.println(n.getId()));
            System.out.println("fin");
            
            
            System.out.println("\n");
            
            //por ultimo imprimo el lenguaje de uno
            uno.printLenguaje();
	}
}
