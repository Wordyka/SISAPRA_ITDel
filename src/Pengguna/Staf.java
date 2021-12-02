package Pengguna;

public class Staf extends Pengguna {
    private String ID_Staf;
    private String Departemen;

    public Staf() {
        super(null,null,null);
    }

    public Staf(String ID_Staf) {
        super(null,null,null);
        this.ID_Staf = ID_Staf;
    }

    public Staf(String ID_Staf, String departemen) {
        super(null,null,null);
        this.ID_Staf = ID_Staf;
        Departemen = departemen;
    }

    public void setID_Staf(String ID_Staf) {
        this.ID_Staf = ID_Staf;
    }

    public void setDepartemen(String departemen) {
        Departemen = departemen;
    }

    public String getID_Staf() {
        return ID_Staf;
    }

    public String getDepartemen() {
        return Departemen;
    }


}