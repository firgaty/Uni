public class Etudiant {
  String nom, prenom;
  int num;
  int note; // Toujours entre 0 et 20

  Etudiant(String nom, String prenom, int num, int note) {
    this.nom = nom;
    this.prenom = prenom;
    this.num = num;
    this.note = note;
  }

  public static void afficher(Etudiant etu) {
    System.out.println("Nom " + etu.nom + " Prénom " + etu.prenom + " (Numéro d'étudiant " + etu.num + " ) : Note " + etu.note);
  }
}
