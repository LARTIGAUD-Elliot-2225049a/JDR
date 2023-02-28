import java.util.ArrayList;
import java.util.Scanner;
public class Combat {
    private ArrayList<Arme> armes;
    private ArrayList<Potion> potion;
    private Hero hero;
    private Monstre monstre;
    private Scanner scanner;
    public Combat(Hero hero, Monstre monstre, ArrayList<Arme> armes, ArrayList<Potion> potions, Scanner scanner) {
        this.hero = hero;
        this.monstre = monstre;
        this.armes = armes;
        this.potion = potions;
        this.scanner = new Scanner(System.in);
    }
    public void start(Inventaire inventaire) {
        if (armes.size() >= 2) {
            System.out.println("Un combat débute contre un Monstre de niveaux "+ monstre.getNiv() +" !");
            // Demander au héros de choisir arme 1 ou arme 2
            System.out.println("Choisissez votre arme :");
            System.out.println("1. " + inventaire.getArme().get(0).getNom() + " - Attaque : " + inventaire.getArme().get(0).getAttaque() + " - Défense : " + inventaire.getArme().get(0).getDefense() + " - Vitesse : " + inventaire.getArme().get(0).getVitesse() + " - Rareté : " + inventaire.getArme().get(0).getRarete());
            System.out.println("2. " + inventaire.getArme().get(1).getNom() + " - Attaque : " + inventaire.getArme().get(1).getAttaque() + " - Défense : " + inventaire.getArme().get(1).getDefense() + " - Vitesse : " + inventaire.getArme().get(1).getVitesse() + " - Rareté : " + inventaire.getArme().get(1).getRarete());

            System.out.print("Entrez une commande : ");
            int choixArme = scanner.nextInt();
            Arme armeChoisie = inventaire.getArme().get(choixArme - 1);
            System.out.println("Vous avez choisi l'arme " + armeChoisie.getNom() + " - Attaque : " + armeChoisie.getAttaque() + " - Défense : " + armeChoisie.getDefense() + " - Vitesse : " + armeChoisie.getVitesse() + " - Rareté : " + armeChoisie.getRarete());
            // Boucle de combat
            while (hero.getVie() > 0 || monstre.getVie() > 0) {
                // Détermine qui joue en premier

                if (hero.getVitesse() + armeChoisie.getVitesse() + inventaire.getVitesseArtefacts() >
                        monstre.getVitesse()) {
                    // Tour du héros
                    System.out.println("Vous :                   Monstre niv "+monstre.getNiv());
                    System.out.println("Vie :"+ hero.getVie()+"                  Vie :"+ monstre.getVie());
                    System.out.println("Attaque :"+ (hero.getAttaque()+armeChoisie.getAttaque()+inventaire.getAttaqueArtefacts())+"              Attaque :"+monstre.getAttaque());
                    System.out.println("Defense :"+ (hero.getDefense()+armeChoisie.getDefense()+inventaire.getDefenseArtefacts())+"              Defense :"+monstre.getDefense());
                    System.out.println("Vitesse :"+ (hero.getVitesse()+armeChoisie.getVitesse()+inventaire.getVitesseArtefacts())+"              Vitesse :"+monstre.getVitesse());
                    System.out.println("À vous de jouer !");
                    System.out.println("1. Attaquer");
                    System.out.println("2. Utiliser une potion");
                    System.out.print("Entrez une commande : ");
                    int choixAction = scanner.nextInt();
                    if (choixAction == 1) {
                        int degats = hero.getAttaque() + armeChoisie.getAttaque() +
                                inventaire.getAttaqueArtefacts() - monstre.getDefense();
                        degats = Math.max(degats, 0);
                        System.out.println("Vous infligez " + degats + " points de dégâts !");
                        monstre.perdreVie(degats);

                        if (monstre.getVie() <= 0) {
                            continue;
                        }
                        // Tour du monstre
                        degats = monstre.getAttaque() - (hero.getDefense()+armeChoisie.getDefense()+inventaire.getDefenseArtefacts());
                        degats = Math.max(degats, 0);
                        System.out.println("Le monstre vous inflige " + degats + " points de dégâts !");
                        hero.perdreVie(degats);
                        continue;
                    }
                    else if (choixAction == 2) {
                        if (potion.size() <= 0) {
                            System.out.println("Aucune Potion dans votre inventaire");
                            continue;
                        }

                        if (potion.size() == 1) {
                            inventaire.getPotions();
                            Potion PotionChoisie = inventaire.getPotions().get(0);
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            inventaire.boirePotion(potion.get(0), hero);
                            inventaire.enleverPotion(potion.get(0));
                        }
                        if (potion.size() == 2) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 3) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 4) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.println("4. " + inventaire.getPotions().get(3).getNom() + " - Attaque : " + inventaire.getPotions().get(3).getAttaque() + " - Défense : " + inventaire.getPotions().get(3).getDefense() + " - Vitesse : " + inventaire.getPotions().get(3).getVitesse() + " - Vie: " + inventaire.getPotions().get(3).getVie() + " - Rareté : " + inventaire.getPotions().get(3).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 5) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.println("4. " + inventaire.getPotions().get(3).getNom() + " - Attaque : " + inventaire.getPotions().get(3).getAttaque() + " - Défense : " + inventaire.getPotions().get(3).getDefense() + " - Vitesse : " + inventaire.getPotions().get(3).getVitesse() + " - Vie: " + inventaire.getPotions().get(3).getVie() + " - Rareté : " + inventaire.getPotions().get(3).getRarete());
                            System.out.println("5. " + inventaire.getPotions().get(4).getNom() + " - Attaque : " + inventaire.getPotions().get(4).getAttaque() + " - Défense : " + inventaire.getPotions().get(4).getDefense() + " - Vitesse : " + inventaire.getPotions().get(4).getVitesse() + " - Vie: " + inventaire.getPotions().get(4).getVie() + " - Rareté : " + inventaire.getPotions().get(4).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        int degats = monstre.getAttaque() - hero.getDefense();
                        degats = Math.max(degats, 0);
                        System.out.println("Le monstre vous inflige " + degats + " points de dégâts !");
                        hero.perdreVie(degats);
                        continue;
                    }

                }
                else {
                    // Tour du monstre
                    int degats = monstre.getAttaque() - (hero.getDefense()+armeChoisie.getDefense()+inventaire.getDefenseArtefacts());
                    degats = Math.max(degats, 0);
                    System.out.println("Le monstre vous inflige " + degats + " points de dégâts !");
                    hero.perdreVie(degats);
                    if (hero.getVie() <= 0) {
                        System.out.println("Vous avez perdu...");
                        System.exit(0);
                    }
                    // Tour du héros
                    System.out.println("Vous :                   Monstre niv "+monstre.getNiv());
                    System.out.println("Vie :"+ hero.getVie()+"                  Vie :"+ monstre.getVie());
                    System.out.println("Attaque :"+ (hero.getAttaque()+armeChoisie.getAttaque()+inventaire.getAttaqueArtefacts())+"              Attaque :"+monstre.getAttaque());
                    System.out.println("Defense :"+ (hero.getDefense()+armeChoisie.getDefense()+inventaire.getDefenseArtefacts())+"              Defense :"+monstre.getDefense());
                    System.out.println("Vitesse :"+ (hero.getVitesse()+armeChoisie.getVitesse()+inventaire.getVitesseArtefacts())+"              Vitesse :"+monstre.getVitesse());
                    System.out.println("1. Attaquer");
                    System.out.println("2. Utiliser une potion");
                    System.out.print("Entrez une commande : ");
                    int choixAction = scanner.nextInt();
                    if (choixAction == 1) {
                        degats = hero.getAttaque() + armeChoisie.getAttaque() + inventaire.getAttaqueArtefacts() - monstre.getDefense();
                        degats = Math.max(degats, 0);
                        System.out.println("Vous infligez " + degats + " points de dégâts !");
                        monstre.perdreVie(degats);

                    } else if (choixAction == 2) {
                        if (potion.size() <= 0) {
                            System.out.println("Aucune Potion dans votre inventaire");
                            continue;
                        }

                        if (potion.size() == 1) {
                            inventaire.getPotions();
                            Potion PotionChoisie = inventaire.getPotions().get(0);
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            inventaire.boirePotion(potion.get(0), hero);
                            inventaire.enleverPotion(potion.get(0));
                        }
                        if (potion.size() == 2) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 3) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 4) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.println("4. " + inventaire.getPotions().get(3).getNom() + " - Attaque : " + inventaire.getPotions().get(3).getAttaque() + " - Défense : " + inventaire.getPotions().get(3).getDefense() + " - Vitesse : " + inventaire.getPotions().get(3).getVitesse() + " - Vie: " + inventaire.getPotions().get(3).getVie() + " - Rareté : " + inventaire.getPotions().get(3).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 5) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.println("4. " + inventaire.getPotions().get(3).getNom() + " - Attaque : " + inventaire.getPotions().get(3).getAttaque() + " - Défense : " + inventaire.getPotions().get(3).getDefense() + " - Vitesse : " + inventaire.getPotions().get(3).getVitesse() + " - Vie: " + inventaire.getPotions().get(3).getVie() + " - Rareté : " + inventaire.getPotions().get(3).getRarete());
                            System.out.println("5. " + inventaire.getPotions().get(4).getNom() + " - Attaque : " + inventaire.getPotions().get(4).getAttaque() + " - Défense : " + inventaire.getPotions().get(4).getDefense() + " - Vitesse : " + inventaire.getPotions().get(4).getVitesse() + " - Vie: " + inventaire.getPotions().get(4).getVie() + " - Rareté : " + inventaire.getPotions().get(4).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                    }
                }
            }
        }
        else {
            System.out.println("Un combat débute contre un Monstre de niveaux "+ monstre.getNiv() +" !");
            while (hero.getVie() > 0 || monstre.getVie() > 0) {
                Arme armeChoisie = inventaire.getArme().get(0);
                if (hero.getVitesse() + armeChoisie.getVitesse() + inventaire.getVitesseArtefacts() >
                        monstre.getVitesse()) {
                    // Tour du héros
                    System.out.println("Vous :                   Monstre niv "+monstre.getNiv());
                    System.out.println("Vie :"+ hero.getVie()+"                  Vie :"+ monstre.getVie());
                    System.out.println("Attaque :"+ (hero.getAttaque()+armeChoisie.getAttaque()+inventaire.getAttaqueArtefacts())+"              Attaque :"+monstre.getAttaque());
                    System.out.println("Defense :"+ (hero.getDefense()+armeChoisie.getDefense()+inventaire.getDefenseArtefacts())+"              Defense :"+monstre.getDefense());
                    System.out.println("Vitesse :"+ (hero.getVitesse()+armeChoisie.getVitesse()+inventaire.getVitesseArtefacts())+"              Vitesse :"+monstre.getVitesse());
                    System.out.println("1. Attaquer");
                    System.out.println("2. Utiliser une potion");
                    System.out.print("Entrez une commande : ");
                    int choixAction = scanner.nextInt();
                    if (choixAction == 1) {
                        int degats = hero.getAttaque() + armeChoisie.getAttaque() +
                                inventaire.getAttaqueArtefacts() - monstre.getDefense();
                        degats = Math.max(degats, 0);
                        System.out.println("Vous infligez " + degats + " points de dégâts !");
                        monstre.perdreVie(degats);

                        if (monstre.getVie() <= 0) {
                            continue;
                        }
                        // Tour du monstre
                        degats = monstre.getAttaque() - (hero.getDefense()+armeChoisie.getDefense()+inventaire.getDefenseArtefacts());
                        degats = Math.max(degats, 0);
                        System.out.println("Le monstre vous inflige " + degats + " points de dégâts !");
                        hero.perdreVie(degats);
                        continue;
                    } else if (choixAction == 2) {
                        if (potion.size() <= 0) {
                            System.out.println("Aucune Potion dans votre inventaire");
                            continue;
                        }

                        if (potion.size() == 1) {
                            inventaire.getPotions();
                            Potion PotionChoisie = inventaire.getPotions().get(0);
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            inventaire.boirePotion(potion.get(0), hero);
                            inventaire.enleverPotion(potion.get(0));
                        }
                        if (potion.size() == 2) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 3) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 4) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.println("4. " + inventaire.getPotions().get(3).getNom() + " - Attaque : " + inventaire.getPotions().get(3).getAttaque() + " - Défense : " + inventaire.getPotions().get(3).getDefense() + " - Vitesse : " + inventaire.getPotions().get(3).getVitesse() + " - Vie: " + inventaire.getPotions().get(3).getVie() + " - Rareté : " + inventaire.getPotions().get(3).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 5) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.println("4. " + inventaire.getPotions().get(3).getNom() + " - Attaque : " + inventaire.getPotions().get(3).getAttaque() + " - Défense : " + inventaire.getPotions().get(3).getDefense() + " - Vitesse : " + inventaire.getPotions().get(3).getVitesse() + " - Vie: " + inventaire.getPotions().get(3).getVie() + " - Rareté : " + inventaire.getPotions().get(3).getRarete());
                            System.out.println("5. " + inventaire.getPotions().get(4).getNom() + " - Attaque : " + inventaire.getPotions().get(4).getAttaque() + " - Défense : " + inventaire.getPotions().get(4).getDefense() + " - Vitesse : " + inventaire.getPotions().get(4).getVitesse() + " - Vie: " + inventaire.getPotions().get(4).getVie() + " - Rareté : " + inventaire.getPotions().get(4).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        int degats = monstre.getAttaque() - hero.getDefense();
                        degats = Math.max(degats, 0);
                        System.out.println("Le monstre vous inflige " + degats + " points de dégâts !");
                        hero.perdreVie(degats);
                        continue;
                    }
                } else {
                    // Tour du monstre
                    int degats = monstre.getAttaque() - (hero.getDefense()+armeChoisie.getDefense()+inventaire.getDefenseArtefacts());
                    degats = Math.max(degats, 0);
                    System.out.println("Le monstre vous inflige " + degats + " points de dégâts !");
                    hero.perdreVie(degats);
                    if (hero.getVie() <= 0) {
                        System.out.println("Vous avez perdu...");
                        System.exit(0);
                    }
                    // Tour du héros
                    System.out.println("Vous :                   Monstre niv "+monstre.getNiv());
                    System.out.println("Vie :"+ hero.getVie()+"                  Vie :"+ monstre.getVie());
                    System.out.println("Attaque :"+ (hero.getAttaque()+armeChoisie.getAttaque()+inventaire.getAttaqueArtefacts())+"              Attaque :"+monstre.getAttaque());
                    System.out.println("Defense :"+ (hero.getDefense()+armeChoisie.getDefense()+inventaire.getDefenseArtefacts())+"              Defense :"+monstre.getDefense());
                    System.out.println("Vitesse :"+ (hero.getVitesse()+armeChoisie.getVitesse()+inventaire.getVitesseArtefacts())+"              Vitesse :"+monstre.getVitesse());
                    System.out.println("1. Attaquer");
                    System.out.println("2. Utiliser une potion");
                    System.out.print("Entrez une commande : ");
                    int choixAction = scanner.nextInt();
                    if (choixAction == 1) {
                        degats = hero.getAttaque() + armeChoisie.getAttaque() + inventaire.getAttaqueArtefacts() - monstre.getDefense();
                        degats = Math.max(degats, 0);
                        System.out.println("Vous infligez " + degats + " points de dégâts !");
                        monstre.perdreVie(degats);

                    } else if (choixAction == 2) {
                        if (potion.size() <= 0) {
                            System.out.println("Aucune Potion dans votre inventaire");
                            continue;
                        }

                        if (potion.size() == 1) {
                            inventaire.getPotions();
                            Potion PotionChoisie = inventaire.getPotions().get(0);
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            inventaire.boirePotion(potion.get(0), hero);
                            inventaire.enleverPotion(potion.get(0));
                        }
                        if (potion.size() == 2) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 3) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 4) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.println("4. " + inventaire.getPotions().get(3).getNom() + " - Attaque : " + inventaire.getPotions().get(3).getAttaque() + " - Défense : " + inventaire.getPotions().get(3).getDefense() + " - Vitesse : " + inventaire.getPotions().get(3).getVitesse() + " - Vie: " + inventaire.getPotions().get(3).getVie() + " - Rareté : " + inventaire.getPotions().get(3).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }
                        if (potion.size() == 5) {
                            inventaire.getPotions();
                            System.out.println("Choisissez votre Potion :");
                            System.out.println("1. " + inventaire.getPotions().get(0).getNom() + " - Attaque : " + inventaire.getPotions().get(0).getAttaque() + " - Défense : " + inventaire.getPotions().get(0).getDefense() + " - Vitesse : " + inventaire.getPotions().get(0).getVitesse() + " - Vie: " + inventaire.getPotions().get(0).getVie() + " - Rareté : " + inventaire.getPotions().get(0).getRarete());
                            System.out.println("2. " + inventaire.getPotions().get(1).getNom() + " - Attaque : " + inventaire.getPotions().get(1).getAttaque() + " - Défense : " + inventaire.getPotions().get(1).getDefense() + " - Vitesse : " + inventaire.getPotions().get(1).getVitesse() + " - Vie: " + inventaire.getPotions().get(1).getVie() + " - Rareté : " + inventaire.getPotions().get(1).getRarete());
                            System.out.println("3. " + inventaire.getPotions().get(2).getNom() + " - Attaque : " + inventaire.getPotions().get(2).getAttaque() + " - Défense : " + inventaire.getPotions().get(2).getDefense() + " - Vitesse : " + inventaire.getPotions().get(2).getVitesse() + " - Vie: " + inventaire.getPotions().get(2).getVie() + " - Rareté : " + inventaire.getPotions().get(2).getRarete());
                            System.out.println("4. " + inventaire.getPotions().get(3).getNom() + " - Attaque : " + inventaire.getPotions().get(3).getAttaque() + " - Défense : " + inventaire.getPotions().get(3).getDefense() + " - Vitesse : " + inventaire.getPotions().get(3).getVitesse() + " - Vie: " + inventaire.getPotions().get(3).getVie() + " - Rareté : " + inventaire.getPotions().get(3).getRarete());
                            System.out.println("5. " + inventaire.getPotions().get(4).getNom() + " - Attaque : " + inventaire.getPotions().get(4).getAttaque() + " - Défense : " + inventaire.getPotions().get(4).getDefense() + " - Vitesse : " + inventaire.getPotions().get(4).getVitesse() + " - Vie: " + inventaire.getPotions().get(4).getVie() + " - Rareté : " + inventaire.getPotions().get(4).getRarete());
                            System.out.print("Entrez une commande : ");
                            int choixPotion = scanner.nextInt();
                            Potion PotionChoisie = inventaire.getPotions().get(choixPotion - 1);
                            System.out.println("Vous avez choisi la " + PotionChoisie.getNom() + " - Attaque : " + PotionChoisie.getAttaque() + " - Défense : " + PotionChoisie.getDefense() + " - Vitesse : " + PotionChoisie.getVitesse() + " - Rareté : " + PotionChoisie.getRarete());
                            inventaire.boirePotion(potion.get(choixPotion - 1), hero);
                            inventaire.enleverPotion(potion.get(choixPotion - 1));
                        }

                    }
                }
            }
        }
            // Fin de la partie
        if (hero.getVie() > 0) {
                System.out.println("Vous avez vaincu le monstre !");
                hero.gagnerExperience();
                monstre.NivMonstre();
                monstre.perdreVie(-100);
        } else {
                System.out.println("Vous avez perdu...");
                System.exit(0);
        }
        }
    }



