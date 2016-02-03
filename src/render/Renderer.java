package render;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Renderer implements ActionListener{
	private Graphics graphics;
	private ArrayList<RenderObject> renderList;
	private Timer refreshTimer;
	public long frameRate;
	private long lastTime = System.currentTimeMillis();
	private JPanel panel;
	private long[] lastFrameRates = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private long average;
	private long steadyRate;
	
	public Renderer(JPanel j,int refreshRate) throws IOException {
		graphics = j.getGraphics();
		graphics.setPaintMode();
		panel = j;
		renderList = new ArrayList<RenderObject>(0);
		refreshTimer = new Timer(1000/refreshRate,this);
		refreshTimer.start();
		Runnable r = new Runnable()
				{

					@Override
					public void run() {
						// TODO Auto-generated method stub
						while(true)
						{
						steadyRate = calculateFrameRate();
						}
					}
			
				};
		Thread frameRateThread = new Thread(r);
		frameRateThread.start();
	}
	public void render(RenderObject rO)
	{
		graphics.drawImage(rO.getBufferedImage(),rO.getPosX(),rO.getPosY(),null);
	}
	public void renderFrameRate()
	{
		graphics.drawString(Long.toString(steadyRate), 0, 12);
	}
	public void addToRenderList(RenderObject rO)
	{
		renderList.add(rO);
		System.out.println("object added");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		panel.update(graphics);
		for(int i = 0;i<renderList.size();i++)
		{
			render(renderList.get(i));
		}
		renderFrameRate();
		frameRate = 1000/(System.currentTimeMillis() - lastTime);
		lastTime = System.currentTimeMillis();
	}
	public long calculateFrameRate()
	{
		
		for(int i = 0; i<lastFrameRates.length-1; i++)
		{
		lastFrameRates[i] = lastFrameRates[i+1];
		}
		lastFrameRates[lastFrameRates.length-1] = frameRate;
		average = 0;
		for(int i = 0; i<lastFrameRates.length; i++)
		{
			average = average + lastFrameRates[i];
		}
		return average/lastFrameRates.length;
	}

}
