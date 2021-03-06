package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Display extends JPanel{
	//add the vars to the panel
	Protractor protractor;
	Game game;
	private boolean protractorVisible = false;
	
	public Display(Game game) {
		//instantiate with game and a protractor
		this.game = game;
		protractor = new Protractor();
	}
	
	//sets protractor visible
	public void protractorVisible(boolean visible) {
		protractorVisible = visible;
	}
	
	//draw component function
	//draws protractor, alien, and missile
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		//paint all the components
		if (protractorVisible) {
			protractor.draw(g);
		}
		if (game.getControlPanel().getProgress() - 1 < Game.numLevels) {
			game.getLevels().get(game.getControlPanel().getProgress() - 1).getAlien().draw(g);
			game.getLevels().get(game.getControlPanel().getProgress() - 1).getMissile().draw(g);
		}

	}
}
