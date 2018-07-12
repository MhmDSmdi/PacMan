package game;

import java.awt.Component;
import java.awt.event.ComponentEvent;

public class ChageDIR extends ComponentEvent {

	Enemy a;
	public ChageDIR(Component arg0, int arg1 , Enemy b) {
		super(arg0, arg1);
		a = b;
		// TODO Auto-generated constructor stub
	}
	public Enemy getA() {
		return a;
	}
	public void setA(Enemy a) {
		this.a = a;
	}

}
