package render;

import java.awt.Graphics;
import java.util.ArrayList;

public class Renderer {
	private Graphics graphics;
	private Boolean shouldRender;
	private ArrayList<RenderObject> renderList;
	public Renderer(Graphics g) {
		graphics = g;
		shouldRender = false;
		renderList = new ArrayList<RenderObject>(0);
		renderList.add(new RenderObject());
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
	public void main()
	{
		System.out.println("hello");
		while(shouldRender)
		{
			for(int i = 0;i<renderList.size();i++)
			{
				render(renderList.get(i));
			}
		}
	}
	public void stopRenderer()
	{
		shouldRender = false;
	}
	public void start()
	{
		shouldRender = true;
		this.main();
	}
}
