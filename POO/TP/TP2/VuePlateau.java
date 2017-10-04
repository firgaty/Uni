class VuePlateau {
	Plateau plateau;
	boolean bas;

	public VuePlateau(Plateau p, boolean bas) {
		this.plateau = p;
		this.bas = bas;
	}

	public void afficherPlateau() {
		String str = new String(" ");

		for(int i = (bas) ? 12 : 5; i >= ((bas) ? 7 : 0); i--) {
			if(plateau.grainesCase(i) < 10) str += " ";
			str += " " + Integer.toString(plateau.grainesCase(i));
		}

		str += "\n" + Integer.toString(((bas) ? plateau.grainesCase(13) : plateau.grainesCase(6)));
		str += "                   ";
		str += Integer.toString(((bas) ? plateau.grainesCase(6) : plateau.grainesCase(13))) + "\n ";

		for(int i = (bas) ? 0 : 7; i <= ((bas) ? 5 : 12); i++) {
			if(plateau.grainesCase(i) < 10) str += " ";
			str += " " + Integer.toString(plateau.grainesCase(i));
		}
		System.out.println(str);
	}

	public boolean viderCase(int c) {
		if(c < 0 || c > 5) return false;
		c += (bas ? 0 : 7);
		if(plateau.grainesCase(c) == 0) return false;

		int graines = plateau.grainesCase(c);
		plateau.viderGrainesCase(c);

		int index = c + 1;

		while (graines > 0) {
			if(index == c) index ++;
			plateau.ajouterGrainesCase(index);
			graines --;
			index ++;
			if(index > 13) index = 0;
		}

		int kalah = bas ? 6 : 13;

		while(index > kalah & (plateau.grainesCase(index) == 2 | plateau.grainesCase(index) == 3)) {
			kalah += plateau.grainesCase(index);
			plateau.viderGrainesCase(index);
			index--;
			if(index < 0) index = 13;
		}

		return true;
	}

	public boolean peutjouer() {
		for(int i = bas ? 0 : 7; i <= (bas ? 5 : 12); i ++) {
			if(plateau.grainesCase(i) != 0) return true;
		}

		return false;
	}
}