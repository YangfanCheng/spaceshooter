package Audio;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javazoom.jl.player.Player;
public class MP3Player{
	private String filename;
	private Player player;
	
	public MP3Player(String filename){
		this.filename=filename;
	}
	
	public void close(){if (player!=null)player.close();}
	
	public void play(){
		try{InputStream fis=this.getClass().getResourceAsStream(filename);//jar archive
		BufferedInputStream bis=new BufferedInputStream(fis);
		player=new Player(bis);
		}catch(Exception e){System.out.println("problem playing file "+filename);
		System.out.println(e);}
	
	
	new Thread(){
		public void run(){
			try{player.play();}
			catch(Exception e){System.out.println("thread error");}
		}
		}.start();
		
		
	
	}
}
