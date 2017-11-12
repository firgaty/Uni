class IntIntervalQuestion extends AbstractIntQuestion {
	private final int margin;

	public IntIntervalQuestion(String q, int w, int a, int m) {
		super(q, w, a);
		this.margin = m;
	}

	@Override
	public boolean isCorrect(int a) {
		return a >= this.answer - margin && a <= this.answer + margin;
	}

	@Override
	public String toString() {
		return title + " (With a margin of " + margin + ")" + " | " + weight + ": ";
	}
}