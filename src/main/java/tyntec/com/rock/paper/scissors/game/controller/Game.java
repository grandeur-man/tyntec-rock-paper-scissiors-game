package tyntec.com.rock.paper.scissors.game.controller;

import tyntec.com.rock.paper.scissors.game.model.Choice;
import tyntec.com.rock.paper.scissors.game.model.Player;

/**
 * @author Samuel.Idaewor
 *
 */
class Game {
	/*
	 * Only accessible to GamePlay Implementation
	 * The rules of the game is defined here, hence it should not be accessible outside this package
	 */
	
	public void gamePlay(Player a, Player b) {
		
		if(a.getChoice() == b.getChoice()) {
			a.setTies(a.getTies() +1);
			b.setTies(b.getTies() +1);
		}
		else if(a.getChoice() == Choice.PAPER && b.getChoice() == Choice.ROCK) {
			a.setWins(a.getWins()+1);
		}
		else if(b.getChoice() == Choice.PAPER && a.getChoice() == Choice.ROCK) {
			b.setWins(a.getWins()+1);
		}
		else if(a.getChoice() == Choice.PAPER && b.getChoice() == Choice.SCISSORS) {
			b.setWins(b.getWins()+1);
		}
		else if(b.getChoice() == Choice.PAPER && a.getChoice() == Choice.SCISSORS) {
			a.setWins(b.getWins()+1);
		}
		else if(a.getChoice() == Choice.ROCK && b.getChoice() == Choice.SCISSORS) {
			a.setWins(a.getWins()+1);
		}
		else if(b.getChoice() == Choice.ROCK && a.getChoice() == Choice.SCISSORS) {
			b.setWins(b.getWins()+1);
		}
	}
	

}
