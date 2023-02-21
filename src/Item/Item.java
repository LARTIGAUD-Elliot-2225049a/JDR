package Item;

public abstract class Item {
    protected String nom;
    protected int valeur;

    public Item(String nom) {
        this.nom = nom;

    }

    public String getNom() {
        return nom;
    }

}
