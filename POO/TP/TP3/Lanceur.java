public class Lanceur {
    public static void main(String[] args) {
    	Joueur j = new Joueur();

    	System.out.println("Nom actuel : " + j.getNom() + "\nChanger de nom ?");
    	if (j.ouiNon())
    		j.setNom();

    	System.out.println("Prêt(e) pour une partie de démineur ?");
    	if(!j.ouiNon()) {
    		System.out.println("Tant pis, au revoir !");
    	}

    	do {
    		System.out.println("Nouvelle partie!\n");

    		System.out.println("Entrez la hauteur du plateau :");
    		int hauteur = j.nombreChoisi();
    		System.out.println("Entrez sa largeur :");
    		int largeur = j.nombreChoisi();
    		System.out.println("Enfin, le nombre de mines (< hauteur x largeur) :");
    		int nbMines = j.nombreChoisi();

    		Jeu jeu = new Jeu(j, hauteur, largeur, nbMines);

    		System.out.println("Voulez vous refaire une petite partie riquiqui de demineur qui ne fait pas mal ?");
    	} while(!j.ouiNon());

    	System.out.println("Au revoir !");

    }
}
