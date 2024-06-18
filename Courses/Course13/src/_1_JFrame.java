import javax.swing.JFrame;

public class _1_JFrame {
    public static void main(String[] args) throws Exception {
        // Create a new JFrame
        JFrame frame = new JFrame("My Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
