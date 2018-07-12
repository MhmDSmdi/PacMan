package mapEditor;

import java.awt.Component;
import java.awt.event.ComponentEvent;

public class SubmitedFile extends ComponentEvent {

	private String name; 
	public SubmitedFile(Component arg0, int arg1 ,  String name) {
		super(arg0, arg1);
		this.name = name ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
