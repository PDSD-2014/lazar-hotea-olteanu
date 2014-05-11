package gameplay;

import java.util.ArrayList;
import java.util.List;

public class GameRoom {
	private Player playerOne;
	private Player playerTwo;
	private QuestionGenerator qGenerator;
	private int playersNumber;
	private List<Question> roomQuestions; 
	private int numberOfQuestions = 10;
	private int questionNumber;
	private int roomId;
	
	public GameRoom(int roomId) {
		this.setRoomId(roomId);
		playerOne = null;
		playerTwo = null;
		qGenerator = QuestionGenerator.getInstance();
		playersNumber = 0;
		setQuestionNumber(0);
		roomQuestions = new ArrayList<Question>(getNumberOfQuestions());
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
		for (int i = 0; i < getNumberOfQuestions(); i++) {
			roomQuestions.add(qGenerator.generateQuestion());
		}
		playerOne.start();
		playerTwo.start();
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	
	public void incQuestionNumber() {
		this.questionNumber += 1;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
}
