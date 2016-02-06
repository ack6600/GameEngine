package render;

import java.awt.image.BufferedImage;

public abstract class RenderObject {
	private int posX;
	private int posY;
	public RenderObject(int x, int y)
	{
		posX = x;
		posY = y;
	}	
	public abstract BufferedImage getBufferedImage();

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
