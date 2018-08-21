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
            
            Automata uno=new Automata();
            
          
            uno.setTrancision(1, "epsilon", 2);
            uno.setTrancision(1, "epsilon", 4);
            uno.setTrancision(2,"a", 3);
            uno.setTrancision(3, "epsilon", 6);
            uno.setTrancision(4, "b", 5);
            uno.setTrancision(5, "epsilon", 6);
            uno.setTrancision(6, "epsilon", 7);
            uno.setEstadoFinal(7);
            
            try {
                uno.setEstadoInicial(1);
                System.out.println(uno.getEstadoInicial().getId());
                System.out.println(uno.getEstadoFinal().getId());

            } catch (Exception e) {
                System.out.println(e);
            }
            
            uno.printAutomata();
            uno.printLenguaje();
	}
}
