import java.util.Scanner;

public class Joueur {
    private String nom;
    private Scanner scan;
    
    public Joueur(){
        //Par défaut, le nom du joueur est "Anonyme". Le constructeur initialise un scan qui pourra vous être utile.
        this.scan = new Scanner(System.in);
        this.nom = "Anonyme";
    }

    public void setNom() {
    	System.out.println("Entrez nouveau nom:");

    	this.nom = scan.next();
    }

    public String getNom() {
    	return this.nom;
    }

    public int nombreChoisi() {
    	System.out.println("Entrez un nombre : ");
    	while(!scan.hasNextInt()) {
    		scan.next();
    		System.out.println("Entrez un VRAI nombre (Entier qui plus est).");
    	}
    	return scan.nextInt();
    }

    public boolean ouiNon() {
    	do {
    		System.out.println("Oui/Non (o/n) :");

    		String in = scan.next();

    		switch(in) {
    			case "oui" 	: return true;
    			case "Oui"	: return true;
    			case "o" 	: return true;
    			case "O"	: return true;
    			case "non"	: return false;
    			case "Non"	: return false;
    			case "n" 	: return false;
    			case "N"	: return false;
    		}

    		System.out.println("Non valide... (u.u) Recommencez (et suivez les intructions).");
    	} while (true);
    }

    public int[] actionChoisie() {
    	int[] out = new int[3];
    	
    	doLoop:
    	do {
    		System.out.println("Choisisser une action (x y action) (int int int) :");
    		String in = scan.nextLine();
    		String[] nb = in.split(" ");

    		for(int i = 0; i < 3; i++) {
    			if(!isInteger(nb[i])) {
    				System.out.println("Veuille respecter le format, que des entiers.");
    				continue doLoop;
    			}
    			out[i] = Integer.parseInt(nb[i]);
    		}
    		break;
    	} while (true);

    	return out;
    }

    private boolean isInteger(String s) {
    	try {
    		Integer.parseInt(s);
    	} catch(NumberFormatException e) {
    		return false;
    	} catch(NullPointerException e) {
    		return false;
    	}
    	return true;
    }
}
