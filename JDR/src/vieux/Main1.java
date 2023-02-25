package vieux;
/*
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        String carteStr ="################################\n" +
                "#..............................#\n" +
                "#..............................#\n" +
                "#..............................#\n" +
                "#..............................#\n" +
                "#..............................#\n" +
                "#..............................#\n" +
                "#..............................#\n" +
                "#..............................#\n" +
                "#..............................#\n" +
                "################################";
        Carte carte = new Carte(carteStr);
        Scanner scanner = new Scanner(System.in);
        Inventaire inventaire = new Inventaire();
        InventaireCoffre inventaireCoffre = new InventaireCoffre();
        ArmesList armesList = new ArmesList();


        boolean afficherCarte = true;
        int deplacementX = 0;
        int deplacementY = 0;
        int[] heroPos = carte.getHeros();
        if (heroPos[0] == -1 && heroPos[1] == -1) {
            System.out.println("\u001B[31m" + "Le héros n'est pas sur la carte." + "\u001B[0m");
        }
        Deplacement heros = new Deplacement(heroPos[0], heroPos[1]);
        while (true) {
            if (afficherCarte) {
                carte.afficherCarte();
            }
            afficherCarte = true;
            System.out.print("Entrez une commande ('help' pour les commande) : ");

            deplacementX = 0;
            deplacementY = 0;

            String commande = scanner.nextLine();
            switch (commande) {
                case "z":
                    deplacementX = -1;
                    break;
                case "s":
                    deplacementX = 1;
                    break;
                case "q":
                    deplacementY = -1;
                    break;
                case "d":
                    deplacementY = 1;
                    break;
                case "inventaire":
                    inventaire.afficherInventaire();
                    afficherCarte = false;
                    break;
                case "fermer inventaire":
                    break;
                case "quitter":
                    break;
                case "help":
                    System.out.print("Mouvement : haut,bas,droite,gauche \nInventaire : inventaire,fermer inventaire \n");
                    afficherCarte = false;
                    break;

                default:
                    System.out.println("\u001B[31m" + "Commande invalide" + "\u001B[0m");

                    continue;
            }

            int nouvellePositionX = heroPos[0] + deplacementX;
            int nouvellePositionY = heroPos[1] + deplacementY;


            List<int[]> coordCoffres = carte.getCoordCoffres();

            int[] anciennePosition = heros.getPosition();
            heros.seDeplacer(deplacementX, deplacementY, carte);
            int[] nouvellePosition = heros.getPosition();
            carte.setCase(anciennePosition[0], anciennePosition[1], '.');
            carte.setCase(nouvellePosition[0], nouvellePosition[1], 'H');

            heroPos[0] = nouvellePositionX;
            heroPos[1] = nouvellePositionY;

        }
    }
}*/



