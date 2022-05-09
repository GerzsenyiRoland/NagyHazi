import java.io.Serializable;

public class Ital implements Serializable{
    private String name;
    private String fajta;
    private double fok;

    //A Ital medódus létre hoz egy uj Italt.
    public Ital(String na,String faj,double fo) {
        name = na; fajta = faj; fok = fo;
    }

    //A toString medódus vissza adja a italt String formátumba.
    public String toString(){
        return ("Fajtája: "+fajta+", Neve: "+name+", Fokszáma: "+fok);
    }
    
    //A getName medódus vissza adja a ital nevét.
    public String getName(){return name;}

    //A getFajta medódus vissza adja a ital fajtáját.
    public String getFajta(){return fajta;}

    //A getFok medódus vissza adja a ital fokát.
    public double getFok(){return fok;}
}