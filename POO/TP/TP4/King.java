class King extends Piece {
	private boolean isReachable;

	public King(boolean c) {
		super(c);
		this.isReachable = false;
	}

	@Override
	public String toString() {
		return color? "r" : "R";
	}

	public boolean isReachable() {
		return this.isReachable;
	}

	public void setIsReachable(boolean r) {
		this.isReachable = r;
	}

	@Override
	public void updateReachable(){
		int count = 0;
		int[][] pArray = new int[8][2];

		for(int i = x - 1; i <= x + 1; i ++) {
			for(int j = y - 1; j <= y + 1; j ++) {
				if(isMaybeReachable(i, j)) {
					pArray[count][0] = i;
					pArray[count][1] = j;
					count ++;
				}
			}
		}

		this.nbReachable = count;

		/*for(int i = 0; i < count; i ++) {
			this.reachable[i][0] = pArray[i][0];
			this.reachable[i][1] = pArray[i][1];
		}*/

		this.reachable = smallestCoorArray(pArray, count);
	}

	public boolean isKing() {return true;}
}