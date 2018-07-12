package mapEditor;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectionPanel extends JPanel implements MouseListener{

	private JButton block , road , submit ;
	private TextField mapName ;
	private SampleMap map;
	public SelectionPanel(SampleMap map) {
		setLayout(null);
		this.map = map;
		setSize(100,500);
		setLocation(0, 0);
		setBackground(Color.DARK_GRAY);
		
		block = new JButton("BLOCK");
		block.setSize(80,30);
		block.setName("block");
		block.setLocation(10, 30);
		block.addMouseListener(this);
		add(block);
		road = new JButton("ROADS");
		road.setSize(80,30);
		road.setName("road");
		road.setLocation(10, 70);
		road.addMouseListener(this);
		add(road);
		submit = new JButton("SUBMIT");
		submit.setSize(80,30);
		submit.setName("submit");
		submit.setLocation(10, 400);
		submit.addMouseListener(this);
		add(submit);
		mapName = new TextField("UN_TITEL");
		mapName.setSize(80, 30);
		mapName.setLocation(10,110);
		add(mapName);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		String name = ((JButton)arg0.getSource()).getName();
		
		if("block".equals(name)){
			map.dispatchEvent(new ChangeElement(this, Events.CHANGE_ELEMENT,ConstElements.block));
		}
		
		if("road".equals(name)){
			map.dispatchEvent(new ChangeElement(this, Events.CHANGE_ELEMENT,ConstElements.road));
		}	
		if("submit".equals(name)){
			map.dispatchEvent(new SubmitedFile(this, Events.SUBMITED,mapName.getText()));
		}	
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
