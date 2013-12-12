package com.xchanging.assignment;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SnakeAndLadderTestCase {
	@Test
	public static void playerPositionShouldBeMovedBasedOnOutcomeOfDice() {
		final Integer size = 100;
		Board board = new Board(size);
		Dice dice = new Dice();
		int diceOutcome = dice.rollDice();
		int currentPositionPlayer1 = 0;

		Position position = new Position();

		currentPositionPlayer1 = position.getNewPosition(currentPositionPlayer1,
				diceOutcome);

		Player player = new Player("player1");

		board.play(player, currentPositionPlayer1);
		assertTrue(board.hasPlayerAt(board.alteredPosition));

	}

	@Test
	public static void shouldNotAllowPlayingBeyondBoundaries() {
		final Integer size = 100;
		Board board = new Board(size);
		Dice dice = new Dice();
		int diceOutcome = dice.rollDice();
		int currentPositionPlayer1 =101;

		Position position = new Position();

		currentPositionPlayer1 = position.getNewPosition(currentPositionPlayer1,
				diceOutcome);

		Player player = new Player("player1");
		try {
			board.play(player, currentPositionPlayer1);
		} catch (OutOfBoundaryException e) {
			return;

		}
		fail("throw OutOfBoundaryException");

	}

	@Test
	public static void shouldNotAllowSamePlayerToPlayConsequtively() {
		final Integer size = 100;
		Board board = new Board(size);
		Dice dice = new Dice();
		int diceOutcome = dice.rollDice();
		int currentPositionPlayer1 = 0;

		Position position = new Position();

		currentPositionPlayer1 = position.getNewPosition(currentPositionPlayer1,
				diceOutcome);

		Player player = new Player("player1");

		board.play(player, currentPositionPlayer1);
		diceOutcome = dice.rollDice();
		currentPositionPlayer1 = 20;
		currentPositionPlayer1 = position.getNewPosition(currentPositionPlayer1,
				diceOutcome);
		try {
			board.play(player, currentPositionPlayer1);
		} catch (ConsequtivePlayOfSamePlayerException e) {
			return;
		}
		fail("throw ConsequtivePlayOfSamePlayerException ");

	}

	@Test
	public static void shouldAllowPlayingAgainOnlyIfOutcomeIsSix() {
		final Integer size = 100;
		Board board = new Board(size);
		Position position = new Position();

		Integer currentPositionPlayer1 = 6;

		Player player = new Player("player1");

		board.play(player, currentPositionPlayer1);
		Dice dice = new Dice();
		int diceOutcome = dice.rollDice();
		currentPositionPlayer1 = 20;
		currentPositionPlayer1 = position.getNewPosition(currentPositionPlayer1,
				diceOutcome);

		board.play(player, currentPositionPlayer1);
		assertTrue(board.hasPlayerAt(currentPositionPlayer1));

	}

	@Test
	public static void shouldBeMovedToTopOfLadderOnReachingBottomOfLadder() {
		final Integer size = 100;
		Board board = new Board(size);

		int currentPositionPlayer1 = 5;

		Player player = new Player("player1");

		board.play(player, currentPositionPlayer1);
		assertTrue(board.hasPlayerAt(board.alteredPosition));

	}

	@Test
	public static void shouldBeMovedToTailOfSnakeOnReachingHeadOfSnake() {
		final Integer size = 100;
		Board board = new Board(size);

		int currentPositionPlayer1 = 5;

		Player player = new Player("player1");

		board.play(player, currentPositionPlayer1);
		assertTrue(board.hasPlayerAt(board.alteredPosition));

	}

	@Test
	public static void shouldDeclareWinnerOnReachingHundered() {
		final Integer size = 100;
		Board board = new Board(size);

		int currentPositionPlayer1 = 99;

		Player player1 = new Player("player1");

		board.play(player1, currentPositionPlayer1);
		assertEquals((board.hasWon(player1, currentPositionPlayer1)), false);
		int currentPositionPlayer2 = 100;

		Player player2 = new Player("player2");
		board.play(player2, currentPositionPlayer2);
		assertTrue(board.hasWon(player2, currentPositionPlayer2));
	}
	
	@Test
	public static void sampleTest() {
		final Integer size = 100;
		Board board = new Board(size);

		int currentPositionPlayer1 = 99;

		Player player1 = new Player("player1");

		board.play(player1, currentPositionPlayer1);
		assertEquals((board.hasWon(player1, currentPositionPlayer1)), false);
		int currentPositionPlayer2 = 100;

		Player player2 = new Player("player2");
		board.play(player2, currentPositionPlayer2);
		assertTrue(board.hasWon(player2, currentPositionPlayer2));
	}

}
