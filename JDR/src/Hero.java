public class Hero {
    private int vie;
    private int attaque;
    private int defense;
    private int vitesse;
    private int experience;

    public Hero(int vie, int attaque, int defense, int vitesse) {
        this.vie = vie;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        this.experience = 0;
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

    public int getExperience() {
        return experience;
    }

    public void gagnerExperience(int ennemiNiveau) {
        int experienceGagnee = ennemiNiveau * 10;
        experience += experienceGagnee;
        int niveauActuel = experience / 100;
        int niveauPrecedent = (experience - experienceGagnee) / 100;
        if (niveauActuel > niveauPrecedent) {
            vie += 10;
            attaque += 5;
            defense += 5;
            vitesse += 2;
            System.out.println("Vous avez atteint le niveau " + niveauActuel + " !");
            System.out.println("Vie : " + vie);
            System.out.println("Attaque : " + attaque);
            System.out.println("Defense : " + defense);
            System.out.println("Vitesse : " + vitesse);
        }
        public void ajusterStats(Inventaire Inventaire) {
            for (Arme arme : Inventaire.getArmes()) {
                attaque += arme.getAttaque();
                defense += arme.getDefense();
                vitesse += arme.getVitesse();
            }
            for (Artefact artefact : Inventaire.getArtefacts()) {
                attaque += artefact.getAttaque();
                defense += artefact.getDefense();
                vitesse += artefact.getVitesse();
            }
        }

    }
}