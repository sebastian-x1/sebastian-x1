package farkle;

import java.util.Random;

/**
 * The Die class represents a physical die with a given number of sides.
 * 
 * It provides operations for rolling the die.
 */
public class Die {
	public static final int DEFAULT_SIDES = 6;
	
	private int numSides = DEFAULT_SIDES;
	private boolean hasWildSide = false;
	private int lastRoll = 1;
	
	public Die() { }
	
	public Die(boolean hasWildSide) {
		this.hasWildSide = hasWildSide;
	}
	
	public void setLastRoll(int lastRoll) {
		this.lastRoll = lastRoll;
	}
	
	public int roll() {
		Random random = new Random();
		return random.nextInt(1, (this.numSides + 1));
	}
	
	public int getNumSides() {
		return this.numSides;
	}
	
	public boolean hasWildSide() {
		return this.hasWildSide;
	}
	
	public int getLastRoll() {
		return this.lastRoll;
	}
}
