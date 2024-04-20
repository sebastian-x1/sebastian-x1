package farkle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The Farkle class contains the entry point of the program and the game loop. The game
 * is configured from the given inputs and then the main loop is entered. This webpage
 * describes the logic behind Farkle: {@link http://farkle.games/official-rules/}.
 */
public class Farkle {
	public static final int MIN_PLAYERS = 2;
	public static final int DICE_COUNT = 6;
	
	private GameConfig config;
	private Player[] players;
	private int playerIndex = 0;
	private Die[] dice = new Die[6];
	private void aiMakeDecision(Player aiPlayer) {
        StrategyMode strategy = aiPlayer.getStrategy();
        if (strategy.isConservative()) {
            // Conservative mode: AI plays it safe.
            // Implement logic to decide when to stop rolling and bank points.
        } else {
            // Aggressive mode: AI takes more risks.
            // Implement logic to decide when to continue rolling and when to stop.
        }
    }
	/**
	 * Prompt for a list of names based on the number of players {@code numPlayers}.
	 * 
	 * @param scanner The Scanner assigned to the standard input stream.
	 * @param numPlayers The number of players.
	 * @return A list of player names.
	 */
	private void promptPlayers(Scanner scanner, int numPlayers) {
		players = new Player[numPlayers];

		for (int i = 0; i < numPlayers; i++) {
			System.out.printf("Please enter the name of player %d: ", (i + 1));
			
			String playerName;
			// Prompt until a valid response (more than just whitespace characters) is given
			do {
				playerName = scanner.nextLine();
			} while (playerName.isBlank());

			// Prompt to determine if the current player should be human or a CPU
			System.out.print("Is this player a human? (y/n): ");
			
			boolean isHuman = promptAnswer(scanner.next().charAt(0));
			if (isHuman)
				players[i] = new HumanPlayer(playerName);
			else {
				// Prompt to determine the difficulty of the CPU player
				System.out.print("Should this CPU play at easy or hard difficulty? (e/h): ");
				char difficultyAnswer = scanner.next().charAt(0);
				
				ComputerDifficulty difficulty;
				switch (difficultyAnswer) {
				case 'e':
				case 'E':
					difficulty = ComputerDifficulty.EASY;
					break;
				case 'h':
				case 'H':
					difficulty = ComputerDifficulty.HARD;
					break;
				default:
					difficulty = ComputerDifficulty.EASY;
				}
				
				players[i] = new ComputerPlayer(playerName, difficulty);
			}
			System.out.println();
		}
		
	}
	
	public class StrategyMode {
	    private ComputerDifficulty difficulty;
	    private boolean isConservative;

	    public StrategyMode(ComputerDifficulty difficulty) {
	        this.difficulty = difficulty;
	        this.isConservative = (difficulty == ComputerDifficulty.HARD);
	    }

	    public boolean isConservative() {
	        return isConservative;
	    }

	    public void setConservative(boolean value) {
	        isConservative = value;
	    }
	}

	/**
	 * Yes or no prompt helper.
	 * @param input
	 * @return True if the given input is Y or y.
	 */
	private static boolean promptAnswer(char input) {
		return (input == 'Y' || input == 'y');
	}
	/**
	 * Prompt for game starting information.
	 */
	public void prepareGame() {
		
		//initialize die in dice[] array
		for (int i = 0; i < dice.length; i++)
			dice[i] = new Die();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Let's play Farkle!");
		System.out.println();
		
		//System.out.print("Do you want to use 7-sided dice (y/n): ");
		//boolean useWildSideDice = promptAnswer(scanner.next().charAt(0));
		boolean useWildSideDice = false;
		//System.out.println();
		
		// Prompt until there are at least 2 players given
		int numPlayers = 0;
		do {
			System.out.print("Please enter the number of players (at least 2): ");
			numPlayers = scanner.nextInt();
		} while (!(numPlayers >= MIN_PLAYERS));
		
		System.out.println();
		// Create each player from user input
		promptPlayers(scanner, numPlayers);

		System.out.println();

		config = new GameConfig(numPlayers, 10_000, useWildSideDice);
	}
	
	private void playRound() {
		// TODO: Implement.
	}
	
	private boolean isOver() {
		// TODO: Implement.
		return true;
	}
	/**
	 * Start the game and enter the main loop.
	 */
	public void beginGame() {
		System.out.println("We're ready to play!\n");
		// TODO: Enter the game's main loop.
		Scanner input = new Scanner(System.in);
		/*
		 * TODO: Implement game's main loop. Below is a description of the possible flow:
		 * 1. Start at the current player in the queue.
		 * 2. Present a menu of actions which the player can perform.
		 * 3. HumanPlayer: Read a given action from standard input.
		 *    ComputerPlayer: If the player is non-player (aka ComputerPlayer), then decisions should be made
		 *    based on the current status of the game and its current score.
		 * 4. Process the action and perform game logic.
		 * 5. If six dies were used by the player to score, then give the current player another turn.
		 *    This extra turn can be repeated continually.
		 * 6. Check to see if the results of the action have resulted in a game win.
		 *    If so, display overall scores for each player and prompt to begin another game.
		 * 7. When it is appropriate, continue on to the next player in the queue.
		 *    After the last player's turn, start over at the first player.
		 */
		boolean running = true;
		while (running) {
			Player currentPlayer = players[playerIndex];
			
			System.out.println(currentPlayer.getName() + ", it's your turn!");
			
			//if player is a human...
			if(currentPlayer.isHuman() == true) {
				System.out.println();
				System.out.printf("Current score: %d\n", currentPlayer.getScore());
				System.out.print("Current dice: ");
				//for (var die : testDice) {
				//	System.out.printf("%d ", die.getLastRoll());
				//}
				System.out.print("\n\n");
			
				System.out.println("""
						Options:
						1. Roll all the dice
						2. Keep specific dice (e.g., "3 6 2")
						3. Bank points and end turn
						4. Display scores
						5. Quit game
						""");
			}
				
			//if player is a computer...
			if (currentPlayer.isHuman() == false) {
				//if (currentPlayer.getDifficulty == ComputerDiffculty.EASY) {
				int AIChoice = 1;
				
				//keep rolling until points > 250
				//do {
					//if (score > 250)
						AIChoice = 2;
				switch (AIChoice) {
				case 1:
					System.out.println("\n" + currentPlayer.name + " rolled-");
					for (int i = 0; i < dice.length; i++) {
						System.out.print(dice[i].roll() + " ");
					}
					
					break;
				case 2:
					System.out.println("\n" + currentPlayer.name + " earned " + 
							ScoringRules.calculateScore(dice) + " points!");
				}
					//} while (AIChoice == 1);

				// TODO: add switch-case statements to print according to what
				// 			computer does and add print statements saying things like:
				//			[name] rolled-, [name] rolled-, [name] earned x points!
				
				System.out.print("\n\n");
				playerIndex = (playerIndex + 1) % players.length;
				continue;
			}
			/**
			 * TODO: get ability to count the total score of a player for just the current turn
			 * get ability to get the difficulty of the computer player
			 */
			

			// NOTE: A ComputerPlayer will not be shown a menu, instead the choice it made during its turn will be displayed.
			int choice = 0;
			// Prompt until a valid choice is received
			do {
				System.out.print("Enter your choice: ");
				choice = input.nextInt();
			} while (!(choice >= 1 && choice <= 5));
			
			switch (choice) {
			case 1: // Roll all the dice
				System.out.println("You rolled- ");
				for (int i = 0; i < dice.length; i++) {
					System.out.print(dice[i].roll() + " ");
				}
				System.out.print("\n\n");
				//System.out.println("You scored " + ScoringRules.calculateScore(dice) + " points!");
				//System.out.print("\n\n");
				
				break;
			case 2: // Keep specific dice
				// TODO: Check for Farkle
				
				break;
			case 3: // Bank points and end turn
				playerIndex = (playerIndex + 1) % players.length;
				
				break;
			case 4: // Display scores
				System.out.println();
				GameTracker.getInstance().displayScore(System.out);
				System.out.println();
				break;
			case 5: // Quit game
				running = false;
				break;
			}
		}
		System.out.println("\nThanks for playing!\n");
		// TODO: Display final results of game.
		System.out.println("Final Scores:");
		System.out.println();
		GameTracker.getInstance().displayScore(System.out);
		System.out.println();
	}
	
	public static void main(String[] args) {
		// Temporary dice scoring testing code:
		Die[] testDice = new Die[6];
		// Construct the die objects
		for (int i = 0; i < testDice.length; i++) {
			testDice[i] = new Die();
		}
		
		testDice[0].setLastRoll(1);
		testDice[1].setLastRoll(5);
		testDice[2].setLastRoll(5);
		testDice[3].setLastRoll(1);
		testDice[4].setLastRoll(5);
		testDice[5].setLastRoll(5);
		System.out.println("Test score: " + ScoringRules.calculateScore(testDice));
		
		//System.exit(0);
		
		Farkle farkle = new Farkle();
		
		farkle.prepareGame();
		farkle.beginGame();
	}
}
