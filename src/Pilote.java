public class Pilote extends Personne {
    enum TypeVehicule {
        MOTO,
        VOITURE
    }

    private Vehicule vehicule;
    private TypeVehicule typeVehicule = TypeVehicule.VOITURE;

    /**
     * construit un responsable technique avec son nom, prenom et salaire
     *
     * @param nom          de la personne
     * @param prenom       de la personne
     * @param salaire      de la personne
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
        return super.toString() + "pilote. Conduit " + vehicule;
    }

    /**
     * conduire un véhicule
     *
     * @param vehicule conduit par le pilote
     */
    public void conduire(Vehicule vehicule) {
        if (typeVehicule == TypeVehicule.MOTO) {
            if (vehicule instanceof Moto)
                System.out.println(this + "conduit " + ((Moto) vehicule));
            else
                System.out.println(this + " ne peut pas conduire de moto.");
        } else {
            if (vehicule instanceof Voiture)
                System.out.println(this + "conduit " + ((Voiture) vehicule));
            else
                System.out.println(getPrenom() + " " + getNom() + " ne peut pas conduire de voiture.");
        }
    }

    /**
     * set le véhicule avec celui passé en parametre
     *
     * @param vehicule du pilote
     */
    public void setVehicule(Vehicule vehicule) {
        if (((vehicule instanceof Voiture &&
                typeVehicule == TypeVehicule.VOITURE) ||
                (vehicule instanceof Moto &&
                        typeVehicule == TypeVehicule.MOTO)) &&
                !vehicule.estUtilise) {
            this.vehicule = vehicule;
            vehicule.estUtilise = true;
        }
    }

    @Override
    public boolean equals(Object o) {
        Pilote pilote = (Pilote)o;
        return super.equals(o) && vehicule.equals(pilote.vehicule) && typeVehicule == pilote.typeVehicule;
    }
}
