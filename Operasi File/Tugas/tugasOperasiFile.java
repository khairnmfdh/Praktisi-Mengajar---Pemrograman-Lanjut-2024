import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Pasien {
    private String nama;
    private String nomorAntrean;
    private LocalDate tanggal;

    public Pasien(String nama, String nomorAntrean, LocalDate tanggal) {
        this.nama = nama;
        this.nomorAntrean = nomorAntrean;
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public String getAntrean() {
        return nomorAntrean;
    }
    
    public LocalDate getTanggal(){
        return tanggal;
    }
}


public class tugasOperasiFile {
    private static Queue<Pasien> queues = new ArrayDeque<>(10);
    private static final String DATA_FILE = "hospital_queue_data.txt";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    
    public static void main(String[] args) {
        createFileIfNotExists();
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

    private static void createFileIfNotExists() {
        try {
            File file = new File(DATA_FILE);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    private static void addPatient(Scanner scanner) {
        try {
            System.out.print("Masukkan nama pasien: ");
            String nama = scanner.next();
            System.out.print("Masukkan nomor antrean: ");
            String nomorAntrean = scanner.next();
            System.out.print("Masukkan tanggal (yyyy-MM-dd): ");
            String tanggal1 = scanner.next();
            LocalDate tanggal = LocalDate.parse(tanggal1, DATE_FORMATTER);
            Pasien pasien = new Pasien(nama, nomorAntrean, tanggal);
            queues.offer(pasien);
            savePatientToFile(pasien);
            System.out.println("Pasien " + nama + " ditambahkan ke dalam antrian.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan pasien: " + e.getMessage());
        }
    }

    private static void displayQueue() {
        System.out.println("\nAntrian saat ini:");
        try {
            if (queues == null || queues.isEmpty()) {
                throw new NullPointerException("Antrian kosong atau tidak ada (null).");
            }
            for (Pasien pasien : queues) {
                System.out.println("\nTanggal: "+pasien.getTanggal());
                System.out.println("Nomor Antrean: " + pasien.getAntrean() + ", Nama: " + pasien.getNama());
            }
        } catch (NullPointerException e) {
            System.out.println("A NullPointerException occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menampilkan antrian: " + e.getMessage());
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
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat memproses pasien: " + e.getMessage());
        }
    }

    private static void savePatientToFile(Pasien pasien) {
        try (FileWriter writer = new FileWriter(DATA_FILE, true)) {
            writer.write("Nama: " + pasien.getNama() + ", Nomor Antrean: " + pasien.getAntrean() + "Tanggal Periksa: "+pasien.getTanggal()+ "\n");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data pasien: " + e.getMessage());
        }
    }
}
