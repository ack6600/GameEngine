package main;

import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import render.AnimatedRenderObject;
import render.RenderConstants;
import render.RenderObject;
import render.Renderer;
import render.StaticRenderObject;

public class GameEngine {
	private Graphics graphics;
	private Renderer renderer;
	private static JFrame jf;
	private static BufferedWriter bFR;
	private static File file = new File("output.txt");
	public GameEngine(JPanel j,int refreshRate,File logfile) throws IOException
	{
		graphics = j.getGraphics();
		renderer = new Renderer(j,refreshRate,RenderConstants.guessDelay);
		Thread t = new Thread(renderer);
		bFR = new BufferedWriter(new FileWriter(logfile));
		t.start();
		GameEngine.log("Engine started");
	}
//	public static void main(String args[]) throws IOException
//	{
//		JPanel j = new JPanel();
//		j.setSize(300, 300);
//		jf = new JFrame();
//		jf.setSize(300, 300);
//		jf.add(j);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jf.setVisible(true);
//		GameEngine g = new GameEngine(j,RenderConstants.REFRESH_RATE, file);
////		g.addObject(new StaticRenderObject(RenderConstants.ENTITY_FILE_PATH,0,0));
//		String[] textureLocations = {"src/render/floor.png","src/render/entity.png"};
//		g.addObject(new AnimatedRenderObject(40, 40,textureLocations,300));
//		GameEngine.log("object added in engine");
//	}
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
	public static void log(String s)
	{
		try {
			bFR.write(s);
			bFR.newLine();;
			bFR.flush();
		} catch (IOException e) {
//			TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
