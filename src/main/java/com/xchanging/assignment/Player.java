package com.xchanging.assignment;

public class Player {
	String currentPlayer;

	public Player(String player) {
		this.currentPlayer = player;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currentPlayer == null) ? 0 : currentPlayer.hashCode());
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
		Player other = (Player) obj;
		if (currentPlayer == null) {
			if (other.currentPlayer != null)
				return false;
		} else if (!currentPlayer.equals(other.currentPlayer))
			return false;
		return true;
	}

	public String toString() {
		return currentPlayer;
	}

}
