package Pengguna;

public class Pengguna {
    private String namaDepan;
    private String namaBelakang;
    private char jk;

    // constructor

    public Pengguna() {
    }


    // setter

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public void setJk(char jk) {
        this.jk = jk;
    }

    // getter

    public String getNamaDepan() {
        return namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public char getJk() {
        return jk;
    }


    public void Info() {
        System.out.println("Info Pengguna");
    }
}
