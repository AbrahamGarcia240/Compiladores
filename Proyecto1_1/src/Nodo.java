/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abraham
 */
public class Nodo {
     private Character simbolo;
    private Nodo derecha;
    private Nodo abajo;
    private Boolean terminal;

    
     void setSimbolo(Character c){
 	this.simbolo=c;
 }

 Character  getSimbolo(){
 	return simbolo;
 }

 void setDerecha(Nodo n){
 	this.derecha=n;
 }

 Nodo getDerecha(){
 	return derecha;
 }

 void setAbajo(Nodo n){
 	this.abajo=n;
 }

 Nodo getAbajo(){
 	return abajo;
 }

 void setTerminal(Boolean b){
 	this.terminal=b;
 }

 Boolean isTerminal(){
 	return terminal;
 }
}
