// Abstract Class

package Posttest6;

public abstract class Buah implements ManajemenBuah {
    private String nama;
    private double harga;
    private int stok;

    public Buah(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Harga: " + harga + ", Stok: " + stok;
    }

    public abstract String getAsal();

    // Static method
    public static void cetakInfoBuah() {
        System.out.println("Program Manajemen Data Buah 🚀");
    }

    // Implementasi interface default (tidak dipakai disini, dipanggil di subclass)
    public void tambahData() {}
    public void lihatData() {}
}
