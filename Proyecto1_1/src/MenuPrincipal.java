

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

public class MenuPrincipal extends javax.swing.JFrame 
{
    public char a;
    public MenuPrincipal() 
    {
        super("Menú principal");
        initComponents();
        this.setLocationRelativeTo(null);
        JList list = new JList(ManejoDeSimbolos.listaSimbolos);
        //Test.main();
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Añadir símbolos", "And/Or", "Estrella/Más", "Cerraduras", "Unir autómatas", "Imprimir autómata" }));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecciona una opción");

        jButton2.setText("Limpiar todo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar Automata");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cargar automatas aritmeticos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(129, 129, 129)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int x = jComboBox1.getSelectedIndex();
        if(x ==0 )
        {
            new añadirSimbolo().setVisible(true);
            this.dispose();            
        }
        else if( x == 1)
        {
             new AndOr().setVisible(true);
            this.dispose();            
        }
        else if(x == 2)
        {
            new estrellaMas().setVisible(true);
            this.dispose();
        }
        else if(x == 3)
        {
            new Cerraduras().setVisible(true);
            this.dispose();
        }
        /*else if(x == 4)
        {
            try
            {
                
                jTextArea1.setText("Lenguaje: " + ManejoDeSimbolos.automatas.keySet().toString());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else if(x== 5)
        {
            new AFNtoAFD().setVisible(true);
            this.dispose();
        }*/
        else if(x == 4)
        {
            new UnirAutomatas().setVisible(true);            
            this.dispose();
        }
        else if(x == 5)
        {
            new ImprimirAutomata().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ManejoDeSimbolos.listaSimbolos.removeAllElements();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        WriteReader cargar=new WriteReader();
        new LoadFile().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        WriteReader lee=new WriteReader();
        int size;
        String cadenas[]={"int","float","sen","cos","tan","log","mas","menos","prod","div","pard","pari","exp"};
        for(String cad: cadenas){
            size=ManejoDeSimbolos.automataTotal.getSize();
            System.out.println(cad);
            //ManejoDeSimbolos.automatasFinales.put(size, (Automata)lee.getLee(jTextField1.getText()));
            Automata me=(Automata)lee.getLee(cad);

            try {


               me.printAutomata();
            } catch (Exception ex) {
                Logger.getLogger(LoadFile.class.getName()).log(Level.SEVERE, null, ex);
            }


             if(ManejoDeSimbolos.listaSimbolos.isEmpty()){
                 System.out.println("is empty");
                ManejoDeSimbolos.listaSimbolos.addElement(0);
                ManejoDeSimbolos.automatas.put(0, (Automata)lee.getLee(cad));
             }
             else{
                 System.out.println(ManejoDeSimbolos.listaSimbolos.lastElement());
                 ManejoDeSimbolos.listaSimbolos.addElement((Integer)ManejoDeSimbolos.listaSimbolos.lastElement()+1);
                 ManejoDeSimbolos.automatas.put((Integer)ManejoDeSimbolos.listaSimbolos.lastElement(), (Automata)lee.getLee(cad));
                 System.out.println(ManejoDeSimbolos.automatas.toString());
             }
        
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed
public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
 public void CreaAutomataFinal(Automata auto)
    {
                if(UnirAutomatas.AutomatasFinales.isEmpty())
                {
                	UnirAutomatas.AutomatasFinales.add(new Automata());
                	UnirAutomatas.AutomatasFinales.set(0, Automata.AgregaATotal(UnirAutomatas.AutomatasFinales.get(0), auto));
                        ManejoDeSimbolos.listaSimbolos.addElement("Final");
                }
                else{
                    UnirAutomatas.AutomatasFinales.set(0, Automata.AgregaATotal(UnirAutomatas.AutomatasFinales.get(0), auto));
                }
               
            }
      
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
