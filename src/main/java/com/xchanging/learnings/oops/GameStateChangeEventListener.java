package com.xchanging.learnings.oops;

import com.xchanging.learnings.oops.GameStateChangeEventListener.GameStateChangeEvent;
import com.xchanging.learnings.oops.GameState;

public interface GameStateChangeEventListener {
	public static final class GameStateChangeEvent {
		private GameState gameState;
		
		public GameStateChangeEvent(GameState gameState){
			this.gameState=gameState;
		}
		public GameState getState(){
			return gameState;
		}
	}
	
	void onStateChange(GameStateChangeEvent gameStateChangeEvent);
}


