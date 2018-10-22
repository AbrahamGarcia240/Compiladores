
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UnirAutomatas extends javax.swing.JFrame 
{
    public Nodo n= new Nodo();
    public int cont=0, a, opc;
    boolean flag;
    public Automata f;
    public String data = "";
    public static String c= "Final", lxma ="" ;
    public static ArrayList<Automata> AutomatasFinales=new ArrayList<Automata>();
    public UnirAutomatas() 
    {
        super("Unir autómatas");
        initComponents();
        this.setLocationRelativeTo(null);
        jList5.setModel(ManejoDeSimbolos.listaSimbolos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Unir autómatas");

        jScrollPane2.setViewportView(jList5);

        jButton2.setText("Unir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Imprimir AFN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setDragEnabled(true);
        jTextArea1.setPreferredSize(new java.awt.Dimension(200, 300));
        jScrollPane1.setViewportView(jTextArea1);

        jButton5.setText("Lexema");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Pintar automata");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Pintar AFD");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton4.setText("Evaluar cadena");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setText("Guardar automata final");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Cargar automata final");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Construir AFD");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Evaluar gramatica");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("First");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Follow");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7)
                                .addGap(4, 4, 4)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3))
                                    .addComponent(jButton10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton12)
                                    .addComponent(jButton13))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
                        .addComponent(jButton1)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            jTextArea1.setText(null);
            seleccionarSimbolo();
            CreaAutomataFinal(ManejoDeSimbolos.automatas.get(a));
            opc = jList5.getSelectedIndex();
            (ManejoDeSimbolos.listaSimbolos).remove(opc);
            
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try
        {
            jTextArea1.setText(null);
            AutomatasFinales.get(0).printAutomataTotal();
        }
        catch(Exception e)
        {            
        }        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try
        {
            if(!AutomatasFinales.isEmpty())
            {
                jTextArea1.setText(null);
                
                lxma = JOptionPane.showInputDialog("Ingresa un lexema ");
                AnalizadorLexico analizador=new AnalizadorLexico(lxma, AutomatasFinales.get(0).AFNtoAFD());
                   //analizador.getToken();
                     EstadoLexico E = new EstadoLexico();
                   int i=0;
                   do{
                       i=analizador.getToken();
                      if(i!=0)
                      {
                          if(i==6){
                            
                              analizador.buildEstadoLexico(E);
                                      
                          }
                          jTextArea1.append("El token es: " + i + "\n");
                          jTextArea1.append("El lexema es: " + analizador.getLexema() + "\n");
                          
                           System.out.print("El token es:");
                            System.out.println(i);
                           System.out.print("El lexema es:");
                            System.out.println(""+analizador.getLexema());
                       }


                   }while(i!=0);
                   /*analizador.useEstadoLexico(E);
                    do{
                       i=analizador.getToken();
                      if(i!=0)
                      {
                          
                          jTextArea1.append("El token es: " + i + "\n");
                          jTextArea1.append("El lexema es: " + analizador.getLexema() + "\n");
                          
                           System.out.print("El token es:");
                            System.out.println(i);
                           System.out.print("El lexema es:");
                            System.out.println(""+analizador.getLexema());
                       }


                   }while(i!=0);*/
            }    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            
                     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    
        AutomatasFinales.get(0).pintaAutomata();
        
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        AutomatasFinales.get(0).AFNtoAFD().pintaAutomata();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         Token T=new Token(AutomatasFinales.get(0).AFNtoAFD());
             T.DefineToken("D", "NUM");
           T.DefineToken("DD.D", "NUM2");
           T.DefineToken("DD.De-D", "NUM3");
            T.DefineToken("DD.De+D", "NUM4");
           T.DefineToken("^", "EXP");
           T.DefineToken("+", "MAS");
           T.DefineToken("-", "MENOS");
           T.DefineToken("/", "DIV");
           T.DefineToken("*", "PROD");
           T.DefineToken("(", "PARI");
           T.DefineToken(")", "PARD");
           T.DefineToken("sen", "SEN");
           T.DefineToken("cos", "COS");
           T.DefineToken("tan", "TAN");
           T.DefineToken("log", "LOG");
            
            System.out.println("Toke den MAS "+T.Tokens.get("MAS"));
            System.out.println("Token de NUM "+T.Tokens.get("NUM"));
            System.out.println("Token de NUM2 "+T.Tokens.get("NUM2"));
            System.out.println("Toke den DIV "+T.Tokens.get("DIV"));
            System.out.println("Toke den PARI "+T.Tokens.get("PARI"));
            System.out.println("Toke den SEN "+T.Tokens.get("SEN"));
            System.out.println("Toke den COS "+T.Tokens.get("COS"));
            System.out.println("Toke den TAN "+T.Tokens.get("TAN"));
            System.out.println("Toke den LOG "+T.Tokens.get("LOG"));
            System.out.println("Toke den NUM3 "+T.Tokens.get("NUM3"));
            System.out.println("Toke den NUM4 "+T.Tokens.get("NUM4"));
         
         AnalizadorSintactico sint=new AnalizadorSintactico(jTextField1.getText(), AutomatasFinales.get(0).AFNtoAFD(), T);
         Flotante v=new Flotante(0.0,"");
          if(sint.Analiza(v)){
              System.out.println("true");
              jLabel2.setText("Resultado: "+String.valueOf(v.getV()));
              jLabel3.setText("Posfijo: "+v.getS());
              System.out.println(v.getV());
              System.out.println(v.getS());
          }
          else{
              JOptionPane.showMessageDialog(null, "La cadena ingresada es incorrecta");
          }
          
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText(null);
         
          
            
            WriteReader escribe= new WriteReader();
        try {
            escribe.setEscribe(AutomatasFinales.get(0), JOptionPane.showInputDialog(null, "Ingresa el nombre del automata a guardar"));
        } catch (IOException ex) {
            Logger.getLogger(ImprimirAutomata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        ManejoDeSimbolos.listaSimbolos.addElement(c);
        
         WriteReader lee=new WriteReader();
     
        System.out.println(jTextField1.getText());
        //ManejoDeSimbolos.automatasFinales.put(size, (Automata)lee.getLee(jTextField1.getText()));
        Automata me=(Automata)lee.getLee(JOptionPane.showInputDialog(null, "Ingresa el nombre del automata a leer"));
        
        try {
           
  
           me.printAutomata();
        } catch (Exception ex) {
            Logger.getLogger(LoadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
         
        
        
        
        
        
        
        AutomatasFinales.add(0,me);
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
          Token T=new Token(AutomatasFinales.get(0).AFNtoAFD());
         T.DefineToken("D", "EXP"); 
         T.DefineToken("\\+", "M");
         T.DefineToken("\\-", "m");
         T.DefineToken("\\.", "p");
           T.DefineToken("+", "CMAS");
           T.DefineToken("*", "CEST");
           T.DefineToken("|", "OR");
           T.DefineToken("&", "AND");
           T.DefineToken("(", "PARI");
           T.DefineToken(")", "PARD");
           T.DefineToken("?", "CPRE");
           AnalizadorSintacticoER sint=new AnalizadorSintacticoER(jTextField1.getText(), AutomatasFinales.get(0).AFNtoAFD(), T);
           AutomataContainer v=new AutomataContainer();
           if(sint.Analiza(v)){
               v.getA().pintaAutomata();
               JOptionPane.showMessageDialog(null, "Mostrando AFD");
               v.getA().AFNtoAFD().pintaAutomata();
           }
           else{
                JOptionPane.showMessageDialog(null, "La cadena ingresada es incorrecta");
           }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
         //ManejoDeSimbolos.listaSimbolos.addElement(c);
        
          
        try { 
            data = new String(Files.readAllBytes(Paths.get(JOptionPane.showInputDialog(null, "Ingresa el nombre del archivo con las reglas").concat(".txt"))));
        } catch (IOException ex) {
            Logger.getLogger(UnirAutomatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        data=data.replaceAll("(\\r|\\n)", "");
   
        System.out.println(data);
        
        Token T=new Token(AutomatasFinales.get(0).AFNtoAFD());
         T.DefineToken("D", "Simbolo");
         T.DefineToken("+", "Simbolo2");
         T.DefineToken("-", "Simbolo3");
         T.DefineToken("*", "Simbolo4");
         T.DefineToken("/", "Simbolo5");
         T.DefineToken("#", "Simbolo6");
         T.DefineToken("(", "Simbolo7");
         T.DefineToken(")", "Simbolo8");
         T.DefineToken(";", "PuntoYComa");
         T.DefineToken("->", "Flecha");
         T.DefineToken("|", "OR");
      
         
        
        
        
       
        
        AnalizadorSintacticoG AN=new AnalizadorSintacticoG(data, AutomatasFinales.get(0).AFNtoAFD(), T);
        
       
        if(AN.G(n)){
           n.printNodo();
               
        }
        else{
            System.out.println("NEL");
        }  
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        
        ArrayList<Character> ListaSimbolos = new ArrayList<Character>();
        for(char x: jTextField1.getText().toCharArray()){
            ListaSimbolos.add(x);
        }
        LL1 miau = new LL1(n);
        miau.First(ListaSimbolos).forEach(n->System.out.println(n) );
        
        
    }//GEN-LAST:event_jButton12ActionPerformed
    public  Integer seleccionarSimbolo()
    {
        
        a = (Integer)ManejoDeSimbolos.listaSimbolos.get( jList5.getSelectedIndex());
        System.out.println(a);
        return a;
    }
   
    public void CreaAutomataFinal(Automata auto)
    {
                if(AutomatasFinales.isEmpty())
                {
                	AutomatasFinales.add(new Automata());
                	AutomatasFinales.set(0, Automata.AgregaATotal(AutomatasFinales.get(0), auto));
                        ManejoDeSimbolos.listaSimbolos.addElement(c);
                }
                else{
                    AutomatasFinales.set(0, Automata.AgregaATotal(AutomatasFinales.get(0), auto));
                }
               
            }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
