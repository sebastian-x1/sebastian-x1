package farkle;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

/**
 * 
 */
public class GameTracker {
	private static GameTracker instance; // Singleton instance
	// TODO: Keep track of the number of wins.
	private record PlayerData(int score, int wins) {
	}
	
	private HashMap<String, Integer> scores; // Hash table of player names & their data
	
	private GameTracker() {
		this.scores = new HashMap<String, Integer>();
	}
	/**
	 * 
	 */
	public void reset() {
		scores.clear();
	}
	/**
	 * Increase 
	 * @param name
	 * @param addedScore
	 */
	public void updateScore(String name, int addedScore) {
		scores.compute(name, (key, value) -> (value == null) ? addedScore : value + addedScore);
	}
	/**
	 * Obtain the score at the key {@code name}.
	 * @param name The player name to obtain a score from.
	 * @return The score for that player.
	 */
	public int getScore(String name) {
		if (scores.containsKey(name)) {
			return scores.get(name).intValue();
		} else {
			throw new NoSuchElementException("Given name is not a current player!");
		}
	}
	/**
	 * Print a table of the current player scores to {@code stream}.
	 * @param stream The stream to print to.
	 */
	public void displayScore(PrintStream stream) {
		stream.printf("%-60s | %-6s\n", "Name", "Score");
		for (int i = 0; i < 70; i++) {
			stream.print('-');
		}
		stream.println();
		
		List<Map.Entry<String, Integer>> entries = new ArrayList<>(scores.entrySet());
		
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		for (var entry : entries)  {
			stream.printf("%-60s | %-6d\n", entry.getKey(), entry.getValue().intValue());
		}
	}
	/**
	 * Access singleton instance of {@code GameTracker}.
	 * @return Singleton instance of {@code GameTracker}.
	 */
	public synchronized static GameTracker getInstance() {
		if (instance == null) {
			instance = new GameTracker();
		}
		return instance;
	}
}
