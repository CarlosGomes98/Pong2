import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame{
	public final int fWidth = 1000, fHeight = 500;
	private Pong panel;
	public Game(){
			setTitle("PONG!");
			setSize(fWidth, fHeight);
			setBackground(Color.WHITE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setResizable(false);
			panel = new Pong(this);
			add(panel);
	}
	public static void main(String[] args){
		new Game();
	}
	public Pong getPanel(){
		return panel;
	}
}
