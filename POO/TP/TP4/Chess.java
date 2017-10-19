import java.util.Scanner;

class Chess {
	private Board board;
	private boolean player;
	private Scanner scan;

	public Chess(int x, int y) {
		this.player = true;

		if(x < 4 || y < 4 || x > 8 || y > 8) {
			x = 4;
			y = 4;
		} else if (x % 2 != 0) 
			x = x - 1;

		this.board = new Board(x, y);

		// On place les Rois.
		this.board.initKing(x / 2, 0, new King(false));
		this.board.initKing(x / 2, y - 1, new King(true));

		// On place les reines.
		this.board.initPiece(x / 2 - 1, 0, new Queen(false));
		this.board.initPiece(x / 2 - 1, y - 1, new Queen(true));

		// On place les Tours.
		this.board.initPiece(0, 0, new Rook(false));
		this.board.initPiece(x - 1, 0, new Rook(false));		
		this.board.initPiece(0, y - 1, new Rook(true));
		this.board.initPiece(x - 1, y - 1, new Rook(true));

		// Les Pions.
		for(int i = 0; i < x; i ++) {
			this.board.initPiece(i, 1, new Pawn(false));
			this.board.initPiece(i, y - 2, new Pawn(true));
		}

		// Faut-il placer autre chose ?
		if(x == 4) return;

		// On place les Fous.
		this.board.initPiece(x / 2 + 1, 0, new Bishop(false));
		this.board.initPiece(x / 2 - 2, 0, new Bishop(false));
		this.board.initPiece(x / 2 + 1, y - 1, new Bishop(true));
		this.board.initPiece(x / 2 - 2, y - 1, new Bishop(true));

		if(x == 6) return;

		// Enfin les Cavaliers.
		this.board.initPiece(1, 0, new Knight(false));
		this.board.initPiece(x - 2, 0, new Knight(false));
		this.board.initPiece(1, y - 1, new Knight(true));
		this.board.initPiece(x - 2, y - 1, new Knight(true));

		this.board.updateAll();

		this.scan = new Scanner(System.in);
		int x0, y0, x1, y1;

		while(!this.board.oneKingTaken()) {

			System.out.println("\n\n\n\n\nJoueur " + (player ? "Blanc" : "Noir") + " choisissez une piece");
			
			while(true) {
				this.board.display();

				System.out.println("Colonne de la piece:");
				x0 = chosenInt() - 1;
				System.out.println("Ligne de la piece:");
				y0 = chosenInt() - 1;

				if(this.board.getPiece(x0, y0) == null || this.board.getPiece(x0, y0).color() != player) {
					System.out.println("Cases ou piece invalide");
					continue;
				}

				System.out.println("Cases accessibles:");
				this.board.getPiece(x0, y0).printReachable();

				System.out.println("Entrez 1 pour continuer avec cette piece:");
				if(chosenInt() == 1) break;
			}

			while(true) {
				this.board.display();

				System.out.println("Colonne de la case ou se deplacer:");
				x1 = chosenInt() - 1;
				System.out.println("Ligne de la case ou se deplacer:");
				y1 = chosenInt() - 1;

				if(!this.board.move(x0, y0, x1, y1)) {
					System.out.println("Mouvement invalide, recommencez");
					continue;
				} else 
					break;
			}		

			if(this.board.oneKingTaken())
				System.out.println("Le joueur " + (player ? "Blanc" : "Noir") + " a gagne la partie");

			this.player = this.player ? false : true;
		}
	}

	public Chess(int c) {
		this(c, c);
	}

	public Chess() {
		this(8, 8);
	}

	public int chosenInt() {
    	while(!scan.hasNextInt()) {
    		scan.next();
    		System.out.println("Entrez un VRAI nombre (Entier qui plus est).");
    	}
    	return scan.nextInt();
    }
	

	public Board getBoard() {return this.board;}
}