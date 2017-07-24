import java.awt.Rectangle;
import java.util.Map;
import java.util.HashMap;

public class Bracket {
	
	private final int WIDTH = 15, HEIGHT = 75;
	private int posX, posY, yA;
	private int player;
	private int up, down;
	private Pong panel;
	private Map<Integer, Boolean> keys;
	public Bracket(Pong panel, int posX, int posY, int player, int up, int down){
		this.posX = posX;
		this.posY = posY;
		this.player = player;
		this.up = up;
		this.down = down;
		this.panel = panel;
		yA = 0;
		keys = panel.keys;
	}
	public int getPosX(){
		return posX;
	}
	
	public void setPosY(int posY){
		this.posY = posY;
	}
	public int getPosY(){
		return posY;
	}
	public int getWidth(){
		return WIDTH;
	}
	public int getHeight(){
		return HEIGHT;
	}
	public void update(){
		if (keys.get(up) == true && (posY > 0 && posY < panel.getHeight() - HEIGHT - 38))
			posY-= 3;
		else if(keys.get(down) == true && (posY > 0 && posY < panel.getHeight() - HEIGHT - 38))
			posY+= 3;
		else if(posY <= 0)
			posY++;
		else if (posY >= panel.getHeight() - HEIGHT - 38)
			posY--;
	}
	public void released(int key){
		if(key == up || key == down)
			yA = 0;
	}
	public Rectangle getBounds() {
        return new Rectangle(posX, posY, WIDTH, HEIGHT);
    }

}
