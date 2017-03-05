
public class Test {

    public static void main(String[] args) {
  		Fruit f = new Fruit("pamplemousse", 330);
  		Fruit g = new Fruit("pamplemousse", 330);
  		Fruit h = f;

      Fruit.afficher(f);

  		System.out.println("\nTest Termine");
  	}
}
