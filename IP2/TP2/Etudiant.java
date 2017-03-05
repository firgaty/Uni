class Etudiant {
  final String prenom ; // le prenom ,
  final String nom ; // le nom et
  double note ; // la note de l’etudiant ( sur 20).
  static int nombreDEtudiants = 0; // le nombre d’etudiants dans la promo
  static double sommeDesNotes = 0; // la somme des notes des etudiants
  /* A COMPLETER */

  /* Constructeur */

  Etudiant(String prenom, String nom, double note) {
    this.prenom = prenom;
    this.nom = nom;
    this.note = note;

    addNote(note);
    addEtudiant();

  }

  /* Méthodes */

  public void addNote(double note) {
    sommeDesNotes += note;
  }
  public void addEtudiant() {
    nombreDEtudiants += 1;
  }

  public void afficher() {
    System.out.println(this.nom + " " + this.prenom + " : " + this.note);
  }

  public boolean estAdmis() {
    if(this.note >= 10) {
      return true;
    } else {
      return false;
    }
  }

  public static double moyenne() {
    return sommeDesNotes / nombreDEtudiants;
  }

  public boolean estMeilleurQueLaMoyenne() {
    if(this.note > Etudiant.moyenne()) {
      return true;
    } else {
      return false;
    }
  }

  public void modifierNote(double nouvelleNote) {
    sommeDesNotes -= this.note;
    sommeDesNotes += nouvelleNote;
    this.note = nouvelleNote;
  }

}
