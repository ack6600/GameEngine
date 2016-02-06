package render;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class AnimatedRenderObject extends RenderObject{
	private BufferedImage[] frames;
	private int frameOn;
	private int maxFrame;
	public AnimatedRenderObject(int x, int y, String[] filePaths) throws IOException 
	{
		super(x, y);
		frames = new BufferedImage[filePaths.length];
		for(int i = 0;i<filePaths.length;i++)
		{
			frames[i] = (new TextureManager(filePaths[i])).getTexture();
		}
		frameOn = 0;
		maxFrame = frames.length;
	}

	@Override
	public BufferedImage getBufferedImage() 
	{
		
		if(frameOn<maxFrame)
		{
			frameOn++;
			return frames[frameOn-1];
		}
		else
		{
			frameOn = 0;
			return frames[frameOn];
		}
	}

}
