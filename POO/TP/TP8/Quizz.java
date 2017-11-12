import java.util.LinkedList;
import java.util.Scanner;

class Quizz {
	private LinkedList<Question> qList;

	public static void main(String[] args) {
		Bank bank = new Bank();

		Quizz q = new Quizz();
		bank.interactiveQuizzCreation().ask();

		// Quizz q = new Quizz();

		// q.addQuestion(new StringQuestion("Quelle est la capitale de la Suisse ?", 2, "Berne"));
		// q.addQuestion(new IntStrictQuestion("Combien d'étoiles apparaissent sur le drapeau de l'Union Européenne ?", 4, 12));
		// q.addQuestion(new IntIntervalQuestion("Quelle est la taille d'un Hobit moyen ? (en cm)", 3, 107, 10));
		// String[] aList = {"John Hammond", "Alan Grant", "Henry Archibald", "Ian Malcolm"};
		// q.addQuestion(new MultipleChoiceQuestion("Quel est le nom du scientifique ayant créé le parc de Jurassic Park ?", 5, "a", aList));

		// q.ask();
	}

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

	public void addQuestion(Question q) {
		if(q != null)
			this.qList.add(q);
	}

	public void removeLastQuestion() {
		this.qList.removeLast();
	}

	public void removeQuestion(int index) {
		if(index >= qList.size() || index < 0)
			return;
		this.qList.remove(index);
	}

	public void ask() {
		int score = 0;
		int scoreMax = 0;
		Scanner sc = new Scanner(System.in);

		for(Question q : qList) {
			System.out.println(q.toString());
			scoreMax += q.getWeight();
			if(q.isCorrect(sc.nextLine())) {
				score += q.getWeight();
				System.out.println("Nice !");
			} else {
				System.out.println("Too bad... The right answer was : " + q.getAnswer());
			}
		}

		System.out.println("\n\nYour score : " + score + " | " + scoreMax);
	}

	public String description() {
		String out = new String("");

		for(int i = 0; i < qList.size(); i ++) {
			out += Integer.toString(i) + ") " + qList.get(i).toString()
				+ "\nAnswer : " + qList.get(i).getAnswer() + "\n";
		}

		return out;
	}

	public int numberOfQuestions() {
		return qList.size();
	}	
}