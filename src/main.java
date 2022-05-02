import java.util.ArrayList;
import java.util.Scanner;

public class main{
     static Scanner sc = new Scanner(System.in);

     public static void main(String agrs[]){
        String kezdo[] = {"1.Ital hozzáadása","2.Ital törlése","3.Italok kilisztázása","4.Recept létrehozáse","5.Recept törlése","6.Receptek kilistázása","7.Kilépés és mentés","8.Kilépés mentés nélkül"};
        ArrayList<Ital> italok = new ArrayList<Ital>();
        ArrayList<Recept> receptek = new ArrayList<Recept>();
        while(true){
            int a = segit(kezdo);
            if (a==1){italok.add(addItal());
            }else if(a==2){
            }else if (a==3){iratItal(italok);
            }else if (a==4){
            }else if (a==5){
            }else if (a==6){
            }else if (a==7){
            }else if (a==8){}
        }
    }
    

    public static int segit(String ku[]){
        for (int i=0;i<ku.length;i++){
            System.out.println(ku[i]);
        }
        while (true){
            System.out.print("Adja meg a választását: ");
            try{
            int a = sc.nextInt();
            if (a<=ku.length-1 && a >0){return a;} else{System.out.println("A felsorolt számokból adjon meg.");}
            }catch(Exception a){System.out.println("Számotadjon meg!");}
        }
    }

    public static Ital addItal(){
        while (true){
            System.out.println("Adja meg az ital nevét fajtáját és fokát alsó vonásal elválasztva'_'.(Pl:Borsodi_Ipa_4)");
            String dod = sc.next();
            String dodo[] = dod.split("_");
            if (dodo.length<3){System.out.println("Nem adot meg elég adatot vagy helytelen formátumot használt.");}else{
                try{
                    Ital u = new Ital(dodo[0],dodo[1], Double.parseDouble(dodo[2]));
                    return u;
                }catch(Exception a){System.out.println("Számot adjon meg az utolsó adatnak.");}
            }

        }
    }

    public static void iratItal(ArrayList<Ital> a){
        for (int i=0;i< a.size();i++){
            System.out.println(a.get(i).toString());
        }
    }
}
