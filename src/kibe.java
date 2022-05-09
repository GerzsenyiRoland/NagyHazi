import java.io.*;
import java.util.ArrayList;

public class kibe implements Serializable {
    //A kiItal medódus meg kapja a italokat és ki irja a 'Ital.txt' file-ba.
    public static void kiItal(ArrayList<Ital> italok){
        try {
            FileOutputStream f = new FileOutputStream("Ital.txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(italok);
            out.close();
            f.close();
        }catch(Exception ex){System.out.print("A kiiratásal hiba történt.");}
    }

    //A kiRecept medódus meg kapja a recepteket és ki irja a 'Recept.txt' file-ba.
    public static void kiRecept(ArrayList<Recept> recept){
        try {
            FileOutputStream f = new FileOutputStream("Recept.txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(recept);
            out.close();
            f.close();
        }catch(Exception ex){System.out.print("A ki iratásal hiba történt");}
    }

    //A beItal medódus meg nyitja a 'Ital.txt' file-t és benne lévő adator ki olvasa és átadja egy ArrayLista által.
    public static ArrayList<Ital> beItal(){
        ArrayList<Ital> italok = new ArrayList<Ital>();
        try {
            FileInputStream f = new FileInputStream(new File("Ital.txt"));
            ObjectInputStream in = new ObjectInputStream(f);
            italok = (ArrayList<Ital>)in.readObject();
            in.close();
            f.close();
            return italok;
        } catch(IOException ex) {System.out.print("Nem sikerült a beolvasása");
        } catch (ClassNotFoundException e) {System.out.print("Nem tatálható a 'Ital.txt' file.");}
        return italok;
    }

    //A beRecept medódus meg nyitja a 'Recept.txt' file-t és benne lévő adator ki olvasa és átadja egy ArrayLista által.
    public static ArrayList<Recept> beRecept(){
        ArrayList<Recept> recept = new ArrayList<Recept>();
        try {
            FileInputStream f = new FileInputStream(new File("Recept.txt"));
            ObjectInputStream in = new ObjectInputStream(f);
            recept = (ArrayList<Recept>)in.readObject();
            in.close();
            f.close();
            return recept;
        } catch(IOException ex) {System.out.print("Nem sikerült a beolvasás");
        } catch (ClassNotFoundException e) {System.out.print("Nem található a 'Recept.txt' file");}
        return recept;
    }
    
}
