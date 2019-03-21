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
		smallDic.add("Bubble");
		smallDic.add("Crunch");
		smallDic.add("wrapper");
	}
	
	@Test
	void testAddToDictionary() {
		SpellChecker smallSC = new SpellChecker(smallDic);
		assertTrue(smallSC.inDictionary("Bubble"));
	}

	@Test
	void testRemoveFromDictionary() {
		fail("Not yet implemented");
	}

	@Test
	void testSpellCheck() {
		fail("Not yet implemented");
	}

}
