
package resource;
public class CommonValue {
    
    public String Login(String userName,String password){
        return  "select * from ACCOUNT where USERNAME=N'"+userName+"' AND PASS=N'"+password+"'";
    }
    
    public String KhachHangLogin(String userName,String password){
        return  "select * from ACCOUNT_GUESS where USERNAME=N'"+userName+"' AND PASS=N'"+password+"'";
    }
     //==================================================
    public static final String KHO_TABLE_NAME="KHO";
    public static final String KHO_ID="MAKHO";
    public static final String KHO_NAME="TENKHO";
    public static final String KHO_ADDRESS="DIACHI";
    public static final String KHO_PHONENUMBER="SDT";
    
    public static final String PHIEUNHAP_TABLE_NAME="PHIEUNHAP";
    public static final String PHIEUNHAP_NGAY="NGAY";
    public static final String PHIEUNHAP_ID="SOPHIEU";
    
    public static final String CHITIET_PHIEUNHAP_TABLE_NAME="CHITIETPHIEUNHAP";
    public static final String CHITIET_PHIEUNHAP_SOLUONG="SOLUONG";
    
    public String SelectKho(String key){
        return "select "
                + KHO_ID +" AS 'Mã Kho',"
                + KHO_NAME+" AS N'Tên Kho', "
                + KHO_ADDRESS+" AS N'Địa Chỉ', "
                + KHO_PHONENUMBER+" AS N'Số Điện Thoại' "
                + "from "+KHO_TABLE_NAME+" where "+KHO_ID+" LIKE N'%"+key+"%' OR "+KHO_NAME+" LIKE N'%"+key+"%'";
    }
    
    public String InsertKho(String name,String address,String phone){
        String sql="insert into "+KHO_TABLE_NAME+"("+KHO_NAME+","+KHO_ADDRESS+","+KHO_PHONENUMBER+") VALUES(N'"+name+"',N'"+address+"',N'"+phone+"')";
        return  sql;
    }
    
    public String UpdatetKho(String id,String name,String address,String phone){
        String sql="update "+KHO_TABLE_NAME+" set "+KHO_NAME+"=N'"+name+"'," +KHO_ADDRESS+"=N'"+address+"',"
                +KHO_PHONENUMBER+"=N'"+phone+"' WHERE "+KHO_ID+" ='"+id+"'";
        return  sql;
    }
    
    public String DeleteKho(String id){
        String sql="DELETE "+KHO_TABLE_NAME+" WHERE "+KHO_ID+"='"+id+"'";
        return  sql;
    }
   
    public String InsertPhieuNhap(String idNv,String idKho,String date){
       String sql="insert into "+PHIEUNHAP_TABLE_NAME+"("+NHANVIEN_ID+","+KHO_ID+","+PHIEUNHAP_NGAY+") VALUES('"+idNv+"','"+idKho+"','"+date+"')";
       return sql;
   }
    
    public String InsertChiTietPhieuNhap(String idPhieuNhap,String idMh,String soLuong){
       String sql="insert into "+CHITIET_PHIEUNHAP_TABLE_NAME+"("+PHIEUNHAP_ID+","+HANG_ID+","+CHITIET_PHIEUNHAP_SOLUONG+") VALUES('"+idPhieuNhap+"','"+idMh+"','"+soLuong+"')";
       return sql;
   }
    
    public String InsertHangTonKho(String idMH,String idKHO,String soLuong){
       String sql="insert into "+HANGTON_TABLE_NAME+"("+HANG_ID+","+HANGTON_SOLUONG+","+KHO_ID+") VALUES('"+idMH+"','"+soLuong+"','"+idKHO+"')";
       return sql;
   }
    
    public String UpdateHangTonKho(String idMH,String idKHO,String soLuong){
       String sql="UPDATE "+HANGTON_TABLE_NAME+" set "+HANGTON_SOLUONG+"="+soLuong
               +" WHERE "+HANG_ID+"='"+idMH+"' AND "+KHO_ID+"='"+idKHO+"'";
       return sql;
   }
    
    public String DeleteHangTonKho(String idMH,String idKHO){
       String sql="DELETE "+HANGTON_TABLE_NAME+" WHERE "+KHO_ID+"='"+idKHO+"' AND "+HANG_ID+"='"+idMH+"'";
       return sql;
   }
    
