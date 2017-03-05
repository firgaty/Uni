class Confiture {
  private static String fruit;
  private int proportion;
  private int cal;

  public Confiture(String fruit, int proportion, int sucre){
    this.fruit = fruit;
    this.proportion = proportion;
    this.cal = sucre*387;
  }

  public Confiture(String fruit, int sucre) {
    this.fruit = fruit;
    this.proportion = 50;
    this.cal = sucre*387;
  }

  public String getFruit() {
    return this.fruit;
  }
  public int getProportion() {
    return this.proportion;
  }
  public int getCal() {
    return this.cal.
  }

  public static void setCal(int cal) {
    this.cal = cal;
  }

  public String description() {
    return new String("Confiture de " + this.fruit + \
                            ", " + this.proportion + "% de fruit, " + \
                            this.cal + " calories ax 100 grammes.");;
  }

  public int nbCal(int quantite) {
    return this.cal*quantite / 100;
  }

  public boolean egal(Confiture c) {
    if (c.getFruit() == this.fruit && c.getProportion() == this.proportion && c.getCal() == this.Cal) {
      return true;
    } else {
      return false;
    }
  }
}
