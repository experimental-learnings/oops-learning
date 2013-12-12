package com.xchanging.learnings.oops;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;

import com.xchanging.learnings.oops.BoardStateChangeEventListener.BoardStateChangeEvent;
import com.xchanging.learnings.oops.GameStateChangeEventListener.GameStateChangeEvent;

public class TicTacToeTestCase {

	@Test
	public static void shouldBeAbleToPlaceTokenOnTheBoard() {
		final Integer size = 3;
		Board board = new Board(size);
		Position oneByTwo = new Position(1, 2);
		Token token = new Token("X");
		BoardStateChangeEventListener listener = mock(BoardStateChangeEventListener.class);
		board.setBoardStateChangeListener(listener);
		board.place(oneByTwo, token);

		ArgumentCaptor<BoardStateChangeEvent> argument = ArgumentCaptor
				.forClass(BoardStateChangeEvent.class);
		verify(listener).onStateChange(argument.capture());
		assertTrue(argument.getValue().getState().hasTokenAt(oneByTwo));

	}

	@Test
	public static void shouldNotAllowPlacingTokenOnSamePosition() {
		final Integer size = 3;
		Board board = new Board(size);
		Position twoByTwo = new Position(2, 2);
		Token token = new Token("X");
		Token anotherToken = new Token("0");
		BoardStateChangeEventListener listener = mock(BoardStateChangeEventListener.class);
		board.setBoardStateChangeListener(listener);

		board.place(twoByTwo, anotherToken);

		try {
			board.place(twoByTwo, token);
		} catch (TokenAlreadyPlacedException e) {
			return;

		}
		fail(" throw TokenAlreadyPlacedException");
	}

	@Test
	public static void shouldNotAbleToPlaceBeyondBoundaries() {

		final Integer size = 3;
		Board board = new Board(size);
		Position position = new Position(3, 2);
		Token token = new Token("X");
		BoardStateChangeEventListener listener = mock(BoardStateChangeEventListener.class);
		board.setBoardStateChangeListener(listener);

		try {
			board.place(position, token);
		} catch (OutOfBoundaryException e) {
			return;

		}

		fail(" throw OutOfBoundaryException");
	}

	@Test
	public static void shouldNotAllowSameplayerToPlayConsequtively() {

		final Integer size = 3;
		Board board = new Board(size);
		Position position = new Position(1, 2);
		Position anotherPosition = new Position(2, 0);
		Token token = new Token("X");
		BoardStateChangeEventListener listener = mock(BoardStateChangeEventListener.class);
		board.setBoardStateChangeListener(listener);

		try {
			board.place(position, token);
			board.place(anotherPosition, token);

		} catch (ConsequtivePlayOfSamePlayerException e) {
			return;

		}

		fail("throw ConsequtivePlayOfSamePlayerException");

	}

	@Test
	public static void shouldDeclareHorizontalWin() {

		final Integer size = 3;
		Board board = new Board(size);
		GameState gameState = new GameState();

		Position oneZero = new Position(1, 0);
		Position zeroZero = new Position(0, 0);
		Position oneOne = new Position(1, 1);
		Position twoZero = new Position(2, 0);
		Position oneTwo = new Position(1, 2);
		Token token = new Token("X");
		Token anotherToken = new Token("0");
		BoardStateChangeEventListener listener = mock(BoardStateChangeEventListener.class);
		board.setBoardStateChangeListener(listener);

		board.place(oneZero, token);
		board.place(zeroZero, anotherToken);
		board.place(oneOne, token);
		board.place(twoZero, anotherToken);

		GameStateChangeEventListener gameListener = mock(GameStateChangeEventListener.class);
		board.setGameStateChangeListener(gameListener);

		board.place(oneTwo, token);

		ArgumentCaptor<GameStateChangeEvent> argument = ArgumentCaptor
				.forClass(GameStateChangeEvent.class);
		verify(gameListener).onStateChange(argument.capture());
		assertTrue(argument.getValue().getState().hasGameCompleted());

	}

	@Test
	public static void shouldDeclareVerticalWin() {

		final Integer size = 3;
		Board board = new Board(size);
		Position zeroZero = new Position(0, 0);
		Position oneOne = new Position(1, 1);
		Position oneZero = new Position(1, 0);
		Position oneTwo = new Position(1, 2);

		Position twoZero = new Position(2, 0);

		Token token = new Token("X");
		Token anotherToken = new Token("0");
		BoardStateChangeEventListener listener = mock(BoardStateChangeEventListener.class);
		board.setBoardStateChangeListener(listener);

		board.place(zeroZero, token);
		board.place(oneOne, anotherToken);
		board.place(oneZero, token);
		board.place(oneTwo, anotherToken);
		GameStateChangeEventListener gameListener = mock(GameStateChangeEventListener.class);
		board.setGameStateChangeListener(gameListener);

		board.place(twoZero, token);
		ArgumentCaptor<GameStateChangeEvent> argument = ArgumentCaptor
				.forClass(GameStateChangeEvent.class);
		verify(gameListener).onStateChange(argument.capture());
		assertTrue(argument.getValue().getState().hasGameCompleted());

	}

	@Test
	public static void shouldDeclareLeftDiagnolWin() {

		final Integer size = 3;
		Board board = new Board(size);
		Position zeroZero = new Position(0, 0);
		Position Zeroone = new Position(0, 1);

		Position oneone = new Position(1, 1);
		Position oneTwo = new Position(1, 2);
		Position twotwo = new Position(2, 2);

		Token token = new Token("X");
		Token anotherToken = new Token("0");
		BoardStateChangeEventListener listener = mock(BoardStateChangeEventListener.class);
		board.setBoardStateChangeListener(listener);

		board.place(zeroZero, anotherToken);
		board.place(Zeroone, token);
		board.place(oneone, anotherToken);
		board.place(oneTwo, token);
		GameStateChangeEventListener gameListener = mock(GameStateChangeEventListener.class);
		board.setGameStateChangeListener(gameListener);

		board.place(twotwo, anotherToken);
		ArgumentCaptor<GameStateChangeEvent> argument = ArgumentCaptor
				.forClass(GameStateChangeEvent.class);
		verify(gameListener).onStateChange(argument.capture());
		assertTrue(argument.getValue().getState().hasGameCompleted());

	}

	@Test
	public static void shouldDeclareRightDiagnolWin() {

		final Integer size = 3;
		Board board = new Board(size);
		Position zerotwo = new Position(0, 2);
		Position Zeroone = new Position(0, 1);

		Position oneone = new Position(1, 1);
		Position oneTwo = new Position(1, 2);
		Position twozero = new Position(2, 0);

		Token token = new Token("X");
		Token anotherToken = new Token("0");
		BoardStateChangeEventListener listener = mock(BoardStateChangeEventListener.class);
		board.setBoardStateChangeListener(listener);

		board.place(zerotwo, anotherToken);
		board.place(Zeroone, token);
		board.place(oneone, anotherToken);
		board.place(oneTwo, token);
		GameStateChangeEventListener gameListener = mock(GameStateChangeEventListener.class);
		board.setGameStateChangeListener(gameListener);

		board.place(twozero, anotherToken);
		ArgumentCaptor<GameStateChangeEvent> argument = ArgumentCaptor
				.forClass(GameStateChangeEvent.class);
		verify(gameListener).onStateChange(argument.capture());
		assertTrue(argument.getValue().getState().hasGameCompleted());

	}
}
