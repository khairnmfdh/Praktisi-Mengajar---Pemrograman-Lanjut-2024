import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Pasien {
    private String nama;
    private String nomorAntrean;

    public Pasien(String nama, String nomorAntrean) {
        this.nama = nama;
        this.nomorAntrean = nomorAntrean;
    }

    public String getNama() {
        return nama;
    }

    public String getAntrean() {
        return nomorAntrean;
    }
}


public class ExceptionHandling {
    private static Queue<Pasien> queues = new ArrayDeque<>(10);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Proses Pasien Berikutnya");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    displayQueue();
                    break;
                case 3:
                    processNextPatient();
                    break;
                case 4:
                    System.out.println("Keluar...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Masukkan nama pasien: ");
        String nama = scanner.next();
        System.out.print("Masukkan nomor antrean: ");
        String nomorAntrean = scanner.next();
        queues.offer(new Pasien(nama, nomorAntrean));
        System.out.println("Pasien " + nama + " ditambahkan ke dalam antrian.");
    }

    private static void displayQueue() {
        System.out.println("\nAntrian saat ini:");
        try {
            if (queues == null || queues.isEmpty()) {
                throw new NullPointerException("Antrian kosong atau tidak ada (null).");
            }
            for (Pasien pasien : queues) {
                System.out.println("Nomor Antrean: " + pasien.getAntrean() + ", Nama: " + pasien.getNama());
            }
        } catch (NullPointerException e) {
            System.out.println("A NullPointerException occurred: " + e.getMessage());
        }
    }

    private static void processNextPatient() {
        System.out.println("\nMemproses pasien berikutnya...");
        try {
            Pasien pasien = queues.poll();
            if (pasien == null) {
                throw new NullPointerException("Tidak ada pasien dalam antrian.");
            }
            System.out.println("Sedang Memeriksa " + pasien.getNama() + " dengan nomor antrean " + pasien.getAntrean());
            // Proses pemeriksaan pasien...
            System.out.println("Selesai memeriksa " + pasien.getNama() + "\n");
        } catch (NullPointerException e) {
            System.out.println("A NullPointerException occurred: " + e.getMessage());
        }
    }
}
