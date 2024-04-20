package farkle;

/**
 * The abstract {@code Player} class represents the operations and data required by both
 * the {@code HumanPlayer} and {@code ComputerPlayer}.
 */
public abstract class Player {
	public static final int INITIAL_SCORE = 0;
	
	protected String name;
	protected int score;
	protected int farkleCount;
	protected boolean playing;
	protected DiceSet dice;
	// TODO: Each player needs to hold an array of 6 dies.
	
	protected Player(String name) {
		this.name = name;
		this.score = INITIAL_SCORE;
		this.farkleCount = 0;
		this.playing = true;
		this.dice = new DiceSet();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	/**
	 * @return The number of consecutive Farkles.
	 */
	public int getFarkleCount() {
		return this.farkleCount;
	}
	/**
	 * @return False if the player has won and is no longer playing, true otherwise.
	 */
	public boolean isPlaying() {
		return this.playing;
	}
	
	public void resetFarkleCount() {
		this.farkleCount = 0;
	}
	
	@Override
	public String toString() {
		String playerType = isHuman() ? "Human" : "Computer";
		return String.format("%s %s has score: %d", playerType, name, score);
	}
	// Abstract operations:
	/**
	 * @return True if the Player instance is a human.
	 */
	public abstract boolean isHuman();
	/**
	 * 
	 * @param dice
	 * @return
	 */
	public abstract Die[] selectDiceToKeep(Die[] dice);
	/**
	 * Implements step 3 of the instructions which states:
	 * A hint that tells the person the odds of a Farkle given how many dice are left to roll.
	 * This is relevant for providing a hint to human players or aggressive AI opponents.
	 * 
	 * @return True if the player should roll again.
	 */
	public abstract boolean shouldRollAgain();
	/**
	 * Determines how points will be added to the player's score.
	 * @param points
	 */
	public abstract void addScore(int points);
	/**
	 * handleTurn() method handles turn logic for players
	 */
	public abstract void handleTurn();
}
