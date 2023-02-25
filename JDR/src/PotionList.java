import java.util.ArrayList;
import java.util.List;

public class PotionList {
    private static List<Potion> potions;

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

    public static Potion getPotion(int index) {
        if (index >= 0 && index < potions.size()) {
            return potions.get(index);
        }
        return null;
    }

    public Potion choisirPotion() {
        List<Potion> communes = new ArrayList<>();
        List<Potion> peuCommunes = new ArrayList<>();
        List<Potion> rares = new ArrayList<>();
        List<Potion> epiques = new ArrayList<>();
        List<Potion> legendaires = new ArrayList<>();

        for (Potion potion : potions) {
            switch (potion.getRarete()) {
                case COMMON:
                    communes.add(potion);
                    break;
                case UNCOMMON:
                    peuCommunes.add(potion);
                    break;
                case RARE:
                    rares.add(potion);
                    break;
                case EPIC:
                    epiques.add(potion);
                    break;
                case LEGENDARY:
                    legendaires.add(potion);
                    break;
                default:
                    break;
            }
        }

        double rareteAleatoire = Math.random();
        if (rareteAleatoire < 0.6) { // 60% de chance d'obtenir une potion commune ou peu commune
            List<Potion> potionsDisponibles = new ArrayList<>(communes);
            potionsDisponibles.addAll(peuCommunes);
            int indexPotionAleatoire = (int) (Math.random() * potionsDisponibles.size());
            return potionsDisponibles.get(indexPotionAleatoire);
        } else if (rareteAleatoire < 0.9) { // 30% de chance d'obtenir une potion rare ou épique
            List<Potion> potionsDisponibles = new ArrayList<>(rares);
            potionsDisponibles.addAll(epiques);
            int indexPotionAleatoire = (int) (Math.random() * potionsDisponibles.size());
            return potionsDisponibles.get(indexPotionAleatoire);
        } else { // 10% de chance d'obtenir une potion légendaire
            int indexPotionAleatoire = (int) (Math.random() * legendaires.size());
            return legendaires.get(indexPotionAleatoire);
        }
    }
}
