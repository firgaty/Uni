class Case {
	private boolean color;
	// color : false = noir, true = blanc.
	private Piece piece;

	public Case(boolean c) {
		this.color = c;
	}

	public boolean estVide() {
		return this.piece == null;
	}

	public Piece getPiece() {
		if(estVide()) return null;
		return this.piece;
	}

	public void remplirPiece(Piece p) {
		this.piece = p;
	}

	public void enleverPiece() {
		this.piece = null;
	}

	public String toString() {
		if(estVide()) return color ? "-" : "#";
		return this.piece.toString();
	}
}