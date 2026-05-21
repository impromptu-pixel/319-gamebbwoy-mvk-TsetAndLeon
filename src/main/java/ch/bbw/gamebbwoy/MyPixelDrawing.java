package ch.bbw.gamebbwoy;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.internal.GameBbwoy;
import ch.bbw.gamebbwoy.myClasses.Sprite;
import ch.bbw.gamebbwoy.myClasses.Sprites;

public class MyPixelDrawing implements PixelDrawing, ButtonListener {

	private final Sprite sprite = Sprites.JEFFREY_REALISTIC;

	public static void main(String[] args) throws Throwable {
		GameBbwoy.playGame(new MyPixelDrawing());
	}

	@Override
	public void initialize(PixelDisplay graphic) {
		sprite.setX(graphic.getPixelWidth() / 2);
		sprite.setY(graphic.getPixelHeight() / 2);
	}

	@Override
	public void onButtonPress(GameButton button) {
		switch (button) {
			case UP    -> sprite.moveUp();
			case DOWN  -> sprite.moveDown();
			case LEFT  -> sprite.moveLeft();
			case RIGHT -> sprite.moveRight();
			default    -> {}
		}
	}

	@Override
	public void onButtonRelease(GameButton button) {
		// nothing to do
	}

	@Override
	public void tick(PixelDisplay graphic) {
		graphic.clear();
		sprite.draw(graphic);
	}
}