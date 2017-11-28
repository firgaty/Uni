import java.util.Random;
import java.util.Scanner;

class Game {
	static class Square {
		private int m_destination;

		public Square(int destination) {
			m_destination = destination;
		}

		public int destination() {
			return m_destination;
		}

		public void setDestination(int destination) {
			m_destination = destination;
		}
	}

	public class Player {
		private int m_id;
		private int m_squareId;

		public Player(int id) {
			m_id = id;
			m_squareId = 0;
			display();
		}

		public boolean playTurn() {
			Random rand = new Random();
			int move = rand.nextInt(6) + 1;

			System.out.println("Dice : " + move);

			m_squareId += move;

			if(m_squareId > m_board.length - 1) {
				m_squareId = 2 * m_board.length - 2 - m_squareId;
			}

			m_squareId = m_board[m_squareId].destination();

			return m_squareId == m_board.length - 1;
		}

		public void display() {
			System.out.println("Player " + (m_id + 1) + " : square " + (m_squareId + 1) + ".");
		}
	}

	Square[] m_board;
	Player[] m_players;

	public Game(int nbPlayers) {
		m_players = new Player[nbPlayers];

		for(int i = 0; i < nbPlayers; i ++) {
			m_players[i] = new Player(i);
		}

		m_board = new Square[100];

		for(int i = 0; i < 100; i ++)
			m_board[i] = new Square(i);

		m_board[3].setDestination(10);
		m_board[9].setDestination(68);
		m_board[69].setDestination(2);
		m_board[42].setDestination(54);
		m_board[98].setDestination(34);
		m_board[20].setDestination(87);
		m_board[78].setDestination(84);
		m_board[56].setDestination(32);
		m_board[67].setDestination(15);
		m_board[38].setDestination(29);

		boolean end = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("FIRST TO 100 !");

		while(!end) {
			for(Player p : m_players) {
				if(p.playTurn()) end = true;
				p.display();
			}

			System.out.println("Press 'Enter' key to continue.");
			sc.nextLine();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of players who want to play : ");
		new Game(scan.nextInt());
	}
}