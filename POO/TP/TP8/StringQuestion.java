class StringQuestion extends Question {
	private final String answer;

	public StringQuestion(String q, int w, String a) {
		super(q, w);
		this.answer = a;
	}

	public boolean isCorrect(String a) {
		return this.answer == a;
	}
}