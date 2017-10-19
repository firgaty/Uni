class Queen extends Piece {
	public Queen(boolean c) {
		super(c);
	}

	@Override
	public String toString() {
		return color ? "d" : "D";
	}

	@Override
	public void updateReachable() {
		int[][] likeRook = reachableByRook();
		int[][] likeBishop = reachableByBishop();

		if(likeBishop != null && likeRook != null) {
			this.reachable = new int[likeBishop.length + likeRook.length][2];
			for(int i = 0; i < likeRook.length; i ++) 
				this.reachable[i] = likeRook[i];
			for(int i = 0; i < likeBishop.length;i ++)
				this.reachable[i + likeRook.length] = likeBishop[i];
		} else if (likeRook != null) {
			this.reachable = new int[likeRook.length][2];
			for(int i = 0; i < likeRook.length; i ++) 
				this.reachable[i] = likeRook[i];
		} else if (likeBishop != null) {
			this.reachable = new int[likeBishop.length][2];
			for(int i = 0; i < likeBishop.length; i ++) 
				this.reachable[i] = likeBishop[i];
		} else {
			this.nbReachable = 0;
			return;
		}

		this.nbReachable = this.reachable.length;
	}
}