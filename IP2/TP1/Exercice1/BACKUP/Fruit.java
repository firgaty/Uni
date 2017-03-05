public class Fruit {
	public String nom;
	public int poids;

	public Fruit(String nom, int poids){
		this.nom  = nom;
		this.poids = poids;
	}

	public static void afficher(Fruit f){
		System.out.printf("Ce fruit est un(e) " + f.nom + " et pèse " + f.poids + " grammes.\n");
	}
}
