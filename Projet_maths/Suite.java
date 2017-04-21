class Suite {
  public Suite() {
    double out = 0;
    out = iteration(this.depart, 0);
    System.out.println("u final = " + out);
  }

  public double iteration(double uprecedent, int n) {
    System.out.println(n + "." + " u = " + uprecedent);
    if(n >= 81) return uprecedent;
    //return iteration(uprecedent * (80 - n) / (81 -n), n + 1);
    return iteration(uprecedent - uprecedent / (81 - n), n + 1);
  }

  private double u;
  final private double depart = 40.0;
}
