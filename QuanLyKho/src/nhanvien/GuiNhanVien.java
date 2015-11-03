
package nhanvien;

import connect.MyConnection;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import resource.CommonValue;

public class GuiNhanVien extends myframe.MyPanel {
    
      private MyConnection myConnection;
    private CommonValue myCommonValue;
    public static GuiNhanVien guiNhanVien;
    public GuiNhanVien(MyConnection myConnection,int w,int h) {
        initComponents();
        guiNhanVien=this;
        myCommonValue=new CommonValue();
        this.myConnection=myConnection;
        setSize(w, h);
        setVisible(true);
        LoadDataToTable("");
        disableSeparator(tbData);
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

        jLabel1 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel2 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btInsert2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý nhân viên");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSplitPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(130, 44));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("   Nhập tên hoặc mã nhân viên:    ");
        jSplitPane1.setLeftComponent(jLabel2);
        jSplitPane1.setRightComponent(tfSearch);

        tbData.setBackground(new java.awt.Color(227, 241, 254));
        tbData.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbData.setForeground(new java.awt.Color(0, 0, 255));
        tbData.setModel(new javax.swing.table.DefaultTableModel(
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
        tbData.setFillsViewportHeight(true);
        tbData.setRowHeight(40);
        tbData.setRowMargin(5);
        jScrollPane1.setViewportView(tbData);

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

        btInsert2.setText("Thêm");
        btInsert2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsert2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(btInsert2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btInsert2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int index=tbData.getSelectedRow();
        if (index==-1) {
            dialogMessage("Bạn chưa chọn nhân viên muốn xóa", JOptionPane.WARNING_MESSAGE);
        }else{
            int result=JOptionPane.showConfirmDialog(null,"Bạn muốn xóa nhân viên này?", "Message", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION) {
                try {
                    myConnection.updateSql(myCommonValue.DeleteNhanVien(tbData.getModel().getValueAt(index,0)+""));
                    myConnection.updateSql(myCommonValue.DeleteAccount(tbData.getModel().getValueAt(index,5)+""));
                    dialogMessage("Xóa thành công",JOptionPane.INFORMATION_MESSAGE);
                    LoadDataToTable("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    dialogMessage("Xóa thất bại",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        int index=tbData.getSelectedRow();
        if (index==-1) {
            dialogMessage("Bạn chưa chọn nhà cung cấp để sửa", JOptionPane.WARNING_MESSAGE);
        }else{
            String id=tbData.getModel().getValueAt(index, 0)+"";
            String name=tbData.getModel().getValueAt(index, 1)+"";
            String address=tbData.getModel().getValueAt(index, 2)+"";
            String phone=tbData.getModel().getValueAt(index, 3)+"";
            String birthday=tbData.getModel().getValueAt(index, 4)+"";
            String userName=tbData.getModel().getValueAt(index, 5)+"";
            String passWord=tbData.getModel().getValueAt(index, 6)+"";
            String adMin=tbData.getModel().getValueAt(index, 7)+"";
            new UpdateNhanVien(myConnection, id, name, address, phone, birthday, userName, passWord, adMin);
        }
    }//GEN-LAST:event_btUpdateActionPerformed
    public void LoadDataToTable(String value){
        tbData.setModel(LoadDataToTable(myConnection,myCommonValue.SelectNhanVien(value)));
    }
    private void btInsert2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsert2ActionPerformed
        new InsertNhanVien(myConnection);
    }//GEN-LAST:event_btInsert2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btInsert2;
    private javax.swing.JButton btUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tbData;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
