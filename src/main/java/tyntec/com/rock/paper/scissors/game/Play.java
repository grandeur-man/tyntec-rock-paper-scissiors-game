package tyntec.com.rock.paper.scissors.game;

import tyntec.com.rock.paper.scissors.game.controller.GamePlayImpl;
import tyntec.com.rock.paper.scissors.game.model.Player;

public class Play {

	public static void main(String [] args) {
		
	Player a = new Player("Player A");
	Player b = new Player("Player B");
	int rounds = 100;
	
	GamePlayImpl gamePlay = new GamePlayImpl();
	gamePlay.play(a, b, rounds);
		
	}
}
