import java.util.Random;

public class Plateau {
    public final int hauteur, largeur, nbMines;
    
    private final boolean[][] mines;
        /*indique où sont les mines sur le plateau*/
    private final int[][] etats;
        /*indique dans quel état est chaque case
          (cachée, révélée, avec/sans drapeau)*/
    private final int[][] adja;
        /*indique le nombre de mines adjacentes 
          à chaque case*/
    private int nbDrapeaux;

    public Plateau(int hauteur, int largeur, int nbMines) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.nbMines = nbMines;

        this.mines = new boolean[hauteur][largeur]; 
        this.etats = new int[hauteur][largeur];
        this.adja = new int[hauteur][largeur];

        this.nbDrapeaux = 0;

        ajouteMinesAlea();
        System.out.println("Mines ajoutées !");
        calculeAdjacence();
        System.out.println("Proximités des mines calculées!");
    }

    private void ajouteMinesAlea() {
        int x, y;
        Random rand = new Random();

        for(int i = 0; i < nbMines; i ++) {
            do {
                x = rand.nextInt(hauteur);
                y = rand.nextInt(largeur);
            } while (isMine(x, y));

            this.mines[x][y] = true;
        }
    }

    private void calculeAdjacence() {
        for(int i = 0; i < hauteur; i ++) {
            for(int j = 0; j < largeur; j ++) {

                if(!isMine(i, j))
                    adja[i][j] = calculeAdjacenceLocale(i, j);
            }
        }
    }

    private int calculeAdjacenceLocale(int x, int y) {
        int out = 0;

        for(int i = x - 1; i <= x + 1; i ++) {
            for(int j = y - 1; j <= y + 1; j ++) {
                if(!(i == x && j == y) && isMine(i, j))
                    out ++;
            }
        }

        return out;
    }

    public boolean isMine(int x, int y) {
        if(!isCase(x, y))
            return false;

        return this.mines[x][y];
    }

    private void revelerCase(int x, int y) {
        if(!isCase(x, y)) 
            return;
        this.etats[x][y] = 1;

        System.out.println("Adja : " + this.adja[x][y]);

        if(!(this.adja[x][y] == 0))
            return;

        for(int i = x - 1; i <= x + 1; i ++) {
            for(int j = y - 1; j <= y + 1; j ++) {
                if(isCase(x, y))
                    System.out.println(i + ", " + j + " : adj " + this.adja[i][j]);
                if(!(i == x && j == y))
                    revelerCase(i, j);
            }
        }
    }

    public void affichage() {
        System.out.println("******************\n* Mines/Drapeaux *");
        System.out.println("*  " + afficherInt(nbMines) + " /   " + afficherInt(nbDrapeaux) + "   *");
        System.out.println("******************");

        String ligne = new String(" ");

        for(int i = 0; i < largeur; i ++)
            ligne += " " + Integer.toString(i);
        System.out.println(ligne);

        for(int i = 0; i < hauteur; i ++) {
            ligne = charFromAscii(i) + "";
            for(int j = 0; j < largeur; j ++) {
                switch(etats[i][j]) {
                    case 0 :
                        ligne += " .";
                        break;
                    case 1 :
                        if(mines[i][j] == true) {
                            ligne += " *";
                            break;
                        }
                        ligne += " " + Integer.toString(this.adja[i][j]);
                        break;
                    case 2 :
                        ligne += " ?";
                        break;
                    default :
                        System.out.println("\n\nErreur: case (" + Integer.toString(i) + "," + Integer.toString(j) + "), etat non valide.");
                }
            }
            System.out.println(ligne);
        }
    }

    private char charFromAscii(int x) {
        if(x < 0 || x > 90) System.out.println("x > 26 (ou x < 0), la lettre n'est pas valide");
        return (char)(x + 65);
    }

    private String afficherInt(int x) {
        return x > 99 ? Integer.toString(x) : " " + (x > 9 ? Integer.toString(x) : " " + Integer.toString(x));
    }

    public boolean isValidAction(int i) {
        if(i < 0 || i > 1) return false;
        return true;
    }

    public boolean agir(int x, int y, int action) {
        if(!isValidAction(action) || !isCase(x, y) || isRevealed(x, y)) {
            System.out.println("Case ou Action invalide.");
            return false;
        }

        switch(action) {
            // Poser|Enlever drapeau.
            case 2 : return setFlag(x, y);

            // Reveler case
            case 1 : return reveal(x, y);
            
            default : return false;
        }
    }

    public boolean isCase(int x, int y) {
        return !(x < 0 || x >= hauteur || y < 0 || y >= largeur);
    }

    public boolean jeuFini() {
        if(anyMineExploded())
            return true;
        if(nbDrapeaux == nbMines)
            return flagsValidity();
        return false;
    }

    public boolean jeuGagne() {
        return anyMineExploded() ? false : true;
    }

    private boolean anyMineExploded() {
        for(int i = 0; i < hauteur; i ++) {
            for(int j = 0; i < largeur; i ++) {
                if(isRevealed(i, j) && isMine(i, j)) return true;
            }
        }
        return false;
    }

    private boolean flagsValidity() {
        for(int i = 0; i < hauteur; i ++) {
            for(int j = 0; i < largeur; i ++) {
                if(isFlagged(i, j) && !isMine(i, j)) return false;
            }
        }
        return true;
    }

    public boolean isRevealed(int x, int y) {
        if(!isCase(x, y)) return false;
        if(this.etats[x][y] == 1) return true;
        return false;
    }

    public boolean isFlagged(int x, int y) {
        if(!isCase(x, y) || this.etats[x][y] != 2) return false;
        return true;
    }

    private boolean setFlag(int x, int y) {
        if(!isCase(x, y) || isRevealed(x, y)) return false;
        this.etats[x][y] = this.etats[x][y] == 2 ? 0 : 2;
        this.nbDrapeaux += this.etats[x][y] == 2 ? -1 : 1;
        return true;
    }

    private boolean reveal(int x, int y) {
        if(!isCase(x, y) || isFlagged(x, y) || isRevealed(x,y)) return false;
        this.etats[x][y] = 1;
        return true;
    }
}
