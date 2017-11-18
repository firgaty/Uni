class ReadOnlyEntry extends Entry {
	public ReadOnlyEntry(Folder p, String n, Element e) {
		super(p, n, e);
	}

	@Override
	public void insert(Element e) {
		System.out.println("This entry can't be modified.");
	}

	@Override
	public void delete() {
		System.out.println("This entry can't be deleted.");
	}
}