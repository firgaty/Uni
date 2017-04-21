class Noeud {
  private Lettre etiquette;
  private Noeud gauche;
  private Noeud droit;
  public Noeud(char c, int p, Noeud g, Noeud d){
    this.gauche = g;
    this.droit = d;
    this.etiquette = new Lettre(c, p);
  }
  public Noeud(char c, int p){
    this.gauche = null;
    this.droit = null;
    this.etiquette = new Lettre(c, p);
  }
}
