package vieux;
/*
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carte1 {
    private char[][] carte;
    private int nbMonstres = 5;
    private int nbCoffres = 5;
    List<int[]> coordCoffres = new ArrayList<>();

    public Carte1(String carteStr) {
        String[] lignes = carteStr.split("\n");
        int hauteur = lignes.length;
        int largeur = lignes[0].length();
        carte = new char[hauteur][largeur];
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                carte[i][j] = lignes[i].charAt(j);
            }
        }

        // Ajouter les monstres
        Random rand = new Random();
        int i = 0;
        while (i < nbMonstres) {
            int x = rand.nextInt(hauteur);
            int y = rand.nextInt(largeur);
            if (carte[x][y] == '.') {
                carte[x][y] = 'M';
                i++;
            }
        }

        // Ajouter les coffres
        while (i < nbCoffres) {
            int x = rand.nextInt(hauteur);
            int y = rand.nextInt(largeur);
            if (carte[x][y] == '.') {
                carte[x][y] = 'C';
                coordCoffres.add(new int[]{x, y}); // ajouter les coordonnées à la liste
                i++;
            }
        }
        // Ajouter le héros
        i = 0;
        while (i < 1) {
            int x = rand.nextInt(hauteur);
            int y = rand.nextInt(largeur);
            if (carte[x][y] == '.') {
                carte[x][y] = 'H';
                i++;
            }
        }
    }

    public int[] getHeros() {
        int[] herosPos = new int[2];
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[0].length; j++) {
                if (carte[i][j] == 'H') {
                    herosPos[0] = i;
                    herosPos[1] = j;
                    return herosPos;
                }
            }
        }
        return herosPos;
    }


    public void afficherCarte() {
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[0].length; j++) {
                System.out.print(carte[i][j]);
            }
            System.out.println();
        }
    }

    public char getCase(int x, int y) {
        return carte[x][y];
    }
    /*public ArrayList<int[]> getCoffre() {
        ArrayList<int[]> coffrePositions = new ArrayList<int[]>();
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[0].length; j++) {
                if (carte[i][j] == 'C') {
                    int[] CoffrePos = {i,j};
                    coffrePositions.add(CoffrePos);
                }
            }
        }
        return coffrePositions;
    }


    public List<int[]> getCoordCoffres() {
        return coordCoffres;
    }
    public void setCase(int ligne, int colonne, char valeur) {
        this.carte[ligne][colonne] = valeur;
    }

}*/