package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class PlayBtn extends JButton implements MouseListener , FocusListener , KeyListener{

	private ImageIcon ex = new ImageIcon("Images//btnexited.png");
	private ImageIcon press = new ImageIcon("Images//btnpressed.png");
	private ImageIcon click = new ImageIcon("Images//btnclick.png");
	private ImageIcon image = new ImageIcon("Images//btnclick.png");
	private JComboBox<String> jcombo;
	private JTextField q ;
	public PlayBtn(JComboBox<String>a , JTextField q) {
		addMouseListener(this);
		addFocusListener(this);
		addKeyListener(this);
		setSize(120,50);
		setLocation(640,440);
		jcombo = a ;
		this.q = q ;
	}
	
	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		arg0.drawImage(image.getImage(), 0,0,null);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		image = click;
		repaint();
		String name = q.getText();
		if("Easy".equals(jcombo.getSelectedItem())){
			Pacman pac = new Pacman();
			BelowPanel bp = new BelowPanel();
			GameFrame a = new GameFrame(pac,1,name,this,bp);
			CheckCollides c = new CheckCollides(a);
			new Thread(pac).start();
			new Thread(c).start();
		}
		else if("Medium".equals(jcombo.getSelectedItem())){
			Pacman pac = new Pacman();
			BelowPanel bp = new BelowPanel();
			GameFrame a = new GameFrame(pac,2,name,this,bp);
			CheckCollides c = new CheckCollides(a);
			new Thread(pac).start();
			new Thread(c).start();
		}
		else if("Hard".equals(jcombo.getSelectedItem())){
			Pacman pac = new Pacman();
			BelowPanel bp = new BelowPanel();
			GameFrame a = new GameFrame(pac,3,name,this,bp);
			CheckCollides c = new CheckCollides(a);
			new Thread(pac).start();
			new Thread(c).start();
		}
		
	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		image = ex ;
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		image = click;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		image = press;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void processComponentEvent(ComponentEvent arg0) {
		if(arg0.getID() == Messages.END_OF_GAME){
			
			GameFrame gf = ((EndOfGame)arg0).getGf();
			gf.getEnemies().waitForGiftAffect.stop();
			gf.getEnemies().dispatchEvent(new ComponentEvent(this, Messages.END_OF_GAME));
			gf.setVisible(false);
			
			
			Pacman pac = new Pacman();
			BelowPanel bp = new BelowPanel();
			bp.dispatchEvent(new ComponentEvent(this, Messages.RESET_IMAGE));
			if(gf.getLevel() == 3){
				gf.setLevel(0);
			}
			GameFrame a = new GameFrame(pac,gf.getLevel() + 1 ,gf.getName(),this ,bp);
			CheckCollides c = new CheckCollides(a);
			new Thread(pac).start();
			new Thread(c).start();
			
		}
		super.processComponentEvent(arg0);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		image = press;
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		image = click;
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE){
			image = click;
			repaint();
			String name = q.getText();
			if("Easy".equals(jcombo.getSelectedItem())){
				Pacman pac = new Pacman();
				BelowPanel bp = new BelowPanel();
				GameFrame a = new GameFrame(pac,1,name,this,bp);
				CheckCollides c = new CheckCollides(a);
				new Thread(pac).start();
				new Thread(c).start();
			}
			else if("Medium".equals(jcombo.getSelectedItem())){
				Pacman pac = new Pacman();
				BelowPanel bp = new BelowPanel();
				GameFrame a = new GameFrame(pac,2,name,this,bp);
				CheckCollides c = new CheckCollides(a);
				new Thread(pac).start();
				new Thread(c).start();
			}
			else if("Hard".equals(jcombo.getSelectedItem())){
				Pacman pac = new Pacman();
				BelowPanel bp = new BelowPanel();
				GameFrame a = new GameFrame(pac,3,name,this,bp);
				CheckCollides c = new CheckCollides(a);
				new Thread(pac).start();
				new Thread(c).start();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
