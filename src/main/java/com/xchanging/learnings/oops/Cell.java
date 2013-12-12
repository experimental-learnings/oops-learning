package com.xchanging.learnings.oops;

import java.util.HashMap;
import java.util.Map;

public class Cell {
	int count = 0;
	Map<Position, Token> anothertokenMap = new HashMap<Position, Token>();

	public int evaluateSurroundingColumns(Position position, Token token,
			Map<Position, Token> tokenMap) {
		int row = position.getRow();
		int column = position.getColumn();
		this.anothertokenMap = tokenMap;
		Position[] position1 = { new Position(row, column),
				new Position(row, column - 1), new Position(row, column + 1) };
		Position[] position2 = { new Position(row, column),
				new Position(row, column - 1), new Position(row, column - 2) };
		Position[] position3 = { new Position(row, column),
				new Position(row, column + 1), new Position(row, column + 2) };

		if ((token.equals(tokenMap.get(position1[0]))
				&& token.equals(tokenMap.get(position1[1])) && token
					.equals(tokenMap.get(position1[2])))
				|| (token.equals(tokenMap.get(position2[0]))
						&& token.equals(tokenMap.get(position2[1])) && token
							.equals(tokenMap.get(position2[2])))
				|| (token.equals(tokenMap.get(position3[0]))
						&& token.equals(tokenMap.get(position3[1])) && token
							.equals(tokenMap.get(position3[2])))) {

			count++;

		}
		return count;
	}
	
/*	public void evaluateGameState(Position current, Token token,
			Map<Position, Token> tokenMap){
		int row = current.getRow();
		int column = current.getColumn();
		topPosition = current.top();
		bottomPosition = current.bottom();
		bottomBottomPostion = current.bottom();
		
		
		WinScenario immediateVerticalWin = new WinScenario(top, current, bottom);
		WinScenario topVerticalWin = new WinScenario(new Position(row, column),
				new Position(row + 1, column), new Position(row + 2, column));
		WinScenario bottomVerticalWin = new WinScenario(new Position(row, column),
				new Position(row + 1, column), new Position(row + 2, column));
		
		
		for(WinScenario winScenario : scenarios){
			if(winScenario.hasWon()) {
				notifyGameWin();
				break;
			}
		}
		
	}*/

	public int evaluateSurroundingRows(Position position, Token token,
			Map<Position, Token> tokenMap) {
		
		int row = position.getRow();
		int column = position.getColumn();
		Position[] position1 = { new Position(row, column),
				new Position(row + 1, column), new Position(row + 2, column) };
		Position[] position2 = { new Position(row, column),
				new Position(row - 1, column), new Position(row + 1, column) };
		Position[] position3 = { new Position(row, column),
				new Position(row - 2, column), new Position(row - 1, column) };

		if ((token.equals(tokenMap.get(position1[0]))
				&& token.equals(tokenMap.get(position1[1])) && token
					.equals(tokenMap.get(position1[2])))
				|| (token.equals(tokenMap.get(position2[0]))
						&& token.equals(tokenMap.get(position2[1])) && token
							.equals(tokenMap.get(position2[2])))
				|| (token.equals(tokenMap.get(position3[0]))
						&& token.equals(tokenMap.get(position3[1])) && token
							.equals(tokenMap.get(position3[2])))) {

			count++;

		}
		return count;
	}

	public int evaluateSurroundingRightDiagnolPositions(Position position,
			Token token, Map<Position, Token> tokenMap) {
		int row = position.getRow();
		int column = position.getColumn();
		Position[] position1 = { new Position(row, column),
				new Position(row - 1, column + 1),
				new Position(row - 2, column + 2) };
		Position[] position2 = { new Position(row, column),
				new Position(row - 1, column + 1),
				new Position(row + 1, column - 1) };
		Position[] position3 = { new Position(row, column),
				new Position(row + 1, column - 1),
				new Position(row + 2, column - 2) };

		if ((token.equals(tokenMap.get(position1[0]))
				&& token.equals(tokenMap.get(position1[1])) && token
					.equals(tokenMap.get(position1[2])))
				|| (token.equals(tokenMap.get(position2[0]))
						&& token.equals(tokenMap.get(position2[1])) && token
							.equals(tokenMap.get(position2[2])))
				|| (token.equals(tokenMap.get(position3[0]))
						&& token.equals(tokenMap.get(position3[1])) && token
							.equals(tokenMap.get(position3[2])))) {

			count++;

		}
		return count;
	}

	public int evaluateSurroundingLeftDiagnolPositions(Position position,
			Token token, Map<Position, Token> tokenMap) {
		int row = position.getRow();
		int column = position.getColumn();
		Position[] position1 = { new Position(row, column),
				new Position(row - 1, column - 1),
				new Position(row - 2, column - 2) };
		Position[] position2 = { new Position(row, column),
				new Position(row - 1, column - 1),
				new Position(row + 1, column + 1) };
		Position[] position3 = { new Position(row, column),
				new Position(row + 1, column + 1),
				new Position(row + 2, column + 2) };

		if ((token.equals(tokenMap.get(position1[0]))
				&& token.equals(tokenMap.get(position1[1])) && token
					.equals(tokenMap.get(position1[2])))
				|| (token.equals(tokenMap.get(position2[0]))
						&& token.equals(tokenMap.get(position2[1])) && token
							.equals(tokenMap.get(position2[2])))
				|| (token.equals(tokenMap.get(position3[0]))
						&& token.equals(tokenMap.get(position3[1])) && token
							.equals(tokenMap.get(position3[2])))) {

			count++;

		}
		return count;
	}
}
