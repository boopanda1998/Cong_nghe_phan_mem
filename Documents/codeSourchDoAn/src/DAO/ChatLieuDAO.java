/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChatLieuDTO;

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
/**
 *
 * @author PC
 */
public class ChatLieuDAO {
    
    public static ArrayList<ChatLieuDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM chatlieu";
        ArrayList<ChatLieuDTO> list = new ArrayList<ChatLieuDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieuDTO chatlieuDTO = new ChatLieuDTO();
                chatlieuDTO.setMacl(rs.getString("macl"));
                chatlieuDTO.setMaloai(rs.getString("maloai"));
                chatlieuDTO.setMahang(rs.getString("mahang"));
                chatlieuDTO.setTenhang(rs.getString("tenhang"));    
                list.add(chatlieuDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    

  public static int  Insert(ChatLieuDTO chatlieuDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO chatlieu(macl, maloai, mahang, tenhang) "
                    + "VALUES ( ?, ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra ma chat lieu da nhan du lieu tu GUI --" +chatlieuDTO.getMacl());
            ps.setString(1, chatlieuDTO.getMacl());
            ps.setString(2, chatlieuDTO.getMaloai());
            ps.setString(3, chatlieuDTO.getMahang());
            ps.setString(4, chatlieuDTO.getTenhang());
           
            
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
  public static int Delete (String macl){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM `chatlieu` WHERE macl=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, macl);
            
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

  public static int Update(ChatLieuDTO chatlieuDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE chatlieu SET maloai=?,mahang=?,tenhang=? WHERE macl=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            
            ps.setString(4, chatlieuDTO.getMacl());
            ps.setString(1, chatlieuDTO.getMaloai());
            ps.setString(2, chatlieuDTO.getMahang());
            ps.setString(3, chatlieuDTO.getTenhang());
            
            
            
            int update = ps.executeUpdate();
            System.out.println((update!=0)? (update + " customers updated") : " updatedSomething wrong! Check the input values");
            
            ps.close();
            cons.close();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
