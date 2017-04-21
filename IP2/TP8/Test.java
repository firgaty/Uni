public class Test {
  public static void main ( String [] args ){
    Noeud a = new Noeud(6, new Noeud(3), null);
    Noeud b = new Noeud(9, new Noeud(2), a);
    Noeud c = new Noeud(5, b, null);
    Noeud d = new Noeud(1, null, new Noeud(4));
    Noeud e = new Noeud(7, new Noeud(0), d);
    Noeud f = new Noeud(8, c, e);
    Noeud g = new Noeud(f);

    System.out.println("f");
    System.out.println("Infixe : " + f.infixe());
    System.out.println("Prefixe : " + f.prefixe());
    System.out.println("Postfixe : " + f.postfixe());

    System.out.println("g");
    System.out.println("Infixe : " + g.infixe());
    System.out.println("Prefixe : " + g.prefixe());
    System.out.println("Postfixe : " + g.postfixe());

    if(f.contientNoeudDEtiquette(8)) System.out.println("Contient 8");
    if(!f.contientNoeudDEtiquette(10)) System.out.println("Contient pas 10");

    System.out.println("Nombre de noeuds de f: " + f.nbNoeuds());
    System.out.println("Profondeur f : " + f.profondeur());
    System.out.println("Somme f : " + f.somme());

    int [] tab = {0, 1, 2, 3, 4, 5};
    Noeud h = new Noeud(tab);
    System.out.println(h.prefixe() + "\t" + h.infixe() + "\t" + h.postfixe());
  }
}
