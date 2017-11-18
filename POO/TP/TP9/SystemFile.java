class SystemFile extends Element {
	protected String m_content;

	public SystemFile(String c) {
		super();
		this.m_content = c;
	}

	public SystemFile() {
		this("");
	}

	@Override
	public String getType() {
		return "system file";
	}
}