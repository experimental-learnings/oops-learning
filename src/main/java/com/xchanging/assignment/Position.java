package com.xchanging.assignment;

public class Position {
	private int position;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (position != other.position)
			return false;
		return true;
	}

	public Position() {

	}

	public Position(int position) {
		this.position = position;
	}

	public int getNewPosition(int currentPosition, int diceOutcome) {

		currentPosition += diceOutcome;

		return currentPosition;
	}

}
