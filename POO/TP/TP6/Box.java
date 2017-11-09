abstract class Box {
 	public Box() {};
	abstract public int length();
	@Override
	public String toString() { return ""; }
	public boolean isStretchable() {return false;}
}