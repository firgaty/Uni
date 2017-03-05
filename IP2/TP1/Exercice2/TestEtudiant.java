public class TestEtudiant {
  public static void main(String[] args) {
    Etudiant etu = new Etudiant("DuPeret", "Jean", 25002427, 13);
    Etudiant.afficher(etu);
    System.out.println(mention(etu));
  }

  public static boolean estAdmis(Etudiant etu) {
    if (etu.note >= 10) {
      return true;
    } else {
      return false;
    }
  }

  public static String mention(Etudiant etu) {
    if (estAdmis(etu)) {
      if (etu.note >= 16) {
        return "Très bien";
      } else if (etu.note >= 14) {
        return "Bien";
      } else if (etu.note >= 12) {
        return "Passable";
      } else if (etu.note >= 10) {
        return "Passable";
      }
    } else {
      return "Note invalide";
    }
    return "";
  }
}
