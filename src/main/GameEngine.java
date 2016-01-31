package main;

import java.awt.Graphics;

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
	public GameEngine(Graphics g)
	{
		graphics = g;
		world = new World();
		renderer = new Renderer(g);
	}
	public static void main(String args [])
	{
		JPanel j = new JPanel();
		j.setSize(300, 300);
		JFrame jf = new JFrame();
		jf.setSize(300, 300);
		jf.add(j);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		GameEngine g = new GameEngine(j.getGraphics());
		g.addEntity();
		g.addTile();
	}
	public Entity addEntity()
	{
		Entity e = new Entity(this);
		renderer.addToRenderList(new RenderObject(e));
		world.addEntity(e);
		return e;
	}
	public Tile addTile()
	{
		Tile t = new Tile(this);
		renderer.addToRenderList(new RenderObject(t));
		world.addTile(t);
		return t;
	}
	public Graphics getGraphics()
	{
		return graphics;
	}

}
