package TileMap;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Main.Game;

public class Background {
	BufferedImage image;
	public Background(String path){
		try{image=ImageIO.read(getClass().getResourceAsStream(path));
		
		}catch(Exception e){e.printStackTrace();System.out.println("loading image error");}
		
	
		
	}

public void draw(Graphics g){
		g.drawImage(image,0,0,Game.WIDTH,Game.HEIGHT,null);
}
}
