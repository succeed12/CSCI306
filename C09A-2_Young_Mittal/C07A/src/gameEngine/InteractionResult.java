package gameEngine;

/**
 * Interacting with a game piece must yield one of these results.
 * 
 * @author Mark Baldwin
 * @author Cyndi Rader
 * 
 */
public enum InteractionResult {
	HIT, KILL, ADVANCE, GET_POINT, NONE;
	
	// HIT : Imp
	// KILL : Ghoul
	// ADVANCE : Fairy
	// GET_POINT : Castle
	// NONE : Bug
}
