/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author huynh
 */
import DTO.NhaCungCapDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.DropMode.INSERT;
 
public class NhaCungCapDAO{


 
    
    public static ArrayList<NhaCungCapDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM nhacungcap";
        ArrayList<NhaCungCapDTO> list = new ArrayList<NhaCungCapDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCapDTO nhacungcapDTO = new NhaCungCapDTO();
                nhacungcapDTO.setMancc(rs.getString("mancc"));
                nhacungcapDTO.setTenncc(rs.getString("tenncc"));
                nhacungcapDTO.setDiachi(rs.getString("diachi"));
                nhacungcapDTO.setSodt(rs.getString("sodt"));
               
                list.add(nhacungcapDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    

  public static int  Insert(NhaCungCapDTO nhacungcapDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhacungcap(mancc, tenncc, diachi, sodt) "
                    + "VALUES ( ?, ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra ma giam gia da nhan du lieu tu GUI --" +nhacungcapDTO.getMancc());
            ps.setString(1, nhacungcapDTO.getMancc());
            ps.setString(2, nhacungcapDTO.getTenncc());
            ps.setString(3, nhacungcapDTO.getDiachi());
            ps.setString(4, nhacungcapDTO.getSodt());
           
            //
            
            int insert = ps.executeUpdate();
            System.out.println((insert!=0)? (insert + " customers insert") : " insert Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return insert;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
  public static int Delete (String mancc){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM `nhacungcap` WHERE mancc=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, mancc);
            
            int deleted = ps.executeUpdate();
            System.out.println((deleted!=0)? (deleted + " customers deleted") : " deleted Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return deleted;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

  public static int Update(NhaCungCapDTO nhacungcapDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE nhacungcap SET tenncc=?,diachi=?,sodt=? WHERE mancc=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            
            ps.setString(4, nhacungcapDTO.getMancc());
            ps.setString(1, nhacungcapDTO.getTenncc());
            ps.setString(2, nhacungcapDTO.getDiachi());
            ps.setString(3, nhacungcapDTO.getSodt());
           
            int update = ps.executeUpdate();
            System.out.println((update!=0)? (update + " customers updated") : " updatedSomething wrong! Check the input values");
            
            ps.close();
            cons.close();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
  }}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

      
      
 
  
      
  
  
