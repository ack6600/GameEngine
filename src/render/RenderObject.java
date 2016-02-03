package render;

import java.awt.image.BufferedImage;
import java.io.IOException;

import world.Entity;
import world.Tile;

public class RenderObject {
	private int width;
	private int height;
	private BufferedImage renderObjectTexture;
	private int posX;
	private int posY;
	public RenderObject(Tile t) throws IOException {
		// TODO Auto-generated constructor stub
		width = RenderConstants.TILE_WIDTH;
		height = RenderConstants.TILE_HEIGHT;
		renderObjectTexture = (new TextureManager(RenderConstants.TILE_FILE_PATH).getTexture());
		posX = t.posX;
		posY = t.posY;
	}

	public RenderObject(Entity e) throws IOException {
		// TODO Auto-generated constructor stub
		width = RenderConstants.ENTITY_WIDTH;
		height = RenderConstants.ENTITY_HEIGHT;
		renderObjectTexture = (new TextureManager(RenderConstants.ENTITY_FILE_PATH).getTexture());
		posX = e.posX;
		posY = e.posY;
	}
	public RenderObject()
	{
		//for testing
		width = 10;
		height = 10;
//		renderObjectTexture = Color.BLACK;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public BufferedImage getColor() {
		return renderObjectTexture;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
