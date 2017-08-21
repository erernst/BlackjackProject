package com.erernst.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class Deck {
	private List<Card> deck = new ArrayList<Card>(52);
	private int numDealt;

	public Card dealCard() { 
		Card c = deck.remove(0);
		
		
		return c;
	}
	
	public void CardCheck() {
		int i =1;
		  for (Card card : deck) {
	            System.out.println(i + ":" + card);
	            i++;
	        }
	}
	public void emptyDeck() {
		deck.clear();
	}
	public void generateDeck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(s, r));
			}
		}
		shuffleDeck(deck);	
//        for (Card card : deck) {
//            System.out.println(card);
//        }

	}

	private void shuffleDeck(List<Card> deck) {
		Collections.shuffle(deck);
	}

	public int cardsLeft() {
		return deck.size();
	}
	
}
