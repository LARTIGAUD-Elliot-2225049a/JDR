import java.util.ArrayList;
import java.util.List;


public class ArmesList {
    private List<Arme> armes;

    public ArmesList() {
        armes = new ArrayList<>();
        armes.add(new Arme("Épée en bois", 5, 1, 1, Rarete.COMMON));
        armes.add(new Arme("Arc de chasse", 3, 3, 2, Rarete.COMMON));
        armes.add(new Arme("Bouclier en fer", 1, 10, 1, Rarete.UNCOMMON));
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
    public Arme choisirArme() {
        List<Arme> communes = new ArrayList<>();
        List<Arme> peuCommunes = new ArrayList<>();
        List<Arme> rares = new ArrayList<>();
        List<Arme> epiques = new ArrayList<>();
        List<Arme> legendaires = new ArrayList<>();

        for (Arme arme : armes) {
            switch (arme.getRarete()) {
                case COMMON:
                    communes.add(arme);
                    break;
                case UNCOMMON:
                    peuCommunes.add(arme);
                    break;
                case RARE:
                    rares.add(arme);
                    break;
                case EPIC:
                    epiques.add(arme);
                    break;
                case LEGENDARY:
                    legendaires.add(arme);
                    break;
                default:
                    break;
            }
        }

        double rareteAleatoire = Math.random();
        if (rareteAleatoire < 0.6) { // 60% de chance d'obtenir une arme commune ou peu commune
            List<Arme> armesDisponibles = new ArrayList<>(communes);
            armesDisponibles.addAll(peuCommunes);
            int indexArmeAleatoire = (int) (Math.random() * armesDisponibles.size());
            return armesDisponibles.get(indexArmeAleatoire);
        } else if (rareteAleatoire < 0.9) { // 30% de chance d'obtenir une arme rare ou épique
            List<Arme> armesDisponibles = new ArrayList<>(rares);
            armesDisponibles.addAll(epiques);
            int indexArmeAleatoire = (int) (Math.random() * armesDisponibles.size());
            return armesDisponibles.get(indexArmeAleatoire);
        } else { // 10% de chance d'obtenir une arme légendaire
            int indexArmeAleatoire = (int) (Math.random() * legendaires.size());
            return legendaires.get(indexArmeAleatoire);
        }
    }

}
