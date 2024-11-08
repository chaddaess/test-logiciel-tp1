import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PorteMonnaie {
    private HashMap<String, Integer> contenu;
    public HashMap<String, Integer> getContenu() {
        return contenu;
    }
    public PorteMonnaie() {
        contenu = new HashMap<String, Integer>();
    }
    public void ajouteSomme(SommeArgent sa) throws UniteDistincteException {
        if(!contenu.containsKey(sa.getUnite())){
            contenu.put(sa.getUnite(),sa.getQuantite());
        }else{
            for (Map.Entry<String,Integer> c:contenu.entrySet()){
                if(Objects.equals(c.getKey(), sa.getUnite())){
                    SommeArgent sum=sa.add(new SommeArgent(c.getValue(),c.getKey()));
                    c.setValue(sum.getQuantite());
                    break;
                }
            }
        }

    }
    public String toString(){
        StringBuilder s= new StringBuilder();
        for (Map.Entry<String,Integer> c:contenu.entrySet()){
            SommeArgent sa=new SommeArgent(c.getValue(),c.getKey());
            s.append(sa.toString());
            s.append("|");
        }
        s.delete(s.length()-1,s.length());
        return s.toString();
    }
    public boolean equals(Object obj) {
        for (Map.Entry<String, Integer> c : contenu.entrySet()) {
            if (!((PorteMonnaie) obj).contenu.containsKey(c.getKey()) || !Objects.equals(((PorteMonnaie) obj).contenu.get(c.getKey()), c.getValue())) {
                return false;
            }
        }
        return true;
    }
}