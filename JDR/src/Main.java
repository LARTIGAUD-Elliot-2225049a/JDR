import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Carte carte = new Carte();
        char[][] map = carte.getCarte();
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        InventaireCoffre inventaireCoffre = new InventaireCoffre();
        ArmesList armesList = new ArmesList();
        PotionList potionList = new PotionList();
        ArtefactList artefactsList = new ArtefactList();
        EchangeInventaire echangeInventaire = new EchangeInventaire();
        Inventaire inventaire = new Inventaire();
        Hero hero = new Hero(100, 10, 10, 10);
        Monstre monstre = new Monstre(100, 25, 10, 30, 1);
        Combat combat = new Combat(hero, monstre, inventaire.getArme(), inventaire.getPotions(), scanner);
        CombatBoss combatBoss = new CombatBoss(hero, monstre, inventaire.getArme(), inventaire.getPotions(), scanner);
        // Placement du héros
        int x = rand.nextInt(carte.NB_LIGNES - 2) + 1; // Génère une coordonnée aléatoire entre 1 et NB_LIGNES-2 (pour éviter le contour)
        int y = rand.nextInt(carte.NB_COLONNES - 2) + 1; // Génère une coordonnée aléatoire entre 1 et NB_COLONNES-2 (pour éviter le contour)
        while (map[x][y] != '.') { // Si la case est déjà occupée, on en génère de nouvelles
            x = rand.nextInt(carte.NB_LIGNES - 2) + 1;
            y = rand.nextInt(carte.NB_COLONNES - 2) + 1;
        }
        map[x][y] = 'H';
        // Affichage de la carte
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        inventaire.ajouterArmeText(armesList.getArme(0));
        inventaire.ajouterPotionText(PotionList.getPotion(0));
        inventaire.ajouterArtefactText(artefactsList.getArtefact(0));
        // Boucle pour déplacer le héros
        while (true) {
            System.out.print("Entrez une commande (help pour la liste des commande) : ");
            String commande = scanner.nextLine();
            // Déplacement du héros
            int nouveauX = x;
            int nouveauY = y;
            switch (commande) {
                case "haut":
                    nouveauX--;
                    break;
                case "bas":
                    nouveauX++;
                    break;
                case "gauche":
                    nouveauY--;
                    break;
                case "droite":
                    nouveauY++;
                    break;
                case "quitter":
                    System.exit(0);
                case "help":
                    System.out.print("- Déplacement : haut,bas,gauche,droite\n");
                    System.out.print("- inventaire\n");
                    System.out.print("- ouvrir coffre (A coté d'un coffre 'C') \n");
                    System.out.print("- Rentré dans un monstre pour lancé un combat\n");
                    System.out.print("- Pour fermer le jeu : quitter\n");
                    break;
                case "ouvrir coffre":
                    if ((x > 0 && map[x - 1][y] == 'C') || (x < carte.NB_LIGNES - 1 && map[x + 1][y] == 'C')
                            || (y > 0 && map[x][y - 1] == 'C') || (y < carte.NB_COLONNES - 1 && map[x][y + 1] == 'C')) {
                        System.out.println("le Coffre est ouvert dedans il y a :");
                        inventaireCoffre.ajouterArmeCoffreText(armesList.choisirArme());
                        inventaireCoffre.ajouterPotionCoffreText(potionList.choisirPotion());
                        inventaireCoffre.ajouterArtefactCoffreText(artefactsList.choisirArtefact());
                        inventaireCoffre.afficherInventaireCoffre();
                        EchangeInventaire.echangeInventaire(inventaire, inventaireCoffre);
                        inventaireCoffre.viderInventaireCoffre();
                        if (x > 0 && map[x - 1][y] == 'C') {
                            map[x - 1][y] = '.';
                        }
                        if (x < carte.NB_LIGNES - 1 && map[x + 1][y] == 'C') {
                            map[x + 1][y] = '.';
                        }
                        if (y > 0 && map[x][y - 1] == 'C') {
                            map[x][y - 1] = '.';
                        }
                        if (y < carte.NB_COLONNES - 1 && map[x][y + 1] == 'C') {
                            map[x][y + 1] = '.';
                        }
                        break;
                    } else {
                        System.out.println("Pas de coffre");
                        continue;
                    }
                case "inventaire":
                    inventaire.afficherInventaire();
                    break;
                default:
                    System.out.println("Commande invalide.");
                    continue;
            }
            if (((map[nouveauX][nouveauY] == 'C')
                    || (map[nouveauX][nouveauY] == '#'))) {
                System.out.println("Déplacement impossible : case occupée.");
                continue; // On passe au tour suivant de la boucle
            }
            int[] positionM = carte.findM(map);
            if (positionM != null) {
                int ligneM = positionM[0];
                int colonneM = positionM[1];
                map[ligneM][colonneM] = 'B';
            }
            if ((map[nouveauX][nouveauY] == 'B')) {
                map[x][y] = '.';
                x = nouveauX;
                y = nouveauY;
                map[x][y] = 'H';
                combatBoss.start(inventaire);
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        System.out.print(map[i][j]);
                    }
                    System.out.println();
                }
                continue; // On passe au tour suivant de la boucle
            }
            if ((map[nouveauX][nouveauY] == 'M')) {
                map[x][y] = '.';
                x = nouveauX;
                y = nouveauY;
                map[x][y] = 'H';
                combat.start(inventaire);
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        System.out.print(map[i][j]);
                    }
                    System.out.println();
                }
                continue; // On passe au tour suivant de la boucle
            }
            // Déplacement effectif du héros
            map[x][y] = '.';
            x = nouveauX;
            y = nouveauY;
            map[x][y] = 'H';
            // Affichage de la carte mise à jour
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
