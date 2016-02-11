package render;

import java.awt.image.BufferedImage;

public class AnimationManager implements Runnable{
	private BufferedImage[] frames;
	private int delay;
	private int frameOn;
	public AnimationManager(int delay,BufferedImage[] textures)
	{
		frames = textures;
		this.delay = delay;
		frameOn = 0;
	}
	public BufferedImage getFrameOn()
	{
		return frames[frameOn];
	}
	@Override
	public void run() {
		while(true)
		{
		if(frameOn<frames.length-1)
		{
			frameOn++;
		}
		else
		{
			frameOn = 0;
		}
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
