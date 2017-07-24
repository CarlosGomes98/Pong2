
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.HashMap;

public class Pong extends JPanel implements ActionListener, KeyListener{
	public Map<Integer, Boolean> keys = new HashMap<Integer, Boolean>();
	private Ball ball;
	private Game game;
	private Bracket player1;
	private Bracket player2;
	private int score1 = 0;
	private int score2 = 0;
	public final int fWidth = 1000, fHeight = 500;
	public Pong(Game game){
		keys.put(new Integer(KeyEvent.VK_W), false);
		keys.put(new Integer(KeyEvent.VK_S), false);
		keys.put(new Integer(KeyEvent.VK_UP), false);
		keys.put(new Integer(KeyEvent.VK_DOWN), false);
		this.game = game;
		player1 = new Bracket(this, 50, fHeight/2 - 75, 1, KeyEvent.VK_W, KeyEvent.VK_S);
		player2 = new Bracket(this, 950, fHeight/2 - 75, 2, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
		ball = new Ball(this, 2, 2, fWidth/2, fHeight/2, fWidth, fHeight);
		setBounds(0, 0, fWidth, fHeight);
		setVisible(true);
		setFocusable(true);
		addKeyListener(this);
		Timer timer = new Timer(10, this);
		timer.start();
	}
	public Bracket getPlayer(int player){
		if(player == 1)
			return player1;
		else
			return player2;
	}
	public void scored(int player){
		player1.setPosY(fHeight/2 - 75);
		player2.setPosY(fHeight/2 - 75);
		if(player == 1)
			score1 += 1;
		else
			score2 += 1;
	}
	public void update(){
		ball.updatePos();
		player1.update();
		player2.update();
	}
	
	public int getHeight(){
		return fHeight;
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, fWidth, fHeight);
		//draw the ball
		g.setColor(Color.WHITE);
		g.fillOval(ball.getPosX(), ball.getPosY(), 25, 25);
		//draw the brackets
		g.fillRect(player1.getPosX(), player1.getPosY(), player1.getWidth(), player1.getHeight());
		g.fillRect(player2.getPosX(), player2.getPosY(), player2.getWidth(), player2.getHeight());
		//draw score
		g.drawString(Integer.toString(score1), 200, 100);
		g.drawString(Integer.toString(score2), 800, 100);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys.put(e.getKeyCode(), true);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys.put(e.getKeyCode(), false);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		;
		
	}
}
