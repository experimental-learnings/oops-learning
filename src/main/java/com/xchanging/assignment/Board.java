package com.xchanging.assignment;

import java.util.*;

public class Board {
	private Integer size;
	static int previousOutcome = 0;
	static int alteredPosition = 0;

	public Board(Integer size) {
		this.size = size;

	}

	private Player currentPlayer;
	Map<Integer, Player> playerMap = new HashMap<Integer, Player>();
	private Map<Integer, Integer> ladderEndPoints = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> snakeEndPoints = new HashMap<Integer, Integer>();

	public boolean hasPlayerAt(Integer currentPosition) {
		if (playerMap.get(currentPosition) != null)
			return true;

		else
			return false;

	}

	public void play(Player player, int currentPosition) {
		placeLadders();
		placeSnakes();
		Integer ladderCurrentValue = null;
		Integer SnakeCurrentValue = null;

		validate(player, currentPosition);
		if ((ladderCurrentValue = isLadder(currentPosition)) != null) {
			currentPosition = ladderCurrentValue;
			alteredPosition = currentPosition;
		}
		if ((SnakeCurrentValue = isSnake(currentPosition)) != null) {
			currentPosition = SnakeCurrentValue;
			alteredPosition = currentPosition;
		}
		alteredPosition = currentPosition;
		playerMap.put(currentPosition, player);
		currentPlayer = player;
		hasWon(player, currentPosition);
	}

	public boolean hasWon(Player player, int currentPosition) {
		if (currentPosition == 100)
			return true;
		else
			return false;

	}

	private void validate(Player player, int currentPosition) {

		if (!withinBoundaries(currentPosition))
			throw new OutOfBoundaryException();
		if (previousOutcome != 6) {
			if (isSamePlayerPlayingConsequtively(player))
				throw new ConsequtivePlayOfSamePlayerException();
		}
		previousOutcome = currentPosition;

	}

	private boolean withinBoundaries(int currentPosition) {

		return currentPosition <= size;
	}

	private boolean isSamePlayerPlayingConsequtively(Player player) {

		return ((currentPlayer != null) && (currentPlayer.equals(player)));
	}

	public void placeLadders() {
		ladderEndPoints.put(new Integer(5), new Integer(20));
		ladderEndPoints.put(new Integer(30), new Integer(52));
		ladderEndPoints.put(new Integer(40), new Integer(80));
		ladderEndPoints.put(new Integer(75), new Integer(91));
		ladderEndPoints.put(new Integer(88), new Integer(97));

	}

	public Integer isLadder(int currentPosition) {
		Integer value = null;
		if ((value = (Integer) ladderEndPoints.get(currentPosition)) != null) {

			return value;
		}

		return value;
	}

	public void placeSnakes() {
		snakeEndPoints.put(new Integer(99), new Integer(8));
		snakeEndPoints.put(new Integer(83), new Integer(12));
		snakeEndPoints.put(new Integer(69), new Integer(39));
		snakeEndPoints.put(new Integer(58), new Integer(27));
		snakeEndPoints.put(new Integer(31), new Integer(3));

	}

	public Integer isSnake(int currentPosition) {
		Integer value = null;
		if ((value = (Integer) snakeEndPoints.get(currentPosition)) != null) {

			return value;
		}

		return value;
	}

}
