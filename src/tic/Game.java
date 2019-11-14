package tic;

public class Game {
	String couputerTurn;
	String playerTurn;
	boolean message;
	public Game(String couputerTurn, String playerTurn,boolean message) {
		super();
		this.couputerTurn = couputerTurn;
		this.playerTurn = playerTurn;
		this.message = message;
	}
	public boolean isMessage() {
		return message;
	}
	public void setMessage(boolean message) {
		this.message = message;
	}
	public Game() {
		super();
	}
	public String getCouputerTurn() {
		return couputerTurn;
	}
	public void setCouputerTurn(String couputerTurn) {
		this.couputerTurn = couputerTurn;
	}
	public String getPlayerTurn() {
		return playerTurn;
	}
	public void setPlayerTurn(String playerTurn) {
		this.playerTurn = playerTurn;
	}
	
}
