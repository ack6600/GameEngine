package render;

import java.awt.Graphics;
import java.util.ArrayList;

public class Renderer implements Runnable{
	private Graphics graphics;
	private Boolean shouldRender;
	private ArrayList<RenderObject> renderList;
	public Renderer(Graphics g) {
		graphics = g;
		shouldRender = true;
		renderList = new ArrayList<RenderObject>(0);
	}
	public void render(RenderObject rO)
	{
		graphics.setColor(rO.getColor());
		graphics.fillRect(0, 0, rO.getWidth(), rO.getHeight());
	}
	public void addToRenderList(RenderObject rO)
	{
		renderList.add(rO);
		System.out.println("object added");
	}
	public void stopRenderer()
	{
		shouldRender = false;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(shouldRender)
		{
			for(int i = 0;i<renderList.size();i++)
			{
				render(renderList.get(i));
			}
		}
		
	}
}
