import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;;

public class test {
    @Before
        Ital f1 = new Ital("Borsodi", "Sor", 4);
        Ital f2 = new Ital("Dreher","Sor",4);
        ArrayList<Ital> f3 = new ArrayList<Ital>();
        Recept f4;


    @Test
    public void test(){
            f3.add(f1);
            f3.add(f2);
            f4 = new Recept("Sorkombo", f3);
            assertEquals("Hiba", "Sor", f1.getFajta());
            assertEquals("Hiba", "Sorkombo",f4.getName());
            assertEquals("Hiba", "Sor", f2.getFajta());
    }
}
