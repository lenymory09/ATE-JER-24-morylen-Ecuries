import java.time.LocalDate;

public class Ingenieur extends Personne{

    /**
     * construit un ingénieur avec son nom, prenom et salaire
     * @param nom       de l'ingénieur
     * @param prenom    de l'ingénieur
     * @param salaire   de l'ingénieur
     */
    public Ingenieur(String nom, String prenom, float salaire) {
        super(nom, prenom, salaire);
    }

    public Vehicule conceptionnerVehicule(String modele){
        int anneeActuelle = LocalDate.now().getYear();
        return new Vehicule(modele, anneeActuelle);
    }

    /**
     * @return une description textuel de l'ingénieur
     */
    public String toString() {
        return super.toString() + "Ingénieur.";
    }
}
