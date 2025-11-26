package modul06;

import java.awt.BorderLayout;
import javax.swing.*;

public class tes2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout(10, 10));

        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
