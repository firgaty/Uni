import java.util.ArrayList;

class Noeud {
  private String nom;
  private int taille;
  private final boolean repertoire;
  private ArrayList<Noeud> fils;
  private String contenu;

  public Noeud (String nom, boolean repertoire){
    this.nom = nom;
    this.repertoire = repertoire;
    if(repertoire) fils = new ArrayList<Noeud>();
    taille = 0;
    this.contenu = "";
  }

  public void ajouterFils(String nom, boolean repertoire) {
    this.fils.add(new Noeud(nom, repertoire));
  }
  public void liste() {
    if(this.repertoire == false) {
      System.out.println(this.nom);
    } else {
      for(Noeud noeud: this.fils) {
        System.out.println(noeud.getNom() + " (" + noeud.getTaille() + ")");
      }
    }
  }
  public Noeud chercherFils(String nom) {
    if(this.repertoire == false) return null;
    for(Noeud fils : this.fils) {
      if(fils.getNom() == nom) {
        return fils;
      }
    }
    return null;
  }
  public Noeud chercher(String nom) {
    if(this.repertoire == false) return null;
    if(this.chercherFils(nom) != null) {
      return this.chercherFils(nom);
    } else {
      for(Noeud fils : this.fils) {
        if(fils.chercher(nom) != null) {
          return fils.chercher(nom);
        }
      }
      return null;
    }
  }
  public void ecrire(String ligne) {
    this.contenu = this.contenu + ligne + "\n";
    this.taille += (ligne.length() + 2);
  }
  public void ecrireTout(String ligne) {
    if(this.repertoire == false) return;
    for(Noeud fils : this.fils) {
      fils.ecrire(ligne);
    }
  }
  public int calculerTaille() {
    if(this.repertoire == false) {
      System.out.println("1 fichier mis à jour");
      return this.taille;
    }
    int out = 0;
    for(Noeud fils : this.fils) {
      out += fils.calculerTaille();
    }
    return out;
  }

  // GETTERS & SETTERS:

  public boolean repertoire (){
    return this.repertoire;
  }
  public String getNom (){
    return this.nom;
  }
  public int getTaille (){
    return this.taille;
  }
}
