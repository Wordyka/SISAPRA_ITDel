package SISAPRA;

import java.io.*;
import java.util.*;


class Mahasiswa extends Pengguna implements Serializable{
        private String namaDepan;
        private String namaBelakang;
        private String jk;
        private String NIM;
        private String prod;
        private String Angkatan;

        public void setNIM(String NIM) {
            this.NIM = NIM;
        }

        public void setProdi(String prod) {
            this.prod = prod;
        }

        public void setAngkatan(String angkatan) {
            Angkatan = angkatan;
        }

        @Override
        public void setNamaDepan(String namaDepan) {
            this.namaDepan = namaDepan;
        }

        @Override
        public void setNamaBelakang(String namaBelakang) {
            this.namaBelakang = namaBelakang;
        }

        @Override
        public void setJk(String jk) {
            this.jk = jk;
        }

        public String getNIM() {
            return NIM;
        }

        public String getProdi() {
            return prod;
        }

        public String getAngkatan() {
            return Angkatan;
        }

        @Override
        public String getNamaDepan() {
            return namaDepan;
        }

        @Override
        public String getNamaBelakang() {
            return namaBelakang;
        }

        @Override
        public String getJk() {
            return jk;
        }

        public Mahasiswa() {
        }

        public Mahasiswa(String namaD, String namaB, String jkl, String NIM, String prod, String angkatan) {
            super(namaD, namaB, jkl);
            this.NIM = NIM;
            this.prod = prod;
            this.Angkatan = angkatan;
        }

}


class AksiMahasiswa implements ITFAutentikasi{

    public AksiMahasiswa() {
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
        File file = new File("AutentikasiMahasiswa.txt");
        ArrayList<Mahasiswa> al = new ArrayList<>();
        Pengguna p = new Pengguna();
        Mahasiswa mhs = new Mahasiswa();

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Mahasiswa>) ois.readObject();
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
                    AksiMahasiswa.clearConsole();
                    Register();
                    break;

                case 2:
                    AksiMahasiswa.clearConsole();
                    Login(choice);
                    choice = 0;
                    break;
                default:
                    System.out.println("Inputan anda tidak valid!\n");
                    choice = 1;
            }

        } while (choice != 0);
    }


    public static void Login(int choice) throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file = new File("Autentikasi.txt");
        ArrayList<Mahasiswa> al = new ArrayList<>();
        Pengguna p = new Pengguna();
        Mahasiswa mhs = new Mahasiswa();

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
                Mahasiswa pk = (Mahasiswa) li.next();
                pk.setNamaDepan(username);
                try {
                    if (pk.getNamaDepan().equals(username) && pk.getNIM().equals(password)) {
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
                    System.out.println(pk.getNamaDepan() + " " + pk.getNIM());
                    System.out.println(e);
                }

            }
            System.out.println("Login tidak berhasil\n\n");
        }
    }


    public static void Register() throws IOException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file = new File("AutentikasiMahasiswa.txt");
        ArrayList<Mahasiswa> al = new ArrayList<>();
        Pengguna p = new Pengguna();
        Mahasiswa mhs = new Mahasiswa();

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

        System.out.print("Enter NIM : ");
        String NIM = s1.nextLine();

        System.out.print("Enter Program Studi : ");
        String prodi = s1.nextLine();

        Prodi progdi = Prodi.valueOf(Prodi.class,prodi);

        System.out.print("Enter Angkatan : ");
        String angkatan = s1.nextLine();

        al.add(new Mahasiswa(NamaD, NamaB, Jenis_Kelamin.getVal(jkl), NIM, Prodi.getVal(progdi), angkatan));

        mhs.setNamaDepan(NamaD);
        mhs.setNamaBelakang(NamaB);
        mhs.setJk(jk);
        mhs.setNIM(NIM);
        mhs.setProdi(prodi);
        mhs.setAngkatan(angkatan);

        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(al);
        oos.close();
    }

    public static void daftarMahasiswa() throws IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        File file2 = new File("Autentikasi.txt");
        ArrayList<Mahasiswa> al2 = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al2 = (ArrayList<Mahasiswa>)ois.readObject();
            ois.close();

            System.out.println("-------------------------------------");
            li = al2.listIterator();
            System.out.println("============DAFTAR PENGGGUNA MAHASISWA============");
            System.out.println("Nama Depan || Nama Belakang || Jenis Kelamin");
            while(li.hasNext())
                System.out.println(li.next());
            System.out.println("-------------------------------------");
        }else{
            System.out.println("File not Exists....!");
        }
    }
}





