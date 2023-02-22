import java.util.ArrayList;
import java.util.List;

public class ArmesList {
    private List<Arme> armes;

    public ArmesList() {
        armes = new ArrayList<>();
        armes.add(new Arme("Épée en bois", 5, 1, 1, Rarete.COMMON));
        armes.add(new Arme("Arc de chasse", 3, 3, 2, Rarete.COMMON));
        armes.add(new Arme("Bouclier en fer", 1, 2, 10, Rarete.UNCOMMON));
        armes.add(new Arme("Hache de guerre", 10, 5, -2, Rarete.UNCOMMON));
        armes.add(new Arme("Épée de la justice", 8, 5, 4, Rarete.RARE));
        armes.add(new Arme("Marteau de guerre", 8, 4, 5, Rarete.RARE));
        armes.add(new Arme("Épée d'Excalibur", 12, 9, 6, Rarete.EPIC));
        armes.add(new Arme("Lance de Longinus", 20, 8, 1, Rarete.EPIC));
        armes.add(new Arme("Mjöllnir", 30, 10, 5, Rarete.LEGENDARY));
    }

    public List<Arme> getArmes() {
        return armes;
    }

    public Arme getArme(int index) {
        if (index >= 0 && index < armes.size()) {
            return armes.get(index);
        }
        return null;
    }
}
