abstract class Element implements Cloneable {
	public Element(){}

	public abstract String getType();
	
	@Override
	public String toString() {
		return "Type : " + getType();
	}

	@Override
	public Element clone() {
		try {
			return (Element) super.clone();
		} catch(CloneNotSupportedException e) {
			throw new InternalError();
		}
	}
}