    public static final String PHIEUDIEUCHUYEN_TABLE_NAME="PHIEUDIEUCHUYEN";
    public static final String PHIEUDIEUCHUYEN_NGAY="NGAY";
    public static final String PHIEUDIEUCHUYEN_ID="SOPHIEU";
    public static final String PHIEUDIEUCHUYEN_KHOCHUYEN="MAKHOCHUYEN";
    public static final String PHIEUDIEUCHUYEN_KHONHAN="MAKHODEN";
    
    public static final String CHITIET_PHIEUDIEUCHUYEN_TABLE_NAME="CHITIETDIEUCHUYEN";
    public static final String CHITIET_PHIEUDIEUCHUYEN_SOLUONG="SOLUONG";
    public String InsertPhieuDieuChuyen(String maKhoChuyen,String maKhoNhan,String maNv,String ngay){
        String sql="insert into "+PHIEUDIEUCHUYEN_TABLE_NAME+"("+PHIEUDIEUCHUYEN_KHOCHUYEN+","+PHIEUDIEUCHUYEN_KHONHAN+","+NHANVIEN_ID+","+PHIEUDIEUCHUYEN_NGAY+") "
                + "VALUES('"+maKhoChuyen+"','"+maKhoNhan+"','"+maNv+"','"+ngay+"')";
       return sql;
    }
    
public String InsertChiTietPhieuDieuChuyen(String idDieuChuyen,String idMatHang,String soLuong){
        String sql="insert into "+CHITIET_PHIEUDIEUCHUYEN_TABLE_NAME+"("+PHIEUDIEUCHUYEN_ID+","+HANG_ID+","+CHITIET_PHIEUDIEUCHUYEN_SOLUONG+") "
                + "VALUES('"+idDieuChuyen+"','"+idMatHang+"','"+soLuong+"')";
       return sql;
    }

public String SelectDatHang(String idKH){
        String  sql="SELECT "
                + DATMUA_ID +" AS N'Mã Đơn', "
                + DATMUA_NGAY+" AS N'Ngày Đặt', "
                + DATMUA_TINHTRANG+" AS N'Tình Trạng' "
                + "FROM "+DATMUA_TABLE_NAME+" WHERE "+KHACHHANG_ID+" ='"+idKH+"'";
                return sql;
}

     //==================================================
    public static final String NHACC_TABLE_NAME="NHACC";
    public static final String NHACC_ID="MANCC";
    public static final String NHACC_NAME="TENNCC";
    public static final String NHACC_ADDRESS="DIACHI";
    public static final String NHACC_PHONENUMBER="SDT";
    public static final String NHACC_EMAIL="EMAIL";
    
    public String SelectNhaCC(String key){
        String  sql="SELECT "
                + NHACC_ID +" AS N'Mã Nhà Cung Cấp', "
                + NHACC_NAME+" AS N'Tên Nhà Cung Cấp', "
                + NHACC_ADDRESS+" AS N'Địa Chỉ', "
                + NHACC_PHONENUMBER+" AS N'Số Điện Thoại', "
                + NHACC_EMAIL+" AS N'Địa Chỉ Email' "
                + "FROM "+NHACC_TABLE_NAME+" WHERE "+NHACC_NAME+" LIKE N'%"+key+"%' OR "+NHACC_ID+" LIKE"
                + " N'%"+key+"%'";
                return sql;
    }
    
    public String InsertNhaCC(String name,String address,String phone,String email){
        String sql="insert into "+NHACC_TABLE_NAME+"("+NHACC_NAME+","+NHACC_ADDRESS+","+NHACC_PHONENUMBER+","+NHACC_EMAIL+") VALUES(N'"+name+"',N'"+address+"',N'"+phone+"',N'"+email+"')";
        return  sql;
    }
    
    public String UpdatetNhaCC(String id,String name,String address,String phone,String email){
        String sql="update "+NHACC_TABLE_NAME+" set "+NHACC_NAME+"=N'"+name+"'," +NHACC_ADDRESS+"=N'"+address+"',"
                +NHACC_PHONENUMBER+"=N'"+phone+"',"
                + NHACC_EMAIL+"=N'"+email+"'"
                + " WHERE "+NHACC_ID+" ='"+id+"'";
        return  sql;
    }
    
    public String DeleteNhaCC(String id){
        String sql="DELETE "+NHACC_TABLE_NAME+" WHERE "+NHACC_ID+"='"+id+"'";
        return  sql;
    }
    //================================================
    public static final String NHANVIEN_TABLE_NAME="NHANVIEN";
    public static final String NHANVIEN_ID="MANV";
    public static final String NHANVIEN_NAME="HTEN";
    public static final String NHANVIEN_ADDRESS="DIACHI";
    public static final String NHANVIEN_PHONENUMBER="SDT";
    public static final String NHANVIEN_BIRTHDAY="NGAYSINH";
    
