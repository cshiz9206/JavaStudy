package HangmanGame;

import java.util.Scanner;

public abstract class AbsHangmanGame {
	protected Scanner sc;
	protected String answer;
	protected boolean[] isBlank;
	protected int count, max;
	protected char input;
	
	protected abstract void intro();
	protected abstract void print();
	protected abstract void guess();
	protected abstract void check();
	protected abstract boolean gameEnd();
	
	protected void play() {
		intro();
		print();
		while (true) {
			guess();
			check();
			print();
			if(gameEnd())
				break;
		}
	}
}
