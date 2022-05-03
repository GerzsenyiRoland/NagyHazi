import java.util.ArrayList;
import java.util.Collection;
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
            }else if(a==2){italok.remove(tor(italok));
            }else if (a==3){iratItal(italok);
            }else if (a==4){receptek.add(addRecept(italok));
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

    public static int help(int k, String u){
        while(true){
        System.out.print("Adja meg a "+u+" kivánt sorszámát:");
            try {
                int j = sc.nextInt();
                if (j<=k&& j >0){return j-1;}else{System.out.println();System.out.println("A felsorort számokból válaszon!");}
            } catch (Exception e) {System.out.println("");System.out.println("Számot adjon meg!");}
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

    public static int tor(ArrayList<Ital> a){
            iratItal(a);
            return help(a.size(),"törölni");
    }

    public static void iratItal(ArrayList<Ital> a){
        for (int i=0;i< a.size();i++){
            System.out.println(i+1+"."+a.get(i).toString());
        }
    }

    public static Recept addRecept(ArrayList<Ital> a){
        System.out.println("Adja meg a recept nevét: ");
        String na =sc.next();
        ArrayList<Ital> hoz = new ArrayList<Ital>();
        while (true){
            iratItal(a);
            int c = help(a.size(),"recepthez hozáadni");
            if (hoz.contains(a.get(c))){
                System.out.println("Ez már benne van a receptbe");
            }else{hoz.add(a.get(c));}
            if (hoz.size()>2){
                System.out.println("1.Ujabb hozzávaló hozáadása");
                System.out.println("2.Kilépés");
                System.out.print("Valaszon:");
                int h = help(2, "következő lépésének");
                if (h+1==2){
                    Recept z = new Recept(na, hoz);
                    return z;
                }
            }
        }
    }
}
