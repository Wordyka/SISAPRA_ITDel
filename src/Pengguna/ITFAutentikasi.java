package Pengguna;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ITFAutentikasi {
    public void Login() throws IOException, ClassNotFoundException;
    public void Register() throws IOException, ClassNotFoundException;
}
