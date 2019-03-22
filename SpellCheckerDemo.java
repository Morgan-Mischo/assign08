package assign08;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A small demonstration of the SpellChecker class.
 * 
 * @author Erin Parker
 * @version March 6, 2019
 */
public class SpellCheckerDemo {

	public static void main(String[] args) {
		
		List<String> sList = new ArrayList<String>();
		sList.add("police");
		sList.add("you");
		sList.add("see");
		sList.add("help");

		SpellChecker mySC = new SpellChecker(new File("src/assign08/dictionary.txt"));
		SpellChecker shortSC = new SpellChecker(sList);

		runSpellCheck(mySC, "src/assign08/hello_world.txt");
		runSpellCheck(mySC, "src/assign08/hello_world.txt");
		runSpellCheck(mySC, "src/assign08/good_luck.txt");
		runSpellCheck(shortSC, "src/assign08/test");
		shortSC.removeFromDictionary("police");
		runSpellCheck(shortSC, "src/assign08/test");
	}

	/**
	 * Runs the given spell checker (with dictionary already added) on the specified 
	 * file.
	 * 
	 * @param sc - the given spell checker
	 * @param documentFilename - name of the file to be spell checked
	 */
	private static void runSpellCheck(SpellChecker sc, String documentFilename) {

		File doc = new File(documentFilename);
		List<String> misspelledWords = sc.spellCheck(doc);
		if(misspelledWords.size() == 0) 
			System.out.println("There are no misspelled words in file " + doc + ".");
		else {
			System.out.println("The misspelled words in file " + doc + " are:");
			for(String w : misspelledWords) 
				System.out.println("\t" + w);
		}
	}
}