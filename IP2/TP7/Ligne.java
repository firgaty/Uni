class Ligne {
  private String valeur;
  private Ligne suivante;
  private Ligne precedente;

  public Ligne(String valeur){
    this.valeur = valeur;
  }
  public Ligne(String valeur, Ligne precedente, Ligne suivante) {
    this.valeur = valeur;
    this.precedente = precedente;
    this.suivante = suivante;
  }



	/**
	* Returns value of valeur
	* @return
	*/
	public String getValeur() {
		return valeur;
	}

	/**
	* Sets new value of valeur
	* @param
	*/
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/**
	* Returns value of suivante
	* @return
	*/
	public Ligne getSuivante() {
		return suivante;
	}

	/**
	* Sets new value of suivante
	* @param
	*/
	public void setSuivante(Ligne suivante) {
		this.suivante = suivante;
	}

	/**
	* Returns value of precedente
	* @return
	*/
	public Ligne getPrecedente() {
		return precedente;
	}

	/**
	* Sets new value of precedente
	* @param
	*/
	public void setPrecedente(Ligne precedente) {
		this.precedente = precedente;
	}

}
