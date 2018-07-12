package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mapEditor.MapEditor;

public class MenuFrame extends JFrame implements FocusListener,ActionListener{

	private PlayBtn play;
	private JButton editor;
	private JComboBox<String> levels;
	private JTextField nameText = new JTextField();
	private JLabel nameLable = new JLabel("Name : ");
	private JLabel difficultyLable = new JLabel("difficulty : ");
	private Icon logo = new ImageIcon("Images//PacmanLogo.png");
	private JLabel pic = new JLabel(logo);
	FocusListener a = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent arg0) {
				difficultyLable.setForeground(Color.YELLOW);
		}
		
		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			difficultyLable.setForeground(Color.RED);
		}
	};
	public MenuFrame(int w , int h) {
		
		setContentPane(new JLabel(new ImageIcon("Images\\backG.png")));
		
		pic.setLocation(20,-40);
		pic.setSize(750, 200);
		getContentPane().add(pic);
		
		editor = new JButton("Map Editor");
		editor.addActionListener(this);
		editor.setSize(120, 30);
		editor.setLocation(640, 500);
		getContentPane().add(editor);
		
		nameText.setSize(150,25);
		nameText.setLocation(120,189);
		getContentPane().add(nameText);
		nameText.setName("text");
		nameText.addFocusListener(this);
		
		nameLable.setSize(150,200);
		nameLable.setLocation(20,100);
		nameLable.setForeground(Color.YELLOW);
		nameLable.setFont(new Font("arial", Font.BOLD, 27));
		nameLable.setName("lable");
		nameLable.addFocusListener(this);
		getContentPane().add(nameLable);
		
		difficultyLable.setSize(150,200);
		difficultyLable.addFocusListener(this);
		difficultyLable.setLocation(20,200);
		difficultyLable.setForeground(Color.YELLOW);
		difficultyLable.setFont(new Font("arial", Font.BOLD, 27));
		difficultyLable.setName("dif");
		getContentPane().add(difficultyLable);
		
		DefaultComboBoxModel<String> compLevels = new DefaultComboBoxModel<>();
		compLevels.addElement("Easy");
		compLevels.addElement("Medium");
		compLevels.addElement("Hard");
		levels = new JComboBox<>(compLevels);
		levels.setLocation(160,273);
		levels.setSize(150, 50);
		levels.addFocusListener(a);
		levels.setName("com");
		getContentPane().add(levels);
		
		play = new PlayBtn(levels , nameText);
		getContentPane().add(play);
		
		setLayout(null);
		setResizable(false);
		setSize(800,600);
		setTitle("PacMan");
		setLocation(200,200);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MenuFrame a = new MenuFrame(300, 300);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		if("text".equals(((JTextField)arg0.getSource()).getName())){
			nameLable.setForeground(Color.red);
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if("text".equals(((JTextField)arg0.getSource()).getName())){
			nameLable.setForeground(Color.yellow);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MapEditor editation = new MapEditor();
		
	}

}
