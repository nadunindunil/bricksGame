
public class Ball {
	int x;
	int y;
	int w;
	int h;
	
	int gameW;
	int gameH;
	
	private int speed;
	
	private int dx;
	private int dy;
	
	boolean sign;
	
	
	public Ball (int x,int y,int w,int h,int gameW,int gameH,int speed){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			
			this.gameW = gameW;
			this.gameH = gameH;
			this.speed = speed;
			dx = speed;
			dy = speed;
	}

	
	public int getX() {
		return x;
	}

	

	public int getY() {
		return y;
	}

	

	public int getW() {
		return w;
	}

	

	public int getH() {
		return h;
	}
	
	public void Update(){
		
//		x = x + 4;
//		y = y + 4;
		
		if (gameH - h <= y ){
			dy = -speed;
			
		}
		
		if (gameW - w <= x ){
			dx = -speed;	
		}
		
		if (x <= 0 ){
			
			dx = speed;
		}
		
		if (y <= 0 ){
			
			dy = speed;
		}
		
		x = x +dx;
		y = y +dy;
		}
	
	public void ballCollide(){
		dy = -speed;
		
		
	}

	
	
}
