package presentation;

import metier.MetierProduitImpl;
import metier.Produit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Long idCounter = 0L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetierProduitImpl metierProduit = new MetierProduitImpl();

        while (true) {
            menu();
            System.out.print("Entrer le choix: ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        afficherProduits(metierProduit.getAll());
                        break;
                    case 2:
                        rechercherProduit(scanner, metierProduit);
                        break;
                    case 3:
                        ajouterProduit(scanner, metierProduit);
                        break;
                    case 4:
                        supprimerProduit(scanner, metierProduit);
                        break;
                    case 5:
                        System.out.println("Merci d'avoir utiliser ce program! Au revoir!");
                        System.exit(0);
                    default:
                        System.out.println("Veuillez choisir entre 1 et 5.");

                }

            // au cas ou l'utilisateur saisie un type invalide
            } catch (InputMismatchException exception){
                System.out.println("Entrée non valide. Veuillez ressayer");
                scanner.nextLine(); // on consomme encore une fois parceque le premier ne se lit pas.
            }
        }
    }

    private static void menu() {
        System.out.println("\n");
        System.out.println("************ MENU ************");
        System.out.println("1. Afficher la liste des produits.");
        System.out.println("2. Rechercher un produit par son id.");
        System.out.println("3. Ajouter un nouveau produit dans la liste.");
        System.out.println("4. Supprimer un produit par id.");
        System.out.println("5. Quitter ce programme.");
        System.out.println("******************************\n");
    }

    private static void afficherProduits(List<Produit> produits) {
        System.out.println("\n************ LISTE DES PRODUITS ************");

        if (produits.isEmpty()) {
            System.out.println("-> LA LISTE DES PRODUITES EST VIDE");
        }
        for (Produit produit : produits) {
            System.out.println(produit);
        }
        System.out.println("********************************************");
    }

    private static void ajouterProduit(Scanner scanner, MetierProduitImpl metierProduit) {
        System.out.println("\n************ AJOUTER PRODUIT ************");

        System.out.print("-> Choisir le nombre d'elements à ajouter: ");
        int nombreProduits = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nombreProduits; i++) {

            System.out.println("-> Insertion Produit " + (i + 1));

            Produit produit = new Produit();
            produit.setId(idCounter++);

            System.out.print("Entrer nom produit: ");
            produit.setNom(scanner.nextLine());

            System.out.print("Entrer marque produit: ");
            produit.setMarque(scanner.nextLine());

            System.out.print("Entrer prix produit: ");
            produit.setPrix(scanner.nextDouble());
            scanner.nextLine();

            System.out.print("Entrer description produit: ");
            produit.setDescription(scanner.nextLine());

            System.out.print("Entrer nombre en stock produit: ");
            produit.setNombreEnStock(scanner.nextInt());
            scanner.nextLine();

            metierProduit.add(produit);

            System.out.println("-> Produit " + (i + 1) + " est inseré\n");

        }

        System.out.println("********************************************");
    }

    public static void rechercherProduit(Scanner scanner, MetierProduitImpl metierProduit) {
        System.out.println("\n************ RECHERCHER PRODUIT ************");
        System.out.print("Entrer id produit a rechercher: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Produit produit = metierProduit.findById(id);
        if (produit == null) {
            System.out.println("-> Product avec id '" + id + "' n'exist pas");
        } else {
            System.out.println("-> Produit trouvé:");
            System.out.println(produit);
        }
        System.out.println("********************************************");
    }

    public static void supprimerProduit(Scanner scanner, MetierProduitImpl metierProduit) {
        System.out.println("\n************ SUPPRIMER PRODUIT ************");
        System.out.print("Entrer id produit a supprimer: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Produit produit = metierProduit.findById(id);
        if (produit == null) {
            System.out.println("-> Product avec id '" + id + "' n'exist pas");
        } else {
            metierProduit.delete(id);
            System.out.println("-> Produit est supprimé!");
            System.out.println(produit);
        }
        System.out.println("********************************************");
    }
}
