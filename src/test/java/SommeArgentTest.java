import org.junit.Assert;
import org.junit.Test;

public class SommeArgentTest {

    private SommeArgent m12CHF;
    private SommeArgent m14CHF;
    private SommeArgent m14USD;



    public void  buildup(int id){
        System.out.println(id+"ieme passage avant exécution de la méthode de test");
        this.m12CHF= new SommeArgent(12, "CHF");
        this.m14CHF= new SommeArgent(14, "CHF");
        this.m14USD= new SommeArgent(14, "USD");

    }

    public void destory(int id){
        System.out.println(id+"ieme passage après l'execution de la méthode de test");
    }

    @Test
    public void testerSomme() throws UniteDistincteException {
        buildup(1);
        SommeArgent expected = new SommeArgent(26, "CHF");
        SommeArgent result = this.m12CHF.add(this.m14CHF); // (2)
        Assert.assertEquals(expected, result); // (3)
        destory(1);
    }

    @Test
    public void testerEquals(){
        buildup(2);
        Assert.assertFalse(this.m12CHF.equals(null));
        Assert.assertEquals(this.m12CHF, this.m12CHF);
        Assert.assertEquals(this.m12CHF, new SommeArgent(12, "CHF")); // (1)
        Assert.assertFalse(this.m12CHF.equals(this.m14CHF));
        //tester que la méthode equals() prend en considération la différence d'unité
        Assert.assertFalse(this.m14USD.equals(this.m14CHF));
        destory(2);
    }

    @Test(expected = UniteDistincteException.class)
    public void testerAdd() throws UniteDistincteException {
        buildup(3);
        this.m12CHF.add(this.m14USD);
    }
}