package games.preachOrDie1000HolyPlague.pages;

import app.AppPage;
import games.preachOrDie1000HolyPlague.Player;
import games.preachOrDie1000HolyPlague.Religion;
import games.preachOrDie1000HolyPlague.TextField;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import games.preachOrDie1000HolyPlague.World;


public class NameChoice extends AppPage {

	private String text;
	private TextField textField;
	private float aspectRatio;

	public NameChoice(int ID) {
		super(ID);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) {
		super.initSize (container, game, 600, 400);
		super.init(container, game);

		this.setTitle("Choix du nom de votre croyance");

		this.titleVisibility = true;
		this.subtitleVisibility = false;
		this.hintVisibility = false;
		this.aspectRatio = Math.min(container.getWidth() / 1280f, container.getHeight() / 720f);

		this.textField = new TextField(aspectRatio,200, 400, 400, 40, 10, 2);
		//TODO : ajouter TextField
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) {
		super.update (container, game, delta);
		text = textField.getText();
		Input input = container.getInput ();
		textField.update(container,game,delta);
		if (input.isKeyDown (Input.KEY_ESCAPE)) {
			container.exit ();
		} else if (input.isKeyDown (Input.KEY_ENTER)) {
			// Création de la religion et du player en fonction du nom de la religion tapée par le joueur
			Religion religion = new Religion(text);
			Player player = new Player(religion);
			((World) game.getState (3)).setPlayer(player);

			game.enterState (3, new FadeOutTransition(), new FadeInTransition());
		}

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		super.render(container, game, context);
//		context.drawString("TEST NameChoice : "+text, 100,100);
		textField.render(container, game, context);
	}

	public void keyPressed(int key,char value) {
		textField.keyPressed(key,value);
	}
}