    public static final String ACCOUNT_TABLE_NAME="ACCOUNT";
    public static final String ACCOUNT_USERNAME="USERNAME";
    public static final String ACCOUNT_PASS="PASS";
    public static final String ACCOUNT_ADMIN="ADMINISTRATOR";
    
      public String SelectNhanVien(String key){
        String  sql="SELECT "
                + "A."+NHANVIEN_ID +" AS N'Mã Nhân Viên', "
                + NHANVIEN_NAME+" AS N'Tên Nhân Viên', "
                + NHANVIEN_ADDRESS+" AS N'Địa Chỉ', "
                + NHANVIEN_PHONENUMBER+" AS N'Số Điện Thoại', "
                + NHANVIEN_BIRTHDAY+" AS N'Ngày Sinh', "
                + ACCOUNT_USERNAME+" AS N'Tên Tài Khoản', "
                + ACCOUNT_PASS+" AS N'Mật Khẩu', "
                + ACCOUNT_ADMIN+" AS N'Quản Trị Hệ Thống' "
                
                + "FROM "+NHANVIEN_TABLE_NAME+" as A inner join "+ACCOUNT_TABLE_NAME+" as B ON "
                +"A."+NHANVIEN_ID+"="+"B."+NHANVIEN_ID
                + " WHERE "+NHANVIEN_NAME+" LIKE N'%"+key+"%' OR "+"A."+NHANVIEN_ID+" LIKE"
                + " N'%"+key+"%' order by A."+NHANVIEN_ID+" ASC";
                return sql;
    }
    
    public String InsertNhanVien(String name,String address,String phone,String birthDay){
        String sql="insert into "+NHANVIEN_TABLE_NAME+"("+NHANVIEN_NAME+","+NHANVIEN_ADDRESS+","+NHANVIEN_PHONENUMBER+","+NHANVIEN_BIRTHDAY
                +") VALUES(N'"+name+"',N'"+address+"',N'"+phone+"',N'"+birthDay+"')";
        return  sql;
    }
    
    public String InsertAccount(String idNv,String userName,String passWord, boolean adMin){
        String sql="insert into "+ACCOUNT_TABLE_NAME+"("+ACCOUNT_USERNAME+","+ACCOUNT_PASS+","+ACCOUNT_ADMIN+","+NHANVIEN_ID
                +") VALUES(N'"+userName+"',N'"+passWord+"',N'"+adMin+"',N'"+idNv+"')";
        return  sql;
    }
    
    public String UpdatetNhanVien(String id,String name,String address,String phone,String birthDay){
        String sql="update "+NHANVIEN_TABLE_NAME+" set "+NHANVIEN_NAME+"=N'"+name+"'," +NHANVIEN_ADDRESS+"=N'"+address+"',"
                +NHANVIEN_PHONENUMBER+"=N'"+phone+"',"
                + NHANVIEN_BIRTHDAY+"=N'"+birthDay+"'"
                + " WHERE "+NHANVIEN_ID+" ='"+id+"'";
        return  sql;
    }
    
    public String UpdatetAccount(String userName,String passWord, boolean adMin){
        String sql="update "+ACCOUNT_TABLE_NAME+" set "+ACCOUNT_PASS+"=N'"+passWord+"',"
                +ACCOUNT_ADMIN+"=N'"+adMin+"'"
                + " WHERE "+ACCOUNT_USERNAME+" ='"+userName+"'";
        return  sql;
    }
    
    public String DeleteNhanVien(String id){
        String sql="DELETE "+NHANVIEN_TABLE_NAME+" WHERE "+NHANVIEN_ID+"='"+id+"'";
        return  sql;
    }
    
    public String DeleteAccount(String userName){
        String sql="DELETE "+ACCOUNT_TABLE_NAME+" WHERE "+ACCOUNT_USERNAME+"='"+userName+"'";
        return  sql;
    }
    //==============================================================
    public static final String HANG_TABLE_NAME="HANG";
    public static final String HANG_ID="MAMH";
    public static final String HANG_NAME="TENMH";
    public static final String HANG_GIANHAP="GIANHAP";
    public static final String HANG_LAIXUAT="LAIXUAT";
    
