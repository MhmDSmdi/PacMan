package mapEditor;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CustomBTN extends JButton implements MouseListener{

	private ImageIcon entered ;
	private ImageIcon defaultIm;
	private ImageIcon image;
	public CustomBTN(ImageIcon entered , ImageIcon defaultIm) {
		addMouseListener(this);
		setSize(Location.widht,Location .height);
		this.entered = entered ; 
		this.defaultIm = defaultIm ;
		image = defaultIm ;
	}

	
	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		arg0.drawImage(image.getImage(), 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		image = entered ;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		image = defaultIm ;
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
