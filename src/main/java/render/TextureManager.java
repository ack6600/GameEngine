package render;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureManager {
	private BufferedImage bImage;
	public TextureManager(String filePath) throws IOException
	{
		File f = new File(filePath);
		bImage = ImageIO.read(f);
	}
	public BufferedImage getTexture()
	{
		return bImage;
	}

}
