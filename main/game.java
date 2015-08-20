package Main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import GameStates.DifferentStates;
import GameStates.StatesManager;


//as game starts, it runs the thread which then proceeds to the run method.
public class Game extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	public final int Width=800, Height=600;
	
	private BufferedImage image;
	private Graphics2D g;
	private boolean isRunning=false;
	private final long DesireOneFrameNanoSecond=1000000000/60; // one frame takes 16000000 nanosec.
	Thread gameThread=new Thread(this);
	
	StatesManager sm;
	DifferentStates state;
	
	public Game(){
		setContentPane(new Window());
		setSize(Width,Height);
		setTitle("LASTPROJECT");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	
	//==================================GameThread======================================//
	public synchronized void gameStart(){isRunning=true;gameThread.start(); }
	public synchronized void gameEnd(){isRunning=false;}
	public void run() {
		init();
		long startingTime;
		long SystemOneFrameNanoSecond;
		long DelayTimeInMilliSeconds;
		while(isRunning){/*-----sets up variable timestep, carries out update(), render()----*/
			startingTime=System.nanoTime();
			
			sm= new StatesManager(state);
			
			
			SystemOneFrameNanoSecond=System.nanoTime()-startingTime;
			DelayTimeInMilliSeconds=(DesireOneFrameNanoSecond-SystemOneFrameNanoSecond)/1000000;//difference of one frame time in nanoseconds convert to milliseconds 
			if(DelayTimeInMilliSeconds<10)DelayTimeInMilliSeconds=10;//set minimum delay time
			try{Thread.sleep(DelayTimeInMilliSeconds);}catch(InterruptedException ex){System.out.println("Thread time error");}
			
		}
	}
	
	//==================================GameComponent=======================================//
	public void init(){
	
	}
	public void update(){}
	public void render(){}
	
	
	//================================Main===================================================//
	
	public static void main(String[] args){
		new Game().gameStart(); //run game thread
		//musicthread.start(); //run music thread
		//renderthread.start(); //run render thread
	}
}
