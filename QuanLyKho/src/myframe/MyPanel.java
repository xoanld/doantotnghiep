/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myframe;

import connect.MyConnection;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BacKa
 */
public class MyPanel extends  JPanel{
    
    protected void closeForm(){
        this.dispatchEvent(new WindowEvent(null, WindowEvent.WINDOW_CLOSING));
    }
    protected  void dialogMessage(String message,int icon){
        JOptionPane.showMessageDialog(null,message,"Thông báo", icon);
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
}
