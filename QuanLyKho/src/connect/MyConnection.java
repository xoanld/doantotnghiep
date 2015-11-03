package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import resource.CommonValue;

public class MyConnection {
    private Connection mConnection;
    public MyConnection() {
    }
    public void openConnect() throws Exception{
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLKHO;User=sa;PassWord=123456";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        mConnection = DriverManager.getConnection(url);
        
    }
    public Connection getConnetc(){
        return mConnection;
    }
    public void closeConnect(){
        try {
            if (mConnection!=null) {
              mConnection.close();  
            }
        } catch (SQLException ex) {
        }
    }
    public ResultSet selectSql(String sql) throws SQLException{
        System.out.println(sql);
        Statement statement = mConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        return statement.executeQuery(sql);
    }
    
    public String getIdNhanVien() throws  Exception{
        String sql="select TOP 1 MANV as 'id' FROM NHANVIEN ORDER BY MANV DESC";
        Statement statement = mConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet= statement.executeQuery(sql);
        resultSet.first();
        String id=resultSet.getString("id");
        return id;
    }
    
    public String getIdDonDH() throws  Exception{
        String sql="select TOP 1 "+CommonValue.DATMUA_ID+" as 'id' FROM "+CommonValue.DATMUA_TABLE_NAME+" ORDER BY "+CommonValue.DATMUA_ID+" DESC";
        Statement statement = mConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet= statement.executeQuery(sql);
        resultSet.first();
        String id=resultSet.getString("id");
        return id;
    }
    
     public String getIdKho(String name) throws  Exception{
        String sql="select TOP 1 "+CommonValue.KHO_ID+" as 'id' FROM "+CommonValue.KHO_TABLE_NAME+" WHERE "+CommonValue.KHO_NAME+"=N'"+name+"'";
        Statement statement = mConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet= statement.executeQuery(sql);
        resultSet.first();
        String id=resultSet.getString("id");
        return id;
    }
    
    public String getIdPhieuNhap() throws  Exception{
        String sql="select TOP 1 "+CommonValue.PHIEUNHAP_ID+" as 'id' FROM "+CommonValue.PHIEUNHAP_TABLE_NAME+" ORDER BY "+CommonValue.PHIEUNHAP_ID+" DESC";
        Statement statement = mConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet= statement.executeQuery(sql);
        resultSet.first();
        String id=resultSet.getString("id");
        return id;
    }
    
    public String getIdPhieuDieuChuyen() throws  Exception{
        String sql="select TOP 1 "+CommonValue.PHIEUDIEUCHUYEN_ID+" as 'id' FROM "+CommonValue.PHIEUDIEUCHUYEN_TABLE_NAME+" ORDER BY "+CommonValue.PHIEUDIEUCHUYEN_ID+" DESC";
        Statement statement = mConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet= statement.executeQuery(sql);
        resultSet.first();
        String id=resultSet.getString("id");
        return id;
    }
    
    public String getIdPhieuXuat() throws  Exception{
        String sql="select TOP 1 "+CommonValue.PHIEUXUAT_ID+" as 'id' FROM "+CommonValue.PHIEUXUAT_TABLE_NAME+" ORDER BY "+CommonValue.PHIEUXUAT_ID+" DESC";
        Statement statement = mConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet= statement.executeQuery(sql);
        resultSet.first();
        String id=resultSet.getString("id");
        return id;
    }
    
    public String getIdHoaDon() throws  Exception{
        String sql="select TOP 1 "+CommonValue.HOADON_ID+" as 'id' FROM "+CommonValue.HOADON_TABLE_NAME+" ORDER BY "+CommonValue.HOADON_ID+" DESC";
        Statement statement = mConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet= statement.executeQuery(sql);
        resultSet.first();
        String id=resultSet.getString("id");
        System.out.println(id);
        return id;
    }
    
    public String getSoluongTonKho(String idKho,String idMh) throws  Exception{
        String sql="select TOP 1 "+CommonValue.HANGTON_SOLUONG+" as 'SL' FROM "+CommonValue.HANGTON_TABLE_NAME+" WHERE "+CommonValue.HANG_ID+"='"+idMh+"' AND "+CommonValue.KHO_ID+"='"+idKho+"'";
        Statement statement = mConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet= statement.executeQuery(sql);
        resultSet.first();
        String id=resultSet.getString("SL");
        return id;
    }
    
    
    
    public String getIdKhachHang() throws  Exception{
        String sql="select TOP 1 MAKH as 'id' FROM KHACHHANG ORDER BY MAKH DESC";
        Statement statement = mConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet= statement.executeQuery(sql);
        resultSet.first();
        String id=resultSet.getString("id");
        return id;
    }
    

    public void updateSql(String sql) throws  Exception{
        System.out.println(sql);
        Statement statement=mConnection.createStatement();
        statement.executeUpdate(sql);
    }
}
