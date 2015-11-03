package guimain;

import account.Login;
import banhang.DonDatHang;
import connect.MyConnection;
import hang.GuiHang;
import java.awt.Color;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import khachhang.DatHang;
import khachhang.InsertKhachHang;
import khachhang.YeuCau;
import kho.GuiKho;
import nhaccungcap.GuiNhacCungCap;
import nhanvien.GuiNhanVien;
import report.BaoCao;
import resource.CommonValue;

public class GuiMain extends myframe.MyFrame {

    private MyConnection myConnection;
    private String maNv;
    private BufferedImage image;

    public GuiMain() {

        try {
            UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
            UIManager.getLookAndFeelDefaults().put("Frame.background", new Color(227, 241, 254));
            image = ImageIO.read(ClassLoader.getSystemResource("image/background.png"));
            setContentPane(new JLabel(new ImageIcon(image)));
        } catch (Exception e) {
        }
        setUndecorated(true);
        initComponents();
        setupButton(btQlBanHang);
        setupButton(btLogin);
        setupButton(btQLHang);
        setupButton(btQLKho);
        setupButton(btQLNhaCungCap);
        setupButton(btQLNhanVien);
        setupButton(btGuess);
        setupButton(btExit);
        setupButton(btQLBaoCao);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getScreenSize();
        setSize(width, height);
        myConnection = new MyConnection();
        try {
            myConnection.openConnect();
        } catch (Exception ex) {
            dialogMessage("Lỗi: Kết nối thất bại", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btQLNhanVien = new javax.swing.JButton();
        btQLNhaCungCap = new javax.swing.JButton();
        btQLKho = new javax.swing.JButton();
        btQLHang = new javax.swing.JButton();
        btLogin = new javax.swing.JButton();
        btQlBanHang = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        btQLBaoCao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btGuess = new javax.swing.JButton();
        btThemKhachHang = new javax.swing.JButton();
        btKhachHangLogin = new javax.swing.JButton();
        btUpdateKhachHang = new javax.swing.JButton();
        btDatHang = new javax.swing.JButton();
        btDonDat = new javax.swing.JButton();
        panelContain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btQLNhanVien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btQLNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staff.png"))); // NOI18N
        btQLNhanVien.setText("Nhân Viên");
        btQLNhanVien.setEnabled(false);
        btQLNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQLNhanVienActionPerformed(evt);
            }
        });

