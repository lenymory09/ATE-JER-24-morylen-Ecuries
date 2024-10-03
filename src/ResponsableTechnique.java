public class ResponsableTechnique extends Personne{

    /**
     * construit un responsable technique avec son nom, prenom et salaire
     * @param nom       du responsable technique
     * @param prenom    du responsable technique
     * @param salaire   du responsable technique
     */
    public ResponsableTechnique(String nom, String prenom, float salaire) {
        super(nom, prenom, salaire);
    }

    /**
     * vérifie le véhicule passé en parametre
     * @param vehiculeAVerifier à vérifier
     */
    public void verifierVehicule(Vehicule vehiculeAVerifier){
        System.out.println(getNom() + " vérifie le véhicule : " + vehiculeAVerifier);
    }

    /**
     * repare le véhicule passé en parametre
     * @param vehiculeAReparer   véhicule à réparer
     */
    public void reparerVehicule(Vehicule vehiculeAReparer){
        System.out.println("Le véhicule : " + vehiculeAReparer + " a ete réparé.");
    }

    /**
     * @return une description textuel du responsable technique
     */
    public String toString() {
        return super.toString() + "Je suis un responsable technique.";
    }

}
