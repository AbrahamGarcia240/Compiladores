
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class WriteReader {
    private Object escribe;
    private Object lee;

    public WriteReader() {
    }

    public void setEscribe(Object escribe,String nombre) throws IOException {
        this.escribe = escribe;
        
       
        try {
             FileOutputStream f = new FileOutputStream(new File(nombre.concat(".txt")));
	     ObjectOutputStream o = new ObjectOutputStream(f);
             o.writeObject(escribe);
             o.close();
	     f.close();
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteReader.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
        }
       
    }
    
    public Object getLee(String nombre){
        try {
             FileInputStream fi = new FileInputStream(new File(nombre.concat(".txt")));
	     ObjectInputStream oi = new ObjectInputStream(fi);
             
             lee=oi.readObject();
             oi.close();
             fi.close();
        } catch (Exception e) {
             e.printStackTrace();
             Logger.getLogger(WriteReader.class.getName()).log(Level.SEVERE, null, e);
        }
       return lee;
    
    }
    
    
    
    
}
