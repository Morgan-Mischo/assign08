package assign08;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTests {

	private BinarySearchTree<String> sTree = new BinarySearchTree<String>();
	private BinarySearchTree<Integer> iTree = new BinarySearchTree<Integer>();
//	
//	    iList1 = new ArrayList<>(); 
//		iList2 = new ArrayList<>(); 
//
//		for (int i = 0; i <= 10; i++)
//		{
//			iList1.add("v" + i);  
//			iList2.add("v" + (i+1));
//		}
//		iList1.add("v" + 5);
//		iList2.add("v" + 1);
//		
//		aList1 = new ArrayList<Character>();
//		aList2 = new ArrayList<Character>();
//		aList1.add('a');
//		aList2.add('a');
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void empty()
	{
//		assertTrue(sTree.isEmpty());
		sTree.add("Cat");
		assertFalse(sTree.isEmpty());
	}
	
	@Test
	void inOrder()
	{
//		iTree.add(5);
//		iTree.add(3);
//		iTree.add(6);
//		iTree.add(1);
//		for(int i = 4; i < 52; i+=3)
//		{
//			iTree.add(i);
//		}
//		iTree.toArrayList();
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
}