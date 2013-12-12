package com.xchanging.learnings.oops;

public class GameState {
	public static String gameStatus;

	public boolean hasGameCompleted() {
		if (gameStatus != null)
			return true;

		return false;
	}

}
