class IntStrictQuestion extends AbstractIntQuestion {
	public IntStrictQuestion(String q, int w, int a) {
		super(q, w, a);
	}

	@Override
	public boolean isCorrect(int a) {
		return a == this.answer;
	}
}