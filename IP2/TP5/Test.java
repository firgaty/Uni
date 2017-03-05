class Test {
  public static void main(String[] args) {
    Employe e1 = new Employe("Ambre", 1000);
    Employe e2 = new Employe("Chris", 2012);
    Employe e3 = new Employe("Salomon", 1238);
    Employe e4 = new Employe("Emie", 7581);
    Employe e5 = new Employe("Patrick", 1236);
    Employe e6 = new Employe("Sofiane", 7652);
    Employe e7 = new Employe("Hector", 2352);
    Employe e8 = new Employe("Henry", 3258);
    Employe e9 = new Employe("Alloa", 12497);
    Employe e10 = new Employe("Ellie", 21871);
    Employe e11 = new Employe("Xavier", 1472);
    Employe e12 = new Employe("Francois", 7423);
    Employe e13 = new Employe("Fabienne", 5292);
    Employe e14 = new Employe("Eleanore", 5329);
    Employe e15 = new Employe("Simon", 3252);
    Employe e16 = new Employe("Simon", 2313);

    e1.afficher();
    System.out.println("=========================");

    Cellule c9 = new Cellule(e9);
    Cellule c8 = new Cellule(e8, c9);
    Cellule c7 = new Cellule(e7, c8);
    Cellule c6 = new Cellule(e6, c7);
    Cellule c5 = new Cellule(e5, c6);
    Cellule c4 = new Cellule(e4, c5);
    Cellule c3 = new Cellule(e3, c4);
    Cellule c2 = new Cellule(e2, c3);
    Cellule c1 = new Cellule(e1, c2);

    Entreprise ent = new Entreprise("Entreprise.corp", c1);
    ent.affiche();
    System.out.println("=========================");

    // Test ajout.
    ent.ajout(e10);
    ent.ajout(e11);
    ent.ajout(e10);
    ent.affiche();
    System.out.println("=========================");

    // Test demission.
    ent.demission("Chris");
    ent.affiche();
    System.out.println("=========================");

    // Test augmente.
    ent.augmente("Hector", 1023);
    ent.affiche();
    System.out.println("=========================");

    // Test trierParSalaire.
    ent = Entreprise.trierParSalaire(ent);
    System.out.println("=========================");



  }
}
