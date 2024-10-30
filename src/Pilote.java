public class Pilote extends Personne{
    enum TypeVehicule {
        MOTO,
        VOITURE
    }

    private TypeVehicule typeVehicule = TypeVehicule.VOITURE;

    /**
     * construit un responsable technique avec son nom, prenom et salaire
     *
     * @param nom     de la personne
     * @param prenom  de la personne
     * @param salaire de la personne
     * @param typeVehicule que le pilote peut conduire
     */
    public Pilote(String nom, String prenom, float salaire, TypeVehicule typeVehicule) {
        super(nom, prenom, salaire);
        this.typeVehicule = typeVehicule;
    }

    /**
     * @return une description textuel du pilote
     */
    public String toString() {
        return super.toString() + "pilote.";
    }

    /**
     *
     * @param vehicule
     */
    public void conduire(Vehicule vehicule, Course course){
        if (typeVehicule == TypeVehicule.MOTO) {
            if (vehicule instanceof Moto)
                System.out.println(this + "conduit " + ((Moto)vehicule));
            else
                System.out.println(this + " ne peut pas conduire de moto.");
        } else {
            if (vehicule instanceof Voiture)
                System.out.println(this + "conduit " + ((Voiture)vehicule));
            else
                System.out.println(getPrenom() + " " + getNom() + " ne peut pas conduire de voiture.");
        }
    }
}
