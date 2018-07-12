package mapEditor;

import java.awt.Component;
import java.awt.event.ComponentEvent;

public class WriterInFile extends ComponentEvent {

	private int i , j , element ;
	
	public WriterInFile(Component arg0, int arg1 , int i , int j , int element) {
		super(arg0, arg1);
		this.i = i ;
		this.j = j ;
		this.element = element ;
	}

	//GETTER & SETTER
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public int getElement() {
		return element;
	}
	public void setElement(int element) {
		this.element = element;
	}
}
