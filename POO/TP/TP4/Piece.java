public abstract class Piece {
	protected boolean color;
	protected Board board;
	protected int[][] reachable;
	protected int nbReachable;
	protected int x;
	protected int y;


	public Piece(boolean c, Board b, int x, int y) {
		this.color = c;
		this.board = b;
		this.x = x;
		this.y = y;
	}

	public Piece(boolean c, Board b) {
		this(c, b, -1, -1);
	}

	public Piece(boolean c) {
		this(c, null);
	}

	abstract public String toString(); //{
		//return color ? "p" : "P";
	//}

	public void printReachable() {
		String str = this.toString() + " en " + (x + 1) + ":" + (y + 1) + "\n";

		if(!hasReachable()){
			System.out.println(str + "You can't move this piece.");
			return;
		}
		for(int i = 0; i < this.nbReachable; i ++) {
			str += "(" + (reachable[i][0] + 1) + ":" + (reachable[i][1] + 1) + ")\n";
		}
		System.out.println(str);
	}

	public boolean isReachable(int x, int y) {
		if(!hasReachable()){
			System.out.println("You can't move this piece.");
			return false;
		}

		for(int i = 0; i < nbReachable; i ++) {
			if(reachable[i][0] == x && reachable[i][1] == y)
				return true;
		}
		return false;
	}

	public int[][] getReachable() {
		if(!hasReachable())
			return null;
		return this.reachable;
	}

	public boolean hasReachable() {
		if(this.nbReachable == 0 || this.reachable == null)
			return false;
		return true;
	}

	abstract public void updateReachable();
	protected void updateReachable(int[][] reachable) {
		if(reachable == null) {
			this.reachable = null;
			this.nbReachable = 0;
			return;
		}
		this.reachable = reachable;
		this.nbReachable = reachable.length;
	}

	protected int[][] reachableByRook() {
		int i = this.x + 1;
		int j = this.y;
		int count = 0;
		int[][] pArray = new int[100][2];

		while(isMaybeReachable(i, j)) {
			pArray[count][0] = i;
			pArray[count][1] = j;
			count ++;
			if(this.board.isOccupied(i, j) && !isSameColor(this.board.getPiece(i, j)))
				break;
			i ++;
		}

		i = this.x - 1;

		while(isMaybeReachable(i, j)) {
			pArray[count][0] = i;
			pArray[count][1] = j;
			count ++;
			if(this.board.isOccupied(i, j) && !isSameColor(this.board.getPiece(i, j)))
				break;
			i --;

		}

		i = this.x;
		j = this.y + 1;

		while(isMaybeReachable(i, j)) {
			pArray[count][0] = i;
			pArray[count][1] = j;
			count ++;
			if(this.board.isOccupied(i, j) && !isSameColor(this.board.getPiece(i, j)))
				break;
			j ++;
		}

		j = this.y - 1;

		while(isMaybeReachable(i, j)) {
			pArray[count][0] = i;
			pArray[count][1] = j;
			count ++;
			if(this.board.isOccupied(i, j) && !isSameColor(this.board.getPiece(i, j)))
				break;
			j --;
		}

		return smallestCoorArray(pArray, count);
	}

	protected int[][] reachableByBishop() {
		int i = this.x + 1;
		int j = this.y + 1;
		int count = 0;
		int[][] pArray = new int[100][2];

		while(isMaybeReachable(i, j)) {
			pArray[count][0] = i;
			pArray[count][1] = j;
			count ++;
			if(this.board.isOccupied(i, j) && !isSameColor(this.board.getPiece(i, j)))
				break;
			i ++;
			j ++;
		}

		i = this.x - 1;
		j = this.y + 1;

		while(isMaybeReachable(i, j)) {
			pArray[count][0] = i;
			pArray[count][1] = j;
			count ++;
			if(this.board.isOccupied(i, j) && !isSameColor(this.board.getPiece(i, j)))
				break;
			i --;
			j ++;
		}

		i = this.x + 1;
		j = this.y - 1;

		while(isMaybeReachable(i, j)) {
			pArray[count][0] = i;
			pArray[count][1] = j;
			count ++;
			if(this.board.isOccupied(i, j) && !isSameColor(this.board.getPiece(i, j)))
				break;
			i ++;
			j --;
		}

		i = this.x - 1;
		j = this.y - 1;

		while(isMaybeReachable(i, j)) {
			pArray[count][0] = i;
			pArray[count][1] = j;
			count ++;
			if(this.board.isOccupied(i, j) && !isSameColor(this.board.getPiece(i, j)))
				break;
			j --;
			i --;
		}

		return smallestCoorArray(pArray, count);
	}

	// protected int[][] reachableStrait(int x, int y)

	protected int[][] smallestCoorArray(int[][] array, int size) {
		if(size == 0)
			return null;

		int[][] out = new int[size][2];
		for(int i = 0; i < size; i ++) {
			out[i][0] = array[i][0];
			out[i][1] = array[i][1];
		}
		return out;
	}

	public boolean isSameColor(int x, int y) {
		return this.color == this.board.getPiece(x, y).color();
	}

	public boolean isSameColor(Piece p) {
		return this.color == p.color();
	}

	public boolean color() {return this.color;}

	protected boolean isMaybeReachable(int x, int y) {
		return 		(this.x != x || this.y != y)
				&& 	this.board.isValid(x, y) 
				&& 	(this.board.isOccupied(x, y) ? 
					!isSameColor(this.board.getPiece(x,y)) : true);
	}

	public boolean isSet() {
		return this.x != -1 && this.y != -1;
	}

	public void setBoard(Board b) {this.board = b;}
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setCoor(int x, int y) {
		setX(x);
		setY(y);
	}
	public void setCoor(int[] coor){
		setX(coor[0]);
		setY(coor[1]);
	}

	public int getX() {return this.x;}
	public int getY() {return this.y;}
	public int[] getCoor(){
		int[] out = new int[2];
		out[0] = getX();
		out[1] = getY();
		return out;
	}

	public boolean isKing() {
		return false;
	}
}