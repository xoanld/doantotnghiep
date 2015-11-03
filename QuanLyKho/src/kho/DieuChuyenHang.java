
package kho;

import connect.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import resource.CommonValue;

public class DieuChuyenHang extends myframe.MyFrame {
     private MyConnection myConnection;
    private CommonValue commonValue;
    private String maKho;
    private String maNv;
    private DefaultTableModel dtm;
    private double tongGia;
    private ArrayList<String>arr=new ArrayList<String>();
    private ResultSet resultSet;
    public DieuChuyenHang(MyConnection myConnection,String maKho,String maNv) {
        setBackground();
        initComponents();
        dtm=(DefaultTableModel) tbHangChuyen.getModel();
        getScreenSize();
        this.maKho=maKho;
        this.maNv=maNv;
        setSize(width, height);
          this.myConnection=myConnection;
        commonValue=new CommonValue();
        try {
            resultSet=myConnection.selectSql(commonValue.SelectKho(""));
                while (resultSet.next()) {                
                    cbKhoDich.addItem(resultSet.getString("Tên Kho"));
                    arr.add(resultSet.getString("Mã Kho"));
                }
            cbKhoDich.setSelectedIndex(0);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        disableSeparator(tbHang);
        disableSeparator(tbHangChuyen);
        
         LoadDataToTable("");
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
                }catch(Exception ex){
                     tfSoLuong.setText("0");
                    dialogMessage("Số lượng phải là số nguyên dương", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                if (!tfSoLuong.getText().equals("")) {
                    try{
                    double soluong=Double.parseDouble(tfSoLuong.getText().trim());
                }catch(Exception ex){
                    tfSoLuong.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfTenNCC = new javax.swing.JTextField();
        btThemHang = new javax.swing.JButton();
        tfSoLuong = new javax.swing.JTextField();
        tfMaMh = new javax.swing.JTextField();
        tfTenMH = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHangChuyen = new javax.swing.JTable();
        btClear = new javax.swing.JButton();
        btDatHang = new javax.swing.JButton();
        btOrder = new javax.swing.JButton();
        cbKhoDich = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Điều Chuyển Hàng");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSplitPane1.setBorder(null);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(130, 44));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("   Nhập tên hàng:    ");
        jSplitPane1.setLeftComponent(jLabel2);
        jSplitPane1.setRightComponent(tfSearch);

        tbHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbHang.setForeground(new java.awt.Color(0, 0, 204));
        tbHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbHang.setFillsViewportHeight(true);
        tbHang.setRowHeight(40);
        tbHang.setRowMargin(5);
        jScrollPane1.setViewportView(tbHang);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã MH:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tên MH:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số Lượng:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tên NCC:");

        tfTenNCC.setEnabled(false);

        btThemHang.setText("Thêm Vào Đơn Đặt HÀng");
        btThemHang.setMaximumSize(new java.awt.Dimension(100, 100));
        btThemHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemHangActionPerformed(evt);
            }
        });

        tfSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSoLuongActionPerformed(evt);
            }
        });

        tfMaMh.setEnabled(false);

        tfTenMH.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfMaMh, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(tfTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(241, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 688, Short.MAX_VALUE)
                        .addComponent(btThemHang, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btThemHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tbHangChuyen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbHangChuyen.setForeground(new java.awt.Color(0, 0, 204));
        tbHangChuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hàng", "Tên Mặt Hàng", "Nhà Cung Cấp", "Số Lượng"
            }
        ));
        tbHangChuyen.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbHangChuyen.setFillsViewportHeight(true);
        tbHangChuyen.setRowHeight(40);
        tbHangChuyen.setRowMargin(5);
        jScrollPane2.setViewportView(tbHangChuyen);

        btClear.setText("Làm Mới");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btDatHang.setText("Chuyển");
        btDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDatHangActionPerformed(evt);
            }
        });

        btOrder.setText("Đặt Hàng");
        btOrder.setMaximumSize(new java.awt.Dimension(100, 100));
        btOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrderActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Kho Đích:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 871, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cbKhoDich, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btDatHang)
                                .addGap(18, 18, 18)
                                .addComponent(btClear)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbKhoDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btClear)
                    .addComponent(btDatHang))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                dtm.addRow(new Object[]{dtm.getRowCount()+1,tfMaMh.getText(),tfTenMH.getText(),tfTenNCC.getText(),tfSoLuong.getText()});
            }else{
                dialogMessage("Mặt hàng đã tồn tại", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            dialogMessage("Chưa nhập thông tin mặt hằng muốn đặt",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btThemHangActionPerformed

    private void tfSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSoLuongActionPerformed

    }//GEN-LAST:event_tfSoLuongActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        for (int i = 0; i < dtm.getRowCount(); i++) {
            dtm.removeRow(i);
        }
        tongGia=0;
    }//GEN-LAST:event_btClearActionPerformed

    private void btDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDatHangActionPerformed
        if (dtm.getRowCount()>0) {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String date =dateFormat.format(new Date());
            String idKhoNhan=arr.get(cbKhoDich.getSelectedIndex());
            try {
                String sql=commonValue.InsertPhieuDieuChuyen(maKho, idKhoNhan, maNv, date);
                
                myConnection.updateSql(sql);
                String id=myConnection.getIdPhieuDieuChuyen();
                
                
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    sql=commonValue.InsertChiTietPhieuDieuChuyen(id,dtm.getValueAt(i, 1)+"", dtm.getValueAt(i, 4)+"");
                    myConnection.updateSql(sql);
                    String soluongAppear=dtm.getValueAt(i, 4)+"";
                        String slOld=myConnection.getSoluongTonKho(maKho, dtm.getValueAt(i, 1)+"");
                        int newSoluong=Integer.parseInt(slOld)-Integer.parseInt(soluongAppear);
                        sql=commonValue.UpdateHangTonKho(dtm.getValueAt(i, 1)+"", maKho ,String.valueOf(newSoluong));
                        myConnection.updateSql(sql);
                        
                        try {
                        sql=commonValue.InsertHangTonKho(dtm.getValueAt(i, 1)+"", idKhoNhan , dtm.getValueAt(i, 4)+"");
                        myConnection.updateSql(sql);
                    } catch (Exception e) {
                        slOld=myConnection.getSoluongTonKho(idKhoNhan, dtm.getValueAt(i, 1)+"");
                        newSoluong=Integer.parseInt(slOld)+Integer.parseInt(soluongAppear);
                        sql=commonValue.UpdateHangTonKho(dtm.getValueAt(i, 1)+"", idKhoNhan ,String.valueOf(newSoluong));
                        myConnection.updateSql(sql);
                    }
                }
                dialogMessage("Chuyển hàng thành công",JOptionPane.INFORMATION_MESSAGE);
                for (int i = dtm.getRowCount()-1; i>=0; i--) {
                    dtm.removeRow(i);
                }
                tongGia=0;
            } catch (Exception ex) {
                ex.printStackTrace();
                dialogMessage("Lỗi:"+ex.toString(), JOptionPane.ERROR_MESSAGE);
            }
        }else{
            dialogMessage("Không có mặt hàng nào", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btDatHangActionPerformed

    private void btOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrderActionPerformed
        int index=tbHang.getSelectedRow();
        if (index==-1) {
            dialogMessage("Bạn chưa chọn mặt hàng", JOptionPane.WARNING_MESSAGE);
        }else{
            tfSoLuong.setText("");
            tfMaMh.setText(tbHang.getModel().getValueAt(index, 0)+"");
            tfTenMH.setText(tbHang.getModel().getValueAt(index, 1)+"");
            tfTenNCC.setText(tbHang.getModel().getValueAt(index, 4)+"");
        }
    }//GEN-LAST:event_btOrderActionPerformed

     public void LoadDataToTable(String value){
        tbHang.setModel(LoadDataToTable(myConnection,commonValue.SelectHangTon(value, maKho,"")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDatHang;
    private javax.swing.JButton btOrder;
    private javax.swing.JButton btThemHang;
    private javax.swing.JComboBox cbKhoDich;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tbHang;
    private javax.swing.JTable tbHangChuyen;
    private javax.swing.JTextField tfMaMh;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenMH;
    private javax.swing.JTextField tfTenNCC;
    // End of variables declaration//GEN-END:variables
}
