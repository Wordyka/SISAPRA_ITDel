package SISAPRA;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Scanner scan = new Scanner(System.in);

        System.out.println("=================SELAMAT DATANG DI APLIKASI=================\n=======SISTEM INFORMASI SARANA DAN PRASARANA (SISAPRA)======\n===========================IT DEL===========================");
        System.out.println("\nMasuk sebagai : ");
        System.out.println("1. Staf\n2. Dosen\n3. Mahasiswa");
        System.out.println("\nPilihan Anda : ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                AksiDosen ADsn = new AksiDosen();
                ADsn.HalamanAutentikasi();
                break;
            case 2:
                AksiStaf AStf = new AksiStaf();
                AStf.HalamanAutentikasi();
                break;
            case 3:
                AksiMahasiswa AMhs = new AksiMahasiswa();
                AMhs.HalamanAutentikasi();
                break;
            default:
                System.out.println("Inputan Anda tidak valid !");
        }

    }
}
