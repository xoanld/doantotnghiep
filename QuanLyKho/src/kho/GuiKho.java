/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kho;

import connect.MyConnection;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import resource.CommonValue;

/**
 *
 * @author BacKa
 */
public class GuiKho extends myframe.MyPanel {
    private MyConnection myConnection;
    private CommonValue commonValue;
    public static GuiKho guiKho;
    private String maNv;
    public GuiKho(MyConnection myConnection,int w,int h,String maNv) {
        initComponents();
        guiKho=this;
        this.maNv=maNv;
        this.myConnection=myConnection;
        commonValue=new CommonValue();
        setSize(w, h);
        setVisible(true);
        setBackground(Color.BLUE);
        disableSeparator(tbDataKho);
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
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btInsert = new javax.swing.JButton();
        btShowItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDataKho = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel2 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();

        btDelete.setText("Xóa");
        btDelete.setMaximumSize(new java.awt.Dimension(100, 100));
        btDelete.setMinimumSize(null);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btUpdate.setText("Sửa");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btInsert.setText("Thêm");
        btInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertActionPerformed(evt);
            }
        });

        btShowItem.setText("Xem  hàng");
        btShowItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btShowItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addComponent(btShowItem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUpdate)
                    .addComponent(btInsert)
                    .addComponent(btShowItem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbDataKho.setBackground(new java.awt.Color(227, 241, 254));
        tbDataKho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbDataKho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbDataKho.setForeground(new java.awt.Color(0, 0, 255));
        tbDataKho.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDataKho.setFillsViewportHeight(true);
        tbDataKho.setRowHeight(40);
        tbDataKho.setRowMargin(5);
        jScrollPane1.setViewportView(tbDataKho);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý kho");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSplitPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(130, 44));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("   Nhập tên hoặc mã kho:    ");
        jSplitPane1.setLeftComponent(jLabel2);
        jSplitPane1.setRightComponent(tfSearch);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int index=tbDataKho.getSelectedRow();
        if (index==-1) {
            dialogMessage("Bạn chưa chọn kho muốn xóa", JOptionPane.WARNING_MESSAGE);
        }else{
            
            int result=JOptionPane.showConfirmDialog(null,"Bạn muốn xóa nhà kho này?", "Message", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
                try {
                    String idKho=tbDataKho.getModel().getValueAt(index,0)+"";
                    ResultSet rs=myConnection.selectSql(commonValue.SelectHangTon("", idKho, ""));
                    System.out.println(idKho);
                    if (rs.first()) {
                        dialogMessage("Trong kho còn hàng không thể xóa",JOptionPane.WARNING_MESSAGE);
                    }else{
                    myConnection.updateSql(commonValue.DeleteKho( idKho));
                    dialogMessage("Xóa thành công",JOptionPane.INFORMATION_MESSAGE);
                    LoadDataToTable("");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    dialogMessage("Xóa thất bại",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        int index=tbDataKho.getSelectedRow();
        if (index==-1) {
            dialogMessage("Bạn chưa chọn kho để sửa", JOptionPane.WARNING_MESSAGE);
        }else{
            String id=tbDataKho.getModel().getValueAt(index, 0)+"";
            String name=tbDataKho.getModel().getValueAt(index, 1)+"";
            String address=tbDataKho.getModel().getValueAt(index, 2)+"";
            String phone=tbDataKho.getModel().getValueAt(index, 3)+"";
            new UpdateKho(myConnection,id, name, address, phone);
        }
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertActionPerformed
        new InsertKho(myConnection);
    }//GEN-LAST:event_btInsertActionPerformed

    private void btShowItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btShowItemActionPerformed
         int index=tbDataKho.getSelectedRow();
        if (index==-1) {
            dialogMessage("Bạn chưa chọn kho", JOptionPane.WARNING_MESSAGE);
        }else{
            String id=tbDataKho.getModel().getValueAt(index, 0)+"";
            String name=tbDataKho.getModel().getValueAt(index, 1)+"";
            new HangTon(myConnection, id, name,maNv);
        }
    }//GEN-LAST:event_btShowItemActionPerformed
     public void LoadDataToTable(String value){
        tbDataKho.setModel(LoadDataToTable(myConnection,commonValue.SelectKho(value)));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btInsert;
    private javax.swing.JButton btShowItem;
    private javax.swing.JButton btUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tbDataKho;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
