import java.util.Random;
public class Carte {
    private char[][] carte;
    public final int NB_LIGNES = 10;
    public final int NB_COLONNES = 20;
    private final int NB_MONSTRES = 5;
    private final int NB_COFFRES = 10;

    public Carte() {
        carte = new char[NB_LIGNES][NB_COLONNES];
        Random rand = new Random();
        // Initialisation de la carte avec des dièses
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[i].length; j++) {
                if (i == 0 || i == carte.length - 1 || j == 0 || j == carte[i].length - 1) {
                    carte[i][j] = '#'; // Ajout du contour
                } else {
                    carte[i][j] = '.'; // Case vide
                }
            }
        }

        for (int i = 0; i < NB_COFFRES; i++) {
            int x = rand.nextInt(NB_LIGNES - 2) + 1; // Génère une coordonnée aléatoire entre 1 et NB_LIGNES-2 (pour éviter le contour)
            int y = rand.nextInt(NB_COLONNES - 2) + 1; // Génère une coordonnée aléatoire entre 1 et NB_COLONNES-2 (pour éviter le contour)
            int[] coffresX = new int[NB_COFFRES];
            int[] coffresY = new int[NB_COFFRES];
            boolean isOnDiagonal = true;
            while (carte[x][y] != '.' || isOnDiagonal) { // Si la case est déjà occupée ou est sur la diagonale d'un autre 'C', on en génère de nouvelles
                x = rand.nextInt(NB_LIGNES - 2) + 1;
                y = rand.nextInt(NB_COLONNES - 2) + 1;
                // Vérifier si la nouvelle position est sur la diagonale d'un autre 'C' et n'est pas en face d'un autre 'C'
                isOnDiagonal = false;
                for (int j = 0; j < i; j++) {
                    if (Math.abs(x - coffresX[j]) == Math.abs(y - coffresY[j])) {
                        isOnDiagonal = true;
                        break;
                    }
                    if (x == coffresX[j] || y == coffresY[j]) {
                        // Il y a déjà un coffre sur la même ligne ou colonne
                        isOnDiagonal = true;
                        break;
                    }
                    if (x < coffresX[j] && y < coffresY[j] && carte[x + 1][y + 1] != '.') {
                        // Il y a déjà un coffre en haut à gauche
                        isOnDiagonal = true;
                        break;
                    }
                    if (x < coffresX[j] && y > coffresY[j] && carte[x + 1][y - 1] != '.') {
                        // Il y a déjà un coffre en haut à droite
                        isOnDiagonal = true;
                        break;
                    }
                    if (x > coffresX[j] && y < coffresY[j] && carte[x - 1][y + 1] != '.') {
                        // Il y a déjà un coffre en bas à gauche
                        isOnDiagonal = true;
                        break;
                    }
                    if (x > coffresX[j] && y > coffresY[j] && carte[x - 1][y - 1] != '.') {
                        // Il y a déjà un coffre en bas à droite
                        isOnDiagonal = true;
                        break;
                    }
                }
            }
            carte[x][y] = 'C';
            coffresX[i] = x;
            coffresY[i] = y;
        }

        // Placement des monstres
        for (int i = 0; i < NB_MONSTRES; i++) {
            int x = rand.nextInt(NB_LIGNES - 2) + 1; // Génère une coordonnée aléatoire entre 1 et NB_LIGNES-2 (pour éviter le contour)
            int y = rand.nextInt(NB_COLONNES - 2) + 1; // Génère une coordonnée aléatoire entre 1 et NB_COLONNES-2 (pour éviter le contour)
            while (carte[x][y] != '.') { // Si la case est déjà occupée, on en génère de nouvelles
                x = rand.nextInt(NB_LIGNES - 2) + 1;
                y = rand.nextInt(NB_COLONNES - 2) + 1;
            }
            carte[x][y] = 'M';
        }
    }
    public char[][] getCarte() {
        return carte;
    }

}

