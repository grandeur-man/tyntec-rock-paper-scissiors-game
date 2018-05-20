package tyntec.com.rock.paper.scissors.game.controller.interfaces;

import tyntec.com.rock.paper.scissors.game.model.Choice;
import tyntec.com.rock.paper.scissors.game.model.Player;

public interface GamePlay {

	/**
	 * @author Samuel.Idaewor
	 *
	 */
	/*
	 * Maximum number of rounds allowed
	 */
	public final int MAX_ROUNDS = 10000;
	
	
	/*
	 * This method manages the game play
	 * based on the number of rounds, it gets player's input choice and generates a random choice for the Computer opponent
	 */
	public void play (Player a, Player b, int rounds);
	/*
	 * Generates a random choice.
	 * This method should be used by the computer opponent.
	 */
	public Choice selectRandomChoice();
	/*
	 * This method could be used to accept user input from standard Input 
	 * or any other source
	 */
	public Choice getPlayerChoice();
	
	/*
	 * Displays the result after game is over.
	 */
	public void displayResults(Player a, Player b, int rounds);
}
