class Informations {
	private int vitalite;
	private int force;
	private int agilite;

	public Informations(int vitalite, int force, int agilite) {
		this.vitalite = vitalite;
		this.force = force;
		this.agilite = agilite;
	}
	public Informations(Informations i) {
		this(i.getVitalite(), i.getForce(), i.getAgilite());
	}

	public int getVitalite() {
		return this.vitalite;
	}
	public int getForce() {
		return this.force;
	}
	public int getAgilite() {
		return this.agilite;
	}

	public void setVitalite(int v) {
		this.vitalite = v > 0 ? v : 0;
	}
	public void setForce(int f) {
		this.force = f > 0 ? f : 0;
	}
	public void setAgilite(int a) {
		this.agilite = a > 0 ? a : 0;
	}

	public String toString() {
		return "Vitalite : " + String.valueOf(this.vitalite) +
				" ; Force : " + String.valueOf(this.force) +
				" ; Agilite : " + String.valueOf(this.agilite);
	}
}