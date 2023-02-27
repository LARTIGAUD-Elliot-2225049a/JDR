import java.util.ArrayList;

public class Hero {
    private int vie;
    private int attaque;
    private int defense;
    private int vitesse;
    private int niveaux;

    public Hero(int vie, int attaque, int defense, int vitesse) {
        this.vie = vie;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        this.niveaux = 0;
    }

    public int getVie() {
        return vie;
    }
    public void perdreVie(int degats) {
        vie -= degats;
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

    public int getNiveaux() {
        return niveaux;
    }
    public void gagnerAttaque(int bonusAttaque) {
        attaque += bonusAttaque;
        System.out.println("Attaque : " + attaque);
    }
    public void gagnerDefense(int bonusDefense) {
        defense += bonusDefense;
        System.out.println("Defense : " + defense);
    }
    public void gagnerVitesse(int bonusVitesse) {
        vitesse += bonusVitesse;
        System.out.println("Vitesse: " + vitesse);
    }
    public void gagnerExperience() {
        niveaux += 1;
        vie += 10;
        if (vie > 100);{
            vie = 100;
        }
        attaque += 5;
        defense += 5;
        vitesse += 2;
        System.out.println("Vous avez atteint le niveau " + niveaux + " !");
        System.out.println("Vie : " + vie);
        System.out.println("Attaque : " + attaque);
        System.out.println("Defense : " + defense);
        System.out.println("Vitesse : " + vitesse);
        }
    }
