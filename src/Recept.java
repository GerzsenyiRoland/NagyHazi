import java.util.ArrayList;
import java.io.Serializable;

public class Recept implements Serializable{
    private String name;
    private ArrayList<Ital> hozvalok;

    //A Recept medódus létre hoz egy új receptet a meg kapot paraméterekel.
    public Recept(String na,ArrayList<Ital> valo){
        name = na;
        hozvalok = valo;
    }
    //A toString medódus vissza adja a receptet egy Stringként '_'-kal elválasztva.
    public String toString(){
        return name +"_"+ helpToString(hozvalok, hozvalok.size()-1);
    }

    //A helpToString egy rekurziv metódus ami vissza adja a italokat egybe füzve.
    private String helpToString(ArrayList<Ital> hozavalok,int hossz){
        if (hossz==0){
            return hozavalok.get(hossz).getName();
        }else{return hozavalok.get(hossz).getName()+"_"+helpToString(hozavalok, hossz-1);}
    }

    //A getName medódus vissza adja a recept nevét.
    public String getName(){return name;}

    //A getHozvalok medódus vissza adj a hozzavalokat egy listába.
    public ArrayList<Ital> getHozvalok(){return hozvalok;}
}