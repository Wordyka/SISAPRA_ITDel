package Pengguna;

public class Mahasiswa extends Pengguna{
    private String NIM;
    private String Prodi;
    private String Angkatan;

    // constructor



    public Mahasiswa(String namaDepan, String namaBelakang, String jk, String NIM, String prodi, String angkatan) {
        super();
        this.NIM = NIM;
        this.Prodi = prodi;
        this.Angkatan = angkatan;
    }



    public Mahasiswa() {
    }

    // setter

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public void setProdi(String Prodi) {
        this.Prodi = Prodi;
    }

    public void setAngkatan(String Angkatan) {
        this.Angkatan = Angkatan;
    }


    // getter

    public String getNIM() {
        return NIM;
    }

    public String getProdi() {
        return Prodi;
    }

    public String getAngkatan() {
        return Angkatan;
    }


}
