package modul07.latihan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ManajemenNilaiSiswaApp  extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;


    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4,2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {"Matematika","Bahasa Indonesia", "Algoritma dan Pemrograman", "Praktikum Pemrograman II"};
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(new JLabel(""));
        panel.add(btnSimpan);

        btnSimpan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
                
            }
        });

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }


    private void prosesSimpan() {
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // Validasi input
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0-100!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka", "Error validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simpan data ke tabel
        String grade;
        if (nilai >= 80) grade = "A";
        else if (nilai >= 70) grade = "AB";
        else if (nilai >= 60) grade = "B";
        else if (nilai >= 50) grade = "BC";
        else if (nilai >= 40) grade = "C";
        else if (nilai >= 30) grade = "D";
        else grade = "E";

        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        tabbedPane.setSelectedIndex(1);
    }

    public ManajemenNilaiSiswaApp() {
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(00, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        // Tab Input Data
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        JPanel panelTabel =  createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        add(tabbedPane);

        // Tab Lihat Data
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ManajemenNilaiSiswaApp app = new ManajemenNilaiSiswaApp();
            app.setVisible(true);
        });
    }
}

