package com;

public class Methods {
	final static int MinuetLenght = 16;
	public static double[] runningsample;
	public static String outputfilename = "";
	public static String savefilename = "";
	static int totallenght = 0;
	static String[] Waltz = new String[32];
	
	public static void generateWaltzNameAndFilename() {
		PairOfDice dice = new PairOfDice();
		
		for (int i = 0; i < Waltz.length; i++) {
			if (i < MinuetLenght) {
				dice.roll();
				Waltz[i] = "M" + WaltzTable.MinuetArray[dice.getDiceTotal()][i];
			}
			else {
				dice.roll();
				Waltz[i] = "T" + WaltzTable.TrioArray[dice.getDie1()][i - MinuetLenght];
			}
		}
		
		for (int i = 0; i < Waltz.length; i++) {
			totallenght += StdAudio.read("audio/" + Waltz[i] + ".wav").length;
			outputfilename += Waltz[i];
		}
	}
	
	public static void generateWaltzAudio() {
		runningsample = new double[totallenght];
		totallenght = 0;
		double[] currentsample;
		int destinationPosition = 0;
		
		for (int i = 0; i < Waltz.length; i++) {
			currentsample = StdAudio.read("audio/" + Waltz[i] + ".wav");
			System.arraycopy(currentsample, 0, runningsample, destinationPosition, currentsample.length);
			destinationPosition += currentsample.length;
		}
	}
}
