import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Tree {

	public class Node {
		boolean m_directory;
		String m_name;
		long m_size;
		ArrayList<Node> m_children;

		public Node(File file) {
			try {
				if(!file.exists())
					throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
			}

			m_directory = file.isDirectory();
			m_name = file.getName();
			m_size = file.length();
			
			if(m_directory) {
				m_children = new ArrayList<Node>();

				for(File f : file.listFiles()) {
					m_children.add(new Node(f));
				}
			} else
				m_children = null;
		}

		public String toString(int level) {
			String str = new String(m_name + " (" + m_size + ")");

			if(m_directory) {
				str += " :\n";

				for(Node child : m_children) {
					for(int i = 0; i <= level; i ++)
						str += "    ";
					str += child.toString(level + 1);
				}
			} else str += "\n";

			return str;
		}
	}

	Node m_root;

	public Tree(String path) {
		m_root = new Node(new File(path));
	}

	public void display() {
		System.out.println(m_root.toString(0));
	}

	public static void main(String[] args) {
		Tree t = new Tree(args[0]);
		t.display();
	}
}