// Author: David Young
package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Grass implements Drawable {
	
	public Grass() {
		// TODO: Constructor
	}
	
	// variables tracking Grass status
	private int location = 9;
	private String symbol = "G";
	
	// if you need to reset level
	public void resetLevel(int location) {
		this.location = 9;
	}

	// return location for updating:
	// Doesn't really need updating since it's not Moveable
	public int getLocation() {
		return location;
	}
	
	// draw character on board
	public void draw() {
		System.out.print(symbol);
	}
	
}
