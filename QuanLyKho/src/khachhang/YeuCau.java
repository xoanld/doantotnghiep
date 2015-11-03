package khachhang;

import connect.MyConnection;
import javax.swing.table.DefaultTableModel;
import resource.CommonValue;

public class YeuCau extends myframe.MyFrame {

    private MyConnection myConnection;
    private CommonValue myCommonValue;
    private String idKh;
    private DefaultTableModel dtm;

    public YeuCau(MyConnection myConnection, String idKh) {
        setBackground();
        initComponents();
        getScreenSize();
        setSize(width, height);
        this.idKh = idKh;
        setLocation((width - this.getWidth()) / 2, (height - this.getHeight()) / 2);
        this.myConnection = myConnection;
        myCommonValue = new CommonValue();
        LoadDataToTable(idKh);
        disableSeparator(tbDataDonDat);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDataDonDat = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbDataDonDat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbDataDonDat.setForeground(new java.awt.Color(0, 0, 255));
        tbDataDonDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDataDonDat.setFillsViewportHeight(true);
        tbDataDonDat.setRowHeight(40);
        tbDataDonDat.setRowMargin(5);
        jScrollPane1.setViewportView(tbDataDonDat);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Yêu Cầu Đặt Hàng");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void LoadDataToTable(String value) {
        tbDataDonDat.setModel(LoadDataToTable(myConnection, myCommonValue.SelectDatHang(value)));
        dtm = (DefaultTableModel) tbDataDonDat.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String tt = dtm.getValueAt(i, 2) + "";
            if (tt.equalsIgnoreCase("true")) {
                dtm.setValueAt("Đã được duyệt", i, 2);
            } else {
                if (tt.equalsIgnoreCase("false")) {
                    dtm.setValueAt("Đã bị từ chối", i, 2);
                } else {
                    dtm.setValueAt("Đang đợi duyệt", i, 2);
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDataDonDat;
    // End of variables declaration//GEN-END:variables
}
