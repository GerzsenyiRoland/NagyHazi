import java.util.ArrayList;
import java.util.Scanner;

public class main{
     Scanner sc = new Scanner(System.in);

     public void main(String agrs[]){
        ArrayList<Ital> italok = new ArrayList<Ital>();
        ArrayList<Recept> receptek = new ArrayList<Recept>();
        italok = addItal(italok);
    }

    public int segit(int k){
        while (true){
            System.out.println("Adja meg a választását");
            try{
            int a = sc.nextInt();
            if (a<=k){return a;} else{System.out.println("A felsorolt számokból adjon meg.");}
            }catch(Exception a){System.out.println("Számotadjon meg!");}
        }
    }

    public ArrayList<Ital> addItal(ArrayList<Ital> hoz){
        while (true){
            System.out.println("Adja meg az ital nevét fajtáját és fokát alsó vonásal elválasztva'_'.(Pl:Borsodi_Ipa_4)");
            String dod = sc.nextLine();
            String dodo[] = dod.split("_");
            if (dodo.length<3){System.out.println("Nem adot meg elég adatot vagy helytelen formátumot használt.");}else{
                try{
                    Ital u = new Ital(dodo[0],dodo[1], Double.parseDouble(dodo[2]));
                    hoz.add(u);
                    return hoz;
                }catch(Exception a){System.out.println("Számot adjon meg az utolsó adatnak.");}
            }

        }
    }
}
