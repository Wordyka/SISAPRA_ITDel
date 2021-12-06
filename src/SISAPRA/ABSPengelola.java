package SISAPRA;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ABSPengelola {
    public abstract void tambahBarang() throws IOException, ClassNotFoundException;

    public abstract void hapusBarang() throws IOException, ClassNotFoundException;

    public abstract void ubahBarang() throws IOException, ClassNotFoundException;
}
