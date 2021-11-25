/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pengelola;

/**
 *
 * @author Wordyka Nainggolan
 */
import java.util.*;

import java.io.*;

class Barang implements Serializable{
    int ID_Barang;
    String Nama;
    String Jenis;
    int Jumlah;
    String Kondisi;

    public Barang(int ID_Barang, String Nama, String Jenis, int Jumlah, String Kondisi) {
        this.ID_Barang = ID_Barang;
        this.Nama = Nama;
        this.Jenis = Jenis;
        this.Jumlah = Jumlah;
        this.Kondisi = Kondisi;
    }

    @Override
    public String toString(){
        return ID_Barang+" || "+Nama+" || "+Jenis+" || "+Jumlah+" || "+Kondisi;
    }



}
class BarangDemo{
    public static void main(String[] args) throws Exception{
        int choice = -1;
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file = new File("Barang.txt");
        ArrayList<Barang> al = new ArrayList<Barang>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        if(file.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Barang>)ois.readObject();
            ois.close();
        }
        do{
            System.out.println("1.Tambah Data Barang");
            System.out.println("2.Tampilkan Data Barang");
            System.out.println("3.Cari Data Barang");
            System.out.println("4.Hapus Data Barang");
            System.out.println("5.Ubah Data Barang");
            System.out.println("6.Urutkan berdasarkan ID_Barang");
            System.out.println("7.Urutkan berdasarkan Nama");
            System.out.println("0.Keluar");
            System.out.print("Masukkan pilihan Anda : ");
            choice = s.nextInt();

            switch(choice){
                case 1:
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

                        al.add(new Barang(ID_Barang,Nama,Jenis,Jumlah,Kondisi));
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(al);
                    oos.close();
                    break;
                case 2:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        System.out.println("-------------------------------------");
                        li = al.listIterator();
                        System.out.println("============DAFTAR BARANG=============");
                        System.out.println("ID || Nama || Jenis || Jumlah || Kondisi");
                        while(li.hasNext())
                            System.out.println(li.next());
                        System.out.println("-------------------------------------");
                    }else{
                        System.out.println("File not Exists....!");
                    }
                    break;
                case 3:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        boolean found = false;
                        System.out.println("Enter ID Barang untuk dicari : ");
                        int ID_Barang = s.nextInt();
                        System.out.println("-------------------------------------");
                        li = al.listIterator();
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
                case 4:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        boolean found = false;
                        System.out.print("Enter ID Barang untuk dihapus : ");
                        int ID_Barang = s.nextInt();
                        System.out.println("-------------------------------------");
                        li = al.listIterator();
                        while(li.hasNext()){
                            Barang e = (Barang)li.next();
                            if(e.ID_Barang == ID_Barang){
                                li.remove();
                                found = true;
                            }
                        }
                        if(found){
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
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
                case 5:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        boolean found = false;
                        System.out.print("Enter ID_Barang untuk diupdate : ");
                        int ID_Barang = s.nextInt();
                        System.out.println("-------------------------------------");
                        li = al.listIterator();
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

                                li.set(new Barang(ID_Barang,Nama,Jenis,Jumlah,Kondisi));
                                found = true;

                            }
                        }
                        if(found){
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
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
                case 6:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        Collections.sort(al, new Comparator<Barang>(){
                            public int compare(Barang e1, Barang e2){
                                return e1.ID_Barang - e2.ID_Barang;
                            }
                        });

                        System.out.println("-------------------------------------");
                        li = al.listIterator();
                        while(li.hasNext())
                            System.out.println(li.next());
                        System.out.println("-------------------------------------");
                    }else{
                        System.out.println("Data tidak ditemukan");
                    }
                    break;
                case 7:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Barang>)ois.readObject();
                        ois.close();

                        Collections.sort(al, new Comparator<Barang>(){
                            public int compare(Barang e1, Barang e2){
                                return e1.Nama.compareTo(e2.Nama);
                            }
                        });

                        System.out.println("-------------------------------------");
                        li = al.listIterator();
                        while(li.hasNext())
                            System.out.println(li.next());
                        System.out.println("-------------------------------------");
                    }else{
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;
            }
        }while(choice!=0);
    }
}
