
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Pong extends JFrame implements ActionListener{
	private Ball ball;
	public final int fWidth = 1000, fHeight = 500;
	public Pong(){
		setTitle("PONG!");
		ball = new Ball(10, 10, fWidth/2, fHeight/2, fWidth, fHeight);
		setBounds(0, 0, fWidth, fHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		Timer timer = new Timer(30, this);
		timer.start();
	}
	
	public void update(){
		ball.updatePos();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, fWidth, fHeight);
		g.setColor(Color.WHITE);
		g.fillOval(ball.getPosX(), ball.getPosY(), 50, 50);
	}
	public static void main(String[] args){
		new Pong();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
		
	}
}
