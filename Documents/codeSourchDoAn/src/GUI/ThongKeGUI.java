/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.QuanLyThongKeController;

/**
 *
 * @author boopa
 */
public class ThongKeGUI extends javax.swing.JPanel {

    /**
     * Creates new form HangHoaGUI
     */
    public ThongKeGUI() {
        initComponents();
        QuanLyThongKeController controller = new QuanLyThongKeController();
//        controller.setDataToChart1(jpnChart1);
        //controller.setDataToChart2(jpnChart2);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnChart1 = new javax.swing.JPanel();
        jpnChart2 = new javax.swing.JPanel();

        javax.swing.GroupLayout jpnChart1Layout = new javax.swing.GroupLayout(jpnChart1);
        jpnChart1.setLayout(jpnChart1Layout);
        jpnChart1Layout.setHorizontalGroup(
            jpnChart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
        );
        jpnChart1Layout.setVerticalGroup(
            jpnChart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnChart2Layout = new javax.swing.GroupLayout(jpnChart2);
        jpnChart2.setLayout(jpnChart2Layout);
        jpnChart2Layout.setHorizontalGroup(
            jpnChart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnChart2Layout.setVerticalGroup(
            jpnChart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jpnChart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnChart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpnChart1;
    private javax.swing.JPanel jpnChart2;
    // End of variables declaration//GEN-END:variables
}
