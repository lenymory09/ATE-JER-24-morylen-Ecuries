public class Moto extends Vehicule{

    /**
     * construit une moto avec son modele et sa date de création
     * @param modele de la moto
     * @param anneeDeCreation de la moto
     */
    public Moto(String modele, int anneeDeCreation) {
        super(modele, anneeDeCreation);
    }

    /**
     * construit une moto avec l'année de naissance par défaut et son modele
     * @param modele de la moto
     */
    public Moto(String modele) {
        super(modele);
    }

    /**
     * retourne une description de la moto
     * @return la chaine de caractere
     */
    public String toString() {
        return this.getClass().getName() + ", " + super.toString();
    }
}
