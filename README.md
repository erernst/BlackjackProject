## Blackjack Project

### Erik Ernst 08/21/2017

#### Overview
This project is a command-line blackjack game. You have most the capabilities of blackjack. You can bet, hit, stay, and double down. You can not split at this point. Aces are treated as 11s and 1s.

#### Basic Operation
Disclaimer *THIS CASINO DOES NOT USE 50 CENT CHIPS AND ONLY WORKS IN WHOLE DOLLARS*

The player is asked their name, and how much they would like to buy in for. They are then dealt a hand along with the dealer. The game runs the blackjack checks. If neither person has blackjack, the player is given an option to hit, stay or double. 

If the player hits the process continues until they decide to stay. If the player doubles their wager is doubled up to the amount they have in their wallet. At this point they receive 1 card and the dealer gets their turn.

At the end it runs the winner checks and pays out or takes the bet as dictated by the situation. 

The player is then offered to continue this process.

#### Objectives  Met
* Create a class structure that mimics a deck of cards. Remember decks as well as a hand of cards are made up of cards. Feel free to create the structure in any way you see fit. hint We did a lab in Chapter 6 of this week that dealt with a deck of cards. Your card and deck implementations should NOT be coupled to Blackjack; you should be able to reuse them to implement a poker or bridge game application.


* Add methods and fields to your classes that mimic the functionality of shuffling and dealing a deck of cards. Remember that when a card is dealt you have to remove it from the current deck! You should be able to print out a shuffled deck to the terminal.


* Deal two hands of cards - one to a Dealer and another to a Player. Allow the players to Hit (add cards to their hand) or Stay (not add cards to their hand) in accordance to the rules of blackjack shown in the wiki. Do not worry about the multiple values for Ace until your basic game logic is working. Assume they are either 1 or 11 to start.


* Implement the remaining rules of blackjack so you can determine a winner of each round.

#### Stretch Goals Met:

* Implement a monetary system so players can place bets on their hands.

* Allow players to double down.

* Deal from a multi-deck shoe.