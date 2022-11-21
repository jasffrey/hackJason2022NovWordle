package wordle;

public class WordleWord {

	// instance variables

	/**
	 * Word of the day
	 */
	private String wordleWord;

	/**
	 * Word status at specific round
	 */
	private String statusWord;

	/**
	 * Counter for number of rounds in play
	 */
	private int roundCount = 0;

	/**
	 * Boolean flag to indicate if word has been successfully solved within 5 rounds
	 * (true if so)
	 */
	private boolean isSolved = false;

	// constructor

	public WordleWord(String word) {

		this.wordleWord = word;
		this.statusWord = "-----";
	}

	// getters and setters

	/**
	 * @return the wordleWord
	 */
	public String getWordleWord() {
		return wordleWord;
	}

	/**
	 * @return the statusWord
	 */
	public String getStatusWord() {
		return statusWord;
	}

	/**
	 * @return the roundCount
	 */
	public int getRoundCount() {
		return roundCount;
	}

	/**
	 * @return the isSolved
	 */
	public boolean isSolved() {
		return isSolved;
	}

	/**
	 * @param isSolved the isSolved to set
	 */
	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	// methods

	public void wordStatusUpdate(String inputWord) {

		inputWord = inputWord.toLowerCase();
		wordleWord = wordleWord.toLowerCase();

		char[] statusArr = statusWord.toCharArray();

		for (int i = 0; i < statusArr.length; i++) {

			if (wordleWord.indexOf(inputWord.charAt(i)) != -1) {
				statusArr[i] = Character.toLowerCase(inputWord.charAt(i));
			}

			if (wordleWord.charAt(i) == inputWord.charAt(i)) {
				statusArr[i] = Character.toUpperCase(inputWord.charAt(i));
			}

		}

		roundCount += 1;
		statusWord = new String(statusArr);
	}

	public boolean isGameOver() {

		return (statusWord.toLowerCase().equals(wordleWord.toLowerCase()));
	}

}
