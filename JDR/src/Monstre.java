public class Monstre {
    private int vie;
    private int attaque;
    private int defense;
    private int vitesse;
    private int niveau;

    public Monstre(int vie, int attaque, int defense, int vitesse) {
        this.vie = vie;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        this.niveau = 1;
    }

    public int getVie() {
        return vie;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getDefense() {
        return defense;
    }

    public int getVitesse() {
        return vitesse;
    }
    public int getNiv() {
        return niveau;
    }
    int niveauGagnee = 1;
    public void gagnerExperience(int ennemiNiveau) {
        niveau += niveauGagnee;
        int niveauActuel = niveau / 100;
        int niveauPrecedent = (niveau - niveauGagnee) / 100;
        if (niveauActuel > niveauPrecedent) {
            vie += 10;
            attaque += 5;
            defense += 5;
            vitesse += 2;
        }
    }
}