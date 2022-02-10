/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.*;
import levelPieces.*;


/**
 * @author davidyoung
 *
 */
public class TestInteractions {
	
	/*
	 * HIT, KILL, ADVANCE, GET_POINT, NONE
	 *
	 * HIT : Imp (bumblebee)
	 * KILL : Wraith
	 * ADVANCE : Fairy
	 * GET_POINT : Castle
	 * NONE : Bug
	 */
	
	/*
	 * Test that Imp hits player (interaction) only when player is on same location
	 */
	
	@Test
	public void testImp() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Imp imp = new Imp();
		gameBoard[imp.getLocation()] = imp;
		// Hit points if player on same space
		assertEquals(InteractionResult.HIT, imp.interact(gameBoard, 1));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<1; i++)
			assertEquals(InteractionResult.NONE, imp.interact(gameBoard, i));
		for (int i=2; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, imp.interact(gameBoard, i));		
	}

	
	/*
	 * Test that Wraith kills player (interaction) only when player within 2 blocks
	 */
	public void testWraith() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Wraith wraith = new Wraith();
		gameBoard[wraith.getLocation()] = wraith;
		// Hit points if player on same space
		assertEquals(InteractionResult.KILL, wraith.interact(gameBoard, 5));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<5; i++)
			assertEquals(InteractionResult.NONE, wraith.interact(gameBoard, i));
		for (int i=6; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, wraith.interact(gameBoard, i));		
	}
	
	/*
	 * Test that Fairy advances player (interaction) only when player is on same location
	 */
	public void testFairy() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Fairy fairy = new Fairy();
		gameBoard[fairy.getLocation()] = fairy;
		// Hit points if player on same space
		assertEquals(InteractionResult.ADVANCE, fairy.interact(gameBoard, 19));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<19; i++)
			assertEquals(InteractionResult.NONE, fairy.interact(gameBoard, i));
		for (int i=20; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, fairy.interact(gameBoard, i));		
	}
	
	/*
	 * Test that Castle gives point to player (interaction) only when player is on same location 
	 */
	public void testCastle() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Castle castleOne = new Castle(20);
		gameBoard[20] = castleOne;
		Castle castleTwo = new Castle(2);
		gameBoard[2] = castleTwo;
		// Hit points if player on same space
		assertEquals(InteractionResult.ADVANCE, castleOne.interact(gameBoard, 20));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<20; i++)
			assertEquals(InteractionResult.NONE, castleOne.interact(gameBoard, i));
		for (int i=21; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, castleOne.interact(gameBoard, i));	
		
		assertEquals(InteractionResult.ADVANCE, castleTwo.interact(gameBoard, 2));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<2; i++)
			assertEquals(InteractionResult.NONE, castleTwo.interact(gameBoard, i));
		for (int i=3; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, castleTwo.interact(gameBoard, i));		
	}
	
	/*
	 * Test that Bug does nothing to player (interaction) only when player is on same location
	 */
	public void testBug() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Bug bug = new Bug();
		gameBoard[bug.getLocation()] = bug;
		// Hit points if player on same space
		assertEquals(InteractionResult.ADVANCE, bug.interact(gameBoard, 20));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<20; i++)
			assertEquals(InteractionResult.NONE, bug.interact(gameBoard, i));
		for (int i=21; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, bug.interact(gameBoard, i));	
	
	}
	
}
