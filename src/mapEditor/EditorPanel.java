package mapEditor;

import java.awt.Graphics;

import javax.swing.JPanel;

public class EditorPanel extends JPanel{

	private MapEditor mapEditor;
	
	public EditorPanel(MapEditor map) {
		mapEditor = map;
	}
	
	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		
		////Map Paint
		System.out.println("2e");
		for(int j = 0 ; j < mapEditor.getMap().getHeightSize() ; j++){
			for(int i = 0 ; i < mapEditor.getMap().getWidhtSize() ; i++){
				arg0.drawImage(mapEditor.getMap().getLocation(i, j).getLocationImage(),500+i*Location.widht , Location.height , null);
				System.out.println("i");
			}
		}
	}
}
