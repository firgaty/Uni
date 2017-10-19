class Board {
	private final int x;
	private final int y;
	private Piece[][] squares;
	private Piece[] pieces;
	private int pieceCount;
	private King[] kings;
	private int nbKings;
	private boolean oneKingTaken;

	public Board(int x, int y) {
		this.squares = new Piece[x][y];
		this.x = x;
		this.y = y;
		this.kings = new King[2];
		this.nbKings = 0;
		this.oneKingTaken = false;

		System.out.println("x : " + x + "\ny : " + y);
	}

	public boolean isOccupied(int x, int y) {
		return isValid(x, y) && this.squares[x][y] != null;
	}

	public boolean isValid(int x, int y) {
		return x >= 0 && x < this.x && y >= 0 && y < this.y;
	}

	public void setPiece(int x, int y, Piece p) {
		if(!isValid(x, y)) {
			System.out.println("Piece non valide en " + x +":" +y);
			return;
		}
		System.out.println("Piece placee en : " + x + ":" + y);
		this.squares[x][y] = p;
		p.setX(x);
		p.setY(y);
	}

	public void initPiece(int x, int y, Piece p) {
		if(!isValid(x, y)) return;
		System.out.println("Piece initialisee.");
		p.setBoard(this);
		setPiece(x, y, p);
	}

	public void initKing(int x, int y, King k) {
		this.kings[this.nbKings] = k;
		this.nbKings ++;
		initPiece(x, y, k);
	}

	public Piece getPiece(int x, int y) {
		if(!isValid(x, y) || !isOccupied(x, y)){
			//System.out.println("Valeur non retourne");
			return null;
		}
		//System.out.println("Valeur retournee");
		return this.squares[x][y];
	}

	public void remove(int x, int y) {
		if(!isValid(x, y)) return;
		this.squares[x][y] = null;
	}

	public void display() {
		String str = new String(" ");

		for(int i = 0; i < this.x; i ++)
			str += " " + ( i + 1);

		for(int j = 0; j < this.x; j ++) {
			str += "\n" + (j + 1);
			for(int i = 0; i < this.y; i ++) {
				str += " ";
				if(getPiece(i, j) == null) {
					//System.out.println("Case vide");
					str += (i + j) % 2 == 0 ? "-" : "#";
				} else {
					//System.out.println(getPiece(i, j).toString() + " en " + i + ":" + j);
					str += getPiece(i, j).toString();
				}
			}
		}

		System.out.println(str);
	}

	public void updateAll() {
		for(int i = 0; i < x; i ++) {
			for(int j = 0; j < y; j ++) {
				if(isOccupied(i , j)) {
					getPiece(i, j).updateReachable();
				}
			}
		}
	}

	/*public void updateKingsReachability() {
		for(int i = 0; i < x; i ++) {
			for(int j = 0; j < y; j ++) {
				if(isOccupied(i , j) && !kings[0].isSameColors(getPiece(i, j))) {
					getPiece(i, j).updateReachable();
				}
			}
		}
	}*/

	public int getSizeX(){
		return this.x;
	}
	public int getSizeY() {
		return this.y;
	}

	public boolean move(int x0, int y0, int x1, int y1) {
		if(!isValid(x0, y0) || !isOccupied(x0, y0) || !isValid(x1, y1) || isOccupied(x1, y1))
			return false;
		if(isOccupied(x1, y1) && !getPiece(x0, y0).isReachable(x1, y1))
			return false;
		if(isOccupied(x1, y1) && getPiece(x1, y1).isKing())
			this.oneKingTaken = true;
		setPiece(x1, y1, getPiece(x0, y0));
		remove(x0, y0);
		return true;
	}

	public boolean oneKingTaken() {return this.oneKingTaken;}
}