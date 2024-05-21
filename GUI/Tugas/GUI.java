import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Queue;

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

    public LocalDate getTanggal() {
        return tanggal;
    }
}

public class GUI extends JFrame {
    private static final String DATA_FILE = "hospital_queue_data.txt";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Queue<Pasien> queues = new ArrayDeque<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> daftarAntrian = new JList<>(listModel);
    private JTextArea antrianDiproses = new JTextArea();
    private JTextArea antrianSelesai = new JTextArea();
    private JTextField inputNama = new JTextField(20);
    private JTextField inputNomorAntrean = new JTextField(20);
    private JTextField inputTanggal = new JTextField(20);

    public GUI() {
        setTitle("Antrian");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Panel input data pasien
        JPanel inputPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(inputNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Nomor Antrean:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(inputNomorAntrean, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Tanggal (yyyy-MM-dd):"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(inputTanggal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton btnTambah = new JButton("Tambah Antrian");
        inputPanel.add(btnTambah, gbc);
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = inputNama.getText();
                    String nomorAntrean = inputNomorAntrean.getText();
                    LocalDate tanggal = LocalDate.parse(inputTanggal.getText(), DATE_FORMATTER);

                    Pasien pasien = new Pasien(nama, nomorAntrean, tanggal);
                    queues.offer(pasien);
                    listModel.addElement(nama + " - " + nomorAntrean + " - " + tanggal);
                    inputNama.setText("");
                    inputNomorAntrean.setText("");
                    inputTanggal.setText("");
                    savePatientToFile(pasien);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(GUI.this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Panel antrian
        JPanel queuePanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        queuePanel.add(new JLabel("Daftar Antrian"), gbc);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        queuePanel.add(new JScrollPane(daftarAntrian), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        queuePanel.add(new JLabel("Antrian yang Sedang Diproses"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        queuePanel.add(new JScrollPane(antrianDiproses), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton btnProses = new JButton("Proses Antrian");
        queuePanel.add(btnProses, gbc);
        btnProses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pasien pasien = queues.poll();
                if (pasien != null) {
                    antrianDiproses.setText(pasien.getAntrean());
                    antrianSelesai.append(pasien.getAntrean()+"." + pasien.getNama() + " - " + " ( " + pasien.getTanggal() + ")\n");
                    listModel.remove(0);
                } else {
                    JOptionPane.showMessageDialog(GUI.this, "Tidak ada pasien dalam antrian.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Panel antrian selesai
        JPanel completedPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        completedPanel.add(new JLabel("Antrian yang Sudah Selesai"), gbc);
        gbc.gridy = 1;
        completedPanel.add(new JScrollPane(antrianSelesai), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton btnReset = new JButton("Reset Antrian");
        completedPanel.add(btnReset, gbc);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queues.clear();
                listModel.clear();
                antrianDiproses.setText("");
                antrianSelesai.setText("");
                saveAllToFile();
            }
        });

        // Menambahkan panel input, antrian, dan selesai ke frame utama
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(inputPanel, gbc);
        gbc.gridy = 1;
        add(queuePanel, gbc);
        gbc.gridy = 2;
        add(completedPanel, gbc);

        loadFromFile();
    }

    private void savePatientToFile(Pasien pasien) {
        try (FileWriter writer = new FileWriter(DATA_FILE, true)) {
            writer.write(pasien.getNama() + "," + pasien.getAntrean() + "," + pasien.getTanggal() + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data pasien: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveAllToFile() {
        try (FileWriter writer = new FileWriter(DATA_FILE, false)) {
            for (Pasien pasien : queues) {
                writer.write(pasien.getNama() + "," + pasien.getAntrean() + "," + pasien.getTanggal() + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data pasien: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String nama = parts[0];
                    String nomorAntrean = parts[1];
                    LocalDate tanggal = LocalDate.parse(parts[2], DATE_FORMATTER);
                    Pasien pasien = new Pasien(nama, nomorAntrean, tanggal);
                    queues.offer(pasien);
                    listModel.addElement(nama + " - " + nomorAntrean + " - " + tanggal);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memuat data pasien: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}
