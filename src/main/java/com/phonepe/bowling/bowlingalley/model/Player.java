package com.phonepe.bowling.bowlingalley.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
	private String name;
	private int score;
	private int chancesRemaining;
	private StringBuilder strikeHistory;
	
	
	public Player(String name) {
		super();
		this.name = name;
		this.score = 0;
		this.chancesRemaining = 2;
		strikeHistory  = new StringBuilder();
	}
	
	public void appendToStrikeHistory(String currentStrike) {
		strikeHistory.append(currentStrike);
	}
	
	public String getStrikeHistory() {
		return strikeHistory.toString();
	}
}
