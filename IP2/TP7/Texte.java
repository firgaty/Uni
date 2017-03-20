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
  public void supprimer() {
    if(this.curseur.getSuivante() == null && this.curseur.getPrecedente() == null) {
      this.premiere = new Ligne("");
      this.curseur = this.premiere;
    } else if (this.curseur.getSuivante() == null) {
      this.curseur = this.curseur.getPrecedente();
      this.curseur.getSuivante().setPrecedente(null);
      this.curseur.setSuivante(null);
    } else if (this.curseur.getPrecedente() == null) {
      this.premiere = this.premiere.getSuivante();
      this.premiere.setPrecedente(null);
      this.curseur = this.premiere;
    } else {
      this.curseur.getPrecedente().setSuivante(this.curseur.getSuivante());
      this.curseur = this.curseur.getPrecedente();
      this.curseur.getSuivante().setPrecedente(this.curseur);
    }
  }
  public void allerA (int ligne) {
    Ligne l = this.premiere;
    for(int i = 0; i < ligne; i++) {
      if(l.getSuivante() == null) {
        this.curseur = l; // Dans le cas où la ligne demandée est plus grande que le nombre de ligne dans le texte, on se place à la dernière ligne.
        return;
      }
      l = l.getSuivante();
    }
    this.curseur = l;
  }

  public void couper() {
    this.pressePapier = new Ligne(this.curseur.getValeur());
    this.supprimer();
  }

  public void couper(int N) {
    if(1 > N) return;
    this.pressePapier = this.curseur;
    Ligne a = (this.curseur == this.premiere) ? null : this.curseur.getPrecedente();
    Ligne b = this.pressePapier;

    for(int i = 0; i < N; i ++) {
      if(this.curseur.getSuivante() == null) {
        break;
      }
      this.curseur = this.curseur.getSuivante();
      b = b.getSuivante();
    }
    // On efface les relations du pressePapier avec les lignes du texte :
    b.setSuivante(null);
    this.pressePapier.setPrecedente(null);

    // On supprime dansle texte et on place le curseur au bon endroit :
    this.curseur.getSuivante().setPrecedente(a);
    if(a == null) this.premiere = this.curseur.getSuivante();
  }

  public void coller() {
    if(this.pressePapier == null) return;

    Ligne ligne = this.pressePapier;

    if(this.curseur.getPrecedente() == null) {
      this.premiere = ligne;
    } else {
      this.curseur.getPrecedente().setSuivante(ligne);
      this.pressePapier.setPrecedente(this.curseur.getPrecedente());
    }


    if(ligne.getSuivante() != null) {
      while(ligne.getSuivante() != null) {
        ligne = ligne.getSuivante();
        System.out.println(ligne.getValeur());
      }
    }
    ligne.setSuivante(this.curseur);
    this.curseur.setPrecedente(ligne);
    this.pressePapier = null; // On vide le presse papier.
  }
  public void copier() {
    this.pressePapier = new Ligne(this.curseur.getValeur());
  }
  public void copier(int N) {
    if(1 > N) return;

    Ligne debut = new Ligne(this.curseur.getValeur());
    Ligne n = debut;
    Ligne curseur = this.curseur;

    for(int i = 1; i < N; i ++) {
      if(curseur.getSuivante() == null) break;

      n.setSuivante(new Ligne(curseur.getValeur()));
      n = n.getSuivante();
      curseur = curseur.getSuivante();
    }
    this.pressePapier = debut;
  }
}
