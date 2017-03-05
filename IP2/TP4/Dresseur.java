public class Dresseur {
  public final String nom;
  private Pokeball premiere;

  public Dresseur(String nom) {
    this.nom = nom;
  }

  public void afficher() {
    System.out.println(this.nom);
    boolean t = true;
    Pokeball pok = premiere;
    while (t) {
      pok.afficher();
      System.out.print(" ");
      if(pok.getSuivante() == null) {
        t = false;
      } else {
        pok = pok.getSuivante();
      }
    }
  }

  public void ajouterPokemon(Pokemon pok) {
    if(this.premiere == null) {
      this.premiere = new Pokeball(pok);
    } else {
      Pokeball i = this.premiere;
      while(i.getSuivante() != null) {
        i = i.getSuivante();
      }
      i.setSuivante(new Pokeball(pok));
    }
    return;
  }

  public Pokemon get(int n) {
    if(this.premiere == null) return null;

    Pokeball i = this.premiere;
    for(int j = 0; j < n; j++) {
      if(i.getSuivante() == null) return null;
      i = i.getSuivante();
    }
    return i.getPokemon();
  }

  public void remove(int n) {

    Pokeball b = this.premiere;
    for(int i = 1; i < n - 1; i++) {
      b = b.getSuivante();
    }
    b.setSuivante(b.getSuivante().getSuivante());
    return;
  }

  public String typeFavoris() {
    if(this.premiere == null) return new String("none");
    int i = 0;
    int[] listeType = new int[3];
    listeType[0] = 0;
    listeType[1] = 0;
    listeType[2] = 0;
    while(this.get(i) != null) {
      switch (this.get(i).getType()) {
        case "feu" : listeType[0] += 1;
        break;
        case "eau" : listeType[1] += 1;
        break;
        case "plante" : listeType[2] += 1;
        break;
      }
      i++;
    }

    if (listeType[0] > listeType[1] && listeType[0] > listeType[2]) {
      return new String("feu");
    } else if (listeType[1] > listeType[0] && listeType[1] > listeType[2]) {
      return new String("eau");
    } else if (listeType[2] > listeType[0] && listeType[2] > listeType[1]) {
      return new String("plante");
    } else {
      return new String("none");
    }
  }

}
