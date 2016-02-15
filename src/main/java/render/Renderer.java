package render;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;

import geometry.BasicShape;
import main.RenderEngine;
//import javax.swing.Timer;

public class Renderer implements Runnable{
	private Graphics graphics;
	private ArrayList<RenderObject> complexRenderList;
	private long frameRate;
	private long lastTime =  System.currentTimeMillis();
	private JPanel panel;
	private int[] lastFrameRates = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private int average;
	private int steadyRate;
	private int frameOn;
	private long lastTime2;
	private long delay;
	private int refreshRate;
//	private long lastNanoTime;
//	private long nanoDelay;
//	private long realNanoDelay;
	private boolean calculate = false;
	public Renderer(JPanel j,int refreshRate,int startDelay) throws IOException {
		graphics = j.getGraphics();
		graphics.setPaintMode();
		panel = j;
		this.refreshRate = refreshRate;
		complexRenderList = new ArrayList<RenderObject>(0);
		frameOn = 0;
//		nanoDelay = 0;
		delay = startDelay;
		lastTime2 = System.currentTimeMillis();
	}
	public void render(RenderObject rO)
	{
		graphics.drawImage(rO.getBufferedImage(),rO.getPosX(),rO.getPosY(),null);
	}
	public void renderFrameRate()
	{
		graphics.drawString(Integer.toString(steadyRate), 0, 12);
	}
	public void addToRenderList(RenderObject rO)
	{
		complexRenderList.add(rO);
		RenderEngine.log("object added to renderlist");
	}
	public void addBasicToRenderList(BasicShape basicShape)
	{

	}
	public int calculateFrameRate(int fRate)
	{
//		RenderEngine.log(fRate);
		for(int i = 0; i<lastFrameRates.length-1; i++)
		{
		lastFrameRates[i] = lastFrameRates[i+1];
		}
		lastFrameRates[lastFrameRates.length-1] = fRate;
		average = 0;
		for(int i = 0; i<lastFrameRates.length; i++)
		{
			average = average + lastFrameRates[i];
		}
		
		return average/lastFrameRates.length;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
//		if(calculate)
//		{
//			nanoDelay = 1000000000-(System.nanoTime() - lastNanoTime);
//			delay = 0;
//			while(nanoDelay>999999)
//			{
//				delay++;
//				nanoDelay = nanoDelay - 1000000;
//				RenderEngine.log("delay " + nanoDelay);
//			}
//			delay = delay/RenderConstants.REFRESH_RATE;
//			nanoDelay = nanoDelay/RenderConstants.REFRESH_RATE;
//			RenderEngine.log("uncompensated nano delay " + (System.nanoTime()-lastNanoTime));
//			RenderEngine.log("nano delay "+nanoDelay);
//			RenderEngine.log("compensatedDelay "+ delay);
//			RenderEngine.log("nano reading " + System.nanoTime());
//			RenderEngine.log("last time " + lastNanoTime);
//			RenderEngine.log("frame rate "+frameRate);
//			calculate = false;
//		}

		while(frameOn<refreshRate)
		{
		steadyRate = calculateFrameRate((int) frameRate);
		panel.update(graphics);
		for(int i = 0; i< complexRenderList.size(); i++)
		{
			render(complexRenderList.get(i));
		}
		renderFrameRate();
		try
		{
		frameRate =  1000/((System.currentTimeMillis() - lastTime));
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
		}
		lastTime = System.currentTimeMillis();
		frameOn++;
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
		if(calculate)
		{
		if(System.currentTimeMillis()-lastTime2<=1000)
			{
				delay = calculateDelay((System.currentTimeMillis()-lastTime2));
				calculate = false;
				RenderEngine.log("delay "+((System.currentTimeMillis()-lastTime2)));
				RenderEngine.log("compensatedDelay "+ delay);
			}
			else
			{
				delay--;
				calculate = false;
				RenderEngine.log("delay "+((int) (System.currentTimeMillis()-lastTime2)));
				RenderEngine.log("compensatedDelay "+ delay);
			}
		}
		if((System.currentTimeMillis()-lastTime2)>=1000)
		{
			
			RenderEngine.log("Frames " + frameOn);
			lastTime2 = System.currentTimeMillis();
			frameOn = 0;
			calculate = true;
			//nano
//			lastNanoTime = System.nanoTime();
		}
		}
	}
	public long calculateDelay(long extraTime)
	{
		return extraTime/refreshRate;
	}

}
