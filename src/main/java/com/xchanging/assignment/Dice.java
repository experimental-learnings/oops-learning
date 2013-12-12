package com.xchanging.assignment;

import java.util.Random;

public class Dice {

	public int rollDice() {

		Random r = new Random();

		return (1 + Math.round(r.nextInt(6)));
	}

}
