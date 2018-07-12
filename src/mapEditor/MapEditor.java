package mapEditor;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class MapEditor extends JDialog {

	private static final int WIDTH = 1123 , HEIGHT = 560 ;
	private SampleMap map;
	private SelectionPanel selection_Panel;
	//private EditorPanel paintPanel;
	public MapEditor() {
		setSize(WIDTH, HEIGHT);
		map = new SampleMap();
		getContentPane().add(map);
		selection_Panel = new SelectionPanel(map);
		getContentPane().add(selection_Panel);
		setLayout(null);
		setVisible(true);
	}
	
	//GETTER & SETTER
	public SampleMap getMap() {
		return map;
	}

	public void setMap(SampleMap map) {
		this.map = map;
	}

}
