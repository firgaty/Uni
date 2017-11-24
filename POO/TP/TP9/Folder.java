import java.util.LinkedList;

class Folder extends Element implements Displayable {
	private LinkedList<Entry> m_entries;
	private Folder m_parent;

	public Folder(Folder p) {
		super();
		this.m_entries = new LinkedList<Entry>();
		this.m_parent = p;

		if(m_parent != null)
			m_entries.add(new ReadOnlyEntry(m_parent.getParent(), "..", m_parent));
		m_entries.add(new ReadOnlyEntry(m_parent, ".", this));
	}

	public Folder() {
		this(null);
	}

	public LinkedList<Entry> getEntries() {
		return m_entries;
	}

	@Override
	public String getType() {
		return "folder";
	}

	public Folder getParent() {
		return m_parent;
	}

	public void setParent(Folder p) {
		m_parent = p;
	}

	public Entry readEntry (String name) {
		for(Entry e : m_entries) {
			if(e.getName().equals(name))
				return e;
		}
		Entry out = new Entry(this, name, null);
		m_entries.add(out);
		return out;
	}

	public boolean hasSubFile(String name) {
		for(Entry e : m_entries) {
			if(e.getName().equals(name))
				return true;
		}
		return false;
	}

	public boolean hasSubFolder(String name) {
		for(Entry e : m_entries) {
			if(e.getName().equals(name) && e.getElem().getType().equals("folder"))
				return true;
		}
		return false;
	}

	@Override
	public void display() {
		for(Entry e : m_entries) {
			System.out.println(e.toString());
		}
	}

	public void addEntry(Entry e) {
		m_entries.add(e);
	}

	public void removeLastEntry() {
		m_entries.removeLast();
	}

	public boolean removeEntry(Entry r) {
		for(Entry e : m_entries) {
			if(e == r) {
				m_entries.remove(r);
				return true;
			}
		}

		return false;
	}
}