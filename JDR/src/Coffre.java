import java.util.Random;

public class Coffre {
    private Arme arme;
    private Potion potion;
    private Artefact artefact;

    public Coffre() {
        Random rand = new Random();

        // Ajoute une arme aléatoire en fonction de la rareté
        ArmesList armeList = new ArmesList();
        Rarete rareteArme = Rarete.values()[rand.nextInt(Rarete.values().length)];
        for (Arme a : armeList.getArmes()) {
            if (a.getRarete() == rareteArme) {
                arme = a;
                break;
            }
        }

        // Ajoute une potion aléatoire en fonction de la rareté
        PotionList potionList = new PotionList();
        Rarete raretePotion = Rarete.values()[rand.nextInt(Rarete.values().length)];
        for (Potion p : potionList.getPotion()) {
            if (p.getRarete() == raretePotion) {
                potion = p;
                break;
            }
        }

        // Ajoute un artefact aléatoire en fonction de la rareté
        ArtefactList artefactList = new ArtefactList();
        Rarete rareteArtefact = Rarete.values()[rand.nextInt(Rarete.values().length)];
        for (Artefact a : artefactList.getArtefacts()) {
            if (a.getRarete() == rareteArtefact) {
                artefact = a;
                break;
            }
        }
    }

    public Arme getArme() {
        return arme;
    }

    public Potion getPotion() {
        return potion;
    }

    public Artefact getArtefact() {
        return artefact;
    }
}
