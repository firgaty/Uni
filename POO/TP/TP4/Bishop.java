class Bishop extends Piece {
	public Bishop(boolean c) {
		super(c);
	}

	@Override
	public String toString() {
		return color ? "f" : "F";
	}

	@Override
	public void updateReachable() {
		updateReachable(reachableByBishop());
	}
}