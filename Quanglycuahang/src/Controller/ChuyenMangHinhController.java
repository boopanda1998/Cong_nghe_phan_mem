package Controller;

import Bean.DanhMucBean;
import GUI.ChatLieuGUI;
import GUI.HangHoaGUI;
import GUI.NhapHangGUI;
import GUI.HoaDonGUI;
import GUI.KhachHangGUI;
import GUI.NhaCungCapGUI;
import GUI.NhanVienGUI;
import GUI.NhanVienGUI;
import GUI.NhapHangGUI;
import GUI.ThongKeGUI;
import GUI.TrangChuGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author boopa
 */
public class ChuyenMangHinhController {
    private JPanel root;
    private String kindSelected = "";
    
    public ArrayList<DanhMucBean> listItem =null;
    
    public ChuyenMangHinhController(JPanel jpnRoot){
        this.root = jpnRoot;
    }
public void setDashboard(JPanel jpnItem, JLabel jlbItem) {
       kindSelected = "TrangChu";
       jpnItem.setBackground(new Color(255, 0, 0));
       jlbItem.setBackground(new Color(255, 0, 0));
       
       root.removeAll();
       root.setLayout(new BorderLayout());
       root.add(new TrangChuGUI());
       root.validate();
       root.repaint();
    }
    public void setEvent(ArrayList<DanhMucBean> listItem){
    this.listItem = listItem;
    for(DanhMucBean item : listItem){  
        item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    }
        
class LabelEvent implements MouseListener{
        
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jpbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jpbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "TrangChu":
                    node = new TrangChuGUI();
                    break;
                case "NhanVien":
                    node  = new NhanVienGUI();
                    break;
                case "KhachHang":
                    node = new KhachHangGUI();
                    break;
                case "HoaDon":
                    node = new HoaDonGUI();
                    break;
                case "NhaCungCap":
                    node = new NhaCungCapGUI();
                    break;
                case "NhapHang":
                    node = new NhapHangGUI();
                    break;
                case "ChatLieu":
                    node = new ChatLieuGUI();
                    break;
                case "ThongKe":
                    node = new ThongKeGUI();
                    break;
                               
                default:
                    break;
            }
           root.removeAll();
           root.setLayout(new BorderLayout());
           root.add(node);
           root.validate();
           root.repaint();
           setChangeBackground(kind);
        }

       @Override
      public void mousePressed(MouseEvent e) {
           kindSelected = kind;
           jpnItem.setBackground(new Color(255,255,255));
           jlbItem.setBackground(new Color(255,255,255));
      }

      @Override
      public void mouseReleased(MouseEvent e) {
          jpnItem.setBackground(new Color(255, 0, 0));
          jlbItem.setBackground(new Color(255, 0, 0));
      }

      @Override
      public void mouseEntered(MouseEvent e) {
          jpnItem.setBackground(new Color(255,0,0));
          jlbItem.setBackground(new Color(255,0,0));
      }

      @Override
      public void mouseExited(MouseEvent e) {
          if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(255,96,74));
                jlbItem.setBackground(new Color(255,96,74));
          }
      }
    }
    private void setChangeBackground(String kind){
        for(DanhMucBean item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(255, 0, 0));
                item.getJlb().setBackground(new Color(255, 0, 0));
            }else
                item.getJpn().setBackground(new Color(255,96,74));
                item.getJlb().setBackground(new Color(255,96,74));
    }
}
}
