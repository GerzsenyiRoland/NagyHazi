import java.io.*;
import java.util.ArrayList;

public class kibe implements Serializable {
    public static void kiItal(ArrayList<Ital> a){
        try {
            FileOutputStream f = new FileOutputStream("Ital.txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(a);
            out.close();
            f.close();
        }catch(Exception ex){System.out.print("1");}
    }

    public static void kiRecept(ArrayList<Recept> a){
        try {
            FileOutputStream f = new FileOutputStream("Recept.txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(a);
            out.close();
            f.close();
        }catch(Exception ex){System.out.print("2");}
    }

    public static ArrayList<Ital> beItal(){
        ArrayList<Ital> k = new ArrayList<Ital>();
        try {
            FileInputStream f = new FileInputStream(new File("Ital.txt"));
            ObjectInputStream in = new ObjectInputStream(f);
            k = (ArrayList<Ital>)in.readObject();
            in.close();
            f.close();
            return k;
        } catch(IOException ex) {System.out.print("3");
        } catch (ClassNotFoundException e) {System.out.print("4");}
        return k;
    }

    public static ArrayList<Recept> beRecept(){
        ArrayList<Recept> k = new ArrayList<Recept>();
        try {
            FileInputStream f = new FileInputStream(new File("Recept.txt"));
            ObjectInputStream in = new ObjectInputStream(f);
            k = (ArrayList<Recept>)in.readObject();
            in.close();
            f.close();
            return k;
        } catch(IOException ex) {System.out.print("5");
        } catch (ClassNotFoundException e) {System.out.print("6");}
        return k;
    }
    
}
