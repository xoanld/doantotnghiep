package banhang;

import connect.MyConnection;
import javax.swing.JOptionPane;
import resource.CommonValue;

/**
 *
 * @author BacKa
 */
public class DonDatHang extends myframe.MyPanel{

    private MyConnection myConnection;
    private CommonValue commonValue;
    private String maNV;
    public DonDatHang(MyConnection myConnection,int w,int h,String maNV) {
        initComponents();
        this.maNV=maNV;
        this.myConnection=myConnection;
        commonValue=new CommonValue();
        setSize(w, h);
        setVisible(true);
        LoadDataToTable("");
        disableSeparator(tbData);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(227, 241, 254));

        jPanel1.setBackground(new java.awt.Color(227, 241, 254));

        btDelete.setText("Từ chối");
        btDelete.setMaximumSize(new java.awt.Dimension(100, 100));
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btUpdate.setText("Chi Tiết");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(btUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbData.setBackground(new java.awt.Color(227, 241, 254));
        tbData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbData.setForeground(new java.awt.Color(0, 0, 255));
        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbData.setCellSelectionEnabled(true);
        tbData.setFillsViewportHeight(true);
        tbData.setRowHeight(40);
        tbData.setRowMargin(5);
        jScrollPane1.setViewportView(tbData);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Yêu Cầu Đặt Hàng");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
          int index=tbData.getSelectedRow();
        if (index==-1) {
            dialogMessage("Bạn chưa chọn đơn đặt hàng", JOptionPane.WARNING_MESSAGE);
        }else{
            int result=JOptionPane.showConfirmDialog(null,"Bạn muốn từ chối đơn đặt hàng này?", "Message", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
                try {
                    myConnection.updateSql(commonValue.UpdateDatMua(tbData.getModel().getValueAt(index,0)+"", "false"));
                    dialogMessage("Từ chối thành công",JOptionPane.INFORMATION_MESSAGE);
                    LoadDataToTable("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    dialogMessage("Từ chối thất bại",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
          int index=tbData.getSelectedRow();
        if (index==-1) {
            dialogMessage("Bạn chưa chọn đơn đặt hàng", JOptionPane.WARNING_MESSAGE);
        }else{
                new ChiTietDonDat(myConnection, tbData.getValueAt(index, 0)+"",maNV,this);
        }
        
    }//GEN-LAST:event_btUpdateActionPerformed
     public void LoadDataToTable(String value){
        tbData.setModel(LoadDataToTable(myConnection,commonValue.SelectDatMua()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbData;
    // End of variables declaration//GEN-END:variables
}
