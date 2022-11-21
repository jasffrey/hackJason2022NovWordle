package wordle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class WordleDB {
//
	// instance variables

	/**
	 * ArrayList of all words from file
	 */
	private ArrayList<WordleWord> wordleInfo = new ArrayList<WordleWord>();

	// setters and getters

	/**
	 * @return the wordleInfo
	 */
	public ArrayList<WordleWord> getWordleInfo() {
		return wordleInfo;
	}

	// methods

	public void setUp(String wordleData) {

		try {

			File f = new File(wordleData);
			FileReader fd = new FileReader(f);
			BufferedReader br = new BufferedReader(fd);

			while (true) {

				String line = br.readLine();

				if (line == null) {
					break;
				}

				String[] arr = line.trim().split(",");
				WordleWord newWord = new WordleWord(arr[2].trim().toLowerCase());
				wordleInfo.add(newWord);
			}

			fd.close();
			br.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
