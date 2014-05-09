package gameplay;

public class GameRoom {
	private Player playerOne;
	private Player playerTwo;
	private QuestionGenerator qGenerator;
	private int playersNumber;
	
	public GameRoom() {
		playerOne = null;
		playerTwo = null;
		qGenerator = QuestionGenerator.getInstance();
		playersNumber = 0;
	}
	
	public boolean addPlayer(Player player) {
		if (playerOne == null && player != null) {
			playerOne = player;
			playersNumber++;
			return true;
		} else if (playerTwo == null && player != null) {
			playerTwo = player;
			playersNumber++;
			return true;
		}
		
		return false;
	}
	
	public boolean isFull() {
		if (playersNumber == 2)
			return true;
		return false;
	}
	
	public void startGame() {
		//TODO
	}
}
