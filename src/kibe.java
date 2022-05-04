import java.io.*;
import java.util.ArrayList;

public class kibe implements Serializable {
    public static void kiItal(ArrayList<Ital> a){
        try {
            FileOutputStream f = new FileOutputStream("Ital.txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(a);
            out.close();
        }catch(Exception ex){System.out.println("Hiba!!");}
    }

    public static void kiRecept(ArrayList<Recept> a){
        try {
            FileOutputStream f = new FileOutputStream("Recept.txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(a);
            out.close();
        }catch(Exception ex){System.out.println("Hiba!!");}
    }

    public static ArrayList<Ital> beItal(){
        ArrayList<Ital> k = new ArrayList<Ital>();
        try {
            FileInputStream f = new FileInputStream("Ital.txt");
            ObjectInputStream in = new ObjectInputStream(f);
            k = (ArrayList<Ital>)in.readObject();
            in.close();
            return k;
        } catch(IOException ex) {System.out.println("Hiba!!");
        } catch (ClassNotFoundException e) {System.out.println("Hiba!");}
        return k;
    }

    public static ArrayList<Recept> beRecept(){
        ArrayList<Recept> k = new ArrayList<Recept>();
        try {
            FileInputStream f = new FileInputStream("Recept.txt");
            ObjectInputStream in = new ObjectInputStream(f);
            k = (ArrayList<Recept>)in.readObject();
            in.close();
            return k;
        } catch(IOException ex) {System.out.println("Hiba!!");
        } catch (ClassNotFoundException e) {System.out.println("Hiba!");}
        return k;
    }
    
}
