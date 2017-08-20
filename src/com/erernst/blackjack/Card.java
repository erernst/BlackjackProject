package com.erernst.blackjack;

public class Card {
	private Suit suit;
	private int value;
	private Rank rank;
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Card(Suit suit, Rank rank, int value) {
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(suit);
		builder.append("\t");
		builder.append(rank);
		return builder.toString();
	}
	public Card(Suit s, Rank r) {
		super();
		this.suit = s;
		this.rank = r;
		this.value = rank.getValue();
	}
	
}

