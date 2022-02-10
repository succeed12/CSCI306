//author: Eshita Mittal
package levelPieces;

import java.lang.Math;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable; 
import gameEngine.Player;

public class Castle extends GamePiece {
	
	
	
	public Castle(int location) {
		super('C', "Castle", location);
	}
	
		
	// interaction status
		public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
			if (super.getLocation() == playerLocation) {
				gameBoard[super.getLocation()] = null;
				return InteractionResult.GET_POINT;
			}
			return InteractionResult.NONE;
		}
}
