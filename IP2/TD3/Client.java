class Client {
  private String nom;
  private String prenom;

  Client(String nom, String prenom) {
    this.nom = nom;
    this.prenom = prenom;
  }

  public String getNom() {
    return this.nom;
  }
  public String getPrenom() {
    return this.prenom;
  }
}
