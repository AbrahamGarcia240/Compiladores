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
    private String simbolo;
    private char MinSimb;
    private char MaxSimb;
    private Estado destino;

    public Transicion(char MinSimb, char MaxSimb, Estado destino) {
        this.MinSimb = MinSimb;
        this.MaxSimb = MaxSimb;
        this.destino = destino;
    }

    
    public Transicion(String simbolo, Estado destino) {
        this.simbolo = simbolo;
        this.destino = destino;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public Estado getDestino() {
        return destino;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setDestino(Estado destino) {
        this.destino = destino;
    }
    
    public void printTrancision(){
        System.out.printf("----");
        System.out.print(this.simbolo);
        System.out.printf("---->%d\n",this.destino.getId());
    }
    
    
}
