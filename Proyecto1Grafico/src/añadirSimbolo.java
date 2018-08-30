

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class añadirSimbolo extends javax.swing.JFrame 
{    
    public static int cont=0;
    public static char car;
    public static int tamanio=1;    
    //public static ArrayList<Character> caracter = new ArrayList<Character>();
    //public static HashMap <Character, Automata> automatas = new HashMap <Character, Automata>();
    //Lista de símbolos
    //public static DefaultListModel listaSimbolos = new DefaultListModel();
    public añadirSimbolo()
    {
        super("Simbolos");
        initComponents();
        this.setLocationRelativeTo(null);
        jList1.setModel(ManejoDeSimbolos.listaSimbolos);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Añadir símbolo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(116, 116, 116))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            if((jTextField1.getText().length() != 0 && jTextField1.getText().length() == 1))
            {
                String str = jTextField1.getText();
                //Convertimos a char el valor del jTextField1
                car = str.charAt(0);
                System.out.println(""+ car);
                //Guardamos el valor en un ArrayList
                ManejoDeSimbolos.automatas.put(car, (Automata.CreaAFNBasico(car)));
                //ManejoDeSimbolos.automatas.put(new ID(car), (Automata.CreaAFNBasico(car)));
                //-----------------automatas.put(car, (Automata.CreaAFNBasico(car)));
                //Generamos e imprimimos el autómata
                //--------ManejoDeSimbolos.automatas.get(car).printAutomata();
                //-----------------automatas.get(car).printAutomata();
                //Automata.CreaAFNBasico(car).printAutomata();
                //Se limpia el jTextField
                jTextField1.setText(null);
                
                ManejoDeSimbolos.listaSimbolos.addElement(car);
                //-----------------listaSimbolos.addElement(car);
            }
            else 
            {
                jTextField1.setText(null);                
                JOptionPane.showMessageDialog(null,"No puede estar vacio o tener más de un caracter");
            }
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();
            
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
