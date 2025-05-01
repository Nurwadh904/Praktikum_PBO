// Final Class

package Posttest6;

public final class Transaksi {
    protected final String namaBuah;
    protected int jumlah;
    protected double totalHarga;

    public Transaksi(String namaBuah, int jumlah, double totalHarga) {
        this.namaBuah = namaBuah;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    public String getNamaBuah() { return namaBuah; }
    public int getJumlah() { return jumlah; }
    public double getTotalHarga() { return totalHarga; }

    @Override
    public String toString() {
        return "Buah: " + namaBuah + ", Jumlah: " + jumlah + ", Total Harga: " + totalHarga;
    }
}
