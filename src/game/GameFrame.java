package game;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;


public class GameFrame extends JFrame implements KeyListener{
	
	private Pacman pac ;
	private Map map ;
	private Foods foods;
	private Gifts gifts;
	private Enemies enemies;
	private GamePanel gamePanel;
	private PlayBtn b;
	private CheckCollides check;
	private ImageIcon leftImage = new ImageIcon("Images//pacLeft.png");
	private ImageIcon rightImage = new ImageIcon("Images//pacRight.png");
	private ImageIcon upImage = new ImageIcon("Images//pacUp.png");
	private ImageIcon downImage = new ImageIcon("Images//pacDown.png");
	private int level;
	private String name ;
	
	//CONSTRUCTOR
	public GameFrame(Pacman pac , int level , String name , PlayBtn w ,BelowPanel bp) {

		this.level = level;
		this.pac = pac ;
		this.name = name ;
		b = w ;
		map = new Map(50, 25, "Maps\\map"+level+".txt");
		foods = new Foods(level * 50, map);
		gifts = new Gifts(map , level);
		enemies = new Enemies(this.map,level,pac);
		gamePanel = new GamePanel(this , bp);
		pac.setMap(this.getMap());
		addKeyListener(pac);
		setTitle("PackMan");
		setSize(1000,600);
		this.add(gamePanel);
		//this.getContentPane().add(a);
		setResizable(false);
		setVisible(true);
		enemies.starter();
		//moveTimer.start();
		paintTimer.start();
	}
	public CheckCollides getCheck() {
		return check;
	}
	public Enemies getEnemies() {
		return enemies;
	}
	
	// GETTER & SETTER
	public Pacman getPac() {
		return pac;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Map getMap() {
		return map;
	}
	public Gifts getGifts() {
		return gifts;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Foods getFoods() {
		return foods;
	}
	
	public GamePanel getPanel(){
		return gamePanel;
	}
	
	Timer paintTimer = new Timer(16,(ActionEvent e) -> {
		gamePanel.repaint();
	});
	
	public PlayBtn getB() {
		return b;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
}
