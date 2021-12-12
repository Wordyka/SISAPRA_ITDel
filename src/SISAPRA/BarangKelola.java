package SISAPRA;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class BarangKelola extends ABSPengelola implements Serializable {
    int ID_Barang = 0;
    String Nama = "-";
    String Jenis = "-";
    int Jumlah = 0;
    String Kondisi = "Baru";
    String Loc;
    String Status = "Tersedia";

    public BarangKelola() {
    }

    public BarangKelola(int ID_Barang, String nama, String jenis, int jumlah, String kondisi, String loc, String status) {
        this.ID_Barang = ID_Barang;
        Nama = nama;
        Jenis = jenis;
        Jumlah = jumlah;
        Kondisi = kondisi;
        Loc = loc;
        Status = status;
    }

    public String toString(){
        return ID_Barang+" || "+Nama+" || "+Jenis+" || "+Jumlah+" || "+Kondisi+" || "+Loc+" || "+Status;
    }

    public void kelolaBarang() throws IOException, ClassNotFoundException, InterruptedException {
        int choice = -1;
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<BarangKelola> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        AksiMahasiswa AMhs = new AksiMahasiswa();
        Mahasiswa Mhs = new Mahasiswa();
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<BarangKelola>)ois.readObject();
            ois.close();
        }

        do{
            System.out.println("\n\n\n\n==============SELAMAT DATANG DI HALAMAN ADMIN===========");
            System.out.println("1.Lihat Data Barang");
            System.out.println("2.Tambah Data Barang");
            System.out.println("3.Hapus Data Barang");
            System.out.println("4.Ubah Data Barang");
            System.out.println("5.Daftar Mahasiswa");
            System.out.println("6.Kembali");
            System.out.println("0.Keluar");
            System.out.print("Masukkan pilihan Anda : ");
            choice = s.nextInt();

            switch(choice){
                case 1:
                    if(file2.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file2));
                        al2 = (ArrayList<BarangKelola>)ois.readObject();
                        ois.close();

                        System.out.println("-------------------------------------");
                        li = al2.listIterator();
                        System.out.println("============DAFTAR BARANG=============");
                        System.out.println("ID || Nama || Jenis || Jumlah || Kondisi || Lokasi || Status");
                        while(li.hasNext())
                            System.out.println(li.next());
                        System.out.println("-------------------------------------");
                    }else{
                        System.out.println("File not Exists....!");
                    }
                    break;
                case 2:
                    tambahBarang();
                    break;
                case 3:
                    hapusBarang();
                    break;
                case 4:
                    ubahBarang();
                    break;
                case 5:
                    AMhs.daftarMahasiswa();
                    break;
                case 6:
                    Thread.sleep(1000);
                    AMhs.clearConsole();
                    choice = 0;
                    AMhs.HalamanAutentikasi();
                    break;
                default:
                    System.out.println("Inputan anda tidak valid!\n");
                    choice = 1;
            }
        }while(choice!=0);
    }

    @Override
    public void tambahBarang() throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        AksiMahasiswa AMhs = new AksiMahasiswa();
        Mahasiswa Mhs = new Mahasiswa();

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();
        }

        System.out.println("Jumlah barang yang dimasukkan : ");
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter ID_Barang: ");
            int ID_Barang = s.nextInt();

            System.out.print("Enter Nama Barang: ");
            String Nama = s1.nextLine();

            System.out.print("Enter Jenis Barang : ");
            String Jenis = s1.nextLine();

            System.out.print("Enter Jumlah Barang : ");
            int Jumlah = s.nextInt();

            System.out.print("Enter Kondisi Barang : ");
            String Kondisi = s1.nextLine();

            System.out.println("Enter Lokasi Barang : ");
            String Loc = s1.nextLine();

            Lokasi location = Lokasi.valueOf(Lokasi.class, Loc);

            al2.add(new Barang(ID_Barang,Nama,Jenis,Jumlah,Kondisi,Lokasi.getVal(location),Status));
        }
        oos = new ObjectOutputStream(new FileOutputStream(file2));
        oos.writeObject(al2);
        oos.close();
    }

    @Override
    public void hapusBarang() throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        AksiMahasiswa AMhs = new AksiMahasiswa();
        Mahasiswa Mhs = new Mahasiswa();

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();

            boolean found = false;
            System.out.print("Enter ID Barang untuk dihapus : ");
            int ID_Barang = s.nextInt();
            System.out.println("-------------------------------------");
            li = al2.listIterator();
            while(li.hasNext()){
                Barang e = (Barang)li.next();
                if(e.ID_Barang == ID_Barang){
                    li.remove();
                    found = true;
                }
            }
            if(found){
                oos = new ObjectOutputStream(new FileOutputStream(file2));
                oos.writeObject(al2);
                oos.close();
                System.out.println("Data berhasil dihapus....!");
            }
            else{
                System.out.println("Data tidak berhasil dihapus...!");
            }
            System.out.println("-------------------------------------");
        }else{
            System.out.println("Data tidak ditemukan....!");
        }
    }

    @Override
    public void ubahBarang() throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        AksiMahasiswa AMhs = new AksiMahasiswa();
        Mahasiswa Mhs = new Mahasiswa();

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();

            boolean found = false;
            System.out.print("Enter ID_Barang untuk diupdate : ");
            int ID_Barang = s.nextInt();
            System.out.println("-------------------------------------");
            li = al2.listIterator();
            while(li.hasNext()){
                Barang e = (Barang)li.next();
                if(e.ID_Barang == ID_Barang){
                    System.out.print("Enter Nama Barang yang baru : ");
                    String Nama = s1.nextLine();

                    System.out.print("Enter Jenis Barang yang baru : ");
                    String Jenis = s1.nextLine();

                    System.out.print("Enter Jumlah Barang yang baru : ");
                    int Jumlah = s.nextInt();

                    System.out.print("Enter Kondisi Barang yang baru : ");
                    String Kondisi = s1.nextLine();

                    System.out.println("Enter Lokasi Barang yang baru : ");
                    String Loc = s1.nextLine();

                    Lokasi location = Lokasi.valueOf(Lokasi.class, Loc);

                    li.set(new Barang(ID_Barang,Nama,Jenis,Jumlah,Kondisi, Lokasi.getVal(location), Status));
                    found = true;

                }
            }
            if(found){
                oos = new ObjectOutputStream(new FileOutputStream(file2));
                oos.writeObject(al2);
                oos.close();
                System.out.println("Data berhasil diubah!");
            }
            else{
                System.out.println("Data tidak berhasil diubah!");
            }
            System.out.println("-------------------------------------");
        }else{
            System.out.println("Data tidak ditemukan!");
        }
    }
}
