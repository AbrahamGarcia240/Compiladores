
import java.util.ArrayList;
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
            
            //aqui pruebo la cerradura epsilon la cual devuelve un arreglo de todos los estados
            //a los que puedes llegar desde el estado (x) usando epsilon
            try {
                ArrayList<Estado>prueba= Automata.CerraduraEpsilon(uno.getEstado(1));
                System.out.println("ceradura:");
                //imprimo el resultado
                prueba.forEach(n->System.out.println(n.getId()));
                System.out.println("fin");

                System.out.println("\n");
                
                prueba= Automata.CerraduraEpsilon(dos.getEstadoInicial());
                System.out.println("ceradura:");
                prueba.forEach(n->System.out.println(n.getId()));
                System.out.println("fin");
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println(e);
            }
            
            
            //ahora pruebo la cerradura epsilon con dos, en este caso puedo llegar a todos los nodos
            //con epsilon
           
           
            
            
            
            
            ArrayList<Estado> prueba2 = new ArrayList<Estado>();
            try {
                prueba2.add(dos.getEstado(3));
                prueba2.add(dos.getEstado(4));
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
            prueba2=Automata.CerraduraConjunto(prueba2);
            
            System.out.println("Cerradura conjunto:\n");
            prueba2.forEach(n-> System.out.println(n.getId()));
            System.out.println("fin\n");
            
            
            try {
                System.out.println("Ir a\n");
                prueba2=Automata.Ir_A(dos.getEstadoInicial(),'\0');
                prueba2.forEach(n-> System.out.println(n.getId()));
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println(e);
            }
            
            System.out.println("Union");
            uno.UnirAutomata(dos);
            uno.printAutomata();
            uno.printLenguaje();
            System.out.println("fin\n");
            
            
            System.out.println("Concatenacion");
            uno.ConcatenarAutomata(new Automata().CreaAFNBasico('c'));
            uno.printAutomata();
            uno.printLenguaje();
            System.out.println("fin\n");
            
            
            /*try {
                          for(Map.Entry<Integer,Estado>m:uno.Estados.entrySet()){
                              System.out.println(m.getKey());
                          }

            } catch (Exception e) {
            }*/
            
            System.out.println("Cerradura estrella");
            uno.CerraduraEstrella();
            uno.printAutomata();
            uno.printLenguaje();
            System.out.println("fin\n");
            
            System.out.println("ir_a");
            try {
                 prueba2=Automata.Ir_A(uno.getEstado(1), 'a');
                 prueba2.forEach(n-> System.out.println(n.getId()));
                System.out.println("\n");               
            } catch (Exception e) {
                System.out.println(e);
            }
            
            System.out.println("Cerradura");
            try {
                 prueba2=Automata.CerraduraEpsilon(uno.getEstadoInicial());
                 prueba2.forEach(n-> System.out.println(n.getId()));
                System.out.println("\n");               
            } catch (Exception e) {
                System.out.println(e);
            }
                        
           
            
            //por ultimo imprimo el lenguaje de uno
            uno.printLenguaje();
	}
}
