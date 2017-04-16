class Test {
  public static void main(String[] args) {
    SystemeFichiers s = new SystemeFichiers();

    s.getRacine().ajouterFils("tmp", true);
    s.chercher("tmp").ajouterFils("dump", false);
    s.chercher("tmp").ajouterFils("x2.tmp", false);

    s.getRacine().ajouterFils("home", true);
    s.chercher("home").ajouterFils("doc", true);
    s.chercher("home").ajouterFils("foo", true);
    s.chercher("foo").ajouterFils("f1.java", false);
    s.chercher("foo").ajouterFils("f2.ml", false);
    s.chercher("foo").ajouterFils(".ssh", true);
    s.chercher(".ssh").ajouterFils("cle", false);

    s.chercher("cle").ecrire("A135ADDE1084F04FFF011");
    s.chercher("tmp").ecrire("dump");

    s.getRacine().liste();
    s.chercher("tmp").liste();
    s.chercher("home").liste();
    s.chercher("foo").liste();
    s.chercher(".ssh").liste();
    System.out.println("Taille de foo: " + s.chercher("foo").calculerTaille());
    s.mettreAJourTaille();
    System.out.println("Taille de racine: " + s.getRacine().calculerTaille());
    s.chercher("foo").liste();

  }
}
