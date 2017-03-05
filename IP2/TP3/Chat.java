import java.util.ArrayList;


class Chat {
  private ArrayList<Salon> salons;

  Chat() {
    this.salons = new ArrayList<Salon>();
  }

  public void ajouterSalon(Salon s) {
    this.salons.add(s);
  }
  public boolean estPresent(Utilisateur u) {
    for(Salon s: this.salons) {
      if(s.estPresent(u)) return true;
    }
    return false;
  }
  public int nombreMessages(Utilisateur u) {
    if(!this.estPresent(u)) return 0;
    int out = 0;

    for(Salon s: this.salons) {
      if(s.estPresent(u)) {
        for(Message m: s.getMessages()) {
          if(m.getAuteur() == u) {
            out++;
          }
        }
      }
    }
    return out;
    }

    public Utilisateur contributeur() {
      ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
      ArrayList<Integer> nbMessages = new ArrayList<Integer>();

      // On check tous les auteurs de chaque messages de chaque salon.
      for (Salon s: this.salons) {
        for (Message m: s.getMessages()) {
          if (listeUtilisateurs.indexOf(m.getAuteur()) >= 0) {
            // S'il exite, on incrémente de 1 son compteur associé.
            nbMessages.set(listeUtilisateurs.indexOf(m.getAuteur()), nbMessages.get(listeUtilisateurs.indexOf(m.getAuteur())).intValue() + + 1);
          } else {
            // Sinon on créé une nouvelle entrée dans listeUtilisateurs et nbMessages.
            listeUtilisateurs.add(m.getAuteur());
            nbMessages.add(1);
          }
        }
      }

      // On passe au tri, en éliminant au fur et à mesure, jusqu'à ce qu'il ne reste plus qu'un seul utilisateur dans la liste.
      while (nbMessages.size() > 1) {
        if (nbMessages.get(0) > nbMessages.get(1)) {
          nbMessages.remove(1);
          listeUtilisateurs.remove(1);
        } else {
          nbMessages.remove(0);
          listeUtilisateurs.remove(0);
        }
      }

      // On le renvoie.
      return listeUtilisateurs.get(0);
    }
 }
