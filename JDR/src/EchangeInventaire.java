import java.util.ArrayList;
import java.util.Scanner;
public class EchangeInventaire {
    public static void echangeInventaire(Inventaire inventaire1, InventaireCoffre inventaireCoffre) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;
        int fin=0;

        while (continuer) {
            System.out.println("Que souhaitez-vous faire ?");
            System.out.println("1. Ajouter un objet de l'inventaire au coffre");
            System.out.println("2. Retirer un objet du coffre pour l'ajouter à l'inventaire");
            System.out.println("3. Quitter");
            System.out.print("Entrez une commande : ");
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Quel type d'objet voulez-vous ajouter ?");
                    System.out.println("1. Arme");
                    System.out.println("2. Artefact");
                    System.out.println("3. Potion");
                    System.out.print("Entrez une commande : ");
                    int choixType = scanner.nextInt();
                    switch (choixType) {
                        case 1:
                            ArrayList<Arme> armes = inventaire1.getArme();
                            if (armes.size() == 0) {
                                System.out.println("Vous n'avez pas d'armes dans votre inventaire !");
                            } else {
                                System.out.println("Quelle arme voulez-vous ajouter au coffre ?");
                                for (int i = 0; i < armes.size(); i++) {
                                    System.out.println((i + 1) + ". " + armes.get(i).getNom() + " - Attaque : " + armes.get(i).getAttaque() + " - Défense : " + armes.get(i).getDefense() + " - Vitesse : " + armes.get(i).getVitesse() + " - Rareté : " + armes.get(i).getRarete() );
                                }
                                int choixArme = scanner.nextInt();
                                if (choixArme < 1 || choixArme > armes.size()) {
                                    System.out.println("Choix invalide !");
                                } else {
                                    inventaireCoffre.ajouterArmeCoffre(armes.get(choixArme - 1));
                                    inventaire1.enleverArme(armes.get(choixArme - 1));
                                }
                            }
                            break;
                        case 2:
                            ArrayList<Artefact> artefacts = inventaire1.getArtefact();
                            if (artefacts.size() == 0) {
                                System.out.println("Vous n'avez pas d'artefacts dans votre inventaire !");
                            } else {
                                System.out.println("Quel artefact voulez-vous ajouter au coffre ?");
                                for (int i = 0; i < artefacts.size(); i++) {
                                    System.out.println((i + 1) + ". " + artefacts.get(i).getNom());
                                }
                                int choixArtefact = scanner.nextInt();
                                if (choixArtefact < 1 || choixArtefact > artefacts.size()) {
                                    System.out.println("Choix invalide !");
                                } else {
                                    inventaireCoffre.ajouterArtefactCoffre(artefacts.get(choixArtefact - 1));
                                    inventaire1.enleverArtefact(artefacts.get(choixArtefact - 1));
                                }
                            }
                            break;
                        case 3:
                            ArrayList<Potion> potions = inventaire1.getPotions();
                            if (potions.size() == 0) {
                                System.out.println("Vous n'avez pas de potions dans votre inventaire !");
                            } else {
                                System.out.println("Quelle potion voulez-vous ajouter au coffre ?");
                                for (int i = 0; i < potions.size(); i++) {
                                    System.out.println((i + 1) + ". " + potions.get(i).getNom());
                                }
                                int choixPotion = scanner.nextInt();
                                if (choixPotion < 1 || choixPotion > potions.size()) {
                                    System.out.println("Choix invalide !");
                                } else {
                                    inventaireCoffre.ajouterPotionCoffre(potions.get(choixPotion - 1));
                                    inventaire1.enleverPotion(potions.get(choixPotion - 1));
                                }
                            }
                            break;
                        default:
                            System.out.println("Choix invalide !");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Quel type d'objet voulez-vous retirer du coffre ?");
                    System.out.println("1. Arme");
                    System.out.println("2. Artefact");
                    System.out.println("3. Potion");
                    System.out.print("Entrez une commande : ");
                    int choixTypeRetrait = scanner.nextInt();
                    switch (choixTypeRetrait) {
                        case 1:
                            ArrayList<Arme> armes = inventaireCoffre.getArme();
                            if (armes.size() == 0) {
                                System.out.println("Il n'y a pas d'armes dans le coffre !");
                            } else {
                                System.out.println("Quelle arme voulez-vous retirer du coffre ?");
                                for (int i = 0; i < armes.size(); i++) {
                                    System.out.println((i + 1) + ". " + armes.get(i).getNom() + " - Attaque : " + armes.get(i).getAttaque() + " - Défense : " + armes.get(i).getDefense() + " - Vitesse : " + armes.get(i).getVitesse() + " - Rareté : " + armes.get(i).getRarete() );
                                }
                                int choixArme = scanner.nextInt();
                                if (choixArme < 1 || choixArme > armes.size()) {
                                    System.out.println("Choix invalide !");
                                } else {
                                    inventaire1.ajouterArme(armes.get(choixArme - 1));
                                    inventaireCoffre.enleverArmeCoffre(armes.get(choixArme - 1));
                                }
                            }
                            break;
                        case 2:
                            ArrayList<Artefact> artefacts = inventaireCoffre.getArtefact();
                            if (artefacts.size() == 0) {
                                System.out.println("Il n'y a pas d'artefacts dans le coffre !");
                            } else {
                                System.out.println("Quel artefact voulez-vous retirer du coffre ?");
                                for (int i = 0; i < artefacts.size(); i++) {
                                    System.out.println((i + 1) + ". " + artefacts.get(i).getNom());
                                }
                                int choixArtefact = scanner.nextInt();
                                if (choixArtefact < 1 || choixArtefact > artefacts.size()) {
                                    System.out.println("Choix invalide !");
                                } else {
                                    inventaire1.ajouterArtefact(artefacts.get(choixArtefact - 1));
                                    inventaireCoffre.enleverArtefactCoffre(artefacts.get(choixArtefact - 1));
                                }
                            }
                            break;
                        case 3:
                            ArrayList<Potion> potions = inventaireCoffre.getPotions();
                            if (potions.size() == 0) {
                                System.out.println("Il n'y a pas de potions dans le coffre !");
                            } else {
                                System.out.println("Quelle potion voulez-vous retirer du coffre ?");
                                for (int i = 0; i < potions.size(); i++) {
                                    System.out.println((i+1) + ". " + potions.get(i).getNom());
                                }
                                int choixPotion = scanner.nextInt();
                                if (choixPotion < 1 || choixPotion > potions.size()) {
                                    System.out.println("Choix invalide !");
                                } else {
                                    inventaire1.ajouterPotion(potions.get(choixPotion-1));
                                    inventaireCoffre.enleverPotionCoffre(potions.get(choixPotion-1));
                                }
                            }
                            break;
                        default:
                            System.out.println("Choix invalide !");
                            break;
                    }
                case 3:
                    continuer = false;
                    break;
                default:
                    if (fin==0);
                    System.out.println("Choix invalide !");
                    break;
            }
        }
    }
}