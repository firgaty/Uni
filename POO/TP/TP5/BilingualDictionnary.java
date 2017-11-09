class BilingualDictionnary extends Dictionary {
	private String language2;

	public BilingualDictionnary(String title, String language1, String language2, int n) {
		super(title, language1, n);
		this.language2 = language2;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + language2;
	} 
}