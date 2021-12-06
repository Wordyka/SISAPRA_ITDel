package SISAPRA;

import java.io.IOException;

public abstract class ABSPengguna {
    public abstract void lihatDaftarBarang() throws IOException, ClassNotFoundException, InterruptedException;

    public abstract void lihatJenis() throws IOException, ClassNotFoundException;

    public abstract void cekKondisi() throws IOException, ClassNotFoundException;

    public abstract void saringData() throws IOException, ClassNotFoundException;

    public abstract void urutData() throws IOException, ClassNotFoundException;

    public abstract void lihatDaftarRuangan() throws IOException, ClassNotFoundException;

    public abstract void cariBarang() throws IOException, ClassNotFoundException;

}
