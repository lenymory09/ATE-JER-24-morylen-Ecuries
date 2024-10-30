import java.util.Scanner;

public class Main {
    public final static int CHOIX_AFFICHER_EMPLOYES = 1;
    public final static int CHOIX_AFFICHER_VEHICULES = 2;
    public final static int CHOIX_AJOUTER_EMPLOYE = 3;
    public final static int CHOIX_SUPPRIMER_EMPLOYES = 4;
    public final static int CHOIX_AJOUTER_VEHICULES = 5;
    public final static int CHOIX_SUPPRIMER_VEHICULES = 6;
    public final static int CHOIX_VOIR_COURSES = 7;
    public final static int CHOIX_FAIRE_CONDUIRE_PILOTE = 8;
    public final static int CHOIX_ARRETER_PROGRAMME = 0;

    public static void main(String[] args) {

        Ecurie ecurie = new Ecurie("GOATED ecurie");

        // ajout de véhicule
        ecurie.ajouterVehicule(new Voiture("Ferrari", 1999));
        ecurie.ajouterVehicule(new Voiture("Lamborgini", 2020));
        ecurie.ajouterVehicule(new Moto("GT 2/12", 2009));

        // ajout de personnel
        ecurie.employerPersonnel(new Ingenieur("DZ", "Algerino", 19999));
        ecurie.employerPersonnel(new Pilote("Fedele", "Luca", 19999, Pilote.TypeVehicule.MOTO));
        ecurie.employerPersonnel(new ResponsableTechnique("Mory", "Leny", 19999));

        // Affichage des membres et véhicules de l'écurie
        System.out.println(ecurie + " : ");

        while (true) {
            afficherChoix();

            traiterChoix(saisirEntier("Quel choix voulez-vous faire ? "), ecurie);
        }
    }

    public static void afficherChoix() {
        System.out.println("""
                [1] Afficher les employés.
                [2] Voir les véhicules
                [3] Ajouter des employés
                [4] Supprimer des employés
                [5] Ajouter des véhicules
                [6] supprimer des véhicules
                [7] arreter le programme""");
    }

    public static void traiterChoix(int choix, Ecurie ecurie) {
        switch (choix) {
            case CHOIX_AFFICHER_EMPLOYES:
                ecurie.afficherListeEmploye();
                break;
            case CHOIX_AFFICHER_VEHICULES:
                ecurie.afficherVehicules();
                break;
            case CHOIX_AJOUTER_EMPLOYE:
                switch (saisirEntier("Ingenieur [1], Responsable technique [2] ou Pilote [3] ? ")) {
                    case 1:
                        ecurie.ajouterEmploye(new Ingenieur(saisirChaine("Nom : "), saisirChaine("Prenom : "), saisirEntier("Salaire : ")));
                        break;
                    case 2:
                        ecurie.ajouterEmploye(new ResponsableTechnique(saisirChaine("Nom : "), saisirChaine("Prenom : "), saisirEntier("Salaire : ")));
                        break;
                    case 3:
                        switch (saisirEntier("Spécialiste Moto [1] ou Voiture [2] ? ")) {
                            case 1:
                                ecurie.ajouterEmploye(new Pilote(saisirChaine("Nom : "), saisirChaine("Prenom : "), saisirEntier("Salaire : "), Pilote.TypeVehicule.MOTO));
                                break;
                            case 2:
                                ecurie.ajouterEmploye(new Pilote(saisirChaine("Nom : "), saisirChaine("Prenom : "), saisirEntier("Salaire : "), Pilote.TypeVehicule.VOITURE));
                                break;
                        }
                        break;
                }
                break;
            case CHOIX_SUPPRIMER_EMPLOYES:
                ecurie.afficherListeEmploye();
                ecurie.licencierPersonnel(saisirChaine("Saisir les employées à licencier : "));
                break;
            case CHOIX_AJOUTER_VEHICULES:
                System.out.println("Moto [1] ou Voiture [2] ?");
                switch (saisirEntier("Moto [1] ou Voiture [2] ? ")) {
                    case 1:
                        ecurie.ajouterVehicule(new Moto(saisirChaine("Modele : "), saisirEntier("Annee de conception : ")));
                        break;
                    case 2:
                        ecurie.ajouterVehicule(new Voiture(saisirChaine("Modele : "), saisirEntier("Annee de conception : ")));
                        break;
                }
                break;
            case CHOIX_SUPPRIMER_VEHICULES:
                ecurie.afficherVehicules();
                ecurie.vendrePlusieursVehicules(saisirChaine("Quels véhicules voulez-vous vendre ? "));
                break;
        }
    }


    /**
     * permet de saisir une chaine
     *
     * @param prompt à afficher pour l'utilisateur
     * @return la chaine saisie par l'utilisateur
     */
    public static String saisirChaine(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * permet de saisir un nombre
     *
     * @param prompt à afficher pour l'utilisateur
     * @return le nombre saisi par l'utilisateur
     */
    public static int saisirEntier(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
