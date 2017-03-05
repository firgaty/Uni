public class Panier {
  public Fruit[] t;

  Panier(Fruit[] f) {
    this.t = f;
  }
  Panier() {
    t = null;
  }
  Panier(Fruit f, Panier p) {
    Fruit[] foo = new Fruit[p.t.length + 1];

    for (int i = 0; i < p.t.length; i++) {
      foo[i] = p.t[i];
    }

    foo[foo.length - 1] = f;

    this.t = foo;
  }

  public static void afficher(Panier p) {
    for (int i = 0; i < p.t.length; i++) {
      Fruit.afficher(p.t[i]);
    }
  }

  public static Panier hybridePanier(Fruit f, Panier p) {
    Fruit[] foo = new Fruit[p.t.length];
    for (int i = 0; i < p.t.length; i++) {
      foo[i] = Fruit.hybridation(f, p.t[i]);
    }

    return new Panier(foo);
  }
}
