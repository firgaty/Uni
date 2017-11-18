class BigObject {
	private int[] m_array;
	private int m_id;
	private static int s_id= 0;

	public static void main(String[] args) {
		BigObject[] array = new BigObject[100];
		for(int i = 0; i < 100; i ++) {
			array[i] = new BigObject();
		}

		for(int i = 0; i < 100; i++) {
			array[i].finalize();
		}

		// Lors de l'execution du programme,
		// les objets sont initialises mais la méthode
		// finalize() n'est pas appelé si ce n'est pas fait 
		// explicitement.
		// Sinon, ces objets sont detruits dans l'ordre ou 
		// finalise() est appelee.
	}

	public BigObject() {
		this.m_array = new int[1000000];
		this.m_id = s_id;
		incStaticId();
		System.out.println(m_id);
	}

	private void incStaticId() {
		s_id ++;
	}

	@Override
	public void finalize() {
		System.out.println(m_id);
	}
}