package game;

import java.awt.Component;
import java.awt.event.ComponentEvent;

public class EndOfGame extends ComponentEvent {

	private GameFrame gf ;
	private CheckCollides c;
	public EndOfGame(Component arg0, int arg1 , GameFrame gf , CheckCollides c) {
		super(arg0, arg1);
		this.gf = gf;
		this.c = c;
	}
	public GameFrame getGf() {
		return gf;
	}
	public CheckCollides getC() {
		return c;
	}
	public void setC(CheckCollides c) {
		this.c = c;
	}
	public void setGf(GameFrame gf) {
		this.gf = gf;
	}

}
