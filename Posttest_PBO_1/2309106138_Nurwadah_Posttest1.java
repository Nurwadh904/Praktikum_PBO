
//Nurwadah
//2309106138

import java.util.ArrayList;
import java.util.Scanner;

class Buah {
    private String nama;
    private double harga;
    private int stok;

    public Buah(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    
    public void setStok(int stok) { this.stok = stok; }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Harga: " + harga + ", Stok: " + stok;
    }
}

class Transaksi {
    private String namaBuah;
    private int jumlah;
    private double totalHarga;

    public Transaksi(String namaBuah, int jumlah, double totalHarga) {
        this.namaBuah = namaBuah;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    @Override
    public String toString() {
        return "Buah: " + namaBuah + ", Jumlah: " + jumlah + ", Total Harga: " + totalHarga;
    }
}

public class StokBuah {
    private static ArrayList<Buah> daftarBuah = new ArrayList<>();
    private static ArrayList<Transaksi> riwayatTransaksi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== Sistem Informasi Pengelolaan Stok dan Penjualan Buah ===");
            System.out.println("1. Tambah Buah");
            System.out.println("2. Lihat Daftar Buah");
            System.out.println("3. Ubah Data Buah");
            System.out.println("4. Hapus Buah");
            System.out.println("5. Jual Buah");
            System.out.println("6. Lihat Riwayat Transaksi");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: tambahBuah(); break;
                case 2: lihatDaftarBuah(); break;
                case 3: ubahDataBuah(); break;
                case 4: hapusBuah(); break;
                case 5: jualBuah(); break;
                case 6: lihatRiwayatTransaksi(); break;
                case 7: System.out.println("Keluar dari program."); break;
                default: System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (pilihan != 7);
    }

    private static void tambahBuah() {
        System.out.print("Masukkan nama buah: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga buah: ");
        double harga = scanner.nextDouble();
        System.out.print("Masukkan stok buah: ");
        int stok = scanner.nextInt();
        scanner.nextLine();
        
        daftarBuah.add(new Buah(nama, harga, stok));
        System.out.println("Buah berhasil ditambahkan!");
    }

    private static void lihatDaftarBuah() {
        if (daftarBuah.isEmpty()) {
            System.out.println("Tidak ada buah dalam daftar.");
        } else {
            System.out.println("\nDaftar Buah:");
            for (int i = 0; i < daftarBuah.size(); i++) {
                System.out.println((i + 1) + ". " + daftarBuah.get(i));
            }
        }
    }

    private static void ubahDataBuah() {
        lihatDaftarBuah();
        if (daftarBuah.isEmpty()) return;
        
        System.out.print("Pilih nomor buah yang ingin diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (index >= 0 && index < daftarBuah.size()) {
            System.out.print("Masukkan stok baru: ");
            int stok = scanner.nextInt();
            scanner.nextLine();
            daftarBuah.get(index).setStok(stok);
            System.out.println("Data buah berhasil diperbarui!");
        } else {
            System.out.println("Nomor buah tidak valid.");
        }
    }

    private static void hapusBuah() {
        lihatDaftarBuah();
        if (daftarBuah.isEmpty()) return;
        
        System.out.print("Pilih nomor buah yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (index >= 0 && index < daftarBuah.size()) {
            daftarBuah.remove(index);
            System.out.println("Buah berhasil dihapus!");
        } else {
            System.out.println("Nomor buah tidak valid.");
        }
    }

    private static void jualBuah() {
        lihatDaftarBuah();
        if (daftarBuah.isEmpty()) return;
        
        System.out.print("Pilih nomor buah yang ingin dibeli: ");
        int index = scanner.nextInt() - 1;
        
        if (index >= 0 && index < daftarBuah.size()) {
            Buah buah = daftarBuah.get(index);
            System.out.print("Masukkan jumlah yang ingin dibeli: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();
            
            if (jumlah > 0 && jumlah <= buah.getStok()) {
                double totalHarga = jumlah * buah.getHarga();
                buah.setStok(buah.getStok() - jumlah);
                riwayatTransaksi.add(new Transaksi(buah.getNama(), jumlah, totalHarga));
                System.out.println("Pembelian berhasil! Total harga: " + totalHarga);
            } else {
                System.out.println("Stok tidak mencukupi atau jumlah tidak valid.");
            }
        } else {
            System.out.println("Nomor buah tidak valid.");
        }
    }

    private static void lihatRiwayatTransaksi() {
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            System.out.println("\nRiwayat Transaksi:");
            for (Transaksi transaksi : riwayatTransaksi) {
                System.out.println(transaksi);
            }
        }
    }
}
