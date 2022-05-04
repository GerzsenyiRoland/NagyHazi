import java.io.Serializable;

public class Ital implements Serializable{
    private String name;
    private String fajta;
    private double fok;

    public Ital(String na,String faj,double fo) {
        name = na; fajta = faj; fok = fo;
    }

    public String toString(){
        return ("Fajtája: "+fajta+", Neve: "+name+", Fokszáma: "+fok);
    }
    
    public String getName(){return name;}

    public String getFajta(){return fajta;}

    public double getFok(){return fok;}
}