    public static final String HANGTON_TABLE_NAME="HANGTON";
    public static final String HANGTON_SOLUONG="SOLUONG";
    public String SelectHang(String key){
        String  sql="SELECT "
                + HANG_ID +" AS N'Mã Mặt Hàng', "
                + HANG_NAME+" AS N'Tên Mặt Hàng', "
                + HANG_GIANHAP+" AS N'Giá Nhập', "
                + HANG_LAIXUAT+" AS N'Lãi Xuất', "
                + NHACC_NAME+" AS N'Tên Nhà Cung Cấp' "
                + "FROM "+HANG_TABLE_NAME+"  as A inner join "+NHACC_TABLE_NAME+" AS B ON A."+NHACC_ID+"=B."+NHACC_ID
                + " WHERE "+HANG_NAME+" LIKE N'%"+key+"%' OR "+HANG_ID+" LIKE"
                + " N'%"+key+"%'";
                return sql;
    }
    
    public String SelectHangExist(String key){
        String  sql="SELECT * FROM "+HANG_TABLE_NAME+ " WHERE "+NHACC_ID+"='"+key+"'";
                return sql;
    }
    
    public String SelectHangTon(String key,String kho,String order){
        String  sql="SELECT "
                +"A."+ HANG_ID +" AS N'Mã Mặt Hàng', "
                + HANG_NAME+" AS N'Tên Mặt Hàng', "
                + HANG_GIANHAP+" AS N'Giá Nhập', "
                + HANG_LAIXUAT+" AS N'Lãi Xuất', "
                + NHACC_NAME+" AS N'Tên Nhà Cung Cấp', "
                +HANGTON_SOLUONG+" AS N'Số Lượng'"
                + "FROM "+HANG_TABLE_NAME+"  as A inner join "+NHACC_TABLE_NAME+" AS B ON A."+NHACC_ID+"=B."+NHACC_ID
                +"  INNER JOIN "+HANGTON_TABLE_NAME+" AS C ON A."+HANG_ID+"=C."+HANG_ID
                +"  INNER JOIN "+KHO_TABLE_NAME+" AS D ON C."+KHO_ID+"=D."+KHO_ID
                + " WHERE C."+KHO_ID+" = '"+kho+"' "+order;
                return sql;
    }
    
    public String SelectALLHangTon(String key){
        String  sql="SELECT "
                +"A."+ HANG_ID +" AS N'Mã Mặt Hàng', "
                + HANG_NAME+" AS N'Tên Mặt Hàng', "
                + HANG_GIANHAP+" AS N'Giá Nhập', "
                + HANG_LAIXUAT+" AS N'Lãi Xuất', "
                + NHACC_NAME+" AS N'Tên Nhà Cung Cấp', "
                +HANGTON_SOLUONG+" AS N'Số Lượng'"
                + "FROM "+HANG_TABLE_NAME+"  as A inner join "+NHACC_TABLE_NAME+" AS B ON A."+NHACC_ID+"=B."+NHACC_ID
                +"  INNER JOIN "+HANGTON_TABLE_NAME+" AS C ON A."+HANG_ID+"=C."+HANG_ID
                +"  INNER JOIN "+KHO_TABLE_NAME+" AS D ON C."+KHO_ID+"=D."+KHO_ID
                +" WHERE "+HANG_NAME+" LIKE '%"+key+"%'"
                +"order by A."+HANG_ID+" ASC";
                return sql;
    }
   
    public String SelectHangDat(String key){
        String  sql="SELECT "
                + HANG_ID +" AS N'Mã Mặt Hàng', "
                + HANG_NAME+" AS N'Tên Mặt Hàng', "
                +(HANG_GIANHAP+"+"+(HANG_GIANHAP+"*"+HANG_LAIXUAT))+" AS 'Đơn Giá', "
                + NHACC_NAME+" AS N'Tên Nhà Cung Cấp' "
                
                + "FROM "+HANG_TABLE_NAME+"  as A inner join "+NHACC_TABLE_NAME+" AS B ON A."+NHACC_ID+"=B."+NHACC_ID
                +" WHERE " +HANG_NAME+" LIKE N'%"+key+"%'";
                return sql;
    }
    
    public String InsertHang(String name,String giaNhap,String laiXuat,String maNCC){
        String sql="insert into "+HANG_TABLE_NAME+"("+HANG_NAME+","+HANG_GIANHAP+","+HANG_LAIXUAT+","+NHACC_ID+") VALUES"
                + "(N'"+name+"',N'"+giaNhap+"',N'"+laiXuat+"',N'"+maNCC+"')";
        return  sql;
    }
    
