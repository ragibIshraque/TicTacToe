package tic;

public class Intelegence {
	Game gameInfo;

	public Intelegence(Game gaemInfoGame) {
		super();
		this.gameInfo = gaemInfoGame;
	}

	public Intelegence() {
	}

	int max(int a, int b) {
		return a > b ? a : b;
	}

	int min(int a, int b) {
		return a < b ? a : b;
	}

	boolean noMove() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (TicTacToeMain.board[i][j].equals(" - ")) {
					return true;
				}
			}
		}
		return false;
	}

	public int winloss() {

		for (int i = 0; i < 3; i++) {
			if (TicTacToeMain.board[i][0] != " - " && TicTacToeMain.board[i][0].equals(TicTacToeMain.board[i][1])
					&& TicTacToeMain.board[i][2].equals(TicTacToeMain.board[i][1])) {
				if (TicTacToeMain.board[i][0].equals(gameInfo.couputerTurn))
					return 10;
				else if (TicTacToeMain.board[i][0].equals(gameInfo.playerTurn))
					return -10;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (!TicTacToeMain.board[0][i].equals(" - ") && TicTacToeMain.board[0][i].equals(TicTacToeMain.board[1][i])
					&& TicTacToeMain.board[2][i].equals(TicTacToeMain.board[1][i])) {
				if (TicTacToeMain.board[0][i].equals(gameInfo.couputerTurn))
					return 10;
				else if (TicTacToeMain.board[0][i].equals(gameInfo.playerTurn))
					return -10;
			}
		}

		if (!TicTacToeMain.board[0][0].equals(" - ") && TicTacToeMain.board[0][0].equals(TicTacToeMain.board[1][1])
				&& TicTacToeMain.board[2][2].equals(TicTacToeMain.board[1][1])) {
			if (TicTacToeMain.board[0][0].equals(gameInfo.couputerTurn))
				return 10;
			else if (TicTacToeMain.board[0][0].equals(gameInfo.playerTurn))
				return -10;
		}

		if (!TicTacToeMain.board[0][2].equals(" - ") && TicTacToeMain.board[0][2].equals(TicTacToeMain.board[1][1])
				&& TicTacToeMain.board[2][0].equals(TicTacToeMain.board[1][1])) {
			if (TicTacToeMain.board[0][2].equals(gameInfo.couputerTurn))
				return 10;
			else if (TicTacToeMain.board[0][2].equals(gameInfo.playerTurn))
				return -10;
		}
		return 0;
	}

	public int minMax(boolean turn) {
		int result = winloss();

		if (result == 10)
			return 10;

		if (result == -10)
			return -10;
		if (noMove() == false)
			return 0;
		if (turn) {
			int res = -1000;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (TicTacToeMain.board[i][j].equals(" - ")) {
						TicTacToeMain.board[i][j] = gameInfo.couputerTurn;
						res = max(res, minMax(!turn));
						TicTacToeMain.board[i][j] = " - ";
					}
				}
			}
			return res;
		} else {

			int res = 1000;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (TicTacToeMain.board[i][j].equals(" - ")) {
						TicTacToeMain.board[i][j] = gameInfo.playerTurn;
						res = min(res, minMax(!turn));
						TicTacToeMain.board[i][j] = " - ";
					}
				}
			}
			return res;
		}

	}

}
