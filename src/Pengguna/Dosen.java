package Pengguna;

public class Dosen {
    private String NIDN;
    
    public Dosen(String NIDN){
        this.NIDN = NIDN;
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
