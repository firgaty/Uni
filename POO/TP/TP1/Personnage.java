class Personnage {
	private String nom;
	private Informations statsActuels;
	private Informations statsBase;

	public Personnage(String nom, Informations i) {
		this.statsBase = new Informations(i);
		this.statsActuels = new Informations(i);
		this.nom = nom;
	}
	public Personnage(String nom, int vitalite, int force, int agilite) {
		this(nom, new Informations(vitalite, force, agilite));
	}
	public Personnage(String nom){
		this(nom, new Informations(100, 50, 50));
	}

	public boolean estVivant() {
		return this.statsActuels.getVitalite() > 0;
	}
	public void rebirth() {
		this.statsActuels.setVitalite(this.statsBase.getVitalite());
		this.statsActuels.setForce(this.statsBase.getForce());
		this.statsActuels.setAgilite(this.statsBase.getAgilite());
	}
	public String toString() {
		return this.nom + " : " + this.statsActuels.toString();
	}

	public void attaque(Personnage p) {
		p.coup((p.getAgilite() > this.getAgilite()) ? 0 : (int) Math.random() * Math.max(1, this.getForce() - p.getForce()) + 1);
		if(p.getAgilite() > this.getAgilite()) p.setAgilite((p.getAgilite() / 3) * 2);
	}

	public int lutteIte(Personnage p) {
		boolean win = false;
		int count = 0;

		while(!win) {
			this.attaque(p);
			count ++;
			if(!p.estVivant()) {
				win = true;
				this.recupereAgi();
			} else {
				p.attaque(this);
				count ++;
				if(!this.estVivant()) {
					win = true;
					p.recupereAgi();
				}
			}
		}

		return count;
	}

	public int lutteRec(Personnage p) {
		this.attaque(p);
		if(!p.estVivant()) {
			this.recupereAgi();
			return 1;
		}
		return p.lutteRec(this) + 1;
	}

	/*	
	*	EXO 4.5
	*
	*	La regle qui lie la valeur retournee par les methodes de lutte et le vainqueur est
	*	que le vainqueur est l'objet sur lequel on a appele la fonction si la valeur retournee
	*	% 2 = 1. Sinon, si la valeur retournee % 2 = 0, c'est l'objet passe en parametre.
	*/

	public void recupereAgi() {
		this.setAgilite(this.statsBase.getAgilite());
	}

	public int getVitalite() {
		return this.statsActuels.getVitalite();
	}
	public int getForce() {
		return this.statsActuels.getForce();
	}
	public int getAgilite() {
		return this.statsActuels.getAgilite();
	}
	public void setVitalite(int v) {
		this.statsActuels.setVitalite(v);
	}
	public void coup(int intensite) {
		if(intensite == 0) return;
		this.setVitalite(this.getVitalite() - intensite);
	}
	public void setAgilite(int a) {
		this.statsActuels.setAgilite(a);
	}
}