package Pengguna;



import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class PinjamKembali extends Mahasiswa implements ITFAutentikasi, ITFPinjamKembali, Serializable {
    private String tglPinjam;
    private String tglKembali;
    private int Jumlah;
    private String namaBarang;
    private String Jenis;
    private String Keperluan;

    // setter

    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }

    public void setJumlah(int jumlah) {
        Jumlah = jumlah;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setJenis(String jenis) {
        Jenis = jenis;
    }

    public void setKeperluan(String keperluan) {
        Keperluan = keperluan;
    }

    // getter


    public String getTglPinjam() {
        return tglPinjam;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getJenis() {
        return Jenis;
    }

    public String getKeperluan() {
        return Keperluan;
    }

    // constructor


    public PinjamKembali(String namaDepan, String namaBelakang, String jk, String NIM, String prodi, String angkatan) {
        super(namaDepan, namaBelakang, jk, NIM, prodi, angkatan);
    }

    public PinjamKembali() {
    }

    //    public PinjamKembali(String tglPinjam, String tglKembali, int jumlah, String namaBarang, String jenis, String keperluan) {
//        this.tglPinjam = tglPinjam;
//        this.tglKembali = tglKembali;
//        Jumlah = jumlah;
//        this.namaBarang = namaBarang;
//        Jenis = jenis;
//        Keperluan = keperluan;
//    }

    @Override
    public String toString() {
        return "PinjamKembali{" +
                "tglPinjam='" + tglPinjam + '\'' +
                ", tglKembali='" + tglKembali + '\'' +
                ", Jumlah=" + Jumlah +
                ", namaBarang='" + namaBarang + '\'' +
                ", Jenis='" + Jenis + '\'' +
                ", Keperluan='" + Keperluan + '\'' +
                '}';
    }

    @Override
    public void Login() throws IOException, ClassNotFoundException {
//        String username, password;
//
//
//        ois = new ObjectInputStream(new FileInputStream(file));
//        al = (ArrayList)ois.readObject();
//        ois.close();
//        System.out.println("Username : ");
//        username = s.nextLine();
//        System.out.println("Password : ");
//        password = s.nextLine();
//        System.out.println("-------------------------------------");
//        li = al.listIterator();
//
//        while(li.hasNext()) {
//            pk = (PinjamKembali) li.next();
//            if (username == pk.getNamaDepan()) {
//                if(password == pk.getNIM()) {
//                    System.out.println("Login Berhasil");
//                }
//            } else {
//                System.out.println("Login tidak berhasil");
//            }
//        }

    }

    @Override
    public void Register() throws IOException, ClassNotFoundException {

    }


    public void Register(Scanner s1, ArrayList al, File file, ObjectOutputStream oos) throws IOException, ClassNotFoundException {

        // String namaDepan, String namaBelakang, char jk, String NIM, String prodi, String angkatan
        System.out.print("Enter Nama Depan ");
        String NamaDepan = s1.nextLine();

        System.out.print("Enter Nama Belakang ");
        String NamaBelakang = s1.nextLine();

        System.out.print("Enter Jenis Kelamin : ");
        String jk = s1.nextLine();

        System.out.print("Enter NIM : ");
        String NIM = s1.nextLine();

        System.out.print("Enter Program Studi : ");
        String prodi= s1.nextLine();

        System.out.print("Enter Angkatan : ");
        String angkatan = s1.nextLine();

        al.add(new PinjamKembali(NamaDepan,NamaBelakang,jk,NIM,prodi,angkatan));

        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(al);
        oos.close();

    }

    @Override
    public void Meminjam() {

    }

    @Override
    public void Mengembalikan() {

    }

    public static void main(String[] args) throws Exception{

        int choice = 0;
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file = new File("Autentikasi.txt");
        ArrayList<PinjamKembali> al = new ArrayList();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        if(!file.isFile()){
            System.out.println("Data tidak ditemukan....!");
        }

        System.out.println("Pilihan:\n");
        System.out.println("1.Login\n2.Register\n3.Pinjam\n4.Kembali");

        PinjamKembali pk = new PinjamKembali();
        choice = s.nextInt();
        switch (choice) {
            case 1:
                pk.Login();
                break;
            case 2:
                pk.Register(s1,al,file,oos);
                break;
            case 3:

        }

    }

}
