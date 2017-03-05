class Pot {
  private Confiture c;
  private int poids;
  private static int counter = 1;

  public Pot(Confiture c, int poids) {
    this.c = c;
    this.poids = poids;
    counter ++;
  }

  public String description() {
    return new String("Ceci est un pot de " + this.c.description());
  }
  public static int() {
    return counter;
  }
}
