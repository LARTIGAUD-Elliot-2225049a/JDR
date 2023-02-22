public class Potion {
    private String nom;
    private int attaque;
    private int vitesse;
    private int defense;
    private int vie ;
    private Rarete rarete;

    public Potion(String nom, int attaque, int defense, int vitesse, int vie, Rarete rarete) {
        this.nom = nom;
        this.attaque = attaque;
        this.vitesse = vitesse;
        this.defense = defense;
        this.vie = vie;
        this.rarete = rarete;
    }

    public String getNom() {
        return nom;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getDefense() {
        return defense;
    }

    public int getVie(){
        return vie;
    }

    public Rarete getRarete() {
        return rarete;
    }
}

