
import java.util.ArrayList;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielmezam
 */
public class TablaEvaluada extends javax.swing.JFrame {
    
    public TablaEvaluada() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
    public void mostrarValores(ArrayList<simbolosTablaLL1> array){
        String datos[][] = new String[array.size()][3];
        for(int i=0; i<array.size(); i++){
            datos[i][0] = array.get(i).getPila();
            datos[i][1] = array.get(i).getCadena();
            datos[i][2] = array.get(i).getAccions();
        }
        
        tablaEvaluada.setModel(new javax.swing.table.DefaultTableModel(
            datos,
            new String [] {
                "Pila", "Cadena", "Acción"
            }
        ));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEvaluada = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaEvaluada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Pila", "Cadena", "Acción"
            }
        ));
        jScrollPane1.setViewportView(tablaEvaluada);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEvaluada;
    // End of variables declaration//GEN-END:variables
}
