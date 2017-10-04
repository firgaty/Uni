class Plateau {
	int[] cases;
	VuePlateau[] vues;

	public Plateau() {
		this.cases = new int[14];

		vues = new VuePlateau[2];
		vues[0] = new VuePlateau(this, true);
		vues[1] = new VuePlateau(this, false);

		for(int i = 0; i < 6; i++) {
			this.cases[i] = 4;
		}
		for(int i = 7; i < 13; i++) {
			this.cases[i] = 4;
		}
	}

	public int grainesCase(int c) {
		if(c < 0 || c > 14) {
			return -1;
		}

		return this.cases[c];
	}

	public void viderGrainesCase(int c) {
		if(c < 0 || c > 14) {
			return;
		}

		this.cases[c] = 0;
	}

	public void ajouterGrainesCase(int c) {
		if(c < 0 || c > 14) {
			return;
		}

		this.cases[c] += 1;
	}

	public VuePlateau getVue(int i) {
		return vues[i];
	}
}