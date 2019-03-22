package assign08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Timing {

	public static <E> void main (String[] args) {
		
		final int problemSize = 20000;
		final int TIMES_TO_LOOP = 1000;

		Random rng = new Random();

		List<Integer> iList1 = new ArrayList<>();

		for (int i = 5000; i < problemSize + 1; i+=5000)
		{
			BinarySearchTree<Integer> test1 = new BinarySearchTree<Integer>(iList1);

			long startTime, midpointTime, stopTime = System.nanoTime();

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { 
				// empty block
			}

			// Now, run the test.
			startTime = System.nanoTime();

			int p = 0;
			while (p < 10)
			{
				iList1.clear();
			for (int j = 0; j < i; j++)
			{
				iList1.add(rng.nextInt(i));
			}
			for (int j = 0; j <= TIMES_TO_LOOP; j++)
			{
				for (int k = 0; k < i; k++)
				{
					test1.contains(k);
				}
			}
			p++;
			}

			midpointTime = System.nanoTime();

			// Run a loop to capture the cost of running the "timesToLoop" loop and
			// generating a random ISBN.
			while (p < 10)
			{
				iList1.clear();
			for (int j = 0; j < i; j++)
			{
				iList1.add(rng.nextInt(i));
			}
			for (int j = 0; j <= TIMES_TO_LOOP; j++)
			{
				for (int k = 0; k < i; k++)
				{
				}
			}
			p++;
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