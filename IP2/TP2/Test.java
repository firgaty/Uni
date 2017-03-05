class Test {
  public static void main ( String [] args ){
  /* A COMPLETER */

  /*
  Ex.3)
    le mot clé "static" permet d'appeler une fonction sans avoir besoin d'instancier la classe dans une variable.Les variables ou méthodes declarées "static" sont alors commune entre toutes les instances d'une même classe.
    Le mot clé "final" sert à déclarer une variable ou une méthode comme constante, ne pouvant être redéfinie ou modifiée.
  */
  Etudiant e1 = new Etudiant("Luke", "Skywalker", 8.25);
  Etudiant e2 = new Etudiant("Leia", "Organa", 11.75);
  Etudiant e3 = new Etudiant("Felix", "Desmaretz", 14.25);

  System.out.println("nb d’etudiants : " + Etudiant.nombreDEtudiants);
  // nb d’etudiants : 2
  System.out.println("somme des notes : " + Etudiant.sommeDesNotes);
  // somme des notes : 20

  e1.afficher();
  e2.afficher();

  e2.modifierNote(19.5);
  e2.afficher();

  System.out.println("Moyenne : " + Etudiant.moyenne());


  // EXERCICE 2
  Trio unTrio = new Trio(e1, e2, e3);

  unTrio.premier().afficher();
  // Leia Organa 19.5

  System.out.println("Leia : " + unTrio.classement("Leia", "Organa") + "\nLuke : " + unTrio.classement("Luke", "Skywalker") + "\nFelix : " + unTrio.classement("Felix", "Desmaretz") + "\nAutre : " + unTrio.classement("un", "autre"));
  /*
    Leia : 1
    Luke : 3
    Felix : 2
    Autre : 0
  */

  Etudiant e4 = new Etudiant("Etudiant", "Autre", 2.25);

  System.out.println("Moyenne : " + unTrio.moyenne());
  if(unTrio.meilleurQueLaMoyenne()) {
    System.out.println("meilleurQueLaMoyenne");
  } else {
    System.out.println("pas meilleurQueLaMoyenne");
  }

  }
}
