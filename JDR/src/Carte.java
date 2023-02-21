import java.util.Random;

public class Carte {
    private char[][] carte;
    private int nbMonstres = 9;
    private int nbCoffres = 4;

    public Carte(String carteStr) {
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
        i = 0;
        while (i < nbCoffres) {
            int x = rand.nextInt(hauteur);
            int y = rand.nextInt(largeur);
            if (carte[x][y] == '.') {
                carte[x][y] = 'C';
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
        // Si on ne trouve pas le héros, on renvoie un tableau contenant -1 -1
        herosPos[0] = -1;
        herosPos[1] = -1;
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

    public int getHauteur() {
        return carte.length;
    }

    public int getLargeur() {
        return carte[0].length;
    }

    public char getCase(int x, int y) {
        return carte[x][y];
    }
    public void setCase(int ligne, int colonne, char valeur) {
        this.carte[ligne][colonne] = valeur;
    }

}