import java.util.Scanner;

class Joueur {
	private String nom;
	private VuePlateau vue;

	public Joueur(String nom, VuePlateau vue) {
		this.nom = nom; 
		this.vue = vue;
	}

	public int demanderCoup() {
		vue.afficherPlateau();

		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le numero de la case a vider (0 - 5):");
     	int i = sc.nextInt();

     	return i;
	}

	public void rejeterCoup() {
		System.out.println("Ce coup est invalide. Recommencez:");
	}

	public String getNom() {
		return this.nom;
	}

	public VuePlateau getVue() {
		return this.vue;
	}
}