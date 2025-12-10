package modul09;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.Buffer;

public class AplikasiFileIO extends JFrame{
    // komponen UI
    private JTextArea textArea;
    private JButton btnOpenText;
    private JButton btnSaveBinary;
    private JButton btnSaveText;
    private JButton btnLoadBinary;
    private JFileChooser fileChooser;
    private JButton btnAppendText;
    

    public AplikasiFileIO() {
        super ("Tutorial File IO & Exception Handling");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // Inisialisasi komponen
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();

        // panel tombol
        JPanel buttonPanel = new JPanel();
        btnOpenText = new JButton("buka text"); 
        btnSaveText = new JButton("simpan text");
        btnSaveBinary = new JButton("simpan binary");
        btnLoadBinary = new JButton("buka binary");
        // ltihan 4
        btnAppendText = new JButton("tambah text");

        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);
        // latihan4
        buttonPanel.add(btnAppendText);

        // layout
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);



        // event handling
        // 1. membaca file teks
        btnOpenText.addActionListener(e -> bukaFileTeks());
        // 2. menulis file teks
        btnSaveText.addActionListener(e -> simpanFileTeks());
        // 3. menulis file binary
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        // 4. membaca file binary
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
        // 5. menambahkan
        // latihan4
        btnAppendText.addActionListener(e -> { tambahFileTeks(); });


        // latihan2
        // Load last_notes.txt otomatis saat aplikasi dibuka
        muatLastNotes();
    }

    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(file));
                textArea.setText("");

                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }

                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "file tidak ditemukan" + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "gagal membaca  file" + ex.getMessage());
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void simpanFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "gagal menyimpan file" + ex.getMessage());
            } 
        }
    }

    private void simpanConfigBinary() {

            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("config.bin"))) {
                int fontSize = textArea.getFont().getSize();
                dos.writeInt(fontSize);
                JOptionPane.showMessageDialog(this, "ukuran font (" + fontSize + ") berhasil disimpan dalam file binary!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "gagal menyimpan file binary" + ex.getMessage());
            }   
    }

    private void muatConfigBinary() {

            try (DataInputStream dis = new DataInputStream(new FileInputStream("config.bin"))) {
                int fontSize = dis.readInt();
                textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
                JOptionPane.showMessageDialog(this, "font diubah menjadi ukuran " + fontSize );
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "gagal memuat file binary" + ex.getMessage());
            }   
    }

    // latihan2
    private void muatLastNotes() {
        File file = new File("last_notes.txt");
        
        // Jika file ada, baca dan tampilkan di TextArea
        if (file.exists()) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                StringBuilder content = new StringBuilder();
                String line;
                
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                
                textArea.setText(content.toString());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca last_notes.txt: " + ex.getMessage());
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        // Jika file tidak ada, TextArea tetap kosong (tidak ada pesan error)
    }

    private void tambahFileTeks() {
    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        
        // FileWriter(file, true) = append mode
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(textArea.getText());
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Text berhasil ditambahkan ke file!");
            
            // Baca file lagi dan tampilkan di TextArea agar perubahan terlihat
            muatFileKeTextArea(file);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "gagal menambahkan text ke file: " + ex.getMessage());
        }
    }
}

private void muatFileKeTextArea(File file) {
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader(file));
        textArea.setText("");
        String line;
        while ((line = reader.readLine()) != null) {
            textArea.append(line + "\n");
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "gagal memuat file: " + ex.getMessage());
    } finally {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           new AplikasiFileIO().setVisible(true);
        });
    }

}