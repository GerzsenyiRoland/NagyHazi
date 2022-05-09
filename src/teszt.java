
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
public class teszt {
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
