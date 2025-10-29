package modul05;

import java.awt.BorderLayout;
import javax.swing.*;

public class Latihan4tambahan {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout tambahan");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setLayout(new BorderLayout());
                JLabel label = new JLabel("Label ada di Atas (NORTH)", JLabel.CENTER);
                JButton buttonSouth = new JButton("Tombol ada di bawah (SOUTH)");
                JButton buttonCenter = new JButton("(CENTER)");
                JButton buttonWest = new JButton("(WEST)");
                JButton buttonEast = new JButton("EAST)");

                buttonSouth.addActionListener(e -> label.setText("Tombol SOUTH diklik!"));
                buttonCenter.addActionListener(e -> label.setText("Tombol CENTER diklik!"));
                buttonWest.addActionListener(e -> label.setText("Tombol WEST diklik!"));
                buttonEast.addActionListener(e -> label.setText("Tombol EAST diklik!"));

                frame.add(label, BorderLayout.NORTH);
                frame.add(buttonSouth , BorderLayout.SOUTH);
                frame.add(buttonWest, BorderLayout.WEST);
                frame.add(buttonEast, BorderLayout.EAST);
                frame.add(buttonCenter, BorderLayout.CENTER);
                frame.setVisible(true);
            }
        });
    }
    
}
