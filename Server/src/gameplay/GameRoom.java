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
		setPlayerOne(null);
		setPlayerTwo(null);
		qGenerator = QuestionGenerator.getInstance();
		playersNumber = 0;
		setQuestionNumber(0);
		roomQuestions = new ArrayList<Question>(getNumberOfQuestions());
	}
	
	public boolean addPlayer(Player player) {
		if (getPlayerOne() == null && player != null) {
			setPlayerOne(player);
			playersNumber++;
			return true;
		} else if (getPlayerTwo() == null && player != null) {
			setPlayerTwo(player);
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
		getPlayerOne().start();
		getPlayerTwo().start();
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
	
	public Question getCurrentQuestion() {
		System.out.println("Get question number " + (questionNumber % 2));
		return roomQuestions.get(questionNumber % 2); //modulo 2 because both players increment the questionNumber
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}
}
