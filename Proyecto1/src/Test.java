
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
            
           Automata uno=Automata.CreaAFNBasico('L');
           //uno.printAutomata();
           Automata dos=Automata.CreaAFNBasico('M');
           //dos.printAutomata();
           uno.UnirAutomata(dos);
           uno.printAutomata();
           
           
           Automata tres=Automata.CreaAFNBasico('D');
           //tres.printAutomata();
           Automata cuatro=Automata.CreaAFNBasico('T');
           //cuatro.printAutomata();
           
           tres.UnirAutomata(cuatro);
           
           tres.printAutomata();
          
           cuatro=Automata.AgregaATotal(new Automata(), uno);
           
           
           cuatro.printAutomata();
          
           
           cuatro=Automata.AgregaATotal(cuatro, tres);
           cuatro.printAutomata();
            System.out.println("PRIMERA PRUEBA TERMINA");
            
          Automata cinco= Automata.CreaAFNBasico('S');
          cinco.printAutomata();
          Automata seis= Automata.CreaAFNBasico('T');
          seis.printAutomata();
          cinco.UnirAutomata(seis);
          cinco.printAutomata();
          cinco.CerraduraMas();
          cinco.printAutomata();
          
          System.out.println("INICIO SEGUNDA PRUEBA");
          cuatro=Automata.AgregaATotal(cuatro, cinco);
          cuatro.printAutomata();
            System.out.println("FIN PRUEBA 2");
          
          
           
           
           
         
            
           
           
            //Aqui creo un AFNbasico como en clase, hize uno normal y otro con epsilon
            //de tal manera que la cerradura epsilon para "dos" dara como resultado los nodos 1 y 2
           /*
           Automata uno=Automata.CreaAFNBasico('P');
           Automata dos=Automata.CreaAFNBasico('M');
           Automata tres=Automata.CreaAFNBasico('D');
           Automata cuatro=Automata.CreaAFNBasico('D');
           Automata cinco=Automata.CreaAFNBasico('E');
           Automata seis=Automata.CreaAFNBasico('e');
           Automata siete=Automata.CreaAFNBasico('P');
           Automata ocho=Automata.CreaAFNBasico('M');
           Automata nueve=Automata.CreaAFNBasico('D');
           
           
           
           uno.UnirAutomata(dos);//PlM
           uno.CerraduraPregunta();//(PlM)?
           tres.CerraduraMas();//D+
           cuatro.CerraduraMas();//D+
    
           uno.ConcatenarAutomata(tres);//(PlM)?D+
           uno.ConcatenarAutomata(cuatro);//(PlM)?D+D+
           
    
          cinco.UnirAutomata(seis);//Ele
          siete.UnirAutomata(ocho);//PlM
          siete.CerraduraPregunta();//(PlM)?
          nueve.CerraduraMas();//D+
          
          cinco.ConcatenarAutomata(siete);//Ele(PlM)?
          cinco.ConcatenarAutomata(nueve);//Ele(PlM)?D+
          cinco.CerraduraPregunta();//(Ele(PlM)?D+)?
          
          uno.ConcatenarAutomata(cinco);//FINAL

          uno.AFNtoAFD().printAutomata();
            
            
            
            System.out.println("Imprimo el automata final");
            //uno.printAutomata();*/
           
            
            
        try {
            
           
            //Automata.CerraduraEpsilon(uno.getEstadoInicial()).forEach(n->System.out.println(n.getId()));
            
            
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
           
           
	}
}
