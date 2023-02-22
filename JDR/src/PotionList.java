import java.util.ArrayList;
import java.util.List;

public class PotionList {
    private List<Potion> potions;

    public PotionList() {
        potions = new ArrayList<>();
        potions.add(new Potion("Potion de soin mineure",0,0,0,10, Rarete.COMMON));
        potions.add(new Potion("Potion de soin majeure",0,0,0,20, Rarete.UNCOMMON));
        potions.add(new Potion("Potion de résistance aux dégâts",0,7,0,0, Rarete.RARE));
        potions.add(new Potion("Potion de vitesse",0,0,8,0, Rarete.RARE));
        potions.add(new Potion("Potion de soin royale",0,0,0,25, Rarete.EPIC));
        potions.add(new Potion("Potion de force",15,0,0,0, Rarete.EPIC));
        potions.add(new Potion("Potion d'invinsibilité",0,50,0,100, Rarete.LEGENDARY));
    }

    public List<Potion> getPotion() {
        return potions;
    }

    public Potion getPotion(int index) {
        if (index >= 0 && index < potions.size()) {
            return potions.get(index);
        }
        return null;
    }
}
