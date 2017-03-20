import java.util.Scanner;

class Editeur {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Texte texte = new Texte();

    while(true) {
      System.out.print("\033[H\033[2J"); // Sur Windows, cette ligne ne fonctionne pas, il faut la commenter.
      System.out.flush();
      texte.afficher();
      String input = scanner.nextLine();
      switch(input) {
        case "!q" : return;
        case "!8" : {
          texte.reculerCurseur();
          break;
        }
        case "!2" : {
          texte.avancerCurseur();
          break;
        }
        case "!o" : {
          texte.ajouterLigne();
          break;
        }
        case "!dd" : {
          texte.supprimer();
          break;
        }
        case "!c" : {
          texte.copier();
          break;
        }
        case "!v" : {
          texte.coller();
          break;
        }
        case "!x" : {
          texte.couper();
          break;
        }
        default: {
          texte.ecrire(input);
          break;
        }
      }
    }
  }
}
