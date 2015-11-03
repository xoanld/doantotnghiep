package kho;

import connect.MyConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import resource.CommonValue;

public class NhapHang extends myframe.MyFrame {
    
    private MyConnection myConnection;
    private CommonValue commonValue;
    private String maKho;
    private String maNv;
    private DefaultTableModel dtm;
    private double tongGia;
    private HangTon hangTon;
    
    public NhapHang(MyConnection myConnection,String maKho,String maNv,HangTon hangTon) {
        setBackground();
        initComponents();
        dtm=(DefaultTableModel) tbHangMua.getModel();
        getScreenSize();
        this.maKho=maKho;
        this.maNv=maNv;
        this.hangTon=hangTon;
        setSize(width, height);
        disableSeparator(tbHang);
        disableSeparator(tbHangMua);
          this.myConnection=myConnection;
        commonValue=new CommonValue();
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
                    tfTongGia.setText(String.valueOf((double)(soluong*(Double.parseDouble(tfDonGia.getText())))));
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
                    tfTongGia.setText((double)(soluong*(Double.parseDouble(tfDonGia.getText())))+"");
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHangMua = new javax.swing.JTable();
        btClear = new javax.swing.JButton();
        btDatHang = new javax.swing.JButton();
        lbTongGia = new javax.swing.JLabel();
        btOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nhập Hàng");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSplitPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        tfSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSoLuongActionPerformed(evt);
            }
        });

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
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfMaMh, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTenMH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDonGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTongGia, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btThemHang, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(tfTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(tfMaMh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(tfTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(28, 28, 28))
        );

        tbHangMua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbHangMua.setForeground(new java.awt.Color(0, 0, 204));
        tbHangMua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hàng", "Tên Mặt Hàng", "Nhà Cung Cấp", "Đơn Giá", "Số Lượng", "Tổng Tiền"
            }
        ));
        tbHangMua.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbHangMua.setFillsViewportHeight(true);
        tbHangMua.setRowHeight(30);
        tbHangMua.setRowMargin(5);
        jScrollPane2.setViewportView(tbHangMua);

        btClear.setText("Làm Mới");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btDatHang.setText("Nhập Hàng");
        btDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDatHangActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btDatHang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbTongGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTongGia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDatHang)
                    .addComponent(btClear))
                .addContainerGap(33, Short.MAX_VALUE))
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
                myConnection.updateSql(commonValue.InsertPhieuNhap(maNv, maKho, dateFormat.format(date)));
                String id=myConnection.getIdPhieuNhap();
                
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    String sql=commonValue.InsertChiTietPhieuNhap(id,dtm.getValueAt(i, 1)+"",dtm.getValueAt(i, 5)+"");
                    myConnection.updateSql(sql);
                    try {
                        sql=commonValue.InsertHangTonKho(dtm.getValueAt(i, 1)+"", maKho , dtm.getValueAt(i, 5)+"");
                        myConnection.updateSql(sql);
                    } catch (Exception e) {
                        String soluongAppear=dtm.getValueAt(i, 5)+"";
                        String slOld=myConnection.getSoluongTonKho(maKho, dtm.getValueAt(i, 1)+"");
                        int newSoluong=Integer.parseInt(slOld)+Integer.parseInt(soluongAppear);
                        sql=commonValue.UpdateHangTonKho(dtm.getValueAt(i, 1)+"", maKho ,String.valueOf(newSoluong));
                        myConnection.updateSql(sql);
                    }
                }
                dialogMessage("Phiếu được nhập thành công",JOptionPane.INFORMATION_MESSAGE);
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

    private void btOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrderActionPerformed
        int index=tbHang.getSelectedRow();
        if (index==-1) {
            dialogMessage("Bạn chưa chọn mặt hàng", JOptionPane.WARNING_MESSAGE);
        }else{
            tfSoLuong.setText("");
            tfTongGia.setText("");
            tfMaMh.setText(tbHang.getModel().getValueAt(index, 0)+"");
            tfTenMH.setText(tbHang.getModel().getValueAt(index, 1)+"");
            tfTenNCC.setText(tbHang.getModel().getValueAt(index, 4)+"");
            tfDonGia.setText(tbHang.getModel().getValueAt(index, 2)+"");
        }
    }//GEN-LAST:event_btOrderActionPerformed

    private void tfSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSoLuongActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        hangTon.LoadDataToTable("");
    }//GEN-LAST:event_formWindowClosing
    
    
    public void LoadDataToTable(String value){
        tbHang.setModel(LoadDataToTable(myConnection,commonValue.SelectHang(value)));
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
