package modul06;

import javax.swing.*;
import java.awt.FlowLayout;     

public class tes1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        panel.add(new JButton("Tombol 1"));
        panel.add(new JButton("Tombol 2"));
        panel.add(new JButton("Tombol tiga"));
        panel.add(new JButton("Tombol Empat panjang"));
        panel.add(new JButton("Tombol 5"));

        frame.add(panel);
        frame.setVisible(true);
    }
}
