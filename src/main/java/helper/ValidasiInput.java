/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.util.Scanner;

/**
 *
 * @author Asus
 */

public class ValidasiInput {

    public static int inputInteger(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);

            if (scanner.hasNextInt()) {
                int nilai = scanner.nextInt();
                scanner.nextLine();
                return nilai;
            }

            System.out.println("Input harus berupa angka");
            scanner.nextLine();
        }
    }

    public static String inputNama(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String nama = scanner.nextLine();

            if (!nama.isEmpty() && nama.matches("[a-zA-Z ]+")) {
                return nama;
            }

            System.out.println("Nama hanya boleh mengandung huruf");
        }
    }

    public static int inputUmur(Scanner scanner, String pesan) {
        while (true) {
            int umur = inputInteger(scanner, pesan);

            if (umur > 0 && umur <= 200) {
                return umur;
            }

            System.out.println("Umur harus antara 1 - 200");
        }
    }

    public static String inputNoTelepon(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String noTelepon = scanner.nextLine();

            if (noTelepon.matches("\\d{9,13}")) {
                return noTelepon;
            }

            System.out.println("Nomor telepon harus berupa angka dan terdiri dari 9-13 digit");
        }
    }

    public static String inputNomorBPJS(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String nomorBPJS = scanner.nextLine();

            if (nomorBPJS.matches("\\d+")) {
                return nomorBPJS;
            }

            System.out.println("Nomor BPJS hanya boleh berupa angka");
        }
    }
}