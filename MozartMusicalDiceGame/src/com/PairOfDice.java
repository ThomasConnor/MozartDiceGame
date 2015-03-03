package com;

public final class PairOfDice {
	private int die1;
	private int die2;
	
	public PairOfDice() {
	}
	
	public void roll() {
		// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/random
		// uniform distribution, see verifyDice
		final int min = 1;
		final int max = 6;
		die1 = (int) Math.floor(Math.random() * (max - min + 1)) + min;
		die2 = (int) Math.floor(Math.random() * (max - min + 1)) + min;
	}
	
	public void roll2() {
		//http://math.hws.edu/eck/cs124/javanotes4/c5/ex-5-1-answer.html
		die1 = (int) (Math.random() * 6) + 1;
		die2 = (int) (Math.random() * 6) + 1;
	}
	
	public int getDie1() {
		return die1;
	}
	
	public int getDie2() {
		return die1;
	}
	
	public int getDiceTotal() {
		return die1 + die2;
	}
}
