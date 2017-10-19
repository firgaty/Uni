class Knight extends Piece {
	public Knight(boolean c) {
		super(c);
	}

	@Override
	public String toString() {
		return color ? "c" : "C";
	}

	@Override
	public void updateReachable() {
		int[][] squares = {
			{x + 2, y + 1}, {x + 2, y - 1},
			{x - 2, y + 1}, {x - 2, y - 1},
			{x + 1, y + 2}, {x + 1, y - 2},
			{x - 1, y + 2}, {x - 1, y - 2},
		};
		int count = 0;
		int [][] pArray = new int[8][2];

		for(int i = 0; i <  8; i ++) {
			if(isMaybeReachable(squares[i][0], squares[i][1])) {
				pArray[count] = squares[i];
				count ++;
			}
		}

		updateReachable(smallestCoorArray(pArray, count));
	}
}