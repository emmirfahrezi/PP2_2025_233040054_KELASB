package modul10.model;

import modul10.koneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaModel {
    
    // Method untuk mengambil semua data mahasiswa
    public List<String[]> getAllMahasiswa() throws Exception {
        List<String[]> dataList = new ArrayList<>();
        Connection conn = koneksiDB.configDB();
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM mahasiswa");
        
        while (res.next()) {
            String[] data = {
                res.getString("nama"),
                res.getString("nim"),
                res.getString("jurusan")
            };
            dataList.add(data);
        }
        
        return dataList;
    }
    
    // Method untuk menambah data mahasiswa
    public void tambahMahasiswa(String nama, String nim, String jurusan) throws Exception {
        String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
        Connection conn = koneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, nama);
        pst.setString(2, nim);
        pst.setString(3, jurusan);
        
        pst.executeUpdate();
    }
    
    // Method untuk mengupdate data mahasiswa
    public void updateMahasiswa(String nama, String nim, String jurusan) throws Exception {
        String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
        Connection conn = koneksiDB.configDB();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1, nama);
        pstmt.setString(2, jurusan);
        pstmt.setString(3, nim);
        
        pstmt.executeUpdate();
    }
    
    // Method untuk menghapus data mahasiswa
    public void hapusMahasiswa(String nim) throws Exception {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        Connection conn = koneksiDB.configDB();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1, nim);
        
        pstmt.executeUpdate();
    }
    
    // Method untuk mencari data mahasiswa berdasarkan nama
    public List<String[]> cariMahasiswa(String kataKunci) throws Exception {
        List<String[]> dataList = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
        Connection conn = koneksiDB.configDB();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + kataKunci + "%");
        
        ResultSet res = pstmt.executeQuery();
        
        while (res.next()) {
            String[] data = {
                res.getString("nama"),
                res.getString("nim"),
                res.getString("jurusan")
            };
            dataList.add(data);
        }
        
        return dataList;
    }
    
    // Method untuk mengecek apakah NIM sudah ada
    public boolean cekNimExists(String nim) throws Exception {
        String sql = "SELECT nim FROM mahasiswa WHERE nim = ?";
        Connection conn = koneksiDB.configDB();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, nim);
        ResultSet rs = pstmt.executeQuery();
        
        return rs.next();
    }
}
