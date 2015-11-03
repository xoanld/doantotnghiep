/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BaoCao.java
 *
 * Created on Apr 24, 2015, 5:53:38 AM
 */
package report;

import connect.MyConnection;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author BacKa
 */
public class BaoCao extends myframe.MyPanel {

    private MyConnection myConnection;

    public BaoCao(MyConnection myConnection, int w, int h) {
        initComponents();
        this.myConnection = myConnection;
        setSize(w, h);
        setVisible(true);
        UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(227,241,254));        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btXuatKho = new javax.swing.JButton();
        btNhap = new javax.swing.JButton();
        btTonKho = new javax.swing.JButton();
        btDieuChuyen = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thống Kê, Báo Cáo");

        btXuatKho.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btXuatKho.setText("Xuất Kho");
        btXuatKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXuatKhoActionPerformed(evt);
            }
        });

        btNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btNhap.setText("Nhập Kho");
        btNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhapActionPerformed(evt);
            }
        });

        btTonKho.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btTonKho.setText("Hàng Tồn");
        btTonKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTonKhoActionPerformed(evt);
            }
        });

        btDieuChuyen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btDieuChuyen.setText("Hàng Điều Chuyển");
        btDieuChuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDieuChuyenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btDieuChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btXuatKho, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(355, 355, 355)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btDieuChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btXuatKho, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void btXuatKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXuatKhoActionPerformed
    try {
        JasperDesign jasperDesign = JRXmlLoader.load("src/Report/HangXuat.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, myConnection.getConnetc());

        JasperViewer.viewReport(jasperPrint, false);
    } catch (Exception ex) {
        dialogMessage("Error:" + ex.toString(), JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btXuatKhoActionPerformed

private void btNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhapActionPerformed
    try {
        JasperDesign jasperDesign = JRXmlLoader.load("src/Report/HangNhap.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, myConnection.getConnetc());
        JasperViewer.viewReport(jasperPrint, false);
    } catch (Exception ex) {
        dialogMessage("Error:" + ex.toString(), JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btNhapActionPerformed

private void btTonKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTonKhoActionPerformed
    try {
        JasperDesign jasperDesign = JRXmlLoader.load("src/Report/HangTonKho.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, myConnection.getConnetc());
        JasperViewer.viewReport(jasperPrint, false);
    } catch (Exception ex) {
        dialogMessage("Error:" + ex.toString(), JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btTonKhoActionPerformed

private void btDieuChuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDieuChuyenActionPerformed
    try {
        JasperDesign jasperDesign = JRXmlLoader.load("src/Report/HangDieuChuyen.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, myConnection.getConnetc());
        JasperViewer.viewReport(jasperPrint, false);
    } catch (Exception ex) {
        ex.printStackTrace();
        dialogMessage("Error:" + ex.toString(), JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btDieuChuyenActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDieuChuyen;
    private javax.swing.JButton btNhap;
    private javax.swing.JButton btTonKho;
    private javax.swing.JButton btXuatKho;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
