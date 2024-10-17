import java.util.ArrayList;
import java.util.Scanner;

public class Pembelian {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();
    private static Penumpang penumpang = null;
    private static Penerbangan penerbanganDipilih = null;

    public static void main(String[] args) {
        initPenerbangan();
        int pilihan;

        do {
            tampilkanMenu();
            pilihan = inputInteger("Silahkan pilih menu: ");
            prosesPilihan(pilihan);
        } while (pilihan != 4);

        System.out.println("Terima kasih!");
        scanner.close();
    }

    private static void initPenerbangan() {
        // Menggunakan string untuk bandara keberangkatan dan tujuan
        daftarPenerbangan.add(new Penerbangan("GA101", "CGK, Jakarta", "DPS, Bali", "06:30", "08:15", 1200000f));
        daftarPenerbangan.add(new Penerbangan("QZ202", "SUB, Surabaya", "KNO, Medan", "09:00", "11:45", 1350000f));
    }

    private static void tampilkanMenu() {
        System.out.println("======= EAD Ticket Booking System =======");
        System.out.println("1. Tampilkan Daftar Penerbangan");
        System.out.println("2. Beli Tiket");
        System.out.println("3. Tampilkan Pesanan Tiket");
        System.out.println("4. Exit");
    }

    private static void prosesPilihan(int pilihan) {
        switch (pilihan) {
            case 1 -> tampilkanDaftarPenerbangan();
            case 2 -> beliTiket();
            case 3 -> tampilkanPesananTiket();
            case 4 -> {} // Exit handled in the loop.
            default -> System.out.println("Pilihan tidak valid, coba lagi.");
        }
    }

    private static void tampilkanDaftarPenerbangan() {
        System.out.println("== Daftar Penerbangan ==");
        for (int i = 0; i < daftarPenerbangan.size(); i++) {
            daftarPenerbangan.get(i).tampilDaftarPenerbangan(i);
        }
    }

    private static void beliTiket() {
        if (penumpang == null) {
            penumpang = inputDataPenumpang();
            System.out.println("\nTerima kasih telah mengisi data. Silakan pilih tiket penerbangan.");
        }

        tampilkanDaftarPenerbangan();
        int nomor = inputInteger("Pilih nomor penerbangan (ex: 1): ") - 1;

        if (nomor >= 0 && nomor < daftarPenerbangan.size()) {
            penerbanganDipilih = daftarPenerbangan.get(nomor);
            System.out.println("\nPemesanan Tiket Berhasil! Cek Pesanan di Menu (3).");
        } else {
            System.out.println("Nomor penerbangan tidak valid!");
        }
    }

    private static void tampilkanPesananTiket() {
        if (penerbanganDipilih != null && penumpang != null) {
            System.out.println("======= Detail Tiket Penerbangan =======");
            penumpang.tampilDetailPenumpang();
            System.out.println("Nomor Penerbangan: " + penerbanganDipilih.getNomorPenerbangan());
            System.out.println("Harga Tiket: Rp." + penerbanganDipilih.getHargaTiket());
        } else {
            System.out.println("Belum ada pembelian tiket.");
        }
    }

    private static Penumpang inputDataPenumpang() {
        System.out.println("\nIsi Data Diri Anda:");
        String NIK = inputString("Masukkan NIK: ");
        String namaDepan = inputString("Masukkan Nama Depan: ");
        String namaBelakang = inputString("Masukkan Nama Belakang: ");
        return new Penumpang(NIK, namaDepan, namaBelakang);
    }

    private static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int inputInteger(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka!");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Bersihkan newline
        return input;
    }
}
