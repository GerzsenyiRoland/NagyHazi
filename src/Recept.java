public class Recept{
    private String name;
    private Ital[] hozvalok;

    public Recept(String na,Ital[] valo){
        name = na;
        hozvalok = valo;
    }

    public String toString(){
        return name + helpToString(hozvalok, hozvalok.length-1);
    }
    private String helpToString(Ital[] hoz,int a){
        if (a==0){
            return hoz[a].getName();
        }else{return hoz[a].getName()+" "+helpToString(hoz, a-1);}
    }

}