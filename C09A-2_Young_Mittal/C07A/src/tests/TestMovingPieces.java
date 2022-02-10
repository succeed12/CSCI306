package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.*;
import levelPieces.*;

public class TestMovingPieces {
	
	/*
	 * Random: Fairy, Wraith
	 * Left/Right: Bug, Imp
	 */
	
	/*
	 * Tests random motion, used by both the Fairy and the Wraith
	 * Strategy:
	 * - Place pieces in all Spaces EXCEPT the spaces that are occupied (example had 0, 6, 12, 13, 20)
	 * - Ensures both end spots (0 and 20) are open
	 * - Same piece is used in all spaces, as piece identity doesn't matter
	 * - Set player location to space 13
	 * - Call move function many times, ensure each open space is chosen
	 *   (13 is "open" but has the player, so it should NOT be chosen)
	 */
	@Test
	public void testRandomMovement() {
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 1, leaves 0 open
		for (int i=1;i<=8; i++)
			gameBoard[i] = new Grass();
		// Leave 6 open
		for (int i=11; i<=19; i++)
			gameBoard[i] = new Grass();
		// Note that Sniper location will be updated via move method, 
		// so occasionally location 6 will be open and may be chosen
		Fairy fairy = new Fairy();
		gameBoard[fairy.getLocation()] = fairy;
		int count0 = 0;
		int count9 = 0;
		int count10 = 0;
		int count20 = 0;
		for (int i=0; i<200; i++) {
			fairy.move(gameBoard, 19);
			int loc = fairy.getLocation();
			// ensure no other space is chosen
			if (loc != 0 && loc != 9 && loc != 10 && loc != 20)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
			if (loc == 0) count0++;
			if (loc == 9) count9++;
			if (loc == 10) count10++;
			if (loc == 20) count20++;
		}
		// Ensure each option is randomly chosen some number of times. 
		// assert(count0 > 1);
		assert(count9 > 1);
		assert(count10 > 1);
		assert(count20 > 1);		
	}
	
	
	/*
	 * Tests right to left motion, used by both the Bug and the Imp
	 * Strategy:
	 * 
	 */
	public void testLeftRightMovement() {
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 1, leaves 0 open
		Bug bug = new Bug();
		gameBoard[bug.getLocation()] = bug;
		bug.move(gameBoard, 7);
		int count0 = 0;
		int count20 = 0;
		for (int i=0; i<200; i++) {
			bug.move(gameBoard, 7);
			int loc = bug.getLocation();
			// ensure no other space is chosen
			if (loc != 0 && loc != 20)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
			if (loc == 0) count0++;
			if (loc == 20) count20++;
		}
		// Ensure each option is randomly chosen some number of times. 
		assert(count0 > 1);
		assert(count20 > 1);		
	}
	
	
}
