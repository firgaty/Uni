abstract class AbstractIntQuestion extends Question {
	protected final int answer;

	public AbstractIntQuestion(String q, int s, int a) {
		super(q,s);
		this.answer = a;
	}
	
	@Override
	public boolean isCorrect(String answer) {
		try {
			return Integer.parseInt(answer) == this.answer;
		} catch (NumberFormatException e) {
			System.out.println("This is not a valid number (It must be an integer)");
			return false;
		}
	}
}