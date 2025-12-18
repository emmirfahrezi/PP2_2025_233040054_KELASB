package modul10.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MahasiswaView extends JFrame {
    
    // Komponen GUI
    private JTextField txtNama, txtNim, txtJurusan, txtCari;
    private JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    private JTable tableMahasiswa;
    private DefaultTableModel model;
    
    public MahasiswaView() {
        setTitle("Aplikasi CRUD Mahasiswa JDBC - MVC");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        initComponents();
        
        setVisible(true);
    }
    
    private void initComponents() {
        // JPanel form input
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);
        panelForm.add(new JLabel("NIM:"));
        txtNim = new JTextField();
        panelForm.add(txtNim);
        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);
        
        // JPanel tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");
        
        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);
        
        // Panel pencarian
        panelTombol.add(new JLabel("   Cari:"));
        txtCari = new JTextField(15);
        panelTombol.add(txtCari);
        btnCari = new JButton("Cari");
        panelTombol.add(btnCari);
        
        // Gabungkan panel form dan tombol di bagian atas (NORTH)
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);
        
        // Tabel data mahasiswa
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Jurusan");
        
        tableMahasiswa = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    // Getter untuk komponen GUI
    public JTextField getTxtNama() {
        return txtNama;
    }
    
    public JTextField getTxtNim() {
        return txtNim;
    }
    
    public JTextField getTxtJurusan() {
        return txtJurusan;
    }
    
    public JTextField getTxtCari() {
        return txtCari;
    }
    
    public JButton getBtnSimpan() {
        return btnSimpan;
    }
    
    public JButton getBtnEdit() {
        return btnEdit;
    }
    
    public JButton getBtnHapus() {
        return btnHapus;
    }
    
    public JButton getBtnClear() {
        return btnClear;
    }
    
    public JButton getBtnCari() {
        return btnCari;
    }
    
    public JTable getTableMahasiswa() {
        return tableMahasiswa;
    }
    
    public DefaultTableModel getModel() {
        return model;
    }
    
    // Method untuk menampilkan pesan
    public void tampilkanPesan(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }
    
    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Method untuk clear form
    public void clearForm() {
        txtNama.setText("");
        txtNim.setText("");
        txtJurusan.setText("");
    }
    
    // Method untuk set data dari tabel ke form
    public void setDataFromTable(int row) {
        txtNama.setText(model.getValueAt(row, 1).toString());
        txtNim.setText(model.getValueAt(row, 2).toString());
        txtJurusan.setText(model.getValueAt(row, 3).toString());
    }
    
    // Method untuk menambahkan listener klik pada tabel
    public void addTableMouseListener(MouseAdapter adapter) {
        tableMahasiswa.addMouseListener(adapter);
    }
}
