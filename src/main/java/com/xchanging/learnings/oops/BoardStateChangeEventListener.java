package com.xchanging.learnings.oops;

import com.xchanging.learnings.oops.Board.BoardState;

public interface BoardStateChangeEventListener {

	public static final class BoardStateChangeEvent {
		private BoardState boardState;

		public BoardStateChangeEvent(BoardState boardState) {
			this.boardState = boardState;
		}

		public BoardState getState() {
			return boardState;
		}
	}

	void onStateChange(BoardStateChangeEvent boardStateChangeEvent);
}
