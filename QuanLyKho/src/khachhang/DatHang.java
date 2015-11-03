package khachhang;

import connect.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import resource.CommonValue;

public class DatHang extends myframe.MyFrame {
     private MyConnection myConnection;
    private CommonValue commonValue;
    private String maKH;
    private DefaultTableModel dtm;
    private double tongGia;
    private int soLuongHang;
    public DatHang(MyConnection myConnection,String maKH) {
        setBackground();
        initComponents();
        dtm=(DefaultTableModel) tbHangMua.getModel();
        getScreenSize();
        this.maKH=maKH;
        setSize(width, height);
          this.myConnection=myConnection;
        commonValue=new CommonValue();
         LoadDataToTable("");
         disableSeparator(tbHang);
         disableSeparator(tbHangMua);
         tfSearch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                LoadDataToTable(tfSearch.getText().trim());
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                LoadDataToTable(tfSearch.getText().trim());
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
         
         tfSoLuong.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                try{
                    double soluong=Double.parseDouble(tfSoLuong.getText().trim());
                    if (soluong>soLuongHang) {
                        dialogMessage("Không đủ hàng trong kho",JOptionPane.WARNING_MESSAGE);
                        tfSoLuong.setText("");
                    }
                    tfTongGia.setText(String.valueOf((double)(soluong*(Double.parseDouble(tfDonGia.getText())))));
                }catch(Exception ex){
                    dialogMessage("Số lượng phải là số nguyên dương", JOptionPane.WARNING_MESSAGE);
                    tfSoLuong.setText("");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                if (!tfSoLuong.getText().equals("")) {
                    try{
                    double soluong=Double.parseDouble(tfSoLuong.getText().trim());
                    tfTongGia.setText((double)(soluong*(Double.parseDouble(tfDonGia.getText())))+"");
                }catch(Exception ex){
                }
                }
            }
            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel2 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        lbTongGia = new javax.swing.JLabel();
        btOrder = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfTenNCC = new javax.swing.JTextField();
        btThemHang = new javax.swing.JButton();
        tfDonGia = new javax.swing.JTextField();
        tfSoLuong = new javax.swing.JTextField();
        tfMaMh = new javax.swing.JTextField();
        tfTenMH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfTongGia = new javax.swing.JTextField();
        btClear = new javax.swing.JButton();
        btDatHang = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHangMua = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Hàng");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSplitPane1.setBorder(null);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(130, 44));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("   Nhập tên hàng:    ");
        jSplitPane1.setLeftComponent(jLabel2);
        jSplitPane1.setRightComponent(tfSearch);

        lbTongGia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTongGia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTongGia.setText("Tổng Giá: 0 ");

        btOrder.setText("Đặt Hàng");
        btOrder.setMaximumSize(new java.awt.Dimension(100, 100));
        btOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrderActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã MH:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tên MH:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số Lượng:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Đơn Giá:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tên NCC:");

        tfTenNCC.setEnabled(false);

        btThemHang.setText("Thêm Vào Đơn Đặt Hàng");
        btThemHang.setMaximumSize(new java.awt.Dimension(100, 100));
        btThemHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemHangActionPerformed(evt);
            }
        });

        tfDonGia.setEnabled(false);

        tfMaMh.setEnabled(false);

        tfTenMH.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tổng Giá:");

        tfTongGia.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addComponent(tfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfMaMh, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(tfTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTongGia, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btThemHang, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(438, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(tfTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfMaMh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(tfTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(tfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTongGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btThemHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );

        btClear.setText("Làm Mới");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btDatHang.setText("Đặt Hàng");
        btDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDatHangActionPerformed(evt);
            }
        });

        tbHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbHang.setForeground(new java.awt.Color(0, 0, 204));
        tbHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbHang.setFillsViewportHeight(true);
        tbHang.setRowHeight(40);
        tbHang.setRowMargin(5);
        jScrollPane1.setViewportView(tbHang);

        tbHangMua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbHangMua.setForeground(new java.awt.Color(0, 0, 255));
        tbHangMua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hàng", "Tên Mặt Hàng", "Nhà Cung Cấp", "Đơn Giá", "Số Lượng", "Tổng Tiền"
            }
        ));
        tbHangMua.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbHangMua.setRowHeight(30);
        tbHangMua.setRowMargin(4);
        jScrollPane2.setViewportView(tbHangMua);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1687, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1687, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1677, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1307, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(lbTongGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btClear)
                        .addGap(27, 27, 27)
                        .addComponent(btDatHang))))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTongGia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btClear)
                    .addComponent(btDatHang))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrderActionPerformed
        int index=tbHang.getSelectedRow();
        if (index==-1) {
            dialogMessage("Bạn chưa chọn mặt hàng", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                tfSoLuong.setText("");
                tfMaMh.setText(tbHang.getModel().getValueAt(index, 0)+"");
                tfTenMH.setText(tbHang.getModel().getValueAt(index, 1)+"");
                tfTenNCC.setText(tbHang.getModel().getValueAt(index, 3)+"");
                tfDonGia.setText(tbHang.getModel().getValueAt(index, 2)+"");
                String sql="select SUM(SOLUONG) as  'sl' from HANGTON WHERE MAMH='"+tfMaMh.getText().trim()+"'";
                ResultSet rs= myConnection.selectSql(sql);
                if (rs.first()) {
                    soLuongHang=rs.getInt("sl");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btOrderActionPerformed

    private void btThemHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemHangActionPerformed
        if (!tfSoLuong.getText().equals("")) {
            boolean checkExist=false;
            for (int i = 0; i < dtm.getRowCount(); i++) {
                    if (dtm.getValueAt(i, 1).toString().trim().equals(tfMaMh.getText().trim())) {
                    checkExist=true;
                    break;
                }
            }
            if (!checkExist) {
                    dtm.addRow(new Object[]{dtm.getRowCount()+1,tfMaMh.getText(),tfTenMH.getText(),tfTenNCC.getText(),tfDonGia.getText(),tfSoLuong.getText(),tfTongGia.getText()});    
                    tongGia+=Double.parseDouble(tfTongGia.getText());
                    lbTongGia.setText("Tổng Giá: "+tongGia+" ");
            }else{
                dialogMessage("Mặt hàng đã tồn tại", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            dialogMessage("Chưa nhập thông tin mặt hằng muốn đặt",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btThemHangActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        for (int i = 0; i < dtm.getRowCount(); i++) {
            dtm.removeRow(i);
        }
        tongGia=0;
        lbTongGia.setText("Tổng Giá: "+tongGia+" ");
    }//GEN-LAST:event_btClearActionPerformed

    private void btDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDatHangActionPerformed
        if (dtm.getRowCount()>0) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            try {
                myConnection.updateSql(commonValue.InsertDatMua(maKH,dateFormat.format(date).toString()));
                String id=myConnection.getIdDonDH();
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    String sql=commonValue.InsertChiTietPhieuDat(id, dtm.getValueAt(i, 1)+"", dtm.getValueAt(i, 5)+"");
                    myConnection.updateSql(sql);
                }
                dialogMessage("Phiếu đặt mua đã được gửi",JOptionPane.INFORMATION_MESSAGE);
                for (int i = dtm.getRowCount()-1; i>=0; i--) {
                     dtm.removeRow(i);
               }
               tongGia=0;
                  lbTongGia.setText("Tổng Giá: "+tongGia+" ");
            } catch (Exception ex) {
                ex.printStackTrace();
                dialogMessage("Lỗi:"+ex.toString(), JOptionPane.ERROR_MESSAGE);
            }
        }else{
            dialogMessage("Không có mặt hàng nào", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btDatHangActionPerformed
     public void LoadDataToTable(String value){
        tbHang.setModel(LoadDataToTable(myConnection,commonValue.SelectHangDat(value)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDatHang;
    private javax.swing.JButton btOrder;
    private javax.swing.JButton btThemHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbTongGia;
    private javax.swing.JTable tbHang;
    private javax.swing.JTable tbHangMua;
    private javax.swing.JTextField tfDonGia;
    private javax.swing.JTextField tfMaMh;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenMH;
    private javax.swing.JTextField tfTenNCC;
    private javax.swing.JTextField tfTongGia;
    // End of variables declaration//GEN-END:variables
}
