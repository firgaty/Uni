import java.util.LinkedList;
import java.util.Scanner;

class Quizz {
	private LinkedList<Question> qList;

	public Quizz(LinkedList<Question> list) {
		this.qList = list;
	}

	public Quizz() {
		this(new LinkedList<Question>());
	}

	public Question getQuestion(int i) {
		if(i >= this.qList.size()) return null;
		return this.qList.get(i);
	}

	public void ask() {
		int score = 0;
		Scanner sc = new Scanner(System.in);

		for(Question q : qList) {
			System.out.println(q.toString());
			if(q.isCorrect(sc.nextLine()))
				score += q.getWeight();
		}

		System.out.println("\n\nYour score : " + score + " points.");
	}
}