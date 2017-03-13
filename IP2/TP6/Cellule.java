class Cellule {
  private Cellule precedente;
  private Cellule suivante;
  private boolean noire;
  private boolean prochainEtat;

	public Cellule(boolean noire) {
		this.precedente = null;
		this.suivante = null;
		this.noire = noire;
    this.prochainEtat = false;
  }

  public Cellule(boolean b, Cellule teteDeListe)  {
    Cellule cel = teteDeListe.derniere();
    cel.setSuivante(new Cellule(b));
    teteDeListe.derniere().setPrecedente(cel);
  }

  /**
  * @return la dernière cellule de la liste.
  */
  public Cellule derniere() {
    if(this.suivante == null) return this;
    return this.suivante.derniere();
  }

  public void afficher() {
    if(this.noire == true) System.out.print("#");
    else System.out.print("-");
  }

  public void afficherTout() {
    if(this.noire == true) System.out.print("#");
    else System.out.print("-");

    if(!(this.suivante == null)) this.suivante.afficherTout();
  }
  public void prochainEtape() {
    if(this.suivante == null || this.precedente == null) {
      if(this.suivante == null) {
        this.prochainEtat = !(!(this.noire) && !(this.precedente.isNoire()));
      } else {
        this.prochainEtat = !(!(this.noire) && !(this.suivante.isNoire()));
      }
      return;
    }
    if(!(this.suivante.isNoire()) && !(this.noire) && !(this.precedente.isNoire())) {
      this.prochainEtat = false;
      return;
    }
    if(this.suivante.isNoire() && this.noire && this.precedente.isNoire()) {
      this.prochainEtat = false;
      return;
    }
    this.prochainEtat = true;
  }

  public void miseAJour() {
    this.noire = this.prochainEtat;
    this.prochainEtat = false;
  }

  // GETTERS & SETTERS :

	public Cellule getPrecedente() {
		return precedente;
	}
	public void setPrecedente(Cellule precedente) {
		this.precedente = precedente;
	}
	public Cellule getSuivante() {
		return suivante;
	}
	public void setSuivante(Cellule suivante) {
		this.suivante = suivante;
	}
  public boolean isNoire() {
    return this.noire;
  }
	public void setNoire(boolean noire) {
		this.noire = noire;
	}

}
