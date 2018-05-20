package tyntec.com.rock.paper.scissors.game.model;

/**
 * @author Samuel.Idaewor
 *
 */
public class Player {

	private int wins;
	private int ties;
	private String name;
	private Choice choice;
	
	/*
	 * This constructor ensures that name is provided when creating an instance of Player.
	 */
	public Player(String name) {
		super();
		setName(name);
	}
	
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}

	public String getName() {
		return name;
	}
	public Choice getChoice() {
		return choice;
	}
	public void setChoice(Choice choice) {
		this.choice = choice;
	}
	
	/*
	 * This method is private because the player name should only be set when creating a new player
	 * The method ensures that the player is assigned a name regardless of the user input.
	 */
	private void setName(String name) {
		if(name == null || name.isEmpty())
			name = String.valueOf(this.hashCode());
		this.name = name;
	}
	
}
