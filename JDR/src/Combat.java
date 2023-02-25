/*
import java.util.Random;
import java.util.Scanner;

public class Combat {
    private Hero hero;
    private Monstre monstre;
    private boolean tourHero;
    public Combat(Hero hero, Monstre monstre) {
        this.hero = hero;
        this.monstre = monstre;
        this.tourHero = true;
    }
    public void lancer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Un combat débute !");
        while (hero.getVie() > 0 && monstre.getVie() > 0) {
            System.out.println("-------------------------------------------");
            if (tourHero) {
                System.out.println("Tour du héros !");
                System.out.println("Vie du héros : " + hero.getVie());
                System.out.println("Vie du monstre : " + monstre.getVie());
                System.out.println("Que voulez-vous faire ?");
                System.out.println("1 - Attaquer avec votre main");
                System.out.println("2 - Attaquer avec " + (hero.getArme().size() > 0 ? "votre arme 1" : "aucune arme"));
                System.out.println("3 - Attaquer avec " + (hero.getArme().size() > 1 ? "votre arme 2" : "aucune arme"));
                System.out.println("4 - Utiliser une potion");
                int choix = scanner.nextInt();
                switch (choix) {
                    case 1:
                        attaquer(hero.getAttaque(), 0);
                        break;
                    case 2:
                        if (hero.getArme().size() > 0) {
                            attaquer(hero.getArme().get(0).getAttaque(), hero.getArme().get(0).getRarete());
                        } else {
                            System.out.println("Vous n'avez pas d'arme !");
                        }
                        break;
                    case 3:
                        if (hero.getArme().size() > 1) {
                            attaquer(hero.getArme().get(1).getAttaque(), hero.getArme().get(1).getRarete());
                        } else {
                            System.out.println("Vous n'avez pas d'autre arme !");
                        }
                        break;
                    case 4:
                        utiliserPotion();
                        break;
                    default:
                        System.out.println("Choix invalide !");
                        break;
                }
            } else {
                System.out.println("Tour du monstre !");
                int degats = calculerDegats(monstre.getAttaque(), hero.getDefense());
                System.out.println("Le monstre inflige " + degats + " points de dégâts !");
                hero.setVie(hero.getVie() - degats);
            }
            tourHero = !tourHero;
        }
        if (hero.getVie() <= 0) {
            System.out.println("Le héros a été vaincu !");
        } else {
            System.out.println("Le monstre a été vaincu !");
            int ennemiNiveau = monstre.getNiveau();
            hero.gagnerExperience(ennemiNiveau);
        }
    }

    private void attaquer(int attaque, int rarete) {
        Random random = new Random();
        int degats = calculerDegats(attaque, monstre.getDefense());
        if (rarete > 0) {
            int crit = random.nextInt(100);
            if (crit < rarete) {
                degats *= 2;
                System.out.println("Coup critique !");
            }
        }
        System.out.println("Vous infligez " + degats + " points de dégâts !");
        monstre.setVie(monstre.getVie() - degats);
    }

    private void utiliserPotion() {
        if (hero.getPotions() > 0) {
            hero.setVie(hero.getVie() + 50);
            hero.setPotions(hero.getPotions() - 1);
            System.out.println("Vous utilisez une potion et récupérez 50 points de vie !");
        } else {
            System.out.println("Vous n'avez plus de potions !");
        }
    }

    private int calculerDegats(int attaque, int defense) {
        Random random = new Random();
        int degats = attaque - defense;
        if (degats < 0) {
            degats = 0;
        }
        degats += random.nextInt(11) - 5;
        return degats;
    }

}

 *//*
import java.util.Random;

public class Combat {
    private Hero hero;
    private Monstre monstre;
    private boolean tourDuHero;
    private boolean combatTermine;
    private Random rand;

    public Combat(Hero hero, Monstre monstre) {
        this.hero = hero;
        this.monstre = monstre;
        this.tourDuHero = true;
        this.combatTermine = false;
        this.rand = new Random();
    }

    Inventaire inventaire = new Inventaire();

    public void tour() {
        if (combatTermine) {
            return;
        }

        if (tourDuHero) {
            tourDuHero();
        } else {
            tourDuMonstre();
        }

        if (hero.getVie() <= 0 || monstre.getVie() <= 0) {
            combatTermine = true;
            finDuCombat();
        } else {
            tourDuHero = !tourDuHero;
        }
    }

    private void tourDuHero() {
        System.out.println("C'est au tour du héros.");

        // Afficher les options de l'utilisateur
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1. Attaquer avec la main");
        int choixArme1 = -1;
        int choixArme2 = -1;
        if (hero.getArmes().size() >= 1) {
            System.out.println("2. Attaquer avec l'arme 1 : " + hero.getArmes().get(0).getNom());
            choixArme1 = 2;
        }
        if (hero.getArmes().size() >= 2) {
            System.out.println("3. Attaquer avec l'arme 2 : " + hero.getArmes().get(1).getNom());
            choixArme2 = 3;
        }
        System.out.println("4. Utiliser une potion");
        System.out.print("Votre choix : ");

        // Lire l'entrée de l'utilisateur
        int choix = LireEntier();

        // Valider l'entrée de l'utilisateur et effectuer l'action appropriée
        switch (choix) {
            case 1:
                attaquer(hero, monstre, hero.getAttaque());
                break;
            case 2:
                if (choixArme1 != -1) {
                    attaquer(hero, monstre, hero.getArmes().get(0).getAttaque());
                } else {
                    System.out.println("Option invalide.");
                }
                break;
            case 3:
                if (choixArme2 != -1) {
                    attaquer(hero, monstre, hero.getArmes().get(1).getAttaque());
                } else {
                    System.out.println("Option invalide.");
                }
                break;
            case 4:
                utiliserPotion(hero);
                break;
            default:
                System.out.println("Option invalide.");
                break;
        }
    }

    private void tourDuMonstre() {
        System.out.println("C'est au tour du monstre.");

        // Le monstre choisit une attaque aléatoire
        int choixAttaque = rand.nextInt(2);
        if (choixAttaque == 0) {
            attaquer(monstre, hero, monstre.getAttaque());
        } else {
            // Le monstre utilise une compétence spéciale s'il en a une
            if (monstre.getCompetenceSpeciale() != null) {
                System.out.println("Le monstre utilise " + monstre.getCompetenceSpeciale().getNom() + " !");
                monstre.getCompetenceSpeciale().effet(hero);
            } else {
                attaquer(monstre, hero, monstre.getAttaque());
            }
        }
    }

    private void attaquer(Personnage attaquant, Personnage defenseur, int attaque) {
        int degats = attaquant.calculerDegats(attaque);
        System.out.println(attaquant.getNom() + " attaque " + defenseur.getNom() + " et lui inflige " + degats + " points de dégâts.");
        defenseur.recevoirDegats(degats);
    }

    private void utiliserPotion(Hero hero) {
        if (hero.getPotions() <= 0) {
            System.out.println("Vous n'avez plus de potions.");
            return;
        }

        int soins = rand.nextInt(20) + 10;
        System.out.println("Vous utilisez une potion et récupérez " + soins + " points de vie.");
        hero.recevoirSoins(soins);
        hero.retirerPotion();
    }

    private void finDuCombat() {
        if (hero.getVie() <= 0) {
            System.out.println("Vous êtes mort.");
        } else if (monstre.getVie() <= 0) {
            System.out.println("Vous avez vaincu le monstre !");
            int xpGagnee = monstre.getXp();
            System.out.println("Vous gagnez " + xpGagnee + " points d'expérience.");
            hero.gagnerXp(xpGagnee);
        }
    }

    private int LireEntier() {
        // Cette méthode permet de lire l'entrée de l'utilisateur et de s'assurer qu'il s'agit bien d'un entier.
        // Elle n'est pas incluse dans la question, mais elle est nécessaire pour que le code compile.

        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrée invalide, veuillez entrer un nombre : ");
            scanner.nextLine();
        }
        int entier = scanner.nextInt();
        scanner.nextLine(); // vider la ligne
        return entier;
    }
}*/