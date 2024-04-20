package farkle;

import java.util.Arrays;
import java.util.HashMap;

public class ScoringRules {
	public static final int THREE_OF_A_KIND_SCORE_MULTIPLIER = 100;
	public static final int THREE_PAIRS_SCORE = 750;
	public static final int STRAIGHT_SCORE = 1_000;
	public static final int WINNING_SCORE = 10_000;
	/**
	 * Calculate the score of the current {@code DieSet}. A resulting score of zero
	 * indicates a Farkle.
	 * 
	 * @param dice The current dice which have been set aside by the player for scoring.
	 * @return Resulting score.
	 */
	public static int calculateScore(Die[] dice) {
		int score = 0;
		// 1 & 5 spot dice are the only dice that can be scored outside of a combination
		score += countOnes(dice) * 100;
		System.out.println("Score after (containsOne): " + score);
		
		score += countFives(dice) * 50;
		System.out.println("Score after (containsFive): " + score);
		// Combinations
		score += calculateThreeOfAKind(dice);
		System.out.println("Score after (calculateThreeOfAKind): " + score);
		score += calculateThreePairs(dice);
		System.out.println("Score after (calculateThreePairs): " + score);
		score += calculateStraight(dice);
		System.out.println("Score after (calculateStraight): " + score);
		
		return score;
	}
	/**
	 * @param dice
	 * @return True if {@code dice} contains a 1.
	 */
	private static long countOnes(Die[] dice) {
		return Arrays.stream(dice).filter(die -> die.getLastRoll() == 1).count();
	}
	/**
	 * @param dice
	 * @return True if {@code dice} contains a 5.
	 */
	private static long countFives(Die[] dice) {
		return Arrays.stream(dice).filter(die -> die.getLastRoll() == 5).count();
	}
	/**
	 * Three of a kind earn the face value times 100, e.g., 2, 2, 2 = 200 points.
	 * @param dice
	 * @return Resulting score.
	 */
	private static int calculateThreeOfAKind(Die[] dice) {
		int score = 0;
		// Iterate through each face value
		for (int value = 1; value <= 6; value++) {
			final int currentValue = value;
			// Get the number of die which match the current face value
			var filteredDice = Arrays.stream(dice).filter(die -> die.getLastRoll() == currentValue).toArray();
			long count = filteredDice.length;
			
			if (count >= 3) {
				// Three 1s are special and earn 1,000 points
				if (Arrays.stream(filteredDice).allMatch(die -> ((Die) die).getLastRoll() == 1))
					score += THREE_OF_A_KIND_SCORE_MULTIPLIER * 10;
				else
					score += currentValue * THREE_OF_A_KIND_SCORE_MULTIPLIER;
			}
		}
		return score;
	}

	private static int[] countDieValues(Die[] dice) {
		int[] counts = new int[6];
		for (var die : dice) {
			int lastRoll = die.getLastRoll();
			// Convert the last rolled value to an index and increment the count
			counts[lastRoll - 1]++;
		}
		return counts;
	}
	
	private static int calculateThreePairs(Die[] dice) {
		var counts = countDieValues(dice);
		// Filter out all elements which are not pairs and take the count
		long pairsCount = Arrays.stream(counts).filter(count -> count == 2).count();
		if (pairsCount == 3) {
			return THREE_PAIRS_SCORE;
		}
		return 0;
	}
	
	private static int calculateStraight(Die[] dice) {
		var counts = countDieValues(dice);
		// Filter out all elements and ensure that 
		if (Arrays.stream(counts).allMatch(count -> count == 1)) {
			return STRAIGHT_SCORE;
		}
		return 0;
	}
}
