package assign08;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTests {

	private BinarySearchTree<String> sTree = new BinarySearchTree<String>();
	private BinarySearchTree<Integer> iTree = new BinarySearchTree<Integer>();
	private ArrayList<Integer> iItems = new ArrayList<Integer>();
	private BinarySearchTree<Integer> iTree2 = new BinarySearchTree<Integer>();

	@BeforeEach
	void setUp() throws Exception
	{
		iTree.add(8);
		iTree.add(3);
		iTree.add(6);
		iTree.add(15);
		iTree.add(12);
		iTree.add(7);
		
		iItems.add(7);
		iItems.add(15);
		iItems.add(8);
		iItems.add(6);
		
		iTree2.add(7);
		iTree2.add(15);
		iTree2.add(8);
		iTree2.add(6);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void empty()
	{
		assertTrue(sTree.isEmpty());
		sTree.add("Cat");
		assertFalse(sTree.isEmpty());
	}
	
	@Test
	void add()
	{
		sTree.add("Human");
		assertTrue(sTree.contains("Human"));
		//case sensitive unless comparison is changed, which will be necessary in a future spell-checker class
		assertFalse(sTree.contains("human"));
	}
	
	@Test
	void size()
	{
		sTree.add("apple");
		assertEquals(1, sTree.size());
		
		assertEquals(6, iTree.size());
	}
	
	@Test
	void addAll()
	{
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		test.addAll(iItems);
		
		assertEquals(4, test.size());
	}
	
	@Test
	void addAll10()
	{
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		List<Integer> myList = new ArrayList<Integer>();
		for(int i = 0; i < 500; i++)
		{
			myList.add(i);
		}
		test.addAll(myList);
		assertEquals(500, test.size());
	}
	
	@Test
	void inOrder()
	{
//		iTree.toArrayList();
//		System.out.println(iTree);
	}
	
	@Test
	void contains()
	{
		assertTrue(iTree.contains(8));
		assertTrue(iTree.contains(7));
		assertFalse(iTree.contains(9));
		assertTrue(iTree.contains(15));
	}
	
	@Test
	void containsAll()
	{
		
		ArrayList<Integer> items = new ArrayList<Integer>();
		items.add(7);
		items.add(15);
		items.add(8);
		items.add(6);
		
		assertTrue(iTree.containsAll(items));
	}
	
	@Test
	void clear()
	{
		iTree.clear();
		assertTrue(iTree.isEmpty());
	}
	
	@Test
	void remove_Root()
	{
		iTree.remove(8);
//		System.out.println(iTree);
		assertFalse(iTree.contains(8));
		
	}
	@Test
	void string()
	{
//		iTree.add(5);
//		iTree.add(3);
//		iTree.add(6);
//		iTree.add(1);
//		for(int i = 4; i < 20; i+=3)
//		{
//			iTree.add(i);
//		}
//		String result = iTree.toString();
//		System.out.println(result);
	}
	
	@Test
	void remove()
	{
		assertTrue(iTree.remove(8)); 
		assertFalse(iTree.contains(8));
		iTree.remove(12);
		assertFalse(iTree.contains(12)); 
	}
	
	@Test
	void remove_Leaf()
	{
		iTree2.remove(6);
		assertFalse(iTree2.contains(6));
	}
	
	@Test
	void removeAll()
	{
		assertTrue(iTree.removeAll(iItems)); 
		assertFalse(iTree.removeAll(iItems)); 
	}
}