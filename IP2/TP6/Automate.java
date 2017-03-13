class Automate {
  private Cellule premiereCellule;

  public Automate() {
    this.premiereCellule = null;
  }

  public Automate(String str) {
    this.premiereCellule = new Cellule((str.charAt(0) == '#') ? true : false);
    for(int i = 1; i < str.length(); i++) {
      new Cellule((str.charAt(i) == '#') ? true : false, this.premiereCellule);
    }
  }

  public void initialisation() {
    this.premiereCellule = new Cellule(true);
    new Cellule(true, this.premiereCellule);
    new Cellule(true, this.premiereCellule);
    new Cellule(false, this.premiereCellule);
    new Cellule(false, this.premiereCellule);
    new Cellule(false, this.premiereCellule);
    new Cellule(true, this.premiereCellule);
    new Cellule(false, this.premiereCellule);
    new Cellule(false, this.premiereCellule);
    new Cellule(false, this.premiereCellule);
    new Cellule(false, this.premiereCellule);
  }

  public void afficher() {
    this.premiereCellule.afficherTout();
  }

  public void uneEtape() {
    Cellule cel = premiereCellule;

    while(cel.getSuivante() != null) {
      cel.prochainEtape();
      cel = cel.getSuivante();
    }
    cel.prochainEtape();

    while(cel.getPrecedente() != null) {
      cel.miseAJour();
      cel = cel.getPrecedente();
    }
    cel.miseAJour();
  }

  public void nEtapes(int n) {
    this.afficher();

    for(int i = 0; i < n; i++) {
      System.out.println("");
      this.uneEtape();
      this.afficher();
    }
  }
}
