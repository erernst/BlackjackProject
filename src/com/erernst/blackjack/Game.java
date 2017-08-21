package com.erernst.blackjack;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner keyb = new Scanner(System.in);
		gameLogic(keyb);
		keyb.close();
	}

	private static int bustCheck(Hand hand) {
		if (hand.getCardsInHand() > 21) {
			System.out.println("Bust! you have more than 21");
			return 1;
		}
		return 0;
	}

	private static int outcome(Hand hp, Hand hd, int wager) {
		System.out.println("Player has: ");
		int p = hp.getCardsInHand();
		System.out.println("Dealer has: ");
		int d = hd.getCardsInHand();
		int roi = 0;
		if (p == d && p < 21) {
			System.out.println("Push.");
			roi = 0;
		} else if (p < d && d <= 21) {
			System.out.println("Dealer wins.");
			roi = -wager;
		} else if (p > d && p <= 21) {
			System.out.println("Player wins!");
			roi = wager;
		} else if (p > 21) {
			System.out.println("Player busted. Dealer wins!");
			roi = -wager;
		} else if (d > 21) {
			System.out.println("Dealer busted. Player wins!");
			roi = wager;
		}
		return roi;
	}

	private static void gameLogic(Scanner keyb) {

		System.out.println("Welcome to BlackJack, a game of skill and chance.");
		System.out.println("At this casino, we work in whole dollars, all 50 cent winnings will be rounded down.");
		System.out.print("What is your first name: ");
		String name = keyb.next();
		System.out.print("How much would you like to buy in for: $");
		int buyN = getInt(keyb);
		Hand hp = new Hand();
		Player player = new Player(name, hp, buyN);
		Hand hd = new Hand();
		Player chance = new Dealer("Chance", hd, 100_000d);
		Deck deck = new Deck();
		for(int i = 0; i<6; i++) {
		deck.generateDeck();}
		play: while (deck.cardsLeft() > 12 && player.getWallet() > 0) {
			if (deck.cardsLeft()<=24) {
				System.out.println("Cards low, new deck.");
				deck.emptyDeck();
				for (int i = 0; i < 6; i++) {
					deck.generateDeck();}
			}
			System.out.println("");
			int wager = wager(keyb, (int) player.getWallet());
			Card d = null;
			hd = new Hand();
			hp = new Hand();
			for (int i = 0; i < 2; i++) {
				Card p = deck.dealCard();
				hp.addCard(p);
				d = deck.dealCard();
				hd.addCard(d);
			}
			System.out.println("");
			System.out.println("You are dealt:");
			int playVal = hp.getCardsInHand();
			
			System.out.println("Dealer is showing a(n) " + d.getRank() + " of " + d.getSuit());
			int dCheck = d.getValue();
			int pbj = 0;
			if (playVal == 21 && dCheck != 10 && dCheck != (11)) {
				System.out.println("Black Jack! ");
				player.setWallet(player.getWallet() + (int)(wager * .5));
				pbj = 1;
			} else if (playVal == 21 && (dCheck == 10)) {
				System.out.println("You have 21... dealer checks their cards...  ");
				if (hd.getValueOfHand() == 21) {
					System.out.println("Sorry the dealer also has 21. Its a push");
				} else {
					System.out.println("The dealer does not have 21! BlackJack!");
					player.setWallet(player.getWallet() + (int)(wager * .5));
					pbj = 1;
				}
			} else if (playVal == 21 && (dCheck == 11)) {
				System.out.println("You have 21... dealer has an Ace would you like even money?...  ");
				if (hd.getValueOfHand() == 21) {
					System.out.println("Sorry the dealer also has 21. You push.");
				} else {
					System.out.println("The dealer does not have 21! BlackJack!");
					player.setWallet(player.getWallet() + (int)(wager * .5));
					pbj = 1;
				}

			} else if (playVal < 21 && (dCheck == 11 || dCheck == 10)) {
				System.out.println("Dealer checks cards...");
				if (hd.getValueOfHand() == 21) {
					System.out.println("Sorry the dealer has 21. You lose");

				} else {
					System.out.println("The dealer does not have 21.");
					wager = hitOrStay(deck, hp, player, wager, keyb);
				}

			}

			else {
				wager = hitOrStay(deck, hp, player, wager, keyb);
			}
			if (hp.getValueOfHand() <= 21 && pbj < 1) {
				int s = hd.softCheck();
				chance.hitOrStay(deck, hd, s);
			}
			System.out.println();
			player.setWallet(outcome(hp, hd, wager) + player.getWallet());
			cont: while (player.getWallet()>=5) {
				System.out.println(
						"You now have $" + player.getWallet() + ". Would you like to keep playing [Y] or [N]? ");
				String cont = keyb.next().toUpperCase();
				switch (cont) {
				case "Y":
					continue play;
				case "N":
					break play;
				default:
					System.out.println("Invalid entry.");
					continue cont;
				}
			}
			
				
		
		if (player.getWallet() < 5) {
			System.out.println(
					"You only have $" + player.getWallet() + " left in chips, this is not enough for table minimum.");
				break play;
		} else if (player.getWallet() == 0) {
			System.out.println("You are out of chips.");
			break play;
		} else if (player.getWallet() > 5) {
			System.out.println("You leave the table with $" + player.getWallet());
			break play;
		}}

	}

	private static int hitOrStay(Deck deck, Hand hand, Player player, int wager, Scanner keyb) {
		System.out.println("");
		String c = (hand.cardsInHand() > 2 ? "[H]it or [S]tay" : "[H]it or [S]tay or [D]ouble?");
		System.out.println(c);
		String choice = keyb.next().toUpperCase();
		switch (choice) {
		case "H":
			Card p = deck.dealCard();
			System.out.println("You draw a(n) " + p);
			hand.addCard(p);
			if (bustCheck(hand) == 1) {
				break;
			} else {
				wager = hitOrStay(deck, hand, player, wager, keyb);

			}
		case "S":
			break;
		case "D":
			if (hand.cardsInHand() > 2) {
				System.out.println("Invalid entry.");
				wager = hitOrStay(deck, hand, player, wager, keyb);
				break;
			}
			if ((wager * 2 <= (int) player.getWallet())) {
				wager = wager * 2;
				System.out.println("You double down. Your bet is now: $" + wager);
				Card pd = deck.dealCard();
				System.out.println("You draw a(n) " + pd);
				hand.addCard(pd);
				break;
			}
			if (wager * 2 > player.getWallet()) {
				dchoice: while (true) {
					System.out.println("Player only has " + player.getWallet());
					System.out.println("Does player wish to double down for less [Y] or [N]?");
					String opt = keyb.next().toUpperCase();
					switch (opt) {
					case "Y":
						wager = player.getWallet();
						System.out.println("You double down. Your bet is now: $" + wager);
						Card pd = deck.dealCard();
						System.out.println("You draw a(n) " + pd);
						hand.addCard(pd);
						break dchoice;
					case "N":
						wager = hitOrStay(deck, hand, player, wager, keyb);
						break dchoice;
					default:
						System.out.println("Invalid entry.");
						continue dchoice;
					}
				}break;
			}
		default:
			System.out.println("Invalid entry.");
			wager = hitOrStay(deck, hand, player, wager, keyb);
			break;
		}
		System.out.println("");
		return wager;

	}

	private static int wager(Scanner keyb, int wallet) {
		System.out.println("You have $" + wallet + " in chips.");
		System.out.print("What is your wager: $");
		int wager = getInt(keyb);
		if (wager < 5) {
			System.out.println("Table minimum is $5");
			wager=5;
		} else if (wager > 500) {
			System.out.println("Table maximum is $500");
			wager(keyb, wallet);
		} else if (wager > wallet) {
			System.out.println("Sorry, you only have " + wallet + " to bet.");
			wager = wallet;
		}
		return wager;

	}
	static int getInt(Scanner keyb) {
		int temp = 0;
		while (!keyb.hasNextInt()) {
			System.out.print("Invalid Entry. Use whole numbers only: "); // notifies user of invalid entry
			keyb.next();
		}
		temp = keyb.nextInt();
		if (temp < 0) {
			System.err.print("Invalid Entry. Please make a valid entry:");
			temp = getInt(keyb);
		}
		return temp;
	}

}
