package render;

import java.awt.Color;

import world.Entity;
import world.Tile;

public class RenderObject {
	private int width;
	private int height;
	private Color color;
	public RenderObject(Tile t) {
		// TODO Auto-generated constructor stub
		width = RenderConstants.TILE_WIDTH;
		height = RenderConstants.TILE_HEIGHT;
		color = RenderConstants.TILE_COLOR;
	}

	public RenderObject(Entity e) {
		// TODO Auto-generated constructor stub
		width = RenderConstants.ENTITY_WIDTH;
		height = RenderConstants.ENTITY_HEIGHT;
		color = RenderConstants.ENTITY_COLOR;
	}
	public RenderObject()
	{
		//for testing
		width = 10;
		height = 10;
		color = Color.BLACK;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Color getColor() {
		return color;
	}

}
