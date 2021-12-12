/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SISAPRA;

/**
 *
 * @author Wordyka Nainggolan
 */
import java.util.*;

import java.io.*;

class Barang extends ABSPengguna implements ITFPinjamKembali, Serializable{
    int ID_Barang = 0;
    String Nama = "-";
    String Jenis = "-";
    int Jumlah = 0;
    String Kondisi = "Baru";
    String Loc;
    String Status = "Tersedia";

    public Barang() {
    }

    public Barang(int ID_Barang, String Nama, String Jenis, int Jumlah, String Kondisi, String Loc, String Status) {
        this.ID_Barang = ID_Barang;
        this.Nama = Nama;
        this.Jenis = Jenis;
        this.Jumlah = Jumlah;
        this.Kondisi = Kondisi;
        this.Loc = Loc;
        this.Status = Status;
    }

    @Override
    public String toString(){
        return ID_Barang+" || "+Nama+" || "+Jenis+" || "+Jumlah+" || "+Kondisi+" || "+Loc+" || "+Status;
    }


    public void lihatBarang() throws IOException, ClassNotFoundException, InterruptedException {
        int choice = -1;
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        AksiMahasiswa AMhs = new AksiMahasiswa();
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();
        }

        do{
            System.out.println("\n\n\n\n==============SELAMAT DATANG DI HALAMAN BERANDA===========");
            System.out.println("1.Lihat Data Barang");
            System.out.println("2.Lihat Jenis Barang");
            System.out.println("3.Cek Kondisi Barang");
            System.out.println("4.Saring Data Barang");
            System.out.println("5.Urutkan Barang");
            System.out.println("6.Lihat Daftar Ruangan");
            System.out.println("7.Cari Barang");
            System.out.println("8.Pengembalian Barang");
            System.out.println("9.Peminjaman Barang");
            System.out.println("10.Kembali");
            System.out.println("0.Keluar");
            System.out.print("Masukkan pilihan Anda : ");
            choice = s.nextInt();

            switch(choice){
                case 1:
                    lihatDaftarBarang();
                    break;
                case 2:
                    lihatJenis();
                    break;
                case 3:
                    cekKondisi();
                    break;
                case 4:
                    saringData();
                    break;
                case 5:
                    urutData();
                    break;
                case 6:
                    lihatDaftarRuangan();
                    break;
                case 7:
                    cariBarang();
                    break;
                case 8:
                    Mengembalikan();
                    break;
                case 9:
                    Meminjam();
                    break;
                case 10:
                    AMhs.HalamanAutentikasi();
                    break;
                default:
                    System.out.println("Inputan anda tidak valid!\n");
                    choice = 1;
            }
        }while(choice!=0);
    }

    @Override
    public void lihatDaftarBarang() throws IOException, ClassNotFoundException, InterruptedException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
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
    }

    @Override
    public void lihatJenis() throws IOException, ClassNotFoundException {
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();

            boolean found = false;

            System.out.println("-------------------------------------");
            li = al2.listIterator();
            while(li.hasNext()) {
                Barang e = (Barang)li.next();
                System.out.println(e.Nama+" => "+ e.Jenis);
                found = true;
            }
            System.out.println("-------------------------------------");
        }else{
            System.out.println("Data tidak ditemukan....!");
        }
    }

    @Override
    public void cekKondisi() throws IOException, ClassNotFoundException {
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();

            boolean found = false;

            System.out.println("-------------------------------------");
            li = al2.listIterator();
            while(li.hasNext()) {
                Barang e = (Barang)li.next();
                System.out.println(e.Nama+" => "+ e.Kondisi);
                found = true;
            }
            System.out.println("-------------------------------------");
        }else{
            System.out.println("Data tidak ditemukan....!");
        }
    }

    @Override
    public void saringData() throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();

            boolean found = false;

            System.out.println("-------------------------------------");
            li = al2.listIterator();
            while(li.hasNext()) {
                Barang e = (Barang)li.next();
                System.out.println(e.Nama+" => "+ e.Kondisi);
                found = true;
            }
            System.out.println("-------------------------------------");
        }else{
            System.out.println("Data tidak ditemukan....!");
        }
    }

    @Override
    public void urutData() throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();

            Collections.sort(al2, new Comparator<Barang>(){
                public int compare(Barang e1, Barang e2){
                    return e1.Nama.compareTo(e2.Nama);
                }
            });

            System.out.println("-------------------------------------");
            li = al2.listIterator();
            while(li.hasNext())
                System.out.println(li.next());
            System.out.println("-------------------------------------");
        }else{
            System.out.println("Data tidak ditemukan!");
        }
    }

    @Override
    public void lihatDaftarRuangan() throws IOException, ClassNotFoundException {
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();

            boolean found = false;

            System.out.println("-------------------------------------");
            li = al2.listIterator();
            while(li.hasNext()) {
                Barang e = (Barang)li.next();
                System.out.println(e.Nama+" => "+ e.Loc);
                found = true;
            }
            System.out.println("-------------------------------------");
        }else{
            System.out.println("Data tidak ditemukan....!");
        }
    }



    @Override
    public void cariBarang() throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();

            boolean found = false;
            System.out.println("Enter ID Barang untuk dicari : ");
            int ID_Barang = s.nextInt();
            System.out.println("-------------------------------------");
            li = al2.listIterator();
            while(li.hasNext()){
                Barang e = (Barang)li.next();
                if(e.ID_Barang == ID_Barang){
                    System.out.println(e);
                    found = true;
                }
            }
            if(!found)
                System.out.println("Data ditemukan...!");
            System.out.println("-------------------------------------");
        }else{
            System.out.println("Data tidak ditemukan....!");
        }
    }


    public static void Meminjam() throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        boolean found = false;


        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();

            li = al2.listIterator();
            while(li.hasNext()){
                Barang e = (Barang)li.next();
                if(e.Status.equals("Tersedia")){
                    System.out.println(e);
                }
            }

            System.out.print("Enter ID_Barang untuk dipinjam: ");
            int ID_Barang = s.nextInt();


            li = al2.listIterator();
            while(li.hasNext()){
                Barang e = (Barang)li.next();
                if(ID_Barang==e.ID_Barang){
                    System.out.println("Enter jumlah barang untuk dipinjam: ");
                    int jumlah = s.nextInt();
                    if (e.Jumlah<jumlah) {
                        System.out.println("Anda melewati batas jumlah peminjaman barang");
                    } else {
                        e.Jumlah = e.Jumlah-jumlah;
                        if (e.Jumlah==jumlah) {
                            e.Status = "Kosong";
                        }
                        li.set(new Barang(e.ID_Barang,e.Nama,e.Jenis,e.Jumlah,e.Kondisi, e.Loc, e.Status));
                        found = true;
                    }
                }
            }

            if (found) {
                oos = new ObjectOutputStream(new FileOutputStream(file2));
                oos.writeObject(al2);
                oos.close();
                System.out.println("Barang berhasil dipinjam!");
            }

            System.out.println("-------------------------------------");
        }else{
            System.out.println("Data tidak ditemukan....!");
        }
    }


    public static void Mengembalikan() throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Barang.txt");
        ArrayList<Barang> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        boolean found = false;

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Barang>)ois.readObject();
            ois.close();

            li = al2.listIterator();
            while(li.hasNext()){
                Barang e = (Barang)li.next();
                System.out.println(e);
            }

            System.out.print("Enter ID_Barang untuk dikembalikan: ");
            int ID_Barang = s.nextInt();

            li = al2.listIterator();

            while(li.hasNext()){
                Barang e = (Barang)li.next();
                if(e.ID_Barang == ID_Barang){
                    System.out.println(e);
                    System.out.println("Enter jumlah barang untuk dikembalikan: ");
                    s.nextLine();
                    int jumlah = s.nextInt();
                    if (jumlah>e.Jumlah) {
                        System.out.println("Anda mengisi jumlah pengembalian barang yang tidak valid");
                    } else {
                        e.Jumlah = e.Jumlah+jumlah;
                        e.Status = "Tersedia";
                        li.set(new Barang(e.ID_Barang,e.Nama,e.Jenis,e.Jumlah,e.Kondisi, e.Loc, e.Status));
                        found = true;
                    }
                }
            }

            if (found) {
                oos = new ObjectOutputStream(new FileOutputStream(file2));
                oos.writeObject(al2);
                oos.close();
                System.out.println("Barang berhasil dikembalikan!");
            }

            System.out.println("-------------------------------------");
        }else{
            System.out.println("Data tidak ditemukan....!");
        }
    }

}



