
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
public class Test {
    public static void main(String [] args)
	{
            System.out.println("Automata AUB");
            
           Automata uno=Automata.CreaAFNBasico('+');
           //uno.printAutomata();
           Automata dos= Automata.CreaAFNBasico('M');
           //dos.printAutomata();
           uno.UnirAutomata(dos);
           //uno.printAutomata();
           uno.CerraduraPregunta();
           //uno.printAutomata();
           Automata tres= Automata.CreaAFNBasico('D');
           //tres.printAutomata();
           tres.CerraduraMas();
           //tres.printAutomata();
           uno.ConcatenarAutomata(tres);
           uno.printAutomata();
           
           
           
           
            System.out.println("Automata 2");
            
            Automata cuatro=Automata.CreaAFNBasico('+');
            
           //cuatro.printAutomata();
           Automata cinco= Automata.CreaAFNBasico('M');
           //cinco.printAutomata();
           cuatro.UnirAutomata(cinco);
           //cuatro.printAutomata();
           cuatro.CerraduraPregunta();
           //cuatro.printAutomata();
           Automata seis= Automata.CreaAFNBasico('D');
           //seis.printAutomata();
           seis.CerraduraMas();
           //seis.printAutomata();
           cuatro.ConcatenarAutomata(seis);
           Automata m=Automata.CreaAFNBasico('P');
           cuatro.ConcatenarAutomata(m);
           //cuatro.printAutomata();
           Automata siete= Automata.CreaAFNBasico('D');
           siete.CerraduraMas();
           //siete.printAutomata();
           cuatro.ConcatenarAutomata(siete);
           //cuatro.printAutomata();
          
            //System.out.println("aqui error\n");
           Automata ocho= Automata.CreaAFNBasico('E');
           Automata nueve= Automata.CreaAFNBasico('e');
           ocho.UnirAutomata(nueve);
           //ocho.printAutomata();
          
           
           Automata diez= Automata.CreaAFNBasico('+');
           Automata once= Automata.CreaAFNBasico('M');
           diez.UnirAutomata(once);
           diez.CerraduraPregunta();
           //diez.printAutomata();
           ocho.ConcatenarAutomata(diez);
           //cuatro.printAutomata();
           //ocho.printAutomata();
           
           Automata doce= Automata.CreaAFNBasico('D');
           doce.CerraduraMas();
           ocho.ConcatenarAutomata(doce);
            try {
                System.out.println("inicial");
                System.out.println(ocho.getEstadoInicial().getId());
                System.out.println("Trancisiones del inicial");
                ocho.getEstadoInicial().getTrancisiones().forEach(n->System.out.println(n.getDestino().getId()));
            } catch (Exception e) {
            }
           
           ocho.CerraduraPregunta();
            try {
                System.out.println(" ");
                System.out.println("inicial");
                System.out.println(ocho.getEstadoInicial().getId());
                System.out.println("Trancisiones del inicial");
                ocho.getEstadoInicial().getTrancisiones().forEach(n->System.out.println(n.getDestino().getId()));
                System.out.println(" ");
            } catch (Exception e) {
            }
           
           //ocho.printAutomata();
           
           cuatro.ConcatenarAutomata(ocho);
           cuatro.printAutomata();
           
       
       
           
            System.out.println("Automata 3");
            
            Automata trece=Automata.CreaAFNBasico('L');
            Automata catorce=Automata.CreaAFNBasico('D');
            trece.UnirAutomata(catorce);//LlD
            trece.CerraduraMas();//(LlD)*
            Automata quince=Automata.CreaAFNBasico('L');
            quince.ConcatenarAutomata(trece);
            
            quince.printAutomata();
            
            System.out.println("Automata 4");
            
            Automata veinte=Automata.CreaAFNBasico('S');
            Automata veintiuno= Automata.CreaAFNBasico('T');
            veinte.UnirAutomata(veintiuno);
            veinte.CerraduraMas();
            
            veinte.printAutomata();
            
           
            
            
            System.out.println("AUTOMATA TOTAL");
            Automata f=Automata.AgregaATotal(new Automata(), uno);
            f=Automata.AgregaATotal(f, cuatro);
            f=Automata.AgregaATotal(f, quince);
            f=Automata.AgregaATotal(f, veinte);
            
            f.printAutomata();
      
            
            
            System.out.println("AFD");
            
            AFD nuevo=f.AFNtoAFD();
            nuevo.printAutomata();
            
          
           AnalizadorLexico analizador=new AnalizadorLexico("+DDPDDeMDsDDDDSTTSST+DDPDD", nuevo);
           //analizador.getToken();
           int i=0;
           do{
               i=analizador.getToken();
              if(i!=0){
                   System.out.print("El token es:");
                    System.out.println(i);
                   System.out.print("El lexema es:");
                    System.out.println(analizador.getLexema());
               }
               
               
           }while(i!=0);
           
           
            
           
         
            
           
           
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
