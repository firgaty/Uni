class Entry {
	private Folder m_parentFolder;
	private String m_name;
	private Element m_elem;

	public Entry(Folder p, String n, Element e) {
		m_parentFolder = p;
		m_name = n;
		m_elem = e;
	}

	@Override
	public String toString() {
		return m_name + "\t\t" + m_elem.toString();
	}

	public Element getElem() {
		return m_elem;
	}

	public void setElem(Element e) {
		m_elem = e;
	}

	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		m_name = name;
	}

	public Folder getParentFolder() {
		return m_parentFolder;
	}

	public void setParentFolder(Folder f) {
		m_parentFolder = f;
	}

	public void delete() {
		m_parentFolder.getEntries().remove(this);
		this.m_parentFolder = null;
	}

	public void insert(Element e) {
		if(e instanceof Folder) {
			Folder f = (Folder) e;
			f.setParent(m_parentFolder);
			m_elem = f;
		} else m_elem = e;
	}
}