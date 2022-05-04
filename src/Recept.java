import java.util.ArrayList;
import java.io.Serializable;

public class Recept implements Serializable{
    private String name;
    private ArrayList<Ital> hozvalok;
    public Recept(String na,ArrayList<Ital> valo){
        name = na;
        hozvalok = valo;
    }

    public String toString(){
        return name +"_"+ helpToString(hozvalok, hozvalok.size()-1);
    }
    private String helpToString(ArrayList<Ital> hoz,int a){
        if (a==0){
            return hoz.get(a).getName();
        }else{return hoz.get(a).getName()+"_"+helpToString(hoz, a-1);}
    }

    public String getName(){return name;}

    public ArrayList<Ital> getHozvalok(){return hozvalok;}
}