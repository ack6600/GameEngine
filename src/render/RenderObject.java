package render;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class RenderObject {
	private BufferedImage renderObjectTexture;
	private int posX;
	private int posY;
	public RenderObject(String texturePath, int x, int y) throws IOException
	{
		renderObjectTexture = (new TextureManager(texturePath)).getTexture();
		posX = x;
		posY = y;
	}	
	public BufferedImage getBufferedImage() {
		return renderObjectTexture;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
