package verifyDice;

import com.PairOfDice;

public class verifyDice {
	public static void main(String[] args) {
		PairOfDice dice = new PairOfDice();
		int totalOnes = 0;
		int totalTwos = 0;
		int totalThrees = 0;
		int totalFours = 0;
		int totalFives = 0;
		int totalSixs = 0;
		
		final int poolsize = 1_000_000;
		final int arraysize = 6 * poolsize;
		int[] dicearray = new int[arraysize];
		
		//long startTime = System.nanoTime();    
		for (int i = 0; i < dicearray.length; i++) {
			dice.roll();
			dicearray[i] = dice.getDie1();
			if (dicearray[i] == 1) {totalOnes++; continue;}
			if (dicearray[i] == 2) {totalTwos++; continue;}
			if (dicearray[i] == 3) {totalThrees++; continue;}
			if (dicearray[i] == 4) {totalFours++; continue;}
			if (dicearray[i] == 5) {totalFives++; continue;}
			if (dicearray[i] == 6) {totalSixs++; continue;}
		}
		
		//long estimatedTime = System.nanoTime() - startTime;

		System.out.println("1's: " + totalOnes + "\t(Delta %: " + ((double) (totalOnes - poolsize) / (poolsize / 100) + ")"));
		System.out.println("2's: " + totalTwos + "\t(Delta %: " + ((double) (totalTwos - poolsize) / (poolsize / 100) + ")"));
		System.out.println("3's: " + totalThrees + "\t(Delta %: " + ((double) (totalThrees - poolsize) / (poolsize / 100) + ")"));
		System.out.println("4's: " + totalFours + "\t(Delta %: " + ((double) (totalFours - poolsize) / (poolsize / 100) + ")"));
		System.out.println("5's: " + totalFives + "\t(Delta %: " + ((double) (totalFives - poolsize) / (poolsize / 100) + ")"));
		System.out.println("6's: " + totalSixs + "\t(Delta %: " + ((double) (totalSixs - poolsize) / (poolsize / 100) + ")"));
		//System.out.println(estimatedTime);
	}
}
