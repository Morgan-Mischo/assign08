package assign08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a "dictionary" of strings using a binary search tree and offers
 * methods for spell-checking documents.
 * 
 * @author Erin Parker, Casey Rand, and Morgan Mischo
 * @version March 6, 2019
 */
public class SpellChecker {

	private BinarySearchTree<String> dictionary;

	/**
	 * Default constructor--creates empty dictionary.
	 */
	public SpellChecker() {
		dictionary = new BinarySearchTree<String>();
	}

	/**
	 * Creates dictionary from a list of words.
	 * 
	 * @param words - the List of Strings used to build the dictionary
	 */
	public SpellChecker(List<String> words) {
		this();
		buildDictionary(words);
	}

	/**
	 * Creates dictionary from a file.
	 * 
	 * @param dictionaryFile - the File that contains Strings used to build the
	 *                        dictionary
	 */
	public SpellChecker(File dictionaryFile) {
		this();
		buildDictionary(readFromFile(dictionaryFile));
	}

	/**
	 * Add a word to the dictionary.
	 * 
	 * @param word - the String to be added to the dictionary
	 */
	public void addToDictionary(String word) {
		String newWord = word.toLowerCase();
		dictionary.add(newWord);
	}

	/**
	 * Remove a word from the dictionary.
	 * 
	 * @param word - the String to be removed from the dictionary
	 */
	public void removeFromDictionary(String word) {
		String newWord = word.toLowerCase();
		dictionary.remove(newWord);
	}
	
	/**
	 * Checks to see if a word is in the dictionary.
	 * 
	 * @param word - the String to be checked if contained in dictionary
	 */
	public boolean inDictionary(String word)
	{
		String changedWord = word.toLowerCase();
		return dictionary.contains(changedWord);
	}

	/**
	 * Spell-checks a document against the dictionary.
	 * 
	 * @param document_file - the File that contains Strings to be looked up in the
	 *                      dictionary
	 * @return a List of misspelled words
	 */
	public List<String> spellCheck(File documentFile) {

		List<String> wordsToCheck = readFromFile(documentFile);
		
		List<String> result = new ArrayList<String>();

		for(int i = 0; i < wordsToCheck.size(); i++)
		{
			String newWord = wordsToCheck.get(i).toLowerCase();
			if(!inDictionary(newWord) && !result.contains(newWord))
			{
				result.add(wordsToCheck.get(i));
			}
		}
		
		return result;
	}

	/**
	 * Fills in the dictionary with the input list of words.
	 * 
	 * @param words - the List of Strings to be added to the dictionary
	 */
	private void buildDictionary(List<String> words) {
		List<String> lowerCase = new ArrayList<String>();
		for(int i = 0; i < words.size(); i++)
		{
			String newWord = words.get(i).toLowerCase();
			lowerCase.add(newWord);
		}
		dictionary.addAll(lowerCase);
	}

	/**
	 * Returns a list of the words contained in the specified file. (Note that
	 * symbols, digits, and spaces are ignored.)
	 * 
	 * @param file - the File to be read
	 * @return a List of the Strings in the input file
	 */
	private List<String> readFromFile(File file) {
		ArrayList<String> words = new ArrayList<String>();

		try {
			/*
			 * Java's Scanner class is a simple lexer for Strings and primitive types (see
			 * the Java API, if you are unfamiliar).
			 */
			Scanner fileInput = new Scanner(file);

			/*
			 * The scanner can be directed how to delimit (or divide) the input. By default,
			 * it uses whitespace as the delimiter. The following statement specifies
			 * anything other than alphabetic characters as a delimiter (so that punctuation
			 * and such will be ignored). The string argument is a regular expression that
			 * specifies "anything but an alphabetic character". You need not understand any
			 * of this for the assignment.
			 */
			fileInput.useDelimiter("\\s*[^a-zA-Z]\\s*");

			while (fileInput.hasNext()) {
				String s = fileInput.next();
				if (!s.equals("")) 
					words.add(s.toLowerCase());
			}
			
			fileInput.close();

		} 
		catch(FileNotFoundException e) {
			System.err.println("File " + file + " cannot be found.");
		}

		return words;
	}
}