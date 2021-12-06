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

class Barang implements Serializable{
    int ID_Barang = 0;
    String Nama = "-";
    String Jenis = "-";
    int Jumlah = 0;
    String Kondisi = "Baru";
    String Status = "Tersedia";

    public Barang() {
    }

    public Barang(int ID_Barang, String Nama, String Jenis, int Jumlah, String Kondisi, String Status) {
        this.ID_Barang = ID_Barang;
        this.Nama = Nama;
        this.Jenis = Jenis;
        this.Jumlah = Jumlah;
        this.Kondisi = Kondisi;
        this.Status = Status;
    }

    @Override
    public String toString(){
        return ID_Barang+" || "+Nama+" || "+Jenis+" || "+Jumlah+" || "+Kondisi+" || "+Status;
    }


    public void lihatBarang() throws IOException, ClassNotFoundException {
        int choice = -1;
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
        }

        do{
            System.out.println("\n\n\n\n==============SELAMAT DATANG DI HALAMAN BERANDA===========");
            System.out.println("1.Tampilkan Data Barang");
            System.out.println("2.Cari Data Barang");
            System.out.println("3.Urutkan berdasarkan ID_Barang");
            System.out.println("4.Urutkan berdasarkan Nama");
            System.out.println("5.Pengembalian Barang");
            System.out.println("6.Peminjaman Barang");
            System.out.println("7.Kembali");
            System.out.println("0.Keluar");
            System.out.print("Masukkan pilihan Anda : ");
            choice = s.nextInt();

            switch(choice){
                case 1:
                    if(file2.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file2));
                        al2 = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        System.out.println("-------------------------------------");
                        li = al2.listIterator();
                        System.out.println("============DAFTAR BARANG=============");
                        System.out.println("ID || Nama || Jenis || Jumlah || Kondisi");
                        while(li.hasNext())
                            System.out.println(li.next());
                        System.out.println("-------------------------------------");
                    }else{
                        System.out.println("File not Exists....!");
                    }
                    break;
                case 2:
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
                    break;
                case 3:
                    if(file2.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file2));
                        al2 = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        Collections.sort(al2, new Comparator<Barang>(){
                            public int compare(Barang e1, Barang e2){
                                return e1.ID_Barang - e2.ID_Barang;
                            }
                        });

                        System.out.println("-------------------------------------");
                        li = al2.listIterator();
                        while(li.hasNext())
                            System.out.println(li.next());
                        System.out.println("-------------------------------------");
                    }else{
                        System.out.println("Data tidak ditemukan");
                    }
                    break;
                case 4:
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
                    break;
                case 5:
                    if(file2.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file2));
                        al2 = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        boolean found = false;
                        li = al2.listIterator();
                        while(li.hasNext()){
                            Barang e = (Barang)li.next();
                            if(e.Status == Status){
                                System.out.println(e);
                                found = true;
                            }
                        }
                        if(!found) {
                            System.out.print("Enter ID_Barang untuk dikembalikan: ");
                            int ID_Barang = s.nextInt();
                            while(li.hasNext()){
                                Barang e = (Barang)li.next();
                                if(e.ID_Barang == ID_Barang){
                                    System.out.println(e);
                                    System.out.println("Enter jumlah barang untuk dikembalikan: ");
                                    int jumlah = s.nextInt();
                                    if (jumlah>e.Jumlah) {
                                        System.out.println("Anda mengisi jumlah pengembalian barang yang tidak valid");
                                    } else {
                                        e.Jumlah = e.Jumlah+jumlah;
                                        e.Status = "Tersedia";
                                        li.set(new Barang(e.ID_Barang,e.Nama,e.Jenis,e.Jumlah,e.Kondisi, e.Status));
                                    }
                                }
                            }
                        }
                        System.out.println("-------------------------------------");
                    }else{
                        System.out.println("Data tidak ditemukan....!");
                    }
                    break;
                case 6:
                    if(file2.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file2));
                        al2 = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        boolean found = false;
                        li = al2.listIterator();
                        while(li.hasNext()){
                            Barang e = (Barang)li.next();
                            if(e.Status == Status){
                                System.out.println(e);
                                found = true;
                            }
                        }
                        if(!found) {
                            System.out.print("Enter ID_Barang untuk dipinjam: ");
                            int ID_Barang = s.nextInt();
                            while(li.hasNext()){
                                Barang e = (Barang)li.next();
                                if(e.ID_Barang == ID_Barang){
                                    System.out.println(e);
                                    System.out.println("Enter jumlah barang untuk dipinjam: ");
                                    int jumlah = s.nextInt();
                                    if (e.Jumlah<jumlah) {
                                        System.out.println("Anda melewati batas jumlah peminjaman barang");
                                    } else {
                                        e.Jumlah = e.Jumlah-jumlah;
                                        if (e.Jumlah==jumlah) {
                                            e.Status = "Kosong";
                                        }
                                        li.set(new Barang(e.ID_Barang,e.Nama,e.Jenis,e.Jumlah,e.Kondisi, e.Status));
                                    }
                                }
                            }
                        }
                        System.out.println("-------------------------------------");
                    }else{
                        System.out.println("Data tidak ditemukan....!");
                    }
                    break;
                case 7:
                    AksiMahasiswa AMhs = new AksiMahasiswa();
                    AMhs.HalamanAutentikasi();
                    break;
            }
        }while(choice!=0);
    }


    public void kelolaBarang() throws IOException, ClassNotFoundException, InterruptedException {
        int choice = -1;
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

        do{
            System.out.println("\n\n\n\n==============SELAMAT DATANG DI HALAMAN ADMIN===========");
            System.out.println("1.Lihat Data Barang");
            System.out.println("2.Tambah Data Barang");
            System.out.println("3.Hapus Data Barang");
            System.out.println("4.Ubah Data Barang");
            System.out.println("5.Kembali");
            System.out.println("0.Keluar");
            System.out.print("Masukkan pilihan Anda : ");
            choice = s.nextInt();

            switch(choice){
                case 1:
                    if(file2.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file2));
                        al2 = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        System.out.println("-------------------------------------");
                        li = al2.listIterator();
                        System.out.println("============DAFTAR BARANG=============");
                        System.out.println("ID || Nama || Jenis || Jumlah || Kondisi");
                        while(li.hasNext())
                            System.out.println(li.next());
                        System.out.println("-------------------------------------");
                    }else{
                        System.out.println("File not Exists....!");
                    }
                    break;
                case 2:
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

                        al2.add(new Barang(ID_Barang,Nama,Jenis,Jumlah,Kondisi,Status));
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file2));
                    oos.writeObject(al2);
                    oos.close();
                    break;
                case 3:
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
                    break;
                case 4:
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

                                System.out.print("Enter Status Barang yang baru : ");
                                String Status = s1.nextLine();

                                li.set(new Barang(ID_Barang,Nama,Jenis,Jumlah,Kondisi, Status));
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
                break;
                case 5:
                    Thread.sleep(1000);
                    AMhs.clearConsole();
                    choice = 0;
                    AMhs.HalamanAutentikasi();
                    break;
            }
        }while(choice!=0);
    }


}



