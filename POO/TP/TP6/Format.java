import java.util.Scanner;
import java.util.LinkedList;
import java.io.*;


class Format {
	protected Scanner sc;
	protected LinkedList<CompositeBox> list;

	public Format(String file) {
		sc = null;
		try {
			sc = new Scanner(new File(file));
		} catch(Exception e) {
			System.out.println("Error while opening file.");
			e.printStackTrace();
			System.exit(1);
		}

		list = new LinkedList<CompositeBox>();
	}

	public void read() {
		while(sc.hasNextLine()) {
			readParagraph();
		}
	}

	private void readParagraph() {
		String str;
		String[] strArray;
		CompositeBox cb = new CompositeBox();
		boolean first = true;

		if(!sc.hasNextLine())
			return;

		Scanner scan = new Scanner(sc.nextLine());
		
		if(!scan.hasNext())
				return;
		
		while(sc.hasNextLine() || first) {
			scan = first ? scan : new Scanner(sc.nextLine());
			
			str = "";
			boolean empty = true;

			while(scan.hasNext()) {
				str = scan.next();
				if(str == " " || str == "\t" || str == "\n")
					continue;

				cb.addBox(new WordBox(str));
				cb.addBox(new SpaceBox());
				empty = false;
			}

			if(empty)
				break;

			first = false;
		}

		cb.removeLastBox();
		this.list.add(cb);
	}

	public void print() {
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i).toString());
			System.out.println("\n");
		}
	}

	private boolean isEmptyLine(String str) {
		for(int i = 0; i < str.length(); i ++)
			if(str.charAt(i) != ' ')
				return false;

		return true;
	}
}