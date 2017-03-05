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
      premierExiste();
      return;
    }
    premier.affiche();
  }

  public boolean appartient(String n) {
    if(!premierExiste()) return premierExiste();
    return premier.appartient(n);
  }

  public void ajout(Employe emp) {
    if(!premierExiste()) {
      this.premier = new Cellule(emp);
      return;
    }
    if(this.appartient(emp.getNom())) return;
    if(this.premier.getSuiv().getEmploye().getSalaire()> emp.getSalaire()) {
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
      premierExiste();
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
      premierExiste();
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
      premierExiste();
      return this;
    }

    this.premier.choixSalaire2(min, max);

    return new Entreprise(this.nom, this.premier);
  }

  public boolean croissante() {
    if(!premierExiste()) return premierExiste();
    return this.premier.croissante();
  }

  public boolean premierExiste() {
    if(premier == null) {
      System.out.println("L'entrprise n'emploie personne.");
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
    Entreprise ent = new Entreprise(e.getNom(), e.getPremier());
    if(!ent.premierExiste()) return ent;

    Cellule cel = ent.getPremier();
    Cellule cel2 = cel.getSuiv();
    do {
      while(cel2 != null) {
        if(cel.getEmploye().getSalaire() > cel2.getEmploye().getSalaire()) {
          ent.setPremier(cel.getSuiv());
          cel.setSuiv(cel2.getSuiv());
          cel2.setSuiv(cel);
          cel2 = null;
        } else {
          cel2 = cel2.getSuiv();
        }
      }
      if(cel.getSuiv() == null) cel = null;
      else {
        cel = cel.getSuiv();
        cel2 = cel.getSuiv();
      }
    } while (cel != null);
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
