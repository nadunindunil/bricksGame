/**
 * Description	:Engine for the brick game
 * Copyright	:Copyright (c) 2014
 * Company		:Embla Software Innovations (Pvt) Ltd
 * Created on	:2014.09.01
 * @author 		:Chandimal
 * @version 	:1.0
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements KeyListener {

	private static final long serialVersionUID = 1L;

	BufferedImage buffer; // Create the buffer
	Ball ball ;
	Bat bat ;
	
	boolean isleft;
	boolean isRight;
	

	/**
	 * Create the game using the width and the height specified
	 */
	
	public Game(Dimension dim) {
		buffer = new BufferedImage(dim.width, dim.height,
				BufferedImage.TYPE_INT_RGB);
		this.setIgnoreRepaint(true); // Ignore repainting as we are doing all
										// the drawing stuff
		
		ball = new Ball(200,300,10,10,400,600,4);  //instantiate
		bat = new Bat(0,560,10,60,4);
	}

	/**
	 * Start the game
	 */
	public void Start() {

		while (true) {
			// Draw the buffer
			drawBuffer();
			if (isleft){
				bat.setLeft();
			}
			
			if (isRight){
				bat.setRight();
				
			}
			
			if (bat.getX() <= 0){
				bat.setX(0);
			}
			
			if ( bat.getX() >= buffer.getWidth() - bat.getW()){
				bat.setX(buffer.getWidth() - bat.getW()) ;
			}
//			if (!isleft){
////				bat.dx = 0;
////			}
////			if (!isRight){
////				bat.dx = 0;
////			}
////			isleft = false;
////			isRight  = false;
			
			
			ball.Update();
			bat.update();
			collision();
				
				
			// Paint the buffer on screen
			drawScreen();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Draw the image buffer
	 */
	public void drawBuffer() {
		Graphics2D b = buffer.createGraphics();
		
		// Random color background
//		Color c = new Color(new Random().nextInt());
//		b.setColor(c);
//		b.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
		
		// new one 
		Color c = Color.BLACK;
		b.setColor(c);
		b.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
		
		Color b1 = Color.white;
		b.setColor(b1);
		b.fillOval(ball.getX(), ball.getY(), ball.getW(), ball.getH());
		
		Color b2 = Color.red;
		b.setColor(b2);
		b.fillRect(bat.getX(),bat.getY(), bat.getW(), bat.getH());
	}

	/**
	 *  Update it to the screen
	 */
	public void drawScreen() {
		Graphics2D g = (Graphics2D) this.getGraphics();
		g.drawImage(buffer, 0, 0, this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	
	// key listeners for bat
	@Override
	public void keyPressed(KeyEvent ewt) {
		if (ewt.getKeyCode() == 37){
			isleft = true;	
		}
		if (ewt.getKeyCode() == 39){
			isRight = true;	
		}
	}

	@Override
	public void keyReleased(KeyEvent ewt) {
		if (ewt.getKeyCode() == 37){
			isleft = false;	
		}
		if (ewt.getKeyCode() == 39){
			isRight = false;	
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void collision(){
		if ((ball.getY()== bat.getY()) && (bat.getX()) <=ball.getX() && ball.getX() <= (bat.getX()+ bat.getW())){
			ball.ballCollide();
			
		}
		
		if ((ball.getY()== 560 + bat.getH()) && (bat.getX()) <=ball.getX() && ball.getX() <= (bat.getX()+ bat.getW()) ){
			ball.ballCollide();
			
		}
		
		
	}

}
