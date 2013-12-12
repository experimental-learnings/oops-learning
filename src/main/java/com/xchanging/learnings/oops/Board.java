package com.xchanging.learnings.oops;

import java.util.*;

import org.mockito.ArgumentCaptor;
import com.xchanging.learnings.oops.Cell;

import com.xchanging.learnings.oops.BoardStateChangeEventListener.BoardStateChangeEvent;
import com.xchanging.learnings.oops.GameStateChangeEventListener.GameStateChangeEvent;

public class Board {

	private Integer size;
	 Map<Position, Token> tokenMap = new HashMap<Position, Token>();
	private Token currentToken;
	Cell cell = new Cell();
	public String gameState;
	public BoardStateChangeEventListener boardStateListener;
	public GameStateChangeEventListener gameStateListener;

	public Board(Integer size) {
		this.size = size;

	}

	public void place(Position position, Token token) {
		validate(position, token);

		tokenMap.put(position, token);
		hasWon(position, token);
		currentToken = token;
		if (boardStateListener != null) {
			boardStateListener.onStateChange(new BoardStateChangeEvent(
					new BoardState()));
		}

		if (gameStateListener != null) {
			gameStateListener.onStateChange(new GameStateChangeEvent(
					new GameState()));
		}
	}

	private void hasWon(Position position, Token token) {
		if ((isRowWin(position, token) || isColumnWin(position, token) || isLeftDiagonalWin(
				position, token))
				|| isRightDiagonalWin(position, token) == true) {

			System.out.println(token + " won the game");
			GameState.gameStatus = "game completed";
		}

	}

	private boolean isRightDiagonalWin(Position position, Token token) {
	//	int count = 0;
	//	for (int row = 0; row < size; row++) {
		//	for (int column = 2; column > 0; column--) {
		//		if (token.equals(tokenMap.get(new Position(row, column)))) {
			//		count++;
		//	}
		//	}
		//}
		//if (count == 3)
		//	return true;
		 if (cell.evaluateSurroundingRightDiagnolPositions(position, token,
		 tokenMap) == 1)

		{
		 return true;
		 }
		return false;
	}

	private boolean isLeftDiagonalWin(Position position, Token token) {
		// int count = 0;
		// for (int row = 0; row < size; row++) {
		// for (int column = 0; column < size; column++) {
		// if (token.equals(tokenMap.get(new Position(row, column)))) {
		// count++;
		// }

		// }
		// }

		if (cell.evaluateSurroundingLeftDiagnolPositions(position, token,
				tokenMap) == 1)

		{
			return true;
		}
		return false;
	}

	private boolean isColumnWin(Position position, Token token) {

		if (cell.evaluateSurroundingRows(position, token, tokenMap) == 1)

		{
			return true;
		}
		return false;

	}

	private boolean isRowWin(Position position, Token token) {

		if (cell.evaluateSurroundingColumns(position, token, tokenMap) == 1)

		{
			return true;
		}

		return false;
	}

	private void validate(Position position, Token token) {
		if (!isWithinTheBoundaries(position))
			throw new OutOfBoundaryException();
		if (isTokenAlreadyPresent(position, token) == true)
			throw new TokenAlreadyPlacedException();
		if (isSamePlayerPlayingConsequtively(token))
			throw new ConsequtivePlayOfSamePlayerException();
	}

	private boolean isSamePlayerPlayingConsequtively(Token token) {
		return ((currentToken != null) && (currentToken.equals(token)));

	}

	private boolean isTokenAlreadyPresent(Position position, Token token) {
		return tokenMap.containsKey(position);
	}

	private boolean isWithinTheBoundaries(Position position) {

		return ((position.getRow() < size) && (position.getColumn() < size));
	}

	public boolean hasTokenAt(Position position) {
		if (tokenMap.get(position) != null)
			return true;
		else
			return false;
	}

	public class BoardState {

		public boolean hasTokenAt(Position position) {
			if (tokenMap.get(position) != null)
				return true;
			else
				return false;
		}

	}

	public void setBoardStateChangeListener(
			BoardStateChangeEventListener listener) {
		this.boardStateListener = listener;
	}

	public void setGameStateChangeListener(
			GameStateChangeEventListener gameListener) {
		this.gameStateListener = gameListener;
	}
}
