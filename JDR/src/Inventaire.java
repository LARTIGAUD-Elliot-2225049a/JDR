import java.util.ArrayList;
import java.util.Scanner;

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
    public void ajouterArmeText(Arme arme) {
        if (armes.size() < 2) {
            armes.add(arme);
        }
    }

    public void ajouterArtefactText(Artefact artefact) {
        if (artefacts.size() < 3) {
            artefacts.add(artefact);
        }
    }

    public void ajouterPotionText(Potion potion) {
        if (potions.size() < 5) {
            potions.add(potion);
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
    public int getVitesseArtefacts() {
        int totalVitesse = 0;
        for (Artefact artefact : artefacts) {
            totalVitesse += artefact.getVitesse();
        }
        return totalVitesse;
    }
    public int getDefenseArtefacts() {
        int totalDefense = 0;
        for (Artefact artefact : artefacts) {
            totalDefense += artefact.getDefense();
        }
        return totalDefense;
    }
    public int getAttaqueArtefacts() {
        int totalAttaque = 0;
        for (Artefact artefact : artefacts) {
            totalAttaque += artefact.getAttaque();
        }
        return totalAttaque;
    }
    public void boirePotion (Potion potion, Hero hero) {
        System.out.println("Vous avez bu une potion de " + potion.getNom() + " !");
        hero.perdreVie(-potion.getVie());
        hero.gagnerAttaque(potion.getAttaque());
        hero.gagnerDefense(potion.getDefense());
        hero.gagnerVitesse(potion.getVitesse());
        System.out.println("Vie : " + hero.getVie());
    }
    // Méthode pour afficher le contenu de l'inventaire
    public void afficherInventaire() {
        int n =1;
        System.out.println("Armes :");
        if (armes.size() == 0) {
            System.out.println("Aucune arme");
        } else {
            for (int i = 0; i < armes.size(); i++) {
                Arme arme = armes.get(i);
                System.out.println( n + ". " + arme.getNom() + " - Attaque : " + arme.getAttaque() + " - Défense : " + arme.getDefense() + " - Vitesse : " + arme.getVitesse() + " - Rareté : " + arme.getRarete());
                n += 1;
            }
        }
        System.out.println("Artefacts :");
        if (artefacts.size() == 0) {
            System.out.println("Aucun artefact");
        } else {
            for (int i = 0; i < artefacts.size(); i++) {
                Artefact artefact = artefacts.get(i);
                System.out.println( n + ". " + artefact.getNom() + " - Attaque : " + artefact.getAttaque() + " - Défense : " + artefact.getDefense() + " - Vitesse : " + artefact.getVitesse() + " - Rareté : " + artefact.getRarete());
                n += 1;
            }
        }
        System.out.println("Potions :");
        if (potions.size() == 0) {
            System.out.println("Aucune potion");
        } else {
            for (int i = 0; i < potions.size(); i++) {
                Potion potion = potions.get(i);
                System.out.println( n + ". " + potion.getNom() + " - Attaque : " + potion.getAttaque() + " - Défense : " + potion.getDefense() + " - Vitesse : " + potion.getVitesse() + " - Vie : " + potion.getVie() + " - Rareté : " + potion.getRarete());
                n += 1;
            }
        }

        // Demander au joueur s'il veut jeter un objet
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro de l'objet à jeter ou 0 pour fermer l'inventaire:");
        System.out.print("Entrez une commande : ");
        int choix = scanner.nextInt();
        if (choix > 0) {
            System.out.println("Confirmer la suppression de l'objet sélectionné (oui/non) :");
            System.out.print("Entrez une commande : ");
            String confirmation = scanner.next();
            if (confirmation.equalsIgnoreCase("y")) {
                if (choix <= armes.size()) {
                    enleverArme(armes.get(choix - 1));
                } else if (choix <= armes.size() + artefacts.size()) {
                    enleverArtefact(artefacts.get(choix - armes.size() - 1));
                } else {
                    enleverPotion(potions.get(choix - armes.size() - artefacts.size() - 1));
                }
            }
        }
    }
}

