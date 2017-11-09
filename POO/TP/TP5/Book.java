class Book extends Media {
	protected String author;
	protected int pageNb;

	public Book(String title, String author, int n) {
		super(title);
		this.author = author;
		this.pageNb = n;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + author + " - " + pageNb + " pages.";
	}

	@Override
	public boolean smallerThan(Media m) {
		if(!(m instanceof Book)) 
			return false;
		return super.smallerThan(m);
	} 	// Obtient pas initiallement le resultat recherche, car les autres
		// medias ne font pas la difference de leur cote lors de leur insertion au sein de la LinkedList.
}