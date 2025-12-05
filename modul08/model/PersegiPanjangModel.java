package modul08.model;

public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    private double keliling;

    //menghitung luas persegi panjang
    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    }

    // menghitung keliling persegi panjang
    public void hitungKeliling() {
        this.keliling = 2 * (this.panjang + this.lebar);
    }

    public void reset() {
        this.panjang = 0;
        this.lebar = 0;
        this.luas = 0;
        this.keliling = 0;
    }

    //getter dan setter
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }

    public void setReset() {
        this.reset();
    }
}
