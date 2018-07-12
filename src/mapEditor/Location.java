package mapEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Location extends JButton implements MouseListener{

	private int element = 0;
	public static final int widht = 20 , height = 20 ;
	private int i , j ;
	private int xPos , yPos ;
	private static final ImageIcon block = new ImageIcon("Images//d1Big.png");
	private static final ImageIcon road = new ImageIcon("Images//d2Big.png");
	private ImageIcon image , preImage;
	private SampleMap map;
	
	public Location(SampleMap a) {
		addMouseListener(this);
		setSize(widht, height);
		image = new ImageIcon("Images//d2Big.png");
		preImage = new ImageIcon("");
		map = a ;
	}
	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		arg0.drawImage(image.getImage(), 0, 0, null);
		arg0.setColor(Color.CYAN);
		arg0.drawRect(xPos, yPos, widht, height);
	}

	//SETTER & GETTER
	
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public int getHeight() {
		return height;
	}
	public int getI() {
		return i;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
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

	public Image getLocationImage() {
		return image.getImage();
	}

	public void setLocationImage(ImageIcon image) {
		this.image = image;
	}
	@Override
	
	
	
	public void mouseClicked(MouseEvent arg0) {
		if(SampleMap.element == ConstElements.block){
			preImage = block;
			image = block;
			element = ConstElements.block ;
			map.dispatchEvent(new WriterInFile(this, Events.WRITE_IN_FILE, i, j, element));
			System.out.println("BLOCK");
		}
		if(SampleMap.element == ConstElements.road){
			preImage = road;
			image = road;
			element = ConstElements.road ;
			map.dispatchEvent(new WriterInFile(this, Events.WRITE_IN_FILE, i, j, element));
			System.out.println("ROAD");
		}
		repaint();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		preImage = image ; 
		image = new ImageIcon("Images//a.png");
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		image = preImage ;
		repaint();
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
