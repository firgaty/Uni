abstract class Element {
	public Element(){}

	public abstract String getType();
	
	@Override
	public String toString() {
		return "Type : " + getType();
	}
}