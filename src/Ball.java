import java.awt.Rectangle;

public class Ball {
	private int vX, vY, posX, posY, fWidth, fHeight;
	private static final int WIDTH = 25, HEIGHT = 25;
	private Pong panel;
	
	public Ball(Pong panel, int vX, int vY, int posX, int posY, int fWidth, int fHeight){
		this.vX = vX;
		this.vY = vY;
		this.posX = posX;
		this.posY = posY;
		this.fWidth = fWidth;
		this.fHeight = fHeight;
		this.panel = panel;
		
	}
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public void isColliding(){
		if (panel.getPlayer(1).getBounds().intersects(getBounds()) || panel.getPlayer(2).getBounds().intersects(getBounds())){
			if(vX > 0)
				vX += 1;
			else
				vX -= 1;
			vX = -vX;
		}
			
	}
	public boolean yOutOfBounds(){
		return posY >= fHeight - 50 || posY < 0; 
	}

	public void reset(int player){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		posX = fWidth/2;
		posY = fHeight/2;
		vX = 2;
		vY = 2;
		panel.scored(player);
	}

	 public Rectangle getBounds() {
	        return new Rectangle(posX, posY, WIDTH, HEIGHT);
		}
		
	public void updatePos(){
		if(posX >= fWidth)
			reset(1);
		else if(posX <= 0)
			reset(2);
		if(yOutOfBounds())
			vY = -vY;
		posX += vX;
		posY += vY;
		isColliding();
	}
	
}
