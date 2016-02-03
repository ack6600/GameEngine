package main;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import render.RenderConstants;
import render.RenderObject;
import render.Renderer;

public class GameEngine {
	private Graphics graphics;
	private Renderer renderer;
	private static JFrame jf;
	public GameEngine(JPanel j,int refreshRate) throws IOException
	{
		graphics = j.getGraphics();
		renderer = new Renderer(j,refreshRate);
	}
	public static void main(String args []) throws IOException
	{
		JPanel j = new JPanel();
		j.setSize(300, 300);
		jf = new JFrame();
		jf.setSize(300, 300);
		jf.add(j);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		GameEngine g = new GameEngine(j,RenderConstants.REFRESH_RATE);
		g.addObject(new RenderObject(RenderConstants.ENTITY_FILE_PATH,0,0));
		System.out.println("added in engine");
	}
	public Graphics getGraphics()
	{
		return graphics;
	}
	public void addObject(RenderObject r)
	{		
		renderer.addToRenderList(r);
	}
	public void close()
	{
		jf.dispose();
	}

}
