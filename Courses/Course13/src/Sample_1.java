import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Sample_1 extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JLabel resultLabel;
    private JButton additionButton;
    private JButton subtractionButton;
    private JButton divideButton;
    private JButton multiplyButton;

    Sample_1(){
        setTitle("Calculator");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 250);

        textField1 = new JTextField(5);
        textField2 = new JTextField(5);
        resultLabel = new JLabel("Result is: ");
        additionButton = new JButton("Addition");
        subtractionButton = new JButton("Substraction");
        divideButton = new JButton("Divide");
        multiplyButton = new JButton("Multiply");
        
        
        add(textField1);
        add(textField2);
        add(additionButton);
        add(subtractionButton);
        add(divideButton);
        add(multiplyButton);
        add(resultLabel);
        
        additionButton.addActionListener(e -> performOperation('+'));
        subtractionButton.addActionListener(e -> performOperation('-'));
        divideButton.addActionListener(e -> performOperation('/'));
        multiplyButton.addActionListener(e -> performOperation('*'));

        setVisible(true);
    }

    private void performOperation(char operation){
        int num1 = Integer.parseInt(textField1.getText());
        int num2 = Integer.parseInt(textField2.getText());
        int result = 0;

        switch(operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }

        resultLabel.setText("Result is: " + result);
    }

    public static void main(String[] args) {
        new Sample_1();
    }
}
