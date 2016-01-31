package world;

import java.util.ArrayList;

public class World {
	private ArrayList<Entity> entityList;
	private ArrayList<Tile> tileList;
	public World()
	{
		entityList = new ArrayList<Entity>(0);
		tileList = new ArrayList<Tile>(0);
	}
	public void addEntity(Entity e)
	{
		entityList.add(e);
	}
	public void addTile(Tile t)
	{
		tileList.add(t);
	}

}
