package modul06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class tes4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ActionListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Tekan tombol di bawah ini");
        JButton button = new JButton("Tekan Aku!");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol telah ditekan!");
            }
        };

        button.addActionListener(listener);

        frame.add(label);
        frame.add(button);
        
        frame.setVisible(true);
    }
}
