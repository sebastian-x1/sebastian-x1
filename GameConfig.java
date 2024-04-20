package farkle;

/**
 * The {@code GameConfig} record stores information that is used when starting the game.
 * 
 * Note: A record is basically a class with only immutable public attributes.
 */
public record GameConfig(
		int numPlayers,
		int targetScore,
		boolean useWildSideDice) {
}
