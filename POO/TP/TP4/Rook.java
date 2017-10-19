class Rook extends Piece {
	public Rook(boolean c) {
		super(c);
	}

	@Override
	public String toString() {
		return color ? "t" : "T";
	}

	@Override
	public void updateReachable() {
		updateReachable(reachableByRook());
	}
}