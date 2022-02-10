// Author: David Young
package levelPieces;

import java.lang.Math;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable; 
import gameEngine.Player;
import gameEngine.Player.PlayerStatus;

public class Imp extends GamePiece implements Moveable {
	
	// variable(s) to track Imp status
	private int location = 1;
	private boolean rightDir = true;
	
	public Imp() {
		super('I', "Imp", 1);
	}
	
	// test if place on board is empty
	public boolean isLocationEmpty(Drawable[] gameBoard, int location) {
		return gameBoard[location] == null;
	}
	
	// if you need to reset level
	public void resetLevel(int location) {
		this.location = 1;
	}
	
	// return location for updating
	public int getLocation() {
		return location;
	}
	
	// interaction status
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (this.location == playerLocation) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
	
	// determining place on the game board:
	// This movement makes the Imp skip spaces and run left and right
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int increment = 0;
		gameBoard[this.location] = null;
		// hit the end of the board
		if (this.location == GameEngine.BOARD_SIZE - 1) {
			increment = -2;
			rightDir = false;
		}
		// hit the beginning of the board
		else if (this.location == 0) {
			this.location += 2;
			rightDir = true;
		}
		// moving right
		else if (rightDir) {
			if (this.location + 1 == GameEngine.BOARD_SIZE - 1) {
				increment = 1;
			} else {
				increment = 2;
			}
		}
		// moving left
		else {
			if (this.location - 1 == 0) {
				increment = -1;
			} else {
				increment = -2;
			}
		}
		// check that this game piece didn't land on another game piece or the player 
		if (isLocationEmpty(gameBoard, this.location + increment) && this.location + increment != playerLocation) {
			this.location += increment;
		// game piece move was not empty so start at the beginning for the first available empty slot
		} else {
			for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
				if (isLocationEmpty(gameBoard, i)) {
					this.location = i;
					break;
				}
			}
		}		
		gameBoard[this.location] = this;
	}
	
	@Override
	public void draw() {
		System.out.print(symbol);
	}
}
