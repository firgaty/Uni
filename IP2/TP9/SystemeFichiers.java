class SystemeFichiers {
  private Noeud racine;

  public SystemeFichiers() {
    this.racine = new Noeud("", true);
  }

  public Noeud chercher(String nom) {
    return this.racine.chercher(nom);
  }

  public Noeud getRacine() {
    return this.racine;
  }

  public void mettreAJourTaille() {
    this.racine.calculerTaille();
  }

}