        btQLNhaCungCap.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btQLNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/product.png"))); // NOI18N
        btQLNhaCungCap.setText("Nhà Cung Cấp");
        btQLNhaCungCap.setEnabled(false);
        btQLNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQLNhaCungCapActionPerformed(evt);
            }
        });

        btQLKho.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btQLKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kho.png"))); // NOI18N
        btQLKho.setText("Kho");
        btQLKho.setEnabled(false);
        btQLKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQLKhoActionPerformed(evt);
            }
        });

        btQLHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btQLHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hang.png"))); // NOI18N
        btQLHang.setText("Hàng");
        btQLHang.setEnabled(false);
        btQLHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQLHangActionPerformed(evt);
            }
        });

        btLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); // NOI18N
        btLogin.setText("Đăng Nhập");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        btQlBanHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btQlBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/market.png"))); // NOI18N
        btQlBanHang.setText("Bán Hàng");
        btQlBanHang.setEnabled(false);
        btQlBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQlBanHangActionPerformed(evt);
            }
        });

        btExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        btExit.setText("Exit");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        btQLBaoCao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btQLBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/report.png"))); // NOI18N
        btQLBaoCao.setText("Báo Cáo");
        btQLBaoCao.setEnabled(false);
        btQLBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btQLBaoCaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btQlBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btQLHang)
                .addGap(37, 37, 37)
                .addComponent(btQLKho, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btQLNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btQLBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btExit)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btQLNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExit)
                .addComponent(btQLBaoCao)
                .addComponent(btLogin)
                .addComponent(btQlBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btQLHang)
                .addComponent(btQLKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btQLNhaCungCap))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btGuess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/guess.png"))); // NOI18N

        btThemKhachHang.setText("Đăng ký");
        btThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemKhachHangbtThemKhachHangActionPerformed(evt);
            }
        });

        btKhachHangLogin.setText("Đăng Nhập");
        btKhachHangLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhachHangLoginbtKhachHangLoginActionPerformed(evt);
            }
        });

        btUpdateKhachHang.setText("Đổi Thông Tin");
        btUpdateKhachHang.setEnabled(false);
        btUpdateKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateKhachHangbtUpdateKhachHangActionPerformed(evt);
            }
        });

        btDatHang.setText("Đặt Hàng");
        btDatHang.setEnabled(false);
        btDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDatHangbtDatHangActionPerformed(evt);
            }
        });

        btDonDat.setText("Đơn Đặt");
        btDonDat.setEnabled(false);
        btDonDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDonDatbtDonDatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btGuess, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
            .addComponent(btDatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btKhachHangLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btDonDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btThemKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btUpdateKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btThemKhachHang)
                .addGap(18, 18, 18)
                .addComponent(btKhachHangLogin)
                .addGap(18, 18, 18)
                .addComponent(btUpdateKhachHang)
                .addGap(18, 18, 18)
                .addComponent(btDatHang)
                .addGap(18, 18, 18)
                .addComponent(btDonDat)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        panelContain.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelContainLayout = new javax.swing.GroupLayout(panelContain);
        panelContain.setLayout(panelContainLayout);
        panelContainLayout.setHorizontalGroup(
            panelContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContainLayout.setVerticalGroup(
            panelContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelContain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setupButton(JButton button) {
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setBorder(null);
        button.setBorderPainted(false);
        button.setMargin(new Insets(10, 10, 10, 10));
    }
    private void btQLKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQLKhoActionPerformed
        JPanel jPanel = new GuiKho(myConnection, panelContain.getWidth(), panelContain.getHeight(), maNv);
        addPanel(jPanel);
    }//GEN-LAST:event_btQLKhoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        myConnection.closeConnect();
    }//GEN-LAST:event_formWindowClosing

    private void btQLNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQLNhaCungCapActionPerformed
        JPanel jPanel = new GuiNhacCungCap(myConnection, panelContain.getWidth(), panelContain.getHeight());
        addPanel(jPanel);
    }//GEN-LAST:event_btQLNhaCungCapActionPerformed

    private void btQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQLNhanVienActionPerformed
        JPanel jPanel = new GuiNhanVien(myConnection, panelContain.getWidth(), panelContain.getHeight());
        addPanel(jPanel);
    }//GEN-LAST:event_btQLNhanVienActionPerformed

    private void btQLHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQLHangActionPerformed
        JPanel jPanel = new GuiHang(myConnection, panelContain.getWidth(), panelContain.getHeight());
        addPanel(jPanel);
    }//GEN-LAST:event_btQLHangActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        new Login(myConnection, this);
    }//GEN-LAST:event_btLoginActionPerformed

    private void btQlBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQlBanHangActionPerformed
        JPanel jPanel = new DonDatHang(myConnection, panelContain.getWidth(), panelContain.getHeight(), maNv);
        addPanel(jPanel);
    }//GEN-LAST:event_btQlBanHangActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        closeForm();
    }//GEN-LAST:event_btExitActionPerformed

