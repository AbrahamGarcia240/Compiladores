/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abraham
 */
public class Creartxt {

   public static void dibujar(){
        try {
        Runtime.getRuntime().exec("mv src/fsm.gv Compiladores-AutomataFInal/Proyecto1");
        Runtime.getRuntime().exec("dot -Tpng fsm.gv -o automata.png");
        Runtime.getRuntime().exec("eog automata.png");
        } 
        catch(IOException e) {
          System.out.println("EXCEPTION: " + e.getMessage());
        }
    }    
    
    public static void creacion() throws IOException{
    String ruta = "fsm.gv";
            File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            //bw.write("El fichero de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            //bw.write("Acabo de crear el fichero de texto.");
        }
        bw.close();
    }
    
    public static void crearbase(String nodoIni,String qi,String finales[]){ //Base del archivo con los nodos finales
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        
        try{
            fichero = new FileWriter("fsm.gv");
            pw = new PrintWriter(fichero);
            pw.println("digraph finite_state_machine {");
            pw.println("rankdir=LR;");
            pw.println("size=\"8,5\"");
            for(int n=0; n<finales.length;n++){
                pw.println("node [shape = doublecircle]; "+finales[n]+";");
            }
            
            pw.println("node [shape = point ]; "+qi+";");
            pw.println("node [shape = circle];");        
            pw.println(qi+" -> "+nodoIni+";");   

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    public static void nodos(String q1[], String q2[], String letra[]){ //Escribir transiciones
        for(int n=0; n<q1.length; n++){ 
            BufferedWriter bw = null;
            FileWriter fw = null;

            try {
                String data = q1[n]+" -> "+q2[n]+" [label = \""+letra[n]+"\" ];";
                
                System.out.println(data);
                File file = new File("fsm.gv");
                // Si el archivo no existe, se crea!
                if (!file.exists()) {
                    file.createNewFile();
                }
                // flag true, indica adjuntar información al archivo.
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw);
                out.write(data);
                
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e);
            } finally {
                try {
                       
                                //Cierra instancias de FileWriter y BufferedWriter
                    if (bw != null)
                        bw.close();
                    else
                        System.out.println("bw.close es null");
                    if (fw != null)
                        fw.close();
                    else
                        System.out.println("fw.close es null");
                        
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
    
    public static void nodosF(){ //Solo para cerrar el archivo
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String data = "}";
            File file = new File("fsm.gv");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
           // System.out.println("información agregada!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                            //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
       try {
           creacion();
       } catch (IOException ex) {
           Logger.getLogger(Creartxt.class.getName()).log(Level.SEVERE, null, ex);
       }
        String array[]={"1"}; //aqui van los estados finales 
        String q1[]={"0","0","1","c"};//
        String q2[]={"0","1","1","k"};
        String letra[]={"","l","c",""};
        crearbase("1","qi",array);//1 es el estado inicial, 
        nodos(q1,q2,letra);
       /*
        nodosF();
        dibujar();*/
    }
    
}
