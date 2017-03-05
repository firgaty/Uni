class Employe {
  private final String nom;
  private int salaire;

  public Employe(String nom, int salaire) {
    this.nom = nom;
    this.salaire = salaire;
  }

  public void afficher() {
    System.out.println(nom + ", salaire : " + salaire);
  }

  // GETTERS & SETTERS

  public String getNom() {
    return this.nom;
  }
  public int getSalaire() {
    return this.salaire;
  }

  public void setSalaire(int salaire) {
    this.salaire = salaire;
  }
}
