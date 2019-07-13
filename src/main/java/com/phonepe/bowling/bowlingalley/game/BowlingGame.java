package com.phonepe.bowling.bowlingalley.game;

import java.util.LinkedList;
import java.util.Queue;

import com.phonepe.bowling.bowlingalley.model.Player;
import com.phonepe.bowling.bowlingalley.util.ScoreCalculator;

public class BowlingGame {
	private int totalSet;
	private int currentSet = 1;
	private int totalPlayers;
	private ScoreCalculator scoreCalculator;
	Queue<Player> players = new LinkedList<>();

	public BowlingGame(int totalSet, String[] playerNames) {
		super();
		this.totalSet = totalSet;
		this.totalPlayers = playerNames.length;
		this.scoreCalculator = new ScoreCalculator(totalSet);
		addPlayersToQueue(playerNames);
	}

	public void play() {

		while (isGameLeft()) {
			int playerLeft = totalPlayers;
			while (playerLeft > 0) {
				Player curPlayer = players.poll();

				scoreCalculator.calculate(curPlayer, currentSet);

				players.add(curPlayer);
				playerLeft--;
			}

			printScoreBoard();
			currentSet++;
		}

		printFinalResult();

	}

	private void printFinalResult() {
		Player winner = findWinner();
//		System.out.printf("%s is the winner with %x score", winner.getName(), winner.getScore());
		System.out.println(winner.getName() + " is the winner with "+winner.getScore() + " score");
	}

	private void printScoreBoard() {
		System.out.println("ScoreBoard:");
		int playerLeft = totalPlayers;
		while (playerLeft > 0) {
			Player curPlayer = getCurrentPlayer();
//			System.out.printf("%s: %s -> %d \n", curPlayer.getName(), curPlayer.getStrikeHistory(),	curPlayer.getScore());
			System.out.println(curPlayer.getName()+": "+ curPlayer.getStrikeHistory()+"->"+	curPlayer.getScore());
			playerLeft--;
		}

	}

	private Player getCurrentPlayer() {
		Player curPlayer = players.poll();
		players.add(curPlayer);
		return curPlayer;
	}

	private boolean isGameLeft() {
		return currentSet <= totalSet;
	}

	private Player findWinner() {

		Player winner = players.poll();
		while (!players.isEmpty()) {
			Player curPlayer = players.poll();
			if (winner.getScore() < curPlayer.getScore())
				winner = curPlayer;
		}
		return winner;

	}

	private void addPlayersToQueue(String[] playerNames) {
		for (String name : playerNames) {
			players.add(new Player(name));
		}
	}

}
