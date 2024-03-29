package games.preachOrDie1000HolyPlague.pages;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import games.preachOrDie1000HolyPlague.Player;
import games.preachOrDie1000HolyPlague.World;

public class SkillPage extends BasicGameState {
	private Player player;
	private int ID;


	public SkillPage(int ID){
		this.ID = ID;
	}

	@Override
	public int getID() {
		return this.ID;
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		player.renderFromKillPage(gameContainer, stateBasedGame, graphics);
		String title = "Arbre des compétences";
		graphics.drawString (title, (gameContainer.getWidth()-graphics.getFont().getWidth(title))/2, 24);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			game.enterState(3, new FadeOutTransition(), new FadeInTransition());
			((World) game.getState(3)).setState(3);
		}
		player.updateFromSkillPage(container, game, delta);

	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
