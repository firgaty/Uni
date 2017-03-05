import java.util.ArrayList;

class Salon {
  private ArrayList<Utilisateur> utilisateurs;
  private ArrayList<Message> messages;

  Salon() {
    utilisateurs = new ArrayList<Utilisateur>();
    messages = new ArrayList<Message>();
  }
  
  public ArrayList<Utilisateur> getUtilisateurs() {
    return new ArrayList<Utilisateur>(this.utilisateurs);
  }
  public ArrayList<Message> getMessages() {
    return new ArrayList<Message>(this.messages);
  }
  public void ajouterUtilisateur(Utilisateur u) {
    this.utilisateurs.add(u);
  }
  public void ajouterMessage(Message m) {
    if(this.estPresent(m.getAuteur())) this.messages.add(m);
  }
  public boolean estPresent(Utilisateur u) {
    return utilisateurs.contains(u);
  }
  public void afficher() {
    for(Message m : messages) {
      System.out.println(m.getAuteur().getPseudonyme() + " : " + m.getContenu());
    }
  }
}
