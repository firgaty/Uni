class MultipleChoiceQuestion extends StringQuestion {
	private final String[] answers;

	public MultipleChoiceQuestion(String q, int w, String a, String[] as) {
		super(q, w, a);
		this.answers = as;
	}

	@Override
	public String toString() {
		String out = new String("");

		out += super.toString();
		for (int i = 0; i < this.answers.length; i ++) 
			out += "\n" + (char) (97 + i) + ") " + this.answers[i];

		return out;
	}
}