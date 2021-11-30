package Pengguna;

public class Pengguna {
    private String namaDepan;
    private String namaBelakang;
    private String jk;

    // constructor

    public Pengguna(String namaDepan, String namaBelakang, String jk) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.jk = jk;
    }

    public Pengguna() {

    }


    // setter

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    // getter

    public String getNamaDepan() {
        return namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public String getJk() {
        return jk;
    }

    public void Info() {
        System.out.println("Info Pengguna");
    }
}
