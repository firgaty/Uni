class Jeu {
	private Plateau plateau;
	private Joueur[] joueurs;
	private int joueurEnCours;
	private boolean fini;

	public Jeu(String nom1, String nom2) {
		this.plateau = new Plateau();
		this.joueurs = new Joueur[2];
		this.joueurs[0] = new Joueur(nom1, this.plateau.getVue(0));
		this.joueurs[1] = new Joueur(nom2, this.plateau.getVue(1));
		this.fini = false;
		this.joueurEnCours = 0;
	}

	public void jouerTour() {
		System.out.println("Joueur " + Integer.toString(joueurEnCours + 1));
		int i = this.joueurs[this.joueurEnCours].demanderCoup();

		while(!this.joueurs[this.joueurEnCours].getVue().viderCase(i)) {
			this.joueurs[this.joueurEnCours].rejeterCoup();
			i = this.joueurs[this.joueurEnCours].demanderCoup();
		}

		if(this.plateau.grainesCase(6 + 7 * this.joueurEnCours) >= 25) 
			this.fini = true;

		this.joueurEnCours = (this.joueurEnCours + 1) % 2; 
		if(!this.joueurs[this.joueurEnCours].getVue().peutjouer())
			this.fini = true;
	}

	public boolean fini() {
		return this.fini;
	}

	public void afficherGagnant() {
		if(!fini()) {
			System.out.println("La partie n'est pas encore finie.");
			return;
		}

		System.out.println(this.joueurs[joueurEnCours + 1 % 2].getNom() + " a gagne la partie!");
	}
}