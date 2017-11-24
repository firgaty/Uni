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
		String[] sArray = new String[1];


		if(!sc.hasNextLine()) { 
			sArray[0] = " ";
			return sArray;
		}

		Scanner	input = new Scanner(sc.nextLine());

		if(!input.hasNext()) {
			sArray[0] = " ";
			return sArray;
		}

		sArray = new String[100];
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

	public Entry access(String path) {
		Folder f = path.charAt(0) == '/' ? m_root : m_current;

		Scanner sc = new Scanner(path);
		sc.useDelimiter("/");

		Entry e = null;
		while(sc.hasNext()) {
			// if(e != null && !e.getElem().getType().equals("folder")) {
			// 	System.out.println("Not a folder");
			// 	return ;
			// }

			e = f.readEntry(sc.next());
			if(e.getElem() == null) {
				System.out.println("File inexistant.");
				f.removeLastEntry();
				return null;
			} else if(e.getElem().getType().equals("folder"))
			f = (Folder) e.getElem();
		}

		return e;
	}

	public Folder accessParentFolder(String path) {
		if(!IsNotEmptyPath(path)) 
			return null;

		Folder f = path.charAt(0) == '/' ? m_root : m_current;

		Scanner sc = new Scanner(path);
		sc.useDelimiter("/");

		Entry e = null;
		String name = sc.next();
		while(sc.hasNext()) {
			e = f.readEntry(sc.next());
			name = sc.next();
			if(e.getElem() == null) {
				System.out.println("Invalid path.");
				return null;
			} else if(!sc.hasNext()) {
				if(e.getElem().getType().equals("folder")) 
					return (Folder) e.getElem();
				else 
					return null;
			} else if(e.getElem().getType().equals("folder"))
			f = (Folder) e.getElem();
		}

		return f;
	}

	public boolean isAccessible(String path) {
		Folder f = path.charAt(0) == '/' ? m_root : m_current;

		Scanner sc = new Scanner(path);
		sc.useDelimiter("/");

		Entry e = null;
		String name;
		while(sc.hasNext()) {
			name = sc.next();
			if(sc.hasNext() && !f.hasSubFolder(name))
				return false;
			else if(!sc.hasNext())
				if(!f.hasSubFile(name))
					return false;
				else
					return true;
			else {
				e = f.readEntry(sc.next());
				if(e.getElem() == null) {
					System.out.println("Invalid path.");
					f.removeLastEntry();
					return false;
				} else if(e.getElem().getType().equals("folder"))
				f = (Folder) e.getElem();
			}
		}

		return false;
	}

	public void changeDirectory(String path) {
		Entry e = access(path);

		if(e == null)
			System.out.println("Folder doesn't exist.");
		else if(!(e.getElem() instanceof Folder))
			System.out.println("Not a folder.");
		else
			m_current = (Folder) e.getElem();
	}

	public void makeDirectory(String name) {
		if(name == null) {
			System.out.println("Invalid name.");
			return;
		}
		m_current.addEntry(new Entry(m_current, name, new Folder(m_current)));
	}

	public void list(String path) {
		if(path == null || path.equals("")) {
			m_current.display();
			return;
		}

		Entry e = access(path);

		if(e == null)
			return;
		if(e.getElem() instanceof Folder) {
			Folder f = (Folder) e.getElem();
			f.display();
		} else {
			System.out.println(e.toString());
		}
	}

	public void list() {
		list(null);
	}

	public void remove(String path) {
		if(!IsNotEmptyPath(path))
			return;
		Entry e = access(path);
		if(e == null)
			return;
		e.delete();
	}

	public void display(String path) {
		if(!IsNotEmptyPath(path))
			return;
		Entry e = access(path);
		if(e == null || !(e.getElem() instanceof Displayable)) {
			System.out.println("No diplayable file found.");
			return;
		}
		Displayable d = (Displayable) e.getElem();
		d.display();
	}

	public void edit(String path, char option) {
		if(!IsNotEmptyPath(path)) return;

		Entry e = access(path);
		if(e == null) {
			Folder p = accessParentFolder(path);
			if(accessParentFolder(path) == null)
				p = m_current;
			System.out.println(getEntryNameFromPath(path));
			e = new Entry(p, getEntryNameFromPath(path), new TextFile());
			p.addEntry(e);
		}
		if(!(e.getElem() instanceof TextFile)) return;

		TextFile f = (TextFile) e.getElem();
		f.display();
		System.out.println("-----------------------------------\nInput:");

		Scanner s = new Scanner(System.in);
		f.edit(s.nextLine(), option);
	}

	public void move(String sourcePath, String destinationPath) {
		if(!IsNotEmptyPath(sourcePath)) {
			System.out.println("Empty path. (1)"); 
			return;
		}
		if(!isAccessible(sourcePath)) {
			System.out.println("Invalid source path. (2)");
			return;
		}

		Folder d = accessParentFolder(destinationPath);

		if(d == null) {
			System.out.println("Invalid destination path. (3)");
			return;
		}
		if(access(destinationPath) != null) {
			System.out.println("File already exists at destination.");
			return;
		} else {
			d.removeLastEntry();
		}

		Entry destination = d.readEntry(getEntryNameFromPath(destinationPath));
		Entry source = access(sourcePath);
		Folder sParent = source.getParentFolder();
		Folder dParent;
		sParent.removeEntry(source);

		// Ajouter le fait de pas supprimer un element deja existant.

		if(destination.getElem() instanceof Folder) {
			dParent = (Folder) destination.getElem();
		} else {
			dParent = destination.getParentFolder();
			source.setName(getEntryNameFromPath(destinationPath));
		}

		//dParent.removeLastEntry();
		dParent.addEntry(source);
		source.setParentFolder(dParent);
	}

	public void copy(String sourcePath, String destinationPath) {
		if(!IsNotEmptyPath(sourcePath)) {
			System.out.println("Empty path. (4)"); 
			return;
		}
		if(!isAccessible(sourcePath)) {
			System.out.println("Invalid source path. (5)");
			return;
		}

		Folder d = accessParentFolder(destinationPath);

		if(d == null) {
			System.out.println("Invalid destination path. (6)");
			return;
		}

		Entry destination = d.readEntry(getEntryNameFromPath(destinationPath));
		Entry source = access(sourcePath);
		Folder sParent = source.getParentFolder();
		Folder dParent;

		if(destination.getElem() instanceof Folder) {
			dParent = (Folder) destination.getElem();
		} else {
			dParent = destination.getParentFolder();
			source.setName(getEntryNameFromPath(destinationPath));
		}

		dParent.addEntry(source);
		source.setParentFolder(dParent);

	}

	private String getEntryNameFromPath(String path) {
		if(!IsNotEmptyPath(path)) return null;

		Scanner sc = new Scanner(path);
		sc.useDelimiter("/");

		String out = sc.next();
		while(sc.hasNext()) {
			out = sc.next();
		}

		return out;
	}

	private boolean IsNotEmptyPath(String path) {
		if(path == null || path.equals("")) {
			System.out.println("Empty path.");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Shell s = new Shell();

		String[] commands;
		String input;

		while(true) {
			commands = s.readInput();

			switch(commands[0]) {
				case "ls" : if(commands.length < 2) s.list();
							else s.list(commands[1]);
							break;
				case "cd" : if(commands.length >= 2) {
								s.changeDirectory(commands[1]);
								break;
							}
				case "mkdir" :	if(commands.length >= 2) {
									s.makeDirectory(commands[1]);
									break;
								}
				case "rm" : if(commands.length >= 2) {
								s.remove(commands[1]);
								break;
							}
				case "mv" : if(commands.length >= 3) {
								s.move(commands[1], commands[2]);
								break;
							}
				case "cp" : if(commands.length >= 3) {
								s.copy(commands[1], commands[2]);
								break;
							}		
				case "edit" :	if(commands.length >= 3 && commands[2].length() == 1) {
									s.edit(commands[1], commands[2].charAt(0));
									break;
								}
				case "display" :	if(commands.length >= 2) {
										s.display(commands[1]);
										break;
									}
				default : 	
					if(commands[0].equals("quit")) System.exit(0);
					System.out.println("Command '" + commands[0] + "' not recognized or missing path/arguments.");
				
			}
		}
	}
}