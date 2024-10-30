import java.util.ArrayList;

public class Ecurie{
    private final ArrayList<Personne> Employes = new ArrayList<>();
    private final ArrayList<Vehicule> Vehicules = new ArrayList<>();
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
        Vehicules.add(nouveauVehicule);
    }

    /**
     * retire une voiture de la liste
     *
     * @param vehiculeAVendre véhicule a retirer de la liste
     */
    public void vendreVehicule(Vehicule vehiculeAVendre) {
        Vehicules.remove(vehiculeAVendre);
    }

    /**
     * retire un véhicule de la liste de véhicule
     *
     * @param indexVehicule du véhicule
     */
    public void vendreVehicule(int indexVehicule) {
        Vehicules.remove(indexVehicule);
    }

    /**
     * ajoute un employé dans la liste d'employé
     *
     * @param nouvelEmploye de l'écurie
     */
    public void employerPersonnel(Personne nouvelEmploye) {
        Employes.add(nouvelEmploye);
    }

    /**
     * retire du personnel passé en parametre
     * @param personnelALicencier personnel à licencier
     */
    public void licencierPersonnel(String personnelALicencier){
        int decallageIndex = 1;
        for (String employeQuiPart : personnelALicencier.split(" ")){
            Employes.remove(Integer.parseInt(employeQuiPart) - decallageIndex);
            decallageIndex++;
        }
    }

    /**
     * @return la liste des employés
     */
    public ArrayList<Personne> getEmployes() {
        return Employes;
    }

    /**
     * @return les véhicules de l'écurie
     */
    public ArrayList<Vehicule> getVehicules() {
        return Vehicules;
    }

    /**
     * affiche les véhicules de l'écurie
     */
    public void afficherVehicules(){
        for (int index = 0; index < Vehicules.size(); index++){
            System.out.println("Vehicule " + (index + 1) + " " + Vehicules.get(index));
        }
    }

    /**
     * affiche les employés de l'écurie
     */
    public void afficherEmployes(){
        for (int index = 0; index < Employes.size(); index++){
            System.out.println("Employe " + (index + 1) + " " + Employes.get(index));
        }
    }

    /**
     * ajoute l'employe passé en parametre à la liste d'employes
     * @param employe à ajouter dans la liste
     */
    public void ajouterEmploye(Personne employe) {
        Employes.add(employe);
    }

    /**
     * Retire les véhicules passés en parametre de l'écurie
     * @param strVehiculesASupprimer véhicules à vendre
     */
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
