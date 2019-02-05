import java.awt.Rectangle;

public class Ball {
	private int vX, vY, posX, posY, fWidth, fHeight;
	private Bracket nextPlayer;
	private Bracket firstPlayer;
	private static final int WIDTH = 25, HEIGHT = 25;
	private Pong panel;
	
	public Ball(Pong panel, int vX, int vY, int posX, int posY, int fWidth, int fHeight, Bracket firstPlayer){
		this.vX = vX;
		this.vY = vY;
		this.posX = posX;
		this.posY = posY;
		this.fWidth = fWidth;
		this.fHeight = fHeight;
		this.panel = panel;
		this.firstPlayer = firstPlayer;
		this.nextPlayer = firstPlayer;
	}

	public Bracket getNextPlayer() {
		return nextPlayer;
	}
	
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public void isColliding(){
		if (nextPlayer.getBounds().intersects(getBounds())){
			if ( (vX > 0 && posX >= nextPlayer.getPosX() - nextPlayer.getWidth()/2.0)
				|| (vX < 0 && posX <= nextPlayer.getPosX() + nextPlayer.getWidth() / 2.0) ) {
					vY = -vY;
			} 
			else {
				if (vX > 0) {
					vX += 1;
				}
				else {
					vX -= 1;
				}	
				vX = -vX;
			}
			nextPlayer = panel.otherPlayer(nextPlayer);
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
		nextPlayer = firstPlayer;
	}

	 public Rectangle getBounds() {
	        return new Rectangle(posX, posY, WIDTH, HEIGHT);
		}
		
	public void updatePos(){
		posX += vX;
		posY += vY;
		isColliding();
		if(posX >= fWidth)
			reset(1);
		else if(posX <= 0)
			reset(2);
		if(yOutOfBounds())
			vY = -vY;
	}
	
}
