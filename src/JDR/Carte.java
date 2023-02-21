package JDR;

import java.util.Random;

public class Carte {
    private char[][] grille;
    private int nbMonstres;
    private int nbCoffres;
    private Random rand;
    
    public Carte(int nbLignes, int nbColonnes, int nbMonstres, int nbCoffres) {
        grille = new char[nbLignes][nbColonnes];
        rand = new Random();
        this.nbMonstres = nbMonstres;
        this.nbCoffres = nbCoffres;
        
        // Initialisation de la grille avec des murs
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                grille[i][j] = '#';
            }
        }
        
        // Placement des coffres
        for (int i = 0; i < nbCoffres; i++) {
            int x = rand.nextInt(nbLignes);
            int y = rand.nextInt(nbColonnes);
            grille[x][y] = 'C';
        }
        
        // Placement des monstres
        for (int i = 0; i < nbMonstres; i++) {
            int x = rand.nextInt(nbLignes);
            int y = rand.nextInt(nbColonnes);
            while (grille[x][y] != ' ') {  // On vérifie que la case est vide
                x = rand.nextInt(nbLignes);
                y = rand.nextInt(nbColonnes);
            }
            grille[x][y] = 'M';
        }
    }
    
    public char getCase(int x, int y) {
        return grille[x][y];
    }
    
    public void afficher() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }
}