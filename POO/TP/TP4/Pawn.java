class Pawn extends Piece {
	public Pawn(boolean c) {
		super(c);
	}

	@Override
	public String toString() {
		return color ? "p" : "P";
	}

	@Override
	public void updateReachable() {
		int direction = this.color ? -1 : 1;
		int[][] pArray = new int[4][2];
		int count = 0;

		if(isMaybeReachable(x - 1, y + direction) 
			&& this.board.isOccupied(x - 1, y + direction)
			&& !isSameColor(this.board.getPiece(x - 1, y + direction))) {
			pArray[count][0] = x - 1;
			pArray[count][1] = y + direction;
			count ++;
		}
		if(isMaybeReachable(x + 1, y + direction) 
			&& this.board.isOccupied(x + 1, y + direction)
			&& !isSameColor(this.board.getPiece(x + 1, y + direction))) {
			pArray[count][0] = x + 1;
			pArray[count][1] = y + direction;
			count ++;
		}
		if(this.board.isValid(x, y + direction) && !this.board.isOccupied(x, y + direction)) {
			pArray[count][0] = x;
			pArray[count][1] = y + direction;
			count ++;
			if(this.board.isValid(x, y + direction * 2) 
				&& !this.board.isOccupied(x, y + direction * 2)
				&& this.y == (direction == 1 ? 1 : this.board.getSizeY() - 2)) {
				pArray[count][0] = x;
				pArray[count][1] = y + direction * 2;
				count ++;
			}

		}

		updateReachable(smallestCoorArray(pArray, count));
	}
}