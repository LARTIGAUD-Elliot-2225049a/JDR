public class Deplacement {
    private int x;
    private int y;

    public Deplacement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getPosition() {
        int[] position = new int[2];
        position[0] = this.x;
        position[1] = this.y;
        return position;
    }

    public void seDeplacer(int deplacementX, int deplacementY, Carte carte) {
        int nouvellePositionX = x + deplacementX;
        int nouvellePositionY = y + deplacementY;
        char caseArrivee = carte.getCase(nouvellePositionX, nouvellePositionY);

        if (caseArrivee == '#') {
            System.out.println("Vous ne pouvez pas traverser un mur !");
        } else {
            x = nouvellePositionX;
            y = nouvellePositionY;
        }
    }
}