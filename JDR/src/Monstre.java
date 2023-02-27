public class Monstre {
    private int vie;
    private int attaque;
    private int defense;
    private int vitesse;
    private int niveau;

    public Monstre(int vie, int attaque, int defense, int vitesse, int niveau) {
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

    public void perdreVie(int degats) {
        vie -= degats;
    }

    public void NivMonstre() {
        niveau += 1;
        vie += 10;
        attaque += 5;
        defense += 5;
        vitesse += 2;
        }
    }