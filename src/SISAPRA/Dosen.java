package SISAPRA;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Dosen extends Pengguna implements Serializable {
    private String NIDN;

    public Dosen(String namaDepan, String namaBelakang, String jk, String NIDN) {
        super(namaDepan, namaBelakang, jk);
        this.NIDN = NIDN;
    }

    public Dosen(){
    }
    
    //Setter
    public void setNIDN(String NIDN){
        this.NIDN = NIDN;
    }
    
    //Getter
    public String getNIDN(){
        return NIDN;
    }
}

class AksiDosen implements ITFAutentikasi {

    public AksiDosen() {
    }

    public static void clearConsole() throws IOException, InterruptedException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void Beranda() throws IOException, ClassNotFoundException, InterruptedException {
        Barang brg = new Barang();
        brg.lihatBarang();
    }

    public static void BerandaAdmin() throws IOException, ClassNotFoundException, InterruptedException {
        BarangKelola brg = new BarangKelola();
        brg.kelolaBarang();
    }

    public static void HalamanAutentikasi() throws IOException, ClassNotFoundException, InterruptedException {
        int choice = -1;
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file = new File("AutentikasiDosen.txt");
        ArrayList<Dosen> al = new ArrayList<>();
        Pengguna p = new Pengguna();
        Dosen mhs = new Dosen();

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Dosen>) ois.readObject();
            ois.close();
        }
        do {
            System.out.println("===========SILAKAN LOGIN ATAU REGISTER============");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("0.Keluar");
            System.out.print("\nMasukkan pilihan Anda : ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    AksiDosen.clearConsole();
                    Register();
                    break;

                case 2:
                    AksiDosen.clearConsole();
                    Login(choice);
                    choice = 0;
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Inputan anda tidak valid!\n");
                    choice = 1;
            }

        } while (choice != 0);
    }

    public static void Login(int choice) throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file = new File("AutentikasiDosen.txt");
        ArrayList<Dosen> al = new ArrayList<>();
        Pengguna p = new Pengguna();
        Dosen dsn = new Dosen();

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if (file.isFile()) {

            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList) ois.readObject();
            ois.close();

            System.out.println("Username : ");
            String username = s1.nextLine();
            System.out.println("Password : ");
            String password = s1.nextLine();
            System.out.println("-------------------------------------");
            li = al.listIterator();

            while (li.hasNext()) {
                Dosen pk = (Dosen) li.next();
                pk.setNamaDepan(username);
                try {
                    if (pk.getNamaDepan().equals(username) && pk.getNIDN().equals(password)) {
                        System.out.println("Login Berhasil");
                        Thread.sleep(1000);
                        clearConsole();
                        Beranda();
                        choice = 0;
                        break;
                    } else if (username.equals("admin123") && password.equals("admin123")) {
                        System.out.println("Login Berhasil");
                        Thread.sleep(1000);
                        clearConsole();
                        BerandaAdmin();
                        choice = 0;
                        break;
                    } else {
                        int i = li.nextIndex();
                        int j = i + 1;
                        if (i == j) ;
                    }
                } catch (NullPointerException | InterruptedException e) {
                    System.out.println(pk.getNamaDepan() + " " + pk.getNIDN());
                    System.out.println(e);
                }

            }
            System.out.println("Login tidak berhasil\n\n");
        }
    }

    public static void Register() throws IOException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file = new File("AutentikasiDosen.txt");
        ArrayList<Dosen> al = new ArrayList<>();
        Pengguna p = new Pengguna();
        Dosen dsn = new Dosen();

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        System.out.print("Enter Nama Depan : ");
        String NamaD = s1.nextLine();

        System.out.print("Enter Nama Belakang : ");
        String NamaB = s1.nextLine();

        System.out.print("Enter Jenis Kelamin (L/P) : ");
        String jk = s1.nextLine();

        Jenis_Kelamin jkl = Jenis_Kelamin.valueOf(Jenis_Kelamin.class,jk);

        System.out.print("Enter NIDN : ");
        String NIDN = s1.nextLine();

        al.add(new Dosen(NamaD, NamaB, Jenis_Kelamin.getVal(jkl), NIDN));

        dsn.setNamaDepan(NamaD);
        dsn.setNamaBelakang(NamaB);
        dsn.setJk(jk);
        dsn.setNIDN(NIDN);

        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(al);
        oos.close();
    }

    public static void daftarDosen() throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("AutentikasiDosen.txt");
        ArrayList<Dosen> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Dosen>)ois.readObject();
            ois.close();

            System.out.println("-------------------------------------");
            li = al2.listIterator();
            System.out.println("============DAFTAR PENGGGUNA DOSEN============");
            System.out.println("Nama Depan || Nama Belakang || Jenis Kelamin");
            while(li.hasNext())
                System.out.println(li.next());
            System.out.println("-------------------------------------");
        }else{
            System.out.println("File not Exists....!");
        }
    }
}
