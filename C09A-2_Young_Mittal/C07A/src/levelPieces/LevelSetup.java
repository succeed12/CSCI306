// Author: David Young, Eshita Mittal
package levelPieces;

import java.util.ArrayList;

import gameEngine.GameEngine;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.Player;
import levelPieces.Grass;
import levelPieces.Bug;
import levelPieces.Castle;

public class LevelSetup {
	
	private Drawable[] gameBoard;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	
	
	public LevelSetup() {
		super();
	}
	
	public void createLevel(int levelNum) {
		
		// start at level 1
		if (levelNum == 1) {
			// initialize gameBoard
			gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			interactingPieces = new ArrayList<GamePiece>();
			movingPieces  = new ArrayList<Moveable>();

			Grass g = new Grass();
			Fairy f = new Fairy();
			Imp i = new Imp();
			Wraith w = new Wraith();
			Castle c1 = new Castle(13);
			Castle c2 = new Castle(2);
			Bug b = new Bug();
			
			gameBoard[g.getLocation()] = g;
			gameBoard[f.getLocation()] = f;
			gameBoard[i.getLocation()] = i;
			gameBoard[w.getLocation()] = w;
			gameBoard[c1.getLocation()] = c1;
			gameBoard[c2.getLocation()] = c2;
			gameBoard[b.getLocation()] = b;
			
			// initialize interacting pieces
			interactingPieces.add(f);
			interactingPieces.add(i);
			interactingPieces.add(w);
			interactingPieces.add(c1);
			interactingPieces.add(c2);
			interactingPieces.add(b);
			
			// initialize moving pieces
			movingPieces.add(f);
			movingPieces.add(i);
			movingPieces.add(w);
			movingPieces.add(b);
		}
		else if (levelNum == 2) {
			gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			interactingPieces = new ArrayList<GamePiece>();
			movingPieces  = new ArrayList<Moveable>();

			Grass g = new Grass();
			Fairy f = new Fairy();
			Imp i = new Imp();
			Wraith w = new Wraith();
			Castle c1 = new Castle(20);
			Castle c2 = new Castle(2);
			Bug b = new Bug();
			
			gameBoard[g.getLocation()] = g;
			gameBoard[f.getLocation()] = f;
			gameBoard[i.getLocation()] = i;
			gameBoard[w.getLocation()] = w;
			gameBoard[c1.getLocation()] = c1;
			gameBoard[c2.getLocation()] = c2;
			gameBoard[b.getLocation()] = b;
			
			// initialize interacting pieces
			interactingPieces.add(f);
			interactingPieces.add(i);
			interactingPieces.add(w);
			interactingPieces.add(c1);
			interactingPieces.add(c2);
			interactingPieces.add(b);
			
			// initialize moving pieces
			movingPieces.add(f);
			movingPieces.add(i);
			movingPieces.add(w);
			movingPieces.add(b);
		}
	}
	public Drawable[] getBoard() {
		return gameBoard;
	}
	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}
	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}
	public int getPlayerStartLoc() {
		return 10;
	}
	
}
