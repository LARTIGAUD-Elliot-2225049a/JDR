import java.util.ArrayList;
import java.util.List;

public class ArtefactList {
    private List<Artefact> artefacts;

    public ArtefactList() {
        artefacts = new ArrayList<>();
        artefacts.add(new Artefact("Amulette de la force", 10, 0, 5, Rarete.COMMON));
        artefacts.add(new Artefact("Chaussures de la rapidité", 0, 10, 2, Rarete.COMMON));
        artefacts.add(new Artefact("Bouclier de la défense", 0, 0, 20, Rarete.UNCOMMON));
        artefacts.add(new Artefact("Casque du savoir", 0, 0, 5, Rarete.UNCOMMON));
        artefacts.add(new Artefact("Anneau de la magie", 5, 5, 5, Rarete.RARE));
        artefacts.add(new Artefact("Amulette du chaos", 20, -5, 10, Rarete.RARE));
        artefacts.add(new Artefact("Bâton de l'ombre", 10, 5, -5, Rarete.EPIC));
        artefacts.add(new Artefact("Bouclier de la lumière", 0, 0, 30, Rarete.EPIC));
        artefacts.add(new Artefact("gamemode 0 ", 100,  100, 100, Rarete.LEGENDARY));
    }

    public Artefact getArtefact(int index) {
        if (index >= 0 && index < artefacts.size()) {
            return artefacts.get(index);
        }
        return null;
    }
    public Artefact choisirArtefact() {
        List<Artefact> communs = new ArrayList<>();
        List<Artefact> peuCommuns = new ArrayList<>();
        List<Artefact> rares = new ArrayList<>();
        List<Artefact> epics = new ArrayList<>();
        List<Artefact> legendaires = new ArrayList<>();

        for (Artefact artefact : artefacts) {
            switch (artefact.getRarete()) {
                case COMMON:
                    communs.add(artefact);
                    break;
                case UNCOMMON:
                    peuCommuns.add(artefact);
                    break;
                case RARE:
                    rares.add(artefact);
                    break;
                case EPIC:
                    epics.add(artefact);
                    break;
                case LEGENDARY:
                    legendaires.add(artefact);
                    break;
                default:
                    break;
            }
        }

        double rareteAleatoire = Math.random();
        if (rareteAleatoire < 0.6) { // 60% de chance d'obtenir un artefact commun ou peu commun
            List<Artefact> artefactsDisponibles = new ArrayList<>(communs);
            artefactsDisponibles.addAll(peuCommuns);
            int indexArtefactAleatoire = (int) (Math.random() * artefactsDisponibles.size());
            return artefactsDisponibles.get(indexArtefactAleatoire);
        } else if (rareteAleatoire < 0.9) { // 30% de chance d'obtenir un artefact rare ou épique
            List<Artefact> artefactsDisponibles = new ArrayList<>(rares);
            artefactsDisponibles.addAll(epics);
            int indexArtefactAleatoire = (int) (Math.random() * artefactsDisponibles.size());
            return artefactsDisponibles.get(indexArtefactAleatoire);
        } else { // 10% de chance d'obtenir un artefact légendaire
            int indexArtefactAleatoire = (int) (Math.random() * legendaires.size());
            return legendaires.get(indexArtefactAleatoire);
        }
    }

}
