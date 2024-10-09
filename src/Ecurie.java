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

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();

        description.append(nom).append(" : \n");
        description.append("Employees : \n");

        for (Personne employe : listeEmployes) {
            description.append(employe.toString()).append("\n");
        }

        description.append("Véhicules : \n");
        for (Vehicule vehicule : listeVehicules) {
            description.append(vehicule.toString()).append("\n");
        }

        return description.toString();
    }
}