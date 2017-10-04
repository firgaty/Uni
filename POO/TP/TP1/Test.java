import java.util.Scanner;

class Test {
	public static char[] tLowerVoyels = {'a', 'e', 'i', 'o', 'u', 'y', 'a'};
	public static char[] tUpperVoyels = {'A', 'E', 'I', 'O', 'U', 'Y', 'A'};

	public static void main(String[] args) {
		String s = new String();

		for(int i = 0; i < args.length; i++) {
			s += args[i] + " ";
		}
		
		System.out.println(changeVoyels(s));

		// System.out.println("Tentatives :" + question());
		// System.out.println("Note " + evaluation(3));

		int[] t1 = {1,5,17,3,18,9};
		int[] t2 = {5,7,3,6,9,3,6,4};
		printTabl(tablOperation(t1, t2));
	}

	public static String changeVoyels(String s) {
		
		String out = new String();

		for(int i = 0; i < s.length(); i++) {
			out += replaceIfMatch(s.charAt(i));
		}

		return out;
	}

	public static char replaceIfMatch(char in) {
		for(int i = tLowerVoyels.length - 2; i >= 0 ; i--) {
			if(in == tLowerVoyels[i])
				return tLowerVoyels[i+1];
			if(in == tUpperVoyels[i])
				return tUpperVoyels[i+1];
		}
		return in;
	}

	public static int question() {
		int n1 = (int)(Math.random() * 9) + 1;
		int n2 = (int)(Math.random() * 9) + 1;

		System.out.println("Multipliez " + n1 + " par " + n2);

		int input = -1;
		int count = 0;

		while(input != n1*n2) {
			boolean ok = false;
			count ++;

			while(!ok) {
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();
			ok = input != -1 ? true : false;

			}

			if (input == n1*n2) {
				System.out.println("Bravo!");
				return count;
			} else {
				System.out.println("Euuuuhm... Non.\n\nRetentez, multipliez " + n1 + " par " + n2);
				input = -1;
				ok = false;
			}
		}
		return 0;
	}

	public static int evaluation(int n) {
		int note = 20;
		int resultat = 0;

		for(int i = 0; i < n; i++) {
			note -= (question() - 1);
		}

		return note;
	}

	public static int[] tablOperation (int[] t1, int [] t2) {
		int[] greatest = t1.length >= t2.length ? t1 : t2;
		int minSize = t1.length >= t2.length ? t2.length : t1.length;
		int maxSize = t1.length >= t2.length ? t1.length : t2.length;

		System.out.println(minSize);
		System.out.println(maxSize);

		int[] inter = new int[maxSize + 1];
		inter[maxSize] = -1;


		// Premiere etape.
		for(int i = 0; i < minSize; i ++) {
			inter[i] = t1[i] * t2[i];
		}
		for(int i = minSize; i < maxSize; i ++) {
			inter[i] = greatest[i];
		}

		printTabl(inter);

		// Deuxieme etape.
		int[] out = new int[1000];
		for(int i = 0; i < 1000; i ++) {
			out[i] = -1;
		}

		int index = 0;

		int count = 0;
		int[] t = new int[100];


		for(int i = 0; i < maxSize; i ++) {
			if(inter[i] < 10 && inter[i] >= 0) {
				out[index] = inter[i];
				index += 1;
			} else {
				t = new int[100];
				count = 0;

				while(inter[i] > 0) {
					if(inter[i] ==  0)// LA  !!!
						inter[i] = 0;
					else {
						t[count] = inter[i] % 10;
						inter[i] = inter[i] / 10;
						System.out.println(t[count]);
						count++;
					}
				}

				System.out.println(count);
				for(int j = count - 1; j >= 0; j --) {
					out[index] = t[j];
					index += 1;

				}
			}
		}

		return out;

	}

	public static void printTabl(int[] t) {
		String out = new String("{ ");

		int i = 0;
		while(t[i] > -1) {
			out += String.valueOf(t[i]) + ", ";
			i++;
		}

		out += "}";
		System.out.println(out);

	}
}