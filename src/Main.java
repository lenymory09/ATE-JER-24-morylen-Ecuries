public class Main {
    public static void main(String[] args) {
        Ecurie ecurie = new Ecurie("GOATED ecurie");

        // ajout de véhicule
        ecurie.ajouterVehicule(new Voiture("Ferrari", 1999));
        ecurie.ajouterVehicule(new Voiture("Lamborgini", 2020));
        ecurie.ajouterVehicule(new Moto("GT 9/11", 2001));

        // ajout de personnel
        ecurie.employerPersonnel(new Ingenieur("Frein", "James", 19999));
        ecurie.employerPersonnel(new Pilote("Fedele", "Luca", 19999, Pilote.TypeVehicule.MOTO));
        ecurie.employerPersonnel(new ResponsableTechnique("Mory", "Leny", 19999));

        for (Personne employe : ecurie.getListeEmployes()){
            if (employe instanceof Ingenieur){
                ((Ingenieur) employe).conceptionnerVehicule("ferariri");
            } else if (employe instanceof Pilote){
                ((Pilote) employe).conduire(ecurie.getListeVehicules().get(1));
            } else {
                ((ResponsableTechnique) employe).reparerVehicule(ecurie.getListeVehicules().getFirst());
            }
        }

        // Affichage des membres et véhicules de l'écurie
        System.out.println(ecurie);
    }
}
