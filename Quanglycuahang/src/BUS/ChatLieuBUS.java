/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChatLieuDAO;
import DTO.ChatLieuDTO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PC
 */
public class ChatLieuBUS {
    
    private ChatLieuDAO chatlieuDAO = null;

    public ChatLieuBUS() {
        this.chatlieuDAO = new ChatLieuDAO();
    }
    
    public static ArrayList<ChatLieuDTO> getList(){
        return ChatLieuDAO.getList();
    }
    public int Insert(ChatLieuDTO chatlieuDTO){
        return ChatLieuDAO.Insert(chatlieuDTO);
    }
    public int Delete(String macl){
        return ChatLieuDAO.Delete(macl);
    }
    
    public int Update(ChatLieuDTO chatlieuDTO){
        return ChatLieuDAO.Update(chatlieuDTO);
    }
}
