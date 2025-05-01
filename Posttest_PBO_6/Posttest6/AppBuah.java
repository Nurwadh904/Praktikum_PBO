// Main App

package Posttest6;

import java.util.ArrayList;
import java.util.Scanner;

public class AppBuah {
    private static final ArrayList<Buah> daftarBuah = new ArrayList<>();
    private static final ArrayList<Transaksi> riwayatTransaksi = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        int pilihan = 0;
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

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1: inputTambahBuah(); break;
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

    private static void inputTambahBuah() {
        try {
            System.out.print("Masukkan nama buah: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan harga buah: ");
            double harga = scanner.nextDouble();
            System.out.print("Masukkan stok buah: ");
            int stok = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Pilih jenis buah:");
            System.out.println("1. Buah Lokal");
            System.out.println("2. Buah Import");
            System.out.print("Pilihan: ");
            int jenis = scanner.nextInt();
            scanner.nextLine();

            if (jenis == 1) {
                System.out.print("Masukkan daerah asal: ");
                String daerah = scanner.nextLine();
                daftarBuah.add(new BuahLokal(nama, harga, stok, daerah));
            } else if (jenis == 2) {
                System.out.print("Masukkan negara asal: ");
                String negara = scanner.nextLine();
                daftarBuah.add(new BuahImport(nama, harga, stok, negara));
            } else {
                System.out.println("Pilihan tidak valid, buah tidak ditambahkan.");
            }

            System.out.println("Buah berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input. Silahkan coba lagi.");
            scanner.nextLine();
        }
    }

    private static void lihatDaftarBuah() {
        if (daftarBuah.isEmpty()) {
            System.out.println("Tidak ada buah dalam daftar.");
        } else {
            System.out.println("\nDaftar Buah:");
            int no = 1;
            for (Buah buah : daftarBuah) {
                System.out.println(no++ + ". " + buah);
            }
        }
    }

    private static void ubahDataBuah() {
        lihatDaftarBuah();
        if (daftarBuah.isEmpty()) return;

        try {
            System.out.print("Pilih nomor buah yang ingin diubah: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < daftarBuah.size()) {
                System.out.print("Masukkan stok baru: ");
                int stok = scanner.nextInt();
                scanner.nextLine();
                daftarBuah.get(index).setStok(stok);
                System.out.println("Data buah berhasil diperbarui!");
            } else {
                System.out.println("Nomor buah tidak valid.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine();
        }
    }

    private static void hapusBuah() {
        lihatDaftarBuah();
        if (daftarBuah.isEmpty()) return;

        try {
            System.out.print("Pilih nomor buah yang ingin dihapus: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < daftarBuah.size()) {
                daftarBuah.remove(index);
                System.out.println("Buah berhasil dihapus!");
            } else {
                System.out.println("Nomor buah tidak valid.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine();
        }
    }

    private static void jualBuah() {
        lihatDaftarBuah();
        if (daftarBuah.isEmpty()) return;

        try {
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
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine();
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
