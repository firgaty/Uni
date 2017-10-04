class Abapa {
	public static void main(String[] args) {
		System.out.println("Bienvenue ! DEBUT DE LA PARTIE, YOUPIE !");
		Jeu jeu = new Jeu("Alice", "Bob");
		while(!jeu.fini()) {
			jeu.jouerTour();
		}
		jeu.afficherGagnant();
	}
}