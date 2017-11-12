import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class Bank {
	private LinkedList<Question> qList;

	public Bank() {
		this.qList = new LinkedList<Question> ();
	}

	public boolean addQuestion(Question q) {
		if(q != null)
			return false;
		this.qList.add(q);
		return true;
	}

	public void removeLastQuestion()  {
		this.qList.removeLast();
	}

	public boolean removeQuestion(int index) {
		if(index >= qList.size() || index < 0)
			return false;

		this.qList.remove(index);
		return true;
	}

	public boolean addQuestionAt(Question q, int index) {
		try {
			qList.add(index, q);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean swapQuestions(int first, int second) {
		try {
			Question q = qList.get(first);
			qList.set(first, qList.get(second));
			qList.set(second, q);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	public boolean setFirst(int index) {
		return swapQuestions(0, index);
	}
	public boolean setLast(int index) {
		return swapQuestions(qList.size() - 1, index);
	}

	public Question getQuestion(int index) {
		try {
			return qList.get(index);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public Quizz randomQuizz(int n) {
		if(n > qList.size())
			n = qList.size();
		if(n <= 0)
			return null;

		Quizz out = new Quizz();
		LinkedList<Question> list = new LinkedList<Question> (qList);
		Random rand = new Random();

		for (int i = qList.size(); i > qList.size() - n; i --) {
			int r = rand.nextInt(i);
			out.addQuestion(list.get(r));
			list.remove(r);
		}

		return out;
	}

	public Quizz interactiveQuizzCreation() {
		Quizz out = new Quizz();
		

		return mainMenu(out);

	}

	private Quizz mainMenu(Quizz q) {
		while(true) {
			System.out.print("\033[H\033[2J");
			System.out.println(   "1) Add a new question to the quizz.\n"
								+ "2) Remove a question.\n"
								+ "3) Modify the question's order.\n"
								+ "4) See the current questions.\n"
								+ "0) End the setup of the quizz and... LAUNCH IT !");
		
			switch(IntInput(0, 4)){
				case 1 : {
					q = addQuestionMenu(q);
					break;
				}
				case 2 : {
					q = removeQuestionMenu(q);
					break;
				}
				case 3 : {
					q = modifyQuestionsMenu(q);
					break;
				}
				case 4 : {
					System.out.print("\033[H\033[2J");
					System.out.println(q.description());
					Scanner scan = new Scanner(System.in);
					System.out.println("To go back to last menu, press any key.");
					scan.next();
					break;
				}
				case 0 : {
					System.out.print("\033[H\033[2J");
					return q;
				}
			}
		}
	}

	private Quizz addQuestionMenu(Quizz q) {
		System.out.print("\033[H\033[2J");
		System.out.println(	  "1) String question.\n"
							+ "2) Integer question.\n"
							+ "3) Integer question with margin.\n"
							+ "4) Multiple choice question.\n"
							+ "0) Return to previous menu.");
		
		int input = IntInput(0, 4);
		Question question;

		if(input == 0)
			return q;

		System.out.println("Input the title of the question :");
		String title = StringInput();

		System.out.println("Input the weight of the question (number of points) :");
		int weight = IntInput(0, 100);
		
		if(input == 2 || input == 3) {
			System.out.println("Input the answer :");
			int answer = IntInput();
			
			if(input == 2) {
				question = new IntStrictQuestion(title, weight, answer);
			} else {
				System.out.println("Input the margin :");
				question = new IntIntervalQuestion(title, weight, answer, IntInput());
			}
		} else {
			if(input == 1) {
				System.out.println("Input the answer :");
				String answer = StringInput();

				question = new StringQuestion(title, weight, answer);
			} else {
				System.out.println("Input the answerS (\"q\" to stop):");
				LinkedList<String> answersList = new LinkedList<String>();

				String str;
				while(true) {
					str = StringInput();
					if(str.equals("q"))
						break;
					answersList.add(str);
				}

				String[] answers = new String[answersList.size()];
				for(int i = 0; i < answersList.size(); i ++) {
					answers[i] = answersList.get(i);
				}

				System.out.println("Input the right answer (a...z)");
				question = new MultipleChoiceQuestion(title, weight, StringInput(), answers);
			}
		}

		q.addQuestion(question);

		return q;
	}

	private Quizz removeQuestionMenu(Quizz q) {
		System.out.println("Input the number of the Question to be removed (-1 to go back) :");
		int input = IntInput(-1, q.numberOfQuestions() - 1);
		if(input == -1)
			return q;
		q.removeQuestion(input);
		return q;
	}

	private Quizz modifyQuestionsMenu(Quizz q) {
		System.out.println("Select the");
		return q;
	}

	private int IntInput() {
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNextInt()) {
			System.out.println("Input an Integer :");
		}
		return scan.nextInt();
	}

	private int IntInput(int min, int max) {
		int out = IntInput();
		while(out > max || out < min)
			out = IntInput();
		return out;
	}

	private String StringInput() {
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNextLine()) {
			System.out.println("Input :");
		}
		return scan.nextLine();
	}
}