    public String UpdatetHang(String id,String name,String giaNhap,String laiXuat){
        String sql="update "+HANG_TABLE_NAME+" set "+HANG_NAME+"=N'"+name+"'," +HANG_GIANHAP+"=N'"+giaNhap+"',"
                +HANG_LAIXUAT+"=N'"+laiXuat+"'"
                + " WHERE "+HANG_ID+" ='"+id+"'";
        return  sql;
    }
    
    public String DeleteHang(String id){
        String sql="DELETE "+HANG_TABLE_NAME+" WHERE "+HANG_ID+"='"+id+"'";
        return  sql;
    }
    
    
    
    
    
    
    //===============================================
    public static final String KHACHHANG_TABLE_NAME="KHACHHANG";
    public static final String KHACHHANG_ID="MAKH";
    public static final String KHACHHANG_NAME="TENKH";
    public static final String KHACHHANG_ADDRESS="DIACHI";
    public static final String KHACHHANG_PHONENUMBER="SDT";
    public static final String KHACHHANG_EMAIL="EMAIL";
    
    public static final String ACCOUNT_GUESS_TABLE_NAME="ACCOUNT_GUESS";
    public static final String ACCOUNT_GUESS_USERNAME="USERNAME";
    public static final String ACCOUNT_GUESS_PASS="PASS";
    
    public String SelectKhachHang(String value){
        String sql="select * from "+KHACHHANG_TABLE_NAME+" where "+KHACHHANG_ID+"='"+value+"'";
        return sql;
    }
    
    public String InsertKhachHang(String name,String address,String phone,String email){
        String sql="insert into "+KHACHHANG_TABLE_NAME+"("+KHACHHANG_NAME+","+KHACHHANG_ADDRESS+","+KHACHHANG_PHONENUMBER+","+KHACHHANG_EMAIL
                +") VALUES(N'"+name+"',N'"+address+"',N'"+phone+"',N'"+email+"')";
        return  sql;
    }
    
    public String InsertAccountGuess(String idNv,String userName,String passWord){
        String sql="insert into "+ACCOUNT_GUESS_TABLE_NAME+"("+ACCOUNT_GUESS_USERNAME+","+ACCOUNT_GUESS_PASS+","+KHACHHANG_ID
                +") VALUES(N'"+userName+"',N'"+passWord+"',N'"+idNv+"')";
        return  sql;
    }
    
    public String UpdatetKhanchHang(String id,String name,String address,String phone,String email){
        String sql="update "+KHACHHANG_TABLE_NAME+" set "+KHACHHANG_NAME+"=N'"+name+"'," +KHACHHANG_ADDRESS+"=N'"+address+"',"
                +KHACHHANG_PHONENUMBER+"=N'"+phone+"',"
                + KHACHHANG_EMAIL+"=N'"+email+"'"
                + " WHERE "+KHACHHANG_ID+" ='"+id+"'";
        return  sql;
    }
    public String UpdatetAccountGuess(String userName,String passWord){
        String sql="update "+ACCOUNT_GUESS_TABLE_NAME+" set "+ACCOUNT_GUESS_PASS+"=N'"+passWord+"'"
                + " WHERE "+ACCOUNT_GUESS_USERNAME+" ='"+userName+"'";
        return  sql;
    }
    
    //========================================================
   public static final String DATMUA_TABLE_NAME="DATMUA";
   public static final String DATMUA_NGAY="NGAY";
   public static final String CHITIET_DATMUA_SOLUONG="SOLUONG";
   public static final String DATMUA_ID="MADON";
   public static final String DATMUA_TINHTRANG="TINHTRANG";
   public static final String CHITIET_DATMUA_TABLE_NAME="CHITIETDATMUA";
   
   public String SelectDatMua(){
       String sql="SELECT "+DATMUA_ID+" AS 'Mã Số Phiếu Đặt',"+KHACHHANG_NAME+" AS 'Tên Khách Hàng', "+DATMUA_NGAY+" AS 'Ngày Đặt Mua' "
               + " FROM "+DATMUA_TABLE_NAME+" AS A INNER JOIN "+KHACHHANG_TABLE_NAME+" AS B ON A."+KHACHHANG_ID+"= B."+KHACHHANG_ID
               +" WHERE A."+DATMUA_TINHTRANG+"='NULL'";
       return sql;
   }
   
