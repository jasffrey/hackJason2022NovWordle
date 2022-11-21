package wordle;

import java.util.ArrayList;

public class WordleGrader {

	// instance variables

	/**
	 * Number of successfully solved games
	 */
	private int numSolves = 0;

	/**
	 * Average number of rounds per game (unsolved games are 5 each)
	 */
	private double avgRounds;

	// setters and getters

	/**
	 * @return the numSolves
	 */
	public int getNumSolves() {
		return numSolves;
	}

	/**
	 * @return the avgRounds
	 */
	public double getAvgRounds() {
		return avgRounds;
	}

	// methods

	public void findNumSolves(ArrayList<WordleWord> wordleInfo) {

		for (WordleWord game : wordleInfo) {

			if (game.isSolved()) {
				numSolves += 1;
			}
		}

		return;
	}

	public void findAvgRounds(ArrayList<WordleWord> wordleInfo) {

		int gameCount = 0;

		for (WordleWord game : wordleInfo) {
			
			avgRounds += game.getRoundCount();
			gameCount += 1;
		}

		try {
			
			avgRounds = avgRounds / gameCount;

		} catch (ArithmeticException e) {
			
			System.out.println("Divided by zero operation cannot be possible");
		}

		return;
	}

}
