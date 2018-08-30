
import java.util.Map;
import javax.swing.JOptionPane;

public class AndOr extends javax.swing.JFrame 
{
    public int opc;
    public int choice;
    public char a;
    public char b;
    public AndOr() 
    {
        super("And-Or");
        initComponents();
        jList2.setModel(ManejoDeSimbolos.listaSimbolos);
        this.setLocationRelativeTo(null);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList2);

        jLabel1.setText("Selecciona dos símbolos");

        jButton1.setText("Seleccionar símbolo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AND", "OR" }));

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Seleccionar símbolo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton1))
                        .addGap(50, 50, 50)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jButton2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(36, 36, 36))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            seleccionarSimbolo();
            jButton1.setEnabled(false);
            opc = jList2.getSelectedIndex();
            (ManejoDeSimbolos.listaSimbolos).remove(opc);
        }
        catch(Exception e)
        {
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        choice = jComboBox1.getSelectedIndex();
        jButton1.setEnabled(true);
        jButton4.setEnabled(true);
        if(choice == 0)
        {
            //System.out.println(a);
            //System.out.println(ManejoDeSimbolos.automatas.entrySet());
            System.out.println("Unión");
            //ManejoDeSimbolos.automatas.get(a).printAutomata();
            System.out.println(ManejoDeSimbolos.automatas.get(a) );
            (ManejoDeSimbolos.automatas.get(a)).UnirAutomata(ManejoDeSimbolos.automatas.get(b));
            //(ManejoDeSimbolos.automatas.get(a)).printAutomata();
            //(ManejoDeSimbolos.automatas.get(a)).printLenguaje();
            //((char) ManejoDeSimbolos.listaSimbolos.get( jList2.getSelectedIndex()))).Automata.UnirAutomata.(ManejoDeSimbolos.listaSimbolos.get( jList2.getSelectedIndex()));
            System.out.println("fin\n");
            ManejoDeSimbolos.listaSimbolos.addElement(a);
            //(ManejoDeSimbolos.automatas.get(a)).printLenguaje();
            
        }
        else if(choice == 1)
        {
            System.out.println("Concatenacion");   
            /*System.out.println(ManejoDeSimbolos.automatas.get(a));
            System.out.println(ManejoDeSimbolos.automatas.get(b));*/
            (ManejoDeSimbolos.automatas.get(a)).ConcatenarAutomata(ManejoDeSimbolos.automatas.get(b));
            //(ManejoDeSimbolos.automatas.get(a)).printAutomata();
            //System.out.println(ManejoDeSimbolos.automatas.get(a));
            //(ManejoDeSimbolos.automatas.get(a)).printLenguaje();
            System.out.println("fin\n");
            ManejoDeSimbolos.listaSimbolos.addElement(a);
                        
        }
        /*else if(choice == 2)
        {
            System.out.println("?");   
            System.out.println(ManejoDeSimbolos.automatas.get(a) );
            (ManejoDeSimbolos.automatas.get(a)).CerraduraPregunta(ManejoDeSimbolos.automatas.get(b));
            (ManejoDeSimbolos.automatas.get(a)).printAutomata();
            //(ManejoDeSimbolos.automatas.get(a)).printLenguaje();
            System.out.println("fin\n");
            ManejoDeSimbolos.listaSimbolos.addElement(a);
        }*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
        {
            seleccionarSimbolo2();
            jButton4.setEnabled(false);
            opc = jList2.getSelectedIndex();
            (ManejoDeSimbolos.listaSimbolos).remove(opc);
        }
        catch(Exception e)
        {
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed
    
    public Character seleccionarSimbolo()
    {
        //System.out.println(""+  ManejoDeSimbolos.automatas.keySet());
        a = new Character((Character)ManejoDeSimbolos.listaSimbolos.get( jList2.getSelectedIndex()));
        //System.out.println("... " +  a);
        return a;
    }
    public Character seleccionarSimbolo2()
    {
        b = new Character((Character)ManejoDeSimbolos.listaSimbolos.get( jList2.getSelectedIndex()));
        //System.out.println("... " +  ManejoDeSimbolos.listaSimbolos.get( jList2.getSelectedIndex() ));
        return b;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
