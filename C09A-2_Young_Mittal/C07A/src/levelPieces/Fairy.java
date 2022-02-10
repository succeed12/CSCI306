// Author: David Young
package levelPieces;

import java.lang.Math;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable; 
import gameEngine.Player;

public class Fairy extends GamePiece implements Moveable {
	
	// variable(s) to track Fairy status
	private int location = 19;
	
	public Fairy() {
		super('F', "Fairy", 19);
	}
	
	// test if place on board is empty
	public boolean isLocationEmpty(Drawable[] gameBoard, int location) {
		return gameBoard[location] == null;
	}
	
	// if you need to reset level
	public void resetLevel(int location) {
		this.location = 19;
	}
	
	// return location for updating
	public int getLocation() {
		return location;
	}
	
	// interaction status
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (this.location == playerLocation) {
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}
	
	// determining place on the game board:
	// This movement makes the Fairy land on random empty spaces on the game board
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[this.location] = null;
		int min = 1;
		int max = GameEngine.BOARD_SIZE;
		int IntValue;
		while (true) {
			IntValue = (int)(Math.random() * (max - min) + min);
			// System.out.println("IntValue: " + IntValue);
			if (isLocationEmpty(gameBoard, IntValue) && IntValue != playerLocation) {
				break;
			}
		}
		this.location = IntValue;

		gameBoard[this.location] = this;
			
	}
	
	// print character
	@Override
	public void draw() {
		System.out.print(symbol);
	}
}
