
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
    public  HashMap<String,String> Tabla = new HashMap<String, String>();
    public HashMap<String,String> Tabla2= new HashMap<String, String>();
    public  ArrayList<String> Reglas = new ArrayList<String>();
    public ArrayList<String> Izq = new ArrayList<String>();
    public ArrayList<Character> Alfabeto= new ArrayList<Character>();
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
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();

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
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Tabla");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Evaluar cadena con LL1");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Generar items");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Tabla LL0");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton12)
                                    .addComponent(jButton13)
                                    .addComponent(jButton14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        for (int i = 0; i <data.length(); i++) {
            if(!Character.valueOf(data.charAt(i)).equals('>') && !Character.valueOf(data.charAt(i)).equals(';') && !Character.valueOf(data.charAt(i)).equals('|') && !Character.valueOf(data.charAt(i)).equals('e') )
                if(!Alfabeto.contains(Character.valueOf(data.charAt(i))))
                    Alfabeto.add(data.charAt(i));
        }
        
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
         T.DefineToken(">", "Flecha");
         T.DefineToken("|", "OR");
      
         
        
        
        
       
        
        AnalizadorSintacticoG AN=new AnalizadorSintacticoG(data, AutomatasFinales.get(0).AFNtoAFD(), T);
        
       
        if(AN.G(n)){
           //n.printNodo();
               
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

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        ArrayList<Character> ListaSimbolos = new ArrayList<Character>();
        for(char x: jTextField1.getText().toCharArray()){
            ListaSimbolos.add(x);
        }
        LL1 miau = new LL1(n);
        miau.Follow(ListaSimbolos.get(0)).forEach(n->System.out.println(n) );
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        
        ArrayList<Character> X = new ArrayList<Character>();
        ArrayList<Character> Y = new ArrayList<Character>();
        
        Y.add('$');
        X.add('$');
        
        for(Character c: data.toCharArray()){
            if(!Y.contains(c)){
                if(!(c.equals('|') || c.equals(';') || c.equals('>') || c.equals('#'))){
                    Y.add(c);
                }
            }    
            if(!X.contains(c)){
                if(!(c.equals('|') || c.equals(';') || c.equals('>') || c.equals('#'))){
                    if(!(c.equals('E') || c.equals('e') || c.equals('F') || c.equals('t') || c.equals('T') || c.equals('>'))){
                        X.add(c);
                     }    
                }
            }
        }
        
        
//        for(Character c: Y){
//            System.out.print(c+" ");
//        }
//        System.out.println(" ");
//        for(Character c: X){
//            System.out.print(c+" ");
//        }
        
       
        
//        CREO LA ESTRUCTURA DE LA TABLA
        
        for(Character c: Y){
            for(Character cc: X){
                if(c.equals(cc)){
                    if(c.equals('$')){
                        Tabla.put(String.valueOf(c).concat(String.valueOf(cc)),"ACEPTAR");
                    }
                    else
                        Tabla.put(String.valueOf(c).concat(String.valueOf(cc)),"POP");
                }
                else
                    Tabla.put(String.valueOf(c).concat(String.valueOf(cc)),"");
            }
        
        }
        
//        FIN DE LA ESTRUCTURA
    
//       for(Map.Entry<String,String> entry: Tabla.entrySet()){
//           System.out.println(entry.getKey()+" "+ entry.getValue());
//       }
//        OBTENGO REGLAS
   

    
    StringTokenizer babasonicos = new StringTokenizer(data,";>");
     String aux3 = new String();
    while(babasonicos.hasMoreTokens()){
        String aux = babasonicos.nextToken();
       
        if(aux.length()==1){
            if(!aux.contains("#")){
                aux3=aux;
                //System.out.println(aux3);
            }
        }
        else{
            StringTokenizer kaboom = new StringTokenizer(aux,"|");
            while(kaboom.hasMoreTokens()){
                String aux2= kaboom.nextToken();
                Izq.add(aux3);
                Reglas.add(aux2);
            }
        
        }

    }
    
//    for(String s: Reglas)
//            System.out.print(s+" ");
//    System.out.println("");
//    for(String s: Izq)
//            System.out.print(s+" ");
   
    LL1 l= new LL1(n);
    int i=0;
    for(String regla: Reglas){
         ArrayList<Character> m = new ArrayList<Character>();
        for (Character charact : regla.toCharArray() ) {
            m.add(charact);
        }
        
        for(Character ch : l.First(m)){
            
            Tabla.replace( Izq.get(i).concat(ch.toString()), regla.concat(","+(i+1)));
            System.out.println("FIRST DE "+m+" es "+ch);
            if(ch.equals('#')){
                /////////////////////////////////////// CODIGO QUE FALTA!
                for(Character rep: l.Follow(Izq.get(i).charAt(0))){
                     Tabla.replace( Izq.get(i).concat(rep.toString()), regla.concat(","+(i+1)));
                }
                
                
            }
            System.out.println("["+Izq.get(i).concat(ch.toString())+","+regla+"]");
        }
        i++;
    }
    
           for(Map.Entry<String,String> entry: Tabla.entrySet()){
                System.out.println(entry.getKey()+" "+ entry.getValue());
            }
    
        
    JOptionPane.showMessageDialog(null, "Tabla LL1 generada correctamente");
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        String cadena= new String();
        String accion = new String();
        cadena=JOptionPane.showInputDialog(null);
        cadena=cadena.replaceAll("[0-9]", "n");
        ArrayList<Character> cad= new ArrayList<Character>();
        int bandera=0;
        for(Character x: cadena.toCharArray()){
            if(x.equals('n')){
                if(bandera==0){
                    cad.add(x);
                    //System.out.println(x.toString());
                    bandera++;
                }
                
            }
            else{
                bandera=0;
                cad.add(x);
                //System.out.println(x.toString());
            }
        }
        cad.add('$');
        cadena=cad.stream().map(Object::toString)
                        .collect(Collectors.joining(""));
        //System.out.println(cadena);
        Stack<Character> Pila = new Stack<Character>();
        Pila.push('$');
        Pila.push('E');
        //String llave=Pila.lastElement().toString().concat(String.valueOf(cadena.charAt(0)));
        //System.out.println(Tabla.get(llave));
         String llave=Pila.lastElement().toString().concat(String.valueOf(cadena.charAt(0)));
         String accions=Tabla.get(llave);
         //
       ArrayList<simbolosTablaLL1> lista = new ArrayList<simbolosTablaLL1>();
        // RECORRIDO EN LA TABLA
        while(!Pila.isEmpty()){
         
            System.out.println(Pila.toString()+"            "+cadena+"          "+accions);
            simbolosTablaLL1 sim = new simbolosTablaLL1(Pila.toString(), cadena, Tabla.get(llave).toString());
            lista.add(sim);
            if(Tabla.get(llave).equals("POP")){
                Pila.pop();
                cadena=cadena.substring(1);
                llave=Pila.lastElement().toString().concat(String.valueOf(cadena.charAt(Integer.valueOf(0))));
                        
                 accions=Tabla.get(llave);
                
            }
            else if(Tabla.get(llave).equals("ACEPTAR")){
                JOptionPane.showMessageDialog(null, "Cadena válida");
                TablaEvaluada tab = new TablaEvaluada();
                tab.setVisible(true);
                tab.mostrarValores(lista);
                //this.dispose();
                break;
            }
            else if(Tabla.get(llave).equals("")){
                JOptionPane.showMessageDialog(null, "Cadena  NO válida");
                break;
            }
            
            else{
                Pila.pop();
                int numero=0;
                // CODIGO SI SE DEBE EJECUTAR UNA ACCION
                StringTokenizer kaboom = new StringTokenizer(accions, ",");
                while(kaboom.hasMoreTokens()){
                    String j=kaboom.nextToken();
                    if(numero==0){
                        
                        for (int i = j.length()-1; i >= 0; i--) {
                            if(j.contains("#")){
                                
                            }
                            
                            else{
                             Pila.push(j.charAt(i));
                            }
                        }
                        numero++;
                    }
                    else{
                        
                        llave=Pila.lastElement().toString().concat(String.valueOf(cadena.charAt(Integer.valueOf(0))));
                        
                        accions=Tabla.get(llave);
                    }
                    
                }
               
                
            }
            
        
        }
        
        
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        n.addItems();
        System.out.println("termine");
        n.printNodo();
        
        

//       
//        System.out.println("");
//        //n.printNodo();
//        System.out.println("");
//        
//        System.out.println("Operacion mover con T");
//        
//        for(Nodo aux: analizador.Mover(analizador.Cerradura(n.getAbajo()),'T') ){ //cerradura de E->°E+T
//            while(aux!=null){
//                System.out.print(aux.getSimbolo()+"->");
//                aux=aux.getDerecha();
//            }
//            System.out.println("");
//        }
//
//
//
//        System.out.println("");
//       // n.printNodo();
//        System.out.println("");
//        System.out.println("Operacion ir a");
//        for(Nodo aux: analizador.Ir_A(Prueba,'T') ){ //cerradura de So con T 
//            while(aux!=null){
//                System.out.print(aux.getSimbolo()+"->");
//                aux=aux.getDerecha();
//            }
//            System.out.println("");
//        }
        
         
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        
        //primero creo la pila que guarda los elementos que no he analizado
        Stack<ArrayList<Nodo>> stack = new Stack<ArrayList<Nodo>>(); 
        
        LR analizador = new LR(n); //aqui tengo todos mis items SIN MODIFICAR
        
        //Analizo So
        int j=0;
        ArrayList<String> Resp= new ArrayList<String>();
        ArrayList<ArrayList<Nodo>> Respuesta= new ArrayList<ArrayList<Nodo>>();
        ArrayList<ArrayList<Nodo>> VieneDe= new ArrayList<ArrayList<Nodo>>();
        stack.push(analizador.Cerradura(n));
        Respuesta.add(stack.get(0));
        Resp.add("Cerradura");
        VieneDe.add(stack.get(0));
    
        while(!stack.isEmpty()){
            ArrayList<Nodo> Sn=stack.pop(); //obtengo el ultimo elemento de la pila
            for (Character c : Alfabeto) {
                ArrayList<Nodo> AAA= analizador.Ir_A(Sn, c);
               // System.out.println("Ir a "+j+","+c);
                if(!analizador.ExisteEn(Respuesta,AAA )){
//                    System.out.println("si");
//                    for (Nodo no :  AAA) {
//                        analizador.ImprimeHorizontal(no);
//                    }
                    stack.add(analizador.Ir_A(Sn, c));//hago ir a del ultimo elemento de la pila con cada caracter
                    
                    
                    Respuesta.add(AAA);
                    VieneDe.add(Sn);
                    Resp.add("S"+j+","+c);
                     
                }
               
            }
            j++;
        
        
        
        }
        
        int i=0;
        j=0;
        for (ArrayList<Nodo> arrayList : Respuesta) {
            if(arrayList.size()!=0){
                System.out.println("");
                System.out.print("S"+j+"= ir a ");
                System.out.println(Resp.get(i));
               
                for (Nodo no :  arrayList) {

                    analizador.ImprimeHorizontal(no);
                }
                System.out.println("Viene de");
                for (Nodo ne  : VieneDe.get(i)) {
                    analizador.ImprimeHorizontal(ne);
                }
                j++;
            }
            i++;
        }
        
//        Nodo test= new Nodo();
//        Nodo test2=new Nodo();
//        Nodo test3=new Nodo();
//        test.setSimbolo('E');
//        test.setDerecha(new Nodo());
//        test.getDerecha().setSimbolo('T');
//        test.getDerecha().setDerecha(new Nodo());
//        test.getDerecha().getDerecha().setSimbolo('°');
//        test.getDerecha().getDerecha().setDerecha(new  Nodo());
//        
//        test2.setSimbolo('T');
//        test2.setDerecha(new Nodo());
//        test2.getDerecha().setSimbolo('T');
//        test2.getDerecha().setDerecha(new Nodo());
//        test2.getDerecha().getDerecha().setSimbolo('°');
//        test2.getDerecha().getDerecha().setDerecha(new Nodo());
//        test2.getDerecha().getDerecha().getDerecha().setSimbolo('*');
//        test2.getDerecha().getDerecha().getDerecha().setDerecha(new Nodo());
//        test2.getDerecha().getDerecha().getDerecha().getDerecha().setSimbolo('F');
//        test2.getDerecha().getDerecha().getDerecha().getDerecha().setDerecha(new Nodo());
//        
//        test3.setSimbolo('T');
//        test3.setDerecha(new Nodo());
//        test3.getDerecha().setSimbolo('T');
//        test3.getDerecha().setDerecha(new Nodo());
//        test3.getDerecha().getDerecha().setSimbolo('°');
//        test3.getDerecha().getDerecha().setDerecha(new Nodo());
//        test3.getDerecha().getDerecha().getDerecha().setSimbolo('/');
//        test3.getDerecha().getDerecha().getDerecha().setDerecha(new Nodo());
//        test3.getDerecha().getDerecha().getDerecha().getDerecha().setSimbolo('F');
//        test3.getDerecha().getDerecha().getDerecha().getDerecha().setDerecha(new Nodo());
//        
//        
//        ArrayList<Nodo> tes=new ArrayList<Nodo>();
//        
//        tes.add(test2);
//        //tes.add(test3);
//        tes.add(test);
//       
//        
//        System.out.println(analizador.ExisteEn(stack, tes));
//        //System.out.println(analizador.ConjuntoEsIgual(stack.get(11), tes));
        
        
    }//GEN-LAST:event_jButton17ActionPerformed
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
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
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
