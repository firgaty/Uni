import java.util.Arrays;

class SpaceBox extends StretchBox {
	public SpaceBox() {}
	
	@Override
	public int length() {
		return 1;
	}
	
	@Override
	public String toString() {
		return " ";
	}

	@Override
	public String toString(int n) {
		char[] array = new char[n + 1];
		Arrays.fill(array, ' ');
		return new String(array);
	}

	@Override
	public boolean isStretchable() {return true;}
}