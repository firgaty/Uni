class Dictionary extends Media {
	protected String language;
	protected int tomeNb;

	public Dictionary(String title, String language, int n) {
		super(title);
		this.language = language;
		this.tomeNb = n;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + tomeNb + " tomes - " + language ;
	}
}