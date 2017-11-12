abstract class Question {
	protected final String title;
	protected final int weight;

	public Question(String q, int s) {
		this.title = q;
		this.weight = s;
	}

	public String getTitle() {
		return title;
	}

	public int getWeight() {
		return weight;
	}

	abstract boolean isCorrect(String answer);
	@Override
	public String toString() {
		return title + " | " + weight + ":";
	}
}