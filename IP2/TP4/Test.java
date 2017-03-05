public class Test {
  public static void main(String[] args) {
    Pokemon a = new Pokemon("tortipousse", "plante");
    Pokemon b = new Pokemon("tortipousse2", "plante");
    Pokemon c = new Pokemon("dracofeu", "feu");
    Pokemon d = new Pokemon("carapuce", "eau");
    Pokemon e = new Pokemon("tortipousse3", "plante");
    Pokemon f = new Pokemon("faux", "pasbon");

    if(f.estDeTypeCorrect()) {
      System.out.println("f est de type correct.");
    } else {
      System.out.println("f n'est pas de type correct.");
    }
    if(e.estDeTypeCorrect()) {
      System.out.println("e est de type correct.");
    } else {
      System.out.println("e n'est pas de type correct.");
    }

    if(a.estPlusFortQue(c)) {
      System.out.println("C'est pas normal.");
    }


    Pokeball pok1 = new Pokeball(a);
    pok1.afficher();

    System.out.println("\n\n===========");


    Dresseur red = new Dresseur("Red");
    red.ajouterPokemon(a);
    red.ajouterPokemon(b);
    red.ajouterPokemon(c);
    red.ajouterPokemon(d);
    red.ajouterPokemon(e);

    red.afficher();

    System.out.println("\n\n===========");

    System.out.println(red.get(2).getNom());
    red.remove(2);
    System.out.println(red.get(2).getNom());

    System.out.println("\n\n===========");

    red.afficher();

    System.out.println("\n\n===========");

    System.out.println(red.typeFavoris());
  }
}
