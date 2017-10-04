class Personne {
  private String nom;
  private String prenom;
  public int age; //PAs nécessaire d'être public
  private int monnaie;

  public Personne(String nom, String prenom, int age) {
    this.nom = nom;
    this.prenom = prenom;
    this.age = age;
  }

  

  public void sedNom(String n) {
    this.nom = n;
  }
  public void setPrenom(String p) {
    this.prenom = p;
  }
  public void anniversaire() {
    this.age ++;
  }
  public String toString() {
    return "Je m'appelle : " + this.prenom + " " + this.nom + ". J'ai " + this.age + " ans.";
  }
  public void addMonnaie(int m) {
    this.monnaie += m;
  }

  public boolean donne(Personne p, int montant) {
    if(montant > this.monnaie) return false;
    if(p == null) return false;

    this.monnaie -= montant;
    p.addMonnaie(montant);

    return true;
  }

  public static boolean donne (Personne p1, Personne p2, int montant) {
    p1.donne(p2, montant);
    return true;
  }
}
