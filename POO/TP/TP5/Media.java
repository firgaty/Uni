class Media {
	private final String title;
	private final int serialNb;
	private static int serialNbCounter = 0;

	public Media(String title) {
		this.title = title;
		this.serialNb = serialNbCounter;
		serialNbCounter ++;
	}

	public String getTitle() {
		return this.title;
	}

	public int getSerialNb() {
		return serialNb;
	}

	@Override
	public String toString() {
		return new String(serialNb + ": " + this.title);
	}

	public boolean smallerThan(Media doc) {
		return serialNb < doc.getSerialNb();
	}
	public boolean smallerThan(Livre l) {
		if(this instanceof Livre)
			return serialNb < l.getSerialNb();
		return true;
	}
}