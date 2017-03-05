import java.util.ArrayList;

class Test {
public static int secret (int n, int p) {
        if (n <= 0)
                return p;
        if (p <= 0)
                return n;
        System.out.println("n : " + n + " | p : " + p);
        return secret(n - 1, n + 1) +2;
}

public static void koi (int n) {
        if (n <= 10) {
                System.out.println(n);
                koi(n + 1);
        }
}

public static String binaire(int n) {
        if (n == 0)
                return "";
        return binaire(n/2) + String.valueOf(n%2);
}
public static void main(String[] args) {
        //System.out.println("Final :" + secret(5,7));
        //koi(5);
        //koi(15);
        //System.out.println(binaire(27));

        FileDAttente file = new FileDAttente();
        Client c1 = new Client("Dupont","Franck");
        Client c2 = new Client("Lovegood","Luna");
        Client c3 = new Client("Theserac","Emilie");
        Client c4 = new Client("Grosne","Carl");

        file.clients.add(c1);
        file.clients.add(c2);
        file.clients.add(c3);
        file.clients.add(c4);

        file.afficher();
      }
}
