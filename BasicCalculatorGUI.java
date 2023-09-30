package dow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculatorGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton equalsButton;
    private JButton clearButton;

    private String currentInput = "";
    private double result = 0;
    private char operator = ' ';
    private boolean isNewInput = true;

    public BasicCalculatorGUI() {
        frame = new JFrame("Basic Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new NumberButtonListener());
            panel.add(numberButtons[i]);
        }

        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (int i = 0; i < 4; i++) {
            operatorButtons[i].addActionListener(new OperatorButtonListener());
            panel.add(operatorButtons[i]);
        }

        equalsButton = new JButton("=");
        equalsButton.addActionListener(new EqualsButtonListener());
        clearButton = new JButton("C");
        clearButton.addActionListener(new ClearButtonListener());

        panel.add(clearButton);
        panel.add(equalsButton);

        frame.add(display, BorderLayout.NORTH);
        frame.add(panel);

        frame.setVisible(true);
    }

    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isNewInput) {
                currentInput = "";
                isNewInput = false;
            }

            JButton buttonClicked = (JButton) e.getSource();
            currentInput += buttonClicked.getText();
            display.setText(currentInput);
        }
    }

    private class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isNewInput) {
                calculate();
                isNewInput = true;
            }

            JButton buttonClicked = (JButton) e.getSource();
            operator = buttonClicked.getText().charAt(0);
        }
    }

    private class EqualsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculate();
            isNewInput = true;
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentInput = "";
            result = 0;
            operator = ' ';
            isNewInput = true;
            display.setText("");
        }
    }

    private void calculate() {
        double inputNumber = Double.parseDouble(currentInput);
        switch (operator) {
            case '+':
                result += inputNumber;
                break;
            case '-':
                result -= inputNumber;
                break;
            case '*':
                result *= inputNumber;
                break;
            case '/':
                if (inputNumber != 0) {
                    result /= inputNumber;
                } else {
                    display.setText("Error: Division by zero");
                    result = 0;
                    isNewInput = true;
                    return;
                }
                break;
            default:
                result = inputNumber;
                break;
        }
        display.setText(String.valueOf(result));
        currentInput = "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BasicCalculatorGUI());
    }
}

