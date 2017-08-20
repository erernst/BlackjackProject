package com.erernst.blackjack;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner keyb = new Scanner(System.in);
		System.out.println("Welcome to BlackJack, a game of skill and chance.");
		System.out.print("What is your first name: ");
		Hand hp = new Hand();
		Player user = new User(null, hp, 0);
		user.getName();
		System.out.print("How Much would you like to buy in for: $");
		user.getWallet();
		Hand hd = new Hand();
		Player chance = new Dealer("Chance", hd, 100_000d);
		Deck deck = new Deck();
		deck.generateDeck();
		Card d = null;
		for (int i = 0; i < 2; i++) {
			Card p = deck.dealCard();
			hp.addCard(p);
			d = deck.dealCard();
			hd.addCard(d);
		}
		System.out.println(deck.cardsLeft());
		int playVal = hp.getCardsInHand();
		System.out.println("Dealer is showing a " + d.getSuit() + "\t" + d.getRank());
		int dCheck = d.getValue();
		if (playVal == 21 && dCheck != 10 && dCheck == (11)) {
			System.out.println("Black Jack! ");
		} else if (playVal == 21 && (dCheck == 10)) {
			System.out.println("You have 21... dealer checks their cards...  ");
			if (hd.getCardsInHand() == 21) {
				System.out.println("Sorry the dealer also has 21. Its a push");
			} else {
				System.out.println("The dealer does not have 21! BlackJack!");
			}
		} else if (playVal == 21 && (dCheck == 11)) {
			System.out.println("You have 21... dealer has an Ace would you like even money?...  ");
			if (hd.getCardsInHand() == 21) {
				System.out.println("Sorry the dealer also has 21. You lose");
			} else {
				System.out.println("The dealer does not have 21! BlackJack!");
			}

		} else if (playVal < 21 && (dCheck == 11 || dCheck == 10)) {
			System.out.println("Dealer checks cards...");
			if (hd.getCardsInHand() == 21) {
				System.out.println("Sorry the dealer has 21. You lose");
			} else {
				System.out.println("The dealer does not have 21.");
				hitOrStay(deck, hp, keyb);
			}

		}

		else {
			hitOrStay(deck, hp, keyb);
		}

	}

	private static void hitOrStay(Deck deck, Hand hand, Scanner keyb) {
		System.out.println("[H]it or [S]tay?");
		String choice = keyb.next().toUpperCase();
		switch (choice) {
		case "H":
			Card p = deck.dealCard();
			hand.addCard(p);
			if (bustCheck(hand) == 1) {
				break;
			} else {
				hitOrStay(deck, hand, keyb);
				if (bustCheck(hand) == 1) {
					break;
				}
			}
		case "S":
			break;
		default:
			System.out.println("You stay with: " );
			hand.getCardsInHand();
		}

	}

	private static int bustCheck(Hand hand) {
		if (hand.getCardsInHand() > 21) {
			System.out.println("Bust! you have more than 21");
			return 1;
		}
		return 0;
	}
}
