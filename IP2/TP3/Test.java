class Test {
  public static void main(String[] args) {
    Utilisateur u1 = new Utilisateur("firagty", "monmdp", "firgaty@gmail.com");
    System.out.println(u1.getPseudonyme());
    u1.setPseudonyme("firgaty2");
    System.out.println(u1.getPseudonyme());

    Utilisateur u2 = new Utilisateur("Franck", "monmdp", "monmail@mail.com");
    Utilisateur u3 = new Utilisateur("Franck2", "monmdp", "monmail@mail.com");
    Utilisateur u4 = new Utilisateur("Franck3", "monmdp", "monmail@mail.com");
    Utilisateur u5 = new Utilisateur("Franck4", "monmdp", "monmail@mail.com");
    Utilisateur u6 = new Utilisateur("Franck5", "monmdp", "monmail@mail.com");
    Utilisateur u7 = new Utilisateur("Franck6", "monmdp", "monmail@mail.com");

    Message m1 = new Message(u1, "Mon contenu");
    Message m2 = new Message(u1, "Mon contenu");
    Message m3 = new Message(u1, "Mon contenu");
    Message m4 = new Message(u2, "Mon contenu");
    Message m5 = new Message(u2, "Mon contenu");
    Message m6 = new Message(u4, "Mon contenu");
    Message m7 = new Message(u5, "Mon contenu");
    Message m8 = new Message(u6, "Mon contenu");
    Message m9 = new Message(u3, "Mon contenu");

    Salon s1 = new Salon();
    Salon s2 = new Salon();

    s1.ajouterUtilisateur(u1);
    s1.ajouterUtilisateur(u2);
    s1.ajouterUtilisateur(u3);
    s1.ajouterUtilisateur(u4);
    s1.ajouterUtilisateur(u5);
    s2.ajouterUtilisateur(u1);
    s2.ajouterUtilisateur(u3);
    s2.ajouterUtilisateur(u2);
    s2.ajouterUtilisateur(u4);
    s2.ajouterUtilisateur(u7);
    s2.ajouterUtilisateur(u6);

    s1.ajouterMessage(m1);
    s1.ajouterMessage(m2);
    s1.ajouterMessage(m3);
    s1.ajouterMessage(m4);
    s1.ajouterMessage(m5);
    s1.ajouterMessage(m6);
    s1.ajouterMessage(m8);
    s1.ajouterMessage(m9);
    s2.ajouterMessage(m1);
    s2.ajouterMessage(m9);


    Chat c1 = new Chat();
    c1.ajouterSalon(s1);
    c1.ajouterSalon(s2);

    s1.afficher();
    System.out.println("---------------------------------");
    s2.afficher();

    System.out.println(c1.nombreMessages(u1));
    System.out.println(c1.contributeur().getPseudonyme());
  }
}
