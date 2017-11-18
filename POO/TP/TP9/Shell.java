import java.util.Scanner;

class Shell {
	private Folder m_root;
	private Folder m_current;

	public Shell(Folder r, Folder c) {
		m_root = r;
		m_current = c;
	}

	public Shell(Folder r) {
		this(r, r);
	}

	public Shell() {
		this(new Folder());
	}

	public String[] readInput() {
		Scanner sc = new Scanner(System.in);

		if(!sc.hasNextLine())
			return null;

		Scanner	input = new Scanner(sc.nextLine());

		if(!input.hasNext())
			return null;

		String[] sArray = new String[100];
		int counter = 0;

		while(input.hasNext()) {
			sArray[counter] = input.next();
			counter++;
		}

		String[] out = new String[counter];

		for(int i = 0; i < counter; i++)
			out[i] = sArray[i];

		return out;
	}

	public void acceder(String path) {
		Folder f = m_current;
		if(path.charAt(0) == '/') {
			f = m_root;
		}

		Scanner sc = new Scanner(path);
		sc.useDelimiter("/");

		Entry e = null;
		while(sc.hasNext()) {
			if(e != null && !e.getElem().getType().equals("folder")) {
				System.out.println("Not a folder");
				return;
			}

			e = f.readEntry(sc.next());
			if(e.getElem() == null) {
				System.out.println("Invalid path.");
				return;
			} else if(e.getElem().getType().equals("folder"))
			f = (Folder) e.getElem();
		}

		m_current = f;
	}
}