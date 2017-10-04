public class Joueur {
    private String nom;
    
    public Joueur(){
        //Par défaut, le nom du joueur est "Anonyme". Le constructeur initialise un scan qui pourra vous être utile.
        scan = new Scanner(System.in);
        nom = "Anonyme";
    }
}
