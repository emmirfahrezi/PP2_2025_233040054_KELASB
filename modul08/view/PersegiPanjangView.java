package modul08.view;

import javax.swing.*;
import java.awt.*;


public class PersegiPanjangView extends JFrame{
    private JTextField txtPanjang = new JTextField();
    private JTextField txtLebar = new JTextField();
    private  JLabel lblhasilluas = new JLabel("");
    private  JLabel lblhasilkeliling = new JLabel("");
    private JButton btnHitungLuas = new JButton("Hitung Luas");
    private JButton btnHitungKeliling = new JButton("Hitung Keliling");
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLayout(new GridLayout(6,2, 10, 10));
        this.setTitle("MVC Kalkulator");
        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblhasilluas);
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblhasilkeliling);
        this.add(btnHitungLuas);
        this.add(btnHitungKeliling);
        this.add(btnReset);
        this.add(new JLabel(""));
        this.setVisible(true);
    }

    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    public void setHasilLuas( double hasil) {
        lblhasilluas.setText(String.format("%.2f", hasil));
        lblhasilkeliling.setText("");
    }

    public void setHasilKeliling( double hasil) {
        lblhasilkeliling.setText(String.format("%.2f", hasil));
        lblhasilluas.setText("");
    }

    public void tampillkanPesanEror(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void KelilingListener(java.awt.event.ActionListener listener) {
        btnHitungKeliling.addActionListener(listener);
    }    

    public void LuasListener(java.awt.event.ActionListener listener) {
        btnHitungLuas.addActionListener(listener);
    }

    public void ResetListener(java.awt.event.ActionListener listener) {
        btnReset.addActionListener(listener);
    }

    public void resetFields() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblhasilluas.setText("");
        lblhasilkeliling.setText("");
        txtPanjang.requestFocusInWindow();
    }
}
