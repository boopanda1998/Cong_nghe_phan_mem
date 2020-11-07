package GUI;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class mainClass {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        KhachHangGUI khGUI = new KhachHangGUI();

        frame.setSize(1045, 750);
        frame.add(khGUI);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
