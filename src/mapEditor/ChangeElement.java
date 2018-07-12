package mapEditor;

import java.awt.Component;
import java.awt.event.ComponentEvent;

public class ChangeElement extends ComponentEvent {

	private int element;
	public ChangeElement(Component arg0, int arg1 , int element) {
		super(arg0, arg1);
		this.element = element;
	}
	public int getElement() {
		return element;
	}
	public void setElement(int element) {
		this.element = element;
	}

}
