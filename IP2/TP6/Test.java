class Test {
  public static void main(String[] args) {
    Cellule liste = new Cellule(true); // crée une liste contenant une seule Cellule
    new Cellule(true,liste); // ajoute une Cellule à la fin de la liste
    new Cellule(false,liste); // ajoute une Cellule à la fin de la liste
    liste.afficher(); // affiche #
    liste.getSuivante().afficher(); // affiche #
    liste.getSuivante().getSuivante().afficher(); // affiche -

    System.out.println("\n\n");

    Automate a = new Automate();
    a.initialisation();
    a.afficher();
    System.out.println("");

    a.uneEtape();
    a.afficher();
    System.out.println("");

    a.uneEtape();
    a.afficher();
    System.out.println("");

    System.out.println("\n\n");

    Automate a2 = new Automate();
    a.initialisation();
    a.nEtapes(60);

    System.out.println("\n\n");

    Automate a3 = new Automate("------------------------------------------------#------------------------------------------------");
    a3.nEtapes(100);
  }
}
