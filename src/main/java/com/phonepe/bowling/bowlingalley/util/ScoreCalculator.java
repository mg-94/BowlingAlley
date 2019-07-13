package com.phonepe.bowling.bowlingalley.util;

import java.util.Scanner;

import com.phonepe.bowling.bowlingalley.model.Player;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ScoreCalculator {

	int totalSet;
	Scanner sc = new Scanner(System.in);
	public ScoreCalculator(int totalSet) {
		super();
		this.totalSet = totalSet;
	}

	public void calculate(Player curPlayer, int currentSet) {
		
		int totScore = 0;
		
		if (isLastSet(currentSet)) {
			int chanceCount = 1;
			while (curPlayer.getChancesRemaining() > 0) {
				System.out.println("Enter hit for player: "+ curPlayer.getName());
				String currentHit = sc.nextLine();
				curPlayer.appendToStrikeHistory(currentHit);

				if (currentHit.equals("x")) {
					totScore += 20;
					curPlayer.setChancesRemaining(curPlayer.getChancesRemaining() - 1);
					chanceCount++;
				} else if (currentHit.equals("/")) {

					totScore  = 15;
					int remainingChances = curPlayer.getChancesRemaining();
					remainingChances--;
					chanceCount++;
//					if (remainingChances != 1 && chanceCount) {
//						remainingChances--;
//						chanceCount = false;
//					}				
//					else if(remainingChances == 1 && !chanceCount) {
//						
//					}
					
//					if(chanceCount == 2)

					curPlayer.setChancesRemaining(remainingChances);
				} else {
					int hits = Integer.parseInt(currentHit);
					chanceCount++;
					totScore += hits;
					curPlayer.setChancesRemaining(curPlayer.getChancesRemaining() - 1);
				}
			}
		} else {

			while (curPlayer.getChancesRemaining() > 0) {
				System.out.println("Enter hit for player: "+ curPlayer.getName());
				String currentHit = sc.nextLine();
				curPlayer.appendToStrikeHistory(currentHit);

				if (currentHit.equals("x")) {
					totScore += 20;
					curPlayer.setChancesRemaining(0);
				} else if (currentHit.equals("/")) {

					totScore = 15;
					curPlayer.setChancesRemaining(0);
				} else {
					int hits = Integer.parseInt(currentHit);
					totScore += hits;
					curPlayer.setChancesRemaining(curPlayer.getChancesRemaining() - 1);
				}
			}

		}
		curPlayer.setChancesRemaining(2);
		curPlayer.setScore(curPlayer.getScore()+totScore);
//		sc.close();
	}

	private boolean isLastSet(int currentSet) {
		return currentSet == totalSet;
	}

}
