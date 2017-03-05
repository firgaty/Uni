class Entreprise {
  private String nom;
  private Cellule premier;

  public Entreprise(String nom) {
    this.nom = nom;
  }
  public Entreprise(String nom, Cellule premier) {
    this.nom = nom;
    this.premier = premier;
  }

  public void affiche() {
    System.out.println(this.nom + " :");
    if(!premierExiste()) {
      return;
    }
    premier.affiche();
  }

  public boolean appartient(String n) {
    if(!premierExiste()) return false;
    return premier.appartient(n);
  }

  public void ajout(Employe emp) {
    if(!premierExiste()) {
      this.premier = new Cellule(emp);
      return;
    }
    if(this.appartient(emp.getNom())) return;
    if(this.premier.getEmploye().getSalaire() > emp.getSalaire()) {
      Cellule cel = this.premier;
      Cellule cel2 = new Cellule(emp, cel);
      this.premier = cel2;
      return;
    }
    this.premier.ajout(emp);
    return;
  }

  public void demission(String n) {
    if(!premierExiste()) {
      return;
    }
    if(this.premier.getEmploye().getNom() == n) {
      this.premier = this.premier.getSuiv();
      return;
    }
    premier.demission(n);
  }

  public boolean augmente(String nom, int montant) {
    if(!appartient(nom) || montant <= 0) return false;
    Employe emp = getEmploye(nom);
    emp.setSalaire(getEmploye(nom).getSalaire() + montant);
    this.demission(nom);
    this.ajout(emp);
    return true;
  }

  public Entreprise choixSalaire(int min, int max) {
    // Cette fonction renvoie une sous-liste de cellules copiés de celles de la liste principale.

    if(!premierExiste()) {
      Entreprise out = new Entreprise(this.nom);
      return out;
    }

    Entreprise out = new Entreprise(this.nom);
    out.setPremier(this.premier.choixSalaire(min, max));

    return out;
  }

  public Entreprise choixSalaire2(int min, int max) {
    // Cette fonction renvoie une sous-liste de cellules dela premiere liste en la détruisant.

    if(!premierExiste()) {
      return this;
    }

    this.premier.choixSalaire2(min, max);

    return new Entreprise(this.nom, this.premier);
  }

  public boolean croissante() {
    if(!premierExiste()) return false;
    return this.premier.croissante();
  }

  public boolean premierExiste() {
    if(premier == null) {
      System.out.println("L'entreprise " + this.nom + " n'emploie personne.");
      return false;
    }
    return true;
  }

  public void acquisition(Entreprise ent) {
    if(!ent.premierExiste()) return;
    if(!premierExiste()) {
      this.premier = ent.getPremier();
      return;
    }
    // Parcourir toute la liste de ent, ajouter chaque employer à this.
    Cellule cel = ent.getPremier();
    do {
      this.ajout(cel.getEmploye());
      cel = cel.getSuiv();
    } while (cel != null);
    return;
  }

  public static Entreprise trierParSalaire(Entreprise e) {
    // renvoie une nouvelle instance d'Entreprise dont les employers sont triés par ordre croissant de salaire.
    if(!e.premierExiste()) return new Entreprise(e.getNom());

    Cellule premier = new Cellule(e.getPremier().getEmploye());
    Entreprise ent = new Entreprise(e.getNom(), premier);

    Cellule cel = e.getPremier();

    if(cel.getSuiv() == null) return ent;

    while (cel.getSuiv() != null) {
      cel = cel.getSuiv();
      ent.ajout(cel.getEmploye());
    }
    return ent;
  }

  // GETTERS & SETTERS :

  public String getNom() {
    return this.nom;
  }
  public Cellule getPremier() {
    return this.premier;
  }
  public Employe getEmploye(String nom) {
    if(!premierExiste()) {
      premierExiste();
      return null;
    }
    return premier.getEmploye(nom);
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
  public void setPremier(Cellule premier) {
    this.premier = premier;
  }
}
