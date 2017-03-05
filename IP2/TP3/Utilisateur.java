class Utilisateur {
  private String pseudo;
  private String mdp;
  private final String addrMail;

  Utilisateur(String pseudo, String mdp, String addrMail) {
    this.pseudo = pseudo;
    this.mdp = mdp;
    this.addrMail = addrMail;
  }
  
  public String getPseudonyme() {
    return this.pseudo;
  }
  public void setPseudonyme(String pseudo) {
    this.pseudo = pseudo;
  }
  public boolean testMotDePasse(String mdp) {
    return this.mdp == mdp;
  }
  public void changerMotDePasse(String mdp, String nouveauMdp) {
    if(testMotDePasse(mdp))
      this.mdp = nouveauMdp;
  }
}
