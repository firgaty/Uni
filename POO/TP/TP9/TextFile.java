class TextFile extends Element implements Displayable {
	protected String m_content;

	public TextFile(String c) {
		super();
		this.m_content = c;
	}

	public TextFile() {
		this("");
	}

	@Override
	public String getType() {
		return "text file";
	}
	@Override
	public void display() {
		System.out.println(m_content);
	}
}