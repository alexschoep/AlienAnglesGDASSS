package game;

import java.util.Random;

import javax.swing.JPanel;

public class Level{
	private int moves = 0;
	private int levelAngle;
	private Alien alien;
	private Missile missile;
	private boolean pass;
	private int precision;
	private Question question;
	private Game game;
	private int levelNumber;
	
	public Level(int angle, Game game) {
		alien = new Alien(angle);
		missile = new Missile();
		this.game = game;
		
	}
	
	public Level(Game game) {
		levelNumber = 1;
		question = new Question(levelAngle, levelNumber);
		Random random = new Random();
		levelAngle = random.nextInt(181);
		alien = new Alien(levelAngle);
		missile = new Missile();
		this.game = game;
	}
	
	public Level(Game game, int levelNumber) {
		this.levelNumber = levelNumber;
		question = new Question(levelAngle, levelNumber);
		Random random = new Random();
		levelAngle = random.nextInt(181);
		alien = new Alien(levelAngle);
		missile = new Missile();
		this.game = game;
	}
	
	public int getLevelAngle() {
		return levelAngle;
	}
	
	public int getPrecision() {
		return precision;
	}
	
	public Missile getMissile() {
		return missile;
	}
	
	public Alien getAlien() {
		return alien;
	}
	
	public void moveMissile(int angle) {
		precision = Math.abs(angle-levelAngle);
		moves++;
		missile.changePosition(angle);
		if (alien.checkHit(missile.getXPos(), missile.getYPos())) {
				alien.killAlien();
				missile.detonate();
		}
		if (moves == Game.gameRadius && alien.alive()) {
			endLevel(false, game);
		}
		if (moves == Game.gameRadius && !alien.alive()) {
			endLevel(true, game);
		}
	}
	
	public void endLevel(boolean pass, Game game) {
		this.pass = pass;
		game.getControlPanel().incProgress(precision);
	}

	public boolean passed() {
		return pass;
	}
	
	public Question getQuestion() {
		return question;
	}
}
