

public class Ball {
	private int vX, vY, posX, posY, fWidth, fHeight;
	
	public Ball(int vX, int vY, int posX, int posY, int fWidth, int fHeight){
		this.vX = vX;
		this.vY = vY;
		this.posX = posX;
		this.posY = posY;
		this.fWidth = fWidth;
		this.fHeight = fHeight;
		
	}
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public boolean isColliding(int otherX, int otherY){
		return (otherX == vX && otherY == vY);
	}
	public boolean xOutOfBounds(){
		return posX >= fWidth || posX <= 0;
	}
	public boolean yOutOfBounds(){
		return posY >= fHeight || posY <= 0; 
	}
	public void reset(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		posX = fWidth/2;
		posY = fHeight/2;
		vX = 10;
		vY = 10;
	}
	public void updatePos(){
		if(xOutOfBounds())
			reset();
		if(yOutOfBounds())
			vY = -vY;
		posX += vX;
		posY += vY;
	}
	
}
