import org.junit.Assert;
import org.junit.Test;

import java.util.AbstractQueue;
import java.util.HashMap;

import static org.junit.Assert.*;

public class PorteMonnaieTest {

    PorteMonnaie p1;
    PorteMonnaie p2;
    public void buildup() throws UniteDistincteException {
        p1=new PorteMonnaie();
        p2=new PorteMonnaie();
        p2.ajouteSomme(new SommeArgent(10,"$"));
    }
    @Test
    public  void testToString() throws UniteDistincteException {
        this.buildup();
        assertEquals("10$",this.p2.toString());
        p2.ajouteSomme(new SommeArgent(5,"£"));
        assertEquals("5£|10$",this.p2.toString());
    }
    @Test
    public void testEquals() throws UniteDistincteException {
        buildup();
        Assert.assertEquals(null,null);
        Assert.assertNotEquals(null,p2);
        assertNotEquals(p2, p1);
    }
    @Test
    public void testAddSomme() throws UniteDistincteException {
        buildup();
        p1.ajouteSomme(new SommeArgent(5,"$"));
        p1.ajouteSomme(new SommeArgent(5,"$"));
        assertEquals(this.p1, this.p2);
        p1.ajouteSomme(new SommeArgent(10,"£"));
        assertNotEquals(p1,p2);
    }

}