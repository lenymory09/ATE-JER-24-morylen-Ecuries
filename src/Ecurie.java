import java.util.ArrayList;

public class Ecurie {
    private final ArrayList<Personne> employes = new ArrayList<>();
    private final ArrayList<Vehicule> vehicules = new ArrayList<>();
    private String nom = "Ecurie";
    private ArrayList<Course> courses = new ArrayList<>();

    /**
     * construit un écurie avec un nom passé en parametre
     */
    public Ecurie(String nom) {
        this.nom = nom;
    }

    /**
     * construit un écurie avec les parametres par défaut
     */
    public Ecurie() {
    }

    /**
     * ajoute un véhicule a la liste de véhicule
     *
     * @param nouveauVehicule de la liste
     */
    public void ajouterVehicule(Vehicule nouveauVehicule) {
        vehicules.add(nouveauVehicule);
    }

    /**
     * retire une voiture de la liste
     *
     * @param vehiculeAVendre véhicule a retirer de la liste
     */
    public void vendreVehicule(Vehicule vehiculeAVendre) {
        vehicules.remove(vehiculeAVendre);
    }

    /**
     * retire un véhicule de la liste de véhicule
     *
     * @param indexVehicule du véhicule
     */
    public void vendreVehicule(int indexVehicule) {
        vehicules.remove(indexVehicule);
    }

    /**
     * ajoute un employé dans la liste d'employé
     *
     * @param nouvelEmploye de l'écurie
     */
    public void employerPersonnel(Personne nouvelEmploye) {
        employes.add(nouvelEmploye);
    }

    /**
     * retire du personnel passé en parametre
     *
     * @param personnelALicencier personnel à licencier
     */
    public void licencierPersonnel(String personnelALicencier) {
        int decallageIndex = 1;
        for (String employeQuiPart : personnelALicencier.split(" ")) {
            employes.remove(Integer.parseInt(employeQuiPart) - decallageIndex);
            decallageIndex++;
        }
    }

    /**
     * @return la liste des employés
     */
    public ArrayList<Personne> getEmployes() {
        return employes;
    }

    /**
     * @return les véhicules de l'écurie
     */
    public ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }

    /**
     * affiche les véhicules de l'écurie
     */
    public void afficherVehicules() {
        for (int index = 0; index < vehicules.size(); index++) {
            System.out.println("Vehicule " + (index + 1) + " " + vehicules.get(index));
        }
    }

    /**
     * affiche les employés de l'écurie
     */
    public void afficherEmployes() {
        for (int index = 0; index < employes.size(); index++) {
            System.out.println("Employe " + (index + 1) + " " + employes.get(index));
        }
    }

    /**
     * ajoute l'employe passé en parametre à la liste d'employes
     *
     * @param employe à ajouter dans la liste
     */
    public void ajouterEmploye(Personne employe) {
        employes.add(employe);
    }

    /**
     * Retire les véhicules passés en parametre de l'écurie
     *
     * @param strVehiculesASupprimer véhicules à vendre
     */
    public void vendrePlusieursVehicules(String strVehiculesASupprimer) {
        String[] vehiculesASupprimer = strVehiculesASupprimer.split(" ");

        int decallageIndex = 1;
        for (String vehicule : vehiculesASupprimer) {
            vendreVehicule(Integer.parseInt(vehicule) - decallageIndex);
            decallageIndex++;
        }
    }

    /**
     * ajoute une course a la liste de courses
     *
     * @param nouvelleCourse à ajouter dans la liste
     */
    public void ajouterCourses(Course nouvelleCourse) {
        courses.add(nouvelleCourse);
    }

    /**
     * affiche les courses de la liste des courses
     */
    public void afficherCourses() {
        for (int index = 0; index < courses.size(); index++) {
            System.out.println("Course " + (index + 1) + " : " + courses.get(index));
        }
    }


    /**
     * ajoute un participant a une course
     * @param indexCourse index de la course dans la liste des courses
     * @param pilote qui va etre ajouter dans la course
     */
    public void ajouterPiloteAUneCourse(int indexCourse, Pilote pilote) {
        Course course = courses.get(indexCourse);
        // Vérifie que le pilote n'est pas déja dans une course
        boolean dejaEnCourse = false;
        for (Course courseTemp : courses){
            if (courseTemp.responsableTechniques.contains(pilote)){
                dejaEnCourse = true;
                break;
            }
        }
        if (dejaEnCourse){
            System.out.println(pilote + " est déja dans une course.");
        } else {
            course.participants.add(pilote);
        };

    }

    /**
     * ajoute un responsable technique à une course
     * @param indexCourse index de la course
     * @param responsableTechnique qui doit etre ajouté
     */
    public void ajouterResponsableTechniqueAUneCourse(int indexCourse, ResponsableTechnique responsableTechnique){
        Course course = courses.get(indexCourse);
        // Vérifie que le responsable technique n'est pas déjà dans une course
        boolean dejaEnCourse = false;
        for (Course courseTemp : courses){
            if (courseTemp.responsableTechniques.contains(responsableTechnique)){
                dejaEnCourse = true;
                break;
            }
        }
        if (dejaEnCourse){
            System.out.println(responsableTechnique + " est déjà dans une course;");
        }
        course.responsableTechniques.add(responsableTechnique);
    }

    /**
     * affiche les détail d'une course
     * @param indexCourse index de la course
     */
    public void afficherDetailsCourse(int indexCourse){
        Course course = courses.get(indexCourse);
        System.out.println(course);

        // Affichage des participants / pilotes
        for (int indexParticipants = 0; indexParticipants < course.participants.size(); indexParticipants++){
            Pilote participantActuel = course.participants.get(indexParticipants);
            System.out.println("Participant " + (indexParticipants + 1) + " : " + participantActuel);
        }

        // Affichage des responsables techniques
        for (int indexResponsableTechnique = 0; indexResponsableTechnique < course.responsableTechniques.size(); indexResponsableTechnique++){
            ResponsableTechnique responsableTechnique = course.responsableTechniques.get(indexResponsableTechnique);
            System.out.println("Responsable technique " + indexResponsableTechnique + " : " + responsableTechnique);
        }
    }

    /**
     * @return le nom de l'écurie
     */
    @Override
    public String toString() {
        return nom;
    }
}
