import java.util.LinkedList;

class CompositeBox extends StretchBox {
	private LinkedList<Box> boxes;

	public CompositeBox(LinkedList<Box> l) {
		this.boxes = l;
	}

	public CompositeBox(Box b) {
		this(new LinkedList<Box>());
		this.boxes.add(b);
		
	}

	public CompositeBox() {
		this.boxes = new LinkedList<Box>();
	}

	@Override
	public int length() {
		int out = 0;

		for(int i = 0; i < boxes.size(); i ++)
			out += boxes.get(i).length();

		return out;
	}

	@Override
	public String toString() {
		String out = new String("");

		for(int i = 0; i < boxes.size(); i ++) 
			out += boxes.get(i).toString();

		return out;
	}

	@Override
	public String toString(int n) {
		if(!this.isStretchable() || n == 0)
			return this.toString();

		int spaces = this.spaceBoxCount();
		//if(this.boxes.getLast() instanceof SpaceBox)
		int q = n / spaces;
		int r = n % spaces;
		String out = new String("");

		for(int i = 0; i < boxes.size(); i ++) {
			if(boxes.get(i) instanceof SpaceBox) {
				SpaceBox sb = (SpaceBox) boxes.get(i);
				out += sb.toString(q + (r > 0 ? 1 : 0));
				r--;
			} else {
				out += boxes.get(i).toString();
			}
		}

		return out;		
	}

	@Override
	public boolean isStretchable() {
		for(Box b : boxes) {
			if(b.isStretchable())
				return true;
		}

		return false;
	}

	private int spaceBoxCount() {
		int out = 0;

		for(Box b : boxes) {
			if(b instanceof SpaceBox)
				out ++;
		}

		return out;
	}

	public boolean isEmpty() {
		return boxes.size() == 0;
	}

	public void addBox(Box b) {
		boxes.add(b);
	}

	public void removeLastBox() {
		boxes.removeLast();
	}

	/*
	* Adds an array of Box-es bs. spaces true means that we NEED to add SpaceBoxe-s. 
	*
	*/
	public void addParagraph(Box[] bs, boolean spaces) {
		for(Box b : bs) {
			addBox(b);
			if(spaces) addBox(new SpaceBox());
		}
		if(spaces) removeLastBox();
	}
}