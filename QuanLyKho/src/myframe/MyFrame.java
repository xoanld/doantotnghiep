package myframe;

import connect.MyConnection;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends  javax.swing.JFrame{
    protected int width,height;
    protected void getScreenSize(){
       this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
//        setModalityExclusionType(Dialog.ModalExclusionType.);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int)screenSize.getWidth();
        height = (int)screenSize.getHeight();
        setResizable(false);
        setVisible(true);
    }

    public MyFrame(){
//        setUndecorated(true);
    }
    
    protected void closeForm(){
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    protected  void dialogMessage(String message,int icon){
        JOptionPane.showMessageDialog(this,message,"Thông báo", icon);
    }
    
    protected DefaultTableModel LoadDataToTable(MyConnection myConnection,String sql){
        try {
           return fillDataToTable(myConnection.selectSql(sql));    
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Lối:"+e.toString(),"Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
     private DefaultTableModel fillDataToTable(ResultSet rs) throws  Exception{
            DefaultTableModel  defaultTableModel=new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
    // names of columns
           Vector columnNames=new Vector();
    int columnCount = metaData.getColumnCount();
    
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }
    defaultTableModel.setColumnIdentifiers(columnNames);
    // data of the table
    while (rs.next()) {
        Vector vector = new Vector();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.addElement(rs.getObject(columnIndex));
        }
        defaultTableModel.addRow(vector);
    }
    return defaultTableModel;
    }
     public void disableSeparator(JTable jTable){
           jTable.setShowHorizontalLines(true);
           jTable.setShowVerticalLines(true);
     }
    protected void setBackground() {
        try {
            BufferedImage image = ImageIO.read(ClassLoader.getSystemResource("image/background_blue.png"));
            setContentPane(new JLabel(new ImageIcon(image)));
        } catch (Exception e) {
        }
    }
}
