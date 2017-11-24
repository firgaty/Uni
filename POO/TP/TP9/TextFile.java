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

	public boolean edit(String s, char option) {
		switch(option) {
			case 'a' : { // Append
				m_content += "\n" + s;
				break;
			}
			case 'w' : { // Write
				m_content = s;
				break;
			}
			case 'b' : {
				m_content = s + "\n" + m_content;
				break;
			}
			default : {
				System.out.println("Option not recognized");
				return false;
			}
		}
		return true;
	}
}