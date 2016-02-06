package render;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class AnimatedRenderObject extends RenderObject{
	private BufferedImage[] frames;
	private int delay;
	private AnimationManager manager;
	public AnimatedRenderObject(int x, int y, String[] filePaths, int delay) throws IOException 
	{
		super(x, y);
		frames = new BufferedImage[filePaths.length];
		for(int i = 0;i<filePaths.length;i++)
		{
			frames[i] = (new TextureManager(filePaths[i])).getTexture();
		}
		manager = new AnimationManager(delay, frames);
		Thread managerThread = new Thread(manager);
		managerThread.start();
		this.delay = delay;
	}
	public int getDelay()
	{
		return delay;
	}
	@Override
	public BufferedImage getBufferedImage() 
	{
		return manager.getFrameOn();
	}

}
