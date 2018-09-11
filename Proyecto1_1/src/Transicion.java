
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class Transicion implements Serializable{
    private Character simbolo;
    private Character MinSimb;
    private Character MaxSimb;
    private Estado destino;

    public Transicion(Character MinSimb, Character MaxSimb, Estado destino) {
        this.MinSimb = MinSimb;
        this.MaxSimb = MaxSimb;
        this.destino = destino;
    }

    
    public Transicion(Character simbolo, Estado destino) {
        this.simbolo = simbolo;
        this.destino = destino;
    }

    public Character getSimbolo() {
        return simbolo;
    }

    public Estado getDestino() {
        return destino;
    }

    public void setSimbolo(Character simbolo) {
        this.simbolo = simbolo;
    }

    public void setDestino(Estado destino) {
        this.destino = destino;
    }
    
    public void printTrancision(){
        try {
             ImprimirAutomata.jTextArea2.append(" -> "+this.destino.getId());
             ImprimirAutomata.jTextArea2.append(" "+this.simbolo + "\n");
        } catch (Exception e) {
        }
      
        System.out.printf(" -> %d ",this.destino.getId());
        System.out.println(this.simbolo);
    }
    public void printTrancisionAFD(){
        try {
            UnirAutomatas.jTextArea1.append(" -> "+this.destino.getId());
            UnirAutomatas.jTextArea1.append(" "+this.simbolo + "\n");
        } catch (Exception e) {
        }
        
        System.out.printf(" -> %d ",this.destino.getId());
        System.out.println(this.simbolo);
    }
    
    //UnirAutomatas.jTextArea1
    public void printTrancisionTotal(){
        try {
            UnirAutomatas.jTextArea1.append(" -> "+this.destino.getId());
            UnirAutomatas.jTextArea1.append(" "+this.simbolo + "\n");
        } catch (Exception e) {
        }
        //
        System.out.printf(" -> %d ",this.destino.getId());
        System.out.println(this.simbolo);
    }
    
}
