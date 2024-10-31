import java.util.Scanner;

public class Main {
    public final static int CHOIX_AFFICHER_EMPLOYES = 1;
    public final static int CHOIX_AFFICHER_VEHICULES = 2;
    public final static int CHOIX_AJOUTER_EMPLOYE = 3;
    public final static int CHOIX_SUPPRIMER_EMPLOYES = 4;
    public final static int CHOIX_AJOUTER_VEHICULES = 5;
    public final static int CHOIX_SUPPRIMER_VEHICULES = 6;
    public final static int CHOIX_AFFICHER_COURSES = 7;
    public final static int CHOIX_AFFICHER_DETAILS_COURSE = 8;
    public final static int CHOIX_AJOUTER_EMPLOYE_COURSE = 9;
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

        // Ajout de courses
        ecurie.ajouterCourses(new Course("GP explorer", "Budapest"));
        ecurie.ajouterCourses(new Course("moto GP", "New York"));
        ecurie.ajouterCourses(new Course("GP explorer", "Budapest"));
        ecurie.ajouterCourses(new Course("GP explorer", "Budapest"));

        // Affichage des membres et véhicules de l'écurie
        System.out.println(ecurie + " : ");

        while (true) {
            afficherChoix();

            traiterChoix(saisirEntier("Quel choix voulez-vous faire ? "), ecurie);
        }
    }

    /**
     * affiche les choix d'action disponible pour l'utilisateur
     */
    public static void afficherChoix() {
        System.out.println("""
                
                [1]  Afficher les employés.
                [2]  Afficher les véhicules
                [3]  Ajouter des employés
                [4]  Supprimer des employés
                [5]  Ajouter des véhicules
                [6]  Supprimer des véhicules
                [7]  Afficher les courses
                [8]  Afficher les détails d'une course
                [9]  Ajouter un employé à une course
                [10] arreter le programme""");
    }

    public static void traiterChoix(int choix, Ecurie ecurie) {
        switch (choix) {
            case CHOIX_AFFICHER_EMPLOYES:
                ecurie.afficherEmployes();
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
                ecurie.afficherEmployes();
                ecurie.licencierPersonnel(saisirChaine("Saisir les employées à licencier : "));
                break;
            case CHOIX_AJOUTER_VEHICULES:
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

            case CHOIX_AFFICHER_COURSES:
                ecurie.afficherCourses();
                break;
            case CHOIX_AFFICHER_DETAILS_COURSE:
                ecurie.afficherCourses();
                ecurie.afficherDetailsCourse(saisirEntier("Quelle course voulez-vous voir en détail ? ") - 1);
                saisirChaine("Appuyez sur entrée pour continuer : ");
                break;
            case CHOIX_AJOUTER_EMPLOYE_COURSE:
                // choisir la course dans lequel ajouter un employé
                ecurie.afficherCourses();
                int indexCourse = saisirEntier("Dans quelle course voulez-vous ajouter un employé ? ") - 1;

                // choisir l'employé qui doit etre ajouter dans une course
                ecurie.afficherEmployes();
                Personne employeChoisi = ecurie.getEmployes().get(saisirEntier("Quel employé rejoint la course ? ") - 1);
                if (employeChoisi instanceof Pilote){
                    ecurie.ajouterPiloteAUneCourse(indexCourse, (Pilote)employeChoisi);
                } else if (employeChoisi instanceof ResponsableTechnique){
                    ecurie.ajouterResponsableTechniqueAUneCourse(indexCourse, (ResponsableTechnique) employeChoisi);
                } else {
                    System.out.println("L'employé doit être un responsable technique ou un pilote pour etre ajouter à une course.");
                }
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
