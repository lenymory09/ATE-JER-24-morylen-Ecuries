import java.time.LocalDate;

public class Vehicule {
    private String modele;
    private int anneeDeCreation = LocalDate.now().getYear();
    boolean estUtilise = false;

    /**
     * construit un véhicule avec son modele et sa date de création
     * @param modele de la voiture
     * @param anneeDeCreation de la voiture
     */
    public Vehicule(String modele, int anneeDeCreation) {
        this.setModele(modele);
        this.setAnneeDeCreation(anneeDeCreation);
    }

    /**
     * construit un modele avec l'année de naissance par défaut et son modele
     * @param modele de la voiture
     */
    public Vehicule(String modele){
        this.setModele(modele);
    }

    /**
     * @return le modele du véhicule
     */
    public String getModele() {
        return modele;
    }

    /**
     * assigne le nouveau modele a la variable modele
     *
     * @param modele nouveau modele du véhicule
     */
    public void setModele(String modele) {
        if (!modele.isEmpty())
            this.modele = modele;
    }

    /**
     * @return l'annee de création du véhicule
     */
    public int getAnneeDeCreation() {
        return anneeDeCreation;
    }

    /**
     * initialise l'année de création passé en parametre au véhicule
     * @param anneeDeCreation de la voiture
     */
    public void setAnneeDeCreation(int anneeDeCreation) {
        int anneeActuelle = LocalDate.now().getYear();
        if (anneeDeCreation > 1850 && anneeDeCreation <= anneeActuelle)
            this.anneeDeCreation = anneeDeCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return anneeDeCreation == vehicule.anneeDeCreation && modele.equals(vehicule.modele);
    }

    /**
     * @return une description textuelle du véhicule
     */
    public String toString(){
        return "Modele : " + getModele() + ", Annee de création : " + getAnneeDeCreation();
    }
}
