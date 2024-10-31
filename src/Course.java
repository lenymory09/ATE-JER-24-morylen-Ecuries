import java.util.ArrayList;

public class Course {
    String nom;
    String lieu;
    ArrayList<Pilote> participants = new ArrayList<>();
    ArrayList<ResponsableTechnique> responsableTechniques = new ArrayList<>();

    /**
     * construit une course avec un nom passé en paramètre
     * @param nom de la course
     */
    public Course(String nom, String lieu){
        this.nom = nom;
        this.lieu = lieu;
    }

    public String toString(){
        return nom + " (" + lieu + ")";
    }

}
