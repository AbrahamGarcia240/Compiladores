
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cerraduras extends javax.swing.JFrame 
{
    public int opc;
    public int a;
    public int aux;
    public char auxC;
    public String input, input2;
    public ArrayList<Estado> prueba = new ArrayList<Estado>();
    public ArrayList<Estado> prueba2 = new ArrayList<Estado>();
    public Cerraduras() 
    {
        super("Cerraduras");
        initComponents();
        jList4.setModel(ManejoDeSimbolos.listaSimbolos);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cerraduras");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cerradura Epsilon", "Operación mover", "Operación Ir_A", "Cerradura ?" }));

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList4);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane1.setViewportView(jTextArea3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        a = (Integer)ManejoDeSimbolos.listaSimbolos.get( jList4.getSelectedIndex());
        opc = jComboBox1.getSelectedIndex();
        if(opc == 0)
        {
            try
            {
                input = JOptionPane.showInputDialog("Ingresa un estado.");
                aux = Integer.parseInt(input);
                
                System.out.println((ManejoDeSimbolos.automatas.get(a)).getEstado(aux));
                ArrayList<Estado> prueba= Automata.CerraduraEpsilon((ManejoDeSimbolos.automatas.get(a)).getEstado(aux));
                System.out.println("Ceradura epsilon:");
                //imprimo el resultado
                prueba.forEach(n->System.out.println(n.getId() + " / "));
                prueba.forEach(n-> jTextArea3.append( n.getId() + " / ")  );
                System.out.println("fin");  
            }
            catch (Exception e) 
            {
                System.out.println(e);
            }
            
        }
        else if(opc == 1)
        {
            try/*------------------------------------*/
            {
                input = JOptionPane.showInputDialog("Ingrese un estado.");
                aux = Integer.parseInt(input);
                input2 = JOptionPane.showInputDialog("Ingrese un carácter");
                auxC = input2.charAt(0);
                System.out.println("Mover");
                try 
                {
                    prueba2 = Automata.Mover((ManejoDeSimbolos.automatas.get(a)).getEstado(aux), auxC);
                    prueba2.forEach(n-> System.out.println(n.getId()));
                    prueba2.forEach(n-> jTextArea3.append(""+ n.getId()) );
                    System.out.println("\n");               
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                prueba.forEach(n-> jTextArea3.append( n.getId() + " / ")  );
                //prueba.forEach(n->System.out.println(n.getId() + " / "));
                System.out.println("fin");
            }
            catch (Exception e) 
            {
                System.out.println(e);
            }
            
        }
        else if(opc == 2)
        {
            try/*------------------------------------*/
            {
                input = JOptionPane.showInputDialog("Ingrese un estado.");
                aux = Integer.parseInt(input);
                input2 = JOptionPane.showInputDialog("Ingrese un carácter");
                auxC = input2.charAt(0);
                System.out.println("ir_a");
                try {
                     prueba2=Automata.Ir_A((ManejoDeSimbolos.automatas.get(a)).getEstado(aux), auxC);
                     prueba2.forEach(n-> jTextArea3.append( n.getId() + " / ")  );
                     prueba2.forEach(n-> System.out.println(n.getId()));
                    System.out.println("\n");               
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                prueba.forEach(n-> jTextArea3.append( n.getId() + " / ")  );
                prueba.forEach(n->System.out.println(n.getId() + " / "));
                System.out.println("fin");
            }
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
        else if(opc == 3)
        {
            try
            {
                System.out.println("Cerradura pregunta");
                (ManejoDeSimbolos.automatas.get(a)).CerraduraPregunta();
                
            }
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
