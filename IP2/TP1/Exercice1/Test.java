
public class Test {

    public static void main(String[] args) {
  		Fruit f = new Fruit("pamplemousse", 330);
  		Fruit g = new Fruit("pamplemousse", 330);
  		Fruit h = f;

      Fruit.afficher(f);

      Fruit.afficher(Fruit.hybridation(f,g));
      Fruit[] tab = {f, f, f};
      Panier p = new Panier(tab);
      Panier.afficher(p);
      Panier p2 = Panier.hybridePanier(f, p);
      Panier.afficher(p2);


  		System.out.println("\nTest Termine");
  	}
}
