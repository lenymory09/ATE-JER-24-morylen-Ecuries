public class Voiture extends Vehicule{
    /**
     * construit une voiture avec son modele et sa date de création
     * @param modele          de la voiture
     * @param anneeDeCreation de la voiture
     */
    public Voiture(String modele, int anneeDeCreation) {
        super(modele, anneeDeCreation);
    }

    /**
     * construit une voiture avec l'année de naissance par défaut et son modele
     * @param modele de la voiture
     */
    public Voiture(String modele) {
        super(modele);
    }

    /**
     * retourne une description de la voiture
     * @return la chaine de caractère
     */
    public String toString() {
        return this.getClass().getName() + ", " + super.toString();
    }
}
