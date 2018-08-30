/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class Transicion {
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
        int x = 10;
        printAutomata.jTextArea2.append("-----");
        System.out.printf("----");
        printAutomata.jTextArea2.append(Character.toString( this.simbolo) );
        System.out.print(this.simbolo);
        printAutomata.jTextArea2.append("----->" + this.destino.getId() + "\n");
        System.out.printf("---->%d\n",this.destino.getId());
    }
    
    
}
