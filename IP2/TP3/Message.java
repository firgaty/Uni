class Message {
  private final Utilisateur auteur;
  private final String contenu;

  Message(Utilisateur auteur, String contenu) {
    this.auteur = auteur;
    this.contenu = contenu;
  }

  public Utilisateur getAuteur() {
    return this.auteur;
  }
  public String getContenu() {
    return this.contenu;
  }
}
