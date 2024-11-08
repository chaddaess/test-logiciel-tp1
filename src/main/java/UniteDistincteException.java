public class UniteDistincteException extends Exception {
    private final SommeArgent somme1;
    private final SommeArgent somme2;

    public UniteDistincteException(SommeArgent sa1, SommeArgent sa2) {
        somme1 = sa1;
        somme2 = sa2;
    }

    public String toString() {
        return "unité distincte : " + somme1.getUnite() + " != " + somme2.getUnite();
    }

}

