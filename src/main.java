import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class main{
     static Scanner sc = new Scanner(System.in);
     //A main medódus a főprogram ami elosztja a a feladatokat.
     public static void main(String agrs[]){
        String kezdo[] = {"1.Ital hozzáadása","2.Ital törlése","3.Italok kilisztázása","4.Recept létrehozáse","5.Recept törlése","6.Receptek kilistázása","7.Kilépés és mentés","8.Kilépés mentés nélkül"};
        ArrayList<Ital> italok = new ArrayList<Ital>(kibe.beItal());
        ArrayList<Recept> receptek = new ArrayList<Recept>(kibe.beRecept());
        while(true){
            int sorszam = fosegit(kezdo);
            if (sorszam==1){italok.add(addItal());
            }else if(sorszam==2){italok.remove(torItal(italok));
            }else if (sorszam==3){iratItal(italok);
            }else if (sorszam==4){receptek.add(addRecept(italok));
            }else if (sorszam==5){receptek.remove(torRecept(receptek));
            }else if (sorszam==6){iratRecept(receptek);
            }else if (sorszam==7){
                kibe.kiItal(italok);
                kibe.kiRecept(receptek);
                break;
            }else if (sorszam==8){break;}
        }
    }

    //fajok medódus meg kapja az italokat és vissza adja egy listába hogy milyen fajta italok vannak.
    public static ArrayList<String> fajok(ArrayList<Ital> italok){
        ArrayList<String> fajok = new ArrayList<String>();
        for (int i=0;i<italok.size();i++){
            if (fajok.contains(italok.get(i).getFajta())){}else{fajok.add(italok.get(i).getFajta());}
        }
        return fajok;
    }

    //fosegit medódus kilistáza a funkciókat és bekéri hogy melyiket szeretné végre hajtani.
    public static int fosegit(String kezdo[]){
        for (int i=0;i<kezdo.length;i++){
            System.out.println(kezdo[i]);
        }
        while (true){
            System.out.print("Adja meg a választását: ");
            try{
            int sorszam = sc.nextInt();
            if (sorszam<=kezdo.length && sorszam >0){return sorszam;} 
            else{System.out.println("A felsorolt számokból adjon meg.");}
            }catch(Exception a){System.out.println("Számotadjon meg!");}
        }
    }

    //help medódus bekér számot és meg nézi hogy meg felelő a paraméterezése és vissza adja a számot.
    public static int help(int length, String koment){
        while(true){
        System.out.print("Adja meg a "+koment+" kivánt sorszámát:");
            try {
                int sorszam = sc.nextInt();
                if (sorszam<=length&& sorszam >0){return sorszam-1;}
                else{System.out.println();System.out.println("A felsorort számokból válaszon!");}
            } catch (Exception e) {System.out.println("");System.out.println("Számot adjon meg!");}
        }
    }

    //addItal medódus beolvas egy sort (Név_Fajta_Fok) formátumba és meg töri a '_' mentén és ezek vissza adja Ital ként.
    public static Ital addItal(){
        String hibakezelés = sc.nextLine();
        while (true){
            System.out.println("Adja meg az ital nevét fajtáját és fokát alsó vonásal elválasztva'_'.(Pl:Borsodi Ipa_Sör_4)");
            String sor = sc.nextLine();
            System.out.println(sor);
            String sortort[] = sor.split("_");
            if (sortort.length<3 || sortort.length >3){
                System.out.println("Helytelen formátumot adott meg.");
            }else{
                try{
                    return new Ital(sortort[0],sortort[1], Double.parseDouble(sortort[2]));
                }catch(Exception a){System.out.println("Számot adjon meg az utolsó adatnak.");}
            }
        }
    }
    /*torItal medódus meg kapja az italokat és azokat kiiratja a 'iratItal' medótusal 
    és a help medódusal bekér egy számot és visszaadja azt a számot */
    public static int torItal(ArrayList<Ital> italok){
            iratItal(italok);
            return help(italok.size(),"törölni");
    }

    //A segitIratItal medódus meg kapja a italokat ki iratja a fajtákat és abból bekéri az egyiket és vissza adja a fajtát.
    public static String segitIratItal(ArrayList<Ital> italok){
        ArrayList<String> fajta = new ArrayList<String>(fajok(italok));
        for (int u=0;u<fajta.size();u++){
            System.out.println(u+1+"."+fajta.get(u));
        }
        System.out.println(fajta.size()+1+"."+"Mindet");
        int melyikfajta = help(fajta.size()+1, "tipust");
        if (fajta.size() == melyikfajta){return "Mind";}else{return fajta.get(melyikfajta);}
    }

    public static void ir(ArrayList<Ital> italok,String fajta){
        int sorszam1 = 1;
        System.out.println("");
        if (fajta=="Mind"){for (int i=0;i<italok.size();i++){System.out.println(i+1+"."+italok.get(i).toString());}
        }else {for (int i=0;i< italok.size();i++){
                if (fajta.equals(italok.get(i).getFajta())){
                    System.out.println(sorszam1+"."+italok.get(i).toString());
                    sorszam1++;
                }
            }
        }
        System.out.println("");
    }

    //iratItal medódus meg hivja a 'segitIratItal' medódus és az abból kapot fajtát iratja átadja a 'ir' medódusnak.
    public static void iratItal(ArrayList<Ital> italok){
        String melyikfajta = segitIratItal(italok);
        ir(italok, melyikfajta);
    }

    //A ItalVissza medódus ki iratja a italokat és be kér egy sorszámot és azt a italt vissza adja.
    public static Ital Italvissza(ArrayList<Ital> italok){
        String melyikfajta = segitIratItal(italok);
        ir(italok, melyikfajta);
        int sorszam = help(italok.size(),"recepthez hozáadni")+1;
        int sorszam1=0;
        for (int i = 0;i<italok.size();i++){
            if (italok.get(i).getFajta().equals(melyikfajta)){
                sorszam1++;
                if (sorszam==sorszam1){return italok.get(i);}
            }
        }
        return null;
    }

    /*A addRecept medódus bekéri a recept nevét, és utána kilistáza a az italokat a iratItal medódusal
    utána meg kérdi hogy melyik italt adja hozzá és ha van már benn olyan akkor kér egy másikat 
    és legalább két italnak kell benne szerepelnie*/
    public static Recept addRecept(ArrayList<Ital> italok){
        System.out.println("Adja meg a recept nevét: ");
        String receptnev =sc.next();
        ArrayList<Ital> hozzavalok = new ArrayList<Ital>();
        while (true){
            Ital ital = Italvissza(italok);
            if (hozzavalok.contains(ital)){
                System.out.println("Ez már benne van a receptbe");
            }else{hozzavalok.add(ital);}
            if (hozzavalok.size()>=2){
                System.out.println("1.Ujabb hozzávaló hozáadása");
                System.out.println("2.Kilépés");
                int h = help(2, "következő lépésének");
                if (h+1==2){
                    return new Recept(receptnev, hozzavalok);
                }
            }
        }
    }

    //A torRecept kiiratatja a recepteket a 'iratRecept' medódusal és be kéri a törölni kévánt recept sorszámát és vissza adja azt
    public static int torRecept(ArrayList<Recept> recept){
        iratRecept(recept);
        return help(recept.size(), "törölni");
    }

    //A iratRecept medódus kiirja a képernyőre a recepteket.
    public static void iratRecept(ArrayList<Recept> recept){
        if (recept.size() == 0 ){System.out.println("Nincs recept");
        }else{
            for (int i=0;i<recept.size();i++){
                String sor = recept.get(i).toString();
                String sortor[]=sor.split("_");
                System.out.println("");
                System.out.println(i+1+" Neve: "+sortor[0]);
                System.out.println("Hozávalók:");
                for (int u=1;u<sortor.length;u++){System.out.println(sortor[u]);}
                System.out.println(" ");
            }
        }
    }  

    @Test
    public void test(){
        Ital f1 = new Ital("Borsodi", "Sor", 4);
        Ital f2 = new Ital("Dreher","Sor",4);
        ArrayList<Ital> f3 = new ArrayList<Ital>();
        Recept f4; 

        f3.add(f1);
        f3.add(f2);
        f4 = new Recept("Sorkombo", f3);
        assertEquals("Hiba", "Sor", f1.getFajta());
        assertEquals("Hiba", "Sorkombo",f4.getName());
        assertEquals("Hiba", 4,0, f2.getFok());
        assertEquals("Hiba", "Borsodi", f1.getName());
        assertEquals("Hiba", f1,f4.getHozvalok().get(0));
        assertEquals("Hiba", f2,f4.getHozvalok().get(1));
    }
}
