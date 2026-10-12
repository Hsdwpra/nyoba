import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inisialisasi variabel
        int jenisWorkshop;
        int metodePembayaran;
        String kategoriPeserta;
        int semester = 0;
        
        float hargaDasar = 0;
        float diskonPersen = 0.0f;
        float diskon = 0;
        float totalBiaya = 0;
        
        System.out.println("=====================");
        System.out.println("Sistem Pendaftaran Workshop");
        System.out.println("=====================");
        System.out.println("Pilihan Kategori Peserta:");
        System.out.println("1. Mahasiswa");
        System.out.println("2. Umum");
        System.out.print("Masukkan kategori peserta (1/2): ");
        kategoriPeserta = scanner.nextLine();
        
        // Perbaikan 1: Menggunakan .equals() untuk membandingkan String
        if (kategoriPeserta.equals("1") || kategoriPeserta.equalsIgnoreCase("mahasiswa")) {
            System.out.print("Masukkan semester Anda: ");
            semester = scanner.nextInt();
            
            // Nested If untuk menentukan diskon berdasarkan semester
            if (semester == 1) {
                System.out.println("Status: Mahasiswa Baru (Diskon 20%)");
                diskonPersen = 0.2f;
            } else if (semester >= 2 && semester <= 6) {
                System.out.println("Status: Mahasiswa Reguler (Diskon 10%)");
                diskonPersen = 0.1f;
            } else {
                System.out.println("Status: Mahasiswa Semester Akhir (Tanpa Diskon)");
                diskonPersen = 0.0f;
            }
        } else {
            System.out.println("Status: Peserta Umum (Tanpa Diskon Kategori)");
            diskonPersen = 0.0f;
        }

        // Menu Workshop (Berjalan untuk SEMUA kategori peserta)
        System.out.println("======================");
        System.out.println("Pilih Jenis Workshop:");
        System.out.println("1. Back-End Development (Rp. 50.000)");
        System.out.println("2. Internet of Things / IoT (Rp. 75.000)");
        System.out.println("3. UI/UX Design (Rp. 100.000)");
        System.out.print("Masukkan pilihan jenis workshop (1/2/3): ");
        jenisWorkshop = scanner.nextInt();  

        // Switch-Case untuk menentukan harga dasar
        switch (jenisWorkshop) {
            case 1:
                hargaDasar = 50000;
                break;
            case 2:
                hargaDasar = 75000;
                break;
            case 3:
                hargaDasar = 100000;
                break;
            default:
                System.out.println("Pilihan workshop tidak valid.");
                scanner.close();
                return; // Menghentikan program jika pilihan salah
        }

        // Hitung nominal diskon berdasarkan harga dasar yang sudah didapat
        diskon = hargaDasar * diskonPersen;

        // Pilihan Metode Pembayaran
        System.out.println("======================");
        System.out.println("Pilih Metode Pembayaran:");
        System.out.println("1. Transfer Bank");
        System.out.println("2. E-Wallet (Cashback tambahan 5%)");
        System.out.print("Masukkan pilihan metode pembayaran (1/2): ");
        metodePembayaran = scanner.nextInt();

        // If-Else untuk metode pembayaran
        if (metodePembayaran == 1) {
            totalBiaya = hargaDasar - diskon;
        } else if (metodePembayaran == 2) {
            // Diskon total dikurangi lagi 5% dari harga dasar
            totalBiaya = (hargaDasar - diskon) - (0.05f * hargaDasar); 
        } else {
            System.out.println("Pilihan metode pembayaran tidak valid.");
            scanner.close();
            return;
        }

        // Output Rincian Akhir
        System.out.println("======================");
        System.out.println("Rincian Biaya Workshop:");
        System.out.println("Harga Dasar    : Rp. " + hargaDasar);
        System.out.println("Total Diskon   : Rp. " + diskon);
        System.out.println("Total Pembayaran: Rp. " + totalBiaya);
        System.out.println("======================");
        
        scanner.close();
    }
}

//PROGRAM PendaftaranWorkshopIT

// Kamus:
//     jenisWorkshop, metodeBayar : Integer
//     kategoriPeserta, statusMhs : String
//     semester : Integer
//     hargaDasar, totalBayar, diskon : Float

// Algoritma:
//     // 1. Bagian Print / Output Tampilan Awal
//     PRINT "=========================================="
//     PRINT "   SISTEM PENDAFTARAN TECH WORKSHOP 2026  "
//     PRINT "=========================================="
//     PRINT "Pilihan Kategori Peserta:"
//     PRINT "1. Mahasiswa Internal"
//     PRINT "2. Umum"
//     INPUT kategoriPeserta

//     // 2. Penggunaan Nested If (If Berarang)
//     IF (kategoriPeserta == "1" OR kategoriPeserta == "Mahasiswa") THEN
//         PRINT "Masukkan Status Semester Anda: "
//         INPUT semester
        
//         IF (semester == 1) THEN
//             PRINT "Status: Mahasiswa Baru (Berhak mendapat subsidi khusus)"
//             diskon = 0.20 // Diskon 20%
//         ELSE
//             PRINT "Status: Mahasiswa Reguler"
//             diskon = 0.10 // Diskon 10%
//         ENDIF
        
//     ELSE
//         PRINT "Status: Peserta Umum"
//         diskon = 0.0 // Tidak ada diskon khusus kategori
//     ENDIF

//     // 3. Bagian Print Menu & Switch-Case untuk Pemilihan Workshop
//     PRINT "------------------------------------------"
//     PRINT "Pilih Jenis Workshop:"
//     PRINT "1. Backend Development (Rp 50.000)"
//     PRINT "2. Internet of Things / IoT (Rp 60.000)"
//     PRINT "3. UI/UX Design (Rp 45.000)"
//     PRINT "Pilihan Anda (1-3): "
//     INPUT jenisWorkshop

//     SWITCH (jenisWorkshop)
//         Case 1:
//             hargaDasar = 50000
//             PRINT "Anda memilih: Backend Development"
//             Break
//         Case 2:
//             hargaDasar = 60000
//             PRINT "Anda memilih: Internet of Things (IoT)"
//             Break
//         Case 3:
//             hargaDasar = 45000
//             PRINT "Anda memilih: UI/UX Design"
//             Break
//         Default:
//             PRINT "Pilihan tidak valid, diatur ke default (Backend)"
//             hargaDasar = 50000
//     ENDSWITCH

//     // 4. Penggunaan If-Else untuk Metode Pembayaran & Hitung Diskon Akhir
//     PRINT "------------------------------------------"
//     PRINT "Pilih Metode Pembayaran:"
//     PRINT "1. E-Wallet (Cashback tambahan 5%)"
//     PRINT "2. Transfer Bank (Tanpa cashback tambahan)"
//     INPUT metodeBayar

//     IF (metodeBayar == 1) THEN
//         PRINT "Metode: E-Wallet"
//         totalBayar = (hargaDasar - (hargaDasar * diskon)) - 2500 // Potongan e-wallet
//     ELSE
//         PRINT "Metode: Transfer Bank"
        // totalBayar = hargaDasar - (hargaDasar * diskon)
    // ENDIF

    // 5. Output Hasil Akhir (Print)
    //PRINT "=========================================="
    //PRINT "           STRUK PEMBAYARAN AKHIR         "
    //PRINT "=========================================="
    //PRINT "Total yang harus dibayar: Rp ", totalBayar
    //PRINT "Terima kasih telah mendaftar!"
//ENDPROGRAM//