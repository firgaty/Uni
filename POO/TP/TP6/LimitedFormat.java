import java.util.Scanner;
import java.util.LinkedList;
import java.io.*;

class LimitedFormat extends Format {
	private int lineLength;
	private LinkedList<LinkedList<CompositeBox>> list2;

	public LimitedFormat(String file, int l) {
		super(file);
		this.lineLength = l;
		list2 = new LinkedList<LinkedList<CompositeBox>>();
	}

	public void read() {
		while(sc.hasNextLine()) {
			readParagraph();
		}
	}

	private void readParagraph() {
		String str;
		String[] strArray;
		LinkedList<CompositeBox> cbs = new LinkedList<CompositeBox>();
		boolean first = true;

		if(!sc.hasNextLine())
			return;

		Scanner scan = new Scanner(sc.nextLine());
		
		if(!scan.hasNext())
				return;

		cbs.add(new CompositeBox());
		
		while(sc.hasNextLine() || first) {
			scan = first ? scan : new Scanner(sc.nextLine());

			str = "";
			boolean empty = true;

			while(scan.hasNext()) {
				str = scan.next();
				if(str == " " || str == "\t" || str == "\n")
					continue;

				if(new WordBox(str).length() + cbs.getLast().length() > this.lineLength){
					cbs.getLast().removeLastBox();
					cbs.add(new CompositeBox());
				}

				cbs.getLast().addBox(new WordBox(str));
				cbs.getLast().addBox(new SpaceBox());
				empty = false;
			}

			if(empty)
				break;

			first = false;
		}

		cbs.getLast().removeLastBox();
		this.list2.add(cbs);
	}

	public void print() {
		for(int i = 0; i < list2.size(); i ++) {
			for(CompositeBox b : list2.get(i)) {
				System.out.println(b.toString());
			}
			if(i != list2.size() - 1)
				System.out.println("\n");
		}
	}

	public void printJustified() {
		for(int i = 0; i < list2.size(); i ++) {
			for(int j = 0; j < list2.get(i).size() - 1; j ++) {
				System.out.println(list2.get(i).get(j).toString(this.lineLength - list2.get(i).get(j).length()));
			}
			System.out.println(list2.get(i).getLast().toString());

			if(i != list2.size() - 1)
				System.out.println("\n");
		}
	}
}