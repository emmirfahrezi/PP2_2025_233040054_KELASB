package modul10.controller;

import javax.swing.table.DefaultTableModel;

import modul10.model.MahasiswaModel;
import modul10.view.MahasiswaView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MahasiswaController {
    
    private MahasiswaView view;
    private MahasiswaModel model;
    
    public MahasiswaController(MahasiswaView view, MahasiswaModel model) {
        this.view = view;
        this.model = model;
        
        // Setup event listeners
        this.view.getBtnSimpan().addActionListener(e -> tambahData());
        this.view.getBtnEdit().addActionListener(e -> editData());
        this.view.getBtnHapus().addActionListener(e -> hapusData());
        this.view.getBtnClear().addActionListener(e -> view.clearForm());
        this.view.getBtnCari().addActionListener(e -> cariData());
        
        // Setup listener untuk klik tabel
        this.view.addTableMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = view.getTableMahasiswa().getSelectedRow();
                if (selectedRow >= 0) {
                    view.setDataFromTable(selectedRow);
                }
            }
        });
        
        // Load data awal
        muatData();
    }
    
    // Method untuk memuat semua data
    private void muatData() {
        DefaultTableModel tableModel = view.getModel();
        tableModel.setRowCount(0); // reset tabel
        
        try {
            List<String[]> dataList = model.getAllMahasiswa();
            int no = 1;
            for (String[] data : dataList) {
                tableModel.addRow(new Object[]{
                    no++,
                    data[0], // nama
                    data[1], // nim
                    data[2]  // jurusan
                });
            }
        } catch (Exception e) {
            view.tampilkanPesanError("Gagal memuat data: " + e.getMessage());
        }
    }
    
    // Method untuk menambah data
    private void tambahData() {
        String nama = view.getTxtNama().getText().trim();
        String nim = view.getTxtNim().getText().trim();
        String jurusan = view.getTxtJurusan().getText().trim();
        
        // Validasi input kosong
        if (nama.isEmpty() || nim.isEmpty()) {
            view.tampilkanPesanError("Data tidak boleh kosong!");
            return;
        }
        
        try {
            // Cek apakah NIM sudah ada
            if (model.cekNimExists(nim)) {
                view.tampilkanPesanError("NIM sudah terdaftar! Gunakan NIM yang berbeda.");
                return;
            }
            
            // Tambah data
            model.tambahMahasiswa(nama, nim, jurusan);
            view.tampilkanPesan("Data berhasil disimpan");
            muatData();
            view.clearForm();
        } catch (Exception e) {
            view.tampilkanPesanError("Gagal menambah data: " + e.getMessage());
        }
    }
    
    // Method untuk mengedit data
    private void editData() {
        String nama = view.getTxtNama().getText().trim();
        String nim = view.getTxtNim().getText().trim();
        String jurusan = view.getTxtJurusan().getText().trim();
        
        // Validasi input kosong
        if (nama.isEmpty() || nim.isEmpty()) {
            view.tampilkanPesanError("Data tidak boleh kosong!");
            return;
        }
        
        try {
            model.updateMahasiswa(nama, nim, jurusan);
            view.tampilkanPesan("Data berhasil diupdate");
            muatData();
            view.clearForm();
        } catch (Exception e) {
            view.tampilkanPesanError("Gagal mengedit data: " + e.getMessage());
        }
    }
    
    // Method untuk menghapus data
    private void hapusData() {
        String nim = view.getTxtNim().getText().trim();
        
        if (nim.isEmpty()) {
            view.tampilkanPesanError("Pilih data yang akan dihapus!");
            return;
        }
        
        try {
            model.hapusMahasiswa(nim);
            view.tampilkanPesan("Data berhasil dihapus");
            muatData();
            view.clearForm();
        } catch (Exception e) {
            view.tampilkanPesanError("Gagal menghapus data: " + e.getMessage());
        }
    }
    
    // Method untuk mencari data
    private void cariData() {
        DefaultTableModel tableModel = view.getModel();
        tableModel.setRowCount(0); // reset tabel
        String kataKunci = view.getTxtCari().getText().trim();
        
        try {
            List<String[]> dataList = model.cariMahasiswa(kataKunci);
            int no = 1;
            for (String[] data : dataList) {
                tableModel.addRow(new Object[]{
                    no++,
                    data[0], // nama
                    data[1], // nim
                    data[2]  // jurusan
                });
            }
            
            // Jika tidak ada hasil dan kata kunci kosong, tampilkan semua data
            if (tableModel.getRowCount() == 0 && kataKunci.isEmpty()) {
                muatData();
            }
        } catch (Exception e) {
            view.tampilkanPesanError("Gagal mencari data: " + e.getMessage());
        }
    }
}
