class WordBox extends Box {
	private String word;

	public WordBox(String w) {
		this.word = w;
	}

	@Override
	public int length() {
		return word.length();
	}

	@Override
	public String toString() {
		return word;
	}
}