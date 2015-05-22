import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Bat {
	private int x;
	private int y;
	private int h;
	private int w;
	
	int dx ; 
	private int speed;
	
	boolean isleft = false;
	boolean isright = false;
	
	public Bat(int x,int y,int h,int w,int speed){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.speed = speed;
		dx = 0;
		
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getH() {
		return h;
	}

	public int getW() {
		return w;
	}
	
	public void update(){
		x = x + dx;	
		
		if (isleft){
			setLeft();
		}
		
		if (isright){
			setRight();
			
		}
		
		if (x <= 0){
			x = 0;
		}
		
		if ( x  >= 400 - w){
			x  = 400 - w ;
		}

		isleft = false;
		isright  = false;
		
	}
	 public void setLeft(){
			 
		dx = -speed;
		 
		 
	 }
	public void setX(int x){
		this.x = x;
	}
	 
	 public void setRight(){
		 
		 dx = speed;
	 }
	
	
}
