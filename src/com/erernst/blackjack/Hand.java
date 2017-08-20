package com.erernst.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand = new ArrayList<Card>(0);

	public void addCard(Card card) {
		hand.add(card);
	}
	public int getCardsInHand() {
		int tVal=0;
		for (Card card : hand) {
			System.out.print(card);
			System.out.print("\t\t");
			tVal = card.getValue()+ tVal;
		}
		System.out.println("Hand Value: " + tVal);
		
		return tVal;
		}
		
	
	private int getValueOfHand() {
		return 0;
		
	}

}
