import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String carteStr = "################################\n" +
                "######################.........#\n" +
                "######################.........#\n" +
                "######################.........#\n" +
                "######################.........#\n" +
                "######################.........#\n" +
                "##############.....###.........#\n" +
                "##############.....###.........#\n" +
                "##############.....##########.##\n" +
                "##############.....##########.##\n" +
                "################.############.##\n" +
                "################.############.##\n" +
                "#...##########...############.##\n" +
                "#.....########..........#####.##\n" +
                "#.......######..####..........##\n" +
                "#...............####....#####.##\n" +
                "#..............#..##....#####.##\n" +
                "#.............##........#####.##\n" +
                "#.....####....##..##....#####.##\n" +
                "#....######..###..##....#####.##\n" +
                "#....#######.################.##\n" +
                "#.....######.###########..###.##\n" +
                "#.....######.#########....###.##\n" +
                "##....######.#########.#..##...#\n" +
                "##....######..########.#####...#\n" +
                "##.....#####...######...####...#\n" +
                "##.............######..........#\n" +
                "##........###...#####...###....#\n" +
                "##........#####.........###....#\n" +
                "##........##########....###....#\n" +
                "####################....###....#\n" +
                "################################";
        Carte carte = new Carte(carteStr);
        Scanner scanner = new Scanner(System.in);
        Inventaire inventaire = new Inventaire();
        boolean afficherCarte = true;


        int[] heroPos = carte.getHeros();
        if (heroPos[0] == -1 && heroPos[1] == -1) {
            System.out.println("\u001B[31m" + "Le héros n'est pas sur la carte." + "\u001B[0m");
        }
        Deplacement heros = new Deplacement(heroPos[0], heroPos[1]);
        while (true) {
            if (afficherCarte) {
                carte.afficherCarte();
            }
            System.out.print("Entrez une commande ('help' pour les commande) : ");
            String commande = scanner.nextLine();


            int deplacementX = 0;
            int deplacementY = 0;

            switch (commande) {
                case "haut":
                    deplacementX = -1;
                    break;
                case "bas":
                    deplacementX = 1;
                    break;
                case "gauche":
                    deplacementY = -1;
                    break;
                case "droite":
                    deplacementY = 1;
                    break;
                case "inventaire":
                    inventaire.afficherInventaire();
                    afficherCarte = false;
                    break;
                case "fermer inventaire":
                    break;
                case "help":
                    System.out.print("Mouvement : haut,bas,droite,gauche \nInventaire : inventaire,fermer inventaire \n");
                    break;

                default:
                    System.out.println("\u001B[31m" + "Commande invalide" + "\u001B[0m");
                    continue;
            }
            int nouvellePositionX = heroPos[0] + deplacementX;
            int nouvellePositionY = heroPos[1] + deplacementY;
            if (carte.getCase(nouvellePositionX, nouvellePositionY) == '#') {
                System.out.println("\u001B[31m" + "Vous ne pouvez pas passer à travers les murs !" + "\u001B[0m");
                continue;
            }

            int[] anciennePosition = heros.getPosition();
            heros.seDeplacer(deplacementX, deplacementY, carte);
            int[] nouvellePosition = heros.getPosition();
            carte.setCase(anciennePosition[0], anciennePosition[1], '.');
            carte.setCase(nouvellePosition[0], nouvellePosition[1], 'H');

            if (!commande.equals("inventaire")) {
                afficherCarte = true;
            }

        }

    }
}