package main;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import render.RenderObject;
import render.Renderer;
import world.Entity;
import world.Tile;
import world.World;

public class GameEngine {
	private Graphics graphics;
	private Renderer renderer;
	private World world;
	public GameEngine(JPanel j) throws IOException
	{
		graphics = j.getGraphics();
		world = new World();
		renderer = new Renderer(j);
	}
	public static void main(String args []) throws IOException
	{
		JPanel j = new JPanel();
		j.setSize(300, 300);
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		jf.add(j);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		GameEngine g = new GameEngine(j);
		System.out.println("added in engine");
		g.addEntity(50,50);
		g.addTile(30,30);
	}
	public Entity addEntity(int x, int y) throws IOException
	{
		System.out.println("added in engine");
		Entity e = new Entity(this, x, y);
		renderer.addToRenderList(new RenderObject(e));
		world.addEntity(e);
		return e;
	}
	public Tile addTile(int x, int y) throws IOException
	{
		System.out.println("added in engine");
		Tile t = new Tile(this, x, y );
		renderer.addToRenderList(new RenderObject(t));
		world.addTile(t);
		return t;
	}
	public Graphics getGraphics()
	{
		return graphics;
	}

}
