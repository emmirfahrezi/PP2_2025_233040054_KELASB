package modul06;

import javax.swing.*;
import java.awt.*;

public class latihan2 {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Konverter Celcius ke Fahrenheit");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new GridLayout(3,2, 10, 10));

			JLabel labelC = new JLabel("Celcius:");
			JTextField inputC = new JTextField(7);
			JButton btnConvert = new JButton("Konversi");
			JLabel labelF = new JLabel("Fahrenheit:");
			JLabel resultF = new JLabel("");

			frame.add(labelC);
			frame.add(inputC);
			frame.add(btnConvert);
			frame.add(labelF);
			frame.add(resultF);

			btnConvert.addActionListener(e -> {
				String text = inputC.getText().trim();
				if (text.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Masukkan nilai Celcius terlebih dahulu.", "Input kosong", JOptionPane.WARNING_MESSAGE);
					resultF.setText("");
					return;
				}

				try {
					double c = Double.parseDouble(text);
					double f = (c * 9.0 / 5.0) + 32.0;
					resultF.setText(String.format("%.2f", f));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Input bukan angka. Masukkan nilai numerik untuk Celcius.", "Format salah", JOptionPane.ERROR_MESSAGE);
					resultF.setText("");
				}
			});

			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
