package pl.maciejkizlich.games.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractGameScreen implements Screen {

  protected ElevatorTroubleGame game;

  protected OrthographicCamera camera;
  protected SpriteBatch spriteBatch;

  public AbstractGameScreen(ElevatorTroubleGame game) {
    this.game = game;
    createCamera();
    spriteBatch = new SpriteBatch();
    init();
  }

  protected abstract void init();

  private void createCamera() {
    camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
  }

  @Override
  public void render(float delta) {
    clearScreen();
    camera.update();
    spriteBatch.setProjectionMatrix(camera.combined);
  }

  @Override
  public void show() {}

  private void clearScreen() {
    Gdx.gl.glClearColor(0, 0, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
  }

  @Override
  public void resume() {}

  @Override
  public void pause() {}

  @Override
  public void hide() {}

  @Override
  public void dispose() {
    game.dispose();
  }

  @Override
  public void resize(int width, int height) {}
}
