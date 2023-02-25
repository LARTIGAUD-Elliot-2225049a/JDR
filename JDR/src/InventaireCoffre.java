import java.util.ArrayList;

public class InventaireCoffre {
    private static ArrayList<Arme> armes;
    private ArrayList<Artefact> artefacts;
    private ArrayList<Potion> potions;

    public InventaireCoffre() {
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

    public void ajouterArmeCoffre(Arme arme) {
        if (armes.size() < 3) {
            armes.add(arme);
            System.out.println("L'arme " + arme.getNom() + " a été ajoutée au coffre !");
        } else {
            System.out.println("Le coffre et plein !");
        }
    }

    public void ajouterArtefactCoffre(Artefact artefact) {
        if (artefacts.size() < 3) {
            artefacts.add(artefact);
            System.out.println("L'artefact " + artefact.getNom() + " a été ajouté au coffre !");
        } else {
            System.out.println("Le coffre et plein  !");
        }
    }

    public void ajouterPotionCoffre(Potion potion) {
        if (potions.size() < 3) {
            potions.add(potion);
            System.out.println(potion.getNom() + " a été ajoutée au coffre !");
        } else {
            System.out.println("LLe coffre et plein  !");
        }
    }
    public void ajouterArmeCoffreText(Arme arme) {
        if (armes.size() < 1) {
            armes.add(arme);
        } else {
            System.out.println("Le coffre et plein !");
        }
    }

    public void ajouterArtefactCoffreText(Artefact artefact) {
        if (artefacts.size() < 1) {
            artefacts.add(artefact);
        } else {
            System.out.println("Le coffre et plein  !");
        }
    }

    public void ajouterPotionCoffreText(Potion potion) {
        if (potions.size() < 1) {
            potions.add(potion);
        } else {
            System.out.println("LLe coffre et plein  !");
        }
    }
    public void enleverArmeCoffre(Arme arme) {
        if (armes.contains(arme)) {
            armes.remove(arme);
            System.out.println("L'arme " + arme.getNom() + " a été enlevée du coffre !");
        } else {
            System.out.println("L'arme " + arme.getNom() + " n'est pas dans le coffre !");
        }
    }

    public void enleverArtefactCoffre(Artefact artefact) {
        if (artefacts.contains(artefact)) {
            artefacts.remove(artefact);
            System.out.println("L'artefact " + artefact.getNom() + " a été enlevé ddu coffre !");
        } else {
            System.out.println("L'artefact " + artefact.getNom() + " n'est pas dans le coffre!");
        }
    }

    public void enleverPotionCoffre(Potion potion) {
        if (potions.contains(potion)) {
            potions.remove(potion);
            System.out.println(potion.getNom() + " a été enlevée du coffre !");
        } else {
            System.out.println(potion.getNom() + " n'est pas dans le coffre !");
        }
    }
    public void viderInventaireCoffre() {
        armes.clear();
        artefacts.clear();
        potions.clear();
    }

    // Méthode pour afficher le contenu de l'inventaire
    public void afficherInventaireCoffre() {
        if (armes.size() == 0) {
            System.out.println("Aucune arme");
        } else {
            for (Arme arme : armes) {
                System.out.println(arme.getNom() + " - Attaque : " + arme.getAttaque() + " - Défense : " + arme.getDefense() + " - Vitesse : " + arme.getVitesse() + " - Rareté : " + arme.getRarete() );
            }
        }
        if (artefacts.size() == 0) {
            System.out.println("Aucun artefact");
        } else {
            for (Artefact artefact : artefacts) {
                System.out.println(artefact.getNom() + " - Attaque : " + artefact.getAttaque() + " - Défense : " + artefact.getDefense() + " - Vitesse : " + artefact.getVitesse() + " - Rareté : " + artefact.getRarete() );
            }
        }
        if (potions.size() == 0) {
            System.out.println("Aucune potion");
        } else {
            for (Potion potion : potions) {
                System.out.println(potion.getNom() + " - Attaque : " + potion.getAttaque() + " - Défense : " + potion.getDefense() + " - Vitesse : " + potion.getVitesse() + " - Vie : " + potion.getVie() + " - Rareté : " + potion.getRarete() );
            }
        }
    }
}


