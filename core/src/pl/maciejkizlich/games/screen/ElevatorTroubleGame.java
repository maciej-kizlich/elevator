package pl.maciejkizlich.games.screen;

import com.badlogic.gdx.Game;

public class ElevatorTroubleGame extends Game {

  @Override
  public void create() {
    System.out.println("splash screen set");
    this.setScreen(new SplashScreen(this));
  }
}