   public String SelectHangDatMua(String idDon){
       String sql="SELECT C."
               +HANG_ID+" AS 'Mã Hàngt',"
               +HANG_NAME+" AS 'Tên Hàng', "
               +(HANG_GIANHAP+"+"+(HANG_GIANHAP+"*"+HANG_LAIXUAT))+" AS 'Đơn Giá', "
               +CHITIET_DATMUA_SOLUONG+" AS 'Số Lượng' "
               + " FROM "+DATMUA_TABLE_NAME+" AS A INNER JOIN "+CHITIET_DATMUA_TABLE_NAME+" AS B ON A."+DATMUA_ID+"= B."+DATMUA_ID
               +" INNER JOIN "+HANG_TABLE_NAME+" AS C ON C."+HANG_ID+"= B."+HANG_ID
               + " WHERE A."+DATMUA_ID+"='"+idDon+"'";
       return sql;
   }
   
     
   
   
   public String InsertDatMua(String idKH,String date){
       String sql="insert into "+DATMUA_TABLE_NAME+"("+KHACHHANG_ID+","+DATMUA_NGAY+","+DATMUA_TINHTRANG+") VALUES('"+idKH+"','"+date+"','NULL')";
       return sql;
   }
   
   public String UpdateDatMua(String idDon,String type){
       String sql="UPDATE "+DATMUA_TABLE_NAME+" SET "+DATMUA_TINHTRANG+"='"+type+"' WHERE "+DATMUA_ID+"='"+idDon+"'";
       return sql;
   }
   
   public String InsertChiTietPhieuDat(String madon,String maMh,String soluong){
       String sql="insert into "+CHITIET_DATMUA_TABLE_NAME+"("+DATMUA_ID+","+HANG_ID+","+CHITIET_DATMUA_SOLUONG+") VALUES('"+madon+"','"+maMh+"','"+soluong+"')";
       return sql;
   }
   //===================================
   public static final String PHIEUXUAT_TABLE_NAME="PHIEUXUAT";
   public static final String PHIEUXUAT_NGAY="NGAY";
   public static final String PHIEUXUAT_DONDAT="MADONDAT";
   public static final String PHIEUXUAT_ID="SOPX";
   public static final String CHITIET_PHIEUXUAT_TABLE_NAME="CHITIETPHIEUXUAT";
   public static final String CHITIET_PHIEUXUAT_SOLUONG="SOLUONG";
   public String insertPhieuXuat(String maNV,String maDonDat,String ngay){
       String sql="INSERT INTO "+PHIEUXUAT_TABLE_NAME+"("+NHANVIEN_ID+","+PHIEUXUAT_DONDAT+","+PHIEUXUAT_NGAY+") VALUES('"+maNV+"','"+maDonDat+"','"+ngay+"')";
       return sql;
   }
   public String insertChiTietPhieuXuat(String maPhieuXuat,String soLuong,String maKho,String maKH){
       String sql="INSERT INTO "+CHITIET_PHIEUXUAT_TABLE_NAME+"("+PHIEUXUAT_ID+","+CHITIET_PHIEUXUAT_SOLUONG+","+KHO_ID+","+HANG_ID+") VALUES('"+maPhieuXuat+"','"+soLuong+"','"+maKho+"','"+maKH+"')";
       return sql;
   }
   //=================================
   public static final String HOADON_TABLE_NAME="HOADON";
   public static final String HOADON_ID="SOHD";
   public static final String HOADON_MADONDAT="MADONDAT";
   public static final String HOADON_NGAY="NGAY";
   
   public static final String CHITIET_HOADON_TABLE_NAME="CHITIETHOADON";
   public static final String CHITIET_HOADON_SOLUONG="SOLUONG";
   public static final String CHITIET_HOADON_DONGIA="DONGIA";
   public static final String CHITIET_HOADON_TONGTIEN="TONGTIEN";
   
   public String insertHoaDon(String maDonDat,String ngay){
       String sql="INSERT INTO "+HOADON_TABLE_NAME+"("+HOADON_MADONDAT+","+HOADON_NGAY+") VALUES('"+maDonDat+"','"+ngay+"')";
       return sql;
   }
   public String insertChiTietHoaDon(String maHD,String maHang,String soLuong,String donGia){
       String sql="INSERT INTO "+CHITIET_HOADON_TABLE_NAME+"("+HOADON_ID+","+HANG_ID+","+CHITIET_HOADON_SOLUONG+","+CHITIET_HOADON_DONGIA+","+CHITIET_HOADON_TONGTIEN
               +") VALUES('"+maHD+"','"+maHang+"','"+soLuong+"','"+donGia+"',"+(soLuong+"*"+donGia)+")";
       return sql;
   }
}
