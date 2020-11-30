
package DAO;

/**
 *
 * @author Min-NvT
 */
 
import DTO.ChamCongDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ChamCongDAO{ 
    public static ArrayList<ChamCongDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM chamcong";
        ArrayList<ChamCongDTO> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChamCongDTO chamCongDTO = new ChamCongDTO();
                chamCongDTO.setMacc(rs.getString("macc"));
                chamCongDTO.setManv(rs.getString("manv"));
                chamCongDTO.setNgaylam(rs.getString("ngaylam"));
                chamCongDTO.setNghicophep(rs.getString("nghicophep"));
                chamCongDTO.setGhichu(rs.getString("ghichu"));             
                list.add(chamCongDTO);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int Delete (String macc){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM `chamcong` WHERE macc=?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, macc);    
            int deleted = ps.executeUpdate();
            System.out.println((deleted!=0)? (deleted + " customers deleted") : "Xóa lỗi! NVDAO"); 
            ps.close();
            cons.close();
            return deleted;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
  public static int  Insert(ChamCongDTO chamCongDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhanvien(macc,manv,ngaylam,nghicophep,ghichu) "
                    + "VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement ps = cons.prepareStatement(sql); 
            System.out.println("kiem tra ma cham cong" +chamCongDTO.getMacc());
            ps.setString(1, chamCongDTO.getMacc());
            ps.setString(2, chamCongDTO.getManv());
            ps.setString(3, chamCongDTO.getNgaylam());
            ps.setString(4, chamCongDTO.getNghicophep());
            ps.setString(5, chamCongDTO.getGhichu());
            int insert = ps.executeUpdate();
            System.out.println((insert!=0)? (insert + " customers insert") : " Thêm  lỗi!DAO"); 
            ps.close();
            cons.close();
            return insert;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
   public static int Update(ChamCongDTO chamCongDTO){
        try {
            Connection cons = DBConnect.getConnection();
           String sql="UPDATE chamcong SET manv=?,ngaylam=?,nghicophep=?,ghichu=? WHERE macc=?";
            PreparedStatement ps = cons.prepareStatement(sql);
          ps.setString(1, chamCongDTO.getMacc());
            ps.setString(2, chamCongDTO.getManv());
            ps.setString(3, chamCongDTO.getNgaylam());
            ps.setString(4, chamCongDTO.getNghicophep());
            ps.setString(5, chamCongDTO.getGhichu());
            int update = ps.executeUpdate();
            System.out.println((update!=0)? (update + " customers updated") : " Sửa lỗi!DAO");
            ps.close();
            cons.close();
            return update;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}