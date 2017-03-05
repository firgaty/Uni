public class Pokeball {
  private Pokemon pok;
  private Pokeball suivante;

  public Pokeball(Pokemon p) {
    this.pok = p;
  }
  public Pokeball(Pokemon p, Pokeball b) {
    this.pok = p;
    this.suivante = b;
  }

  public void afficher() {
    System.out.print(pok.getNom());
    return;
  }
  // GETTERS & SETTERS.

  public Pokeball getSuivante() {
    return this.suivante;
  }

  public void setSuivante(Pokeball b) {
    this.suivante  = b;
    return;
  }

  public Pokemon getPokemon() {
    return this.pok;
  }
}
