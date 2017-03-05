import java.util.ArrayList;

class FileDAttente {
  public ArrayList<Client> clients;

  FileDAttente() {
    clients = new ArrayList<Client>();
  }

  public int getTaille() {
    return this.clients.size();
  }

  public void afficher() {
    String str = new String();
    for (int i = 0; i < this.clients.size(); i++) {
      System.out.println((i + 1) + ". " + this.clients.get(i).getPrenom() + " " + this.clients.get(i).getNom());
    }
  }
}
