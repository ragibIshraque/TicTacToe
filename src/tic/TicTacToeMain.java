package tic;

import java.util.Scanner;

public class TicTacToeMain {

	public static String[][] board = new String[3][3];
	public Game game;
	public Position position;
	public Intelegence aI;

	void logPrint(String s) {
		System.out.println(s);
	}

	TicTacToeMain(Game g, Position p, Intelegence ai) {
		this.game = g;
		this.position = p;
		this.aI = ai;

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				board[i][j] = " - ";
			}
	}

	static void show() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}System.out.println("\n");
	}

	void playerTurn() {

		Scanner input = new Scanner(System.in);
		System.out.println(" Your turn ");

		int position;
		position = input.nextInt() - 1;

		if (position < 0 || position > 8) {
			System.out.println(" Illigal position Try again\n");
			show();
			playerTurn();
		} else {
			int x = position / 3;
			int y = position - (x * 3);
			if (board[x][y] == " - ")
				board[x][y] = game.playerTurn;
			else {
				System.out.println(" Illigal position Try again\n");
				playerTurn();
			}
		}

	}

	void ComputerAI() {

		int best = -1000;
		position.xPos = -1;
		position.yPos = -1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (TicTacToeMain.board[i][j].equals(" - ")) {
					TicTacToeMain.board[i][j] = game.couputerTurn;
					int localResult = aI.minMax(false);
                    TicTacToeMain.board[i][j] = " - ";
					if (localResult > best) {
						best = localResult;
						position.xPos = i;
						position.yPos = j;
					}
				}
			}
		}
		board[position.xPos][position.yPos] = " X ";
		// return 0;
	}

	public static Game playerSelect() {
		Double random = Math.random() * 1000;
		if (random % 2 == 0) {
			return new Game(" X ", " O ", true);
		}

		return new Game(" X ", " O ", true);
	}

	void instruction() {
		System.out.println(
				"1 2 3\n4 5 6\n7 8 9\nThis are position number.Type the number where you want to make your move");
	}

	void showInitialMessage() {
		if (game.message) {
			System.out.println("-----: You put O & computer puts X : ----");
			instruction();
		} else {
			System.out.println("-----: You put X & computer puts O : ----");
			instruction();
		}
	}

	public static void main(String[] args) {
		Game currGame = TicTacToeMain.playerSelect();
		Position aIPostiong = new Position();
		Intelegence cAI = new Intelegence(currGame);
		TicTacToeMain gameObject = new TicTacToeMain(currGame, aIPostiong, cAI);
		gameObject.show();
		
		gameObject.showInitialMessage();
		for (int i = 0; i < 9; i++) {
			if (currGame.message) {
				gameObject.playerTurn();
				gameObject.show();
				int result = gameObject.aI.winloss();
				if (result == 10) {
					gameObject.logPrint(" Computer wins ");
					break;
				} else if (result == -10) {
					gameObject.logPrint(" You win ");
					break;
				}
				currGame.setMessage(!currGame.message);

			} else {
				gameObject.ComputerAI();
				try {
					System.out.println(" Computer is thinking ........\n");
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				gameObject.show();
				int result = gameObject.aI.winloss();
				if (result == 10) {
					gameObject.logPrint(" Computer wins ");
					break;
				} else if (result == -10) {
					gameObject.logPrint(" You win ");
					break;
				}
				currGame.setMessage(!currGame.message);
			}
		}
		
		System.out.println(" ---- : Match Draw :-----");

	}

}
