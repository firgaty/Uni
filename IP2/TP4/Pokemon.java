import java.lang.Math;

public class Pokemon {
  private String nom;
  private String type;
  private int niveau;

  Pokemon(String nom, String type) {
    this.nom = nom;
    this.type = type;
    this.niveau = 1 + (int)(Math.random() * 100);
  }

  public boolean estDeTypeCorrect() {
    if(this.type == "eau" || this.type == "feu" || this.type == "plante") {
      return true;
    } else {
      return false;
    }
  }

  public boolean estPlusFortQue(Pokemon p) {
    // Renvoie true si this est plus fort que p.

    if(p.getType() == this.type) {
      return p.getNiveau() < this.getNiveau();
    } else if ((p.getType() == "eau" && this.type == "feu") || (p.getType() == "plante" && this.type == "eau") || p.getType() == "feu" && this.type == "plante") {
      return false;
    } else if ((p.getType() == "eau" && this.type == "plante") || (p.getType() == "plante" && this.type == "feu") || (p.getType() == "feu" && this.type == "eau")) {
      return true;
    }
    return true;
  }

  // GETTERS

  public String getNom() {
    return this.nom;
  }
  public String getType() {
    return this.type;
  }
  public int getNiveau() {
    return this.niveau;
  }
}
