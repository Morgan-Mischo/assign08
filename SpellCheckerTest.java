package assign08;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpellCheckerTest {
	
	private SpellChecker mySC = new SpellChecker(new File("src/assign08/dictionary.txt"));
	private List<String> smallDic = new ArrayList<String>();
	
	@BeforeEach
	void setUp() throws Exception
	{
		smallDic.add("bubble");
		smallDic.add("crunch");
		smallDic.add("wrapper");
	}
	
	@Test
	void inDictionary() 
	{
		SpellChecker smallSC = new SpellChecker(smallDic);
		assertTrue(smallSC.inDictionary("Bubble"));
	}
	
	@Test
	void addToDictionary() 
	{
		mySC.addToDictionary("ferror");
		assertTrue(mySC.inDictionary("ferror"));
	}
	
	@Test
	void capitalization()
	{
		assertTrue(mySC.inDictionary("ball"));
		assertTrue(mySC.inDictionary("Ball"));
	}

	@Test
	void testRemoveFromDictionary() {
		mySC.addToDictionary("fowster");
		mySC.removeFromDictionary("fowster");
		assertFalse(mySC.inDictionary("fowster"));
	}
}
