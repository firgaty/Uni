class Texte {
  private Ligne premiere;
  private Ligne curseur; // indique la position du curseur
  private Ligne pressePapier;

  public Texte() {
    premiere = new Ligne("");
    curseur = premiere;
    pressePapier = null;
  }

  public void avancerCurseur() {
    if(this.curseur.getSuivante() != null) {
      this.curseur = this.curseur.getSuivante();
    }
  }
  public void reculerCurseur() {
    if(this.curseur.getPrecedente() != null) {
      this.curseur = this.curseur.getPrecedente();
    }
  }
  public void ajouterLigne() {
    this.curseur.setSuivante(new Ligne(""));
    this.curseur.getSuivante().setPrecedente(this.curseur);
    this.curseur = this.curseur.getSuivante();
  }
  public void ecrire(String ligne) {
    this.curseur.setValeur(ligne);
  }
  public void afficher() {
    System.out.println(premiere.getValeur());

    if (this.premiere.getSuivante() == null) {
      return;
    }
    Ligne ligne = this.premiere;

    do {
      ligne = ligne.getSuivante();
      System.out.println(ligne.getValeur());
    } while (ligne.getSuivante() != null);
  }
}
