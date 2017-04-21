class Noeud {
  private int etiquette;
  private Noeud gauche;
  private Noeud droit;

  public Noeud(int etiquette, Noeud gauche, Noeud droit) {
    this.etiquette = etiquette;
    this.gauche = gauche;
    this.droit = droit;
  }

  public Noeud(int etiquette) {
    this(etiquette, null, null);
  }

  public Noeud(Noeud n) {
    this.etiquette = n.getEtiquette();
    this.droit = n.getDroit() == null ? null : new Noeud(n.getDroit());
    this.gauche = n.getGauche() == null ? null : new Noeud(n.getGauche());
  }

  public Noeud(int[] tab) {
    switch(tab.length) {
      case 1: {
        this.etiquette = tab[0];
        this.gauche = null;
        this.droit = null;
        break;
      }
      case 2: {
        this.etiquette = tab[1];
        this.gauche = new Noeud(tab[0]);
        this.droit = null;
        break;
      }
      case 3: {
        this.etiquette = tab[1];
        this.gauche = new Noeud(tab[0]);
        this.droit = new Noeud(tab[2]);
        break;
      }
      default: {
        int r = tab.length / 2;
        int tabG[] = new int[r];
        int tabD[] = new int[tab.length - (r + 1)];

        for(int i = 0; i < r; i ++) tabG[i] = tab[i];
        for(int i = r + 1; i < tab.length; i ++) tabD[i - (r + 1)] = tab[i];

        this.etiquette = tab[r];
        this.gauche = new Noeud(tabG);
        this.droit = new Noeud(tabD);
      }
    }
  }

  public String infixe() {
    String out = new String("");

    if(this.gauche != null) out += this.gauche.infixe();
    out += Integer.toString(etiquette) + " ";
    if(this.droit != null) out += this.droit.infixe();

    return out;
  }

  public String prefixe() {
    String out = new String("");

    out += Integer.toString(etiquette) + " ";
    if(this.gauche != null) out += this.gauche.prefixe();
    if(this.droit != null) out += this.droit.prefixe();

    return out;
  }

  public String postfixe() {
    String out =  new String("");

    if(this.gauche != null) out += this.gauche.postfixe();
    if(this.droit != null) out += this.droit.postfixe();
    out += Integer.toString(etiquette) + " ";

    return out;
  }

  public int nbNoeuds() {
    int out = 0;

    if(this.gauche != null) out += this.gauche.nbNoeuds();
    if(this.droit != null) out += this.droit.nbNoeuds();

    return out + 1;
  }

  public int somme() {
    int out = 0;

    if(this.gauche != null) out += this.gauche.somme();
    if(this.droit != null) out += this.droit.somme();

    return out + this.etiquette;
  }

  public int profondeur() {
    if(this.gauche == null && this.droit == null) return 0;

    int gauche = 0;
    int droit = 0;

    if(this.gauche != null) gauche += this.gauche.profondeur();
    if(this.droit != null) droit += this.droit.profondeur();

    return (gauche > droit ? gauche : droit) + 1;
  }

  public boolean contientNoeudDEtiquette(int e) {
    if(this.etiquette == e) return true;

    return ((this.gauche != null ? this.gauche.contientNoeudDEtiquette(e) : false) || (this.droit != null ? this.gauche.contientNoeudDEtiquette(e) : false));
  }

  // GETTERS & SETTERS

  public int getEtiquette() {
    return this.etiquette;
  }
  public Noeud getGauche() {
    return this.gauche;
  }
  public Noeud getDroit() {
    return this.droit;
  }
}
