package modul06;

import java.awt.*;
import javax.swing.*;

public class latihan1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("UI kalkulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JTextField display = new JTextField();
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton b = new JButton(text);
            b.setFont(b.getFont().deriveFont(18f));
            buttonPanel.add(b);
        }
        
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }
}
