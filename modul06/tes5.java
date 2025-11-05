package modul06;

import  java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import  java.awt.event.MouseEvent;
import javax.swing.*;

public class tes5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MouseListener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(200, 100));

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse di klik : x=" + e.getX() + ", y=" + e.getY());
            }
        };

    panel.addMouseListener(mouseAdapter);
    frame.add(panel);
    frame.setVisible(true);
    }
}
