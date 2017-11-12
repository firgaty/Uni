class StringQuestion extends Question {
	protected final String answer;

	public StringQuestion(String q, int w, String a) {
		super(q, w);
		this.answer = a;
	}

	public boolean isCorrect(String a) {
		return this.answer.equals(a);
	}

	public String getAnswer() {
		return answer;
	}
}