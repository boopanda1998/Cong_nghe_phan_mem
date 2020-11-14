/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.ThongKeBUS;
import BUS.ThongKeBUSImpl;
import Bean.KhachHangBean;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
//import javafx.concurrent.Task;/
import javax.swing.JPanel;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.data.gantt.TaskSeries;
//import org.jfree.data.gantt.TaskSeriesCollection;
//import org.jfree.data.time.SimpleTimePeriod;

/**
 *
 * @author User
 */
public class QuanLyThongKeController {
     private ThongKeBUS thongKe = null;
 
    public QuanLyThongKeController() {
        this.thongKe = new ThongKeBUSImpl();
    }
 
//    public void setDataToChart1(JPanel jpnItem) {
//        List<KhachHangBean> listItem = thongKe.getListByKhachHang();
// 
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        if (listItem != null) {
//            for (KhachHangBean item : listItem) {
//                dataset.addValue(item.getSo_luong_nhan_vien(), "Nhân viên", item.getGioitinh());
//            }
//        }
// 
//        JFreeChart barChart = ChartFactory.createBarChart(
//                "Biểu đồ thống kê giới tính khách hàng ".toUpperCase(),
//                "Giới tính", "Số lượng",
//                dataset, PlotOrientation.VERTICAL, false, true, false);
// 
//        ChartPanel chartPanel = new ChartPanel(barChart);
//        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));
// 
//        jpnItem.removeAll();
//        jpnItem.setLayout(new CardLayout());
//        jpnItem.add(chartPanel);
//        jpnItem.validate();
//        jpnItem.repaint();
//    }
//    
//    
  
}