private void btQLBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btQLBaoCaoActionPerformed
    JPanel jPanel = new BaoCao(myConnection, panelContain.getWidth(), panelContain.getHeight());
    addPanel(jPanel);
}//GEN-LAST:event_btQLBaoCaoActionPerformed

    private void btThemKhachHangbtThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemKhachHangbtThemKhachHangActionPerformed
        new InsertKhachHang(myConnection);
    }//GEN-LAST:event_btThemKhachHangbtThemKhachHangActionPerformed

    private void btKhachHangLoginbtKhachHangLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhachHangLoginbtKhachHangLoginActionPerformed
        new khachhang.KhachHangLogin(myConnection, this);
    }//GEN-LAST:event_btKhachHangLoginbtKhachHangLoginActionPerformed

    private void btUpdateKhachHangbtUpdateKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateKhachHangbtUpdateKhachHangActionPerformed
        loginKhachHang(id, true);
        new khachhang.UpdateKhachHang(myConnection, id, tenKh, diaChi, sdt, email, userName, passWord);
    }//GEN-LAST:event_btUpdateKhachHangbtUpdateKhachHangActionPerformed

    private void btDatHangbtDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDatHangbtDatHangActionPerformed
        new DatHang(myConnection, id);
    }//GEN-LAST:event_btDatHangbtDatHangActionPerformed

    private void btDonDatbtDonDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDonDatbtDonDatActionPerformed
        new YeuCau(myConnection, id);
    }//GEN-LAST:event_btDonDatbtDonDatActionPerformed
    String id, userName, passWord, tenKh, diaChi, sdt, email;

    public void loginKhachHang(String id, boolean ck) {
        if (ck) {
            CommonValue commonValue = new CommonValue();
            this.id = id;
            try {
                ResultSet resultSet = myConnection.selectSql(commonValue.SelectKhachHang(id));
                while (resultSet.next()) {
                    tenKh = resultSet.getString(CommonValue.KHACHHANG_NAME);
                    diaChi = resultSet.getString(CommonValue.KHACHHANG_ADDRESS);
                    sdt = resultSet.getString(CommonValue.KHACHHANG_PHONENUMBER);
                    email = resultSet.getString(CommonValue.KHACHHANG_EMAIL);
                }
                ResultSet resultSet1 = myConnection.selectSql("select * from " + CommonValue.ACCOUNT_GUESS_TABLE_NAME + " where " + CommonValue.KHACHHANG_ID + "='" + id + "'");
                while (resultSet1.next()) {
                    userName = resultSet1.getString(CommonValue.ACCOUNT_GUESS_USERNAME);
                    passWord = resultSet1.getString(CommonValue.ACCOUNT_GUESS_PASS);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            btDatHang.setEnabled(ck);
            btUpdateKhachHang.setEnabled(ck);
            btDonDat.setEnabled(ck);
            btKhachHangLogin.setEnabled(!ck);
            btThemKhachHang.setEnabled(false);
        }

    }

    public void LoginNhanVien(String id, boolean ck, boolean isAdmin) {
        if (ck) {
            this.maNv = id;
            btQLHang.setEnabled(ck);
            btQLKho.setEnabled(ck);
            btQLNhaCungCap.setEnabled(ck);
            btQLNhanVien.setEnabled(isAdmin);
            btQlBanHang.setEnabled(ck);
            btDatHang.setEnabled(false);
            btDonDat.setEnabled(false);
            btKhachHangLogin.setEnabled(false);
            btThemKhachHang.setEnabled(false);
            btUpdateKhachHang.setEnabled(false);
            btLogin.setEnabled(false);
            btQLBaoCao.setEnabled(true);
        }
    }

    private void addPanel(JPanel jPanel) {
        panelContain.removeAll();
        panelContain.add(jPanel);
        panelContain.validate();
        panelContain.repaint();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GuiMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDatHang;
    private javax.swing.JButton btDonDat;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btGuess;
    private javax.swing.JButton btKhachHangLogin;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btQLBaoCao;
    private javax.swing.JButton btQLHang;
    private javax.swing.JButton btQLKho;
    private javax.swing.JButton btQLNhaCungCap;
    private javax.swing.JButton btQLNhanVien;
    private javax.swing.JButton btQlBanHang;
    private javax.swing.JButton btThemKhachHang;
    private javax.swing.JButton btUpdateKhachHang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelContain;
    // End of variables declaration//GEN-END:variables
}
