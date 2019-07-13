package com.phonepe.bowling.bowlingalley;

import java.util.Scanner;

import com.phonepe.bowling.bowlingalley.game.BowlingGame;

//@SpringBootApplication
public class BowlingAlleyApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of sets:");
		int totalSets = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Number of players:");
		int numPlayers = sc.nextInt();
		sc.nextLine();
		
		
		String[] players = new String[numPlayers];
		System.out.println("Enter first player name:");
		for(int i = 0;i<numPlayers;i++){
			if(i != 0)System.out.println("Enter Next player name:");
			players[i] = sc.nextLine();
		}
		
//		int totalSets = 3;
//		String[] players = {"Alex", "Joy"};
		
		BowlingGame game = new BowlingGame(totalSets,players);
		game.play();
//		sc.close();
		
	}

}
