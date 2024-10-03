public class Personne {
    private String nom;
    private String prenom;
    private float salaire;

    /**
     * construit un responsable technique avec son nom, prenom et salaire
     * @param nom       de la personne
     * @param prenom    de la personne
     * @param salaire   de la personne
     */
    public Personne(String nom, String prenom, float salaire){
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setSalaire(salaire);
    }

    /**
     * @return le nom de la personne
     */
    public String getNom() {
        return nom;
    }

    /**
     * assigne le nouveau nom passé en parametre a la variable nom
     *
     * @param nom de la personne
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return le prenom de la personne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * assigne le nouveau prenom passé en parametre a la variable prenom
     *
     * @param prenom de la personne
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return le salaire de la personne
     */
    public float getSalaire() {
        return salaire;
    }

    /**
     * assigne le nouveau salaire a la variable salaire
     *
     * @param salaire nouveau salaire de la personne
     */
    public void setSalaire(float salaire) {
        if (salaire > 0)
            this.salaire = salaire;
    }

    public String toString(){
        return "Je m'appelle "+ getPrenom() + " " + getNom() + ". J'ai un salaire de CHF" + getSalaire() + ". ";
    }
}
