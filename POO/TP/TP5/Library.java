import java.util.LinkedList;

class Library {
	private LinkedList<Media> dataBase;

	public static void main(String[] args) {
		Library l = new Library();
		Book b = new Book("How to (not) become the best", "Arthur Dolce", 231);
		l.addMedia(new Book("Hello World!", "John Doe", 304));
		l.addMedia(new Dictionary("Welcome.", "English", 2));
		l.addMedia(new Book("50 good cooks", "Henry Jerryman", 167));
		Dvd d = new Dvd("JackAction", "Tim Cook", 127);
		l.addMedia(new Dvd("Wildlife in New Zealand", "Douglas McDaniel", 94));
		l.addMedia(new Book("Back again", "William Shishire", 570));
		l.addMedia(new BilingualDictionnary("Oxford Regional", "English", "Welsh", 1));
		l.addMedia(b);
		l.addMedia(d);

		l.printDataBase();
		System.out.println("\n\n");

		l.printAllDictionaries();
	}

	public Library() {
		this.dataBase = new LinkedList<Media>();
	}

	public void addMedia(Media m) {
		if(dataBase.size() == 0) {
			dataBase.add(m);
			return;
		}
		for(int i = 0; i < dataBase.size(); i ++) {
			if(m.smallerThan(dataBase.get(i))) {
				dataBase.add(i, m);
				return;
			}
		}
		dataBase.add(m);
		//System.out.println("Problem adding Media to Library.");
		return;
	}

	public void printDataBase() {
		for(int i = 0; i < dataBase.size(); i ++) {
			System.out.println(dataBase.get(i).toString());
		}
	}

	public void printAllDictionaries() {
		for(Media m : dataBase) {
			if(m instanceof Dictionary)
				System.out.println(m);
		}
	}
}