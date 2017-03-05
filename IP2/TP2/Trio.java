class Trio {
  Etudiant[] membres;

  Trio(Etudiant e1, Etudiant e2, Etudiant e3) {
    this.membres = new Etudiant[3];
    this.membres[0] = e1;
    this.membres[1] = e2;
    this.membres[2] = e3;
  }

  Etudiant premier() {
    if (this.membres[0].note > this.membres[1].note && this.membres[0].note > this.membres[2].note) {
      return this.membres[0];
    } else if (this.membres[1].note > this.membres[2].note) {
      return this.membres[1];
    } else {
      return this.membres[2];
    }
  }

  int classement(String prenom, String nom) {
    for (int i = 0; i < 3; i++) {
      if (this.membres[i].nom == nom && this.membres[i].prenom == prenom) {
        if( this.membres[i] == this.premier()) {
          return 1;
        } else if (this.membres[i].note < this.membres[(i+1)%3].note && this.membres[i].note < this.membres[(i+2)%3].note) {
          return 3;
        } else {
          return 2;
        }
      }
    }
    return 0;
  }

  double moyenne() {
    return (this.membres[0].note + this.membres[1].note + this.membres[2].note) / 3;
  }

  boolean meilleurQueLaMoyenne() {
    if (this.moyenne() > Etudiant.moyenne()) {
      return true;
    } else {
      return false;
    }
  }


}
