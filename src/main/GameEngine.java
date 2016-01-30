package main;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import render.RenderObject;
import render.Renderer;
import world.Entity;
import world.Tile;

public class GameEngine {
	private Graphics graphics;
	private ArrayList<Entity> entityList;
	private ArrayList<Tile> tileList;
	private Renderer renderer;
	public GameEngine(Graphics g)
	{
		graphics = g;
		entityList = new ArrayList<Entity>(0);
		tileList = new ArrayList<Tile>(0);
		renderer = new Renderer(g);
	}
	public static void main(String args [])
	{
		GameEngine g = new GameEngine(new JPanel().getGraphics());
		g.addEntity();
		g.addTile();
	}
	public Entity addEntity()
	{
		Entity e = new Entity(this);
		renderer.addToRenderList(new RenderObject(e));
		entityList.add(e);
		return e;
	}
	public Tile addTile()
	{
		Tile t = new Tile(this);
		renderer.addToRenderList(new RenderObject(t));
		tileList.add(t);
		return t;
	}
	public Graphics getGraphics()
	{
		return graphics;
	}
	public ArrayList<Entity> getEntities()
	{
		return entityList;
	}
	public ArrayList<Tile> getTiles()
	{
		return tileList;
	}

}
