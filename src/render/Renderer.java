package render;

import java.awt.Graphics;
import java.util.ArrayList;

public class Renderer {
	private Graphics graphics;
	private Boolean shouldRender;
	private ArrayList<RenderObject> renderList;
	public Renderer(Graphics g) {
		graphics = g;
		shouldRender = true;
		renderList = new ArrayList<RenderObject>(0);
		while(shouldRender)
		{
			for(int i = 0;i<renderList.size();i++)
			{
				render(renderList.get(i));
			}
		}
	}
	public void render(RenderObject rO)
	{
		
	}
	public void addToRenderList(RenderObject rO)
	{
		renderList.add(rO);
	}
	public void stopRenderer()
	{
		shouldRender = false;
	}
}
