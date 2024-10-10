import java.util.ArrayList;

public class Ecurie {
    private final ArrayList<Personne> listeEmployes = new ArrayList<>();
    private final ArrayList<Vehicule> listeVehicules = new ArrayList<>();
    String nom = "Ecurie";

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
        listeVehicules.add(nouveauVehicule);
    }

    /**
     * retire une voiture de la liste
     *
     * @param vehiculeAVendre véhicule a retirer de la liste
     */
    public void vendreVehicule(Vehicule vehiculeAVendre) {
        listeVehicules.removeIf(vehicule -> vehicule == vehiculeAVendre);
    }

    /**
     * retire un véhicule de la liste de véhicule
     *
     * @param indexVehicule du véhicule
     */
    public void vendreVehicule(int indexVehicule) {
        listeVehicules.remove(indexVehicule);
    }

    /**
     * ajoute un employé dans la liste d'employé
     *
     * @param nouvelEmploye de l'écurie
     */
    public void employerPersonnel(Personne nouvelEmploye) {
        listeEmployes.add(nouvelEmploye);
    }

    /**
     * retire un employé d'une liste d'employé
     *
     * @param employe employé a retirer de la liste
     */
    public void virerPersonnel(Personne employe) {
        listeEmployes.remove(employe);
    }

    public void virerPersonnel(int indexEmploye) {
        listeEmployes.remove(indexEmploye);
    }

    public ArrayList<Personne> getListeEmployes() {
        return listeEmployes;
    }

    public ArrayList<Vehicule> getListeVehicules() {
        return listeVehicules;
    }

    public void afficherListeVehicule(){
        for (int index = 0; index < listeVehicules.size(); index++){
            System.out.println("Vehicule " + (index + 1) + " " + listeVehicules.get(index));
        }
    }

    public void afficherListeEmploye(){
        for (int index = 0; index < listeEmployes.size(); index++){
            System.out.println("Employe " + (index + 1) + " " + listeEmployes.get(index));
        }
    }

    /**
     * ajoute l'employe passé en parametre à la liste d'employes
     * @param employe à ajouter dans la liste
     */
    public void ajouterEmploye(Personne employe) {
        listeEmployes.add(employe);
    }

    public void vendrePlusieursVehicules(String strVehiculesASupprimer){
        String[] vehiculesASupprimer = strVehiculesASupprimer.split(" ");

        for (String vehicule : vehiculesASupprimer){
            vendreVehicule(Integer.parseInt(vehicule) - 1);
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
