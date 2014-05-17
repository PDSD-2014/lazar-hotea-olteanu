package gameplay;

public class Score {
	private String id;	//each player is identified by an id which is the user name of the player
	private long points;
	
	public Score(String id) {
		this.setId(id);
		setPoints(0);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}
	
	public void resetScore() {
		this.points = 0;
	}
	
	public void addScore(long value) {
		this.points += value;
	}
	
	public void decScore(long value) {
		this.points -= value;
	}
}
