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
	private long frameRate;
	private long lastTime = System.currentTimeMillis();
	private JPanel panel;
	
	public Renderer(JPanel j) throws IOException {
		graphics = j.getGraphics();
		graphics.setPaintMode();
		panel = j;
		renderList = new ArrayList<RenderObject>(0);
		refreshTimer = new Timer(1000/RenderConstants.REFRESH_RATE,this);
		refreshTimer.start();
	}
	public void render(RenderObject rO)
	{
		graphics.drawImage(rO.getColor(),rO.getPosX(),rO.getPosY(),null);
	}
	public void renderFrameRate()
	{
		graphics.drawString(Long.toString(frameRate), 0, 12);
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
		
		frameRate = 1000/(System.currentTimeMillis() - lastTime);
		lastTime = System.currentTimeMillis();
		renderFrameRate();
	}

}
