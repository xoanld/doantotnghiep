package banhang;

import connect.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import resource.CommonValue;

public class ChiTietDonDat extends myframe.MyFrame {

    private MyConnection myConnection;
    private CommonValue commonValue;
    private String maDon;
    private DonDatHang donDatHang;
    private DefaultTableModel dtm;
    private String maNV;

    public ChiTietDonDat(MyConnection myConnection, String maDon, String maNV, DonDatHang donDatHang) {
        setBackground();
        initComponents();
        this.myConnection = myConnection;
        this.donDatHang = donDatHang;
        commonValue = new CommonValue();
        this.maNV = maNV;
        getScreenSize();
        setSize(width, height);
        setVisible(true);
        this.maDon = maDon;
        LoadDataToTable();
        disableSeparator(tbDataDonDat);
        lbMaDon.setText(maDon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbMaDon = new javax.swing.JLabel();
        btDuyet = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDataDonDat = new javax.swing.JTable();
        btXuatHang = new javax.swing.JButton();
        btHoaDon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(227, 241, 254));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chi Tiết Đơn Đặt Hàng");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Mã Số Đơn:");

        lbMaDon.setFont(new java.awt.Font("Tahoma", 1, 18));
        lbMaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbMaDon.setText("Mã Kho:");

        btDuyet.setText("Duyệt Yêu Cầu");
        btDuyet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDuyetActionPerformed(evt);
            }
        });

        tbDataDonDat.setBackground(new java.awt.Color(227, 241, 254));
        tbDataDonDat.setFont(new java.awt.Font("Tahoma", 1, 14));
        tbDataDonDat.setForeground(new java.awt.Color(0, 0, 255));
        tbDataDonDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbDataDonDat.setCellSelectionEnabled(true);
        tbDataDonDat.setFillsViewportHeight(true);
        tbDataDonDat.setRowHeight(40);
        tbDataDonDat.setRowMargin(5);
        jScrollPane2.setViewportView(tbDataDonDat);

        btXuatHang.setText("In Phiếu Xuất Hàng");
        btXuatHang.setEnabled(false);
        btXuatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXuatHangActionPerformed(evt);
            }
        });

        btHoaDon.setText("Xuất Hóa Đơn");
        btHoaDon.setEnabled(false);
        btHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(lbMaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addGap(105, 105, 105))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btXuatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(22, 22, 22)
                .addComponent(btDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 526, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lbMaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXuatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel4)
                    .addContainerGap(387, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDuyetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDuyetActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(new Date());

        try {
            myConnection.updateSql(commonValue.insertPhieuXuat(maNV, maDon, date));
            myConnection.updateSql(commonValue.UpdateDatMua(maDon, "true"));
            myConnection.updateSql(commonValue.insertHoaDon(maDon, date));
            String idHoaDon = myConnection.getIdHoaDon();
            String idPx = myConnection.getIdPhieuXuat();
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String sqlCTHD = commonValue.insertChiTietHoaDon(idHoaDon, dtm.getValueAt(i, 0) + "", dtm.getValueAt(i, 3) + "", dtm.getValueAt(i, 2) + "");
                System.out.println(sqlCTHD);
                myConnection.updateSql(sqlCTHD);
                String tenKho = dtm.getValueAt(i, 4).toString().trim();
                try {
                    String id = myConnection.getIdKho(tenKho);
                    myConnection.updateSql(commonValue.insertChiTietPhieuXuat(idPx, dtm.getValueAt(i, 3).toString().trim(), id, dtm.getValueAt(i, 0).toString().trim()));
                    String soluongAppear = dtm.getValueAt(i, 3) + "";
                    String slOld = myConnection.getSoluongTonKho(id, dtm.getValueAt(i, 0) + "");
                    int newSoluong = Integer.parseInt(slOld) - Integer.parseInt(soluongAppear);
                    if (newSoluong == 0) {
                        String sql = commonValue.DeleteHangTonKho(dtm.getValueAt(i, 0) + "", id);
                        myConnection.updateSql(sql);
                    } else {
                        String sql = commonValue.UpdateHangTonKho(dtm.getValueAt(i, 0) + "", id, String.valueOf(newSoluong));
                        myConnection.updateSql(sql);
                    }
                    btHoaDon.setEnabled(true);
                    btXuatHang.setEnabled(true);
                    btDuyet.setEnabled(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    dialogMessage(ex.toString(), JOptionPane.ERROR_MESSAGE);
                }
//                    closeForm();
                donDatHang.LoadDataToTable("");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            dialogMessage(ex.toString(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btDuyetActionPerformed

private void btXuatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXuatHangActionPerformed
    try {
        JasperDesign jasperDesign = JRXmlLoader.load("src/Report/PhieuXuat.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, myConnection.getConnetc());
        JasperViewer.viewReport(jasperPrint, false);
    } catch (Exception ex) {
        ex.printStackTrace();
        dialogMessage("Error:" + ex.toString(), JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btXuatHangActionPerformed

private void btHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHoaDonActionPerformed
    try {
        JasperDesign jasperDesign = JRXmlLoader.load("src/Report/HoaDon.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, myConnection.getConnetc());
        JasperViewer.viewReport(jasperPrint, false);
    } catch (Exception ex) {
        ex.printStackTrace();
        dialogMessage("Error:" + ex.toString(), JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btHoaDonActionPerformed

    public void LoadDataToTable() {
        tbDataDonDat.setModel(LoadDataToTable(myConnection, commonValue.SelectHangDatMua(maDon)));
        dtm = (DefaultTableModel) tbDataDonDat.getModel();
        dtm.addColumn("Kho");
        JComboBox[] comboBox = new JComboBox[dtm.getRowCount()];
        for (int i = 0; i < dtm.getRowCount(); i++) {
            comboBox[i] = new JComboBox();
            String id = dtm.getValueAt(i, 0) + "";
            String sql = "SELECT * FROM " + CommonValue.HANGTON_TABLE_NAME + " AS A INNER JOIN " + CommonValue.KHO_TABLE_NAME
                    + " AS B ON A." + CommonValue.KHO_ID + "=B." + CommonValue.KHO_ID + " WHERE A." + CommonValue.HANG_ID + "='" + id + "' AND " + CommonValue.HANGTON_SOLUONG + ">=" + dtm.getValueAt(i, 3);
            try {
                ResultSet rs = myConnection.selectSql(sql);
                while (rs.next()) {
                    comboBox[i].addItem(rs.getString(CommonValue.KHO_NAME));
                }
            } catch (SQLException ex) {
                dialogMessage(ex.toString(), JOptionPane.ERROR_MESSAGE);
            }
            tbDataDonDat.getColumn("Kho").setCellEditor(new DefaultCellEditor(comboBox[i]));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDuyet;
    private javax.swing.JButton btHoaDon;
    private javax.swing.JButton btXuatHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMaDon;
    private javax.swing.JTable tbDataDonDat;
    // End of variables declaration//GEN-END:variables
}
