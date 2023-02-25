import java.util.ArrayList;

public class Inventaire {
    private ArrayList<Arme> armes;
    private ArrayList<Artefact> artefacts;
    private ArrayList<Potion> potions;

    public Inventaire() {
        armes = new ArrayList<Arme>();
        artefacts = new ArrayList<Artefact>();
        potions = new ArrayList<Potion>();
    }

    public ArrayList<Arme> getArme() {
        return armes;
    }

    public ArrayList<Artefact> getArtefact() {
        return artefacts;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void ajouterArme(Arme arme) {
        if (armes.size() < 2) {
            armes.add(arme);
            System.out.println("L'arme " + arme.getNom() + " a été ajoutée à l'inventaire !");
        } else {
            System.out.println("L'inventaire d'armes est plein !");
        }
    }

    public void ajouterArtefact(Artefact artefact) {
        if (artefacts.size() < 3) {
            artefacts.add(artefact);
            System.out.println("L'artefact " + artefact.getNom() + " a été ajouté à l'inventaire !");
        } else {
            System.out.println("L'inventaire d'artefacts est plein !");
        }
    }

    public void ajouterPotion(Potion potion) {
        if (potions.size() < 5) {
            potions.add(potion);
            System.out.println(potion.getNom() + " a été ajoutée à l'inventaire !");
        } else {
            System.out.println("L'inventaire de potions est plein !");
        }
    }

    public void enleverArme(Arme arme) {
        if (armes.contains(arme)) {
            armes.remove(arme);
            System.out.println("L'arme " + arme.getNom() + " a été enlevée de l'inventaire !");
        } else {
            System.out.println("L'arme " + arme.getNom() + " n'est pas dans l'inventaire !");
        }
    }

    public void enleverArtefact(Artefact artefact) {
        if (artefacts.contains(artefact)) {
            artefacts.remove(artefact);
            System.out.println("L'artefact " + artefact.getNom() + " a été enlevé de l'inventaire !");
        } else {
            System.out.println("L'artefact " + artefact.getNom() + " n'est pas dans l'inventaire !");
        }
    }

    public void enleverPotion(Potion potion) {
        if (potions.contains(potion)) {
            potions.remove(potion);
            System.out.println(potion.getNom() + " a été enlevée de l'inventaire !");
        } else {
            System.out.println(potion.getNom() + " n'est pas dans l'inventaire !");
        }
    }


    // Méthode pour afficher le contenu de l'inventaire
    public void afficherInventaire() {
        System.out.println("Armes :");
        if (armes.size() == 0) {
            System.out.println("Aucune arme");
        } else {
            for (Arme arme : armes) {
                System.out.println(arme.getNom() + " - Attaque : " + arme.getAttaque() + " - Défense : " + arme.getDefense() + " - Vitesse : " + arme.getVitesse() + " - Rareté : " + arme.getRarete() );
            }
        }
        System.out.println("Artefacts :");
        if (artefacts.size() == 0) {
            System.out.println("Aucun artefact");
        } else {
            for (Artefact artefact : artefacts) {
                System.out.println(artefact.getNom() + " - Attaque : " + artefact.getAttaque() + " - Défense : " + artefact.getDefense() + " - Vitesse : " + artefact.getVitesse() + " - Rareté : " + artefact.getRarete() );
            }
        }
        System.out.println("Potions :");
        if (potions.size() == 0) {
            System.out.println("Aucune potion");
        } else {
            for (Potion potion : potions) {
                System.out.println(potion.getNom() + " - Attaque : " + potion.getAttaque() + " - Défense : " + potion.getDefense() + " - Vitesse : " + potion.getVitesse() + " - Vie : " + potion.getVie() + " - Rareté : " + potion.getRarete() );
            }
        }
    }
}
