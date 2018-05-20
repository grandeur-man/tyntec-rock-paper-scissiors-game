package tyntec.com.rock.paper.scissors.game.controller;

import java.security.SecureRandom;

import tyntec.com.rock.paper.scissors.game.controller.interfaces.GamePlay;
import tyntec.com.rock.paper.scissors.game.model.Choice;
import tyntec.com.rock.paper.scissors.game.model.Player;

/**
 * @author Samuel.Idaewor
 *
 */
public class GamePlayImpl implements GamePlay{

	
	/*
	 * (non-Javadoc)
	 * @see tyntec.com.rock.paper.scissors.game.controller.interfaces.GamePlay#play(tyntec.com.rock.paper.scissors.game.model.Player, tyntec.com.rock.paper.scissors.game.model.Player, int)
	 */
	public void play(Player a, Player b, int rounds) {
		//Validate user input and set to default if user input is invalid
		rounds = rounds > MAX_ROUNDS ? MAX_ROUNDS : rounds;
		
		Game game = new Game();
		
		//Ensure that players are in the right state
		//Get only and the name and other variables should be in their default states.
		normalizeNewPlayer(a);
		normalizeNewPlayer(b);
		
		for (int i = 0; i < rounds; i++) {
			a.setChoice(getPlayerChoice());
			b.setChoice(selectRandomChoice());
			game.gamePlay(a, b);
		}
		
		displayResults(a, b, rounds);
		
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see tyntec.com.rock.paper.scissors.game.controller.interfaces.GamePlay#selectRandomChoice()
	 */
	public Choice selectRandomChoice() {
		
		SecureRandom random = new SecureRandom();
		int choice = random.nextInt(1000)%3;
		if(choice == 0)
			return Choice.PAPER;
		else if(choice == 1)
			return Choice.ROCK;
		else
			return Choice.SCISSORS;
		
	}
	

	/*
	 * (non-Javadoc)
	 * @see tyntec.com.rock.paper.scissors.game.controller.interfaces.GamePlay#getPlayerChoice()
	 */
	public Choice getPlayerChoice() {
		
		return Choice.PAPER;
	}

	/*
	 * (non-Javadoc)
	 * @see tyntec.com.rock.paper.scissors.game.controller.interfaces.GamePlay#displayResults(tyntec.com.rock.paper.scissors.game.model.Player, tyntec.com.rock.paper.scissors.game.model.Player, int)
	 */
	public void displayResults(Player a, Player b, int rounds) {
		
		if((a.getWins() + b.getWins() + a.getTies() == rounds) && (a.getTies() == b.getTies())) {
			System.out.println(a.getName() + " wins "+ a.getWins()+ " of " + rounds + " rounds.\n");
			System.out.println(b.getName() + " wins "+ b.getWins()+ " of " + rounds + " rounds.\n");
			System.out.println("Tie: " + a.getTies()+ " of " + rounds + " rounds.\n");
		}
		else
			System.out.println("Invalid results");
		
	}
	
	/*
	 * This method ensures that user input is in the expected state.
	 */
	private void normalizeNewPlayer(Player player) {
		player.setTies(0);
		player.setWins(0);
	}
	
}
