public class Pilote extends Personne{
    enum TypeVéhicule {
        MOTO,
        VOITURE
    }

    private TypeVéhicule typeVéhicule = TypeVéhicule.VOITURE;

    /**
     * construit un responsable technique avec son nom, prenom et salaire
     *
     * @param nom     de la personne
     * @param prenom  de la personne
     * @param salaire de la personne
     * @param typeVehicule que le pilote peut conduire
     */
    public Pilote(String nom, String prenom, float salaire, TypeVéhicule typeVehicule) {
        super(nom, prenom, salaire);
        this.typeVéhicule = typeVehicule;
    }

    /**
     * @return une description textuel du pilote
     */
    public String toString() {
        return super.toString() + "Je suis un pilote.";
    }

}
