package farkle;

/**
 * The {@code HumanPlayer} class represents a physical player that will play the game.
 */
public class HumanPlayer extends Player {
	public HumanPlayer(String name) {
		super(name);
	}

	@Override
	public boolean isHuman() {
		return true;
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
		
	}
}
