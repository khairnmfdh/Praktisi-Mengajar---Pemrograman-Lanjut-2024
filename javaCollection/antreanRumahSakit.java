
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KHAIRANI
 */
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author KHAIRANI
 */
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
public class antreanRumahSakit {

    public static void main(String[] args) {
        Queue<Pasien> queues = new ArrayDeque<>(10);
        queues.offer(new Pasien("Ana", "RS01"));
        queues.offer(new Pasien("Boni", "RS02"));
                
        for (Pasien pasien : queues) {
            System.out.println("Nomor Antrean:"+pasien.getAntrean());
            System.out.println("Sedang Memeriksa " + pasien.getNama() + " dengan nomor antrean " + pasien.getAntrean());
            // Proses pemeriksaan pasien...
            System.out.println("Selesai memeriksa " + pasien.getNama()+"\n");
        }


    }
}
