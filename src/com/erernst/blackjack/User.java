package com.erernst.blackjack;

import java.util.Scanner;

public class User extends Player {



	public User(String name, Hand hand, double wallet) {
		super(name, hand, wallet);}
		
		public String getName(Scanner keyb) {
			String name = keyb.next();
			return name;
		}
		
	}
	

