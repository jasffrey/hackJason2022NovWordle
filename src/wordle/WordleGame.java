package wordle;

import java.util.*;

public class WordleGame {

	static void gamePlay(WordleWord wordleWord, Scanner scan) {

		while (!wordleWord.isGameOver() && wordleWord.getRoundCount() < 5) {

			System.out.println("Round " + (wordleWord.getRoundCount() + 1));
			System.out.println("Enter a word of 5 alphabetic characters.");

			// replace scanner with custom AI
			String inputWord = scan.nextLine().trim().toLowerCase();

			while (!(inputWord.length() == 5 && inputWord.matches("[a-zA-Z]+"))) {
				System.out.println("Invalid Input. Enter a word of 5 alphabetic characters.");
				
				// replace scanner with custom AI
				inputWord = scan.nextLine().trim().toLowerCase();
			}

			wordleWord.wordStatusUpdate(inputWord);

			System.out.println(wordleWord.getStatusWord());
			System.out.println("");
		}

		if (wordleWord.isGameOver()) {
			wordleWord.setSolved(true);
			System.out.println("You sucessfully solved the word within 5 rounds!");

		} else {
			System.out.println("You failed to solve the word within 5 rounds.");
		}

		System.out.println("Total Rounds: " + wordleWord.getRoundCount());
		System.out.println("Your Best Guess: " + wordleWord.getStatusWord());
		System.out.println("Wordle Word: " + wordleWord.getWordleWord().toUpperCase());
		System.out.println("");
	}

	public static void main(String[] args) {

		// setting up WordleGrader and WordleDB
		WordleGrader wordleGrader = new WordleGrader();
		WordleDB wordleDB = new WordleDB();
		Scanner scan = new Scanner(System.in);

		System.out.println("Reading in Wordle data...");
		wordleDB.setUp("Book2.csv");

		System.out.println("Setting up Game...");
		int gameCount = 0;

		long startTime = System.nanoTime();
		System.out.println("Start time of program run: " + startTime + " ns\n");

		// run game play
		for (int i = 0; i < wordleDB.getWordleInfo().size(); i++) {
			gameCount += 1;
			System.out.println("Game " + gameCount);
			gamePlay(wordleDB.getWordleInfo().get(i), scan);
		}

		long endTime = System.nanoTime();
		System.out.println("End time of program run: " + endTime + " ns");
		System.out.println("Took " + (endTime - startTime) + " ns");

		wordleGrader.findNumSolves(wordleDB.getWordleInfo());
		wordleGrader.findAvgRounds(wordleDB.getWordleInfo());

		System.out.println("Number of Games Played: " + (gameCount));
		System.out.println("Number of Sucessful Games: " + wordleGrader.getNumSolves());
		System.out.println("Average Number of Rounds: " + wordleGrader.getAvgRounds());

		scan.close();
	}

}
