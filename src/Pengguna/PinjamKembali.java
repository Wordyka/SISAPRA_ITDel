//package Pengguna;
//
//import java.io.*;
//import java.util.*;
//
//public class PinjamKembali extends Mahasiswa implements ITFAutentikasi, ITFPinjamKembali, Serializable {
//    private String tglPinjam;
//    private String tglKembali;
//    private int Jumlah;
//    private String namaBarang;
//    private String Jenis;
//    private String Keperluan;
//
//    // setter
//
//    public void setTglPinjam(String tglPinjam) {
//        this.tglPinjam = tglPinjam;
//    }
//
//    public void setTglKembali(String tglKembali) {
//        this.tglKembali = tglKembali;
//    }
//
//    public void setJumlah(int jumlah) {
//        Jumlah = jumlah;
//    }
//
//    public void setNamaBarang(String namaBarang) {
//        this.namaBarang = namaBarang;
//    }
//
//    public void setJenis(String jenis) {
//        Jenis = jenis;
//    }
//
//    public void setKeperluan(String keperluan) {
//        Keperluan = keperluan;
//    }
//
//    // getter
//
//    public String getTglPinjam() {
//        return tglPinjam;
//    }
//
//    public String getTglKembali() {
//        return tglKembali;
//    }
//
//    public int getJumlah() {
//        return Jumlah;
//    }
//
//    public String getNamaBarang() {
//        return namaBarang;
//    }
//
//    public String getJenis() {
//        return Jenis;
//    }
//
//    public String getKeperluan() {
//        return Keperluan;
//    }
//
//
//    // constructor
//
//
//
//    public PinjamKembali() {
//
//    }
////        public PinjamKembali(String tglPinjam, String tglKembali, int jumlah, String namaBarang, String jenis, String keperluan) {
////        this.tglPinjam = tglPinjam;
////        this.tglKembali = tglKembali;
////        Jumlah = jumlah;
////        this.namaBarang = namaBarang;
////        Jenis = jenis;
////        Keperluan = keperluan;
////    }
//
//    public PinjamKembali(String namaDepan, String namaBelakang, String jk, String NIM, String prodi, String angkatan) {
//        super(namaDepan, namaBelakang, jk, NIM, prodi, angkatan);
//    }
//
//    @Override
//    public String toString() {
//        return "PinjamKembali{" +
//                "tglPinjam='" + tglPinjam + '\'' +
//                ", tglKembali='" + tglKembali + '\'' +
//                ", Jumlah=" + Jumlah +
//                ", namaBarang='" + namaBarang + '\'' +
//                ", Jenis='" + Jenis + '\'' +
//                ", Keperluan='" + Keperluan + '\'' +
//                '}';
//    }
//
//    @Override
//    public void Login() {
//
//    }
//
//    @Override
//    public void Register() {
//
//    }
//
//    @Override
//    public void Meminjam() {
//
//    }
//
//    @Override
//    public void Mengembalikan() {
//
//    }
//
//
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//        int choice = -1;
//        Scanner s = new Scanner(System.in);
//        Scanner s1 = new Scanner(System.in);
//        File file = new File("Autentikasi.txt");
//        ArrayList<PinjamKembali> al = new ArrayList<PinjamKembali>();
//        ObjectOutputStream oos = null;
//        ObjectInputStream ois = null;
//        ListIterator li = null;
//        if (file.isFile()) {
//            ois = new ObjectInputStream(new FileInputStream(file));
//            try {
//                al = (ArrayList<PinjamKembali>) ois.readObject();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            ois.close();
//        }
//        do {
//            System.out.println("1.Login");
//            System.out.println("2.Register");
//            System.out.println("3.Peminjaman");
//            System.out.println("4.Pengembalian");
//            System.out.println("0.Keluar");
//            System.out.print("Masukkan pilihan Anda : ");
//            choice = s.nextInt();
//
//            switch (choice) {
//                case 1:
//
//                    if (file.isFile()) {
//                        ois = new ObjectInputStream(new FileInputStream(file));
//                        al = (ArrayList) ois.readObject();
//                        ois.close();
//
//                        System.out.println("Username : ");
//                        String username = s1.nextLine();
//                        System.out.println("Password : ");
//                        String password = s1.nextLine();
//                        System.out.println("-------------------------------------");
//                        li = al.listIterator();
//
//                        while (li.hasNext()) {
//                            PinjamKembali pk = (PinjamKembali) li.next();
//                            if (pk.getNamaDepan() == username) {
//                                if (pk.getNIM() == password) {
//                                    System.out.println("Login Berhasil");
//                                }
//                            } else {
//                            }
//                        }
//                    }
//                    break;
//                case 2:
//                    System.out.print("Enter Nama Depan : ");
//                    String NamaD = s1.nextLine();
//
//                    System.out.print("Enter Nama Belakang : ");
//                    String NamaB = s1.nextLine();
//
//                    System.out.print("Enter Jenis Kelamin : ");
//                    String jk = s1.nextLine();
//
//                    System.out.print("Enter NIM : ");
//                    String NIM = s1.nextLine();
//
//                    System.out.print("Enter Program Studi : ");
//                    String prodi = s1.nextLine();
//
//                    System.out.print("Enter Angkatan : ");
//                    String angkatan = s1.nextLine();
//
//                    al.add(new PinjamKembali(NamaD, NamaB, jk, NIM, prodi, angkatan));
//
//                    oos = new ObjectOutputStream(new FileOutputStream(file));
//                    oos.writeObject(al);
//                    oos.close();
//                    break;
//                case 3:
//
//                    if(file.isFile()){
//                        ois = new ObjectInputStream(new FileInputStream(file));
//                        al = (ArrayList<PinjamKembali>)ois.readObject();
//                        ois.close();
//
//                        System.out.println("-------------------------------------");
//                        li = al.listIterator();
//                        System.out.println("============DAFTAR BARANG=============");
//                        System.out.println("ID || Nama || Jenis || Jumlah || Kondisi");
//                        while(li.hasNext())
//                            System.out.println(li.next());
//                        System.out.println("-------------------------------------");
//                    }else{
//                        System.out.println("File not Exists....!");
//                    }
//                    break;
//                case 4:
//
//                    //break;
//            }
//        } while (choice != 0);
//
//    }
//}
