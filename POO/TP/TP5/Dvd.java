class Dvd extends Media {
	protected String director;
	protected int length;

	public Dvd(String title, String director, int l) {
		super(title);
		this.director = director;
		this.length = l;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + director + " - " + length + " minutes";
	}
}