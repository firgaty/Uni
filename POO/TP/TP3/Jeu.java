public class Jeu {
    private Joueur leJoueur;
    private Plateau lePlateau;

    public Jeu(Joueur joueur, int hauteur, int largeur, int nbMines) {
    	this.leJoueur = joueur;
    	do {
    		this.lePlateau = new Plateau(hauteur, largeur, nbMines);
    		System.out.println("C'est parti !");

			do {
				tour();
			} while(!lePlateau.jeuFini());

			String str = lePlateau.jeuGagne() ? "Vous avez gagne ! \\o/" : "Vous avez perdu... @_@";
			System.out.println(str);

			System.out.println("Recommencer avec les memes parametres ?");
		} while(leJoueur.ouiNon());

    }

    private void tour() {
    	int[] actions = new int[3];
    	lePlateau.affichage();

    	do {
			actions = leJoueur.actionChoisie();
    	} while(!lePlateau.agir(actions[0], actions[1], actions[2]));
    }
    
}
