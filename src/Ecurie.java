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
     * @param vehiculeAVendre      véhicule a retirer de la liste
     */
    public void vendreVehicule(Vehicule vehiculeAVendre) {
        listeVehicules.removeIf(vehicule -> vehicule == vehiculeAVendre);
    }
}
