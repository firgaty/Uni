class Run {
	public static void main(String[] args) {
		Format[] fArray = new Format[100];
		LimitedFormat[] lArray = new LimitedFormat[100];
		for(int i = 0; i < args.length; i ++) {
			// fArray[i] = new Format(args[i]);
			// fArray[i].read();
			// fArray[i].print();

			lArray[i] = new LimitedFormat(args[i], 50);
			lArray[i].read();
			// lArray[i].print();
			lArray[i].printJustified();
		}


	}
}