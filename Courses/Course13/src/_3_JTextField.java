import javax.swing.*;

/**
 * _3_JTextField
 */
public class _3_JTextField {

    public static void main(String[] args) {
        JFrame frame = new JFrame("My App");
        JTextField textField = new JTextField("Type Here...");

        frame.add(textField);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}