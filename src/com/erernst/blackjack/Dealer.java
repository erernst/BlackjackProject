package com.erernst.blackjack;

import java.util.Iterator;

public class Dealer extends Player {
	Hand hand;

	public Dealer(String name, Hand hand, Double wallet) {
		super(name, hand, wallet);

	}

	public void hitOrStay(Deck deck, Hand hand, int s) {
		System.out.println("Dealers cards:");
		int move = hand.getCardsInHand();
		

		if (move < 17) {
			System.out.println("Dealer has " + move + ", dealer hits.");
			Card d = deck.dealCard();
			hand.addCard(d);
			System.out.println("Dealer draws: " + d);
			hitOrStay(deck, hand, s);

		} else if (move == 17 && s == 1) {
			System.out.println("Dealer has a soft 17, dealer hits.");
			Card d = deck.dealCard();
			hand.addCard(d);
			System.out.println("Dealer draws: " + d);
			hitOrStay(deck, hand, s);
		} else if ((move > 17 && move < 22) || (move == 17 && s == 0)) {
			System.out.println("Dealer has " + move + ", dealer stays.");
		} else if (move > 21) {
			System.out.println("Dealer busted.");
		}

		// private Hand dealHand(){
		// Hand userHand = new Hand();
		// for (int i = 0; i < 2; i++) {
		// Card p = deck.dealCard();
		// System.out.println("You are dealt a " + p);
		// Card d = deck.dealCard();
		// userHand.addCard(p);
		// hand.addCard(d);
		// System.out.println("Dealer is dealt a " + d);}
		// return userHand;
		// }

	}
}
