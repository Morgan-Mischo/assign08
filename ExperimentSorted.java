package assign08;

import java.util.ArrayList;
import java.util.List;

public class ExperimentSorted {

	public static <E> void main (String[] args) {
		
		final int problemSize = 20000;
		final int TIMES_TO_LOOP = 1000;

		BinarySearchTree<Integer> test1 = new BinarySearchTree<Integer>();
		List<Integer> iList1 = new ArrayList<>();

		for (int i = 1000; i < problemSize + 1; i+=1000)
		{
			for (int j = 0; j < i; j++)
			{
				iList1.add(j);
			}
			test1.addAll(iList1);

			long startTime, midpointTime, stopTime = System.nanoTime();

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { 
				// empty block
			}

			// Now, run the test.
			startTime = System.nanoTime();

			for (int j = 0; j < i; j++)
			{
			}

			midpointTime = System.nanoTime();

			// Run a loop to capture the cost of running the "timesToLoop" loop and
			// generating a random ISBN.
			for (int j = 0; j < i; j++)
			{
				test1.contains(j);
			}
			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = (double) ((midpointTime - startTime) - (stopTime - midpointTime))
					/ TIMES_TO_LOOP;
			System.out.println(i + "\t" + averageTime);
		}
	

	}

}