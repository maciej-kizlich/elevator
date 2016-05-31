package pl.maciejkizlich.games.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class SplashScreen extends AbstractGameScreen {

  private SpriteBatch batch;
  private Texture splashTexture;
  private Texture titleTexture;
  private Texture startTexture;
  private Rectangle startButton;
  private Sound startSound;
  
  public SplashScreen(ElevatorTroubleGame game) {
    super(game);
  }
  
  @Override
  protected void init() {
    System.out.println("splash screen init");
    
    batch = new SpriteBatch();
    splashTexture = new Texture("city.png");
    titleTexture = new Texture("title.png");
    startTexture = new Texture("startbtn.png");

    startButton = new Rectangle(148, 400, startTexture.getWidth(), startTexture.getHeight());
    
    startSound = Gdx.audio.newSound(Gdx.files.internal("chose.wav"));
  }
  
  @Override
  public void render(float delta) {
    super.render(delta);
    update();
    Gdx.gl.glClearColor(1, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    batch.begin();
    batch.draw(splashTexture, 0, 0);
    batch.draw(titleTexture, 11, 500);
    batch.draw(startTexture, 148, 400);
    batch.end();
  }

  private void update() {
    if (Gdx.input.justTouched()) {
      if (startButton.contains(getMousePosInGameWorld().x, getMousePosInGameWorld().y)) {
        startSound.play();
        game.setScreen(new MainScreen(game));
      }
    }
  }

  private Vector3 getMousePosInGameWorld() {
    return camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
  }

  @Override
  public void dispose() {
    super.dispose();
    batch.dispose();
    splashTexture.dispose();
    titleTexture.dispose();
    startTexture.dispose();
    startSound.dispose();
  }
}
