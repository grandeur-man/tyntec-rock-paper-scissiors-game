package tyntec.com.rock.paper.scissors.game.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import tyntec.com.rock.paper.scissors.game.controller.GamePlayImpl;
import tyntec.com.rock.paper.scissors.game.model.Choice;
import tyntec.com.rock.paper.scissors.game.model.Player;

public class GamePlayTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Test
	public void happyTestCase() {
		GamePlayImpl gamePlay = new GamePlayImpl();
		Player a = new Player ("Tom");
		Player b = new Player ("Computer");
		int rounds = 1000;
		
		gamePlay.play(a, b, rounds);
		
		assertEquals("Name mismatch", "Tom", a.getName());
		assertEquals("Name mismatch", "Computer", b.getName());
		assertEquals("Number of Rounds mismatch", rounds, a.getWins()+b.getWins()+b.getTies());
		assertEquals("Number of Ties mismatch", (rounds-(a.getWins() + b.getWins())), a.getTies());
		assertEquals("Number of Ties mismatch", (a.getTies()), b.getTies());
	}
	
	@Test
	public void whenPlayerHasPredefinedWinsandTies() {
		GamePlayImpl gamePlay = new GamePlayImpl();
		Player a = new Player ("Ham");
		a.setTies(100);
		a.setWins(900);
		Player b = new Player ("Computer");
		int rounds = 100;
		
		gamePlay.play(a, b, rounds);
		
		assertEquals("Name mismatch", "Ham", a.getName());
		assertEquals("Name mismatch", "Computer", b.getName());
		assertEquals("Number of Rounds mismatch", rounds, a.getWins()+b.getWins()+b.getTies());
		assertEquals("Number of Ties mismatch", (rounds-(a.getWins() + b.getWins())), a.getTies());
		assertEquals("Number of Ties mismatch", (a.getTies()), b.getTies());
	}
	
	@Test
	public void whenPlayerHasName() {
		GamePlayImpl gamePlay = new GamePlayImpl();
		Player a = new Player (null);
		Player b = new Player ("");
		int rounds = 400;
		
		gamePlay.play(a, b, rounds);
		
		assertNotNull("Unexepected Name value",  a.getName());
		assertTrue("Unexepected Name value",  !b.getName().isEmpty());
		assertEquals("Number of Rounds mismatch", rounds, a.getWins()+b.getWins()+b.getTies());
		assertEquals("Number of Ties mismatch", (rounds-(a.getWins() + b.getWins())), a.getTies());
		assertEquals("Number of Ties mismatch", (a.getTies()), b.getTies());
	}
	
	@Test
	public void getRandomChoice() {
		GamePlayImpl gamePlay = new GamePlayImpl();
		
		
		Choice choice = gamePlay.selectRandomChoice();
		
		assertNotNull("Unexepected Name value",  choice);
	}
	
	@Test
	public void getPlayerChoice() {
		GamePlayImpl gamePlay = new GamePlayImpl();
		
		
		Choice choice = gamePlay.getPlayerChoice();
		
		assertNotNull("Unexepected Name value",  choice);
		assertEquals("Choice mismatch", Choice.PAPER, choice);
	}
	
	@Test
	public void displayValidInput() {
		System.setOut(new PrintStream(outContent));
		GamePlayImpl gamePlay = new GamePlayImpl();
		Player a = new Player ("Player A");
		Player b = new Player ("Player B");
		int rounds = 400;
		a.setTies(100);
		a.setWins(140);
		b.setTies(100);
		b.setWins(160);
		gamePlay.displayResults(a, b, rounds);
		
		assertEquals("Name mismatch", "Player A", a.getName());
		assertEquals("Name mismatch", "Player B", b.getName());
		assertEquals("Number of Rounds mismatch", rounds, a.getWins()+b.getWins()+b.getTies());
		assertEquals("Number of Ties mismatch", (rounds-(a.getWins() + b.getWins())), a.getTies());
		assertEquals("Number of Ties mismatch", (a.getTies()), b.getTies());
		assertTrue("Invalid result displayed",  !outContent.toString().contains("Invalid results"));
		System.setOut(System.out);
	}
	
	@Test
	public void displayInvalidResultInput() {
		System.setOut(new PrintStream(outContent));
		GamePlayImpl gamePlay = new GamePlayImpl();
		Player a = new Player ("Player A");
		Player b = new Player ("Player B");
		int rounds = 400;
		a.setTies(100);
		a.setWins(100);
		b.setTies(100);
		b.setWins(160);
		gamePlay.displayResults(a, b, rounds);
		
		assertTrue("Invalid result displayed",  outContent.toString().contains("Invalid results"));
		System.setOut(System.out);
	}
	
	@Test
	public void displayInvalidResultInput2() {
		System.setOut(new PrintStream(outContent));
		GamePlayImpl gamePlay = new GamePlayImpl();
		Player a = new Player ("Player A");
		Player b = new Player ("Player B");
		int rounds = 400;
		a.setTies(100);
		a.setWins(100);
		b.setTies(100);
		b.setWins(100);
		gamePlay.displayResults(a, b, rounds);
		
		assertTrue("Invalid result displayed",  outContent.toString().contains("Invalid results"));
		System.setOut(System.out);
	}
	

}
