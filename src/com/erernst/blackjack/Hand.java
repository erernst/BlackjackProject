package com.erernst.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand = new ArrayList<Card>(0);

	public void addCard(Card card) {
		hand.add(card);
	}

	public int getCardsInHand() {
		int tVal = 0;
		for (Card card : hand) {
			System.out.println(card);
			tVal = card.getValue() + tVal;

		}
		if (tVal > 21) {
			ace: for (Card card : hand) {
				if (card.getValue() == 11) {
					card.setValue(1);
					tVal = tVal - 10;
					break ace;
				} else {
					continue ace;

				}
			}
		}

		System.out.println("Hand Value: " + tVal);
		System.out.println();
		return tVal;
	}

	public int softCheck() {
		int soft = 0;
		ace: for (Card card : hand) {
			if (card.getValue() == 11) {
				soft = 1;

				break ace;
			} else {
				continue ace;

			}
		}
		return soft;
	}

	public int getValueOfHand() {
		int tVal = 0;
		for (Card card : hand) {
			tVal = card.getValue() + tVal;
		}
		if (tVal > 21) {
			ace: for (Card card : hand) {
				if (card.getValue() == 11) {
					card.setValue(1);
					tVal = tVal - 10;
					break ace;
				} else {
					continue ace;
				}
			}
		}

		return tVal;

	}

	public int cardsInHand() {
		int size = hand.size();
		return size;
	}

}
