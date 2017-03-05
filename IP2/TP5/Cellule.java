class Cellule {
  private Employe emp;
  private Cellule suivant;

  public Cellule(Employe emp) {
    this.emp = emp;
    this.suivant = null;
  }
  public Cellule(Employe emp, Cellule suiv) {
    this.emp = emp;
    this.suivant = suiv;
  }
  public Cellule() {
    this.emp = null;
    this.suivant = null;
  }

  // Methodes:

  public void affiche() {
    this.emp.afficher();
    if(this.suivant == null) return;
    this.suivant.affiche();
  }

  public boolean appartient(String nom) {
    if(this.emp.getNom() == nom) return true;
    if(this.suivant == null) return false;
    return this.suivant.appartient(nom);
  }

  public void demission(String nom) {
    if(this.suivant.getEmploye().getNom() == nom) {
      if(this.suivant.getSuiv() == null) {
        this.suivant = null;
        return;
      }
      this.suivant = this.suivant.getSuiv();
      return;
    }
    if(this.suivant == null) return;
    this.suivant.demission(nom);
    return;
  }

  public Cellule choixSalaire(int min, int max) {
    if(this.emp.getSalaire() >= min && this.emp.getSalaire() <= max) {
      Cellule cel = new Cellule(this.emp);
      if(this.suivant == null) return cel;
      cel.setSuiv(this.suivant.choixSalaire(min, max));
      return cel;
    }
    if(this.suivant == null) return null;
    return this.suivant.choixSalaire(min, max);
  }

  public Cellule choixSalaire2(int min, int max) {
    if(this.emp.getSalaire() >= min && this.emp.getSalaire() <= max) {
      if(this.suivant == null) return this;
      this.suivant = this.suivant.choixSalaire2(min, max);
      return this;
    }
    if(this.suivant == null) return null;
    return this.suivant.choixSalaire2(min, max);
  }

  public boolean croissante() {
    if(this.suivant == null) return true;
    if(this.suivant.getEmploye().getSalaire() < this.emp.getSalaire()) return false;

    return this.suivant.croissante();
  }

  public void ajout(Employe emp) {
    if(this.suivant == null) {
      this.suivant = new Cellule(emp);
      return;
    }
    if(this.suivant.getEmploye().getSalaire() > emp.getSalaire()) {
      this.suivant = new Cellule(emp, this.suivant);
      return;
    }
    this.suivant.ajout(emp);
    return;
  }

  // GETTERS & SETTERS :

  public Employe getEmploye() {
    return this.emp;
  }

  public Employe getEmploye(String nom) {
    if(this.emp.getNom() == nom) return this.emp;
    if(this.suivant == null) return null;
    return this.suivant.getEmploye(nom);
  }

  public Cellule getSuiv() {
    return this.suivant;
  }

  public void setEmp(Employe emp) {
    this.emp = emp;
  }
  public void setSuiv(Cellule suiv) {
    this.suivant = suiv;
  }
}
