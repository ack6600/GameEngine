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
		renderList.add(new RenderObject());
		main();
	}
	public void render(RenderObject rO)
	{
		graphics.setColor(rO.getColor());
		graphics.fillRect(0, 0, rO.getWidth(), rO.getHeight());
	}
	public void addToRenderList(RenderObject rO)
	{
		renderList.add(rO);
	}
	public void main()
	{
		System.out.println("hello");
		while(shouldRender)
		{
			for(int i = 0;i<renderList.size();i++)
			{
				render(renderList.get(i));
				System.out.println(i);
			}
		}
	}
	public void stopRenderer()
	{
		shouldRender = false;
	}
}
