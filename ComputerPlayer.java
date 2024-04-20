package farkle;

public class ComputerPlayer extends Player {
	/**
	 * 
	 */
	private ComputerDifficulty difficulty;
	/**
	 * Create a new {@code ComputerPlayer}.
	 * @param name The name of the player.
	 * @param difficulty The difficulty level.
	 */
	public ComputerPlayer(String name, ComputerDifficulty difficulty) {
		super(name);
		
		this.difficulty = difficulty;
	}
	
	public ComputerDifficulty getDifficulty() {
		return this.difficulty;
	}

	@Override
	public boolean isHuman() {
		return false;
	}

	@Override
	public Die[] selectDiceToKeep(Die[] dice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean shouldRollAgain() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addScore(int points) {
		super.score += points;
	}
	
	//handle turn logic
	@Override
	public void handleTurn() {
		/* TODO: use if statements to determine
		 * what the AI should do depending on if it is easy or hard.
		 * 
		 * If it's EASY difficulty:
		 * 	keep rolling until points is greater than 250. Then stop.
		 * 
		 * If it's HARD difficulty:
		 * 	if difference in score is large between player in first place and this AI, roll until points are
		 * 	sufficiently high (don't know when that would be).
		 * 
		 * 	if AI is close in score to the player in first, roll more conservatively (maybe until points are
		 * 	above ~500 to 750 if AI is not in first, and roll until points are ~250 if AI is in first && its lead is big).
		 * 
		 * Could make it so that HARD AI has a random chance of keeping points past the 'if' statement
		 * conditions, though, so that the AI has a chance to take a lead, and it doesn't robotically
		 * take points
		 */
	}
}
