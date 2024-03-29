public class Artefact {
    private String nom;
    private int attaque;
    private int vitesse;
    private int defense;
    private Rarete rarete;

    public Artefact(String nom, int attaque, int defense, int vitesse, Rarete rarete) {
        this.nom = nom;
        this.attaque = attaque;
        this.vitesse = vitesse;
        this.defense = defense;
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

    public Rarete getRarete() {
        return rarete;
    }
}