package modul06;

import java.awt.*;
import javax.swing.*;

public class tes2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout(10, 10));
        //membuat button untuk calculator

        frame.add(new JButton("7"), BorderLayout.WEST);
        
        

        

        frame.setVisible(true);
    }
}
