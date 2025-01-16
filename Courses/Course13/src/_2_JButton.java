import javax.swing.JButton;
import javax.swing.JFrame;

public class _2_JButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JButton Example");
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> System.out.println("Button Clicked"));
        frame.add(button);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
