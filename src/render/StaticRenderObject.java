package render;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class StaticRenderObject extends RenderObject{
	private BufferedImage renderObjectTexture;
	public StaticRenderObject(String texturePath, int x, int y) throws IOException {
		super(x, y);
		renderObjectTexture = (new TextureManager(texturePath)).getTexture();
	}

	@Override
	public BufferedImage getBufferedImage() {
		// TODO Auto-generated method stub
		return this.renderObjectTexture;
	}

}
