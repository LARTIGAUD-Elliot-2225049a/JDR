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
        artefacts.add(new Artefact("/gamemode 0 ", 100,  100, 100, Rarete.LEGENDARY));
    }

    public List<Artefact> getArtefacts() {
        return artefacts;
    }

    public Artefact getArtefact(int index) {
        if (index >= 0 && index < artefacts.size()) {
            return artefacts.get(index);
        }
        return null;
    }
}
